package PantallaJuego;
import static Ajustes.ControladorAjustes.config;
import static Interfaz.Colores.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import AnimacionObjetosJuego.EnemigoMovimiento;
import Interfaz.Boton;
import Interfaz.Etiqueta;
import Main.Principal;
import Nave.Jugador;
import Variables.Estatico;
public class Inicio extends JPanel implements ActionListener,Runnable {
	private static final long serialVersionUID = 1L;
	public static boolean salida,entrada;
	int x = 625,y = 180,w = 280,h = 60,h1 = 85;
	Boton jugar,configuracion,puntuacion,salir;
	public Inicio() {
		this.setBounds(0,0,1250,605);		
		this.setOpaque(false);
		this.setLayout(null);
		pantalla();
	}
	public void pantalla() {
		Etiqueta titulo = new Etiqueta(0,0,1250,180,"Invasores Espaciales",lilaC,60);
		this.add(titulo);
		
		jugar = new Boton(5,35,"Jugar",celesteO,Estatico.celesteC,blanco,x-w/2,y,w,h);		
		jugar.addActionListener(this);
		this.add(jugar);
		
		configuracion = new Boton(5,35,"Configuración",celesteO,Estatico.celesteC,blanco,x-w/2,y+h1,w,h);
		configuracion.addActionListener(this);
		this.add(configuracion);
		
		puntuacion = new Boton(5,35,"Puntuación Máxima",celesteO,Estatico.celesteC,blanco,x-w/2,y+2*h1,w,h);
		puntuacion.addActionListener(this);
		this.add(puntuacion);
		
		salir = new Boton(5,35,"Salir",celesteO,Estatico.celesteC,blanco,x-w/2,y+3*h1,w,h);
		salir.addActionListener(this);
		this.add(salir);
	}
	public void run() {
		try {
			if(salida){
				for(int i=0; i >= -1234; i -= 2) {
					this.setLocation(i,0);
					Thread.sleep(1);
				}
				salida = false;
				this.removeAll();
				this.setVisible(false);
			}
			if(entrada) {
				pantalla();
				this.setVisible(true);
				for(int i=-1234; i <= 0; i += 2) {
					this.setLocation(i,0);
					Thread.sleep(1);
				}
				entrada = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jugar) {
			Espacio.entrada = true;
			if(config[0].getVel().equals("Normal")) {
				EnemigoMovimiento.lento = 70;
				Jugador.deltaS = 11;
				AnimacionObjetosJuego.Laser.laserV = 2;
			}else {
				EnemigoMovimiento.lento = 60;
				Jugador.deltaS = 17;
				AnimacionObjetosJuego.Laser.laserV = 3;
			}
			Estatico.revivir();
			Nave.Jugador.alerta1 = true;
			Nave.Jugador.alerta2 = true;
			EnemigoMovimiento.hPrimario = true;
			EnemigoMovimiento.hSecundario = false;
			Jugador.puntos = 0;
			salida = true;
			EstadoBarra.velocidad = 0;
			Espacio.barraE.puntos();
			Espacio.barraE.velocidad();
			EstadoBarra.digito(config[0].getTmp());
			Principal.pantalla.play();
			Thread transicion = new Thread(this);
			transicion.start();
		}
		if(e.getSource() == configuracion) {
			salida = true;
			Configuracion.entrada = true;
			Principal.pantalla.setting();
			Thread transicion = new Thread(this);
			transicion.start();
		}
		if(e.getSource() == puntuacion) {
			Top5.entrada = true;
			Principal.pantalla.top();
			salida = true;
			Thread transicion = new Thread(this);
			transicion.start();
		}
		if(e.getSource() == salir) {
			System.exit(0);
		}
	}
}