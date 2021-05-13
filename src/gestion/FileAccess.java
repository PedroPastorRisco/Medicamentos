package gestion;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import clasesPrincipales.Producto;

public class FileAccess {
	
	
	public static boolean crearFichero(String nombre) {
		File fichero=new File(nombre);
		boolean creado=true;
		try {
			
			if(fichero.createNewFile()) {
				System.out.println("Fichero creado correctamente");
			}else {
				creado=false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return creado;
	}
	
	public static List<Producto> leerFichero(String nombreFichero) {
		ObjectInputStream ficheroEntrada=null;
		List<Producto> productos=new ArrayList<>();
		try {
			 ficheroEntrada = new ObjectInputStream(new FileInputStream(nombreFichero));
			 Object objeto=new Object();
	         while (objeto != null) {
	        	 try {
	               objeto=ficheroEntrada.readObject();
	               productos.add((Producto) objeto);
	        	 }catch(EOFException exc) { //debido a que los panas que crearon java decidieron qeu iba a ser un lenguaje asqueroso, el metodo readobject no te pone el objeto a nulo, enga un saludo
	        		 objeto=null;
	        	 }
	         }
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(null != ficheroEntrada) {
					ficheroEntrada.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return productos;
		
	}
	
	public static void sobreescribirFichero(List<Producto> productos,String nombreFichero) {
		ObjectOutputStream ficheroSalida=null;
		try {
			ficheroSalida = new ObjectOutputStream(new FileOutputStream(nombreFichero));
			for (Producto producto : productos) {
				ficheroSalida.writeObject(producto);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(null != ficheroSalida) {
					ficheroSalida.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void escribirFicheroBinario(Object o,String nombreFichero) {
		ObjectOutputStream ficheroSalida=null;
		File fichero=new File(nombreFichero);
		try {
			if(fichero.createNewFile()) { //Este if controla que el fichero haya sido creado o no, en caso afirmativo utilizará el outputstream sin cabecera, si el fichero no ha sido creado, utilizara el que tiene cabecera				
				ficheroSalida=new ObjectOutputStream(new FileOutputStream(nombreFichero));
			}else {				
				ficheroSalida = new PedroOutputStream(new FileOutputStream(nombreFichero,true));
			}
			ficheroSalida.writeObject(o);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null != ficheroSalida) {
					  ficheroSalida.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void ordenarFichero(String nombreFichero) {
		List<Producto> productos=leerFichero(nombreFichero);
		Gestora.ordenarLista(productos); //Ordenamos la lista de productos que nos han dado
		//Introducimos los objetos en el fichero en el orden correcto
		sobreescribirFichero(productos, nombreFichero);
		
	}
		
}
