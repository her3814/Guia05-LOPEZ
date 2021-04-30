package guia05;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import guia05.domain.*;
import guia05.exceptions.AlquilerNoEntregadoException;

public class App {

	static List<Oficio> oficios;
	static List<Trabajador> trabajadores;
	static List<Servicio> servicios;
	static List<Herramienta> herramientas;
	static List<Usuario> usuarios;

	public static void main(String[] args) {

		oficios = new ArrayList<Oficio>();
		trabajadores = new ArrayList<Trabajador>();
		servicios = new ArrayList<Servicio>();
		herramientas = new ArrayList<Herramienta>();
		usuarios = new ArrayList<Usuario>();

		CargarOficios(oficios);
		CargarTrabajadores(trabajadores, oficios);
		CargarHerramientas(herramientas);
		CargarUsuarios(usuarios);
		SimularPunto8_9();
	}

	
	private static void SimularPunto8_9() {
		var hernan = usuarios.get(0);
		
		ChronoUnit.DAYS.addTo(Instant.now(), -2);
		
		try {			
			hernan.contratar(new Alquiler(herramientas.get(2), ChronoUnit.DAYS.addTo(Instant.now(), -2),
					ChronoUnit.DAYS.addTo(Instant.now(), 2)));
			System.out.println("Se alquilo " + herramientas.get(2).toString() );
			
			hernan.contratar(new Alquiler(herramientas.get(0), ChronoUnit.DAYS.addTo(Instant.now(), -2),
					ChronoUnit.DAYS.addTo(Instant.now(), 2)));
			System.out.println("Se alquilo " + herramientas.get(0).toString() );
			
			hernan.contratar(new Alquiler(herramientas.get(1), ChronoUnit.DAYS.addTo(Instant.now(), -2),
					ChronoUnit.DAYS.addTo(Instant.now(), 2)));		
			System.out.println("Se alquilo " + herramientas.get(1).toString() );	
		}
		catch (AlquilerNoEntregadoException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void CargarUsuarios(List<Usuario> usuarios) {
		usuarios.add(new Usuario("hernan@mail.com"));
		usuarios.add(new Usuario("julian@mail.com"));
		usuarios.add(new Usuario("melisa@mail.com"));
		usuarios.add(new Usuario("belen@mail.com"));
		usuarios.add(new Usuario("mario@mail.com"));
	}

	private static void CargarOficios(List<Oficio> oficios) {
		String[] nombres = { "Albañil", "Carpintero", "Herrero", "Anabella", "Cerrajero" };

		Arrays.asList(nombres).forEach((o) -> {
			oficios.add(new Oficio(o));
		});
	}

	private static void CargarHerramientas(List<Herramienta> herramientas) {
		herramientas.add(new Herramienta("Cortadora de Pasto", 150.00));
		herramientas.add(new Herramienta("Martillo electrico", 350.00));
		herramientas.add(new Herramienta("Remachadora", 75.00));
		herramientas.add(new Herramienta("Taladro", 60.00));
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
