package AnimacionObjetosJuego;
import java.awt.Color;
import javax.swing.JPanel;
import Interfaz.Etiqueta;
import PantallaJuego.Espacio;
public class Victoria implements Runnable {
	JPanel victoria;
	String texto1,texto2;
	public Victoria(JPanel victoria,String texto1,String texto2) {
		this.victoria = victoria;
		this.texto1 = texto1;
		this.texto2 = texto2;
		Thread hilo = new Thread(this);
		hilo.start();
	}
	public void run() {
		try {
			int textoT = 80;
			for(int i = 120; i >= 0; i--) {				
				if(i == 120) {
					winner(victoria,texto1,new Color(221,172,0,0),textoT);
				}else if(i == 115) {
					winner(victoria,texto1,new Color(221,172,0,51),textoT);
				}else if(i == 110) {
					winner(victoria,texto1,new Color(221,172,0,102),textoT);
				}else if(i == 105) {
					winner(victoria,texto1,new Color(221,172,0,153),textoT);
				}else if(i == 100) {
					winner(victoria,texto1,new Color(221,172,0,204),textoT);
				}else if(i == 95) {
					winner(victoria,texto1,new Color(221,172,0,255),textoT);
				}else if(i == 85) {
					winner(victoria,texto1,new Color(221,172,0,204),textoT);
				}else if(i == 80) {
					winner(victoria,texto1,new Color(221,172,0,153),textoT);
				}else if(i == 75) {
					winner(victoria,texto1,new Color(221,172,0,102),textoT);
				}else if(i == 70) {
					winner(victoria,texto1,new Color(221,172,0,51),textoT);
				}else if(i == 65) {
					winner(victoria,texto1,new Color(221,172,0,0),textoT);
				}else if(i == 60) {
					winner(victoria,texto2,new Color(221,172,0,0),textoT);
				}else if(i == 55) {
					winner(victoria,texto2,new Color(221,172,0,51),textoT);
				}else if(i == 50) {
					winner(victoria,texto2,new Color(221,172,0,102),textoT);
				}else if(i == 45) {
					winner(victoria,texto2,new Color(221,172,0,153),textoT);
				}else if(i == 40) {
					winner(victoria,texto2,new Color(221,172,0,204),textoT);
				}else if(i == 35) {
					winner(victoria,texto2,new Color(221,172,0,255),textoT);
				}else if(i == 25) {
					winner(victoria,texto2,new Color(221,172,0,204),textoT);
				}else if(i == 20) {
					winner(victoria,texto2,new Color(221,172,0,153),textoT);
				}else if(i == 15) {
					winner(victoria,texto2,new Color(221,172,0,102),textoT);
				}else if(i == 10) {
					winner(victoria,texto2,new Color(221,172,0,51),textoT);
				}else if(i == 5) {
					winner(victoria,texto2,new Color(221,172,0,0),textoT);
				}else if(i == 0) {
					victoria.removeAll();
					victoria.setVisible(false);
				}
				Thread.sleep(34);
			}
			Volver.entrada = true;
			new Volver(Espacio.ventana);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public JPanel winner(JPanel panel,String texto,Color colorF,int fuente) {
		panel.removeAll();
		panel.setVisible(false);
		panel.add(new Etiqueta(0,0,panel.getWidth(),panel.getHeight(),texto,colorF,fuente));
		panel.setVisible(true);
		return panel;
	}
}