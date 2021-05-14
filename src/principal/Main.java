package principal;

import java.time.LocalDate;

import clasesPrincipales.Epi;
import clasesPrincipales.Medicamento;
import enumerados.Material;
import enumerados.ParteCuerpo;
import enumerados.Presentacion;
import gestion.FileAccess;
import mensaje.Mensaje;
import validaciones.Validacion;

public class Main {

	public static void main(String[] args) {
		String nombreFichero="Antipandemia.txt";
		Medicamento ibuprofeno600=new Medicamento("1234567890qwertyuiop", "Ibuprofeno", LocalDate.parse("2018-12-27"), 10,Presentacion.COMPRIMIDO, "Ibuprofeno");
		Medicamento paracetamol=new Medicamento("7689009876hjklñgfdsa", "Paracetamol", LocalDate.parse("2018-12-26"), 10,Presentacion.COMPRIMIDO, "Paracetamol");
		Epi mascarilla=new Epi("1234509876mnbvczxcvb", "mascarillafp2", LocalDate.parse("2018-11-27"), 2, ParteCuerpo.CARA, Material.TELA);
		Epi guante=new Epi("0192384756ñplokijuhy", "guante", LocalDate.parse("2013-11-27"), 5, ParteCuerpo.MANOS, Material.SILICONA);
		FileAccess.escribirFicheroBinario(ibuprofeno600, nombreFichero);
		FileAccess.escribirFicheroBinario(paracetamol, nombreFichero);
		FileAccess.escribirFicheroBinario(mascarilla, nombreFichero);
		FileAccess.escribirFicheroBinario(guante, nombreFichero);
		FileAccess.ordenarFichero(nombreFichero);
		Mensaje.leerArrayObjeto(FileAccess.leerFichero(nombreFichero));
		
		//Validacion.esFechaValida();
		
		
		

	}

}
