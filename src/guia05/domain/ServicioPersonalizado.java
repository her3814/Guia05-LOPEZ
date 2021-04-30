package guia05.domain;

public class ServicioPersonalizado implements Servicio {
	private Double montoPresupuestado;
	private Double costoMateriales;
	private Double costoTransporte;
	private Oficio oficio;

	public ServicioPersonalizado(Oficio oficio, Double costoPresupuesto, Double costoMateriales, Double costoTransporte) {
		this.oficio=oficio;
		this.montoPresupuestado = costoPresupuesto;
		this.costoMateriales = costoMateriales;
		this.costoTransporte = costoTransporte;
	}

	@Override
	public Double Costo() {
		return this.montoPresupuestado + this.costoMateriales + this.costoTransporte;
	}

	@Override
	public Oficio Oficio() {
		// TODO Auto-generated method stub
		return this.oficio;
	}

}
