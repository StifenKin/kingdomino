package InterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

import kingdomino.Jugador;

public class PanelMostrarTablero extends JPanel {

	private static final long serialVersionUID = 5303249028581330394L;
	private List<Jugador> jugadores;
	private VentanaPartida ventana;
	private int turno;
	private int x;
	private int y;

	public PanelMostrarTablero(VentanaPartida ventana, List<Jugador> jugadores, int turno) {
		this.ventana = ventana;
		this.jugadores = jugadores;
		this.turno = turno;

		this.setBackground(new Color(224, 175, 7));

		this.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		this.x = 10;
		this.y = 30;

		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Consolas", Font.PLAIN, 16));
		g2d.drawString(jugadores.get(turno).getNombreJugador(), 125, 20);

		for (int i = 0; i < jugadores.get(turno).getTablero().getTableroMatriz().length; i++) {
			for (int j = 0; j < jugadores.get(turno).getTablero().getTableroMatriz().length; j++) {
				g2d.setColor(Color.GRAY);
				g2d.drawRect(x, y, 36, 36);

				int imagenTerreno = jugadores.get(turno).getTablero().getTablero(i, j).getImagenTerreno();
				if (imagenTerreno != -1)
					g2d.drawImage(ventana.getTerrenos().get(imagenTerreno), x, y, 36, 36, null);
				x += 36;
			}
			x = 10;
			y += 36;
		}

	}

}
