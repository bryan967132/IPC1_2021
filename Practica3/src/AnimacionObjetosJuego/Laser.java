package AnimacionObjetosJuego;
import static Ajustes.ControladorAjustes.config;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import Interfaz.Sonido;
import PantallaJuego.EstadoBarra;
import PantallaJuego.Espacio;
import Variables.Estatico;
public class Laser extends Thread {
	int y, lim1 = 950,lim2 = 1005,lim3 = 1060,lim4 = 1115,lim5 = 1170;
	JPanel Laser,Jugador;
	static boolean hilo = false,pausa = false;
	public static int laserV;
	public Laser(int y,JPanel Laser,JPanel Jugador){
	    this.y = y;
	    this.Laser = Laser;
	    this.Jugador = Jugador;
	}
	public void run(){
		if(hilo) {
			new Sonido(Estatico.disparo);
		    for (int i = 65; i <= 1250; i+=laserV) {
		        try {
		        	Laser.setLocation(i,y);
		        	if(i == 1250){
		        		pufL();
		            }
		            if(Laser.isShowing() == false){
		            	pufL();
		                i++;
		            }
		            if(dañoFront(i,Espacio.enemy1,lim1,y)) {if(Estatico.salud1 > 0) {pufL();Estatico.salud1--;}else if(Estatico.salud1 == 0) {exp1(Espacio.enemy1);}}
		            else if(dañoFront(i,Espacio.enemy2,lim1,y)) {if(Estatico.salud2 > 0) {pufL();Estatico.salud2--;}else if(Estatico.salud2 == 0) {exp1(Espacio.enemy2);}}
		            else if(dañoFront(i,Espacio.enemy3,lim1,y)) {if(Estatico.salud3 > 0) {pufL();Estatico.salud3--;}else if(Estatico.salud3 == 0) {exp1(Espacio.enemy3);}}
		            else if(dañoFront(i,Espacio.enemy4,lim1,y)) {if(Estatico.salud4 > 0) {pufL();Estatico.salud4--;}else if(Estatico.salud4 == 0) {exp1(Espacio.enemy4);}}
		            else if(dañoFront(i,Espacio.enemy5,lim1,y)) {if(Estatico.salud5 > 0) {pufL();Estatico.salud5--;}else if(Estatico.salud5 == 0) {exp1(Espacio.enemy5);}}
		            else if(dañoFront(i,Espacio.enemy6,lim1,y)) {if(Estatico.salud6 > 0) {pufL();Estatico.salud6--;}else if(Estatico.salud6 == 0) {exp1(Espacio.enemy6);}}
		            else if(dañoFront(i,Espacio.enemy7,lim1,y)) {if(Estatico.salud7 > 0) {pufL();Estatico.salud7--;}else if(Estatico.salud7 == 0) {exp1(Espacio.enemy7);}}
		            else if(dañoFront(i,Espacio.enemy8,lim1,y)) {if(Estatico.salud8 > 0) {pufL();Estatico.salud8--;}else if(Estatico.salud8 == 0) {exp1(Espacio.enemy8);}}
		            else if(dañoFlota(i,Espacio.enemy9,Espacio.enemy1,lim2,y)) {if(Estatico.salud9 > 0) {pufL();Estatico.salud9--;}else if(Estatico.salud9 == 0) {exp23(Espacio.enemy9);}}
		            else if(dañoFlota(i,Espacio.enemy10,Espacio.enemy2,lim2,y)) {if(Estatico.salud10 > 0) {pufL();Estatico.salud10--;}else if(Estatico.salud10 == 0) {exp23(Espacio.enemy10);}}
		            else if(dañoFlota(i,Espacio.enemy11,Espacio.enemy3,lim2,y)) {if(Estatico.salud11 > 0) {pufL();Estatico.salud11--;}else if(Estatico.salud11 == 0) {exp23(Espacio.enemy11);}}
		            else if(dañoFlota(i,Espacio.enemy12,Espacio.enemy4,lim2,y)) {if(Estatico.salud12 > 0) {pufL();Estatico.salud12--;}else if(Estatico.salud12 == 0) {exp23(Espacio.enemy12);}}
		            else if(dañoFlota(i,Espacio.enemy13,Espacio.enemy5,lim2,y)) {if(Estatico.salud13 > 0) {pufL();Estatico.salud13--;}else if(Estatico.salud13 == 0) {exp23(Espacio.enemy13);}}
		            else if(dañoFlota(i,Espacio.enemy14,Espacio.enemy6,lim2,y)) {if(Estatico.salud14 > 0) {pufL();Estatico.salud14--;}else if(Estatico.salud14 == 0) {exp23(Espacio.enemy14);}}
		            else if(dañoFlota(i,Espacio.enemy15,Espacio.enemy7,lim2,y)) {if(Estatico.salud15 > 0) {pufL();Estatico.salud15--;}else if(Estatico.salud15 == 0) {exp23(Espacio.enemy15);}}
		            else if(dañoFlota(i,Espacio.enemy16,Espacio.enemy8,lim2,y)) {if(Estatico.salud16 > 0) {pufL();Estatico.salud16--;}else if(Estatico.salud16 == 0) {exp23(Espacio.enemy16);}}
		            else if(dañoFlota(i,Espacio.enemy17,Espacio.enemy9,lim3,y)) {if(Estatico.salud17 > 0) {pufL();Estatico.salud17--;}else if(Estatico.salud17 == 0) {exp23(Espacio.enemy17);}}
		            else if(dañoFlota(i,Espacio.enemy18,Espacio.enemy10,lim3,y)) {if(Estatico.salud18 > 0) {pufL();Estatico.salud18--;}else if(Estatico.salud18 == 0) {exp23(Espacio.enemy18);}}
		            else if(dañoFlota(i,Espacio.enemy19,Espacio.enemy11,lim3,y)) {if(Estatico.salud19 > 0) {pufL();Estatico.salud19--;}else if(Estatico.salud19 == 0) {exp23(Espacio.enemy19);}}
		            else if(dañoFlota(i,Espacio.enemy20,Espacio.enemy12,lim3,y)) {if(Estatico.salud20 > 0) {pufL();Estatico.salud20--;}else if(Estatico.salud20 == 0) {exp23(Espacio.enemy20);}}
		            else if(dañoFlota(i,Espacio.enemy21,Espacio.enemy13,lim3,y)) {if(Estatico.salud21 > 0) {pufL();Estatico.salud21--;}else if(Estatico.salud21 == 0) {exp23(Espacio.enemy21);}}
		            else if(dañoFlota(i,Espacio.enemy22,Espacio.enemy14,lim3,y)) {if(Estatico.salud22 > 0) {pufL();Estatico.salud22--;}else if(Estatico.salud22 == 0) {exp23(Espacio.enemy22);}}
		            else if(dañoFlota(i,Espacio.enemy23,Espacio.enemy15,lim3,y)) {if(Estatico.salud23 > 0) {pufL();Estatico.salud23--;}else if(Estatico.salud23 == 0) {exp23(Espacio.enemy23);}}
		            else if(dañoFlota(i,Espacio.enemy24,Espacio.enemy16,lim3,y)) {if(Estatico.salud24 > 0) {pufL();Estatico.salud24--;}else if(Estatico.salud24 == 0) {exp23(Espacio.enemy24);}}
		            else if(dañoFlota(i,Espacio.enemy25,Espacio.enemy17,lim4,y)) {if(Estatico.salud25 > 0) {pufL();Estatico.salud25--;}else if(Estatico.salud25 == 0) {exp45(Espacio.enemy25);}}
		            else if(dañoFlota(i,Espacio.enemy26,Espacio.enemy18,lim4,y)) {if(Estatico.salud26 > 0) {pufL();Estatico.salud26--;}else if(Estatico.salud26 == 0) {exp45(Espacio.enemy26);}}
		            else if(dañoFlota(i,Espacio.enemy27,Espacio.enemy19,lim4,y)) {if(Estatico.salud27 > 0) {pufL();Estatico.salud27--;}else if(Estatico.salud27 == 0) {exp45(Espacio.enemy27);}}
		            else if(dañoFlota(i,Espacio.enemy28,Espacio.enemy20,lim4,y)) {if(Estatico.salud28 > 0) {pufL();Estatico.salud28--;}else if(Estatico.salud28 == 0) {exp45(Espacio.enemy28);}}
		            else if(dañoFlota(i,Espacio.enemy29,Espacio.enemy21,lim4,y)) {if(Estatico.salud29 > 0) {pufL();Estatico.salud29--;}else if(Estatico.salud29 == 0) {exp45(Espacio.enemy29);}}
		            else if(dañoFlota(i,Espacio.enemy30,Espacio.enemy22,lim4,y)) {if(Estatico.salud30 > 0) {pufL();Estatico.salud30--;}else if(Estatico.salud30 == 0) {exp45(Espacio.enemy30);}}
		            else if(dañoFlota(i,Espacio.enemy31,Espacio.enemy23,lim4,y)) {if(Estatico.salud31 > 0) {pufL();Estatico.salud31--;}else if(Estatico.salud31 == 0) {exp45(Espacio.enemy31);}}
		            else if(dañoFlota(i,Espacio.enemy32,Espacio.enemy24,lim4,y)) {if(Estatico.salud32 > 0) {pufL();Estatico.salud32--;}else if(Estatico.salud32 == 0) {exp45(Espacio.enemy32);}}
		            else if(dañoFlota(i,Espacio.enemy33,Espacio.enemy25,lim5,y)) {if(Estatico.salud33 > 0) {pufL();Estatico.salud33--;}else if(Estatico.salud33 == 0) {exp45(Espacio.enemy33);}}
		            else if(dañoFlota(i,Espacio.enemy34,Espacio.enemy26,lim5,y)) {if(Estatico.salud34 > 0) {pufL();Estatico.salud34--;}else if(Estatico.salud34 == 0) {exp45(Espacio.enemy34);}}
		            else if(dañoFlota(i,Espacio.enemy35,Espacio.enemy27,lim5,y)) {if(Estatico.salud35 > 0) {pufL();Estatico.salud35--;}else if(Estatico.salud35 == 0) {exp45(Espacio.enemy35);}}
		            else if(dañoFlota(i,Espacio.enemy36,Espacio.enemy28,lim5,y)) {if(Estatico.salud36 > 0) {pufL();Estatico.salud36--;}else if(Estatico.salud36 == 0) {exp45(Espacio.enemy36);}}
		            else if(dañoFlota(i,Espacio.enemy37,Espacio.enemy29,lim5,y)) {if(Estatico.salud37 > 0) {pufL();Estatico.salud37--;}else if(Estatico.salud37 == 0) {exp45(Espacio.enemy37);}}
		            else if(dañoFlota(i,Espacio.enemy38,Espacio.enemy30,lim5,y)) {if(Estatico.salud38 > 0) {pufL();Estatico.salud38--;}else if(Estatico.salud38 == 0) {exp45(Espacio.enemy38);}}
		            else if(dañoFlota(i,Espacio.enemy39,Espacio.enemy31,lim5,y)) {if(Estatico.salud39 > 0) {pufL();Estatico.salud39--;}else if(Estatico.salud39 == 0) {exp45(Espacio.enemy39);}}
		            else if(dañoFlota(i,Espacio.enemy40,Espacio.enemy32,lim5,y)) {if(Estatico.salud40 > 0) {pufL();Estatico.salud40--;}else if(Estatico.salud40 == 0) {exp45(Espacio.enemy40);}}
		            if(Nave.Jugador.alerta1 && b(Espacio.enemy1) && b(Espacio.enemy2) && b(Espacio.enemy3) && b(Espacio.enemy4) && b(Espacio.enemy5) && b(Espacio.enemy6) && b(Espacio.enemy7) && b(Espacio.enemy8) &&
		            		(!b(Espacio.enemy9) || !b(Espacio.enemy10) || !b(Espacio.enemy11) || !b(Espacio.enemy12) || !b(Espacio.enemy13) || !b(Espacio.enemy14) || !b(Espacio.enemy15) || !b(Espacio.enemy16) ||
		            		!b(Espacio.enemy17) || !b(Espacio.enemy18) || !b(Espacio.enemy19) || !b(Espacio.enemy20) || !b(Espacio.enemy21) || !b(Espacio.enemy22) || !b(Espacio.enemy23) || !b(Espacio.enemy24))) {
		            	if(config[0].getVel().equals("Normal")) {
		            		EnemigoMovimiento.lento = 50;
		            	}else {
		            		EnemigoMovimiento.lento = 40;
		            	}
		            	EstadoBarra.velocidad = 1.5;
		            	Espacio.barraE.velocidad();
		            	new Sonido(Estatico.cuenta);
		            	Nave.Jugador.alerta1 = false;
		            }
		            if(Nave.Jugador.alerta2 && b(Espacio.enemy9) && b(Espacio.enemy10) && b(Espacio.enemy11) && b(Espacio.enemy12) && b(Espacio.enemy13) && b(Espacio.enemy14) && b(Espacio.enemy15) && b(Espacio.enemy16) &&
		            		b(Espacio.enemy17) && b(Espacio.enemy18) && b(Espacio.enemy19) && b(Espacio.enemy20) && b(Espacio.enemy21) && b(Espacio.enemy22) && b(Espacio.enemy23) && b(Espacio.enemy24)) {
		            	if(config[0].getVel().equals("Normal")) {
		            		EnemigoMovimiento.lento = 35;
		            	}else {
		            		EnemigoMovimiento.lento = 25;
		            	}
		            	EstadoBarra.velocidad = 2;
		            	Espacio.barraE.velocidad();
		            	new Sonido(Estatico.cuenta);
		            	Nave.Jugador.alerta2 = false;
		            }
		            if(b(Espacio.enemy1) && b(Espacio.enemy2) && b(Espacio.enemy3) && b(Espacio.enemy4) && b(Espacio.enemy5) && b(Espacio.enemy6) && b(Espacio.enemy7) && b(Espacio.enemy8) &&
		            		b(Espacio.enemy9) && b(Espacio.enemy10) && b(Espacio.enemy11) && b(Espacio.enemy12) && b(Espacio.enemy13) && b(Espacio.enemy14) && b(Espacio.enemy15) && b(Espacio.enemy16) &&
		            		b(Espacio.enemy17) && b(Espacio.enemy18) && b(Espacio.enemy19) && b(Espacio.enemy20) && b(Espacio.enemy21) && b(Espacio.enemy22) && b(Espacio.enemy23) && b(Espacio.enemy24) &&
		            		b(Espacio.enemy25) && b(Espacio.enemy26) && b(Espacio.enemy27) && b(Espacio.enemy28) && b(Espacio.enemy29) && b(Espacio.enemy30) && b(Espacio.enemy31) && b(Espacio.enemy32) &&
		            		b(Espacio.enemy33) && b(Espacio.enemy34) && b(Espacio.enemy35) && b(Espacio.enemy36) && b(Espacio.enemy37) && b(Espacio.enemy38) && b(Espacio.enemy39) && b(Espacio.enemy40)) {
		            	EstadoBarra.alto();
		            	EnemigoMovimiento.altoP();
		            	Nave.Jugador.alto();
		            	alto();
		            }
		            sleep(4);
		        } catch (Exception e) {
		            Logger.getLogger(Espacio.class.getName()).log(Level.SEVERE,null,e);
		        }
		    }
		}else {
        	pufL();
        }
	}
	public boolean dañoFront(int i,JPanel enemigo,int lim,int y) {
		if(Laser.isShowing() != false && Explosion.bum.equals("") && enemigo.isShowing() != false && enemigo.getX() < lim && i >= enemigo.getX() && i <= enemigo.getX()+55 && y >= enemigo.getY() && y <= enemigo.getY()+48) {
			return true;
		}
		return false;
	}
	public boolean dañoFlota(int i,JPanel enemigo,JPanel enemigoA,int lim,int y) {
		if(Laser.isShowing() != false && Explosion.bum.equals("") && enemigoA.isShowing() == false && enemigo.isShowing() != false && enemigo.getX() < lim && i >= enemigo.getX() && i <= enemigo.getX()+55 && y >= enemigo.getY() && y <= enemigo.getY()+48) {
			return true;
        }
		return false;
	}
	public JPanel exp1(JPanel nave) {
		new Explosion(nave,"bum");
		puf1();
		return nave;
	}
	public JPanel exp23(JPanel nave) {
		new Explosion(nave,"bum");
		puf2();
		return nave;
	}
	public JPanel exp45(JPanel nave) {
		new Explosion(nave,"bum");
		puf3();
		return nave;
	}
	public static void alto() {
		hilo = false;
	}
	public static void reanudar() {
		hilo = true;
	}
	public static void pausa() {
		pausa = true;
	}
	public void puf1() {
		pufL();Nave.Jugador.mas10();
		Espacio.barraE.puntos();
		new Sonido(Estatico.explosion);
	}
	public void puf2() {
		pufL();Nave.Jugador.mas20();
		Espacio.barraE.puntos();
		new Sonido(Estatico.explosion);
	}
	public void puf3() {
		pufL();Nave.Jugador.mas30();
		Espacio.barraE.puntos();
		new Sonido(Estatico.explosion);
	}
	public boolean b(JPanel enemigo) {
		if(enemigo.isShowing() == false) {
			return true;
		}
		return false;
	}
	public void pufL() {
		Jugador.remove(Laser);
		Laser.setLocation(1200,0);
		Laser.setVisible(false);
		Jugador.updateUI();
	}
}