package validaciones;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static java.time.temporal.ChronoField.YEAR;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

import enumerados.Material;
import enumerados.ParteCuerpo;
import enumerados.Presentacion;

public class Validacion {
private static Scanner teclado = new Scanner(System.in);
	
	/**
	 * Cabecera: public static String leerCodigo()<br>
	 * <br>
	 * Comentario: Este metodo se encarga de leer una cadena, que sera el codigo de un producto.
	 * Este codigo tendrá que ser siempre de longitud 20, en caso contrario le volverá a pedir el código<br>
	 * <br>
	 * Precondiciones: Ninguna<br>
	 * <br>
	 * Entrada: Ninguna<br>
	 * <br>
	 * Salida: String(cadena)<br>
	 * <br>
	 * Postcondiciones: Este metodo se trata de una funcion ya que devulve un tipo de dato, en este caso una cadena.<br>
	 *  <br>
	 * @return nombre<br>
     */
	public static String leerCodigo() {
		String nombre;
		boolean codigoNoValido=true;
		do {
			System.out.println("Ingrese el codigo del producto, debe ser de longitud 20");
			nombre=teclado.next();
			if(nombre.length()==20) {
				codigoNoValido=false;
			}
		}while(codigoNoValido);
    	return nombre;
	}
	/**
	 * Cabecera: public static String leerNombre()<br>
	 * <br>
	 * Comentario: Este metodo se encarga de leer una cadena, que sera el nombre de un producto<br>
	 * <br>
	 * Precondiciones: Ninguna<br>
	 * <br>
	 * Entrada: Ninguna<br>
	 * <br>
	 * Salida: String(cadena)<br>
	 * <br>
	 * Postcondiciones: Este metodo se trata de una funcion ya que devulve un tipo de dato, en este caso una cadena.<br>
	 *  <br>
	 * @return nombre<br>
     */
	public static String leerNombre() {
		String nombre;
		System.out.println("Ingrese el nombre");
		nombre=teclado.next();
    	return nombre;
	}
	/**
     * Precondciones: ninguna</br>
     * Postcondiciones: nos devuelve un valor que vale para un enum</br>
     * entrada: ninguna</br>
     * salida:Material material</br>
     * @return
     */
    public static Material obtenerMaterial() {
		Material material = null;
		String respuesta;
		boolean datoValido;
		System.out.println("Introduce el material de tu EPI. Puede ser plastico, tela o silicona");
		do {
			respuesta=teclado.next();
			respuesta=respuesta.toUpperCase();
			try {
				material=Material.valueOf(respuesta);
				datoValido=true;
			}catch(Exception e) {
				System.out.println("Material introducido no valido, intentelo de nuevo");
				datoValido=false;
			}
		}while(!datoValido);
		return material;
	
    }
    /**
     * Precondciones: ninguna</br>
     * Postcondiciones: nos devuelve un valor que vale para un enum</br>
     * entrada: ninguna</br>
     * salida:ParteCuepro parteCuerpo</br>
     * @return
     */
    public static ParteCuerpo obtenerParteCuerpo() {
		ParteCuerpo parteCuerpo = null;
		String respuesta;
		boolean datoValido;
		System.out.println("Introduce la zona del cuerpo donde s eva a utilizar el EPI. Puede ser manos,ojos o cara");
		do {
			respuesta=teclado.next();
			respuesta=respuesta.toUpperCase();
			try {
				parteCuerpo=ParteCuerpo.valueOf(respuesta);
				datoValido=true;
			}catch(Exception e) {
				System.out.println("Parte de cuerpo  introducida no valida, intentelo de nuevo");
				datoValido=false;
			}
		}while(!datoValido);
		return parteCuerpo;
    }
    /**
     * Precondciones: ninguna</br>
     * Postcondiciones: nos devuelve un valor que vale para un enum</br>
     * entrada: ninguna</br>
     * salida:Presentacion presentacion</br>
     * @return
     */
    public static Presentacion obtenerPresentacion() {
		Presentacion presentacion = null;
		String respuesta;
		boolean datoValido;
		System.out.println("Introduce la presentacion del medicamento. Puede ser comprimido, gotas o suspension");
		do {
			respuesta=teclado.next();
			respuesta=respuesta.toUpperCase();
			try {
				presentacion=Presentacion.valueOf(respuesta);
				datoValido=true;
			}catch(Exception e) {
				System.out.println("Presentacion introducida no valida, intentelo de nuevo");
				datoValido=false;
			}
		}while(!datoValido);
		return presentacion;
    }
    public static int anioValido() {
    	boolean datoNoValido=true;
    	int anio=0;
    	do {
    		System.out.println("Introduzca un anio");
        	anio=teclado.nextInt();
        	YEAR.checkValidValue(anio);
        	datoNoValido=false;
    	}while(datoNoValido||anio<=0);
    	return anio;
    }
    public static int mesValido() {
    	boolean datoNoValido=true;
    	int mes=0;
    	do {
    		try {
    			System.out.println("Introduzca un mes");
            	mes=teclado.nextInt();
            	MONTH_OF_YEAR.checkValidValue(mes);
            	datoNoValido=false;
    		}catch(DateTimeException e) {
    			System.out.println("Mes no valido");
    		}
    		
    	}while(datoNoValido);
    	return mes;
    }
    public static int diaValido() {
    	boolean datoNoValido=true;
    	int dia=0;
    	do {
    		try {
    			System.out.println("Introduzca un dia");
            	dia=teclado.nextInt();
            	DAY_OF_MONTH.checkValidValue(dia);
            	datoNoValido=false;
    		}catch(DateTimeException e) {
    			System.out.println("dia no valido");
    		}
    		
    	}while(datoNoValido);
    	return dia;
    	
    }
    public static LocalDate esFechaValida(){
        boolean esFechaNoValida = true;
        LocalDate fecha=null;
        do {
	        try{
	            fecha=LocalDate.of(anioValido(), mesValido(), diaValido());
	            esFechaNoValida = false;
	        }catch(DateTimeException e) {
	           System.out.println("Fecha introducida no valida");
	        }
        }while(esFechaNoValida);
        return fecha;
    }

}
