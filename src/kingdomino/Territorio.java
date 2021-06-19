package kingdomino;

public class Territorio {

	private String tipo;
	private int corona;
	private boolean puntuado = false;
	
	public Territorio(String tipo, int corona) {
		this.tipo = tipo;
		this.corona = corona;
	}
	
	public boolean compararTerritorio(Territorio otroTerritorio) {
		return this.tipo == otroTerritorio.tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public int getCorona() {
		return corona;
	}

	public boolean isPuntuado() {
		return puntuado;
	}

	public void setPuntuado(boolean puntuado) {
		this.puntuado = puntuado;
	}
	
}
