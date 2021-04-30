package guia05.exceptions;

public class AlquilerNoEntregadoException extends RuntimeException {
	/**
	 * Agregado por recomendación de IDE Eclipse
	 */
	private static final long serialVersionUID = -8875470938281462507L;
	
	public AlquilerNoEntregadoException(String email) {
		super("El usuario " + email + " alcanzó el límite de alquileres sin devolver. No puede realizar más alquileres");
	}

}
