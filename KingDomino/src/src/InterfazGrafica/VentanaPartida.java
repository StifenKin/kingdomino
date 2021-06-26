package InterfazGrafica;

import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import kingdomino.Ficha;
import kingdomino.SalaDeJuego;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class VentanaPartida extends JFrame {

	private SalaDeJuego sala;
	public PanelFichaArray fichas;
	private PanelTablero tableros;
	private Container contentPane;
	private ArrayList<BufferedImage> terrenos;

	
	public VentanaPartida(SalaDeJuego sala) {
		this.sala = sala;
		
		this.setTitle("KingDomino");
		this.setMinimumSize(new Dimension(1200, 700));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//this.setBounds(100, 100, 450, 300);
		this.setVisible(true);
		
		//Container contentPane = getContentPane();
		contentPane = getContentPane();
		//this.setBackground(new Color(246, 196, 23));
		
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
		contentPane.setLayout(null);
		//contentPane.setLayout(new GridLayout(2, 1));
//		this.getContentPane().setBackground(new Color(246, 196, 23));
		
		//this.sala.jugarPartida();
		
		//ArrayList<Ficha> fichasRonda = new ArrayList<Ficha>();
//		fichasRonda.add(new Ficha(new Territorio("campo", 0), new Territorio("campo", 0), 1));
//		fichasRonda.add(new Ficha(new Territorio("mina", 2), new Territorio("campo", 0), 2));
//		fichasRonda.add(new Ficha(new Territorio("campo", 0), new Territorio("campo", 0), 3));
//		fichasRonda.add(new Ficha(new Territorio("mina", 2), new Territorio("campo", 0), 4));
//		System.out.println("ES"+fichasRonda.size());

//		fichas = new PanelFichaArray();
//		contentPane.add(fichas);
		
		//VentanaPartida.mainFrame = this;
		//ArrayList<Ficha> fichasRonda = new ArrayList<Ficha>();
//		fichasRonda.add(new Ficha(new Territorio("campo", 0), new Territorio("campo", 0), 1));
//		fichasRonda.add(new Ficha(new Territorio("mina", 2), new Territorio("campo", 0), 2));
//		fichasRonda.add(new Ficha(new Territorio("campo", 0), new Territorio("campo", 0), 3));
//		fichasRonda.add(new Ficha(new Territorio("mina", 2), new Territorio("campo", 0), 4));
//		System.out.println("ES"+fichasRonda.size());
//		
//		actualizarFichasRonda(fichasRonda);
//		
//		ArrayList<Jugador> jugadoresSala = new ArrayList<Jugador>();
//		Jugador jugador0 = new Jugador("Camila", 1, "Rojo");
//		Tablero tablero = new Tablero();
//		tablero.setTablero(3, 4, new Territorio("lago", 1));
//		tablero.setTablero(3, 5, new Territorio("mina", 0));
//		tablero.setTablero(2, 5, new Territorio("mina", 1));
//		tablero.setTablero(2, 6, new Territorio("campo", 0));
//		tablero.setTablero(2, 4, new Territorio("lago", 0));
//		tablero.setTablero(1, 4, new Territorio("lago", 0));
//		tablero.setTablero(2, 3, new Territorio("lago", 1));
//		tablero.setTablero(3, 3, new Territorio("campo", 0));
//		tablero.setTablero(3, 2, new Territorio("campo", 0));
//		tablero.setTablero(4, 2, new Territorio("campo", 1));
//		jugador0.setTablero(tablero);
//		jugadoresSala.add(jugador0);
		
		terrenos = new ArrayList<BufferedImage>();
		try {
			for (int i = 0; i < 17; i++) {
				terrenos.add(ImageIO.read(new File("src/imagenes/" + i + ".png")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		//tableros = new PanelTablero(this, jugadoresSala, 0);
		tableros = new PanelTablero(this, sala.getJugadores(), 0);
		tableros.setBounds(0, 250, 1200, 450);
		contentPane.add(tableros);
	}
	
	public void ponerFichasEnVentana(ArrayList<Ficha> fichasDeRonda) {
		if (fichas != null) {
			this.remove(fichas);
		}
		fichas = new PanelFichaArray(this, fichasDeRonda);
		fichas.setBounds(0, 0, 1200, 250);
		this.getContentPane().add(fichas);
		this.repaint();
	}
	
	public void actualizarTablero(int turno) {
		if (tableros != null) {
			this.remove(tableros);
		}
		tableros = new PanelTablero(this, sala.getJugadores(), turno);
		tableros.setBounds(0, 250, 1200, 450);
		this.getContentPane().add(tableros);
		this.repaint();
	}

	public SalaDeJuego getSala() {
		return sala;
	}

	public synchronized int traerFichaElegida() {
		try {
			fichas.getEsperaFicha().await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int fichaElegida = fichas.getFichaElegida();
		fichas.setEsperaFicha(new CountDownLatch(1));
		return fichaElegida;
	}
	
	public synchronized int[] traerPosicionElegida() {
		try {
			tableros.getEsperaPosicion().await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int[] posicionElegida = {tableros.getPosicionElegidaX(), tableros.getPosicionElegidaY()};
		tableros.setEsperaPosicion(new CountDownLatch(1));
		return posicionElegida;
	}
	
	public synchronized void terminarTurno() {
		try {
			tableros.getFinTurno().await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		tableros.setFinTurno(new CountDownLatch(1));
	}

	public ArrayList<BufferedImage> getTerrenos() {
		return terrenos;
	}
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SalaDeJuego sala = new SalaDeJuego("Juego Prueba");
//					Jugador jugador1 = new Jugador("Jugador1", 1, "Rojo");
//					Jugador jugador2 = new Jugador("Jugador2", 2, "Verde");
//					Jugador jugador3 = new Jugador("Jugador3", 3, "Azul");
//					Jugador jugador4 = new Jugador("Jugador4", 4, "Amarillo");
//					jugador1.ingresarASalaDeJuego(sala);
//					jugador2.ingresarASalaDeJuego(sala);
//					jugador3.ingresarASalaDeJuego(sala);
//					jugador4.ingresarASalaDeJuego(sala);
//					//jugador1.iniciarPartida(sala);
//					
//					VentanaPartida frame = new VentanaPartida(sala);
//					//frame.init();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
}
