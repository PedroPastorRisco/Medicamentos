package enumerados;

import java.io.Serializable;

public enum ParteCuerpo implements Serializable {CARA('C'),MANOS('M'),OJOS('O');
	
	private char abreviacion;
	
	private ParteCuerpo(char abreviacion) {
		this.abreviacion=abreviacion;
	}

	public char getAbreviacion() {
		return abreviacion;
	}

	public void setAbreviacion(char abreviacion) {
		this.abreviacion = abreviacion;
	}
	

}
