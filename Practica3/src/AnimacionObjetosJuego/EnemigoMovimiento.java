package AnimacionObjetosJuego;
import javax.swing.JPanel;
import Interfaz.Sonido;
import Nave.*;
import PantallaJuego.Espacio;
import PantallaJuego.EstadoBarra;
import PantallaJuego.Ventana;
import Variables.Estatico;
public class EnemigoMovimiento implements Runnable{
	final int f1 = 60,f2 = 115,f3 = 170,f4 = 225,f5 = 280,f6 = 335,f7 = 390,f8 = 445;
	final int c1=0,c2 = 60,c3 = 120,c4 = 180,c5 = 240;
	final int o1 = 950,o2 = 945,o3 = 940,o4 = 935,o5 = 930;
	final double pi = Math.PI;
	public static boolean hPrimario = true,hSecundario = false;
	public static int velocidad,entrada = 10,salida = 20,lento;
	public void run() {
		try {
			for(int i = 1380; i>=-300; i--) {
				double amplitud = 27.5;
				double desfase1 = (-2470-o1*pi)/pi;
				double desfase2 = (-2474-o2*pi)/pi;
				double desfase3 = (-2480-o3*pi)/pi;
				double desfase4 = (-2500-o4*pi)/pi;
				double desfase5 = (-2514-o5*pi)/pi;
				if(hPrimario) {
					if(i == 1200) {new InicioPartida(Ventana.anuncios);}
					if(i == o1) {Jugador.thread = true;Laser.hilo = true;EstadoBarra.hilo = true;Thread time = new Thread(Espacio.barraE);time.start();}
					if(i <= o1) {velocidad = lento;moverC1(i,amplitud,desfase1,amplitud);}else {velocidad = entrada;moverC1(i,0,0,0);}
					if(i <= o2) {velocidad = lento;moverC2(i,amplitud,desfase2,amplitud);}else {velocidad = entrada;moverC2(i,0,0,0);}
					if(i <= o3) {velocidad = lento;moverC3(i,amplitud,desfase3,amplitud);}else {velocidad = entrada;moverC3(i,0,0,0);}
					if(i <= o4) {velocidad = lento;moverC4(i,amplitud,desfase4,amplitud);}else {velocidad = entrada;moverC4(i,0,0,0);}
					if(i <= o5) {velocidad = lento;moverC5(i,amplitud,desfase5,amplitud);}else {velocidad = entrada;moverC5(i,0,0,0);}
					if(i <= 85 && Espacio.player.isShowing() == true) {
						if(Choque(Espacio.player,Espacio.enemy1)) {GameOver();}		if(Choque(Espacio.player,Espacio.enemy2)) {GameOver();}
						if(Choque(Espacio.player,Espacio.enemy3)) {GameOver();}		if(Choque(Espacio.player,Espacio.enemy4)) {GameOver();}
						if(Choque(Espacio.player,Espacio.enemy5)) {GameOver();}		if(Choque(Espacio.player,Espacio.enemy6)) {GameOver();}
						if(Choque(Espacio.player,Espacio.enemy7)) {GameOver();}		if(Choque(Espacio.player,Espacio.enemy8)) {GameOver();}
						if(Choque(Espacio.player,Espacio.enemy9)) {GameOver();}		if(Choque(Espacio.player,Espacio.enemy10)) {GameOver();}
						if(Choque(Espacio.player,Espacio.enemy11)) {GameOver();}	if(Choque(Espacio.player,Espacio.enemy12)) {GameOver();}
						if(Choque(Espacio.player,Espacio.enemy13)) {GameOver();}	if(Choque(Espacio.player,Espacio.enemy14)) {GameOver();}
						if(Choque(Espacio.player,Espacio.enemy15)) {GameOver();}	if(Choque(Espacio.player,Espacio.enemy16)) {GameOver();}
						if(Choque(Espacio.player,Espacio.enemy17)) {GameOver();}	if(Choque(Espacio.player,Espacio.enemy18)) {GameOver();}
						if(Choque(Espacio.player,Espacio.enemy19)) {GameOver();}	if(Choque(Espacio.player,Espacio.enemy20)) {GameOver();}
						if(Choque(Espacio.player,Espacio.enemy21)) {GameOver();}	if(Choque(Espacio.player,Espacio.enemy22)) {GameOver();}
						if(Choque(Espacio.player,Espacio.enemy23)) {GameOver();}	if(Choque(Espacio.player,Espacio.enemy24)) {GameOver();}
						if(Choque(Espacio.player,Espacio.enemy25)) {GameOver();}	if(Choque(Espacio.player,Espacio.enemy26)) {GameOver();}
						if(Choque(Espacio.player,Espacio.enemy27)) {GameOver();}	if(Choque(Espacio.player,Espacio.enemy28)) {GameOver();}
						if(Choque(Espacio.player,Espacio.enemy29)) {GameOver();}	if(Choque(Espacio.player,Espacio.enemy30)) {GameOver();}
						if(Choque(Espacio.player,Espacio.enemy31)) {GameOver();}	if(Choque(Espacio.player,Espacio.enemy32)) {GameOver();}
						if(Choque(Espacio.player,Espacio.enemy33)) {GameOver();}	if(Choque(Espacio.player,Espacio.enemy34)) {GameOver();}
						if(Choque(Espacio.player,Espacio.enemy35)) {GameOver();}	if(Choque(Espacio.player,Espacio.enemy36)) {GameOver();}
						if(Choque(Espacio.player,Espacio.enemy37)) {GameOver();}	if(Choque(Espacio.player,Espacio.enemy38)) {GameOver();}
						if(Choque(Espacio.player,Espacio.enemy39)) {GameOver();}	if(Choque(Espacio.player,Espacio.enemy40)) {GameOver();}
						if(Escape(Espacio.enemy1)) {Retirada();}	if(Escape(Espacio.enemy2)) {Retirada();}	if(Escape(Espacio.enemy3)) {Retirada();}	if(Escape(Espacio.enemy4)) {Retirada();}
						if(Escape(Espacio.enemy5)) {Retirada();}	if(Escape(Espacio.enemy6)) {Retirada();}	if(Escape(Espacio.enemy7)) {Retirada();}	if(Escape(Espacio.enemy8)) {Retirada();}
						if(Escape(Espacio.enemy9)) {Retirada();}	if(Escape(Espacio.enemy10)) {Retirada();}	if(Escape(Espacio.enemy11)) {Retirada();}	if(Escape(Espacio.enemy12)) {Retirada();}
						if(Escape(Espacio.enemy13)) {Retirada();}	if(Escape(Espacio.enemy14)) {Retirada();}	if(Escape(Espacio.enemy15)) {Retirada();}	if(Escape(Espacio.enemy16)) {Retirada();}
						if(Escape(Espacio.enemy17)) {Retirada();}	if(Escape(Espacio.enemy18)) {Retirada();}	if(Escape(Espacio.enemy19)) {Retirada();}	if(Escape(Espacio.enemy20)) {Retirada();}
						if(Escape(Espacio.enemy21)) {Retirada();}	if(Escape(Espacio.enemy22)) {Retirada();}	if(Escape(Espacio.enemy23)) {Retirada();}	if(Escape(Espacio.enemy24)) {Retirada();}
						if(Escape(Espacio.enemy25)) {Retirada();}	if(Escape(Espacio.enemy26)) {Retirada();}	if(Escape(Espacio.enemy27)) {Retirada();}	if(Escape(Espacio.enemy28)) {Retirada();}
						if(Escape(Espacio.enemy29)) {Retirada();}	if(Escape(Espacio.enemy30)) {Retirada();}	if(Escape(Espacio.enemy31)) {Retirada();}	if(Escape(Espacio.enemy32)) {Retirada();}
						if(Escape(Espacio.enemy33)) {Retirada();}	if(Escape(Espacio.enemy34)) {Retirada();}	if(Escape(Espacio.enemy35)) {Retirada();}	if(Escape(Espacio.enemy36)) {Retirada();}
						if(Escape(Espacio.enemy37)) {Retirada();}	if(Escape(Espacio.enemy38)) {Retirada();}	if(Escape(Espacio.enemy39)) {Retirada();}	if(Escape(Espacio.enemy40)) {Retirada();}
					}
				}else if(hSecundario) {
					velocidad = salida;
					moverC1(i,amplitud,desfase1,amplitud);
					moverC2(i,amplitud,desfase2,amplitud);
					moverC3(i,amplitud,desfase3,amplitud);
					moverC4(i,amplitud,desfase4,amplitud);
					moverC5(i,amplitud,desfase5,amplitud);
				}else {
					new Sonido("audio/victoria.wav");
					new Victoria(Ventana.anuncios,"¡Bien Hecho Soldado!","¡Has Salvado La Galaxia!");
					break;
				}
				Thread.sleep(velocidad);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void moverC1(int i,double periodo,double desfase,double amplitud) {
		naves(Espacio.enemy1,i+c1,f1,periodo,desfase,amplitud);		naves(Espacio.enemy2,i+c1,f2,periodo,desfase,amplitud);
		naves(Espacio.enemy3,i+c1,f3,periodo,desfase,amplitud);		naves(Espacio.enemy4,i+c1,f4,periodo,desfase,amplitud);
		naves(Espacio.enemy5,i+c1,f5,periodo,desfase,amplitud);		naves(Espacio.enemy6,i+c1,f6,periodo,desfase,amplitud);
		naves(Espacio.enemy7,i+c1,f7,periodo,desfase,amplitud);		naves(Espacio.enemy8,i+c1,f8,periodo,desfase,amplitud);
	}
	public void moverC2(int i,double periodo,double desfase,double amplitud) {
		naves(Espacio.enemy9,i+c2,f1,periodo,desfase,amplitud);		naves(Espacio.enemy10,i+c2,f2,periodo,desfase,amplitud);
		naves(Espacio.enemy11,i+c2,f3,periodo,desfase,amplitud);	naves(Espacio.enemy12,i+c2,f4,periodo,desfase,amplitud);
		naves(Espacio.enemy13,i+c2,f5,periodo,desfase,amplitud);	naves(Espacio.enemy14,i+c2,f6,periodo,desfase,amplitud);
		naves(Espacio.enemy15,i+c2,f7,periodo,desfase,amplitud);	naves(Espacio.enemy16,i+c2,f8,periodo,desfase,amplitud);
	}
	public void moverC3(int i,double periodo,double desfase,double amplitud) {
		naves(Espacio.enemy17,i+c3,f1,periodo,desfase,amplitud);	naves(Espacio.enemy18,i+c3,f2,periodo,desfase,amplitud);
		naves(Espacio.enemy19,i+c3,f3,periodo,desfase,amplitud);	naves(Espacio.enemy20,i+c3,f4,periodo,desfase,amplitud);
		naves(Espacio.enemy21,i+c3,f5,periodo,desfase,amplitud);	naves(Espacio.enemy22,i+c3,f6,periodo,desfase,amplitud);
		naves(Espacio.enemy23,i+c3,f7,periodo,desfase,amplitud);	naves(Espacio.enemy24,i+c3,f8,periodo,desfase,amplitud);
	}
	public void moverC4(int i,double periodo,double desfase,double amplitud) {
		naves(Espacio.enemy25,i+c4,f1,periodo,desfase,amplitud);	naves(Espacio.enemy26,i+c4,f2,periodo,desfase,amplitud);
		naves(Espacio.enemy27,i+c4,f3,periodo,desfase,amplitud);	naves(Espacio.enemy28,i+c4,f4,periodo,desfase,amplitud);
		naves(Espacio.enemy29,i+c4,f5,periodo,desfase,amplitud);	naves(Espacio.enemy30,i+c4,f6,periodo,desfase,amplitud);
		naves(Espacio.enemy31,i+c4,f7,periodo,desfase,amplitud);	naves(Espacio.enemy32,i+c4,f8,periodo,desfase,amplitud);
	}
	public void moverC5(int i,double periodo,double desfase,double amplitud) {
		naves(Espacio.enemy33,i+c5,f1,periodo,desfase,amplitud);	naves(Espacio.enemy34,i+c5,f2,periodo,desfase,amplitud);
		naves(Espacio.enemy35,i+c5,f3,periodo,desfase,amplitud);	naves(Espacio.enemy36,i+c5,f4,periodo,desfase,amplitud);
		naves(Espacio.enemy37,i+c5,f5,periodo,desfase,amplitud);	naves(Espacio.enemy38,i+c5,f6,periodo,desfase,amplitud);
		naves(Espacio.enemy39,i+c5,f7,periodo,desfase,amplitud);	naves(Espacio.enemy40,i+c5,f8,periodo,desfase,amplitud);
	}
	Enemigo naves(Enemigo enemy,int x,int y,double periodo,double desfase,double amplitud) {
		enemy.setLocation(x,(int)(amplitud*Math.sin(((x*pi)+(periodo*pi))/amplitud)+amplitud)+y);
		return enemy;
	}
	public static void altoP() {
		hPrimario = false;
	}
	public static void salidaS() {
		hSecundario = true;
	}
	boolean Choque(JPanel jugador,JPanel enemigo) {
		if(enemigo.isShowing() != false && jugador.isShowing() != false && jugador.getX() >= enemigo.getX()-55 && ((jugador.getY() >= enemigo.getY() && jugador.getY() <= enemigo.getY()+55) || (enemigo.getY() >= jugador.getY() && enemigo.getY() <= jugador.getY()+55))) {
			return true;
		}
		return false;
	}
	boolean Escape(JPanel enemigo) {
		if(enemigo.isShowing() == true && enemigo.getX() <= 0) {
			return true;
		}
		return false;
	}
	void GameOver() {
		EstadoBarra.alto();
		Laser.alto();
    	Nave.Jugador.alto();
    	altoP();
    	salidaS();
		new Explosion(Espacio.player,"bum");
		new Sonido(Estatico.gameover);
		new GameOver(Ventana.anuncios,"¡Soldado Caido!");
	}
	void Retirada() {
		EstadoBarra.alto();
		Laser.alto();
    	Nave.Jugador.alto();
    	altoP();
    	salidaS();
		new Sonido(Estatico.gameover);
		new GameOver(Ventana.anuncios,"¡Retirada!");
	}
}