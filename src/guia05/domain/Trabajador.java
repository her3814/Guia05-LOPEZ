package guia05.domain;

import java.util.List;

import guia05.exceptions.AgendaOcupadaException;
import guia05.exceptions.OficioNoCoincideException;

public class Trabajador {
	private List<Trabajo> trabajosAsignados;
	private String nombre;
	private String correoElectronico;
	private Oficio oficio;
	private Double costoHora;
	private Double comision;

	public Trabajador(String nombre, String correo, Oficio oficio, Double costoHora, Double comision) {
		this.nombre = nombre;
		this.correoElectronico = correo;
		this.oficio = oficio;
		this.costoHora = costoHora;
		this.comision = comision;
	}

	public void asignarTrabajo(Trabajo trabajo) throws OficioNoCoincideException, AgendaOcupadaException {

		if (!trabajo.getOficioRelacionado().equals(this.oficio))
			throw new OficioNoCoincideException(this.oficio, trabajo.getOficioRelacionado());

		Boolean estaOcupado = this.trabajosAsignados.stream()
				.anyMatch(t -> t.getFechaInicio().equals(trabajo.getFechaInicio()));

		if (!estaOcupado) {
			this.trabajosAsignados.add(trabajo);
		} else
			throw new AgendaOcupadaException(this, trabajo);

	}

	public Double getComision() {
		return this.comision;
	}

	public Double cotizarCostoTrabajo(double horasATrabajar) {
		return this.costoHora * horasATrabajar;
	}

	public String toString() {
		return String.format("Trabajador: {0} ({1}). Oficio: {3}", nombre, correoElectronico, oficio.getNombre());
	}
}
