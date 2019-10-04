package ejbs;

import javax.ejb.Singleton;

@Singleton
public class ContadorEjbImpl implements ContadorEjb {
	private int valor=0;

	@Override
	public void incrementar() {
		valor++;
	}

	@Override
	public void decrementar() {
		valor--;
	}

	@Override
	public int getValor() {
		return valor;		
	}

}
