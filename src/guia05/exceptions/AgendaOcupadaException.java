package guia05.exceptions;

import guia05.domain.Trabajador;
import guia05.domain.Trabajo;
import guia05.infrastructure.Utils;

public class AgendaOcupadaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1940310981460032408L;

	public AgendaOcupadaException(Trabajador trabajador, Trabajo trabajo) {
		super(trabajador.toString() + " posee la agenda ocupada para el día " + Utils.InstantToDateString(trabajo.getFechaInicio()));
	}

}
