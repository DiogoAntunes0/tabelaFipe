package com.projeto.TabelaFipe.Dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ModelosWrapper(@JsonAlias("modelos") List<Marca> modelos) { }