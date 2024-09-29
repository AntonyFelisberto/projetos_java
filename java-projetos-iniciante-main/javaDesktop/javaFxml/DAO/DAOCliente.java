package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import MODEL.Cliente;

public class DAOCliente {
    public ArrayList<Cliente>listar=new ArrayList<>();
    public ResultSet rest;
    public Statement state;
    public PreparedStatement prepare;
    public Connection conec;
    
    public DAOCliente(){
        conec=new Conexao().conectar();
    }
    
    public boolean inserir(Cliente dados){
        boolean result;
        try{
            String verificar="SELECT * FROM Usuario WHERE nome=? and senha=? and cpf=? and status='A'";
            prepare=conec.prepareStatement(verificar);
            prepare.setString(1, dados.getNome());
            prepare.setString(2, dados.getSenha());
            prepare.setString(3, dados.getCpf());
            rest=prepare.executeQuery();
            if(rest.next()){
                result=false;
            }else{
                String sql="INSERT INTO Usuario(nome,telefone,cpf,senha,endereço,status) VALUES(?,?,?,?,?,?)";
                prepare=conec.prepareStatement(sql);
                prepare.setString(1, dados.getNome());
                prepare.setString(2, dados.getTelefone());
                prepare.setString(3, dados.getCpf());
                prepare.setString(4, dados.getSenha());
                prepare.setString(5, dados.getEndereço());
                prepare.setString(6, "A");
                prepare.execute();
                prepare.close();
                result=true;
            }
        }catch(Exception erro){
            throw new RuntimeException("erro ao inserir dados:",erro);
        }
       return result;
    }
    
    public void atualizar(Cliente dados,String senha){
        try{
            String sql="UPDATE Usuario SET nome=?,telefone=?,senha="+senha+",endereço=?  WHERE cpf=? and senha=? and status='A'";
            prepare=conec.prepareStatement(sql);
            prepare.setString(1, dados.getNome());
            prepare.setString(2, dados.getTelefone());
            prepare.setString(4, dados.getEndereço());
            prepare.setString(5, dados.getCpf());
            prepare.setString(6, dados.getSenha());
            prepare.execute();
            prepare.close();
        }catch(Exception erro){
            throw new RuntimeException("erro ao inserir dados:",erro);
        }
    }
    
    public boolean inativar(Cliente dados){
        try{
            String banco="SELECT * FROM Usuario WHERE cpf=? and senha=? and status='A'";
            prepare=conec.prepareStatement(banco);
            prepare.setString(1, dados.getCpf());
            prepare.setString(2, dados.getSenha());
            rest=prepare.executeQuery();
            if(rest.next()){
                String sql="UPDATE Usuario SET status='D' WHERE cpf=? and senha=? and status='A'";
                prepare=conec.prepareStatement(sql);
                prepare.setString(1, dados.getCpf());
                prepare.setString(2, dados.getSenha());
                prepare.execute();
                prepare.close();
                return true;
            }else{
                return false;
            }
        }catch(Exception erro){
            throw new RuntimeException("erro ao inativar dados:",erro);
        }
    }
    public boolean reativar(Cliente dados){
        try{
            String banco="SELECT * FROM Usuario WHERE cpf=? and senha=? and status='D'";
            prepare=conec.prepareStatement(banco);
            prepare.setString(1, dados.getCpf());
            prepare.setString(2, dados.getSenha());
            rest=prepare.executeQuery();
            if(rest.next()){
                String sql="UPDATE Usuario SET status='A' WHERE cpf=? and senha=? and status='D'";
                prepare=conec.prepareStatement(sql);
                prepare.setString(1, dados.getCpf());
                prepare.setString(2, dados.getSenha());
                prepare.execute();
                prepare.close(); 
                return true;
            }else{
                 return false;
            }
        }catch(Exception erro){
            throw new RuntimeException("erro ao reativar dados:",erro);
        }
    }
    public ArrayList<Cliente> listar(Cliente dados){
        try{
            String sql="SELECT * FROM Usuario WHERE  cpf=? and senha=? and status='A'";
            prepare=conec.prepareStatement(sql);
            prepare.setString(1, dados.getCpf());
            prepare.setString(2, dados.getSenha());
            rest=prepare.executeQuery();
            while(rest.next()){
               Cliente cliente=new Cliente();
               cliente.setCpf(rest.getString("cpf"));
               cliente.setEndereço(rest.getString("endereço"));
               cliente.setNome(rest.getString("nome"));
               cliente.setSenha(rest.getString("senha"));
               cliente.setTelefone(rest.getString("telefone"));
               listar.add(cliente);
            }
        }catch(Exception erro){
            throw new RuntimeException("erro ao listar dados"+erro);
        }
        return listar;
    }
    
    public boolean login(Cliente dados){
        boolean dado=false;
        try{
            String sql="SELECT * FROM Usuario WHERE cpf=? and senha=? and status='A'";
            prepare=conec.prepareStatement(sql);
            prepare.setString(1, dados.getCpf());
            prepare.setString(2, dados.getSenha());
            rest=prepare.executeQuery();
            if(rest.next()){
                dado=true;
            }else{
                dado=false;
            }
        }catch(Exception erro){
             throw new RuntimeException("erro ao logar dados",erro);
        }
       return dado;
    }
    
}
