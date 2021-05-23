package PantallaJuego;
import static Ajustes.ControladorAjustes.config;
import static Interfaz.Colores.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Ajustes.ControladorAjustes;
import Interfaz.BotonCircular;
import Interfaz.Boton;
import Interfaz.CheckItems;
import Interfaz.ComboOpciones;
import Interfaz.Etiqueta;
import Interfaz.Icono;
import Interfaz.Separador;
import Main.Principal;
import Variables.Estatico;
public class Configuracion extends JPanel implements ActionListener,Runnable {
	private static final long serialVersionUID = 1L;
	public static boolean entrada,salida = false;
	public static boolean plusT,plusP,plusV,lessT,lessP,lessV;
	BotonCircular regresar;
	Boton guardar,cancelar;
	Icono alerta;
	public CheckItems tplus,pplus,vplus,tless,pless,vless;
	public static ComboOpciones items,velocidad;
	public static JTextField tiempo;
	public Configuracion() {
		this.setBounds(1234,0,1250,605);		
		this.setOpaque(false);
		this.setLayout(null);
	}
	public void pantalla() {
		this.add(new Etiqueta(0,0,1250,180,"Configuraciones",blanco,60));
		regresar = new BotonCircular(Estatico.volver,70,51,50);
		regresar.addActionListener(this);
		
		this.add(regresar);
		int fuente = 35;
		int h = 40;
		int x = 150;
		int y = 180;
		int linea = 8;
		int ancho = 330;
		Color fontC = blanco;
		
		this.add(new Icono(480,160,Estatico.corazon,70));
		this.add(new Icono(Estatico.control,838,260,83,56));
		
		this.add(new Icono(100,y+linea+3,		Estatico.item1,33));
		this.add(new Icono(100,y+h+linea+3,		Estatico.item2,33));
		this.add(new Icono(100,y+2*h+linea+3,	Estatico.item3,33));
		this.add(new Icono(100,y+3*h+linea+3,	Estatico.item4,33));
		this.add(new Icono(100,y+4*h+linea+3,	Estatico.item5,33));
		this.add(new Icono(100,y+5*h+linea+3,	Estatico.item6,33));
		
		tplus = new CheckItems("Aumento de Tiempo",		fuente,config[0].getIt1(),fontC,x,y+linea,	ancho,h);
		pplus = new CheckItems("Puntos Extra",			fuente,config[0].getIt2(),fontC,x,y+h+linea,	ancho,h);
		vplus = new CheckItems("Aumento de Velocidad",	fuente,config[0].getIt3(),fontC,x,y+2*h+linea,ancho,h);
		tless = new CheckItems("Disminución de Tiempo",	fuente,config[0].getIt4(),fontC,x,y+3*h+linea,ancho,h);
		pless = new CheckItems("Penalización",			fuente,config[0].getIt5(),fontC,x,y+4*h+linea,ancho,h);
		vless = new CheckItems("Congelación",			fuente,config[0].getIt6(),fontC,x,y+5*h+linea,ancho,h);
		this.add(new Etiqueta(100,y+6*h+3*linea,150,h,"Frecuencia",fontC,35));
		String[] opcionesI  = {"Normal","Poco Frecuente","Muy Frecuente"};
		items = new ComboOpciones(opcionesI,34,azul,300,y+6*h+20,220,45);
		items.setSelectedItem(config[0].getFre());
		this.add(tplus);
		this.add(pplus);
		this.add(vplus);
		this.add(tless);
		this.add(pless);
		this.add(vless);
		this.add(items);
		
		this.add(new Separador("Items",38,86,lilaC,70,y-45,500,370));
		
		this.add(new Etiqueta(730,148,64,97,"Nivel",fontC,35));
		String[] opcionesV = {"Normal","Rápido"};
		velocidad = new ComboOpciones(opcionesV,34,azul,880,y-6,150,45);
		velocidad.setSelectedItem(config[0].getVel());
		this.add(velocidad);
		
		this.add(new Separador("Velocidad",38,144,lilaC,630,y-45,500,110));
		
		alerta = new Icono(Estatico.alerta,1040,370,20,20);
		alerta.setVisible(false);
		this.add(alerta);
		this.add(new Etiqueta(730,331,95,97,"Tiempo",fontC,35));
		tiempo = new JTextField();
		tiempo.setText(String.valueOf(config[0].getTmp()));
		tiempo.setBounds(880,357,150,45);
		tiempo.setBorder(BorderFactory.createLineBorder(celesteO,2));
		tiempo.setFont(Estatico.fuente.fuente(Estatico.fuente.GAME,0,fuente));
		tiempo.setForeground(azul);
		tiempo.setHorizontalAlignment(JTextField.CENTER);
		this.add(tiempo);
		
		this.add(new Separador("Tiempo",38,108,lilaC,630,y+138,500,110));
		
		guardar = new Boton(5,30,"Guardar",verdeO,Estatico.verdeC,blanco,630,464,215,40);
		guardar.addActionListener(this);
		this.add(guardar);
		
		cancelar = new Boton(5,30,"Cancelar",rojoO,Estatico.rojoC,blanco,915,464,215,40);
		cancelar.addActionListener(this);
		this.add(cancelar);
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
		if(e.getSource() == guardar) {
			if(tiempo.getText().equals("")) {
				alerta.setVisible(true);
			}else {
				ControladorAjustes.configurar(
						tplus.isSelected(),
						pplus.isSelected(),
						vplus.isSelected(),
						tless.isSelected(),
						pless.isSelected(),
						vless.isSelected(),
						items.getSelectedItem().toString(),
						velocidad.getSelectedItem().toString(),
						Integer.parseInt(tiempo.getText())
				);
				ControladorAjustes.Serializar();
				ControladorAjustes.Deserializar();
				EstadoBarra.digito(Integer.parseInt(tiempo.getText()));
				
				salida = true;
				Inicio.entrada = true;
				Thread transicion = new Thread(this);
				Thread inicio = new Thread(Principal.pantalla.inicio);
				transicion.start();
				inicio.start();
				alerta.setVisible(false);
			}
		}
		if(e.getSource() == cancelar) {
			salida = true;
			Inicio.entrada = true;
			Thread transicion = new Thread(this);
			Thread inicio = new Thread(Principal.pantalla.inicio);
			transicion.start();
			inicio.start();
		}
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