package AdminProf;
import static DTT.InicioAdmin.*;
import static Interfaz.Colores.*;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Interfaz.*;
public class Prof {
	static Boton crear,cargaM,act,supr,exp;
	static Boton doCrear,doCargaM,doAct,doSupr;
	static Boton backCr,backCM,backAct,backSupr;
	static Boton buscar,buscarSupr;
	static JPanel datos,grafica;
	static JPanel header;
	static JLabel Titulo;
	static JTable tabla;
	static JText ruta;
	static JText codigo,nombre,apellido,correo;
	static JText Acodigo,Anombre,Aapellido,Acorreo,Acontraseña;
	static JText Dcodigo;
	static Etiqueta Dnombre,Dapellido,Dcorreo;
	static JComboBox<String> genero,Agenero;
	static JPassword contraseña;
	static JLabel capacidad;
	public void Componentes() {
		JLabel b1,b2,b3,b4,b5;
		FunBtnProf prof = new FunBtnProf();
		Titulo = new JLabel("Listado Oficial");
		Titulo.setBounds(30,30,200,20);
		Titulo.setForeground(fuente2);
				
		datos = new JPanel();
		datos.setLayout(new BorderLayout());
		datos.setBounds(30,93,350,396);
		datos.setBackground(Medio);
		
		grafica = new JPanel();
		grafica.setLayout(new BorderLayout());
		grafica.setBounds(407,190,325,296);
		grafica.setBackground(Medio);
		
		b1 = new JLabel("Crear");
		b1.setBounds(59,5,32,20);
		b1.setForeground(blanco);
		
		FormCrear();
		FormCargar();
		FormActualizar();
		FormSuprimir();
		
		crear = new Boton(b1);
		crear.setBounds(407,70,150,30);
		crear.setBackground(VMedio);
		crear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		prof.formCrear();
        		prof.cambiar();
        	}
        });
		
		b2 = new JLabel("Carga Masiva");
		b2.setBounds(37,5,78,20);
		b2.setForeground(blanco);
				
		cargaM = new Boton(b2);
		cargaM.setBounds(582,70,150,30);
		cargaM.setBackground(VMedio);
		cargaM.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		prof.formCarga();
        		prof.cambiar();
        		//eleccion();
        	}
        });
		
		b3 = new JLabel("Actualizar");
		b3.setBounds(47,5,58,20);
		b3.setForeground(blanco);
		
		act = new Boton(b3);
		act.setBounds(407,110,150,30);
		act.setBackground(VMedio);
		act.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		prof.formAct();
        		prof.cambiar();
        	}
        });
		
		b4 = new JLabel("Eliminar");
		b4.setBounds(52,5,46,20);
		b4.setForeground(blanco);
		
		supr = new Boton(b4);
		supr.setBounds(582,110,150,30);
		supr.setBackground(VMedio);
		supr.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		prof.formEliminar();
        		prof.cambiar();
        	}
        });
		
		b5 = new JLabel("Exportar Listado a PDF");
		b5.setBounds(98,5,130,20);
		b5.setForeground(blanco);
		
		exp = new Boton(b5);
		exp.setBounds(407,150,325,30);
		exp.setBackground(VMedio);
		exp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		prof.exportarLista();
        	}
        });
		
		//header();
		prof.TabGraph();
	
		addPanel1();
	}
	public void FormCrear() {
		JLabel carga = new JLabel();
		JLabel imgBack = new JLabel();
        imgBack.setBounds(0,0,40,40);
		ImageIcon img = new ImageIcon("Imagenes/back.png");
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(imgBack.getWidth(), imgBack.getHeight(), Image.SCALE_DEFAULT));
        imgBack.setIcon(icono);
		
		codigo = new JText();
		codigo.setPlaceholder("Código");
		codigo.setBounds(30,70,100,31);
		codigo.setVisible(false);
		codigo.setHorizontalAlignment(JTextField.CENTER);
		
		nombre = new JText();
		nombre.setPlaceholder("Nombres");
		nombre.setBounds(30,120,350,31);
		nombre.setVisible(false);
		nombre.setHorizontalAlignment(JTextField.CENTER);

		apellido = new JText();
		apellido.setPlaceholder("Apellidos");
		apellido.setBounds(30,170,350,31);
		apellido.setVisible(false);
		apellido.setHorizontalAlignment(JTextField.CENTER);
		
		correo = new JText();
		correo.setPlaceholder("Correo");
		correo.setBounds(30,220,350,31);
		correo.setVisible(false);
		correo.setHorizontalAlignment(JTextField.CENTER);
		
		contraseña = new JPassword();
		contraseña.setPlaceholder("Contraseña");
		contraseña.setBounds(30,270,350,31);
		contraseña.setVisible(false);
		contraseña.setHorizontalAlignment(JTextField.CENTER);
		
		String[] opciones = {"F","M"};
		genero = new JComboBox<String>(opciones);
		genero.setBounds(30,320,70,31);
		genero.setBackground(blanco);
		genero.setForeground(fuente1);
		genero.getEditor().getEditorComponent().setBackground(Palido);
		genero.setVisible(false);
		
		carga = new JLabel("Crear");
		carga.setBounds(59,5,40,20);
		carga.setForeground(blanco);
		
		doCrear = new Boton(carga);
		doCrear.setBounds(130,370,150,30);
		doCrear.setBackground(VMedio);
		doCrear.setVisible(false);
		doCrear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FunBtnProf prof = new FunBtnProf();
        		prof.nuevoProfesor();
        	}
        });
		
		backCr = new Boton("");
		backCr.add(imgBack);
		backCr.setBounds(339,70,40,40);
		backCr.setBackground(null);
		backCr.setVisible(false);
		backCr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FunBtnProf prof = new FunBtnProf();
				prof.volver();
			}
		});
	}
	public void FormCargar() {
		JLabel carga = new JLabel();
		JLabel imgBack = new JLabel();
        imgBack.setBounds(0,0,40,40);
		ImageIcon img = new ImageIcon("Imagenes/back.png");
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(imgBack.getWidth(), imgBack.getHeight(), Image.SCALE_DEFAULT));
        imgBack.setIcon(icono);
		
		ruta = new JText();
		ruta.setPlaceholder("Ingrese la ruta de los profesores");
		ruta.setBounds(30,70,245,31);
		ruta.setVisible(false);
		
		carga = new JLabel("Cargar");
		carga.setBounds(31,5,40,20);
		carga.setForeground(blanco);
		
		doCargaM = new Boton(carga);
		doCargaM.setBounds(279,70,100,30);
		doCargaM.setBackground(VMedio);
		doCargaM.setVisible(false);
		doCargaM.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FunBtnProf prof = new FunBtnProf();
        		prof.cargaMasiva();
        		prof.volver();
        	}
        });
		
		backCM = new Boton("");
		backCM.add(imgBack);
		backCM.setBounds(339,110,40,40);
		backCM.setBackground(null);
		backCM.setVisible(false);
		backCM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FunBtnProf prof = new FunBtnProf();
				prof.volver();
			}
		});
	}
	
	public static void eleccion() {
		JFrame frame = new JFrame();
		JFileChooser elegir = new JFileChooser();
		int opciones = elegir.showOpenDialog(frame);
		if(opciones == JFileChooser.APPROVE_OPTION) {
			System.out.println(elegir.getSelectedFile().toString());
		}
	}
	
	public void FormActualizar() {
		JLabel actualizar = new JLabel();
		JLabel imgBack = new JLabel();
        imgBack.setBounds(0,0,40,40);
		ImageIcon img = new ImageIcon("Imagenes/back.png");
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(imgBack.getWidth(), imgBack.getHeight(), Image.SCALE_DEFAULT));
        imgBack.setIcon(icono);
        
        JLabel imgSearch = new JLabel();
        imgSearch.setBounds(0,0,30,30);
		ImageIcon imgS = new ImageIcon("Imagenes/search.png");
        Icon iconoS = new ImageIcon(imgS.getImage().getScaledInstance(imgSearch.getWidth(), imgSearch.getHeight(), Image.SCALE_DEFAULT));
        imgSearch.setIcon(iconoS);
		
		Acodigo = new JText();
		Acodigo.setPlaceholder("Código a buscar");
		Acodigo.setBounds(30,70,100,31);
		Acodigo.setBackground(blanco);
		Acodigo.setHorizontalAlignment(JTextField.CENTER);
		
		Anombre = new JText();
		Anombre.setPlaceholder("Nombres");
		Anombre.setBounds(30,120,350,31);
		Anombre.setVisible(false);
		Anombre.setHorizontalAlignment(JTextField.CENTER);

		Aapellido = new JText();
		Aapellido.setPlaceholder("Apellidos");
		Aapellido.setBounds(30,170,350,31);
		Aapellido.setVisible(false);
		Aapellido.setHorizontalAlignment(JTextField.CENTER);
		
		Acorreo = new JText();
		Acorreo.setPlaceholder("Correo");
		Acorreo.setBounds(30,220,350,31);
		Acorreo.setVisible(false);
		Acorreo.setHorizontalAlignment(JTextField.CENTER);
		
		Acontraseña = new JText();
		Acontraseña.setPlaceholder("Contraseña");
		Acontraseña.setBounds(30,270,350,31);
		Acontraseña.setVisible(false);
		Acontraseña.setHorizontalAlignment(JTextField.CENTER);
		
		String[] opciones = {"F","M"};
		Agenero = new JComboBox<String>(opciones);
		Agenero.setToolTipText("Genero");
		Agenero.setBounds(30,320,70,31);
		Agenero.setBackground(blanco);
		Agenero.setForeground(fuente1);
		Agenero.getEditor().getEditorComponent().setBackground(Palido);
		Agenero.setVisible(false);
		
		actualizar = new JLabel("Actualizar");
		actualizar.setBounds(47,5,57,20);
		actualizar.setForeground(blanco);
		
		doAct = new Boton(actualizar);
		doAct.setBounds(130,370,150,30);
		doAct.setBackground(VMedio);
		doAct.setVisible(false);
		doAct.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FunBtnProf prof = new FunBtnProf();
        		prof.actualizarProfesor();
        	}
        });
		
		backAct = new Boton("");
		backAct.add(imgBack);
		backAct.setBounds(339,70,40,40);
		backAct.setBackground(null);
		backAct.setVisible(false);
		backAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FunBtnProf prof = new FunBtnProf();
				prof.volver();
			}
		});
		
		buscar = new Boton("");
		buscar.add(imgSearch);
		buscar.setBounds(140,70,30,30);
		buscar.setBackground(null);
		buscar.setVisible(false);
		buscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FunBtnProf prof = new FunBtnProf();
        		prof.ubicarProf();
        	}
        });
	}
	public void FormSuprimir() {
		JLabel borrar = new JLabel();
		
		JLabel imgBack = new JLabel();
        imgBack.setBounds(0,0,40,40);
		ImageIcon img = new ImageIcon("Imagenes/back.png");
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(imgBack.getWidth(), imgBack.getHeight(), Image.SCALE_DEFAULT));
        imgBack.setIcon(icono);
        
        JLabel imgSearch = new JLabel();
        imgSearch.setBounds(0,0,30,30);
		ImageIcon imgS = new ImageIcon("Imagenes/search.png");
        Icon iconoS = new ImageIcon(imgS.getImage().getScaledInstance(imgSearch.getWidth(), imgSearch.getHeight(), Image.SCALE_DEFAULT));
        imgSearch.setIcon(iconoS);
		
		Dcodigo = new JText();
		Dcodigo.setPlaceholder("Código a buscar");
		Dcodigo.setBounds(30,70,100,31);
		Dcodigo.setBackground(blanco);
		Dcodigo.setHorizontalAlignment(JTextField.CENTER);
		
		Dnombre = new Etiqueta();
		Dnombre.setPlaceholder("Nombres");
		Dnombre.setBounds(30,120,350,31);
		Dnombre.setVisible(false);
		Dnombre.setHorizontalAlignment(JTextField.CENTER);

		Dapellido = new Etiqueta();
		Dapellido.setPlaceholder("Apellidos");
		Dapellido.setBounds(30,170,350,31);
		Dapellido.setVisible(false);
		Dapellido.setHorizontalAlignment(JTextField.CENTER);
		
		Dcorreo = new Etiqueta();
		Dcorreo.setPlaceholder("Correo");
		Dcorreo.setBounds(30,220,350,31);
		Dcorreo.setVisible(false);
		Dcorreo.setHorizontalAlignment(JTextField.CENTER);
		
		borrar = new JLabel("Borrar");
		borrar.setBounds(56,5,37,20);
		borrar.setForeground(blanco);
		
		doSupr = new Boton(borrar);
		doSupr.setBounds(130,270,150,30);
		doSupr.setBackground(VMedio);
		doSupr.setVisible(false);
		doSupr.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FunBtnProf prof = new FunBtnProf();
        		prof.eliminarProfesor();
        	}
        });
		
		backSupr = new Boton("");
		backSupr.add(imgBack);
		backSupr.setBounds(339,70,40,40);
		backSupr.setBackground(null);
		backSupr.setVisible(false);
		backSupr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FunBtnProf prof = new FunBtnProf();
				prof.volver();
			}
		});
		
		buscarSupr = new Boton("");
		buscarSupr.add(imgSearch);
		buscarSupr.setBounds(140,70,30,30);
		buscarSupr.setBackground(null);
		buscarSupr.setVisible(false);
		buscarSupr.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FunBtnProf prof = new FunBtnProf();
        		prof.localizarProf();
        	}
        });
	}
	public void addPanel1() {
		panel1.add(header);
		panel1.add(grafica);
		panel1.add(datos);
		
		panel1.add(codigo);
		panel1.add(nombre);
		panel1.add(apellido);
		panel1.add(correo);
		panel1.add(contraseña);
		panel1.add(genero);
		panel1.add(doCrear);
		panel1.add(backCr);
		
		panel1.add(ruta);
		panel1.add(doCargaM);
		panel1.add(backCM);
		panel1.add(Titulo);
		
		panel1.add(Acodigo);
		panel1.add(Anombre);
		panel1.add(Aapellido);
		panel1.add(Acorreo);
		panel1.add(Acontraseña);
		panel1.add(Agenero);
		panel1.add(doAct);
		panel1.add(backAct);
		panel1.add(buscar);
		
		panel1.add(Dcodigo);
		panel1.add(Dnombre);
		panel1.add(Dapellido);
		panel1.add(Dcorreo);
		panel1.add(doSupr);
		panel1.add(backSupr);
		panel1.add(buscarSupr);
		
		panel1.add(crear);
		panel1.add(cargaM);
		panel1.add(act);
		panel1.add(supr);
		panel1.add(exp);
	}
}