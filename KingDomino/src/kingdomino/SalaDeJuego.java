package kingdomino;

import java.util.ArrayList;
import java.util.List;

public class SalaDeJuego {

	private String nombreSala; 
	private int cantJugadores = 0; 
	private List<Jugador> jugadores = new ArrayList<Jugador>();
	private boolean estado = false; 	// se refiere a sí hay una partida iniciada 
	private Partida partida; 
	
	public SalaDeJuego(String nombre) {
		this.nombreSala = nombre;
	}
	
	public void mostrarJugadores(){
		System.out.println(this);
		System.out.println(this.jugadores);
	}
	
	public void mostrarJugador(Jugador jugador){
		System.out.println(jugador);
	}

	public boolean admitirJugador(Jugador jugador) {
		if(this.cantJugadores < 4) {
			this.jugadores.add(jugador);
			this.cantJugadores++;
			return true;
		}
		else
			return false;
	}

	public void eliminarJugador(Jugador jugador) {
		this.jugadores.remove(jugador);
		this.cantJugadores--;

		if(this.cantJugadores == 1)
			getPartida().designarGanador(this);
	}
	
	public void crearPartida() {
		this.partida = new Partida();
		this.estado = true;
	}
	
	public void jugarPartida() {
		Ronda ronda = new Ronda();
		int cantRondas;
		if(cantJugadores == 2) 
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

	@Override
	public String toString() {
		return "Sala De Juego " + nombreSala + "\t Cantidad de Jugadores" + cantJugadores;
	}
		
}
