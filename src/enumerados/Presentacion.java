package enumerados;

import java.io.Serializable;

public enum Presentacion implements Serializable { COMPRIMIDO('C'),GOTAS('G'),SUSPENSION('S');
	
	private char abreviatura;
	
	private Presentacion(char abreviatura) {
		this.abreviatura=abreviatura;
	}

	public char getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(char abreviatura) {
		this.abreviatura = abreviatura;
	}

}
