package AnimacionObjetosJuego;
import javax.swing.JPanel;
import Interfaz.Icono;
public class Explosion implements Runnable {
	static JPanel nave;
	static String bum = "";
	public Explosion(JPanel nave,String color) {
		Explosion.nave = nave;
		Explosion.bum = color;
		Thread animacion = new Thread(this);
		animacion.start();
	}
	public void run() {
		try {
			for(int i = 1; i <= 100; i++) {
				if(i <= 10){
					Efecto(AnimacionObjetosJuego.Explosion.nave,"imagenes/Efectos/Explosion1.png");	
				}else if(i <= 20) {
					Efecto(AnimacionObjetosJuego.Explosion.nave,"imagenes/Efectos/Explosion2.png");	
				}else if(i <= 30) {
					Efecto(AnimacionObjetosJuego.Explosion.nave,"imagenes/Efectos/Explosion3.png");	
				}else if(i <= 40) {
					Efecto(AnimacionObjetosJuego.Explosion.nave,"imagenes/Efectos/Explosion4.png");	
				}else if(i <= 50) {
					Efecto(AnimacionObjetosJuego.Explosion.nave,"imagenes/Efectos/Explosion5.png");	
				}else if(i <= 60) {
					Efecto(AnimacionObjetosJuego.Explosion.nave,"imagenes/Efectos/Explosion6.png");	
				}else if(i <= 70) {
					Efecto(AnimacionObjetosJuego.Explosion.nave,"imagenes/Efectos/Explosion7.png");	
				}else if(i <= 80) {
					Efecto(AnimacionObjetosJuego.Explosion.nave,"imagenes/Efectos/Explosion8.png");	
				}else if(i <= 90) {
					Efecto(AnimacionObjetosJuego.Explosion.nave,"imagenes/Efectos/Explosion9.png");	
				}else if(i == 100) {
					Eliminar(AnimacionObjetosJuego.Explosion.nave);
				}
				Thread.sleep(2);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		bum = "";
	}
	public JPanel Efecto(JPanel nave,String imagen) {
		nave.removeAll();
		nave.setVisible(false);
		nave.add(new Icono(imagen,55));
		nave.setVisible(true);
		return nave;
	}
	public JPanel Eliminar(JPanel nave) {
		nave.setVisible(false);
		
		return nave;
	}
}
