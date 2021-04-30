package guia05.domain;

import java.util.ArrayList;
import java.util.List;

import guia05.exceptions.AgendaOcupadaException;
import guia05.exceptions.AlquilerNoEntregadoException;
import guia05.exceptions.OficioNoCoincideException;

public class Usuario {
	private final short limiteAlquileres = 2;
	private String email;
	private List<Contratable> contratosRealizados;

	public Usuario(String email) {
		this.email = email;
		this.contratosRealizados = new ArrayList<Contratable>();
	}

	public String getEmail() {
		return email;
	}

	public void contratar(Trabajo trabajo) throws OficioNoCoincideException, AgendaOcupadaException {
		try {
			trabajo.trabajador.asignarTrabajo(trabajo);
			this.contratosRealizados.add(trabajo);
		} catch (OficioNoCoincideException e) {
			throw e;
		} catch (AgendaOcupadaException e) {
			throw e;
		}
	}

	public void contratar(Alquiler alquiler) throws AlquilerNoEntregadoException {
		if (this.contratosRealizados.stream().filter(t -> t instanceof Alquiler && t.finalizado() == false)
				.count() >= limiteAlquileres)
			throw new AlquilerNoEntregadoException(this.email);
		else
			this.contratosRealizados.add(alquiler);

	}

	public void printDetalleAlquileres() {
		this.contratosRealizados.stream().forEach(c -> {
			if (c instanceof Alquiler)
				c.printDetalle();
		});
	}

	public void printDetalleContratos() {
		this.contratosRealizados.stream().forEach(c -> {
			
				c.printDetalle();
		});
	}
	public void printDetalleTrabajos() {
		this.contratosRealizados.stream().forEach(c -> {
			if (c instanceof Trabajo)
				c.printDetalle();
		});
	}
	public void listarContratadoPendientes() {
		this.contratosRealizados.stream().filter(c -> !c.finalizado()).forEach(c -> System.out.println(c.toString()));
	}

	@Override
	public String toString() {
		return "Usuario: " + email;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.getEmail() != null)
				return false;
		} else if (!email.equals(other.getEmail()))
			return false;
		return true;
	}
}
