package com.aluracursos.animelist.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosTemporada(
        @JsonAlias("seasonNumber") Integer numeroTemporada,
        @JsonAlias("episodes") List<DatosEpisodio> episodios
) {
}
