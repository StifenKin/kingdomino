package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import kingdomino.Tablero;
import kingdomino.Territorio;

public class TableroTest {

	@Test
	public void testCrearTablero() {
		Tablero tablero = new Tablero();

		// Al crear un nuevo tablero se inicializan sus casilleros como territorios
		// vacíos, excepto el central donde se coloca el castillo
		assertEquals("Castillo", tablero.getTablero(4, 4).getTipo());
		assertEquals("Vacio", tablero.getTablero(8, 0).getTipo());
		assertEquals("Vacio", tablero.getTablero(0, 4).getTipo());
		assertEquals("Vacio", tablero.getTablero(4, 8).getTipo());
	}

	@Test
	public void testCalcularPuntaje() {
		Tablero tablero = new Tablero();
		
		tablero.setTablero(3, 4, new Territorio("Lago", 2));
		tablero.setTablero(3, 5, new Territorio("Mina", 0));
		tablero.setTablero(2, 5, new Territorio("Mina", 1));
		tablero.setTablero(2, 6, new Territorio("Campo", 0));
		tablero.setTablero(2, 4, new Territorio("Lago", 0));
		tablero.setTablero(1, 4, new Territorio("Lago", 0));
		tablero.setTablero(2, 3, new Territorio("Lago", 1));
		tablero.setTablero(3, 3, new Territorio("Campo", 0));
		tablero.setTablero(3, 2, new Territorio("Campo", 0));
		tablero.setTablero(4, 2, new Territorio("Campo", 3));
		
		assertEquals(23, tablero.calcularPuntaje());
		
	}
}
