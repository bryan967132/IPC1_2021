package PantallaJuego;
import static Ajustes.ControladorAjustes.config;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import AnimacionObjetosJuego.*;
import Interfaz.BotonCircular;
import Interfaz.Icono;
import Main.Principal;
import Nave.Jugador;
import Variables.Estatico;
public class EstadoBarra extends JPanel implements Runnable,ActionListener {
	private static final long serialVersionUID = 1L;
	public static boolean hilo = true;
	public static double velocidad = 0;
	public static int AumDisT;
	static int lado = 30,abs = 160,ord = 14,fuente = 34;
	static int decP,cenP,milP,uniV,punV,decV,uniT,decT,cenT;
	static JPanel uniPt;
	static JPanel decPt;
	static JPanel cenPt;
	static JPanel milPt;
	static JPanel equSp;
	static JPanel uniSp;
	static JPanel dosSp;
	static JPanel punSp;
	static JPanel decSp;
	static JPanel uniTi;
	static JPanel decTi;
	static JPanel cenTi;
	BotonCircular pausar;
	public EstadoBarra(int x,int y,int w,int h,Color color) {
		this.setBounds(x,y,w,h);
		this.setFocusable(true);
		this.setLayout(null);
		this.setBackground(color);
		barra();
	}
	public void barra() {
		uniPt = new JPanel();
		decPt = new JPanel();
		cenPt = new JPanel();
		milPt = new JPanel();
		equSp = new JPanel();
		uniSp = new JPanel();
		dosSp = new JPanel();
		punSp = new JPanel();
		decSp = new JPanel();
		uniTi = new JPanel();
		decTi = new JPanel();
		cenTi = new JPanel();
		
		JPanel estrella = new JPanel();
		estrella.setBounds(abs,ord-8,lado+10,lado+10);
		estrella.setLayout(null);
		estrella.setOpaque(false);
		estrella.add(new Icono("imagenes/Iconos/star.png",lado+10));
		this.add(estrella);
		
		JLabel score = new JLabel("Puntos:");
		score.setFont(Estatico.fuente.fuente(Estatico.fuente.GAME,0,fuente));
		score.setBounds(abs+50,ord-1,92,lado);
		score.setVerticalAlignment(JLabel.CENTER);
		score.setForeground(Color.WHITE);
		this.add(score);
		
		milPt.setBounds(abs+150,ord,lado,lado);
		milPt.setLayout(null);
		milPt.setOpaque(false);
		milPt.setVisible(false);
		milPt.add(new Icono(Estatico.image1,lado));
		this.add(milPt);
		
		cenPt.setBounds(abs+150,ord,lado,lado);
		cenPt.setLayout(null);
		cenPt.setOpaque(false);
		decPt.setVisible(false);
		this.add(cenPt);
		
		decPt.setBounds(abs+150,ord,lado,lado);
		decPt.setLayout(null);
		decPt.setOpaque(false);
		decPt.setVisible(false);
		this.add(decPt);
		
		uniPt.setBounds(abs+150,ord,lado,lado);
		uniPt.setLayout(null);
		uniPt.setOpaque(false);
		uniPt.add(new Icono(Estatico.image0,lado));
		this.add(uniPt);
		
		JPanel velocimetro = new JPanel();
		velocimetro.setBounds(abs+324,ord-8,lado+10,lado+10);
		velocimetro.setLayout(null);
		velocimetro.setOpaque(false);
		velocimetro.add(new Icono("imagenes/Iconos/velocimetro.png",lado+10));
		this.add(velocimetro);
		
		JLabel speed = new JLabel("Velocidad:");
		speed.setFont(Estatico.fuente.fuente(Estatico.fuente.GAME,0,fuente));
		speed.setBounds(abs+374,ord,142,lado);
		speed.setVerticalAlignment(JLabel.CENTER);
		speed.setForeground(Color.WHITE);
		this.add(speed);
		
		equSp.setBounds(abs+507,ord,lado,lado);
		equSp.setOpaque(false);
		equSp.add(new Icono(Estatico.imageX,24));
		this.add(equSp);
		
		uniSp.setBounds(abs+538,ord,lado,lado);
		uniSp.setLayout(null);
		uniSp.setOpaque(false);
		uniSp.add(new Icono(Estatico.image1,lado));
		this.add(uniSp);
		
		dosSp.setBounds(abs+538,ord,lado,lado);
		dosSp.setLayout(null);
		dosSp.setOpaque(false);
		dosSp.setVisible(false);
		dosSp.add(new Icono(Estatico.image2,lado));
		this.add(dosSp);
		
		punSp.setBounds(abs+569,ord+15,lado/2,lado/2);
		punSp.setLayout(null);
		punSp.setOpaque(false);
		punSp.setVisible(false);
		punSp.add(new Icono(Estatico.imageP,15));
		this.add(punSp);
		
		decSp.setBounds(abs+585,ord,lado,lado);
		decSp.setLayout(null);
		decSp.setOpaque(false);
		decSp.setVisible(false);
		decSp.add(new Icono(Estatico.image5,lado));
		this.add(decSp);
		
		JPanel reloj = new JPanel();
		reloj.setBounds(abs+670,ord-8,lado+10,lado+10);
		reloj.setLayout(null);
		reloj.setOpaque(false);
		reloj.add(new Icono("imagenes/Iconos/timer.png",lado+10));
		this.add(reloj);
		
		JLabel timer = new JLabel("Tiempo:");
		timer.setFont(Estatico.fuente.fuente(Estatico.fuente.GAME,0,fuente));
		timer.setBounds(abs+720,ord,117,lado);
		timer.setVerticalAlignment(JLabel.CENTER);
		timer.setForeground(Color.WHITE);
		this.add(timer);
		
		cenTi.setBounds(abs+784,ord,lado,lado);
		cenTi.setBackground(Color.BLUE);
		cenTi.setLayout(null);
		cenTi.setOpaque(false);
		this.add(cenTi);
		
		decTi.setBounds(abs+805,ord,lado,lado);
		decTi.setBackground(Color.GRAY);
		decTi.setLayout(null);
		decTi.setOpaque(false);
		this.add(decTi);
		
		uniTi.setBounds(abs+826,ord,lado,lado);
		uniTi.setBackground(Color.GREEN);
		uniTi.setLayout(null);
		uniTi.setOpaque(false);
		this.add(uniTi);
		
		digito(config[0].getTmp());
		
		pausar = new BotonCircular(Estatico.pausa,1180,10,30);
		pausar.addActionListener(this);
		pausar.setEnabled(false);
		this.add(pausar);
		
		puntos();
	}
	public void puntos() {
		milP = Jugador.puntos/1000;
		cenP = (Jugador.puntos%1000)/100;
		decP = (Jugador.puntos%100)/10;
		if(Jugador.puntos >= 1000) {
			milPt.setVisible(true);
			cenPt.setBounds(abs+181,ord,lado,lado);
			decPt.setBounds(abs+212,ord,lado,lado);
			uniPt.setBounds(abs+243,ord,lado,lado);
			cenP();
			decP();
		}else if(Jugador.puntos >= 100) {
			milPt.setVisible(false);
			cenPt.setBounds(abs+150,ord,lado,lado);
			decPt.setBounds(abs+181,ord,lado,lado);
			uniPt.setBounds(abs+212,ord,lado,lado);
			cenP();
			decP();
		}else if(Jugador.puntos >= 10){
			milPt.setVisible(false);
			cenPt.removeAll();cenTi.setVisible(false);cenTi.setVisible(true);
			decPt.setBounds(abs+150,ord,lado,lado);
			uniPt.setBounds(abs+181,ord,lado,lado);
			decP();
		}else {
			milPt.setVisible(false);
			cenPt.removeAll();cenTi.setVisible(false);cenTi.setVisible(true);
			decPt.removeAll();decPt.setVisible(false);decPt.setVisible(true);
			uniPt.setBounds(abs+150,ord,lado,lado);
		}
	}
	public void velocidad() {
		if(velocidad == 2) {
			uniSp.setVisible(false);
			dosSp.setVisible(true);
			punSp.setVisible(false);
			decSp.setVisible(false);
		}else if(velocidad == 1.5) {
			punSp.setVisible(true);
			decSp.setVisible(true);
		}else{
			uniSp.setVisible(true);
			dosSp.setVisible(false);
		}
	}
	public void run() {
		try {
			int frecuencia;
			if(config[0].getFre().equals("Poco Frecuente")) {
				frecuencia = 20;
			}else if(config[0].getFre().equals("Normal")) {
				frecuencia = 12;
			}else {
				frecuencia = 4;
			}
			Random posicion;
			Random item;
			int n;
			for(int i = config[0].getTmp(); i>=0; i--) {
				if(hilo) {
					posicion = new Random();
					item = new Random();
					if(i%frecuencia == 0) {
						int y = posicion.nextInt(470)+1;
						n = item.nextInt(6)+1;
						if(n == 1 && config[0].getIt1() == true) {
							Principal.pantalla.espacio.add(new ItPlusT(1300,y+65));
						}
						else if(n == 2 && config[0].getIt2() == true) {
							Principal.pantalla.espacio.add(new ItPlusP(1300,y+65));
						}
						else if(n == 3 && config[0].getIt3() == true) {
							Principal.pantalla.espacio.add(new ItPlusV(1300,y+65));
						}
						else if(n == 4 && config[0].getIt4() == true) {
							Principal.pantalla.espacio.add(new ItLessT(1300,y+65));
						}
						else if(n == 5 && config[0].getIt5() == true) {
							Principal.pantalla.espacio.add(new ItLessP(1300,y+65));
						}
						else if(n == 6 && config[0].getIt6() == true) {
							Principal.pantalla.espacio.add(new ItLessV(1300,y+65));
						}
					}
					
					digito(i);
					Thread.sleep(1000);
					i+=AumDisT;
					AumDisT=0;
					
					if(i == 0) {
						new GameOver(Ventana.anuncios,"¡No Hay Tiempo!¡Retirada!");
					}
				}
			}
			Jugador.alto();
			Laser.alto();
			EnemigoMovimiento.altoP();
			EnemigoMovimiento.salidaS();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void digito(int i) {
		cenT = i/100;
		decT = (i%100)/10;
		uniT = i%10;
		if(i>=100) {
			cenTi.setBounds(abs+824,ord,lado,lado);
			decTi.setBounds(abs+855,ord,lado,lado);
			uniTi.setBounds(abs+886,ord,lado,lado);
			cenTi();
			decTi();
			uniTi();
		}else if(i>=10 && i<100) {
			decTi.setBounds(abs+824,ord,lado,lado);
			uniTi.setBounds(abs+855,ord,lado,lado);
			cenTi.removeAll();cenTi.setVisible(false);cenTi.setVisible(true);
			decTi();					
			uniTi();
		}else {
			uniTi.setBounds(abs+824,ord,lado,lado);
			decTi.removeAll();decTi.setVisible(false);decTi.setVisible(true);
			uniTi();
		}
	}
	public void cenP() {
		if(cenP==0) {cenPt.removeAll();cenPt.setVisible(false);cenPt.add(Estatico.CimageP0);cenPt.setVisible(true);}
		if(cenP==1) {cenPt.removeAll();cenPt.setVisible(false);cenPt.add(Estatico.CimageP1);cenPt.setVisible(true);}
		if(cenP==2) {cenPt.removeAll();cenPt.setVisible(false);cenPt.add(Estatico.CimageP2);cenPt.setVisible(true);}
		if(cenP==3) {cenPt.removeAll();cenPt.setVisible(false);cenPt.add(Estatico.CimageP3);cenPt.setVisible(true);}
		if(cenP==4) {cenPt.removeAll();cenPt.setVisible(false);cenPt.add(Estatico.CimageP4);cenPt.setVisible(true);}
		if(cenP==5) {cenPt.removeAll();cenPt.setVisible(false);cenPt.add(Estatico.CimageP5);cenPt.setVisible(true);}
		if(cenP==6) {cenPt.removeAll();cenPt.setVisible(false);cenPt.add(Estatico.CimageP6);cenPt.setVisible(true);}
		if(cenP==7) {cenPt.removeAll();cenPt.setVisible(false);cenPt.add(Estatico.CimageP7);cenPt.setVisible(true);}
		if(cenP==8) {cenPt.removeAll();cenPt.setVisible(false);cenPt.add(Estatico.CimageP8);cenPt.setVisible(true);}
		if(cenP==9) {cenPt.removeAll();cenPt.setVisible(false);cenPt.add(Estatico.CimageP9);cenPt.setVisible(true);}
	}
	public void decP() {
		if(decP==0) {decPt.removeAll();decPt.setVisible(false);decPt.add(Estatico.DimageP0);decPt.setVisible(true);}
		if(decP==1) {decPt.removeAll();decPt.setVisible(false);decPt.add(Estatico.DimageP1);decPt.setVisible(true);}
		if(decP==2) {decPt.removeAll();decPt.setVisible(false);decPt.add(Estatico.DimageP2);decPt.setVisible(true);}
		if(decP==3) {decPt.removeAll();decPt.setVisible(false);decPt.add(Estatico.DimageP3);decPt.setVisible(true);}
		if(decP==4) {decPt.removeAll();decPt.setVisible(false);decPt.add(Estatico.DimageP4);decPt.setVisible(true);}
		if(decP==5) {decPt.removeAll();decPt.setVisible(false);decPt.add(Estatico.DimageP5);decPt.setVisible(true);}
		if(decP==6) {decPt.removeAll();decPt.setVisible(false);decPt.add(Estatico.DimageP6);decPt.setVisible(true);}
		if(decP==7) {decPt.removeAll();decPt.setVisible(false);decPt.add(Estatico.DimageP7);decPt.setVisible(true);}
		if(decP==8) {decPt.removeAll();decPt.setVisible(false);decPt.add(Estatico.DimageP8);decPt.setVisible(true);}
		if(decP==9) {decPt.removeAll();decPt.setVisible(false);decPt.add(Estatico.DimageP9);decPt.setVisible(true);}
	}
	public static void cenTi() {
		if(cenT==1) {cenTi.removeAll();cenTi.setVisible(false);cenTi.add(Estatico.CimageT1);cenTi.setVisible(true);}
		if(cenT==2) {cenTi.removeAll();cenTi.setVisible(false);cenTi.add(Estatico.CimageT2);cenTi.setVisible(true);}
		if(cenT==3) {cenTi.removeAll();cenTi.setVisible(false);cenTi.add(Estatico.CimageT3);cenTi.setVisible(true);}
		if(cenT==4) {cenTi.removeAll();cenTi.setVisible(false);cenTi.add(Estatico.CimageT4);cenTi.setVisible(true);}
		if(cenT==5) {cenTi.removeAll();cenTi.setVisible(false);cenTi.add(Estatico.CimageT5);cenTi.setVisible(true);}
		if(cenT==6) {cenTi.removeAll();cenTi.setVisible(false);cenTi.add(Estatico.CimageT6);cenTi.setVisible(true);}
		if(cenT==7) {cenTi.removeAll();cenTi.setVisible(false);cenTi.add(Estatico.CimageT7);cenTi.setVisible(true);}
		if(cenT==8) {cenTi.removeAll();cenTi.setVisible(false);cenTi.add(Estatico.CimageT8);cenTi.setVisible(true);}
		if(cenT==9) {cenTi.removeAll();cenTi.setVisible(false);cenTi.add(Estatico.CimageT9);cenTi.setVisible(true);}
	}
	public static void decTi() {
		if(decT==0) {decTi.removeAll();decTi.setVisible(false);decTi.add(Estatico.DimageT0);decTi.setVisible(true);}
		if(decT==1) {decTi.removeAll();decTi.setVisible(false);decTi.add(Estatico.DimageT1);decTi.setVisible(true);}
		if(decT==2) {decTi.removeAll();decTi.setVisible(false);decTi.add(Estatico.DimageT2);decTi.setVisible(true);}
		if(decT==3) {decTi.removeAll();decTi.setVisible(false);decTi.add(Estatico.DimageT3);decTi.setVisible(true);}
		if(decT==4) {decTi.removeAll();decTi.setVisible(false);decTi.add(Estatico.DimageT4);decTi.setVisible(true);}
		if(decT==5) {decTi.removeAll();decTi.setVisible(false);decTi.add(Estatico.DimageT5);decTi.setVisible(true);}
		if(decT==6) {decTi.removeAll();decTi.setVisible(false);decTi.add(Estatico.DimageT6);decTi.setVisible(true);}
		if(decT==7) {decTi.removeAll();decTi.setVisible(false);decTi.add(Estatico.DimageT7);decTi.setVisible(true);}
		if(decT==8) {decTi.removeAll();decTi.setVisible(false);decTi.add(Estatico.DimageT8);decTi.setVisible(true);}
		if(decT==9) {decTi.removeAll();decTi.setVisible(false);decTi.add(Estatico.DimageT9);decTi.setVisible(true);}
	}
	public static void uniTi() {
		if(uniT==0)	{uniTi.removeAll();uniTi.setVisible(false);uniTi.add(Estatico.UimageT0);uniTi.setVisible(true);}
		if(uniT==1)	{uniTi.removeAll();uniTi.setVisible(false);uniTi.add(Estatico.UimageT1);uniTi.setVisible(true);}
		if(uniT==2)	{uniTi.removeAll();uniTi.setVisible(false);uniTi.add(Estatico.UimageT2);uniTi.setVisible(true);}
		if(uniT==3)	{uniTi.removeAll();uniTi.setVisible(false);uniTi.add(Estatico.UimageT3);uniTi.setVisible(true);}
		if(uniT==4)	{uniTi.removeAll();uniTi.setVisible(false);uniTi.add(Estatico.UimageT4);uniTi.setVisible(true);}
		if(uniT==5)	{uniTi.removeAll();uniTi.setVisible(false);uniTi.add(Estatico.UimageT5);uniTi.setVisible(true);}
		if(uniT==6)	{uniTi.removeAll();uniTi.setVisible(false);uniTi.add(Estatico.UimageT6);uniTi.setVisible(true);}
		if(uniT==7)	{uniTi.removeAll();uniTi.setVisible(false);uniTi.add(Estatico.UimageT7);uniTi.setVisible(true);}
		if(uniT==8)	{uniTi.removeAll();uniTi.setVisible(false);uniTi.add(Estatico.UimageT8);uniTi.setVisible(true);}
		if(uniT==9)	{uniTi.removeAll();uniTi.setVisible(false);uniTi.add(Estatico.UimageT9);uniTi.setVisible(true);}
	}
	public static void alto() {
		hilo = false;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
