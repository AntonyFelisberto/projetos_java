package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexao{
   public Connection conectar(){
       try{
           Class.forName("org.apache.derby.jdbc.ClientDriver");
           return DriverManager.getConnection("jdbc:derby://localhost/ProjectAep","projetoAEP","gerenciado@1906");

       }catch(Exception erro){
           throw new RuntimeException("erro ao conectar com o banco de dados :",erro);
       }
   }    
}
