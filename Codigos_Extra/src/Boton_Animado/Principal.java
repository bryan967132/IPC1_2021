package Boton_Animado;
import java.awt.Color;
import javax.swing.JFrame;
public class Principal {
	public static void main(String[] args) {
		Ventana pantalla = new Ventana();
		int x = pantalla.getWidth()/2,y = 50,w = 280,h = 60;
		
		Boton botonA = new Boton();
		botonA.PosicionTamaño(x-w/2,y,w,h);//posX,posY,ancho,alto
		botonA.Texto("Boton Azul Animado",Color.white,20);//texto,colorfuente,tamañofuente
		botonA.Diseño(5,new Color(22,111,148),new Color(53,186,243));//grosorborde,coloborde,colorfondo
		botonA.Animar(5);//aumento de tamaño
		pantalla.add(botonA);
		
		Boton botonV = new Boton();
		botonV.PosicionTamaño(x-w/2,y+h+10,w,h);
		botonV.Texto("Boton Verde Animado",Color.white,20);
		botonV.Diseño(5,new Color(77,149,30),new Color(118,203,63));
		botonV.Animar(5);pantalla.add(botonV);
		
		Boton botonR = new Boton();
		botonR.PosicionTamaño(x-w/2,y+2*h+20,w,h);
		botonR.Texto("Boton Rojo Animado",Color.white,20);
		botonR.Diseño(5,new Color(128,43,43),new Color(254,50,53));
		botonR.Animar(5);
		pantalla.add(botonR);
	}
}
class Ventana extends JFrame {
	private static final long serialVersionUID = 1L;
	public Ventana() {
		this.getContentPane().setBackground(Color.black);
		this.setLayout(null);
		this.setSize(350,350);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}