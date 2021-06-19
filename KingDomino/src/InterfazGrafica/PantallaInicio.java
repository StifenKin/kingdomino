package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

    
	public class PantallaInicio extends JFrame{
	    
		ImagenFondo panel = new ImagenFondo();
	       
	    public PantallaInicio(){
	        
	        this.setTitle("Ventana con Imagen");
	        this.setSize(new Dimension(700, 700));        
	        this.setLocationRelativeTo(null);
	        
	        this.add(panel, BorderLayout.CENTER);
	    }

	    public static void main(String [] args){
	    	PantallaInicio frame = new PantallaInicio();
	        frame.setVisible(true);
	    }
	    
	    
	}
	 