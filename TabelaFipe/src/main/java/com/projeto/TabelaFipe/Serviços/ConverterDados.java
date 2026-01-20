package com.projeto.TabelaFipe.Serviços;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverterDados implements IConverterDados {
    private ObjectMapper mapper = new ObjectMapper();

    public <T> T ConverteDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter JSON", e);
        }
    }
}