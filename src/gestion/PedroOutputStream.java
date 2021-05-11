package gestion;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class PedroOutputStream extends ObjectOutputStream{
	
	protected PedroOutputStream() throws IOException {
		super();
	}

	
	public PedroOutputStream(OutputStream out) throws IOException {
		super(out);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void writeStreamHeader() throws IOException
	{
	// No hacer nada.
	}

}
