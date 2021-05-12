package clasesPrincipales;

import java.io.Serializable;
import java.time.LocalDate;

import enumerados.Material;
import enumerados.ParteCuerpo;

public class EPI extends Producto implements Serializable {
	
	private ParteCuerpo parteCuerpo;
	private Material material;

	public EPI(String codigoBarras, String nombre, LocalDate fechaCaducidad, double precio,ParteCuerpo parteCuerpo,Material material) {
		super(codigoBarras, nombre, fechaCaducidad, precio);
		this.parteCuerpo=parteCuerpo;
		this.material=material;
	}

	@Override
	public String toString() {
		return "EPI: "+super.toString()+"parteCuerpo=" + parteCuerpo + ", material=" + material + "]";
	}
	
	

}
