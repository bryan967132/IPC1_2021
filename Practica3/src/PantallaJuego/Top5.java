package PantallaJuego;
import static Interfaz.Colores.*;
import static Puntajes.ControladorPuntaje.ranking;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import Interfaz.BotonCircular;
import Interfaz.Etiqueta;
import Main.Principal;
import Variables.Estatico;
public class Top5 extends JPanel implements Runnable,ActionListener {
	private static final long serialVersionUID = 1L;
	public static boolean entrada,salida = false;
	BotonCircular regresar;
	public Top5() {
		this.setBounds(1234,0,1250,605);		
		this.setOpaque(false);
		this.setLayout(null);
	}
	public void pantalla() {
		this.add(new Etiqueta(0,0,1250,180,"Máximas Puntuaciones",blanco,60));
		regresar = new BotonCircular(Estatico.volver,70,51,50);
		regresar.addActionListener(this);
		this.add(regresar);
		try {
			this.add(new Etiqueta(0,70,1250,180,ranking[0].getPuntos()+" Pts. "+ranking[0].getNombre(),amarillo,60));
			this.add(new Etiqueta(0,140,1250,180,ranking[1].getPuntos()+" Pts. "+ranking[1].getNombre(),amarillo,60));
			this.add(new Etiqueta(0,210,1250,180,ranking[2].getPuntos()+" Pts. "+ranking[2].getNombre(),amarillo,60));
			this.add(new Etiqueta(0,280,1250,180,ranking[3].getPuntos()+" Pts. "+ranking[3].getNombre(),amarillo,60));
			this.add(new Etiqueta(0,350,1250,180,ranking[4].getPuntos()+" Pts. "+ranking[4].getNombre(),amarillo,60));
		}catch(Exception e) {
			
		}
	}
	public void run() {
		try {
			if(entrada) {
				pantalla();
				for(int i = 1234; i >= 0; i -= 2) {
					this.setLocation(i,0);
					Thread.sleep(1);
				}
				entrada = false;
			}
			if(salida){
				for(int i=0; i <= 1234; i += 2) {
					this.setLocation(i,0);
					Thread.sleep(1);
				}
				salida = false;
				this.removeAll();
			}
		}catch(Exception e) {
			
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == regresar) {
			salida = true;
			Inicio.entrada = true;
			Thread transicion = new Thread(this);
			Thread inicio = new Thread(Principal.pantalla.inicio);
			transicion.start();
			inicio.start();
		}
	}
}