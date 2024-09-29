package DAO;
import MODEL.Professor;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class DAOProfessor{
    public Connection conn;
    ArrayList<Professor>lista=new ArrayList<>();
    public PreparedStatement stmt;
    public Statement st;
    public ResultSet rs;
    
    public DAOProfessor(){
        conn=new Conexao().getConexao();
    }
    
    public void inserir(Professor prof){
        try{
            String sql="INSERT INTO tb_professor(nome_professor,email_professor,senha_professor)  VALUES(?,?,?)"; 
            stmt=conn.prepareStatement(sql);
            stmt.setString(1, prof.getNome());
            stmt.setString(2, prof.getEmail());
            stmt.setString(3, prof.getSenha());
            stmt.execute();
            stmt.close();
        }catch(Exception erro){
            throw new RuntimeException("erro ao fazer a inserção de dados:",erro);
        }
    }

    public void deletar(int iden){
        try{
            String sql="DELETE FROM tb_professor WHERE id_professor="+iden;
            st=conn.createStatement();
            st.execute(sql);
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro ao tentar deletar dados:",erro);
        }
    }
    
    public void atualizar(Professor prof){
        try{
            String sql="UPDATE tb_professor set nome_professor=?,email_professor=?,senha_professor=? where id_professor=?";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,prof.getNome());
            stmt.setString(2,prof.getEmail());
            stmt.setString(3,prof.getSenha());
            stmt.setInt(4,prof.getId());
            stmt.execute();
            stmt.close();
        }catch(Exception erro){
            throw new RuntimeException("erro ao atualizar os dados:",erro);
        }
    }
    
    public ArrayList<Professor>listar(){
        try{
            String sql="SELECT * FROM tb_professor";
            Professor prof=new Professor();
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                prof.setId(rs.getInt("id_professor"));
                prof.setNome(rs.getString("nome_professor"));
                prof.setEmail(rs.getString("email_professor"));
                prof.setSenha(rs.getString("senha_professor"));
                lista.add(prof);
            }
        }catch(Exception erro){
            throw new RuntimeException("erro ao fazer a listagem dos dados",erro);
        }
        return lista;
    }
    
    public ArrayList<Professor>listarP(String search){
        try{
            String sql="SELECT * FROM tb_professor WHERE nome_professor LIKE '%"+search+"%'";
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                Professor prof=new Professor();
                prof.setId(rs.getInt("id_professor"));
                prof.setNome(rs.getString("nome_professor"));
                prof.setEmail(rs.getString("email_professor"));
                prof.setSenha(rs.getString("senha_professor"));
                lista.add(prof);
            }
        }catch(Exception erro){
            throw new RuntimeException("erro ao listar dados de procura:",erro);
        }
       return lista;
    }
}
