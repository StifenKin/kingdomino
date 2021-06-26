package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import kingdomino.Jugador;
import kingdomino.SalaDeJuego;

public class SalaDeJuegoTest {

	@Test
	public void testCrearSalaDeJuego() {
		//Crea la sala sin jugadores, verifica que la cantidad sea cero
		SalaDeJuego sala = new SalaDeJuego("sala1");
		assertEquals(0, sala.getCantJugadores());
	}

	@Test
	public void testAdmitirJugadores() {
		//Crea la sala sin jugadores, verifica que la cantidad sea cero
		SalaDeJuego sala = new SalaDeJuego("sala1");
		assertEquals(0, sala.getCantJugadores());
		//Crea un jugador y lo admite. Consulta por cantidad de jugadores = 1
		Jugador jugador1 = new Jugador("Maikcrosoft", 1, "Rojo");
		assertTrue(sala.admitirJugador(jugador1));
		assertEquals(1, sala.getCantJugadores());
		//Crea un jugador y lo admite. Consulta por cantidad de jugadores = 2
		Jugador jugador2 = new Jugador("crosoft", 2, "Verde");
		assertTrue(sala.admitirJugador(jugador2));
		assertEquals(2, sala.getCantJugadores());
		//Crea un tercer jugador y lo admite. Consulta por cantidad de jugadores = 3
		Jugador jugador3 = new Jugador("soft", 3, "Azul");
		assertTrue(sala.admitirJugador(jugador3));
		assertEquals(3, sala.getCantJugadores());
		//Crea un cuarto jugador y lo admite. Consulta por cantidad de jugadores = 4
		Jugador jugador4 = new Jugador("croso", 4, "Amarillo");
		assertTrue(sala.admitirJugador(jugador4));
		assertEquals(4, sala.getCantJugadores());
		//Crea un quinto jugador y verifica que lo rechace. 
		Jugador jugador5 = new Jugador("ikcro", 5, "Rojo");
		assertFalse(sala.admitirJugador(jugador5));
	}
	
	@Test
	public void testEliminarJugadores() {
		//Crea la sala sin jugadores, verifica que la cantidad sea cero
		SalaDeJuego sala = new SalaDeJuego("sala1");
		assertEquals(0, sala.getCantJugadores());
		//Crea un jugador y lo admite. Consulta por cantidad de jugadores = 1
		Jugador jugador1 = new Jugador("Maikcrosoft", 1, "Rojo");
		sala.admitirJugador(jugador1);
		assertEquals(1, sala.getCantJugadores());
		//Crea un jugador y lo admite. Consulta por cantidad de jugadores = 2
		Jugador jugador2 = new Jugador("crosoft", 2, "Verde");
		sala.admitirJugador(jugador2);
		assertEquals(2, sala.getCantJugadores());
		//Elimina al primer jugador, verifica que la cantidad de jugadores = 1
		sala.eliminarJugador(jugador1);
		assertEquals(1, sala.getCantJugadores());
		//Elimina al primer jugador, verifica que la cantidad de jugadores = 0
		sala.eliminarJugador(jugador2);
		assertEquals(0, sala.getCantJugadores());
	}
}
