package com.projeto.TabelaFipe.Serviços.Dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Marca(@JsonAlias("codigo") String cod,
                          @JsonAlias("nome") String nome) {

        @Override
        public String toString() {
            return "Modelos da marca: " +
                    '\'' +
                    "Nome: " + nome + '\'' +
                    ", Código: " + cod + '\'' +
                    '}';
        }
    }

