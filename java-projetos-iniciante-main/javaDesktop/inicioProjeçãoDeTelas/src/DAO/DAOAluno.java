package DAO;
import MODEL.Aluno;//}importa os pacotes que você criou para usar na inserção para o banco
import java.sql.Connection;       //
import java.sql.PreparedStatement;//}necessarios para o banco de dados
import java.sql.Statement;        //
        
public class DAOAluno {
    private Connection conn;         //}
    private PreparedStatement stmt;  //}necessarip primeiro importar a biblioteca de conexao pra usar 
    private Statement st;            //}
    
    //fazer conexao
    public DAOAluno(){
        conn=new Conexao().getConexao();//conectar na rede 
    } 
    
    //metodo de inserção 
    public void inserirAluno(Aluno/*classe*/ aluno /*nomeação*/){
        String sql="INSERT INTO tb_aluno(aluno_nome,aluno_email,aluno_senha)"+"VALUES (?,?,?)";
                                //tabela (atributos)                                  //deixar com ? para executar o script do try catch     
        try{
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,aluno.getAluno_nome());//(numerodaordemdeinserção,nome do item onde vai inserir(no caso que ta na classe aluno))
            stmt.setString(2,aluno.getAluno_email());//basicamente insere os dados que tão sendo pegos pela classe que foi passada e insere os dados no banco
            stmt.setString(3,aluno.getAluno_senha());
            stmt.execute();//executar o script do banco
            stmt.close();//fechar o script
        }catch(Exception erro/*você pode nomear de qualquer coisa*/){
            throw new RuntimeException("erro incerir Aluno:"+erro/*o erro vai mostrar a mensagem de erro(ava não me diga)*/);
        }
    }
}
