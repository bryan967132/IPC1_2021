package PantallaJuego;
import java.awt.Color;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Interfaz.Desvanecer;
import Interfaz.Icono;
public class Ventana extends JFrame {
	private static final long serialVersionUID = 1L;
	public Inicio inicio;
	public Espacio espacio;
	public Configuracion configuracion;
	public Top5 maximos;
	public static JPanel anuncios;
	public Ventana() {
		super("Invasores Espaciales");
		this.setLayout(null);
		pantalla();
		this.setDefaultCloseOperation(3);
		this.getContentPane().setBackground(Color.black);
		this.setSize(1250,605);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	public void pantalla() {
		anuncios = new JPanel();
		anuncios.setBounds(0,215,1250,175);
		anuncios.setOpaque(false);
		anuncios.setLayout(null);
		this.add(new Desvanecer(0,51,"imagenes/Efectos/DesvanecerI.png"));
		this.add(new Desvanecer(1204,51,"imagenes/Efectos/DesvanecerD.png"));
		inicio = new Inicio();
		espacio = new Espacio();
		configuracion = new Configuracion();
		maximos = new Top5();
		this.add(anuncios);
		this.add(inicio);
		this.add(espacio);
		this.add(configuracion);
		this.add(maximos);
		Random random = new Random();
		for(int i=0; i<=10; i+=2) {
			for(int j=0; j<=10; j+=2) {
				int abs = random.nextInt(1250)+1;
				int ord = random.nextInt(605)+1;
				this.getContentPane().add(new Icono(abs,ord,"imagenes/Astros/Estrella1.png",6));
			}
		}
		for(int i=0; i<=10; i+=2) {
			for(int j=0; j<=10; j+=2) {
				int abs = random.nextInt(1250)+1;
				int ord = random.nextInt(605)+1;
				this.getContentPane().add(new Icono(abs,ord,"imagenes/Astros/Estrella2.png",6));
			}
		}
		for(int i=0; i<=10; i+=2) {
			for(int j=0; j<=10; j+=2) {
				int abs = random.nextInt(1250)+1;
				int ord = random.nextInt(605)+1;
				this.getContentPane().add(new Icono(abs,ord,"imagenes/Astros/Estrella3.png",6));
			}
		}
		this.getContentPane().add(new Icono(200,100,"imagenes/Astros/jupiter.png",30));
		this.getContentPane().add(new Icono(300,500,"imagenes/Astros/neptuno.png",40));
		this.getContentPane().add(new Icono(840,150,"imagenes/Astros/saturno.png",80));
		this.getContentPane().add(new Icono(500,320,"imagenes/Astros/tierra.png",50));
	}
	public void play() {
		Thread transicion = new Thread(espacio);
		transicion.start();
	}
	public void setting() {
		Thread transicion = new Thread(configuracion);
		transicion.start();
	}
	public void top() {
		Thread transicion = new Thread(maximos);
		transicion.start();
	}
}