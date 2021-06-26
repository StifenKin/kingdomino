package kingdomino;

public class Rey {

	// reyes del 0 al 3: corresponden a la posición del jugador en el array
	// jugadores de la sala de juego (en partidas de 3/4 jugadores); o reyes 0 y 1
	// para el jugador en posición 0 y reyes 2 y 3 para el jugador en posición 1
	// (partidas de 2 jugadores)
	private int numeroDeRey;
	private int carta;
	
	public Rey(int numeroDeRey) {
		this.numeroDeRey = numeroDeRey;
	}
	
	public void setCarta(int carta) {
		this.carta = carta;
	}

	
}
