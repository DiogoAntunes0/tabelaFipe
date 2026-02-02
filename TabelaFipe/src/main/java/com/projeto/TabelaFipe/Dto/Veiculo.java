package com.projeto.TabelaFipe.Serviços.Dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Veiculo(@JsonAlias("codigo") String cod,
                      @JsonAlias("nome") String nome) {
    @Override
    public String toString() {
        return "Marca: " +
                nome +
                ", Código: " + cod + '\'';
    }
}
