package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.google.gson.Gson;

import kingdomino.SalaDeJuego;
import java.awt.Color;

@SuppressWarnings("serial")
public class Lobby extends JFrame {
	private String usuario;
	private Set<String> salas = new TreeSet<String>();
	private HashMap<String, SalaDeJuego> listaSalas = new HashMap<String, SalaDeJuego>();

	private JPanel panelSalas;
	private Gson gson;


	public void actualizar(java.util.List<SalaDeJuego> listaSalaDeJuego, Socket socket) {
		if(listaSalaDeJuego != null)
		for(SalaDeJuego nuevo : listaSalaDeJuego) {
			listaSalas.put(nuevo.getNombreSala(), nuevo);
		}
		
		salas.clear();
		
//		for(SalaDeJuego sc : listaSalaDeJuego) {
//			if(!sc.nombreSala.contains("-PRIVATE")) {
//				salas.add(sc.nombreSala);
//			}
//		}
		
		panelSalas.removeAll();
		
		for (String sc : salas) {
				JButton salaBtn = new JButton(sc + "    Usuarios: " + listaSalas.get(sc).getCantJugadores() );
				salaBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							PrintStream ps = new PrintStream(socket.getOutputStream(), true);
							ps.println(gson.toJson(new GenericResponse("UNIRSESALA", sc)));
							System.out.println("Se unio a la sala: " + sc);
						} catch (IOException e1) {
							e1.printStackTrace();
						}}
				});
				panelSalas.add(salaBtn);
				panelSalas.updateUI();
			
		}
		listaSalas.clear();
	}

	public Lobby(java.util.List<SalaDeJuego> listaSalaDeJuegos, String nameUsuario, Socket socket) {
//		gson = new Gson();
		usuario = usuario + new Random().nextInt();
		panelSalas = new JPanel();
		panelSalas.setBackground(new Color(0, 206, 209));
		panelSalas.setLayout(new BoxLayout(panelSalas, BoxLayout.Y_AXIS));
		JScrollPane scroll = new JScrollPane(panelSalas);

		pack();
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(scroll, BorderLayout.CENTER);

		JButton crear = new JButton("Crear Sala");
		crear.setBackground(new Color(255, 215, 0));
		crear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre de la sala", "Nueva Sala",
						JOptionPane.QUESTION_MESSAGE);
				if((nombre.compareTo("") != 0) || (nombre.compareTo("") != 0)) {
				try {
					PrintStream ps = new PrintStream(socket.getOutputStream(), true);
					ps.println(gson.toJson(new GenericResponse("CREARSALA", nombre)));
				} catch (IOException e) {
					e.printStackTrace();
				}

				 addSala(nombre,socket);
			}
			}
		});
		actualizar(listaSalaDeJuegos, socket);
		setTitle("Lobby - " + nameUsuario);
		getContentPane().add(crear, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void addSala(String sala, Socket socket) {
		JButton salaBtn = new JButton(sala);
		salaBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					PrintStream ps = new PrintStream(socket.getOutputStream(), true);
					ps.println(gson.toJson(new GenericResponse("UNIRSESALA", sala)));
					System.out.println("Se unio a la sala: " + sala);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}});
		panelSalas.add(salaBtn);
		panelSalas.updateUI();
	}

//	public void registrar() {
//		this.usuario= JOptionPane.showInputDialog(null, "Ingrese el nombre del usuario",
//				"Registrar Usuario", JOptionPane.QUESTION_MESSAGE);
//		
////		nombreBtn.addActionListener(new ActionListener() {
////			@Override
////			public void actionPerformed(ActionEvent e) {
////				JButton btn = (JButton) e.getSource();
////				new SalaChat(usuario, btn.getText()).setVisible(true);
////			}
////		});
//	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(600, 400);
	}

	public static void main(String[] args) {
		Lobby lobby = new Lobby(null, null, null);
		lobby.setVisible(true);
	}

}