package PantallaJuego;
import static Interfaz.Colores.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import AnimacionObjetosJuego.*;
import Interfaz.BotonCircular;
import Interfaz.Icono;
import Main.Principal;
import Nave.Enemigo;
import Nave.Jugador;
import Puntajes.ControladorPuntaje;
import Variables.Estatico;
public class Espacio extends JPanel implements ActionListener,KeyListener,Runnable {
	private static final long serialVersionUID = 1L;
	public static boolean entrada,salida = false;
	public int lasers = 0;
	public static Jugador player;
	public static EstadoBarra barraE = new EstadoBarra(0,0,1234,51,rojoC);
	public static JPanel ventana;
	BotonCircular atras = new BotonCircular(Estatico.volver,167,178,66);
	JTextField nick;
	Icono alerta;
	public Espacio() {
		this.setBounds(1234,0,1250,605);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setOpaque(false);
		this.setLayout(null);
	}
	public void pantalla() {
		ventana = new JPanel();
		ventana.setBounds(425,570,400,305);
		ventana.setOpaque(false);
		ventana.setBorder(BorderFactory.createLineBorder(verdeO,3));
		ventana.setLayout(null);
		
		JLabel nom = new JLabel("Nombre: ");
		nom.setBounds(75,61,120,30);
		nom.setFont(Estatico.fuente.fuente(Estatico.fuente.GAME,0,35));
		nom.setForeground(lilaC);
		ventana.add(nom);
		
		alerta = new Icono(Estatico.alerta,335,117,20,20);
		alerta.setVisible(false);
		ventana.add(alerta);
		
		nick = new JTextField();
		nick.setBounds(75,103,250,45);
		nick.setBorder(BorderFactory.createLineBorder(celesteO,2));
		nick.setFont(Estatico.fuente.fuente(Estatico.fuente.GAME,0,35));
		nick.setForeground(azul);
		ventana.add(nick);
		
		atras.addActionListener(this);
		ventana.add(atras);
		
		player = new Jugador();
		player.setBounds(30,280,55,55);
		
		this.add(ventana);
		this.add(player);
		this.add(barraE);
		Formacion();
		
		EnemigoMovimiento enemy = new EnemigoMovimiento();
		Thread avanceEnemigo = new Thread(enemy);
		avanceEnemigo.start();
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
	public void keyPressed(KeyEvent e) {
		if(e.getExtendedKeyCode() == KeyEvent.VK_UP) {
			player.Desplazamiento("subir");
		}else if(e.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
			player.Desplazamiento("bajar");
		}
	}
	public void keyReleased(KeyEvent e) {
		if(e.getExtendedKeyCode() == KeyEvent.VK_SPACE) {
			int y = player.getY()+24;
			lasers++;
			this.add(player.laser[lasers]);
			Laser hs = new Laser(y,player.laser[lasers],player);
			hs.start();
		}
	}
	public void keyTyped(KeyEvent e) {}
	public static Enemigo enemy1;	public static Enemigo enemy2;	public static Enemigo enemy3;	public static Enemigo enemy4;	public static Enemigo enemy5;
	public static Enemigo enemy6;	public static Enemigo enemy7;	public static Enemigo enemy8;	public static Enemigo enemy9;	public static Enemigo enemy10;
	public static Enemigo enemy11;	public static Enemigo enemy12;	public static Enemigo enemy13;	public static Enemigo enemy14;	public static Enemigo enemy15;
	public static Enemigo enemy16;	public static Enemigo enemy17;	public static Enemigo enemy18;	public static Enemigo enemy19;	public static Enemigo enemy20;
	public static Enemigo enemy21;	public static Enemigo enemy22;	public static Enemigo enemy23;	public static Enemigo enemy24;	public static Enemigo enemy25;
	public static Enemigo enemy26;	public static Enemigo enemy27;	public static Enemigo enemy28;	public static Enemigo enemy29;	public static Enemigo enemy30;
	public static Enemigo enemy31;	public static Enemigo enemy32;	public static Enemigo enemy33;	public static Enemigo enemy34;	public static Enemigo enemy35;
	public static Enemigo enemy36;	public static Enemigo enemy37;	public static Enemigo enemy38;	public static Enemigo enemy39;	public static Enemigo enemy40;
	public void Formacion() {
		enemy1 = new Enemigo(Estatico.imagen1);  enemy2 = new Enemigo(Estatico.imagen1);  enemy3 = new Enemigo(Estatico.imagen1);  enemy4 = new Enemigo(Estatico.imagen1);
		enemy5 = new Enemigo(Estatico.imagen1);  enemy6 = new Enemigo(Estatico.imagen1);  enemy7 = new Enemigo(Estatico.imagen1);  enemy8 = new Enemigo(Estatico.imagen1);
		enemy9 = new Enemigo(Estatico.imagen2);  enemy10 = new Enemigo(Estatico.imagen2); enemy11 = new Enemigo(Estatico.imagen2); enemy12 = new Enemigo(Estatico.imagen2);
		enemy13 = new Enemigo(Estatico.imagen2); enemy14 = new Enemigo(Estatico.imagen2); enemy15 = new Enemigo(Estatico.imagen2); enemy16 = new Enemigo(Estatico.imagen2);
		enemy17 = new Enemigo(Estatico.imagen2); enemy18 = new Enemigo(Estatico.imagen2); enemy19 = new Enemigo(Estatico.imagen2); enemy20 = new Enemigo(Estatico.imagen2);
		enemy21 = new Enemigo(Estatico.imagen2); enemy22 = new Enemigo(Estatico.imagen2); enemy23 = new Enemigo(Estatico.imagen2); enemy24 = new Enemigo(Estatico.imagen2);
		enemy25 = new Enemigo(Estatico.imagen3); enemy26 = new Enemigo(Estatico.imagen3); enemy27 = new Enemigo(Estatico.imagen3); enemy28 = new Enemigo(Estatico.imagen3);
		enemy29 = new Enemigo(Estatico.imagen3); enemy30 = new Enemigo(Estatico.imagen3); enemy31 = new Enemigo(Estatico.imagen3); enemy32 = new Enemigo(Estatico.imagen3);
		enemy33 = new Enemigo(Estatico.imagen3); enemy34 = new Enemigo(Estatico.imagen3); enemy35 = new Enemigo(Estatico.imagen3); enemy36 = new Enemigo(Estatico.imagen3);
		enemy37 = new Enemigo(Estatico.imagen3); enemy38 = new Enemigo(Estatico.imagen3); enemy39 = new Enemigo(Estatico.imagen3); enemy40 = new Enemigo(Estatico.imagen3);

		this.add(enemy1);	this.add(enemy2);	this.add(enemy3);	this.add(enemy4);
		this.add(enemy5);	this.add(enemy6);	this.add(enemy7);	this.add(enemy8);
		this.add(enemy9);	this.add(enemy10);	this.add(enemy11);	this.add(enemy12);
		this.add(enemy13);	this.add(enemy14);	this.add(enemy15);	this.add(enemy16);
		this.add(enemy17);	this.add(enemy18);	this.add(enemy19);	this.add(enemy20);
		this.add(enemy21);	this.add(enemy22);	this.add(enemy23);	this.add(enemy24);
		this.add(enemy25);	this.add(enemy26);	this.add(enemy27);	this.add(enemy28);
		this.add(enemy29);	this.add(enemy30);	this.add(enemy31);	this.add(enemy32);
		this.add(enemy33);	this.add(enemy34);	this.add(enemy35);	this.add(enemy36);
		this.add(enemy37);	this.add(enemy38);	this.add(enemy39);	this.add(enemy40);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == atras) {
			if(nick.getText().equals("")) {
				alerta.setVisible(true);
			}else {
				ControladorPuntaje guardar = new ControladorPuntaje();
				guardar.insertarJugador(nick.getText(),Jugador.puntos);
				Volver.salida = true;
				new Volver(Espacio.ventana);
				salida = true;
				Inicio.entrada = true;
				Thread transicion = new Thread(this);
				Thread inicio = new Thread(Principal.pantalla.inicio);
				transicion.start();
				inicio.start();
				alerta.setVisible(false);
			}
		}
	}
}