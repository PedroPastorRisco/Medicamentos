package gestion;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import clasesPrincipales.Epi;
import clasesPrincipales.Medicamento;
import clasesPrincipales.Producto;
import enumerados.Material;
import enumerados.ParteCuerpo;
import enumerados.Presentacion;
import validaciones.Validacion;

public class Gestora {
	
	
	public static Medicamento crearMedicamento() {
		Medicamento medicamento;
		medicamento=new Medicamento(Validacion.leerCodigo(), Validacion.leerNombre(), Validacion.esFechaValida(), Validacion.leerPrecio(), Validacion.obtenerPresentacion(), Validacion.leerPrincipioActivo());
		return medicamento;
	}
	public static void crearEpi() {
		Epi epi;
		epi=new Epi(Validacion.leerCodigo(), Validacion.leerNombre(), Validacion.esFechaValida(), Validacion.leerPrecio(), Validacion.obtenerParteCuerpo(), Validacion.obtenerMaterial());
		FileAccess.escribirFicheroBinario(epi, FileAccess.NOMBRE_AUX);
	}
	
	public static List<Producto> ordenarLista (List<Producto> productos) {
		Collections.sort(productos);
		return productos;
	}
	
	public static Producto recuperarProducto(String[] atributos) {
		Producto p;
		if(atributos[0].equals("Medicamento")) {
			p=new Medicamento(atributos[1], atributos[2], LocalDate.parse(atributos[3]), Double.parseDouble(atributos[4]), Presentacion.valueOf(atributos[5]), atributos[6]);
		}else {
			p=new Epi(atributos[1], atributos[2], LocalDate.parse(atributos[3]), Double.parseDouble(atributos[4]), ParteCuerpo.valueOf(atributos[6]), Material.valueOf(atributos[5]));
		}
		return p;
	}

}
