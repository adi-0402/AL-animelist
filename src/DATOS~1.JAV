package com.aluracursos.animelist.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Datos(
        @JsonAlias("data") List<Data> data
) { @Override
public String toString() {
    return data.stream()
            .map(Data::toString)
            .collect(Collectors.joining("\n"));
}}
