package Interfaz;
import javax.swing.*;
public class Boton extends JButton {
	private static final long serialVersionUID = 1L;
	public Boton(String nombre) {
		this.setText(nombre);
		this.setBorder(null);
	}
	public Boton(JLabel label) {
		this.setLayout(null);
		this.add(label);
		this.setBorder(null);
	}
}