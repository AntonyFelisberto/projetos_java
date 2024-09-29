package com.antonydio.citiesapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioDePaises extends JpaRepository<Paises,Long> {
                                            //JpaRepository implementa todos os metodos da classes ja estabelecida//classe paises//especificação do id
}
