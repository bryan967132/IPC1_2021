package Interfaz;
import javax.swing.JPanel;
public class Desvanecer extends JPanel {
	private static final long serialVersionUID = 1L;
	public Desvanecer(int x,int y,String imagen) {
		this.setBounds(x,y,30,515);
		this.setLayout(null);
		this.setOpaque(false);
		this.add(new Icono(imagen,30,515));
	}
}