package com.aluracursos.animelist.principal;

import com.aluracursos.animelist.model.Data;
import com.aluracursos.animelist.model.Datos;
import com.aluracursos.animelist.model.DatosAnime;
import com.aluracursos.animelist.service.ConsumoAPI;
import com.aluracursos.animelist.service.ConvierteDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private final String URL = "https://kitsu.io/api/edge/anime";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();

    public void mostrarMenu(){
        System.out.println("Escribe el nombre del anime a buscar:");
        var nombreAnime = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL + "?page[limit]=1&filter[text]=" +
                nombreAnime.replace(" ", "%20"));
        var datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println(datos);

        System.out.println(" ");
        // Top 10 animes populares por categoria
        System.out.println("Elige una categoria: ");
        System.out.println("adventure / action / romance / samurai");
        var categoria = teclado.nextLine();
        var jsonTotal = consumoAPI.obtenerDatos(URL + "?filter[categories]=" + categoria);
        var total = conversor.obtenerDatos(jsonTotal, Datos.class);

        System.out.println("Top 10 animes populares en la categoria " + categoria);
        total.data().stream()
                .sorted(Comparator.comparing(d -> d.anime().evaluacion(), Comparator.reverseOrder()))
                .limit(10)
                .map(a -> a.anime().titulo().toUpperCase())
                .forEach(System.out::println);

        System.out.println(" ");
        // Trabajando con estadisticas
        DoubleSummaryStatistics est = total.data().stream()
                .filter(e -> e.anime().evaluacion() > 0)
                .collect(Collectors.summarizingDouble(e -> e.anime().evaluacion()));
        System.out.println("Media de evaluación: " + est.getAverage());
        System.out.println("Maxima evaluación: " + est.getMax());
        System.out.println("Minima evaluación: " + est.getMin());
    }
}
