package clasesPrincipales;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Producto implements Comparable <Producto>, Serializable {
	
	private String codigoBarras;
	private String nombre;
	private LocalDate fechaCaducidad;
	private double precio;
	
	public Producto(String codigoBarras,String nombre,LocalDate fechaCaducidad,double precio) {
		this.codigoBarras=codigoBarras;
		this.nombre=nombre;
		this.fechaCaducidad=fechaCaducidad;
		this.precio=precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}
	
	@Override
	public int compareTo(Producto o) {
		int resultado=-1;
		if(equals(o)) {
			resultado=0;
		}else {
			if(o.getCodigoBarras().compareTo(getCodigoBarras())==1) {
				resultado=1;
			}
		}
		return resultado;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoBarras == null) ? 0 : codigoBarras.hashCode());
		return result;
	}

	public boolean equals(Producto p) {
		boolean iguales=false;
		if (this == p) {
			iguales=true;
		}else { 
			if(p != null && p instanceof Producto) {
				if(p.getCodigoBarras()==getCodigoBarras()) {
					iguales=true;
				}
			}
		
		}
		return iguales;
	}

	@Override
	public String toString() {
		return "[codigoBarras=" + codigoBarras + ", nombre=" + nombre + ", fechaCaducidad=" + fechaCaducidad
				+ ", precio=" + precio + ", ";
	}
	
}
