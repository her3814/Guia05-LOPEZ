package guia05.domain;

public class Herramienta {

	private String nombre;
	private Double costoPorDia;

	public Herramienta(String nombre, Double costoPorDia) {
		this.nombre = nombre;
		this.costoPorDia = costoPorDia;
	}

	public Double getCostoDiario() {
		return this.costoPorDia;
	}

	@Override
	public String toString() {
		return "Herramienta: " + this.nombre;
	}

}
