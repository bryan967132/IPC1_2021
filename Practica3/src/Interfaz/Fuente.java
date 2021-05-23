package Interfaz;
import java.awt.Font;
import java.io.InputStream;
public class Fuente {
	private Font fuente = null;
	public String GAME = "Fortnite.ttf";
	public Font fuente(String nombre,int estilo,float tamaño) {
		try {
			InputStream is =  getClass().getResourceAsStream(nombre);
			fuente = Font.createFont(Font.TRUETYPE_FONT, is);
		}catch(Exception e) {
			fuente = new Font("Tahoma",Font.BOLD,20);
		}
		Font tfuente = fuente.deriveFont(estilo,tamaño);
		return tfuente;
	}
}