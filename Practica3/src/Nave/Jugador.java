package Nave;
import javax.swing.JPanel;
import Interfaz.Icono;
import Variables.Estatico;
public class Jugador extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	public JPanel[] laser = new JPanel[1000];
	public static boolean thread = false,alerta1 = true,alerta2 = true;
	public static int puntos = 0,deltaS;
	public int lasers = 0;
	String tecla;
	public Jugador() {
		int lado = 55;
		this.setOpaque(false);
		this.setLayout(null);
        this.add(new Icono("imagenes/Jugador/Jugador.png",lado));
        for (int i = 0; i < laser.length; i++) {
        	laser[i]= new JPanel();
        	laser[i].setSize(30,7);
        	laser[i].setLayout(null);
        	laser[i].setOpaque(false);
        	laser[i].add(new Icono(Estatico.azul,30,7));
        }
	}
	public void Desplazamiento(String tecla) {
		this.tecla = tecla;
		Thread hilo = new Thread(this);
		hilo.start();
	}
	public void run() {
		if(thread) {
			if(tecla.equals("subir")) {
				if(this.getY() > 60) {
					this.setLocation(30,this.getY()-deltaS);
				}
			}
			if(tecla.equals("bajar")) {
				if(this.getY() < 500) {
					this.setLocation(30,this.getY()+deltaS);
				}
			}
		}
	}
	public static void alto() {
		thread = false;
	}
	public static void mas10() {
		puntos+=10;
	}
	public static void menos10() {
		puntos-=10;
	}
	public static void mas20() {
		puntos+=20;
	}
	public static void mas30() {
		puntos+=30;
	}
}