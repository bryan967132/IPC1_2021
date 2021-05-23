package AluCur;
import static DTT.InicioAlu.*;
import static Interfaz.Colores.*;
import static AluCur.ABtnCur.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Interfaz.*;
public class GestCurso {
	public static JTable tabla;
	public static JPanel datosAct,header,grafica;
	public void form(int cur,String nombre) {
		
		datosAct = new JPanel();
		datosAct.setLayout(new BorderLayout());
		datosAct.setBounds(28,116,706,83);
		datosAct.setBackground(Medio);
		
		grafica = new JPanel();
		grafica.setLayout(new BorderLayout());
		grafica.setBounds(128,239,450,250);
		grafica.setBackground(Medio);
		
		JLabel imgBack = new JLabel();
        imgBack.setBounds(0,0,40,40);
		ImageIcon img1 = new ImageIcon("Imagenes/backL.png");
        Icon icono1 = new ImageIcon(img1.getImage().getScaledInstance(imgBack.getWidth(), imgBack.getHeight(), Image.SCALE_DEFAULT));
        imgBack.setIcon(icono1);
        
        JLabel Curso = new JLabel(nombre);
        Curso.setBounds(28,30,706,30);
        Curso.setForeground(fuente2);
        Curso.setFont(new Font("", Font.BOLD, 25));
        
        JLabel tT1 = new JLabel("Actividades");
        tT1.setBounds(28,70,200,20);
        tT1.setForeground(fuente2);
        
        Boton back = new Boton("");
		back.add(imgBack);
		back.setBounds(699,30,40,40);
		back.setBackground(null);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NavAlu cursos = new NavAlu();
				cursos.cursos();
				verCurso.removeAll();
			}
		});
		
		ComponentesVerAct tabla = new ComponentesVerAct();
		tabla.tablaActR(cur);
		tabla.grafica(cur);
		
		verCurso.add(datosAct);
		verCurso.add(grafica);
		verCurso.add(Curso);
		verCurso.add(tT1);
		verCurso.add(back);
		panel3.add(verCurso);
	}
}