package DAO;//nome pacote
import MODEL.Cliente;//importando outro pacote
import java.sql.Connection;//necessario para conexao
import java.sql.PreparedStatement; //responsavel pelas instruções sql,com parametro
import java.sql.Statement; //responsavel pelas instruções sql,sem parametro
import java.sql.ResultSet;//responsavel por receber o resultado da busca no banco de dados
import java.util.ArrayList;//responsavel por exibir os valores do resultset
public class DAOCliente {
    private Connection conn;//instancia a conexao
    private PreparedStatement stmt;//instancia o preparedstatement
    private Statement st;//instancia o statement
    private ResultSet rs;//instancia o resultset
    private ArrayList<Cliente> lista=new ArrayList<>();//cria um array<com o tamanho de dados da classe cliente> nomedoarray=new array
    
    public DAOCliente(){
        //fazer conexao
        conn=new Conexao().getConexao();
         //chama a classe conexao e conecta a rede do banco de dados
    }
    public void inserirCliente(Cliente cliente){
                             //|>puxa a classe java Cliente cliente
        //cria o metodo pra passar os prametros no sql
        String sql="insert into tb_Clientes(nome,email) values(?,?)";
        //                                               nome dos itens da tabela values sempre em ?
        try{
            //passar a conexão para o preparet statement que vai se conectar ao banco de dados
            stmt=conn.prepareStatement(sql);
            //passar valores para o banco de dados
            stmt.setString(1,cliente.getNome());
                          //passa de acordo com os parametros do seu sql no caso nome é o 1 parametro,valor que o parametro recebe
            stmt.setString(2,cliente.getEmail());
                          //qual item que vai receber(no caso o email) e o que recebe
            stmt.execute();//executa o banco
            stmt.close();//fecha o banco
        }catch(Exception erro){
            throw new RuntimeException("erro na inserção",erro);
            
        }
    }
    public ArrayList<Cliente> listarClientes(){
           //cria um array<com o tamanhos dos dados da classe cliente> nome da função()//ele ja retorna o array
        String sql="select * from tb_Clientes";
        try{
            st= conn.createStatement();// da pra usar o preparate statemen tbm//se conecta ao banco de dados
            rs=st.executeQuery(sql);
            //criar uma estrutura de repetição para carregar linha por linha no array//esse rs recebe todos os dados que está no banco de dados
            while(rs.next()){
                //vai passando até os valores do banco serem vazios
                Cliente cliente=new Cliente();//tem que estar dentro do while pra ele passar pra uma nova classe onde estão novos dados(se não estiver dentro não funciona
                cliente.setId(rs.getInt("id"));//esse id é nome que esta no banco
                //recebe os valores pra mandar pro array
                cliente.setNome(rs.getString("nome"));//esse nome é nome que esta no banco
                cliente.setEmail(rs.getString("email"));//esse email é nome que esta no banco
                lista.add(cliente);
                //adiciona os valores no array que você criou lá em cima(como se fosse um vetor
            }
        }catch(Exception erro){
            throw new RuntimeException("erro ao listar clientes:",erro);
        }
        return lista;
        //retorna o array completo
    }
    
      public ArrayList<Cliente> listarClientesNome(String nome){
        String sql="select * from tb_Clientes where nome like '%"+nome+"%'";
                                                               //valor que foi pego como parametro//não precisa usar o ?
                                                      //sempre quando for usar um paramtro que foi passado direto como variavel você precisa concatenar com o +
                                                      //caso queira concatenar e escrever mais linhas do código você coloca "+nomevariavel+"linhas de codigo de bd
        try{
            st= conn.createStatement();// da pra usar o preparate statemen tbm//faz a conexao com bd
            rs=st.executeQuery(sql);
            //criar uma estrutura de repetição para carregar linha por linha no array//esse rs recebe todos os dados que está no banco de dados
            while(rs.next()){
                  //vai passando até os valores do banco serem vazios
                Cliente cliente=new Cliente();//tem que estar dentro do while pra ele passar pra uma nova classe onde estão novos dados(se não estiver dentro não funciona
                cliente.setId(rs.getInt("id"));//esse id é do banco
                cliente.setNome(rs.getString("nome"));//esse nome é do banco
                cliente.setEmail(rs.getString("email"));//esse email é do banco
                lista.add(cliente);
                //adiciona os valores no array que você criou lá em cima(como se fosse um vetor
            }
        }catch(Exception erro){
            throw new RuntimeException("erro ao listar clientes:",erro);
        }
        return lista;
       //retorna o array completo
    }
      
    public void  atualizarCliente(Cliente cliente){
        try{
            String sql="UPDATE tb_Clientes SET nome = ?, email = ? WHERE id = ?";
                                //todos os dados precisam ser em ? para que os parametros sejam os dados passados pela classe
            stmt=conn.prepareStatement(sql);//faz a conexao com bd
            stmt.setString(1,cliente.getNome());//parametro que recebe o valor no caso é o nome,valor que recebe
            //seta os valores pra colocar no banco de dados
            stmt.setString(2,cliente.getEmail());//parametro que recebe o valor no caso é o email,valor que recebe
            //seta os valores pra colocar no banco de dados
            stmt.setInt(3,cliente.getId());//parametro que recebe o valor no caso é o id,valor que recebe
            //seta os valores pra colocar no banco de dados
            stmt.execute();//executa os comandos
            stmt.close();//fecha o comando
        }catch(Exception erro){
            throw new RuntimeException("erro ao atualizar dados ",erro);
        }
    }
    
    public void deletar(int  valor){
        try{
            String sql="delete from tb_Clientes where id="+valor;
                                                          //valor que foi pego como parametro//não precisa usar o ?
                                                      //sempre quando for usar um paramtro que foi passado direto como variavel você precisa concatenar com o +
                                                      //caso queira concatenar e escrever mais linhas do código você coloca "+nomevariavel+"linhas de codigo de bd
            st=conn.createStatement();//faz a conexao com bd
            st.execute(sql);//executa o sql
            st.close();//fecha o comando
        }catch(Exception erro){
            throw new RuntimeException("erro ao inativar cliente");
        }
    }
}
