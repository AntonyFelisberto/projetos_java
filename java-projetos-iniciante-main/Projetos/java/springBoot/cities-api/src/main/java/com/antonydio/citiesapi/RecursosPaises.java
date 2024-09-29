package com.antonydio.citiesapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController                                 //é para marcar que o controlador está fornecendo serviços REST com o tipo de resposta JSON
@RequestMapping("/paises")                      //é usada para mapear solicitações da web para métodos Spring Controller.
public class RecursosPaises {
    @Autowired                                  //faz a injeção de dependencia
    private  RepositorioDePaises repository;

    @GetMapping                                 //Anotação para mapear GETsolicitações de HTTP em métodos de tratamento específicos.
    public List<Paises>paises(){                //retorna uma lista<do tamanho de paises> nomeFunção (recebe vazio)
        return repository.findAll();
    }
    @GetMapping("/{id}")                                //dizendo qual parametro vai pegar
    public Paises getOne(@PathVariable Long id){        //retorna o resultado da variavel opcao
        Optional<Paises>opcao=repository.findById();    //OPTIONAL-Se um valor estiver presente e o valor corresponder ao predicado fornecido, retorne um Optionaldescrevendo o valor; caso contrário, retorne um vazio Optional.//encontra um elemento especificado
        return ResponseEntity.ok().opcao.get();         //retorna tudo ok no site//retorna os dados listados na variavel
    }
}
