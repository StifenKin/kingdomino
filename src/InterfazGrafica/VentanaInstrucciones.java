package InterfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;


public class VentanaInstrucciones extends JFrame {

	ImagenesFondoInstrucciones fondo = new ImagenesFondoInstrucciones("1");
	JButton botonSig = new JButton(">");
	JButton botonAnt = new JButton("<");
	String numInstruccion = "1";
	
	public VentanaInstrucciones() {
		setTitle("KingDomino-Instrucciones");
		this.setContentPane(fondo);

		initComponents();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		

		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		
		
		botonSig.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ImagenesFondoInstrucciones fondoSig;
				if(numInstruccion.equals("1")) {
						fondoSig = new ImagenesFondoInstrucciones("2");
					numInstruccion = "2";
				}else if(numInstruccion.equals("2")) {
					 fondoSig = new ImagenesFondoInstrucciones("3");
					numInstruccion = "3";
				}else {
						fondoSig = new ImagenesFondoInstrucciones("4");
					numInstruccion = "4";
				}
				getContentPane().removeAll();
				setContentPane(fondoSig);
				revalidate(); 
				repaint();
				
				botonSig.setOpaque(false);
				botonSig.setBackground(new Color(0,0,0,0));
				botonSig.setForeground(new Color(0, 0, 0));
				botonSig.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 26));
				
				
				botonAnt.setOpaque(false);
				botonAnt.setForeground(Color.BLACK);
				botonAnt.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 26));
				botonAnt.setBackground(new Color(0, 0, 0, 0));

				GroupLayout layout = new GroupLayout(getContentPane());
				layout.setHorizontalGroup(
					layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(botonAnt, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 948, Short.MAX_VALUE)
							.addComponent(botonSig))
				);
				layout.setVerticalGroup(
					layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addContainerGap(471, Short.MAX_VALUE)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(botonSig, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(botonAnt, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
				);
				getContentPane().setLayout(layout);
				getContentPane().setPreferredSize(new Dimension(615,539));
				
				pack();
				
			}
		});
		botonSig.setOpaque(false);
		botonSig.setBackground(new Color(0,0,0,0));
		botonSig.setForeground(new Color(0, 0, 0));
		botonSig.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 26));
		botonAnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ImagenesFondoInstrucciones fondoAnt;
				if(numInstruccion.equals("4")) {
					fondoAnt = new ImagenesFondoInstrucciones("3");
					numInstruccion = "3";
				}else if(numInstruccion.equals("3")) {
					fondoAnt = new ImagenesFondoInstrucciones("2");
					numInstruccion = "2";
				}else {
					fondoAnt = new ImagenesFondoInstrucciones("1");
					numInstruccion = "1";
				}
				getContentPane().removeAll();
				setContentPane(fondoAnt);
				revalidate(); 
				repaint();
				
				botonSig.setOpaque(false);
				botonSig.setBackground(new Color(0,0,0,0));
				botonSig.setForeground(new Color(0, 0, 0));
				botonSig.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 26));
				
				
				botonAnt.setOpaque(false);
				botonAnt.setForeground(Color.BLACK);
				botonAnt.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 26));
				botonAnt.setBackground(new Color(0, 0, 0, 0));

				GroupLayout layout = new GroupLayout(getContentPane());
				layout.setHorizontalGroup(
					layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(botonAnt, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 948, Short.MAX_VALUE)
							.addComponent(botonSig))
				);
				layout.setVerticalGroup(
					layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addContainerGap(471, Short.MAX_VALUE)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(botonSig, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(botonAnt, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
				);
				getContentPane().setLayout(layout);
				getContentPane().setPreferredSize(new Dimension(615,539));
				pack();
			}
		});
		
		
		botonAnt.setOpaque(false);
		botonAnt.setForeground(Color.BLACK);
		botonAnt.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 26));
		botonAnt.setBackground(new Color(0, 0, 0, 0));

		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(botonAnt, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 948, Short.MAX_VALUE)
					.addComponent(botonSig))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(471, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(botonSig, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonAnt, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
		);
		getContentPane().setLayout(layout);
		getContentPane().setPreferredSize(new Dimension(615,539));
		pack();
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
			Logger.getLogger(VentanaInstrucciones.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(VentanaInstrucciones.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(VentanaInstrucciones.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(VentanaInstrucciones.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				VentanaInstrucciones ventana = new VentanaInstrucciones();
				ventana.setVisible(true);
				ventana.setSize(615,539);
			}
		});
	}
}
