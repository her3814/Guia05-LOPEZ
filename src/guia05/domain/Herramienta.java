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

	public String getNombre() {
		return nombre;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Herramienta other = (Herramienta) obj;
		if (nombre == null) {
			if (other.getNombre() != null)
				return false;
		} else if (!nombre.equals(other.getNombre()))
			return false;
		return true;
	}
}
