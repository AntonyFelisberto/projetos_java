package DAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import MODEL.Dados;

public class Metodos {
     public Connection conectar;
     public ResultSet resultar;
     public PreparedStatement preparar;
     public Statement estato;
     ArrayList<Dados>listar=new ArrayList<>();
    public Metodos(){
     conectar=new Conexao().Conectar();
    }
    
    public boolean inserir(Dados dados){
        boolean validação=false;
        try{
          String sql="SELECT * FROM usuario  WHERE cpf=? and status='A'";
          preparar=conectar.prepareStatement(sql);
          preparar.setString(1, dados.getCpf());
          resultar=preparar.executeQuery();
          if(resultar.next()){
              return validação;
          }else{
              String registrar="INSERT INTO usuario(nome,senha,email,cpf,telefone,status) VALUES(?,?,?,?,?,'A')";
              preparar=conectar.prepareStatement(registrar);
              preparar.setString(1, dados.getNome());
              preparar.setString(2, dados.getSenha());
              preparar.setString(3, dados.getEmail());
              preparar.setString(4, dados.getCpf());
              preparar.setString(5, dados.getTelefone());
              preparar.execute();
              preparar.close();
              validação=true;
              return validação;
          }
        }catch(Exception erro){
          throw new RuntimeException("erro ao inserir dados",erro);  
        }
    }
    
    public void atualizar(Dados dados){
        try{
            String sql="UPDATE usuario SET nome=?,senha=?,email=?,telefone=? WHERE cpf=? and status='A'";
            preparar=conectar.prepareStatement(sql);
            preparar.setString(1, dados.getNome());
            preparar.setString(2, dados.getSenha());
            preparar.setString(3, dados.getEmail());
            preparar.setString(4, dados.getTelefone());
            preparar.setString(5,dados.getCpf());
            preparar.execute();
            preparar.close();
        }catch(Exception erro){
            throw new RuntimeException("erro ao executar login",erro);
        }        
    }
    
    public void deletar(String cpf){
        try{
            String sql="UPDATE usuarios SET status='D' WHERE cpf="+cpf+"and status='A'";
            estato=conectar.createStatement();
            estato.execute(sql);
            estato.close();
        }catch(Exception erro){
            throw new RuntimeException("erro ao fazer a desativação",erro);
        }
    }
    public void Reativar(String cpf){
        try{
            String sql="UPDATE usuarios SET status='A' WHERE cpf="+cpf+"and status='D'";
            estato=conectar.createStatement();
            estato.execute(sql);
            estato.close();
        }catch(Exception erro){
            throw new RuntimeException("erro ao fazer a reativação",erro);
        }
    }
    public boolean logar(Dados dados){
        try{
            String sql="SELECT * FROM usuario WHERE cpf=? and senha=? and status='A'";
            preparar=conectar.prepareStatement(sql);
            preparar.setString(1,dados.getCpf());
            preparar.setString(2, dados.getSenha());
            resultar=preparar.executeQuery();
            if(resultar.next()){
                return true;
            }else{
                return false;
            }
        }catch(Exception erro){
            throw new RuntimeException("erro ao logar ",erro);
        }
    }

}
