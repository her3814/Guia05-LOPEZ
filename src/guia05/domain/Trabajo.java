package guia05.domain;

import java.time.Instant;

import guia05.exceptions.TrabajoFinalizadoException;

public class Trabajo implements Contratable {

	Trabajador trabajador;
	Servicio servicio;
	Boolean urgente;
	private Instant fechaInicio;
	private Instant fechaFin;

	public Trabajo(Trabajador trabajador, Servicio servicio) {
		this.trabajador = trabajador;
		this.servicio = servicio;
		this.urgente = false;
		this.fechaInicio = Instant.now();
	}

	public Trabajo(Trabajador trabajador, Servicio servicio, Boolean urgente) {
		this.trabajador = trabajador;
		this.servicio = servicio;
		this.urgente = urgente;
		this.fechaInicio = Instant.now();
	}

	public Trabajo(Trabajador trabajador, Servicio servicio, Boolean urgente, Instant fechaInicio) {
		this.trabajador = trabajador;
		this.servicio = servicio;
		this.fechaInicio = fechaInicio;
		this.urgente = urgente;
	}

	public Trabajo(Trabajador trabajador, Servicio servicio, Boolean urgente, Instant fechaInicio, Instant fechaFin) {
		this.trabajador = trabajador;
		this.servicio = servicio;
		this.fechaInicio = fechaInicio;
		this.urgente = urgente;
		this.fechaFin = fechaFin;
	}

	public Oficio getOficioRelacionado() {
		return this.servicio.Oficio();
	}

	public Instant getFechaInicio() {
		return this.fechaInicio;
	}

	public void marcarFinalizado() {
		if (this.fechaFin == null)
			this.fechaFin = Instant.now();
		else
			throw new TrabajoFinalizadoException(this);
	}

	public Double costo() {
		return urgente ? this.servicio.Costo() * 1.5 : this.servicio.Costo();
	}

	@Override
	public Boolean finalizado() {
		return this.fechaFin != null;
	}

	@Override
	public String toString() {
		return "Trabajo por" + servicio.toString() + " a realizar por " + trabajador.toString();
	}

	public void printDetalle() {
		System.out.println("\n" + servicio.toString());
		System.out.println("A realizar por: " + trabajador.getNombre());
		System.out.println(urgente ? "URGENTE" : "SIN URGENCIA");
		System.out.println(finalizado() ? "finalizado" : "SIN finalizar");
		System.out.println("Costo: " + costo() + "\n");

	}
}
