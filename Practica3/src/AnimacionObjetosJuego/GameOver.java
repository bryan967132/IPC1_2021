package AnimacionObjetosJuego;
import java.awt.Color;
import javax.swing.JPanel;
import Interfaz.Etiqueta;
import PantallaJuego.Espacio;
public class GameOver implements Runnable {
	JPanel gameover;
	String texto;
	public GameOver(JPanel gameover,String texto) {
		this.gameover = gameover;
		this.texto = texto;
		Thread hilo = new Thread(this);
		hilo.start();
	}
	public void run() {
		try {
			int textoT = 80;
			for(int i = 60; i >= 0; i--) {
				if(i == 60) {
					loose(gameover,texto,new Color(254,50,53,0),textoT);
				}
				if(i == 55) {
					loose(gameover,texto,new Color(254,50,53,51),textoT);
				}
				if(i == 50) {
					loose(gameover,texto,new Color(254,50,53,102),textoT);
				}
				if(i == 45) {
					loose(gameover,texto,new Color(254,50,53,153),textoT);
				}
				if(i == 40) {
					loose(gameover,texto,new Color(254,50,53,204),textoT);
				}
				if(i == 35) {
					loose(gameover,texto,new Color(254,50,53,255),textoT);
				}
				if(i == 25) {
					loose(gameover,texto,new Color(254,50,53,204),textoT);
				}
				if(i == 20) {
					loose(gameover,texto,new Color(254,50,53,153),textoT);
				}
				if(i == 15) {
					loose(gameover,texto,new Color(254,50,53,102),textoT);
				}
				if(i == 10) {
					loose(gameover,texto,new Color(254,50,53,51),textoT);
				}
				if(i == 5) {
					loose(gameover,texto,new Color(254,50,53,0),textoT);
				}
				if(i == 0) {
					gameover.removeAll();
					gameover.setVisible(false);
					Volver.entrada = true;
					new Volver(Espacio.ventana);
				}
				Thread.sleep(35);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public JPanel loose(JPanel panel,String texto,Color colorF,int fuente) {
		panel.removeAll();
		panel.setVisible(false);
		panel.add(new Etiqueta(0,0,panel.getWidth(),panel.getHeight(),texto,colorF,fuente));
		panel.setVisible(true);
		return panel;
	}
}