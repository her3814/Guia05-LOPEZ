package guia05.exceptions;

public class AlquilerNoEntregadoException extends RuntimeException {
	/**
	 * Agregado por recomendaci�n de IDE Eclipse
	 */
	private static final long serialVersionUID = -8875470938281462507L;
	
	public AlquilerNoEntregadoException(String email) {
		super("El usuario " + email + " alcanz� el l�mite de alquileres sin devolver. No puede realizar m�s alquileres");
	}

}
