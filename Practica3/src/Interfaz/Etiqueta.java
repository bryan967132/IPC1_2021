package Interfaz;
import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Variables.Estatico;
public class Etiqueta extends JLabel {
	private static final long serialVersionUID = 1L;
	public Etiqueta(int x,int y,int w,int l,String texto,Color colorF,int fuente) {
		this.setText(texto);
		this.setForeground(colorF);
		this.setBounds(x,y,w,l);
		this.setFont(Estatico.fuente.fuente(Estatico.fuente.GAME,0,fuente)); 
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.CENTER);
	}
	public Etiqueta(int w,int l,String imagen) {
		this.setLayout(null);
		this.setBounds(0,0,w,l);
		ImageIcon img = new ImageIcon(imagen);
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_DEFAULT));
        this.setIcon(icono);
	}
	public Etiqueta(int x,int y,int w,int l,String imagen) {
		this.setLayout(null);
		this.setBounds(x,y,w,l);
		ImageIcon img = new ImageIcon(imagen);
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_DEFAULT));
        this.setIcon(icono);
	}
	public Etiqueta(String texto,int x,int y,int w,int l,Color colorF,int fuente) {
		this.setText(texto);
		this.setForeground(colorF);
		this.setBounds(x,y,w,l);
		this.setFont(Estatico.fuente.fuente(Estatico.fuente.GAME,0,fuente));
		this.setVerticalAlignment(JLabel.CENTER);
	}
}