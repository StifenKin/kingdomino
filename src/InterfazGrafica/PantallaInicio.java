package InterfazGrafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class PantallaInicio extends JFrame {

	ImagenFondo fondo = new ImagenFondo();
	private JButton botonJugar;
	private JLabel labelNombre;
	private JLabel labelId;
	private JTextField txtId;
	private JTextField txtNombre;

	public PantallaInicio() {
		setTitle("KingDomino");
		this.setContentPane(fondo);

		initComponents();
	}
	
	@SuppressWarnings("unchecked")
	private void initComponents() {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		botonJugar = new JButton();

		botonJugar.setForeground(new Color(255, 165, 0));
		botonJugar.setBackground(new Color(255, 250, 205));
		botonJugar.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 26));
		botonJugar.setText("Jugar");
		botonJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonJugarActionPerformed(evt);
			}
		});
		txtId = new JTextField();

		txtId.setBackground(new Color(255, 255, 255));
		txtId.setFont(new Font("Dialog", 0, 18)); // NOI18N
		txtId.setForeground(new Color(0, 0, 0));
		labelId = new JLabel();

		labelId.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 26)); // NOI18N
		labelId.setForeground(new Color(255, 165, 0));
		labelId.setText("ID:");
		txtNombre = new JTextField();

		txtNombre.setBackground(new Color(255, 255, 255));
		txtNombre.setFont(new Font("Dialog", 0, 18)); // NOI18N
		txtNombre.setForeground(new Color(0, 0, 0));
		
		labelNombre = new JLabel();
		labelNombre.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 26)); // NOI18N
		labelNombre.setForeground(new Color(255, 165, 0));
		labelNombre.setText("Nombre:");

		JButton btnNewButton = new JButton("\u00BFComo Jugar?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Agregar accion para ver las reglas
				VentanaInstrucciones ventana2 = new VentanaInstrucciones();
				ventana2.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(255, 165, 0));
		btnNewButton.setBackground(new Color(255, 250, 205));
		btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 26));

		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap(384, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(labelNombre, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelId, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
								.addComponent(botonJugar, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
								.addGap(368))
						.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup().addContainerGap(180, Short.MAX_VALUE).addComponent(labelNombre)
						.addGap(6).addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(labelId, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGap(6).addComponent(txtId, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(botonJugar, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addGap(43)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		getContentPane().setLayout(layout);

		pack();
	}

	private void botonJugarActionPerformed(ActionEvent evt) {
		txtNombre.setText("\"Bienvenido\"");
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(PantallaInicio.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(PantallaInicio.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(PantallaInicio.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(PantallaInicio.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PantallaInicio().setVisible(true);
			}
		});
	}

}
