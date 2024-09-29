
package BASE;
import DAO.Conexao;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class DAOFilmes {
    public ResultSet rest;
    public PreparedStatement prepare;
    public Statement estado;
    ArrayList<Filmes>listar=new ArrayList<>();
    public Connection conec;
    public DAOFilmes(){
        conec=new Conexao().Conectar();
    }
    public ArrayList<Filmes> listar(String nomeBanco){
        try{
            String sql="SELECT * FROM ? WHERE  STATUS='A'";
            prepare=conec.prepareStatement(sql);
            prepare.setString(1, nomeBanco);
            rest=prepare.executeQuery();
            while(rest.next()){
               Filmes filme = new Filmes();
               filme.setId(rest.getInt("id"));
               filme.setSTATUS(rest.getString("STATUS"));
               listar.add(filme);
               
            }
        }catch(Exception erro){
            throw new RuntimeException("erro ao listar dados"+erro);
        }
        return listar;
    }
    
}
