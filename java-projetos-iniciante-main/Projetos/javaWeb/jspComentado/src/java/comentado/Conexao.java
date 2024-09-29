package DAO;
import java.sql.Connection;//pra utilizar recursos da conexao
import java.sql.DriverManager;//gerencia os drives de banco

public class Conexao {
    public Connection getConexao(){
     try{
       Class.forName("org.apache.derby.jdbc.ClientDriver");//é onde busca o drive,é obrigatório para funcionar(org.nomedoseuservidor.nomedobanco.jdbc.ClientDriver)
       return DriverManager.getConnection("jdbc:derby://localhost/bdTreino","root","123");//é o caminho da sua conexão,usuario,senha
                                                                   //bdTreino é o nome da sua criação do java db
     }catch(Exception erro){
        throw new RuntimeException("ouve um erro de conexao",erro);
     }
    }
    
}
