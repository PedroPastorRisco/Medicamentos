package mensaje;

import java.util.List;

import clasesPrincipales.Producto;

public class Mensaje {
	
	public static void leerArrayObjeto(List<Producto> productos) {
		
		for (Producto producto : productos) {
			System.out.println(producto.toString());
		}
		
	}

}
