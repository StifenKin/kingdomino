package kingdomino;

import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {

	private String nombreJugador;
	private int numeroId;
	private String color;
	private int puntaje;
	private Tablero tablero;
	private Rey rey1;
	private Rey rey2;

	public Jugador(String nombre, int numeroId) {
		this.nombreJugador = nombre;
		this.numeroId = numeroId;
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

	public int colocarRey(Rey rey, ArrayList<Ficha> fichasDeRonda) {
		Scanner scanner = new Scanner(System.in);
		int numeroDeFicha;
		do {
			numeroDeFicha = scanner.nextInt();
		}while(fichasDeRonda.get(numeroDeFicha).isElegida());
		scanner.close();
		
		rey.setCarta(fichasDeRonda.get(numeroDeFicha).getNumeroFicha());
		return numeroDeFicha;
	}

	public void colocarFicha(Ficha ficha) {
		Scanner scanner = new Scanner(System.in);
		int fila = scanner.nextInt();
		int columna = scanner.nextInt();
		scanner.close();
		
		int filaAdy = fila, columnaAdy = columna;
		if (ficha.getPosicion() == 0)
			columnaAdy++;
		if (ficha.getPosicion() == 1)
			filaAdy--;
		if (ficha.getPosicion() == 2)
			columnaAdy--;
		if (ficha.getPosicion() == 3)
			filaAdy++;
		
		if (validarPosicion(fila, columna) && validarPosicion(filaAdy, columnaAdy)) {
			if (validarTerrenosAdyacentes(fila, columna) || validarTerrenosAdyacentes(filaAdy, columnaAdy)) {
				this.tablero.redefinirLimitesDeTablero();
				this.tablero.setTablero(fila, columna, ficha.getCuadroIzquierdo());
				this.tablero.setTablero(filaAdy, columnaAdy, ficha.getCuadroDerecho());
			}
		}
	}

	private boolean validarTerrenosAdyacentes(int fila, int columna) {
		if (fila - 1 >= this.tablero.getFilaMin()) {
			if (this.tablero.getTablero(fila, columna)
					.compararTerritorio(this.tablero.getTablero(fila - 1, columna)) == false) {
				return false;
			}
		}

		if (fila + 1 <= this.tablero.getFilaMax()) {
			if (this.tablero.getTablero(fila, columna)
					.compararTerritorio(this.tablero.getTablero(fila + 1, columna)) == false) {
				return false;
			}
		}

		if (columna - 1 >= this.tablero.getColumnaMin()) {
			if (this.tablero.getTablero(fila, columna)
					.compararTerritorio(this.tablero.getTablero(fila, columna - 1)) == false) {
				return false;
			}
		}

		if (columna + 1 >= this.tablero.getColumnaMax()) {
			if (this.tablero.getTablero(fila, columna).compararTerritorio(this.tablero.getTablero(fila, columna + 1))) {
				return false;
			}
		}

		return true;
	}

	private boolean validarPosicion(int fila, int columna) {
		if (this.tablero.getFilaMin() > fila || fila > this.tablero.getFilaMax()
				|| this.tablero.getColumnaMin() > columna || columna > this.tablero.getColumnaMax()) {
			System.out.println("La posición está fuera de los límites");
			return false;
		}
		if (this.tablero.getTablero(fila, columna).getTipo() != "Vacio") {
			System.out.println("La posición ya tiene una ficha");
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

	public void setRey1(Rey rey1) {
		this.rey1 = rey1;
	}

	public void setRey2(Rey rey2) {
		this.rey2 = rey2;
	}

	public Rey getRey1() {
		return rey1;
	}

	public Rey getRey2() {
		return rey2;
	}

}
