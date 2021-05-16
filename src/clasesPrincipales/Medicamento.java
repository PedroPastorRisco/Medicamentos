package clasesPrincipales;

import java.time.LocalDate;

import enumerados.Presentacion;

public class Medicamento extends Producto {
	
	private Presentacion presentacion;
	private String principioActivo;
	
	
	

	public Medicamento(String codigoBarras, String nombre, LocalDate fechaCaducidad, double precio,Presentacion presentacion,String principioActivo) {
		super(codigoBarras, nombre, fechaCaducidad, precio);
		this.presentacion=presentacion;
		this.principioActivo=principioActivo;
	}
	


	public Medicamento() {
		// TODO Auto-generated constructor stub
	}



	public Presentacion getPresentacion() {
		return presentacion;
	}



	public String getPrincipioActivo() {
		return principioActivo;
	}



	@Override
	public String toString() {
		return "Medicamento"+super.toString()+"presentacion=" + presentacion + ", principioActivo=" + principioActivo + "]";
	}
	

}