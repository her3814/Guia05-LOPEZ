package guia05;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import guia05.domain.*;

public class App { 

	static List<Oficio> oficios;
	static List<Trabajador> trabajadores;
	static List<Servicio> servicios;

	public static void main(String[] args) {

		oficios = new ArrayList<Oficio>();
		trabajadores = new ArrayList<Trabajador>();
		servicios = new ArrayList<Servicio>();

		CargarOficios(oficios);
		CargarTrabajadores(trabajadores, oficios);
		
		
		System.out.println(trabajadores);

	}

	private static void CargarOficios(List<Oficio> oficios) {
		String[] nombres = { "Albañil", "Carpintero", "Herrero", "Anabella", "Cerrajero" };
		
		Arrays.asList(nombres).forEach((o) -> {
			oficios.add(new Oficio(o));
		});
	}
	
	private static void CargarTrabajadores(List<Trabajador> trabajadores, List<Oficio> oficios) {
		var random = new Random(Instant.now().getEpochSecond());

		String[] nombres = { "Ernesto", "Marina", "Armando", "Anabella", "Mario" };

		Arrays.asList(nombres).forEach((n) -> {
			Oficio o = oficios.get(Math.floorMod(random.nextInt(), oficios.size()));
			trabajadores.add(new Trabajador(n, String.format("%s@correo.com", n.toLowerCase()), o));
		});

	}
}
