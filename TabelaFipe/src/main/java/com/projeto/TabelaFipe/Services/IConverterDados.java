package com.projeto.TabelaFipe.Services;

public interface IConverterDados {
    <T> T ConverteDados(String json, Class<T> classe);
}
