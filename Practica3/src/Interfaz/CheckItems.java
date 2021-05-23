package Interfaz;
import java.awt.Color;
import javax.swing.JRadioButton;
public class CheckItems extends JRadioButton {
	private static final long serialVersionUID = 1L;
	public CheckItems(String texto,int size,Boolean marca,Color fuente,int x,int y,int w,int h) {
		this.setSelected(marca);
		this.setBounds(x,y,w,h);
		this.setLayout(null);
		this.setContentAreaFilled(false);
		this.add(new Etiqueta(texto,30,2,w-21,h,fuente,size));
		this.setForeground(fuente);
        this.setBackground(null);
	}
}