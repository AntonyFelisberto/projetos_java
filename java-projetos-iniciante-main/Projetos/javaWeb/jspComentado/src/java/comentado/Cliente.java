package MODEL;

public class Cliente {
    private int id;//variaveis tem que ser privadas
    private String nome;
    private String email;
   //botão direito inserir codigo,getters e setters
    
    //retorna o valor da variavel
    public int getId() {
        return id;
    }
    //faz a variavel receber um valor que foi passado como parametro
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
