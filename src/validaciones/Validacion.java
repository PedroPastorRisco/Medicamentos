package validaciones;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.MONTH_OF_YEAR;
import static java.time.temporal.ChronoField.YEAR;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import enumerados.Material;
import enumerados.ParteCuerpo;
import enumerados.Presentacion;

public class Validacion {
private static Scanner teclado = new Scanner(System.in);
private static Scanner tecladoInt=new Scanner(System.in);
	
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
	public static double leerPrecio() {
		double precio;
		boolean precioValido=false;
		do {
			System.out.println("Ingrese el precio");
			precio=tecladoInt.nextDouble();
			if(precio>0) {
				precioValido=true;
			}
		}while(!precioValido);
		return precio;
	}
	/**
	 * Cabecera: public static String leerPrincipioActivo()<br>
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
	 *  <br>principioActivo<br>
     */
	public static String leerPrincipioActivo() {
		String principioActivo;
		System.out.println("Ingrese el principio activo");
		principioActivo=teclado.next();
    	return principioActivo;
	}
	/**
     * Cabecera: public static Material obtenerMaterial() <br>
     * Comentario: Este metodo se encarga de leer una cadena y validar que sea igual a uno de los enum correspondientes a Material<br>
     * Precondciones: ninguna</br>
     * Postcondiciones: nos devuelve un valor que vale para un enum</br>
     * entrada: ninguna</br>
     * salida:Material materialo</br>
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
     * Cabecera: public static ParteCuerpo obtenerParteCuerpo() <br>
     * Comentario: Este metodo se encarga de leer una cadena y validar que sea igual a uno de los enum correspondientes a ParteCuerpo<br>
     * Precondciones: ninguna</br>
     * Postcondiciones: nos devuelve un valor que vale para un enum</br>
     * entrada: ninguna</br>
     * salida:ParteCuerpo parteCuerpo</br>
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
     * Cabecera: public static Presentacion obtenerPresentacion() <br>
     * Comentario: Este metodo se encarga de leer una cadena y validar que sea igual a uno de los enum correspondientes a Presentacion<br>
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
    
    /**
     * Cabecera: public static int anioValido()<br>
     * Comentario: Este metodo se encarga de leer un anio y validarlo, el anio tiene que ser mayor que 0.<br>
     * Precondiciones: No introducir un valor que no sea un int <br>
     * Postcondiciones: Devuelve un año valido <br>
     * entrada: ninguna <br>
     * salida: int anio<br>
     * @return int anio<br>
     * 
     */
    
    public static int anioValido() {
    	boolean datoNoValido=true;
    	int anio=0;
    	do {
    		System.out.println("Introduzca un anio");
            anio=tecladoInt.nextInt();
            YEAR.checkValidValue(anio);
            datoNoValido=false;
    	}while(datoNoValido||anio<=0);
    	return anio;
    }
    
    /**
     * Cabecera: public static int mesValido()<br>
     * Comentario: Este metodo se encarga de leer un mes y validarlo, el mes tiene que estar entre 1 y 12<br>
     * Precondiciones: No introducir un valor que no sea un int  <br>
     * Postcondiciones: Devuelve un mes valido <br>
     * entrada: ninguna <br>
     * salida: int mes<br>
     * @return int mes<br>
     * 
     */
    public static int mesValido() {
    	boolean datoNoValido=true;
    	int mes=0;
    	do {
    		try {
    			System.out.println("Introduzca un mes");
            	mes=tecladoInt.nextInt();
            	MONTH_OF_YEAR.checkValidValue(mes);
            	datoNoValido=false;
    		}catch(DateTimeException e) {
    			System.out.println("Mes no valido");
    		}
    	}while(datoNoValido);
    	return mes;
    }
    /**
     * Cabecera: public static int diaValido() <br>
     * Comentario: Este metodo se encarga de leer un dia y validarlo, el dia tiene que estar entre 1 y 31<br>
     * Precondiciones: No introducir un valor que no sea un int <br>
     * Postcondiciones: Devuelve un dia valido <br>
     * entrada: ninguna <br>
     * salida: int dia<br>
     * @return int dia<br>
     * 
     */
    public static int diaValido() {
    	boolean datoNoValido=true;
    	int dia=0;
    	do {
    		try {
    			System.out.println("Introduzca un dia");
            	dia=tecladoInt.nextInt();
            	DAY_OF_MONTH.checkValidValue(dia);
            	datoNoValido=false;
    		}catch(DateTimeException e) {
    			System.out.println("dia no valido");
    		}
    	}while(datoNoValido);
    	return dia;
    	
    }
    
   /**
    * Cabecera: public static LocalDate esFechaValida()<br>
    * Comentario: Este metodo valida que una fecha en su conjunto sea correcta, para ello primero valida cada dato por separado y luego hace una valoracion en común. <br>
    * precondiciones: Ninguna<br>
    * postcondiciones: Devuelve una fecha valida<br>
    * Entrada: ninguna<br>
    * Salida: LocalDate fecha<br>
    * @return LocalDate fecha <br>
    */
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
