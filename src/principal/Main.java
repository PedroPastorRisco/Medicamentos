package principal;

import java.time.LocalDate;

import clasesPrincipales.Medicamento;
import gestion.FileAccess;

public class Main {

	public static void main(String[] args) {
		boolean hola=true;
		String nombreFichero="Antipandemia.txt";
		Medicamento ibuprofeno600=new Medicamento("1234567890qwertyuiop", "Ibuprofeno", LocalDate.parse("2018-12-27"), 10,'C', "Ibuprofeno");
		FileAccess.escribirDefinitivoFichero(ibuprofeno600, nombreFichero);
		FileAccess.leerFichero(nombreFichero);
		System.out.println();
		while(hola) {
			FileAccess.escribirDefinitivoFichero(ibuprofeno600, nombreFichero);
			FileAccess.leerFichero(nombreFichero);
			hola=false;
		}
		
		
		
		

	}

}
