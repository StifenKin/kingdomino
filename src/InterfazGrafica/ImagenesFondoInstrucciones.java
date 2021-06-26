package InterfazGrafica;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


	public class ImagenesFondoInstrucciones extends JPanel{
		
		private ImageIcon icon;
	
		public ImagenesFondoInstrucciones(String num) {
	         this.icon = new ImageIcon(getClass().getResource("/imagenes/Instrucciones"+ num + ".jpg"));
		}

	    @Override
	    public void paint(Graphics g){
//	        Dimension dimension = new Dimension(615, 539);
	    	Dimension dimension = this.getSize();
//	        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Instrucciones1.jpg"));

	        g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
	        setOpaque(false);
	        super.paintChildren(g);
	    }
	    
	}
	
