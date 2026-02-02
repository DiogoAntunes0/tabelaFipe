package com.projeto.TabelaFipe.Serviços.Dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AnoVeiculo(@JsonAlias("Valor") String valor,
                         @JsonAlias("Marca") String marca,
                         @JsonAlias("Modelo") String modelo,
                         @JsonAlias("AnoModelo") String anoModelo,
                         @JsonAlias("Combustivel") String combustivel,
                         @JsonAlias("CodigoFipe") String codigoFipe,
                         @JsonAlias("SiglaCombustivel") String siglaCombustivel){

    @Override
    public String toString() {
        return "Valor: " + valor
                +"\n" + "Marca: " + marca
                +"\n" + "Modelo: " + modelo
                +"\n" + "Ano do modelo: " + anoModelo
                +"\n" + "Combustível: " + combustivel
                +"\n" + "Código Fipe: " + codigoFipe
                +"\n" + "Sigla do combustível: " + siglaCombustivel;
    }
}
