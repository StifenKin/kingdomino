package kingdomino;

public class Ficha implements Comparable<Ficha> {

	private int numeroFicha;
	private Territorio cuadroIzquierdo;
	private Territorio cuadroDerecho;
	private boolean numeroHaciaArriba = true;
	private int posicion = 0;
	private int elegida = -1;

	public Ficha(Territorio cuadroIzq, Territorio cuadroDer, int contadorDeFichas) {
		this.cuadroIzquierdo = cuadroIzq;
		this.cuadroDerecho = cuadroDer;
		this.numeroFicha = contadorDeFichas;
	}

	public void rotarFicha() {
		// posicion = 0 -> horizontal; cuadroIzq y cuadroDer normales
		// posicion = 1 -> vertical; cuadroIzq hacia abajo y cuadroDer hacia arriba
		// posicion = 2 -> horizontal; cuadroIzq y cuadroDer invertidos (de cabeza)
		// posicion = 3 -> vertical; cuadroIzq hacia arriba y cuadroDer hacia abajo

		if (this.posicion == 3)
			this.posicion = 0;
		else
			this.posicion++;
	}

	public void voltearFicha() {
		this.numeroHaciaArriba = !this.numeroHaciaArriba;
	}

	public boolean isNumeroHaciaArriba() {
		return numeroHaciaArriba;
	}

	public void setNumeroHaciaArriba(boolean numeroHaciaArriba) {
		this.numeroHaciaArriba = numeroHaciaArriba;
	}

	public int getNumeroFicha() {
		return numeroFicha;
	}

	public int getPosicion() {
		return posicion;
	}

	public Territorio getCuadroIzquierdo() {
		return cuadroIzquierdo;
	}

	public Territorio getCuadroDerecho() {
		return cuadroDerecho;
	}

	public int getElegida() {
		return elegida;
	}

	public void setElegida(int elegida) {
		this.elegida = elegida;
	}

	@Override
	public int compareTo(Ficha otra) {
		return this.numeroFicha - otra.numeroFicha;
	}

	@Override
	public String toString() {
		return "Ficha [numeroFicha=" + numeroFicha + "]";
	}

}
