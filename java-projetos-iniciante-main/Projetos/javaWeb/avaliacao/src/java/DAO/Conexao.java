package DAO;
import java.sql.DriverManager;
import java.sql.Connection;

public class Conexao {
    public Connection getConexao(){
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            return DriverManager.getConnection("jdbc:derby://localhost/BDAvaliacao","root","123");
        }catch(Exception erro){
            throw new RuntimeException("erro ao fazer a conexao com o banco de dados",erro);
        }
    }
}
