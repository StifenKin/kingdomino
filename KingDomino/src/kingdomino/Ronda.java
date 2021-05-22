package kingdomino;

import java.util.ArrayList;
import java.util.Collections;

public class Ronda {

	private int numeroDeRonda;
	private ArrayList<Ficha> fichasDeRonda = new ArrayList<Ficha>();
	private ArrayList<Integer> ordenTurnos = new ArrayList<Integer>();

	public Ronda() {
	}

	public Ronda(int numeroDeRonda) {
		this.numeroDeRonda = numeroDeRonda;
	}

	public Ronda jugarPrimeraRonda(SalaDeJuego sala) {
		Collections.sort(this.fichasDeRonda);
		this.voltearFichasDeRonda();
		this.ordenTurnos = sala.getPartida().sortearReyes(sala.getCantJugadores());
		ArrayList<Integer> nuevosTurnos = new ArrayList<Integer>();
		if (sala.getCantJugadores() == 2) {
			int[] nuevoOrden = new int[4];
			for (int i = 0; i < ordenTurnos.size(); i++) {
				int rey = ordenTurnos.get(i);
				if (rey == 0 || rey == 1) {
					int orden = sala.getJugadores().get(0).colocarRey(sala.getPartida().getReyes().get(rey),
							this.fichasDeRonda);
					nuevoOrden[orden] = rey;
				}
				if (rey == 2 || rey == 3) {
					int orden = sala.getJugadores().get(1).colocarRey(sala.getPartida().getReyes().get(rey),
							this.fichasDeRonda);
					nuevoOrden[orden] = rey;
				}
			}
			nuevosTurnos = asignarNuevosTurnos(nuevoOrden);
		} else {
			int[] nuevoOrden = new int[sala.getCantJugadores()];
			for (int i = 0; i < ordenTurnos.size(); i++) {
				int rey = ordenTurnos.get(i);
				int orden = sala.getJugadores().get(rey).colocarRey(sala.getPartida().getReyes().get(rey),
						this.fichasDeRonda);
				nuevoOrden[orden] = rey;
			}
			nuevosTurnos = asignarNuevosTurnos(nuevoOrden);
		}
		this.ordenTurnos = nuevosTurnos;
		Ronda ronda2 = new Ronda(this.numeroDeRonda + 1);
		ronda2.fichasDeRonda = sala.getPartida().getMazoPartida().repartirFichas(sala.getCantJugadores());
		Collections.sort(ronda2.fichasDeRonda);
		ronda2.voltearFichasDeRonda();
		nuevosTurnos = jugarTurno(sala, ronda2);
		ronda2.ordenTurnos = nuevosTurnos;
		return ronda2;
	}

	public Ronda jugarRonda(SalaDeJuego sala) {
		Ronda ronda = new Ronda(this.numeroDeRonda + 1);
		ronda.fichasDeRonda = sala.getPartida().getMazoPartida().repartirFichas(sala.getCantJugadores());
		Collections.sort(ronda.fichasDeRonda);
		ronda.voltearFichasDeRonda();
		ArrayList<Integer> nuevosTurnos = new ArrayList<Integer>();
		nuevosTurnos = jugarTurno(sala, ronda);
		ronda.ordenTurnos = nuevosTurnos;
		return ronda;
	}

	public void jugarUltimaRonda(SalaDeJuego sala) {
		for (int i = 0; i < this.ordenTurnos.size(); i++) {
			sala.getJugadores().get(this.ordenTurnos.get(i)).colocarFicha(this.fichasDeRonda.get(i));
		}
	}

	private ArrayList<Integer> asignarNuevosTurnos(int[] nuevoOrden) {
		ArrayList<Integer> nuevosTurnos = new ArrayList<Integer>();
		for (int i = 0; i < nuevoOrden.length; i++) {
			nuevosTurnos.add(nuevoOrden[i]);
		}
		return nuevosTurnos;
	}

	private ArrayList<Integer> jugarTurno(SalaDeJuego sala, Ronda ronda) {
		ArrayList<Integer> nuevosTurnos;
		if (sala.getCantJugadores() == 2) {
			int[] nuevoOrden = new int[4];
			for (int i = 0; i < ordenTurnos.size(); i++) {
				sala.getJugadores().get(this.ordenTurnos.get(i)).colocarFicha(this.fichasDeRonda.get(i));
				int rey = ordenTurnos.get(i);
				if (rey == 0 || rey == 1) {
					int orden = sala.getJugadores().get(0).colocarRey(sala.getPartida().getReyes().get(rey),
							ronda.fichasDeRonda);
					nuevoOrden[orden] = rey;
				}
				if (rey == 2 || rey == 3) {
					int orden = sala.getJugadores().get(1).colocarRey(sala.getPartida().getReyes().get(rey),
							ronda.fichasDeRonda);
					nuevoOrden[orden] = rey;
				}
			}
			nuevosTurnos = asignarNuevosTurnos(nuevoOrden);
		} else {
			int[] nuevoOrden = new int[sala.getCantJugadores()];
			for (int i = 0; i < ordenTurnos.size(); i++) {
				int rey = ordenTurnos.get(i);
				int orden = sala.getJugadores().get(rey).colocarRey(sala.getPartida().getReyes().get(rey),
						ronda.fichasDeRonda);
				nuevoOrden[orden] = rey;
			}
			nuevosTurnos = asignarNuevosTurnos(nuevoOrden);
		}
		return nuevosTurnos;
	}

	private void voltearFichasDeRonda() {
		for (int i = 0; i < this.fichasDeRonda.size(); i++) {
			this.fichasDeRonda.get(i).setNumeroHaciaArriba(false);
		}
	}

	public void setFichasDeRonda(ArrayList<Ficha> fichasDeRonda) {
		this.fichasDeRonda = fichasDeRonda;
	}

}
