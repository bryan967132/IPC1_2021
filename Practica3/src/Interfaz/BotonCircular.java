package Interfaz;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Variables.Estatico;
public class BotonCircular extends JButton implements MouseListener,Runnable {
	private static final long serialVersionUID = 1L;
	public static boolean max = false,min = false;
	int x,y,lado;
	JLabel logo;
	String imagen;
	public BotonCircular(String imagen,int x,int y,int lado) {
		this.x = x;
		this.y = y;
		this.lado = lado;
		this.imagen = imagen;
		this.setLayout(null);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setBounds(x,y,lado,lado);
		this.addMouseListener(this);
		logo = new JLabel();
		logo.setBounds(0,0,lado,lado);
		logo.setLayout(null);
        logo.setIcon(imagenB(imagen,lado));
		pantalla();
	}
	public void pantalla(){
		this.add(logo);
	}
	public void run() {
		try {
			int a = this.getWidth();
			if(a <= lado) {
				new Sonido(Estatico.sobre);
				this.removeAll();
				for(int i=1; i<=5; i++) {
					a += i;
					pantalla();
					this.setBounds(x+lado/2-a/2,y+lado/2-a/2,a,a);
					logo.setSize(a,a);
					logo.setIcon(imagenB(imagen,a));
					Thread.sleep(40);
				}
				this.removeAll();
				for(int i=5; i>=0; i--) {
					a -= i;
					pantalla();
					this.setBounds(x+lado/2-a/2,y+lado/2-a/2,a,a);
					logo.setSize(a,a);
					logo.setIcon(imagenB(imagen,a));
					Thread.sleep(40);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Icon imagenB(String imagen,int lado) {
		ImageIcon img = new ImageIcon(imagen);
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(logo.getWidth(),logo.getHeight(),Image.SCALE_DEFAULT));
        return icono;
	}
	public void mouseEntered(MouseEvent e) {
		Thread hilo = new Thread(this);
		hilo.start();
	}
	public void mouseClicked(MouseEvent e) {new Sonido(Estatico.click);}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}