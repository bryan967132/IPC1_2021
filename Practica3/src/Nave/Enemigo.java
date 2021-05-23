package Nave;
import Interfaz.Icono;
import javax.swing.JPanel;
public class Enemigo extends JPanel {
	private static final long serialVersionUID = 1L;
	public Enemigo(String image) {
		int lado = 55;
		this.setSize(lado,lado);
		this.setOpaque(false);
		this.setLayout(null);
        this.add(new Icono(image,lado));
	}
}