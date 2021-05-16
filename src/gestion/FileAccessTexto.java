package gestion;

import java.io.*;

import clasesPrincipales.Producto;
import mensaje.Mensaje;

public class FileAccessTexto {
	
	public static final String NOMBRE_FICHERO="Antipandemia.txt";
	public static final String NOMBRE_AUX="AntipandemiaAux.txt";
	
	
	/**
	 * Cabecera: public static boolean crearFichero(String nombre) <br>
	 * Descripcion: Este metodo se encarga de crear un fichero, en caso de que ya exista o haya algun error el metodo devolvera un false.<br>
	 * Precondiciones: ninguna <br>
	 * Postcondiciones: se intentara crear un fichero y se devolvera un booleana indicando si se ha podido o no <br>
	 * Entrada: Ninguna<br>
	 * Salida: boolean creado <br>
	 * @return boolean creado <br>
	 */
	public static boolean crearFicheros() {
		File fichero=new File(NOMBRE_FICHERO);
		File ficheroAux=new File(NOMBRE_AUX);
		boolean creado=false;
		try {
			if(ficheroAux.createNewFile()&&fichero.createNewFile()) {
				creado=true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return creado;
	}
	
	
	public static void escribirObjeto(Object o,String nombreFichero) {
		BufferedWriter ficheroSalida=null;
		try
        {
             ficheroSalida = new BufferedWriter(new FileWriter(new File(nombreFichero),true));
            ficheroSalida.write(o.toString());
            ficheroSalida.newLine();
        }
        catch (IOException errorDeFichero)
        {
          
        }finally {
        	try {
				ficheroSalida.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	public static void escribirFichero(String objeto,String nombreFichero) {
		BufferedWriter ficheroSalida=null;
		try
        {
             ficheroSalida = new BufferedWriter(new FileWriter(new File(nombreFichero),true));
            ficheroSalida.write(objeto);
            ficheroSalida.newLine();
        }
        catch (IOException errorDeFichero)
        {
           
        }finally {
        	try {
				ficheroSalida.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
	public static String[] leerObjeto(String nombreFichero) {
		String[] atributos=null;
		BufferedReader ficheroEntrada=null;
		String linea;
		try {
			ficheroEntrada = new BufferedReader(new FileReader(nombreFichero));
			linea=ficheroEntrada.readLine();
			if(linea!=null) {
				atributos=linea.split(",");
			}
		}catch(IOException errorDeFichero) {
			
		}finally {
			try {
				ficheroEntrada.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return atributos;
	}
	public static void leerFichero(String nombreFichero) {
		BufferedReader ficheroEntrada=null;
		String linea;
		try {
			ficheroEntrada = new BufferedReader(new FileReader(nombreFichero));
			linea=ficheroEntrada.readLine();
			while(linea!=null) {
				Mensaje.mostrarString(linea);
				linea=ficheroEntrada.readLine();
			}
		}catch(IOException errorDeFichero) {
			System.out.println("Ups,un error");
		}finally {
			try {
				ficheroEntrada.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void eliminarProducto(String codigoBarras,String nombreFichero) {
		String[] atributos=null;
		BufferedReader ficheroEntrada=null;
		String linea;
		Producto producto;
		try {
			ficheroEntrada = new BufferedReader(new FileReader(nombreFichero));
			linea=ficheroEntrada.readLine();
			while(linea!=null) {
				atributos=linea.split(",");
				producto=Gestora.recuperarProducto(atributos);
				if(!producto.getCodigoBarras().equals(codigoBarras)) {
					escribirFichero(linea,NOMBRE_AUX);
				}
				linea=ficheroEntrada.readLine();
			}
		}catch(IOException errorDeFichero) {
			
		}finally {
			try {
				ficheroEntrada.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void cambioFichero() {
			File fichero=new File(NOMBRE_FICHERO);
			File ficheroAux=new File(NOMBRE_AUX);	
			File ficheroMaster=fichero;
			fichero.delete();
			ficheroAux.renameTo(ficheroMaster);
		}
	

}
