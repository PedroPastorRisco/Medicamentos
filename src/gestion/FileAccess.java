package gestion;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
	
	public static void leerFichero(String nombreFichero) {
		ObjectInputStream ficheroEntrada=null;
		try {
			 ficheroEntrada = new ObjectInputStream(new FileInputStream(nombreFichero));
			 Object objeto=new Object();
	         while (objeto != null) {
	        	 try {
	               if(objeto instanceof Producto) {
	            	   System.out.println(objeto);
	               }
	               objeto=ficheroEntrada.readObject();
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
		
	}
	public static void anyadirFichero(Object o,String nombreFichero) {
		PedroOutputStream ficheroSalida=null;
		try {
			ficheroSalida = new PedroOutputStream(new FileOutputStream(nombreFichero,true));
			ficheroSalida.writeObject(o);
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
	
	public static void escribirFichero(Object o,String nombreFichero) {
		ObjectOutputStream ficheroSalida=null;
		try {
			ficheroSalida = new ObjectOutputStream(new FileOutputStream(nombreFichero,true));
			ficheroSalida.writeObject(o);
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
	
	public static void escribirDefinitivoFichero(Object o,String nombreFichero) {
		ObjectOutputStream ficheroSalida=null;
		File fichero=new File(nombreFichero);
		try {
			if(fichero.exists()) { //Este if controla que el fichero haya sido creado o no, en caso afirmativo utilizará el outputstream sin cabecera, si el fichero no ha sido creado, utilizara el que tiene cabecera
				ficheroSalida = new PedroOutputStream(new FileOutputStream(nombreFichero,true));
			}else {
				fichero.createNewFile();
				ficheroSalida=new ObjectOutputStream(new FileOutputStream(nombreFichero));
			}
			ficheroSalida.writeObject(o);
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
		
}
