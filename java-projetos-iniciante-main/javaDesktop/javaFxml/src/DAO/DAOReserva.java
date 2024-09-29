package DAO;
import java.sql.Connection;
import java.util.ArrayList;
import BASE.Filmes;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import MODEL.Reserva;


public class DAOReserva {
    
    public ResultSet rest;
    public PreparedStatement prepare;
    public Statement estado;
    ArrayList<Filmes>listar=new ArrayList<>();
    public Connection conec;
    public DAOReserva(){
        conec=new Conexao().Conectar();
    }
    public boolean inserir(Reserva dados,int id,String tabelaFilme){
        boolean result;
        try{
            String verificar="SELECT * FROM "+tabelaFilme+" WHERE  STATUS='A' and id="+id;
            estado=conec.createStatement();
            rest=estado.executeQuery(verificar);
            if(rest.next()){
               //verifica se a condição sql existe//no if a condição existe no else não 
                String sql="INSERT INTO reserva(nomeFilme,tipoIngresso,cpf) VALUES(?,?,?)";
                prepare=conec.prepareStatement(sql);
                prepare.setString(1, dados.getNomeFilme());
                prepare.setString(2, dados.getTipoIngresso());
                prepare.setString(3, dados.getCpf());
                prepare.execute();
                prepare.close();
                String cpf=dados.getCpf();
                String atualizar= "UPDATE "+tabelaFilme+" SET STATUS ='D',cpf = '"+cpf+"' WHERE STATUS='A' and id="+id; 
                                        //nome de tabelas não precisam das '' //quando for concatenar variaveis do tipo char ou varchar você abre aspas simple depois aspas duplas coloca os dois mais e fecha a aspas simples e duplas '"+nomevar+' servindo para where,update,insert,delete
                estado=conec.createStatement();
                estado.execute(atualizar);
                estado.close();
                result=true;
            }else{
                result=false;
            }
        }catch(Exception erro){
            throw new RuntimeException("erro ao inserir dados:"+erro.getMessage());
        }
       return result;
    }
   
    
}
