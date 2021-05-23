package Main;
import javax.swing.JFrame;
import Ajustes.ControladorAjustes;
import Puntajes.ControladorPuntaje;
import PantallaJuego.Ventana;
public class Principal {
	public static Ventana pantalla;
	public static void main(String[] args) {
		ControladorAjustes.Deserializar();
		ControladorPuntaje.Deserializar();
		ControladorPuntaje.imprimirTopJugadores();
		pantalla = new Ventana();
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}