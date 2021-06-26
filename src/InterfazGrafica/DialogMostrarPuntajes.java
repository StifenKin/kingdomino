package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class DialogMostrarPuntajes extends JDialog {

	private static final long serialVersionUID = 1505741507173986132L;
	private final JPanel contentPanel = new JPanel();

	public DialogMostrarPuntajes(VentanaPartida ventana) {
		this.setTitle("Mostrar Puntajes");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		{
			JPanel puntajePane = new JPanel();
			puntajePane.setLayout(null);
			getContentPane().add(puntajePane, BorderLayout.CENTER);
			{

				JTextArea textAreaJugador = new JTextArea();
				textAreaJugador.setEditable(false);
				textAreaJugador.setFont(new Font("Consola", Font.BOLD, 14));
				String linea = "\nJugador\n\n";
				textAreaJugador.append(linea);
				for (int i = 0; i < ventana.getSala().getCantJugadores(); i++) {
					linea = ventana.getSala().getJugadores().get(i).getNombreJugador() + "\n";
					textAreaJugador.append(linea);
				}
				textAreaJugador.setBounds(15, 50, 300, 150);
				puntajePane.add(textAreaJugador);

				JTextArea textAreaPuntaje = new JTextArea();
				textAreaPuntaje.setEditable(false);
				textAreaPuntaje.setFont(new Font("Consola", Font.BOLD, 14));
				linea = "\nPuntaje\n\n";
				textAreaPuntaje.append(linea);
				for (int i = 0; i < ventana.getSala().getCantJugadores(); i++) {
					linea = ventana.getSala().getJugadores().get(i).getPuntaje() + "\n";
					textAreaPuntaje.append(linea);
				}
				textAreaPuntaje.setBounds(315, 50, 100, 150);
				puntajePane.add(textAreaPuntaje);

			}
		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cerrarButton = new JButton("Cerrar");
				cerrarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(cerrarButton);
			}
		}
	}

}
