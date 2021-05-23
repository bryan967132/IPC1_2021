package Boton_Animado;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
public class Boton extends JButton implements MouseListener,Runnable {
	private static final long serialVersionUID = 1L;
	boolean activado = false;
	int x,y,w,mov,animSize;
	JLabel titulo;
	public void PosicionTamaño(int x,int y,int w,int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.setBounds(x,y,w,h);
		this.setLayout(null);
		this.addMouseListener(this);
		this.setVisible(true);
	}
	public void Texto(String texto,Color color,int tamaño) {
		titulo = new Etiqueta(0,0,this.getWidth(),this.getHeight(),texto,color,tamaño);
		this.add(titulo);
	}
	public void Diseño(int grosorBorde,Color colorBorde,Color colorFondo) {
		this.setBackground(colorFondo);
		this.setBorder(BorderFactory.createLineBorder(colorBorde,grosorBorde));
	}
	public void Animar(int animSize) {
		this.animSize = animSize;activado = true;
	}
	public void run() {
		try {
			if(activado) {
				int a = this.getWidth();
				int h = this.getHeight();
				if(a <= w) {
					for(int i=1; i<=this.animSize; i++) {
						a += i;
						h += i;
						this.setBounds(x+w/2-a/2,y-i,a,h);
						titulo.setSize(a,h);
						Thread.sleep(40);
					}
					for(int i=this.animSize; i>=1; i--) {
						a -= i;
						h -= i;
						setBounds(x+w/2-a/2,y-i,a,h);
						titulo.setSize(a,h);
						Thread.sleep(40);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void mouseEntered(MouseEvent e) {
		Thread hilo = new Thread(this);
		hilo.start();
	}
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}
class Etiqueta extends JLabel {
	private static final long serialVersionUID = 1L;
	public Etiqueta(int x,int y,int w,int l,String texto,Color colorF,int fuente) {
		this.setText(texto);
		this.setForeground(colorF);
		this.setBounds(x,y,w,l);
		this.setFont(new Font("Tahoma",Font.BOLD,fuente));
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.CENTER);
	}
}