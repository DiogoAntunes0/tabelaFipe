package com.projeto.TabelaFipe.Serviços;

public interface IConverterDados {
    <T> T ConverteDados(String json, Class<T> classe);
}
