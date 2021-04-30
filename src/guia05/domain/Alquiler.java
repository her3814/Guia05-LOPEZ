package guia05.domain;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

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
		return this.fechaDevolucion != null ? 
				ChronoUnit.DAYS.between(this.fechaInicio, this.fechaDevolucion)
				: ChronoUnit.DAYS.between(this.fechaInicio, Instant.now());
	}

	public Boolean enMora() {
		if(this.fechaDevolucion != null)
		{
			return this.fechaDevolucion.isAfter(fechaFinAcordada);
		}else 
			return this.fechaFinAcordada.isBefore(Instant.now());
	}

}
