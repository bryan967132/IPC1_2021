package Interfaz;
import static Interfaz.Colores.GrisB;
import static Interfaz.Colores.fuente1;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.Document;
public class Etiqueta extends JLabel {
	private static final long serialVersionUID = 1L;
	private String placeholder;
    public Etiqueta() {
    	this.setFont(new Font("", Font.PLAIN, 13));
    	this.setForeground(fuente1);
    	this.setBorder(BorderFactory.createLineBorder(GrisB));
    }
    public Etiqueta(final Document pDoc,final String pText,final int pColumns){
        super(pText, pColumns);
    }
    public Etiqueta(final int pColumns) {
        super();
    }
    public Etiqueta(final String pText) {
        super(pText);
    }
    public Etiqueta(final String pText, final int pColumns) {
        super(pText, pColumns);
    }
    public String getPlaceholder() {
        return placeholder;
    }
    protected void paintComponent(final Graphics pG) {
        super.paintComponent(pG);
        if (placeholder == null || placeholder.length() == 0 || getText().length() > 0) {
            return;
        }
        final Graphics2D g = (Graphics2D) pG;
        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.GRAY);
        g.drawString(placeholder, getInsets().left, pG.getFontMetrics()
            .getMaxAscent() + getInsets().top);
    }
    public void setPlaceholder(final String s) {
        placeholder = s;
    }
}