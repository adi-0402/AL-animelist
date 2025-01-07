package com.aluracursos.animelist.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Data(
        @JsonAlias("attributes") DatosAnime anime
        ) {
        @Override
        public String toString() {
                return anime.toString();
        }
}
