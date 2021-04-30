package guia05.exceptions;

import guia05.domain.Trabajo;

public class TrabajoFinalizadoException extends RuntimeException {

	/** Agregado por recomendaci�n del IDE Eclipse */
	private static final long serialVersionUID = -8928961086057418880L;

	public TrabajoFinalizadoException(Trabajo trabajo) {
		super(trabajo.toString() + " ya se marc� como finalizado.");
	}
}