package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import kingdomino.Jugador;
import kingdomino.SalaDeJuego;


public class JugadorTest {

	@Test
	public void testNombreIdJugador() {
		Jugador jugador = new Jugador("Maikcrosoft", 1, "Rojo");

		assertEquals("Maikcrosoft", jugador.getNombreJugador());
		assertEquals(1, jugador.getNumeroId());
	}

	@Test
	public void testCrearSalaDeJuego() {
		// Crea una sala de juego y verifica que solo haya 1 jugador
		Jugador jugador = new Jugador("Maikcrosoft", 1, "Rojo");

		SalaDeJuego sala = jugador.crearSalaDeJuego("sala1");
		assertEquals(1, sala.getCantJugadores());
	}

	@Test
	public void testIngresarSalaDeJuego() {
		// Crea la sala sin jugadores, verifica que la cantidad sea cero
		SalaDeJuego sala = new SalaDeJuego("sala1");
		assertEquals(0, sala.getCantJugadores());
		// Crea al jugador e ingresa a la sala, verifica q la cantidad de la sala sea 1
		Jugador jugador = new Jugador("Maikcrosoft", 1, "Rojo");
		jugador.ingresarASalaDeJuego(sala);
		assertEquals(1, sala.getCantJugadores());
	}

	@Test
	public void testRendirse() {
		// Crea la sala sin jugadores, verifica que la cantidad sea cero
		SalaDeJuego sala = new SalaDeJuego("sala1");
		assertEquals(0, sala.getCantJugadores());
		// Crea al jugador e ingresa a la sala, verifica q la cantidad de la sala sea 1
		Jugador jugador = new Jugador("Maikcrosoft", 1, "Rojo");
		jugador.ingresarASalaDeJuego(sala);
		assertEquals(1, sala.getCantJugadores());

		// El jugador renuncia, se comprueba que la sala quede con cero participantes.
		jugador.salirDeLaSala(sala);
		assertEquals(0, sala.getCantJugadores());
	}

}
