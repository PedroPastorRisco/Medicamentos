package principal;

import java.time.LocalDate;

import clasesPrincipales.Medicamento;
import enumerados.Presentacion;
import gestion.FileAccess;
import gestion.Gestora;
import mensaje.Mensaje;
import validaciones.Validacion;

public class Main {

	public static void main(String[] args) {
		
		Mensaje.mostrarResultado(FileAccess.crearFicheros());
		Medicamento ibuprofeno600=new Medicamento("1234567890qwertyuiop", "Ibuprofeno", LocalDate.parse("2018-12-27"), 10,Presentacion.COMPRIMIDO, "Ibuprofeno");
		Medicamento paracetamol=new Medicamento("7689009876hjklñgfdsa", "Paracetamol", LocalDate.parse("2018-12-26"), 10,Presentacion.COMPRIMIDO, "Paracetamol");
		Medicamento gotas=new Medicamento("1234dfwfqgqgq23rtgfd", "Gotas", LocalDate.parse("2018-12-24"), 10,Presentacion.GOTAS, "Gotas");
		Medicamento bucola=new Medicamento("768aw224dfwf11223456", "bucola", LocalDate.parse("2018-12-10"), 10,Presentacion.SUSPENSION, "Bucal");
		System.out.println();
		System.out.println("--Introduzco los objetos en el fichero y los muestro");
		System.out.println();
		FileAccess.escribirFicheroBinario(ibuprofeno600,FileAccess.NOMBRE_FICHERO);
		FileAccess.escribirFicheroBinario(paracetamol, FileAccess.NOMBRE_FICHERO);
		FileAccess.escribirFicheroBinario(gotas, FileAccess.NOMBRE_FICHERO);
		FileAccess.escribirFicheroBinario(bucola, FileAccess.NOMBRE_FICHERO);
		Mensaje.leerArrayObjeto(FileAccess.leerFichero(FileAccess.NOMBRE_FICHERO));
		System.out.println();
		System.out.println("--Ordeno los objetos en el fichero y los muestro");
		System.out.println();
		FileAccess.ordenarFichero(FileAccess.NOMBRE_FICHERO);
		Mensaje.leerArrayObjeto(FileAccess.leerFichero(FileAccess.NOMBRE_FICHERO));
		System.out.println();
		System.out.println("--Elimino las gotas y vuelvo a mostrar el fichero");
		System.out.println();
		FileAccess.eliminarProducto("1234dfwfqgqgq23rtgfd");
		FileAccess.cambioFichero();
		Mensaje.leerArrayObjeto(FileAccess.leerFichero(FileAccess.NOMBRE_FICHERO));
		System.out.println();
		Mensaje.mostrarResultado(FileAccess.crearFicheros());
		System.out.println();
		System.out.println("--Modifico el ibuprofeno cambiandole el precio");
		System.out.println();
		FileAccess.modificarProducto(Gestora.crearMedicamento());
		FileAccess.cambioFichero();
		Mensaje.leerArrayObjeto(FileAccess.leerFichero(FileAccess.NOMBRE_FICHERO));
		
	}

}
