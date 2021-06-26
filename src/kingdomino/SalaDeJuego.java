package kingdomino;

import java.util.ArrayList;
import java.util.List;

import InterfazGrafica.VentanaPartida;

public class SalaDeJuego {

	private String nombreSala;
	private int cantJugadores = 0;
	private List<Jugador> jugadores = new ArrayList<Jugador>();
	private boolean estado = false; // se refiere a sí hay una partida iniciada
	private Partida partida;
	public VentanaPartida ventana;

	public SalaDeJuego(String nombre) {
		this.nombreSala = nombre;
	}

	public void mostrarJugadores() {
		System.out.println(this);
		System.out.println(this.jugadores);
	}

	public void mostrarJugador(Jugador jugador) {
		System.out.println(jugador);
	}

	public boolean admitirJugador(Jugador jugador) {
		if (this.cantJugadores < 4) {
			this.jugadores.add(jugador);
			this.cantJugadores++;
			return true;
		} else
			return false;
	}

	public void eliminarJugador(Jugador jugador) {
		this.jugadores.remove(jugador);
		this.cantJugadores--;

		if (this.cantJugadores == 1 && this.estado == true)
			getPartida().designarGanador(this);
	}

	public void crearPartida() {
		this.partida = new Partida();
		this.estado = true;
		this.jugarPartida();
	}

	public void jugarPartida() {
		ventana = new VentanaPartida(this);
		Ronda ronda = new Ronda();
		int cantRondas;
		if (cantJugadores == 2)
			cantRondas = 4;
		else
			cantRondas = 10;
		ronda = this.partida.prepararPartida(this);
		ronda = ronda.jugarPrimeraRonda(this);
		for (int i = 0; i < cantRondas; i++) {
			ronda = ronda.jugarRonda(this);
		}
		ronda.jugarUltimaRonda(this);
		this.partida.designarGanador(this);
	}

	public boolean isEstado() {
		return estado;
	}

	public Partida getPartida() {
		return partida;
	}

	public int getCantJugadores() {
		return cantJugadores;
	}

	public void setCantJugadores(int cantJugadores) {
		this.cantJugadores = cantJugadores;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public VentanaPartida getVentana() {
		return ventana;
	}

	public String getNombreSala() {
		return nombreSala;
	}

	@Override
	public String toString() {
		return "Sala De Juego " + nombreSala + "\t Cantidad de Jugadores" + cantJugadores;
	}

	public static void main(String[] args) {
		// Juego de 4 jugadores--------------
		SalaDeJuego sala = new SalaDeJuego("Sala De Prueba");
		Jugador jugador1 = new Jugador("Jugador1Rojo", 1, "Rojo");
		Jugador jugador2 = new Jugador("Jugador2Verde", 2, "Verde");
		Jugador jugador3 = new Jugador("Jugador3Azul", 3, "Azul");
		Jugador jugador4 = new Jugador("Jugador4Amarillo", 4, "Amarillo");
		jugador1.ingresarASalaDeJuego(sala);
		jugador2.ingresarASalaDeJuego(sala);
		jugador3.ingresarASalaDeJuego(sala);
		jugador4.ingresarASalaDeJuego(sala);
		jugador1.iniciarPartida(sala);
		// ----------------------------------

		// Juego de 3 jugadores--------------
//		SalaDeJuego sala = new SalaDeJuego("Sala De Prueba");
//		Jugador jugador1 = new Jugador("Jugador1Rojo", 1, "Rojo");
//		Jugador jugador2 = new Jugador("Jugador2Verde", 2, "Verde");
//		Jugador jugador3 = new Jugador("Jugador3Azul", 3, "Azul");
//		jugador1.ingresarASalaDeJuego(sala);
//		jugador2.ingresarASalaDeJuego(sala);
//		jugador3.ingresarASalaDeJuego(sala);
//		jugador1.iniciarPartida(sala);
		// ----------------------------------

		// Juego de 2 jugadores--------------
//		SalaDeJuego sala = new SalaDeJuego("Sala De Prueba");
//		Jugador jugador1 = new Jugador("Jugador1Rojo", 1, "Rojo");
//		Jugador jugador2 = new Jugador("Jugador2Verde", 2, "Verde");
//		jugador1.ingresarASalaDeJuego(sala);
//		jugador2.ingresarASalaDeJuego(sala);
//		jugador1.iniciarPartida(sala);
		// ----------------------------------
	}
}
