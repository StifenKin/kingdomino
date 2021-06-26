package kingdomino;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Mazo {

	private List<Ficha> mazo = new ArrayList<Ficha>();
	private static Mazo instance;

	private Mazo() {
		final String campo = "campo";
		final String lago = "lago";
		final String mina = "mina";
		final String bosque = "bosque";
		final String pradera = "pradera";
		final String pantano = "pantano";

		int contadorDeFichas = 1;

		this.mazo.add(new Ficha(new Territorio(campo, 0), new Territorio(campo, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(mina, 2), new Territorio(campo, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(mina, 1), new Territorio(campo, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(campo, 0), new Territorio(mina, 3), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(campo, 0), new Territorio(pantano, 2), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(campo, 1), new Territorio(pantano, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(campo, 0), new Territorio(lago, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(lago, 1), new Territorio(campo, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(campo, 1), new Territorio(lago, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(lago, 1), new Territorio(campo, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(campo, 1), new Territorio(mina, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(campo, 0), new Territorio(campo, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(pantano, 0), new Territorio(mina, 2), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(pantano, 0), new Territorio(mina, 2), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(pantano, 0), new Territorio(pantano, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(pradera, 0), new Territorio(pantano, 1), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(pradera, 0), new Territorio(pantano, 2), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(lago, 0), new Territorio(lago, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(lago, 1), new Territorio(bosque, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(lago, 1), new Territorio(bosque, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(bosque, 1), new Territorio(campo, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(bosque, 1), new Territorio(campo, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(campo, 0), new Territorio(pantano, 1), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(campo, 0), new Territorio(pantano, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(pradera, 0), new Territorio(pradera, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(lago, 0), new Territorio(lago, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(lago, 1), new Territorio(bosque, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(lago, 1), new Territorio(bosque, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(campo, 1), new Territorio(bosque, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(campo, 0), new Territorio(bosque, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(campo, 0), new Territorio(pradera, 1), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(campo, 1), new Territorio(pradera, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(campo, 0), new Territorio(pradera, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(pradera, 0), new Territorio(pradera, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(lago, 0), new Territorio(pradera, 2), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(lago, 0), new Territorio(lago, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(bosque, 0), new Territorio(lago, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(bosque, 1), new Territorio(lago, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(bosque, 0), new Territorio(bosque, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(bosque, 1), new Territorio(campo, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(bosque, 1), new Territorio(campo, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(bosque, 0), new Territorio(bosque, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(campo, 0), new Territorio(pradera, 2), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(bosque, 0), new Territorio(pradera, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(bosque, 1), new Territorio(pradera, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(lago, 0), new Territorio(pradera, 1), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(bosque, 0), new Territorio(bosque, 0), contadorDeFichas++));
		this.mazo.add(new Ficha(new Territorio(bosque, 0), new Territorio(bosque, 0), contadorDeFichas++));

	}

	public static Mazo getInstance() {
		if (instance == null) {
			instance = new Mazo();
		}
		return instance;
	}

	public void mezclarMazo() {
		Collections.shuffle(mazo);
	}

	public void descartarFichas(int cantJugadores) {
		// las fichas que se descartan son las últimas del mazo (últimas de Array;
		// primero debería mezclarse el mazo por lo que no se descartarían siempre las
		// mismas fichas)
		int cantFichas = 0;

		if (cantJugadores == 2)
			cantFichas = 24;
		else if (cantJugadores == 3)
			cantFichas = 12;

		for (int i = 0; i < cantFichas; i++) {
			mazo.remove(mazo.size() - 1);
		}
	}

	public ArrayList<Ficha> repartirFichas(int cantidadDeJugadores) {
		ArrayList<Ficha> fichasRonda = new ArrayList<Ficha>();
		int cantidadDeFichas;

		if (cantidadDeJugadores == 3)
			cantidadDeFichas = 3;
		else
			cantidadDeFichas = 4;

		for (int i = 0; i < cantidadDeFichas; i++) {
			fichasRonda.add(this.mazo.get(0));
			this.mazo.remove(0);
		}
		return fichasRonda;
	}

	public Ficha getFicha(int posicionDeFicha) {
		return mazo.get(posicionDeFicha);
	}

	public List<Ficha> getMazo() {
		return mazo;
	}

}
