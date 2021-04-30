package guia05.domain;

public class ServicioEstandar implements Servicio {

	private Double costoFijo;
	private Oficio oficio;

	public void constructor(Oficio oficio, Double costoFijo) {
		this.costoFijo = costoFijo;
		this.oficio = oficio;
	}

	@Override
	public String toString() {
		return "SERVICIO ESTANDAR: " + this.oficio.toString();
	}

	@Override
	public guia05.domain.Oficio Oficio() {
		return this.oficio;
	}

	@Override
	public Double Costo() {
		// TODO Auto-generated method stub
		return this.costoFijo;
	}

}
