package Interfaz;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Icono extends JLabel {
	private static final long serialVersionUID = 1L;
	public Icono(String imagen,int l) {
        this.setBounds(1,1,l-2,l-2);
		ImageIcon img = new ImageIcon(imagen);
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_DEFAULT));
        this.setIcon(icono);
	}
	public Icono(String imagen,int w,int h) {
        this.setBounds(0,0,w,h);
		ImageIcon img = new ImageIcon(imagen);
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_DEFAULT));
        this.setIcon(icono);
	}
	public Icono(String imagen,int x,int y,int w,int h) {
        this.setBounds(x,y,w,h);
		ImageIcon img = new ImageIcon(imagen);
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_DEFAULT));
        this.setIcon(icono);
	}
	public Icono(int x,int y,String imagen,int l) {
		this.setBounds(x,y,l,l);
		ImageIcon img = new ImageIcon(imagen);
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_DEFAULT));
        this.setIcon(icono);
	}
}
