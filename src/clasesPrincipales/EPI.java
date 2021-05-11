package clasesPrincipales;

import java.io.Serializable;
import java.time.LocalDate;

public class EPI extends Producto implements Serializable {
	
	private char parteCuerpo;
	private String material;

	public EPI(String codigoBarras, String nombre, LocalDate fechaCaducidad, double precio,char parteCuerpo,String material) {
		super(codigoBarras, nombre, fechaCaducidad, precio);
		this.parteCuerpo=parteCuerpo;
		this.material=material;
	}

	@Override
	public String toString() {
		return "EPI: "+super.toString()+"parteCuerpo=" + parteCuerpo + ", material=" + material + "]";
	}
	
	

}
