package kingdomino;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import InterfazGrafica.VentanaPartida;

public class Jugador {

	private String nombreJugador;
	private int numeroId;
	private String color;
	private int puntaje;
	private Tablero tablero;
//	private Rey rey1;
//	private Rey rey2;

	public Jugador(String nombre, int numeroId, String color) {
		this.nombreJugador = nombre;
		this.numeroId = numeroId;
		this.color = color;
	}

	public SalaDeJuego crearSalaDeJuego(String nombre) {
		SalaDeJuego sala = new SalaDeJuego(nombre);
		this.ingresarASalaDeJuego(sala);
		return sala;
	}

	public void ingresarASalaDeJuego(SalaDeJuego sala) {
		if (sala.isEstado() == true)
			System.out.println("La sala ya inició su partida. No se puede ingresar");
		else if (sala.admitirJugador(this) == false)
			System.out.println("La sala está completa. No se puede ingresar");
	}

	public void salirDeLaSala(SalaDeJuego sala) {
		sala.eliminarJugador(this);
	}

	// cualquier jugador puede iniciar una partida (siempre que haya al menos otro
	// jugador en la sala con él)
	public void iniciarPartida(SalaDeJuego sala) {
		sala.crearPartida();
	}

	public int colocarRey(int nroJugador, ArrayList<Ficha> fichasDeRonda, VentanaPartida ventana) {
		int numeroDeFicha = -1;
		do {
			numeroDeFicha = ventana.traerFichaElegida();

		} while (fichasDeRonda.get(numeroDeFicha).getElegida() != -1);

		if (fichasDeRonda.get(numeroDeFicha).getElegida() == -1) {
			fichasDeRonda.get(numeroDeFicha).setElegida(nroJugador);
			ventana.repaint();
		}
		return numeroDeFicha;
	}

	public void colocarFicha(Ficha ficha, int turno, VentanaPartida ventana) {
		int fila, columna;
		int[] coordenadas = new int[2];
		boolean fichaColocada = false;
		do {
			coordenadas = ventana.traerPosicionElegida();
			fila = coordenadas[0];
			columna = coordenadas[1];

			if (fila != -1 && columna != -1) {
				int filaAdy = fila, columnaAdy = columna;
				if (ficha.getPosicion() == 0)
					columnaAdy++;
				if (ficha.getPosicion() == 1)
					filaAdy--;
				if (ficha.getPosicion() == 2)
					columnaAdy--;
				if (ficha.getPosicion() == 3)
					filaAdy++;

				if (validarPosicion(fila, columna) == true && validarPosicion(filaAdy, columnaAdy) == true) {
					if (validarTerrenosAdyacentes(fila, columna, ficha.getCuadroIzquierdo()) == true
							|| validarTerrenosAdyacentes(filaAdy, columnaAdy, ficha.getCuadroDerecho()) == true) {
						this.tablero.setTablero(fila, columna, ficha.getCuadroIzquierdo());
						this.tablero.setTablero(filaAdy, columnaAdy, ficha.getCuadroDerecho());
						this.tablero.redefinirLimitesDeTablero();
						ventana.actualizarTablero(turno);
						ventana.terminarTurno();
						fichaColocada = true;
					} else
						JOptionPane.showMessageDialog(null, "Los territorios adyacentes no coinciden",
								"Posición Incorrecta", JOptionPane.INFORMATION_MESSAGE, null);
				}
			} else {
				fichaColocada = true;
				JOptionPane.showMessageDialog(null, "Descartaste tu ficha. Terminá tu turno", "Descarte",
						JOptionPane.INFORMATION_MESSAGE, null);
				ventana.terminarTurno();
			}

		} while (fichaColocada == false);
	}

	private boolean validarTerrenosAdyacentes(int fila, int columna, Territorio territorio) {
		if (fila - 1 >= this.tablero.getFilaMin()) {
			if (territorio.compararTerritorio(this.tablero.getTablero(fila - 1, columna)) == true) {
				return true;
			}
		}

		if (fila + 1 <= this.tablero.getFilaMax()) {
			if (territorio.compararTerritorio(this.tablero.getTablero(fila + 1, columna)) == true) {
				return true;
			}
		}

		if (columna - 1 >= this.tablero.getColumnaMin()) {
			if (territorio.compararTerritorio(this.tablero.getTablero(fila, columna - 1)) == true) {
				return true;
			}
		}

		if (columna + 1 <= this.tablero.getColumnaMax()) {
			if (territorio.compararTerritorio(this.tablero.getTablero(fila, columna + 1)) == true) {
				return true;
			}
		}

		return false;
	}

	private boolean validarPosicion(int fila, int columna) {
		if (this.tablero.getFilaMin() > fila || fila > this.tablero.getFilaMax()
				|| this.tablero.getColumnaMin() > columna || columna > this.tablero.getColumnaMax()) {
			JOptionPane.showMessageDialog(null, "La posición está fuera de los límites", "Posición Incorrecta",
					JOptionPane.INFORMATION_MESSAGE, null);
			return false;
		}
		if (this.tablero.getTablero(fila, columna).getTipo() != "Vacio") {
			JOptionPane.showMessageDialog(null, "La posición ya tiene una ficha asignada", "Posición Incorrecta",
					JOptionPane.INFORMATION_MESSAGE, null);
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Jugador " + nombreJugador + "\t Id " + numeroId + "\t color " + color + "\t puntaje " + puntaje;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public int getNumeroId() {
		return numeroId;
	}

	public String getColor() {
		return color;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

//	public void setRey1(Rey rey1) {
//		this.rey1 = rey1;
//	}
//
//	public void setRey2(Rey rey2) {
//		this.rey2 = rey2;
//	}
//
//	public Rey getRey1() {
//		return rey1;
//	}
//
//	public Rey getRey2() {
//		return rey2;
//	}

}
