package DTT;
import static Interfaz.Colores.*;
import static AluCur.FunBtnACur.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Interfaz.*;
import Main.Principal;
import AluCur.ACur;
import AluCur.NavAlu;
public class InicioAlu extends Formulario {
	private static final long serialVersionUID = 1L;
	public static Boton cursos,cursosAux,perfil,editar,Off,doCancelar,doModificar,back;
	public static JPanel barra,fondo,panel1,panel2,panel3,con1,con2;
	public static JLabel t1,t2,t1Aux,imgEdit,imgEditE;
	public static Etiqueta name,lastname,mail,password,gender;
	public static JText nameE,lastnameE,mailE,passwordE;
	public static JComboBox<String> genderE;
	private static int codigo;
	private static String nombre;
	private static String apellido;
	private static String genero;
	JLabel imgOff;
	public InicioAlu(int codigo,String nombre,String apellido,String genero) {
		super("Administración");
		this.setCodigo(codigo);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setGenero(genero);
		
		if(getGenero().equals("M")) {
			this.setTitle("Alumno: "+getNombre()+" "+getApellido());
		}else {
			this.setTitle("Alumna: "+getNombre()+" "+getApellido());
		}
		
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
		panel3.setBackground(VMedio);
		panel3.setVisible(false);
		panel3.setLayout(null);
		
		fondo = new JPanel();
		fondo.setBounds(9,31,766,521);
		fondo.setBackground(Fondo);
		
		t1 = new JLabel("Cursos Asignados");
		t1.setBounds(8,0,104,20);
		t1.setForeground(fuente1);
		
		t2 = new JLabel("Modificar Perfil");
		t2.setBounds(11,0,86,20);
		t2.setForeground(Color.WHITE);
		
		t1Aux = new JLabel("Cursos Asignados");
		t1Aux.setBounds(8,0,104,20);
		t1Aux.setForeground(fuente1);
		
		cursos = new Boton(t1);
		cursos.setBounds(11,11,120,20);
		cursos.setBackground(Color.WHITE);
		cursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con1.setBackground(blanco);
				con2.setBackground(Fondo);
				NavAlu nav = new NavAlu();
				nav.cursos();
			}
		});
		
		perfil = new Boton(t2);
		perfil.setBounds(133,11,108,20);
		perfil.setBackground(Medio);
		perfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con1.setBackground(Fondo);
				con2.setBackground(blanco);
				NavAlu nav = new NavAlu();
				nav.perfil();
			}
		});
		
		cursosAux = new Boton(t1Aux);
		cursosAux.setBounds(11,11,120,20);
		cursosAux.setBackground(Color.WHITE);
		cursosAux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				con1.setBackground(blanco);
				con2.setBackground(Fondo);
				NavAlu nav = new NavAlu();
				nav.cursosG();
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
		barra.setBounds(9,9,234,24);
		barra.setBackground(Fondo);
		
		con1 = new JPanel();
		con1.setBounds(11,31,120,2);
		con1.setBackground(blanco);
		
		con2 = new JPanel();
		con2.setBounds(133,31,108,2);
		con2.setBackground(Fondo);
		
		ACur.GenerarBtnCursos();
		formPerfil();
		
		this.add(con1);
		this.add(con2);
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(fondo);
		this.add(cursos);
		this.add(cursosAux);
		this.add(perfil);
		this.add(Off);
		this.add(barra);
		
		this.setVisible(true);
	}
	public void formPerfil() {        
        JLabel modificar = new JLabel("Modificar");
		modificar.setBounds(49,5,53,20);
		modificar.setForeground(blanco);
		
		JLabel cancelar = new JLabel("Cancelar");
		cancelar.setBounds(50,5,53,20);
		cancelar.setForeground(blanco);
		
		imgEdit = new JLabel();
		imgEdit.setBounds(0,0,20,20);
		
		ImageIcon img1 = new ImageIcon("Imagenes/edit.png");
        Icon icono1 = new ImageIcon(img1.getImage().getScaledInstance(imgEdit.getWidth(), imgEdit.getHeight(), Image.SCALE_DEFAULT));
        imgEdit.setIcon(icono1);
        
        imgEditE = new JLabel();
		imgEditE.setBounds(0,0,20,20);
		
		ImageIcon img1E = new ImageIcon("Imagenes/editEnabledF.png");
        Icon icono1E = new ImageIcon(img1E.getImage().getScaledInstance(imgEditE.getWidth(), imgEditE.getHeight(), Image.SCALE_DEFAULT));
        imgEditE.setIcon(icono1E);
        imgEditE.setVisible(false);
        
        JLabel perfil = new JLabel("Perfil");
        perfil.setBounds(349,50,63,20);
        perfil.setForeground(fuente2);
        perfil.setFont(new Font("", Font.BOLD, 25));
        panel2.add(perfil);
        
        JLabel nom = new JLabel("Nombres:");
        nom.setBounds(206,113,103,15);
        nom.setForeground(fuente2);
        panel2.add(nom);
        
        JLabel ape = new JLabel("Apellidos:");
        ape.setBounds(206,163,100,15);
        ape.setForeground(fuente2);
        panel2.add(ape);
        
        JLabel cor = new JLabel("Correo:");
        cor.setBounds(206,213,100,15);
        cor.setForeground(fuente2);
        panel2.add(cor);
        
        JLabel con = new JLabel("Contraseña:");
        con.setBounds(206,263,100,15);
        con.setForeground(fuente2);
        panel2.add(con);
        
        JLabel gen = new JLabel("Género:");
        gen.setBounds(206,313,100,15);
        gen.setForeground(fuente2);
        panel2.add(gen);
			
    	name = new Etiqueta();
        name.setBounds(306,105,250,31);
        name.setHorizontalAlignment(JTextField.CENTER);
        panel2.add(name);

        lastname = new Etiqueta();
        lastname.setBounds(306,155,250,31);
        lastname.setHorizontalAlignment(JTextField.CENTER);
        panel2.add(lastname);
		
		mail = new Etiqueta();
		mail.setBounds(306,205,250,31);
		mail.setHorizontalAlignment(JTextField.CENTER);
		panel2.add(mail);
		
		password = new Etiqueta();
		password.setBounds(306,255,250,31);
		password.setHorizontalAlignment(JTextField.CENTER);
		panel2.add(password);
		
		gender = new Etiqueta();
		gender.setBounds(306,305,150,31);
		gender.setHorizontalAlignment(JTextField.CENTER);
		panel2.add(gender);
		
		nameE = new JText();
        nameE.setBounds(306,105,250,31);
        nameE.setHorizontalAlignment(JTextField.CENTER);
        nameE.setVisible(false);
        panel2.add(nameE);
        
        lastnameE = new JText();
        lastnameE.setBounds(306,155,250,31);
        lastnameE.setHorizontalAlignment(JTextField.CENTER);
        lastnameE.setVisible(false);
        panel2.add(lastnameE);
		
		mailE = new JText();
		mailE.setBounds(306,205,250,31);
		mailE.setHorizontalAlignment(JTextField.CENTER);
		mailE.setVisible(false);
		panel2.add(mailE);
		
		passwordE = new JText();
		passwordE.setBounds(306,255,250,31);
		passwordE.setHorizontalAlignment(JTextField.CENTER);
		passwordE.setVisible(false);
		panel2.add(passwordE);
		
		String[] opciones = {"F","M"};
		genderE = new JComboBox<String>(opciones);
		genderE.setBounds(306,305,150,31);
		genderE.setBackground(blanco);
		genderE.setForeground(fuente1);
		genderE.getEditor().getEditorComponent().setBackground(Palido);
		genderE.setVisible(false);
		panel2.add(genderE);
		
		editar = new Boton("");
		editar.add(imgEdit);
		editar.add(imgEditE);
		editar.setBounds(565,110,20,20);
		editar.setBackground(null);
		editar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		editar();
        	}
        });
		panel2.add(editar);
				
		doModificar = new Boton(modificar);
		doModificar.setBounds(225,380,150,30);
		doModificar.setBackground(VPalido);
		doModificar.setEnabled(false);
		doModificar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		modificar();
        	}
        });
		panel2.add(doModificar);
		
		doCancelar = new Boton(cancelar);
		doCancelar.setBounds(390,380,150,30);
		doCancelar.setBackground(VPalido);
		doCancelar.setEnabled(false);
		doCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cancelar();
        	}
        });
		panel2.add(doCancelar);
		
		cargarPerfil();
	}
	public void volver() {
		Principal.main(null);
		this.dispose();
	}
	public static int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		InicioAlu.codigo = codigo;
	}
	public static String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		InicioAlu.nombre = nombre;
	}
	public static String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		InicioAlu.apellido = apellido;
	}
	public static String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		InicioAlu.genero = genero;
	}
}