package Interfaz;
import static Interfaz.Colores.*;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
public class Separador extends JPanel {
	private static final long serialVersionUID = 1L;
	public Separador(String texto,int fuente,int ancho,Color color,int x,int y,int w,int h) {
		this.setBounds(x,y,w,h);
		this.setLayout(null);
		this.setOpaque(false);
		
		this.add(new Etiqueta(20,0,ancho,38,texto,color,fuente));
		
		Color lineas = blancoT;
		
		JPanel ul = new JPanel();
		ul.setBounds(0,13,20,1);
		ul.setBorder(BorderFactory.createLineBorder(lineas));
		ul.setOpaque(false);
		this.add(ul);
		
		JPanel ur = new JPanel();
		ur.setBounds(20+ancho,13,w-20-ancho,1);
		ur.setBorder(BorderFactory.createLineBorder(lineas));
		ur.setOpaque(false);
		this.add(ur);
		
		JPanel d = new JPanel();
		d.setBounds(0,h-1,w,1);
		d.setBorder(BorderFactory.createLineBorder(lineas));
		d.setOpaque(false);
		this.add(d);
		
		JPanel l = new JPanel();
		l.setBounds(0,14,1,h-15);
		l.setBorder(BorderFactory.createLineBorder(lineas));
		l.setOpaque(false);
		this.add(l);
		
		JPanel r = new JPanel();
		r.setBounds(w-1,14,1,h-15);
		r.setBorder(BorderFactory.createLineBorder(lineas));
		r.setOpaque(false);
		this.add(r);
	}
}
