package guia05;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import guia05.domain.*;
import guia05.exceptions.AgendaOcupadaException;
import guia05.exceptions.AlquilerNoEntregadoException;
import guia05.exceptions.OficioNoCoincideException;

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

		CargarOficios();
		CargarTrabajadores();
		CargarHerramientas();
		CargarUsuarios();
		CargarServicios();

		SimularPunto5();
		SimularPunto7();
		SimularPunto8_9();
	}

	private static void SimularPunto5() {

		printMensajeSimulacion(5);

		var julian = usuarios.get(1);

		julian.contratar(new Alquiler(herramientas.get(3), ChronoUnit.DAYS.addTo(Instant.now(), -2),
				ChronoUnit.DAYS.addTo(Instant.now(), 2)));

		julian.contratar(new Alquiler(herramientas.get(1), ChronoUnit.DAYS.addTo(Instant.now(), -2),
				ChronoUnit.DAYS.addTo(Instant.now(), -1)));

		julian.printDetalleAlquileres();

	}

	private static void SimularPunto7() {

		printMensajeSimulacion(7);
		Usuario usuario = usuarios.get(3);

		Trabajador trabajadorA = trabajadores.get(1);
		Oficio oficioA = trabajadorA.getOficio();
		ServicioEstandar servicioA = new ServicioEstandar(oficioA, 150.0, TipoComision.PORCENTUAL, 0.5);

		Trabajador trabajadorB = trabajadores.get(3);
		List<Oficio> oficiosNoB = new ArrayList<Oficio>(oficios);
		oficiosNoB.remove(trabajadorB.getOficio());
		Oficio oficioNoB = oficiosNoB.get(0);
		ServicioEstandar servicioB = new ServicioEstandar(oficioNoB, 300.0, TipoComision.PORCENTUAL, 1.1);

		// Contratacion normal
		try {
			usuario.contratar(new Trabajo(trabajadorA, servicioA, false, ChronoUnit.DAYS.addTo(Instant.now(), -1)));
		} catch (OficioNoCoincideException e) {
			System.out.println(e.getMessage());
		} catch (AgendaOcupadaException e) {
			System.out.println(e.getMessage());
		}

		// Contratacion oficio no coincide
		try {
			usuario.contratar(new Trabajo(trabajadorB, servicioB, false, ChronoUnit.DAYS.addTo(Instant.now(), 1)));
		} catch (OficioNoCoincideException e) {
			System.out.println(e.getMessage());
		} catch (AgendaOcupadaException e) {
			System.out.println(e.getMessage());
		}

		// Contratacion agenda ocupada
		try {
			usuario.contratar(new Trabajo(trabajadorA, new ServicioPersonalizado(oficioA, 200.00, 50.00, 100.00), false,
					ChronoUnit.DAYS.addTo(Instant.now(), -1)));

		} catch (OficioNoCoincideException e) {
			System.out.println(e.getMessage());
		} catch (AgendaOcupadaException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void printMensajeSimulacion(int i) {
		System.out.println("\n\n-------- Simulando ejercicio " + i + " --------\n\n");
	}

	private static void SimularPunto8_9() {

		printMensajeSimulacion(8);

		var hernan = usuarios.get(0);

		ChronoUnit.DAYS.addTo(Instant.now(), -2);

		try {
			hernan.contratar(new Alquiler(herramientas.get(2), ChronoUnit.DAYS.addTo(Instant.now(), -2),
					ChronoUnit.DAYS.addTo(Instant.now(), 2)));
			System.out.println("Se alquilo " + herramientas.get(2).toString());

			hernan.contratar(new Alquiler(herramientas.get(0), ChronoUnit.DAYS.addTo(Instant.now(), -2),
					ChronoUnit.DAYS.addTo(Instant.now(), 2)));
			System.out.println("Se alquilo " + herramientas.get(0).toString());

			hernan.contratar(new Alquiler(herramientas.get(1), ChronoUnit.DAYS.addTo(Instant.now(), -2),
					ChronoUnit.DAYS.addTo(Instant.now(), 2)));
			System.out.println("Se alquilo " + herramientas.get(1).toString());
		} catch (AlquilerNoEntregadoException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void CargarUsuarios() {
		usuarios.add(new Usuario("hernan@mail.com"));
		usuarios.add(new Usuario("julian@mail.com"));
		usuarios.add(new Usuario("melisa@mail.com"));
		usuarios.add(new Usuario("belen@mail.com"));
		usuarios.add(new Usuario("mario@mail.com"));
	}

	private static void CargarOficios() {
		String[] nombres = { "Albañil", "Carpintero", "Herrero", "Anabella", "Cerrajero" };

		Arrays.asList(nombres).forEach((o) -> {
			oficios.add(new Oficio(o));
		});
	}

	private static void CargarServicios() {
		servicios.add(new ServicioEstandar(oficios.get(0), 300.00, TipoComision.PORCENTUAL, 0.8));
		servicios.add(new ServicioEstandar(oficios.get(2), 2000.00, TipoComision.MONTO_FIJO, 150.0));
	}

	private static void CargarHerramientas() {
		herramientas.add(new Herramienta("Cortadora de Pasto", 150.00));
		herramientas.add(new Herramienta("Martillo electrico", 350.00));
		herramientas.add(new Herramienta("Remachadora", 75.00));
		herramientas.add(new Herramienta("Taladro", 60.00));
	}

	private static void CargarTrabajadores() {
		var random = new Random(Instant.now().getEpochSecond());

		String[] nombres = { "Ernesto", "Marina", "Armando", "Anabella", "Mario" };

		Arrays.asList(nombres).forEach((n) -> {
			Oficio o = oficios.get(Math.floorMod(random.nextInt(), oficios.size()));
			trabajadores.add(new Trabajador(n, String.format("%s@correo.com", n.toLowerCase()), o));
		});

	}
}
