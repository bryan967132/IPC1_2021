package AnimacionObjetosJuego;
import java.awt.Color;
import javax.swing.JPanel;
import Interfaz.Etiqueta;
import Interfaz.Sonido;
import Variables.Estatico;
public class InicioPartida implements Runnable {
	JPanel cuenta;
	public InicioPartida(JPanel cuenta) {
		this.cuenta = cuenta;
		Thread hilo = new Thread(this);
		hilo.start();
	}
	public void run() {
		try {
			int numeroT = 150;
			int texto = 80;
			for(int i = 120; i >= 0; i--) {
				if(i == 120) {
					numero(cuenta,"3",new Color(0,104,221,255),numeroT);
					new Sonido(Estatico.cuenta);
				}
				if(i == 115) {
					numero(cuenta,"3",new Color(0,104,221,204),numeroT);
				}
				if(i == 110) {
					numero(cuenta,"3",new Color(0,104,221,153),numeroT);
				}
				if(i == 105) {
					numero(cuenta,"3",new Color(0,104,221,102),numeroT);
				}
				if(i == 100) {
					numero(cuenta,"3",new Color(0,104,221,51),numeroT);
				}
				if(i == 95) {
					numero(cuenta,"3",new Color(0,104,221,0),numeroT);
				}
				if(i == 90) {
					numero(cuenta,"2",new Color(0,104,221,255),numeroT);
					new Sonido(Estatico.cuenta);
				}
				if(i == 85) {
					numero(cuenta,"2",new Color(0,104,221,204),numeroT);
				}
				if(i == 80) {
					numero(cuenta,"2",new Color(0,104,221,153),numeroT);
				}
				if(i == 75) {
					numero(cuenta,"2",new Color(0,104,221,102),numeroT);
				}
				if(i == 70) {
					numero(cuenta,"2",new Color(0,104,221,51),numeroT);
				}
				if(i == 65) {
					numero(cuenta,"2",new Color(0,104,221,0),numeroT);
				}
				if(i == 60) {
					numero(cuenta,"1",new Color(0,104,221,255),numeroT);
					new Sonido(Estatico.cuenta);
				}
				if(i == 55) {
					numero(cuenta,"1",new Color(0,104,221,204),numeroT);
				}
				if(i == 50) {
					numero(cuenta,"1",new Color(0,104,221,153),numeroT);
				}
				if(i == 45) {
					numero(cuenta,"1",new Color(0,104,221,102),numeroT);
				}
				if(i == 40) {
					numero(cuenta,"1",new Color(0,104,221,51),numeroT);
				}
				if(i == 35) {
					numero(cuenta,"1",new Color(0,104,221,0),numeroT);
				}
				if(i == 30) {
					numero(cuenta,"¡Defiende La Galaxia!",new Color(0,104,221,255),texto);
					new Sonido(Estatico.go);
				}
				if(i == 25) {
					numero(cuenta,"¡Defiende La Galaxia!",new Color(0,104,221,204),texto);
				}
				if(i == 20) {
					numero(cuenta,"¡Defiende La Galaxia!",new Color(0,104,221,153),texto);
				}
				if(i == 15) {
					numero(cuenta,"¡Defiende La Galaxia!",new Color(0,104,221,102),texto);
				}
				if(i == 10) {
					numero(cuenta,"¡Defiende La Galaxia!",new Color(0,104,221,51),texto);
				}
				if(i == 5) {
					numero(cuenta,"¡Defiende La Galaxia!",new Color(0,104,221,0),texto);
				}
				if(i == 0) {
					cuenta.removeAll();
					cuenta.setVisible(false);
				}
				Thread.sleep(30);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public JPanel numero(JPanel panel,String texto,Color colorF,int fuente) {
		panel.removeAll();
		panel.setVisible(false);
		panel.add(new Etiqueta(0,0,panel.getWidth(),panel.getHeight(),texto,colorF,fuente));
		panel.setVisible(true);
		return panel;
	}
}