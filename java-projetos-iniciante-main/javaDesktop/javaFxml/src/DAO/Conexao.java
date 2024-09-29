package DAO;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
  public Connection Conectar(){
      try{
          Class.forName("org.apache.derby.jdbc.ClientDriver");
          return DriverManager.getConnection("jdbc:derby://localhost/CineReserva","root","123");
          //Class.forName("com.mysql.jdbc.Driver");
          //return DriverManager.getConnection("jdbc:mysql://localhost/CineReserva","root","");
      }catch(Exception erro){
          throw new RuntimeException("erro ao conectar com o banco de dados",erro);
      }
  }    
}
