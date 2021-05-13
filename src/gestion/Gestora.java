package gestion;

import java.util.Collections;
import java.util.List;

import clasesPrincipales.Producto;

public class Gestora {
	
	public static List<Producto> ordenarLista (List<Producto> productos) {
		Collections.sort(productos);
		return productos;
	}

}
