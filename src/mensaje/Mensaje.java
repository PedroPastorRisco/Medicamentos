package mensaje;

import java.util.List;

import clasesPrincipales.Producto;

public class Mensaje {
	
	/**
	 * Cabecera: public static void leerArrayObjeto(List<Producto> productos) <br>
	 * Comentario: Este metodo se encarga de leer un array de Productos y mostrar por pantalla su toString <br>
	 * Precondiciones: que la lista de productos tenga minimo un producto <br>
	 * Postcondiciones: Muestra por pantalla el toString de los Productos <br> 
	 * Entrada: List<Producto> productos <br>
	 * Salida: Ninguna <br>
	 * @param productos <br>
	 */
	public static void leerArrayObjeto(List<Producto> productos) {
		for (Producto producto : productos) {
			System.out.println(producto.toString());
		}
		
	}
	
	
	public static void mostrarResultado (boolean resultado) {
		if(resultado){
			System.out.println("Todo ha salido a pedir de milhouse");
		}else {
			System.out.println("Ups, algo ha dado error. Contacte con Raúl");
		}
	}

}
