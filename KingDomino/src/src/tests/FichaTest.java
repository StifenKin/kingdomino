package tests;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import kingdomino.Ficha;
import kingdomino.Territorio;

public class FichaTest {
	
	@Test
	public void testNumeroDeFichaCorrecto() {
		int contador = 1;
		Ficha ficha1 = new Ficha(new Territorio("montania", 2), new Territorio("campo", 0), contador++);
		Ficha ficha2 = new Ficha(new Territorio("mina", 3), new Territorio("lago", 0), contador++);
		Ficha ficha3 = new Ficha(new Territorio("lago", 2), new Territorio("bosque", 1), contador++);
		
		// verifica que se asignen los números de ficha consecutivos y correctos
		assertEquals(1, ficha1.getNumeroFicha());
		assertEquals(2, ficha2.getNumeroFicha());
		assertEquals(3, ficha3.getNumeroFicha());
	}	
	
	@Test
	public void testRotarFicha() {
		Ficha ficha = new Ficha(new Territorio("montania", 2), new Territorio("campo", 0), 16);
		
		// al crear una ficha, se inicializa con su posicion en 0 (horizontal; cuadroIzq y cuadroDer normales)
		// en el método (rotarFicha de la clase Ficha) se explica que significa cada posición
		assertEquals(0, ficha.getPosicion());
		ficha.rotarFicha();
		assertEquals(1, ficha.getPosicion());
		ficha.rotarFicha();
		assertEquals(2, ficha.getPosicion());
		ficha.rotarFicha();
		assertEquals(3, ficha.getPosicion());
		ficha.rotarFicha();
		assertEquals(0, ficha.getPosicion());
		// al rotarla 4 veces, regresa a la posición inicial

	}
	
	@Test
	public void testVoltearFicha() {
		Ficha ficha = new Ficha(new Territorio("montania", 2), new Territorio("campo", 0), 16);
		
		// al crear una ficha, se inicializa con su número hacia arriba (numeroHaciaArriba=true)
		assertTrue(ficha.isNumeroHaciaArriba());
		
		ficha.voltearFicha();
		
		// al voltearla, su número esta hacia abajo (numeroHaciaArriba=false)
		assertFalse(ficha.isNumeroHaciaArriba());
	}
	
	@Test
	public void testOrdenarFichas() {
		Ficha ficha = new Ficha(new Territorio("montania", 2), new Territorio("mina", 0), 29);
		Ficha ficha1 = new Ficha(new Territorio("lago", 2), new Territorio("campo", 0), 16);
		Ficha ficha2 = new Ficha(new Territorio("montania", 2), new Territorio("pradera", 0), 13);
		Ficha ficha3 = new Ficha(new Territorio("pantano", 2), new Territorio("campo", 0), 2);
		
		List<Ficha> arrayFichas = new ArrayList<Ficha>();
		
		arrayFichas.add(ficha);
		arrayFichas.add(ficha1);
		arrayFichas.add(ficha2);
		arrayFichas.add(ficha3);
		
		// Se agregaron las fichas al array sin ningún orden
		assertEquals(29, arrayFichas.get(0).getNumeroFicha());
		assertEquals(16, arrayFichas.get(1).getNumeroFicha());
		assertEquals(13, arrayFichas.get(2).getNumeroFicha());
		assertEquals(2, arrayFichas.get(3).getNumeroFicha());
		
		Collections.sort(arrayFichas);
		
		// Se ordenaron (orden creciente) las fichas en el array
		assertEquals(2, arrayFichas.get(0).getNumeroFicha());
		assertEquals(13, arrayFichas.get(1).getNumeroFicha());
		assertEquals(16, arrayFichas.get(2).getNumeroFicha());
		assertEquals(29, arrayFichas.get(3).getNumeroFicha());
	}

}
