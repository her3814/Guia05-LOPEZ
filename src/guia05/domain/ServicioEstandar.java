package guia05.domain;

public class ServicioEstandar implements Servicio {

	private Double costoFijo;	
	private Double comisionProfesional;

	private TipoComision TipoComision;

	private Oficio oficio;

	public void constructor(Oficio oficio, Double costoFijo, TipoComision tipoComision, Double comisionProfesional) {
		this.costoFijo = costoFijo;
		this.oficio = oficio;
		this.TipoComision=tipoComision;
		this.comisionProfesional=comisionProfesional;
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
		switch (this.TipoComision) {
		case MONTO_FIJO:
			return this.costoFijo + this.comisionProfesional;
		case PORCENTUAL:
			return this.costoFijo * (1 + this.comisionProfesional);
		default:
			return this.costoFijo;
		}

	}

}
