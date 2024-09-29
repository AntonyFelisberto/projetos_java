package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import MODEL.Disciplina;
import java.sql.Statement;
import java.sql.ResultSet;

public class DAODisciplina {
    public Connection conn;
    public PreparedStatement stmt;
    ArrayList<Disciplina>lista=new ArrayList<>();
    public Statement st;
    public ResultSet rs;
    
    public DAODisciplina(){
        conn=new Conexao().getConexao();
    }
    
    public void inserir(Disciplina dis){
        try{
            String sql="INSERT INTO tb_disciplina(nome_disciplina,cargahoraria_disciplina) VALUES(?,?)";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,dis.getDisciplina());
            stmt.setInt(2,dis.getCarga());
            stmt.execute();
            stmt.close();
        }catch(Exception erro){
            throw new RuntimeException("erro ao fazer a inserção de dados:",erro);
        }
    }
    
    public void remover(int dado){
        try{
            String sql="DELETE FROM tb_disciplina WHERE id_disciplina="+dado;
            st=conn.createStatement();
            st.execute(sql);
            st.close();
        }catch(Exception erro){
            throw new RuntimeException("erro ao remover os dados:",erro);
        }
    }
    public void atualizar(Disciplina dis){
        try{
            String sql="UPDATE tb_disciplina SET nome_disciplina=?,cargahoraria_disciplina=? WHERE id_disciplina=?";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,dis.getDisciplina());
            stmt.setInt(2,dis.getCarga());
            stmt.setInt(3,dis.getId());
            stmt.execute();
            stmt.close();
        }catch(Exception erro){
            throw new RuntimeException("erro ao atualizar os dados:",erro);
        }
    }
   
    public ArrayList<Disciplina>listar(){
        try{
            String sql="SELECT * FROM tb_disciplina";
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                Disciplina dis=new Disciplina();
                dis.setId(rs.getInt("id_disciplina"));
                dis.setDisciplina(rs.getString("nome_disciplina"));
                dis.setCarga(rs.getInt("cargahoraria_disciplina"));
                lista.add(dis);
            }
        }catch(Exception erro){
            throw new RuntimeException("erro ao listar os dados",erro);
        }
        return lista;
    }
 
    public ArrayList<Disciplina>listarP(String nome){
        try{
            String sql="SELECT * FROM tb_disciplina WHERE nome_disciplina LIKE '%"+nome+"%'";
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                Disciplina dis=new Disciplina();
                dis.setId(rs.getInt("id_disciplina"));
                dis.setDisciplina(rs.getString("nome_disciplina"));
                dis.setCarga(rs.getInt("cargahoraria_disciplina"));
                lista.add(dis);
            }
        }catch(Exception erro){
            throw new RuntimeException("erro ao procurar dados:",erro);
        }
       return lista;
    }
     
}
