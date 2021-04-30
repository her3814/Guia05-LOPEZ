package guia05.exceptions;

import guia05.domain.Oficio;

/**
* <h1>Add Two Numbers!</h1>
* The AddNum program implements an application that
* simply adds two given integer numbers and Prints
* the output on the screen.
* <p>
* <b>Note:</b> Giving proper comments in your program makes it more
* user friendly and it is assumed as a high quality code.
*
* @author  Zara Ali
* @version 1.0
* @since   2014-03-31
*/
public class OficioNoCoincideException extends RuntimeException {
	
	   /**Agregado por recomendación del IDE Eclipse*/
	private static final long serialVersionUID = 4472827032563322863L;

	public OficioNoCoincideException(Oficio oficioTrabajador, Oficio oficioServicio) {
		super("El oficio " + oficioServicio.getNombre() + " no coincide con el oficio del trabajador (" + oficioTrabajador.getNombre() + ").");
	}
}
