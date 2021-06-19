package kingdomino;

import java.util.ArrayList;

public class Partida {

	private ArrayList<Rey> reyes = new ArrayList<Rey>();
	private Mazo mazoPartida;

	public Ronda prepararPartida(SalaDeJuego sala) {
		this.mazoPartida = Mazo.getInstance();
		this.mazoPartida.mezclarMazo();
		this.mazoPartida.descartarFichas(sala.getCantJugadores());
		this.iniciarTablero(sala);
		this.iniciarReyes(sala);
		Ronda ronda1 = new Ronda(1);
		ronda1.setFichasDeRonda(this.mazoPartida.repartirFichas(sala.getCantJugadores()));
		return ronda1;
	}

	private void iniciarTablero(SalaDeJuego sala) {
		for (int i = 0; i < sala.getCantJugadores(); i++) {
			sala.getJugadores().get(i).setTablero(new Tablero());
		}
	}

	public void iniciarReyes(SalaDeJuego sala) {
		int contadorDeReyes = 0;
		if (sala.getCantJugadores() == 2) {
			for (int i = 0; i < sala.getCantJugadores(); i++) {
				sala.getJugadores().get(i).setRey1(new Rey(contadorDeReyes++));
				this.reyes.add(sala.getJugadores().get(i).getRey1());
				sala.getJugadores().get(i).setRey2(new Rey(contadorDeReyes++));
				this.reyes.add(sala.getJugadores().get(i).getRey2());
			}
		} else {
			for (int i = 0; i < sala.getCantJugadores(); i++) {
				sala.getJugadores().get(i).setRey1(new Rey(contadorDeReyes++));
				this.reyes.add(sala.getJugadores().get(i).getRey1());
			}
		}

	}

	public ArrayList<Integer> sortearReyes(int cantJugadores) {
		ArrayList<Integer> ordenReyes = new ArrayList<Integer>();
		if (cantJugadores == 3) {
			for (int i = 0; i < 3; i++) {
				int valor;
				do {
					valor = (int) Math.floor(Math.random() * 2);
				} while (ordenReyes.contains(valor));
				ordenReyes.add(valor);
			}
		} else {
			for (int i = 0; i < 4; i++) {
				int valor;
				do {
					valor = (int) Math.floor(Math.random() * 3);
				} while (ordenReyes.contains(valor));
				ordenReyes.add(valor);
			}
		}
		return ordenReyes;
	}

	public void designarGanador(SalaDeJuego sala) {

		if(sala.getCantJugadores() == 1) {
			System.out.println("GANADOR \n Felicitaciones Jugador: tus oponentes dejaron la partida! \n"
					+ sala.getJugadores().get(0).getNombreJugador());
		}
		
		boolean empate = false;
		ArrayList<Integer> jugadorMayorPuntaje = new ArrayList<Integer>();
		int mayorPuntaje = 0;

		for (int i = 0; i < sala.getCantJugadores(); i++) {
			int puntaje = sala.getJugadores().get(i).getTablero().calcularPuntaje();
			sala.getJugadores().get(i).setPuntaje(puntaje);

			if (puntaje > mayorPuntaje) {
				jugadorMayorPuntaje = new ArrayList<Integer>();
				jugadorMayorPuntaje.add(i);
				mayorPuntaje = puntaje;
				empate = false;
			} else if (puntaje == mayorPuntaje) {
				jugadorMayorPuntaje.add(i);
				empate = true;
			}
		}

		ArrayList<Integer> jugadorMayorTerritorio = new ArrayList<Integer>();
		if (empate == true) {
			empate = false;
			int mayorTerritorio = 0;

			for (int i = 0; i < jugadorMayorPuntaje.size(); i++) {
				int territorio = sala.getJugadores().get(jugadorMayorPuntaje.get(i)).getTablero()
						.getTerritorioMasGrande();

				if (territorio > mayorTerritorio) {
					jugadorMayorTerritorio = new ArrayList<Integer>();
					jugadorMayorTerritorio.add(i);
					mayorTerritorio = territorio;
					empate = false;
				} else if (territorio == mayorTerritorio) {
					jugadorMayorTerritorio.add(i);
					empate = true;
				}
			}
			if (jugadorMayorTerritorio.size() == 1)
				System.out.println("GANADOR \n Felicitaciones Jugador, tuviste el territorio más grande! \n"
						+ sala.getJugadores().get(jugadorMayorTerritorio.get(0)).getNombreJugador());
			else {
				System.out.println("EMPATE Felicitaciones Jugadores: ");
				for (int i = 0; i < jugadorMayorTerritorio.size(); i++) {
					System.out.println(sala.getJugadores().get(jugadorMayorTerritorio.get(i)).getNombreJugador());
				}
			}
		}
		else {
			System.out.println("GANADOR \n Felicitaciones Jugador, tuviste el mejor puntaje! \n"
					+ sala.getJugadores().get(jugadorMayorPuntaje.get(0)).getNombreJugador());
		}

	}

	public Mazo getMazoPartida() {
		return mazoPartida;
	}

	public ArrayList<Rey> getReyes() {
		return reyes;
	}

}
