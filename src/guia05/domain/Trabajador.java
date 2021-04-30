package guia05.domain;

import java.util.List;

import guia05.exceptions.AgendaOcupadaException;
import guia05.exceptions.OficioNoCoincideException;

public class Trabajador {
	private String nombre;
	private String correoElectronico;
	private Oficio oficio;

	//

	private List<Trabajo> trabajosAsignados;

	public Trabajador(String nombre, String correo, Oficio oficio) {
		this.nombre = nombre;
		this.correoElectronico = correo;
		this.oficio = oficio;
	}

	public void asignarTrabajo(Trabajo trabajo) throws OficioNoCoincideException, AgendaOcupadaException {

		if (!trabajo.getOficioRelacionado().equals(this.oficio))
			throw new OficioNoCoincideException(this.oficio, trabajo.getOficioRelacionado());

		// Busco que el trabajador no tenga un trabajo que inicie el mismo dia que se
		// desea, inicie la solicitud de trabajo a sumar
		Boolean estaOcupado = this.trabajosAsignados.stream()
				.anyMatch(t -> t.getFechaInicio().equals(trabajo.getFechaInicio()));

		if (!estaOcupado) {
			this.trabajosAsignados.add(trabajo);
		} else
			throw new AgendaOcupadaException(this, trabajo);

	}

	public String toString() {
		return String.format("Trabajador: %s (%s). Oficio: %s", nombre, correoElectronico, oficio.getNombre());
	}

	public void printListaTrabajosAsignados() {
		if (this.trabajosAsignados.size() < 1) {
			System.out.println(this.nombre + " no posee trabajos asignados.");

		} else {
			System.out.println("Lista de trabajo asignado para " + this.nombre + ":");
			this.trabajosAsignados.forEach(t -> {
				System.out.println("\t" + t);
			});
		}
	}

	public String getNombre() {
		return nombre;
	}
}
