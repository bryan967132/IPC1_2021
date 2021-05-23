package Interfaz;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import Variables.Estatico;
public class Boton extends JButton implements MouseListener,Runnable {
	private static final long serialVersionUID = 1L;
	int x,y,w,mov,sizeBorde;
	JLabel titulo,logo;
	String fondo;
	public Boton(int sizeBorde,int fuente,String texto,Color borde,String fondo,Color colorF,int x,int y,int w,int h) {
		this.sizeBorde = sizeBorde;
		this.x = x;
		this.y = y;
		this.w = w;
		this.fondo = fondo;
		this.setLayout(null);
		this.setContentAreaFilled(false);
		this.addMouseListener(this);
		titulo = new Etiqueta(0,2,w,h,texto,colorF,fuente);
		this.add(titulo);
		this.setBorder(BorderFactory.createLineBorder(borde,sizeBorde));
		this.setBounds(x,y,w,h);
		this.setVisible(true);
		logo = new JLabel();
		logo.setBounds(sizeBorde,sizeBorde,w-2*sizeBorde,h-2*sizeBorde);
		logo.setLayout(null);
        logo.setIcon(imagenB(fondo));
		this.add(logo);
	}
	public void run() {
		try {
			int a = this.getWidth();
			int h = this.getHeight();
			if(a <= w) {
				new Sonido(Estatico.sobre);
				for(int i=1; i<=6; i++) {
					a += i;
					if(i%2 == 0) {
						h += i;
					}
					this.setBounds(x+w/2-a/2,y-i,a,h);
					titulo.setSize(a,h);
					logo.setBounds(sizeBorde,sizeBorde,a-2*sizeBorde,h-2*sizeBorde);
					logo.setIcon(imagenB(fondo));
					Thread.sleep(40);
				}
				for(int i=6; i>=1; i--) {
					a -= i;
					if(i%2 == 0) {
						h -= i;
					}
					this.setBounds(x+w/2-a/2,y-i,a,h);
					titulo.setSize(a,h);
					logo.setBounds(sizeBorde,sizeBorde,a-2*sizeBorde,h-2*sizeBorde);
					logo.setIcon(imagenB(fondo));
					Thread.sleep(40);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Icon imagenB(String imagen) {
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