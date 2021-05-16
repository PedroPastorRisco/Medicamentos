package clasesPrincipales;

import java.time.LocalDate;

import enumerados.Material;
import enumerados.ParteCuerpo;

public class Epi extends Producto {
	
	private ParteCuerpo parteCuerpo;
	private Material material;
	
	public Epi() {
		
	}

	public Epi(String codigoBarras, String nombre, LocalDate fechaCaducidad, double precio,ParteCuerpo parteCuerpo,Material material) {
		super(codigoBarras, nombre, fechaCaducidad, precio);
		this.parteCuerpo=parteCuerpo;
		this.material=material;
	}
	

	public ParteCuerpo getParteCuerpo() {
		return parteCuerpo;
	}


	public Material getMaterial() {
		return material;
	}


	@Override
	public String toString() {
		return "EPI:"+super.toString()+"parteCuerpo=" + parteCuerpo + ", material=" + material + "]";
	}
	
	
	

}
