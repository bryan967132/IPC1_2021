package Interfaz;
import static Interfaz.Colores.celesteO;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import Variables.Estatico;
public class ComboOpciones extends JComboBox<String> {
	private static final long serialVersionUID = 1L;
	public ComboOpciones(String[] opciones,int fuente,Color color,int x,int y,int w,int h) {
		this.setBounds(x,y,w,h);
		for(int i=0; i<opciones.length; i++) {
			this.addItem(opciones[i]);
		}
		this.setForeground(color);
		this.setBackground(Color.white);
		this.setFont(Estatico.fuente.fuente(Estatico.fuente.GAME,0,fuente));
		this.setBorder(BorderFactory.createLineBorder(celesteO,2));
	}
}