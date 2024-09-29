/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author Unicesumar
 */
public class Aluno {
    //fazendo o encapsulamento das variaveis para fazer os gets e sets
    private int aluno_id;
    private String aluno_nome;
    private String aluno_email;
    private String aluno_senha;
    //botão direito,refatorar,encapsular(ele cria os gets e sets automaticamente)
    public int getAluno_id(/*não recebe nada pois é somente para retornar um valor ou printa-lo*/) {
        return aluno_id;//retornando valor para reuso
    }

    public void setAluno_id(int aluno_id/*tipo da variavel e nome que ela vai receber*/) {//não retorna nada pois apenas recebe o valor e armazena na classe
        this.aluno_id = aluno_id;//fazendo a variavel receber os dados passados como parametro
    }

    public String getAluno_nome() {
        return aluno_nome;
    }

    public void setAluno_nome(String aluno_nome) {
        this.aluno_nome = aluno_nome;
    }

    public String getAluno_email() {
        return aluno_email;
    }

    public void setAluno_email(String aluno_email) {
        this.aluno_email = aluno_email;
    }

    public String getAluno_senha() {
        return aluno_senha;
    }

    public void setAluno_senha(String aluno_senha) {
        this.aluno_senha = aluno_senha;
    }

}
