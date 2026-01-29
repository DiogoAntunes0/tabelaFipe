package com.projeto.TabelaFipe.Serviços;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ConverterDados implements IConverterDados {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T ConverteDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
                    //mapper.getTypeFactory().constructCollectionType(classe));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter para lista", e);
        }
    }

    public <T> List<T> obterLista(String json, Class<T> classe) {
        try {
            return mapper.readValue(json,
                    mapper.getTypeFactory().constructCollectionType(List.class, classe));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter lista", e);
        }
    }
}