package Interfaz;
import java.awt.Color;
import javax.swing.*;
public class Log extends JFrame {
	private static final long serialVersionUID = 1L;
	public Log(String nombre) {
		this.setTitle(nombre);
		this.getContentPane().setBackground(Color.WHITE);
		this.setSize(400,300);
		this.setResizable(false);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}