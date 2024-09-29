package com.antonydio.citiesapi;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity                     //é utilizada para informar que uma classe também é uma entidade
@Table(name="pais")         //diz qual a table que vai seu usada para a inserção
public class Paises {
    @id                     //dizendo que essa variavel tem conexão com o id do banco de dados
    private long id;        //criando a veriavel que armazena os dados da tabela


    public Paises(long id) { //criando metodo construtor
        this.id = id;
    }

    public long getId() {   //alt+insert para inserir getters e setters
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
