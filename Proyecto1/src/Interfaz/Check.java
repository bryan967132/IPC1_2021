package Interfaz;
import static Interfaz.Colores.Medio;
import java.awt.Color;
import javax.swing.*;
public class Check extends JRadioButton {
	private static final long serialVersionUID = 1L;
	public Check(JLabel t1,Boolean marca) {
		this.setSelected(marca);
		this.setLayout(null);
		this.add(t1);
		this.setForeground(Medio);
        this.setBackground(Color.white);
	}
}