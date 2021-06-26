package InterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JPanel;

import kingdomino.Jugador;

public class PanelTablero extends JPanel {

	private static final long serialVersionUID = 5182501522280082698L;
	private List<Jugador> jugadores;
	private VentanaPartida ventana;
	private int turno;
	private int x;
	private int y;
	private CountDownLatch esperaPosicion = new CountDownLatch(1);
	private CountDownLatch finTurno = new CountDownLatch(1);
	private int posicionElegidaX;
	private int posicionElegidaY;

	public PanelTablero(VentanaPartida ventana, List<Jugador> jugadores, int turno) {
		this.ventana = ventana;
		this.jugadores = jugadores;
		this.turno = turno;

		this.setBackground(new Color(224, 175, 7));

		JButton btnTerminarTurno = new JButton("Terminar Turno");
		btnTerminarTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				terminarTurno();
			}
		});
		btnTerminarTurno.setBounds(10, 370, 150, 30);
		this.add(btnTerminarTurno);

		JButton btnDescartar = new JButton("Descartar Ficha");
		btnDescartar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				descartar();
			}

		});
		btnDescartar.setBounds(10, 320, 150, 30);
		this.add(btnDescartar);

		JButton btnMostrarTableros = new JButton("Mostrar Tableros");
		btnMostrarTableros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.mostrarTablerosJugadores();
			}

		});
		btnMostrarTableros.setBounds(1025, 370, 150, 30);
		this.add(btnMostrarTableros);

		JButton btnMostrarPuntajes = new JButton("Mostrar Puntajes");
		btnMostrarPuntajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.mostrarPuntajesJugadores();
			}

		});
		btnMostrarPuntajes.setBounds(1025, 320, 150, 30);
		this.add(btnMostrarPuntajes);

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point point = e.getPoint();
				int coordX = clicCoordenadaX(point);
				int coordY = clicCoordenadaY(point);
				if (coordX != -1 && coordY != -1)
					elegirPosicion(coordX, coordY);

			}

		});
		this.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		this.x = 420;
		this.y = 20;

		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Consolas", Font.PLAIN, 16));
		g2d.drawString("Es el turno de: " + jugadores.get(turno).getNombreJugador(), 470, 10);

		for (int i = 0; i < jugadores.get(turno).getTablero().getTableroMatriz().length; i++) {
			for (int j = 0; j < jugadores.get(turno).getTablero().getTableroMatriz().length; j++) {
				g2d.setColor(Color.GRAY);
				g2d.drawRect(x, y, 40, 40);

				int imagenTerreno = jugadores.get(turno).getTablero().getTablero(i, j).getImagenTerreno();
				if (imagenTerreno != -1)
					g2d.drawImage(ventana.getTerrenos().get(imagenTerreno), x, y, 40, 40, null);
				x += 40;
			}
			x = 420;
			y += 40;
		}

	}

	private int clicCoordenadaX(Point point) {
		if (point.y >= 20 && point.y <= 380)
			return (int) ((point.y - 20) / 40);
		return -1;
	}

	private int clicCoordenadaY(Point point) {
		if (point.x >= 420 && point.x <= 780)
			return (int) ((point.x - 420) / 40);
		return -1;
	}

	public synchronized void elegirPosicion(int coordX, int coordY) {
		this.posicionElegidaX = coordX;
		this.posicionElegidaY = coordY;
		esperaPosicion.countDown();
	}

	public synchronized void terminarTurno() {
		finTurno.countDown();
	}

	private void descartar() {
		elegirPosicion(-1, -1);
	}

	public CountDownLatch getEsperaPosicion() {
		return esperaPosicion;
	}

	public void setEsperaPosicion(CountDownLatch esperaPosicion) {
		this.esperaPosicion = esperaPosicion;
	}

	public CountDownLatch getFinTurno() {
		return finTurno;
	}

	public void setFinTurno(CountDownLatch finTurno) {
		this.finTurno = finTurno;
	}

	public int getPosicionElegidaX() {
		return posicionElegidaX;
	}

	public int getPosicionElegidaY() {
		return posicionElegidaY;
	}

}
