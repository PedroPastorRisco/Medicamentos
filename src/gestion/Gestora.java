package gestion;

import java.util.Collections;
import java.util.List;

import clasesPrincipales.Epi;
import clasesPrincipales.Medicamento;
import clasesPrincipales.Producto;
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

}
