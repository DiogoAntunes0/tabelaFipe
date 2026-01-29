package com.projeto.TabelaFipe.Serviços;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Marca(@JsonAlias("codigo") String cod,
                          @JsonAlias("nome") String nome) {
    }

