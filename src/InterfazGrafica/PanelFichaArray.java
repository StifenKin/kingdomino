package InterfazGrafica;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import kingdomino.Ficha;

public class PanelFichaArray extends JPanel {

	private static final long serialVersionUID = 8986111656347104880L;
	private ArrayList<Ficha> fichasRonda;
	private int fichaElegida;
	private int x;
	private int y;
	private final int FICHA_LARGO = 150;
	private final int FICHA_ALTO = 75;
	private VentanaPartida ventana;
	private CountDownLatch esperaFicha = new CountDownLatch(1);
	private ArrayList<BufferedImage> reyesImagenes;

	public PanelFichaArray(VentanaPartida ventana, ArrayList<Ficha> fichasRonda) {
		this.ventana = ventana;
		this.fichasRonda = fichasRonda;

		this.setBackground(new Color(224, 175, 7));

		reyesImagenes = new ArrayList<BufferedImage>();

		try {
			reyesImagenes.add(ImageIO.read(new File("src/imagenes/corona_blanca.png")));
			reyesImagenes.add(ImageIO.read(new File("src/imagenes/corona_roja.png")));
			reyesImagenes.add(ImageIO.read(new File("src/imagenes/corona_azul.png")));
			reyesImagenes.add(ImageIO.read(new File("src/imagenes/corona_amarilla.png")));
			reyesImagenes.add(ImageIO.read(new File("src/imagenes/corona_verde.png")));

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point point = e.getPoint();
				if (clicEnRey(point) != -1 && clicEnRey(point) < fichasRonda.size())
					elegirFicha(clicEnRey(point));

				if (clicEnFicha(point) != -1 && clicEnFicha(point) < fichasRonda.size()) {
					fichasRonda.get(clicEnFicha(point)).rotarFicha();
					repaint();
				}

			}

		});
		this.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		this.x = 100;
		this.y = 100;
		for (int i = 0; i < this.fichasRonda.size(); i++) {
			if (fichasRonda.get(i).getElegida() == -1)
				g2d.drawImage(reyesImagenes.get(0), x + 30, 5, 90, 90, null);
			else if (ventana.getSala().getJugadores().get(fichasRonda.get(i).getElegida()).getColor() == "Rojo")
				g2d.drawImage(reyesImagenes.get(1), x + 30, 5, 90, 90, null);
			else if (ventana.getSala().getJugadores().get(fichasRonda.get(i).getElegida()).getColor() == "Azul")
				g2d.drawImage(reyesImagenes.get(2), x + 30, 5, 90, 90, null);
			else if (ventana.getSala().getJugadores().get(fichasRonda.get(i).getElegida()).getColor() == "Amarillo")
				g2d.drawImage(reyesImagenes.get(3), x + 30, 5, 90, 90, null);
			else if (ventana.getSala().getJugadores().get(fichasRonda.get(i).getElegida()).getColor() == "Verde")
				g2d.drawImage(reyesImagenes.get(4), x + 30, 5, 90, 90, null);

			int coordX = 0, coordY = 0;
			if (this.fichasRonda.get(i).getPosicion() == 0) {
				coordX = x;
				coordY = y;
			}
			if (this.fichasRonda.get(i).getPosicion() == 1) {
				coordX = x + (FICHA_LARGO / 4);
				coordY = y + (FICHA_LARGO / 2);
			}
			if (this.fichasRonda.get(i).getPosicion() == 2) {
				coordX = x + (FICHA_LARGO / 2);
				coordY = y;
			}
			if (this.fichasRonda.get(i).getPosicion() == 3) {
				coordX = x + (FICHA_LARGO / 4);
				coordY = y;
			}
			g2d.drawImage(ventana.getTerrenos().get(fichasRonda.get(i).getCuadroIzquierdo().getImagenTerreno()), coordX,
					coordY, FICHA_LARGO / 2, FICHA_ALTO, null);
			g2d.setColor(Color.BLACK);
			g2d.setStroke(new BasicStroke(3));
			g2d.drawRect(coordX - 2, coordY, FICHA_ALTO + 3, FICHA_ALTO + 3);

			if (this.fichasRonda.get(i).getPosicion() == 0) {
				coordX = x + (FICHA_LARGO / 2);
				coordY = y;
			}
			if (this.fichasRonda.get(i).getPosicion() == 1) {
				coordX = x + (FICHA_LARGO / 4);
				coordY = y;
			}
			if (this.fichasRonda.get(i).getPosicion() == 2) {
				coordX = x;
				coordY = y;
			}
			if (this.fichasRonda.get(i).getPosicion() == 3) {
				coordX = x + (FICHA_LARGO / 4);
				coordY = y + (FICHA_LARGO / 2);
			}
			g2d.drawImage(ventana.getTerrenos().get(fichasRonda.get(i).getCuadroDerecho().getImagenTerreno()), coordX,
					coordY, FICHA_LARGO / 2, FICHA_ALTO, null);

//			g2d.setColor(Color.WHITE);
//			g2d.setFont(new Font("Consolas", Font.BOLD, 30));
//			g2d.drawString(fichasRonda.get(i).getNumeroFicha() + "", x + (FICHA_LARGO / 2) - 10,
//					y + (FICHA_ALTO / 2) + 7);
//			g2d.setColor(Color.BLACK);
//			g2d.setFont(new Font("Consolas", Font.PLAIN, 20));
//			g2d.drawString("Posicion " + fichasRonda.get(i).getPosicion(), x, y + (FICHA_ALTO) + 20);
			x += 275;
		}

	}

	private int clicEnFicha(Point point) {
		if (point.y > this.y && point.y < this.y + FICHA_ALTO) {
			if (point.x > 100 && point.x < 250)
				return 0;
			if (point.x > 375 && point.x < 525)
				return 1;
			if (point.x > 650 && point.x < 800)
				return 2;
			if (point.x > 925 && point.x < 1075)
				return 3;
		}
		return -1;
	}

	private int clicEnRey(Point point) {
		if (point.y > 5 && point.y < 75) {
			if (point.x > 130 && point.x < 220)
				return 0;
			if (point.x > 405 && point.x < 495)
				return 1;
			if (point.x > 680 && point.x < 770)
				return 2;
			if (point.x > 955 && point.x < 1045)
				return 3;
		}
		return -1;
	}

	public synchronized void elegirFicha(int numeroDeFicha) {
		this.fichaElegida = numeroDeFicha;
		esperaFicha.countDown();
	}

	public CountDownLatch getEsperaFicha() {
		return esperaFicha;
	}

	public void setEsperaFicha(CountDownLatch esperaFicha) {
		this.esperaFicha = esperaFicha;
	}

	public int getFichaElegida() {
		return fichaElegida;
	}

}
