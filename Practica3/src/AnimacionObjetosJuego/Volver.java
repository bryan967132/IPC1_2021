package AnimacionObjetosJuego;
import javax.swing.JPanel;
public class Volver implements Runnable {
	public static boolean entrada = true,salida = false;
	JPanel ventana;
	public Volver(JPanel ventana) {
		this.ventana = ventana;
		Thread hilo = new Thread(this);
		hilo.start();
	}
	public void run() {
		try {
			if(entrada) {
				for(int i = 570; i >= 150; i--) {
					ventana.setLocation(ventana.getX(),i);
					Thread.sleep(1);
				}
				entrada = false;
			}
			if(salida) {
				for(int i = 150; i <= 570; i++) {
					ventana.setLocation(ventana.getX(),i);
					Thread.sleep(1);
				}
				salida = false;
			}
		}catch(Exception e) {
			
		}
	}
}