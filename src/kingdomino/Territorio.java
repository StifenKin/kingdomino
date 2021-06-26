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
		if (otroTerritorio.tipo == "Castillo")
			return true;
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

	public int getImagenTerreno() {
		if (this.tipo == "Castillo")
			return 0;
		if (this.tipo == "pradera") {
			if (this.corona == 0)
				return 1;
			if (this.corona == 1)
				return 2;
			if (this.corona == 2)
				return 3;
		}
		if (this.tipo == "campo") {
			if (this.corona == 0)
				return 4;
			if (this.corona == 1)
				return 5;
		}
		if (this.tipo == "lago") {
			if (this.corona == 0)
				return 6;
			if (this.corona == 1)
				return 7;
		}
		if (this.tipo == "bosque") {
			if (this.corona == 0)
				return 8;
			if (this.corona == 1)
				return 9;
		}
		if (this.tipo == "mina") {
			if (this.corona == 0)
				return 10;
			if (this.corona == 1)
				return 11;
			if (this.corona == 2)
				return 12;
			if (this.corona == 3)
				return 13;
		}
		if (this.tipo == "pantano") {
			if (this.corona == 0)
				return 14;
			if (this.corona == 1)
				return 15;
			if (this.corona == 2)
				return 16;
		}
		return -1;
	}

}
