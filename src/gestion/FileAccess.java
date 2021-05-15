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
	
	public static final String NOMBRE_FICHERO="Antipandemia.txt";
	public static final String NOMBRE_AUX="AntipandemiaAux.txt";
	
	
	/**
	 * Cabecera: public static boolean crearFichero(String nombre) <br>
	 * Descripcion: Este metodo se encarga de crear un fichero, en caso de que ya exista o haya algun error el metodo devolvera un false.<br>
	 * Precondiciones: ninguna <br>
	 * Postcondiciones: se intentara crear un fichero y se devolvera un booleana indicando si se ha podido o no <br>
	 * Entrada: String nombre<br>
	 * Salida: boolean creado <br>
	 * @param nombre <br>
	 * @return boolean creado <br>
	 */
	public static boolean crearFicheros() {
		File fichero=new File(NOMBRE_FICHERO);
		File ficheroAux=new File(NOMBRE_AUX);
		boolean creado=false;
		try {
			
			if(fichero.createNewFile()&&ficheroAux.createNewFile()) {
				creado=true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return creado;
	}
	
	/**
	 * Cabecera: public static List<Producto> leerFichero(String nombreFichero) <br>
	 * Descripcion: Este metodo se encarga de crear un fichero, en caso de que ya exista o haya algun error el metodo devolvera un false.<br>
	 * Precondiciones: ninguna <br>
	 * Postcondiciones: se intentara crear un fichero y se devolvera un booleana indicando si se ha podido o no <br>
	 * Entrada: String nombre<br>
	 * Salida: List <producto> <br>
	 * @param nombreFichero <br>
	 * @return List <producto> <br>
	 */	
	public static List<Producto> leerFichero(String nombreFichero) {
		ObjectInputStream ficheroEntrada=null;
		List<Producto> productos=new ArrayList<>();
		Object objeto;
		try {
			 ficheroEntrada = new ObjectInputStream(new FileInputStream(nombreFichero));
			  objeto=new Object();
	         while (objeto != null) {
	        	 try {
	               objeto=ficheroEntrada.readObject();
	               productos.add((Producto) objeto);
	        	 }catch(EOFException exc) {
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
				e.printStackTrace();
			}
		}
		return productos;
		
	}
	
	public static void sobreescribirFichero(List<Producto> productos) {
		ObjectOutputStream ficheroSalida=null;
		try {
			ficheroSalida = new ObjectOutputStream(new FileOutputStream(NOMBRE_FICHERO));
			for (Producto producto : productos) {
				ficheroSalida.writeObject(producto);
			}
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
	
	public static void escribirFicheroBinario(Object o,String nombreFichero) {
		ObjectOutputStream ficheroSalida=null;
		File fichero=new File(nombreFichero);
		try {
			if(fichero.length()<=0) { //Este if controla que el fichero haya sido creado o no, en caso afirmativo utilizará el outputstream sin cabecera, si el fichero no ha sido creado, utilizara el que tiene cabecera				
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
		sobreescribirFichero(productos);
		
	}
	public static void eliminarProducto(String codigoBarras) {
		ObjectInputStream ficheroEntrada=null;
		Producto p=null;
		boolean productoEncontrado=false;
		try {
			 ficheroEntrada = new ObjectInputStream(new FileInputStream(NOMBRE_FICHERO));
	         while (!productoEncontrado) {
	        	 try {
	        		 p=(Producto) ficheroEntrada.readObject();
	        		 if(p.getCodigoBarras().equals(codigoBarras)) {
	        			 p=(Producto) ficheroEntrada.readObject();
	        		 }
	        		 escribirFicheroBinario(p,NOMBRE_AUX);
	        	 }catch(EOFException exc) {
	        		productoEncontrado=true;
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
				e.printStackTrace();
			}
		}
		
	}
	
	
		
}
