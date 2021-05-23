package AnimacionObjetosJuego;
import static Ajustes.ControladorAjustes.config;
import javax.swing.JPanel;
import Interfaz.Icono;
import Interfaz.Sonido;
import Main.Principal;
import PantallaJuego.Espacio;
import PantallaJuego.EstadoBarra;
import Variables.Estatico;
public class ItPlusV extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	int x;
	int y;
	public ItPlusV(int x,int y) {
		this.x = x;
		this.y = y;
		this.setSize(33,33);
		this.setOpaque(false);
		this.setLayout(null);
		Thread hilo = new Thread(this);
		hilo.start();
	}
	public void run() {
		try {
			int velocidad;
			if(config[0].getVel().equals("Normal")) {
				velocidad = 2;
			}else {
				velocidad = 3;
			}
			for(int i = x; i >= -30; i-=velocidad) {
				item(this);
				this.setLocation(i,y);
				if(EstadoBarra.hilo == true && this.getX() <= Espacio.player.getX()+55 &&
						((this.getY() >= Espacio.player.getY() && this.getY() <= Espacio.player.getY()+55) ||
						Espacio.player.getY() >= this.getY() && Espacio.player.getY() <= this.getY()+33)) {
					new Sonido(Estatico.aumento);
					this.setVisible(false);
					Principal.pantalla.espacio.remove(this);
					Nave.Jugador.deltaS+=6;
					Laser.laserV+=2;
					for(int t = 0; t <= 10; t++) {
						Thread.sleep(1000);
					}
					Nave.Jugador.deltaS-=2;
					Laser.laserV-=2;
					break;
				}
				Thread.sleep(20);
			}
			Principal.pantalla.espacio.remove(this);
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	public JPanel item(JPanel panel) {
		panel.add(new Icono(Estatico.item3,33,33));
		panel.setVisible(true);
		return panel;
	}
}