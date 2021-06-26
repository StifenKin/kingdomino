package InterfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kingdomino.Jugador;

public class VentanaMostrarTableros extends JFrame {

	private static final long serialVersionUID = 3115379139006806180L;
	private JPanel contentPane;
	private int cantJugadores;

	public VentanaMostrarTableros(VentanaPartida ventana, List<Jugador> jugadores) {
		this.cantJugadores = jugadores.size();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.setTitle("Mostrar Tableros");

		if (cantJugadores == 2) {
			this.setMinimumSize(new Dimension(720, 400));
		} else {
			this.setMinimumSize(new Dimension(720, 800));
		}
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(224, 175, 7));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		int x = 0;
		int y = 0;

		for (int i = 0; i < jugadores.size(); i++) {
			PanelMostrarTablero tablero = new PanelMostrarTablero(ventana, jugadores, i);
			tablero.setBounds(x, y, 360, 360);
			this.getContentPane().add(tablero);
			x += 360;
			if (i == 1) {
				x = 0;
				y += 360;
			}
		}

	}

}
