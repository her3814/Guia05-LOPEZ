package guia05.domain;

public class Oficio {
	private String nombre;

	public Oficio(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Oficio: " + this.nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oficio other = (Oficio) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
}
