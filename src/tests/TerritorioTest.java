package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import kingdomino.Territorio;

public class TerritorioTest {

	@Test
	public void testComparaTerritoriosIguales() {
		
		Territorio territorio1 = new Territorio("montania", 1);
		Territorio territorio2 = new Territorio("montania", 1);
		
		// con la misma cantidad de coronas son iguales
		assertTrue(territorio1.compararTerritorio(territorio2));
		
		Territorio territorio3 = new Territorio("montania", 3);
		
		// con la misma cantidad de coronas tambien deben ser iguales
		assertTrue(territorio1.compararTerritorio(territorio3));
		
	}

	@Test
	public void testComparaTerritoriosDistintos() {
		
		Territorio territorio1 = new Territorio("montania", 1);
		Territorio territorio2 = new Territorio("campo", 1);
		
		// no importa la cantidad de coronas, si el tipo es distinto, siempre son distintos
		assertFalse(territorio1.compararTerritorio(territorio2));
		
		Territorio territorio3 = new Territorio("campo", 3);
		assertFalse(territorio1.compararTerritorio(territorio3));
		
	}
}
