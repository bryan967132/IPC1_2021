package DTT;
import static Interfaz.Colores.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import AdminAlu.Alu;
import AdminCur.Cur;
import AdminProf.Prof;
import Interfaz.Boton;
import Interfaz.Formulario;
import Main.Principal;
public class InicioAdmin extends Formulario{
	private static final long serialVersionUID = 1L;
	Boton prof,cursos,alu,Off;
	public static JPanel barra,fondo,panel1,panel2,panel3,con1,con2,con3;
	JLabel imgOff;
	JLabel t1,t2,t3;
	JMenuBar menu;
	JMenu m1,m2,m3;
	public InicioAdmin(String user) {
		super("Administración");
		
		this.setTitle(user);
		
		imgOff = new JLabel();
        imgOff.setBounds(0,0,20,20);
		ImageIcon img = new ImageIcon("Imagenes/off.png");
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(imgOff.getWidth(), imgOff.getHeight(), Image.SCALE_DEFAULT));
        imgOff.setIcon(icono);
		
		panel1 = new JPanel();
		panel1.setBounds(11,33,762,517);
		panel1.setBackground(blanco);
		panel1.setVisible(true);
		panel1.setLayout(null);
		
		panel2 = new JPanel();
		panel2.setBounds(11,33,762,517);
		panel2.setBackground(blanco);
		panel2.setVisible(false);
		panel2.setLayout(null);
		
		panel3 = new JPanel();
		panel3.setBounds(11,33,762,517);
		panel3.setBackground(blanco);
		panel3.setVisible(false);
		panel3.setLayout(null);
				
		fondo = new JPanel();
		fondo.setBounds(9,31,766,521);
		fondo.setBackground(Fondo);
		
		t1 = new JLabel("Profesores");
		t1.setBounds(5,0,75,20);
		t1.setForeground(fuente1);
		
		t2 = new JLabel("Cursos");
		t2.setBounds(15,0,70,20);
		t2.setForeground(Color.WHITE);
		
		t3 = new JLabel("Alumnos");
		t3.setBounds(10,0,70,20);
		t3.setForeground(Color.WHITE);
		
		prof = new Boton(t1);
		prof.setBounds(11,11,75,20);
		prof.setBackground(Color.WHITE);
		prof.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con1.setBackground(blanco);
				con2.setBackground(Fondo);
				con3.setBackground(Fondo);
				prof();
			}
		});
		
		cursos = new Boton(t2);
		cursos.setBounds(88,11,70,20);
		cursos.setBackground(Medio);
		cursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con1.setBackground(Fondo);
				con2.setBackground(blanco);
				con3.setBackground(Fondo);
				cursos();
			}
		});
		
		alu = new Boton(t3);
		alu.setBounds(160,11,70,20);
		alu.setBackground(Medio);
		alu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con1.setBackground(Fondo);
				con2.setBackground(Fondo);
				con3.setBackground(blanco);
				alu();
			}
		});
		Off = new Boton("");
		Off.setBounds(750,9,20,20);
		Off.add(imgOff);
		Off.setBackground(null);
		Off.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				volver();
			}
		});
		
		barra = new JPanel();
		barra.setBounds(9,9,223,24);
		barra.setBackground(Fondo);
		
		con1 = new JPanel();
		con1.setBounds(11,31,75,2);
		con1.setBackground(blanco);
		
		con2 = new JPanel();
		con2.setBounds(88,31,70,2);
		con2.setBackground(Fondo);
		
		con3 = new JPanel();
		con3.setBounds(160,31,70,2);
		con3.setBackground(Fondo);
		
		Prof comp1 = new Prof();
		comp1.Componentes();
		Cur comp2 = new Cur();
		comp2.Componentes();
		Alu comp3 = new Alu();
		comp3.Componentes();
		
		this.add(con1);
		this.add(con2);
		this.add(con3);
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(fondo);
		this.add(prof);
		this.add(cursos);
		this.add(alu);
		this.add(Off);
		this.add(barra);
		
		this.setVisible(true);
	}
	public void prof() {
		prof.setBackground(Color.WHITE);
		t1.setForeground(fuente1);
		cursos.setBackground(Medio);
		t2.setForeground(Color.WHITE);
		alu.setBackground(Medio);
		t3.setForeground(Color.WHITE);
		panel1.setVisible(true);
		panel2.setVisible(false);
		panel3.setVisible(false);
	}
	public void cursos() {
		prof.setBackground(Medio);
		t1.setForeground(Color.WHITE);
		cursos.setBackground(Color.WHITE);
		t2.setForeground(fuente1);
		alu.setBackground(Medio);
		t3.setForeground(Color.WHITE);
		panel1.setVisible(false);
		panel2.setVisible(true);
		panel3.setVisible(false);
	}
	public void alu() {
		prof.setBackground(Medio);
		t1.setForeground(Color.WHITE);
		cursos.setBackground(Medio);
		t2.setForeground(Color.WHITE);
		alu.setBackground(Color.WHITE);
		t3.setForeground(fuente1);
		panel1.setVisible(false);
		panel2.setVisible(false);
		panel3.setVisible(true);
	}
	public void volver() {
		Principal.main(null);
		this.dispose();
	}
}