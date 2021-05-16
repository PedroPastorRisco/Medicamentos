package enumerados;


public enum ParteCuerpo{CARA('C'),MANOS('M'),OJOS('O');
	
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
