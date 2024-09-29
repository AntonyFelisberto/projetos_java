package DAO;
import java.sql.Connection;   //}necessarios para o banco de dados
import java.sql.DriverManager;//
//tem que colocar o mysql connector nas bibliotecas
public class Conexao {
    public Connection getConexao(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/uni_4semestre","root","");
                                                    //nomedobanco //caminho banco //usuario padrão //senha
                                                                  //caso ser diferente do padrão de porta localhost:3307(o 3307 você coloca sua porta)
                                                    
        }catch(Exception erro/*você pode nomear de qualquer coisa*/){
            throw new RuntimeException("erro"+erro/*o erro vai mostrar a mensagem de erro(ava não me diga)*/);
        }
    }
}
