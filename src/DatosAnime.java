package com.aluracursos.animelist.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAnime(
        @JsonAlias("canonicalTitle") String titulo,
        @JsonAlias("averageRating") Double evaluacion,
        @JsonAlias("episodeCount") Integer episodios
) {@Override
public String toString() {
    return "Título: " + titulo + ", Evaluación: " + evaluacion + ", Episodios: " + episodios;
}

}
