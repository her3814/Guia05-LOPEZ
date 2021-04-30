package guia05.domain;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import guia05.infrastructure.Utils;

public class Alquiler implements Contratable {

	private Herramienta herramienta;
	private Instant fechaInicio;
	private Instant fechaFinAcordada;
	private Instant fechaDevolucion;

	public Alquiler(Herramienta herramienta, Instant fechaInicio, Instant fechaFinAcordada) {
		this.herramienta = herramienta;
		this.fechaInicio = fechaInicio;
		this.fechaFinAcordada = fechaFinAcordada;
	}

	@Override
	public Boolean finalizado() {
		return this.fechaDevolucion != null;
	}

	@Override
	public Double costo() {
		return this.herramienta.getCostoDiario() * this.diasAlquilado();
	}

	private long diasAlquilado() {
		return this.fechaDevolucion != null ? ChronoUnit.DAYS.between(this.fechaInicio, this.fechaDevolucion)
				: ChronoUnit.DAYS.between(this.fechaInicio, Instant.now());
	}

	public Boolean enMora() {
		if (this.fechaDevolucion != null) {
			return this.fechaDevolucion.isAfter(fechaFinAcordada);
		} else
			return this.fechaFinAcordada.isBefore(Instant.now());
	}

	@Override
	public String toString() {
		return String.format("Alquiler de %s, desde %s acordado hasta %s", herramienta.toString(),
				Utils.InstantToDateString(fechaInicio), Utils.InstantToDateString(fechaFinAcordada));
	}

	public void printDetalle() {
		System.out.println("\n" + herramienta.toString());
		System.out.println("\tFecha Inicio:" + Utils.InstantToDateString(fechaInicio));
		System.out.println("\tFecha Finalización Acordada:" + Utils.InstantToDateString(fechaFinAcordada));
		System.out.println("\tFecha de devolución:" + (fechaDevolucion!=null ? Utils.InstantToDateString(fechaDevolucion) : "SIN DEVOLVER"));
		System.out.println("\tEn mora:" + enMora());		
		System.out.println("\tCosto: " + costo() + "\n");
	}

}
