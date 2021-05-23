package DTT;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Administracion.GestorAdministrador;
import Alumnos.ControladorAlumno;
import Profesores.ControladorProfesor;
import Interfaz.*;
import static Interfaz.Colores.*;
public class Login extends Log {
	private static final long serialVersionUID = 1L;
	static JText usuario;
	static JPassword contraseña;
	Boton ingAdmin,ingProf,ingAlu;
	JLabel imagen,t1,t2,t3,ingreso1,ingreso2,ingreso3;
	Check admin,prof,alu;
	static GestorAdministrador administrador;
	static ControladorProfesor profesor;
	static ControladorAlumno alumno;
	public Login(GestorAdministrador administrador,
				 ControladorProfesor profesor,
				 ControladorAlumno alumno) {
		super("Inicio de Sesión");
		
		Login.administrador = administrador;
		Login.profesor = profesor;
		Login.alumno = alumno;
		
		imagen = new JLabel();
        imagen.setBounds(175,20,50,50);
		ImageIcon img = new ImageIcon("Imagenes/user.png");
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
        imagen.setIcon(icono);
        this.add(imagen);
        
		usuario = new JText();
		usuario.setBounds(100,80,200,30);
		usuario.setPlaceholder("Usuario");
		usuario.setForeground(fuente1);
		this.add(usuario);
		
		contraseña = new JPassword();
		contraseña.setBounds(100,120,200,30);
		contraseña.setPlaceholder("Contraseña");
		this.add(contraseña);
		
		t1 = new JLabel("Administrador");
		t1.setBounds(21,0,106,25);
		t1.setForeground(Medio);
		
		t2 = new JLabel("Profesor");
		t2.setBounds(21,0,75,25);
		t2.setForeground(Medio);
		
		t3 = new JLabel("Alumno");
		t3.setBounds(21,0,68,25);
		t3.setForeground(Medio);
		
		ingreso1 = new JLabel("Ingresar");
		ingreso1.setBounds(51,3,48,24);
		ingreso1.setForeground(Color.WHITE);
		
		ingreso2 = new JLabel("Ingresar");
		ingreso2.setBounds(51,3,48,24);
		ingreso2.setForeground(Color.WHITE);
		
		ingreso3 = new JLabel("Ingresar");
		ingreso3.setBounds(51,3,48,24);
		ingreso3.setForeground(Color.WHITE);
		
		admin = new Check(t1,true);
        admin.setBounds(75,160,106,25);
        admin.setEnabled(false);
        admin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		admin.setEnabled(false);
        		prof.setSelected(false);
        		prof.setEnabled(true);
        		alu.setSelected(false);
        		alu.setEnabled(true);
        		ingAdmin.setVisible(true);
        		ingProf.setVisible(false);
        		ingAlu.setVisible(false);
        	}
        });
		this.add(admin);
		
		prof = new Check(t2,false);
		prof.setBounds(181,160,75,25);
		prof.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin.setSelected(false);
				admin.setEnabled(true);
				prof.setEnabled(false);
				alu.setSelected(false);
				alu.setEnabled(true);
				ingAdmin.setVisible(false);
				ingProf.setVisible(true);
				ingAlu.setVisible(false);
			}
		});
		this.add(prof);
		
		alu = new Check(t3,false);
		alu.setBounds(256,160,68,25);
		alu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin.setSelected(false);
				admin.setEnabled(true);
				prof.setSelected(false);
				prof.setEnabled(true);
				alu.setEnabled(false);
				ingAdmin.setVisible(false);
				ingProf.setVisible(false);
				ingAlu.setVisible(true);
			}
		});
		this.add(alu);
		
		ingAdmin = new Boton(ingreso1);
		ingAdmin.setBounds(125,200,150,30);
		ingAdmin.setForeground(blanco);
		ingAdmin.setBackground(Medio);
		ingAdmin.setBorderPainted(false);
		ingAdmin.setVisible(true);
		ingAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logAdmin();				
			}
		});
		this.add(ingAdmin);
		
		ingProf = new Boton(ingreso2);
		ingProf.setBounds(125,200,150,30);
		ingProf.setForeground(blanco);
		ingProf.setBackground(Medio);
		ingProf.setBorderPainted(false);
		ingProf.setVisible(false);
		ingProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logProf();
			}
		});
		this.add(ingProf);
		
		ingAlu = new Boton(ingreso3);
		ingAlu.setBounds(125,200,150,30);
		ingAlu.setForeground(blanco);
		ingAlu.setBackground(Medio);
		ingAlu.setBorderPainted(false);
		ingAlu.setVisible(false);
		ingAlu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logAlu();
			}
		});
		this.add(ingAlu);
		
		this.setSize(400,300);
		this.setVisible(true);
	}
	public void logAdmin() {
		if(usuario.getText().equals("")){
			JOptionPane.showMessageDialog(this,"Son Campos Obligatorios","Campos Vacios",JOptionPane.WARNING_MESSAGE);
		}else if(contraseña.getText().equals("")){
			JOptionPane.showMessageDialog(this,"Son Campos Obligatorios","Campos Vacios",JOptionPane.WARNING_MESSAGE);
		}else if(administrador.iniciarsesion(usuario.getText(),contraseña.getText())) {
			new InicioAdmin(administrador.getusuario(usuario.getText()).usuario);
			usuario.setText("");
			contraseña.setText("");
			this.dispose();
		}else {
			JOptionPane.showMessageDialog(this,"Verifique sus credenciales","Verificación",JOptionPane.WARNING_MESSAGE);
			usuario.setText("");
			contraseña.setText("");
		}
	}
	public void logProf() {
		try {
			if(usuario.getText().equals("")){
				JOptionPane.showMessageDialog(this,"Son Campos Obligatorios","Campos Vacios",JOptionPane.WARNING_MESSAGE);
			}else if(contraseña.getText().equals("")){
				JOptionPane.showMessageDialog(this,"Son Campos Obligatorios","Campos Vacios",JOptionPane.WARNING_MESSAGE);
			}else if(profesor.iniciarsesion(Integer.parseInt(usuario.getText()),contraseña.getText())) {
				profesor.obtenerProfesor(Integer.parseInt(usuario.getText()));
				usuario.setText("");
				contraseña.setText("");
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this,"Verifique sus credenciales","Verificación",JOptionPane.WARNING_MESSAGE);
				usuario.setText("");
				contraseña.setText("");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this,"Verifique sus credenciales","Verificación",JOptionPane.WARNING_MESSAGE);
			usuario.setText("");
			contraseña.setText("");
		}
	}
	public void logAlu() {
		try {
			if(usuario.getText().equals("")){
				JOptionPane.showMessageDialog(this,"Son Campos Obligatorios","Campos Vacios",JOptionPane.WARNING_MESSAGE);
			}else if(contraseña.getText().equals("")){
				JOptionPane.showMessageDialog(this,"Son Campos Obligatorios","Campos Vacios",JOptionPane.WARNING_MESSAGE);
			}else if(alumno.iniciarsesion(Integer.parseInt(usuario.getText()),contraseña.getText())) {
				alumno.obtenerAlumno(Integer.parseInt(usuario.getText()));
				usuario.setText("");
				contraseña.setText("");
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this,"Verifique sus credenciales","Verificación",JOptionPane.WARNING_MESSAGE);
				usuario.setText("");
				contraseña.setText("");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this,"Verifique sus credenciales","Verificación",JOptionPane.WARNING_MESSAGE);
			usuario.setText("");
			contraseña.setText("");
		}
	}
}