package kingdomino;

import java.util.ArrayList;

public class Tablero {

	private int tamanioTablero = 9;
	private Territorio[][] tablero = new Territorio[tamanioTablero][tamanioTablero];
	private ArrayList<Territorio> grupo = new ArrayList<Territorio>();
	private int territorioMasGrande = 0;
	private int filaMin = 0;
	private int filaMax = 8;
	private int columnaMin = 0;
	private int columnaMax = 8;

	public Tablero() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if ((i == 4) && (j == 4)) {
					tablero[i][j] = new Territorio("Castillo", 0);
				} else {
					tablero[i][j] = new Territorio("Vacio", 0);
				}
			}
		}
	}

	public void redefinirLimitesDeTablero() {
		int filaMax = 0, filaMin = 8;
		int columnaMax = 0, columnaMin = 8;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (tablero[i][j].getTipo() != "Vacio") {
					if (i < filaMin) {
						filaMin = i;
					}
					if (i > filaMax) {
						filaMax = i;
					}
					if (j < columnaMin) {
						columnaMin = j;
					}
					if (j > columnaMax) {
						columnaMax = j;
					}
				}
			}
		}

		this.filaMax = filaMax + (5 - (filaMax - filaMin) - 1);
		this.filaMin = filaMin - (5 - (filaMax - filaMin) - 1);
		this.columnaMin = columnaMin - (5 - (columnaMax - columnaMin) - 1);
		this.columnaMax = columnaMax + (5 - (columnaMax - columnaMin) - 1);
	}

	public void buscarGrupoDeTerritorios(int x, int y) {
		if (tablero[x][y].isPuntuado() == false && tablero[x][y].getTipo() != "Vacio") {

			grupo.add(tablero[x][y]);
			tablero[x][y].setPuntuado(true);

			if (x < 8 && tablero[x + 1][y].getTipo() == tablero[x][y].getTipo() && (x + 1 != filaMax + 1)
					&& tablero[x + 1][y].isPuntuado() == false) {
				buscarGrupoDeTerritorios(x + 1, y);
			}

			if (x > 0 && tablero[x - 1][y].getTipo() == tablero[x][y].getTipo() && (x - 1 != filaMin - 1)
					&& !tablero[x - 1][y].isPuntuado()) {
				buscarGrupoDeTerritorios(x - 1, y);

			}

			if (y < 8 && tablero[x][y + 1].getTipo() == tablero[x][y].getTipo() && (y + 1 != columnaMax + 1)
					&& !tablero[x][y + 1].isPuntuado()) {
				buscarGrupoDeTerritorios(x, y + 1);

			}

			if (y > 0 && tablero[x][y - 1].getTipo() == tablero[x][y].getTipo() && (y - 1 != columnaMin - 1)
					&& !tablero[x][y - 1].isPuntuado()) {
				buscarGrupoDeTerritorios(x, y - 1);

			}
		}
	}

	public int puntuarGrupo(int x, int y) {
		int puntajeGrupo = 0;
		buscarGrupoDeTerritorios(x, y);
		int cantCoronas = 0;
		if (grupo.size() > territorioMasGrande)
			territorioMasGrande = grupo.size();
		for (int i = 0; i < grupo.size(); i++) {
			cantCoronas += grupo.get(i).getCorona();
		}
		puntajeGrupo += (grupo.size() * cantCoronas);

		grupo = new ArrayList<Territorio>();

		return puntajeGrupo;
	}

	public int calcularPuntaje() {
		inicializarPuntaje();
		int puntaje = 0;
		for (int i = filaMin; i < filaMax; i++) {
			for (int j = columnaMin; j < columnaMax; j++) {
				puntaje += puntuarGrupo(i, j);
			}
		}
		return puntaje;
	}

	private void inicializarPuntaje() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j].setPuntuado(false);
			}
		}
	}

	public Territorio getTablero(int fila, int columna) {
		return tablero[fila][columna];
	}

	public Territorio[][] getTableroMatriz() {
		return tablero;
	}

	public void setTablero(int fila, int columna, Territorio territorio) {
		this.tablero[fila][columna] = territorio;
	}

	public int getFilaMin() {
		return filaMin;
	}

	public int getFilaMax() {
		return filaMax;
	}

	public int getColumnaMin() {
		return columnaMin;
	}

	public int getColumnaMax() {
		return columnaMax;
	}

	public void setFilaMin(int filaMin) {
		this.filaMin = filaMin;
	}

	public void setFilaMax(int filaMax) {
		this.filaMax = filaMax;
	}

	public void setColumnaMin(int columnaMin) {
		this.columnaMin = columnaMin;
	}

	public void setColumnaMax(int columnaMax) {
		this.columnaMax = columnaMax;
	}

	public int getTerritorioMasGrande() {
		return territorioMasGrande;
	}

}
