package guia05.domain;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Alquiler implements Contratable {
	private Herramienta herramienta;
	private Instant fechaInicio;
	private Instant fechaEntrega;
	private Instant fechaFin;

	public Alquiler(Herramienta herramienta, Instant fechaInicio, Instant fechaEntrega) {
		this.herramienta = herramienta;
		this.fechaInicio = fechaInicio;
		this.fechaEntrega = fechaEntrega;
	}

	public void MarcarEntrega() {
		this.fechaEntrega = Instant.now();
	}

	@Override
	public Boolean finalizado() {
		return this.fechaEntrega != null;
	}

	@Override
	public Double costo() {
		return this.herramienta.getCostoDiario() * this.diasAlquilado();
	}

	/**
	 * Informa los días que lleva de alquiler
	 */
	private long diasAlquilado() {
		return this.fechaEntrega != null ? ChronoUnit.DAYS.between(this.fechaInicio, this.fechaEntrega)
				: ChronoUnit.DAYS.between(this.fechaInicio, Instant.now());
	}

	public Boolean enMora() {

		if (this.fechaEntrega != null && this.fechaFin != null)
			return this.fechaFin.isBefore(fechaEntrega);

		if (this.fechaEntrega == null && this.fechaFin != null)
			return this.fechaFin.isBefore(Instant.now());

		return false;
	}

}
