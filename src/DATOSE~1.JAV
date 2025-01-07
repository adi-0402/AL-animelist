package com.aluracursos.animelist.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosEpisodio(
        @JsonAlias("canonicalTitle") String titulo,
        @JsonAlias("number") Integer numeroEpisodio,
        @JsonAlias("synopsis") String resumen,
        @JsonAlias("airdate") String fechaLanzamiento
) {
}
