package com.aluracursos.animelist;

import com.aluracursos.animelist.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnimelistApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AnimelistApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.mostrarMenu();
	}
}
