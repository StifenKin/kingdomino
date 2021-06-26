package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import kingdomino.Ficha;
import kingdomino.Mazo;

public class MazoTest {

	
	// No pueden ejecutarse todos los tests a la vez porque es una clase con
	// implementación Singleton (patron de diseño)

	
	@Test
	public void testAgregarAlMazoYMezclar() {
		Mazo mazo = Mazo.getInstance();

		// Se agregan las fichas en orden, entonces su numero debería coincidir con la
		// posición en el mazo-1
		assertEquals(1, mazo.getFicha(0).getNumeroFicha());
		assertEquals(2, mazo.getFicha(1).getNumeroFicha());
		assertEquals(3, mazo.getFicha(2).getNumeroFicha());

		mazo.mezclarMazo();

		// Se mezclaron las fichas, el orden es aleatorio, ya no es según el número de
		// ficha
		if (mazo.getFicha(0).getNumeroFicha() == 1 && mazo.getFicha(1).getNumeroFicha() == 2
				&& mazo.getFicha(2).getNumeroFicha() == 3)
			assertTrue(false);
		else
			assertTrue(true);

	}

	@Test
	public void testDescartarFichas() {
		Mazo mazo = Mazo.getInstance();

		// El mazo, al crearse, tiene 48 fichas en el Array
		assertEquals(48, mazo.getMazo().size());

		mazo.descartarFichas(4);
		// Para 4 jugadores no se descartan fichas; el mazo todavía tiene 48 fichas
		assertEquals(48, mazo.getMazo().size());

		mazo.descartarFichas(3);
		// Para 3 jugadores se descartan 12 fichas; el mazo tiene ahora 36 fichas
		assertEquals(36, mazo.getMazo().size());

		mazo.descartarFichas(2);
		// Para 2 jugadores se descartan 24 fichas; el mazo tiene ahora 12 fichas
		assertEquals(12, mazo.getMazo().size());

	}

	@Test
	public void testRepartirFichas() {
		Mazo mazo = Mazo.getInstance();

		ArrayList<Ficha> fichasDeRonda = new ArrayList<Ficha>();
		fichasDeRonda = mazo.repartirFichas(4);
		// Se repartieron las 4 primeras fichas, por lo que quedarían 44 en el mazo y 4
		// en el array de fichas de la ronda
		assertEquals(44, mazo.getMazo().size());
		assertEquals(4, fichasDeRonda.size());

	}

	@Test
	public void testRepartirFichas3Jugadores() {
		Mazo mazo = Mazo.getInstance();

		ArrayList<Ficha> fichasDeRonda = new ArrayList<Ficha>();
		fichasDeRonda = mazo.repartirFichas(3);
		// Se repartieron las 3 primeras fichas, por lo que quedarían 45 en el mazo y 3
		// en el array de fichas de la ronda
		assertEquals(45, mazo.getMazo().size());
		assertEquals(3, fichasDeRonda.size());

	}
}
