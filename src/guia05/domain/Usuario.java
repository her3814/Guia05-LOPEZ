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

	public void constructor(String email) {
		this.email = email;
		this.contratosRealizados = new ArrayList<Contratable>();
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
		if (this.contratosRealizados.stream().filter(t -> t instanceof Alquiler && t.finalizado() == false).count() >= limiteAlquileres)
			throw new AlquilerNoEntregadoException(this.email);
		else
			this.contratosRealizados.add(alquiler);

	}

	public void ListarContratadoPendientes() {
		this.contratosRealizados.stream().filter(c -> !c.finalizado()).forEach(c -> c.toString()); 
	}
}
