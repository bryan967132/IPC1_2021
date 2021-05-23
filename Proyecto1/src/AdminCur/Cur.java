package AdminCur;
import static DTT.InicioAdmin.*;
import static Interfaz.Colores.*;
import static Profesores.ControladorProfesor.profesor;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Interfaz.*;
public class Cur {
	static Boton crear,cargaM,act,supr,exp;
	static Boton doCrear,doCargaM,doAct,doSupr;
	static Boton backCr,backCM,backAct,backSupr;
	static Boton buscar,buscarSupr;
	static JPanel datos,grafica;
	static JPanel header;
	static JLabel Titulo;
	static JTable tabla;
	static JText ruta;
	static JText codigo,nombre,creditos;
	static JText Acodigo,Anombre,Acreditos;
	static JText Dcodigo;
	static Etiqueta Dnombre,Dcreditos,DProfesor;
	static JComboBox<String> profesorOpc,Aprofesor;
	static String[] profe;
	public void Componentes() {
		JLabel b1,b2,b3,b4,b5;
		FunBtnCur cur = new FunBtnCur();
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
        		cur.formCrear();
        		cur.cambiar();
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
        		cur.formCarga();
        		cur.cambiar();
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
        		cur.formAct();
        		cur.cambiar();
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
        		cur.formEliminar();
        		cur.cambiar();
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
        		cur.exportarLista();
        	}
        });
		
		//header();
		cur.TabGraph();
	
		addPanel2();
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
		nombre.setPlaceholder("Nombre");
		nombre.setBounds(30,120,350,31);
		nombre.setVisible(false);
		nombre.setHorizontalAlignment(JTextField.CENTER);

		creditos = new JText();
		creditos.setPlaceholder("Créditos");
		creditos.setBounds(30,170,350,31);
		creditos.setVisible(false);
		creditos.setHorizontalAlignment(JTextField.CENTER);
		
		int l=1;
		for(int i=0; i<profesor.length; i++) {
			if(profesor[i]!=null) {
				l++;
			}
		}
		profe = new String[l];
		profe[0] = "Asigne un profesor";
		for(int i=1; i<profesor.length; i++) {
			if(profesor[i-1]!=null) {
				profe[i] = 	profesor[i-1].getNombre()+" "+profesor[i-1].getApellido();
			}
		}
		profesorOpc = new JComboBox<String>(profe);
		profesorOpc.setBounds(30,220,150,31);
		profesorOpc.setBackground(blanco);
		profesorOpc.setForeground(fuente1);
		profesorOpc.getEditor().getEditorComponent().setBackground(Palido);
		profesorOpc.setVisible(false);
		
		carga = new JLabel("Crear");
		carga.setBounds(59,5,40,20);
		carga.setForeground(blanco);
		
		doCrear = new Boton(carga);
		doCrear.setBounds(230,220,150,30);
		doCrear.setBackground(VMedio);
		doCrear.setVisible(false);
		doCrear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FunBtnCur cur = new FunBtnCur();
        		cur.nuevoCurso();
        	}
        });
		
		backCr = new Boton("");
		backCr.add(imgBack);
		backCr.setBounds(339,70,40,40);
		backCr.setBackground(null);
		backCr.setVisible(false);
		backCr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FunBtnCur cur = new FunBtnCur();
				cur.volver();
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
		ruta.setPlaceholder("Ingrese la ruta de los cursos");
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
        		FunBtnCur cur = new FunBtnCur();
        		cur.cargaMasiva();
        		cur.volver();
        	}
        });
		
		backCM = new Boton("");
		backCM.add(imgBack);
		backCM.setBounds(339,110,40,40);
		backCM.setBackground(null);
		backCM.setVisible(false);
		backCM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FunBtnCur cur = new FunBtnCur();
				cur.volver();
			}
		});
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
		Acodigo.setVisible(false);
		Acodigo.setHorizontalAlignment(JTextField.CENTER);
		
		Anombre = new JText();
		Anombre.setPlaceholder("Nombre");
		Anombre.setBounds(30,120,350,31);
		Anombre.setVisible(false);
		Anombre.setHorizontalAlignment(JTextField.CENTER);

		Acreditos = new JText();
		Acreditos.setPlaceholder("Créditos");
		Acreditos.setBounds(30,170,350,31);
		Acreditos.setVisible(false);
		Acreditos.setHorizontalAlignment(JTextField.CENTER);
		
		int l=1;
		for(int i=0; i<profesor.length; i++) {
			if(profesor[i]!=null) {
				l++;
			}
		}
		profe = new String[l];
		profe[0] = "Asigne un profesor";
		for(int i=1; i<profesor.length; i++) {
			if(profesor[i-1]!=null) {
				profe[i] = profesor[i-1].getNombre()+" "+profesor[i-1].getApellido();
			}
		}
		Aprofesor = new JComboBox<String>(profe);
		Aprofesor.setToolTipText("Genero");
		Aprofesor.setBounds(30,220,150,31);
		Aprofesor.setBackground(blanco);
		Aprofesor.setForeground(fuente1);
		Aprofesor.getEditor().getEditorComponent().setBackground(Palido);
		Aprofesor.setVisible(false);
		
		actualizar = new JLabel("Actualizar");
		actualizar.setBounds(47,5,57,20);
		actualizar.setForeground(blanco);
		
		doAct = new Boton(actualizar);
		doAct.setBounds(230,220,150,30);
		doAct.setBackground(VMedio);
		doAct.setVisible(false);
		doAct.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FunBtnCur cur = new FunBtnCur();
        		cur.actualizarcurso();
        	}
        });
		
		backAct = new Boton("");
		backAct.add(imgBack);
		backAct.setBounds(339,70,40,40);
		backAct.setBackground(null);
		backAct.setVisible(false);
		backAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FunBtnCur cur = new FunBtnCur();
				cur.volver();
			}
		});
		
		buscar = new Boton("");
		buscar.add(imgSearch);
		buscar.setBounds(140,70,30,30);
		buscar.setBackground(null);
		buscar.setVisible(false);
		buscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FunBtnCur cur = new FunBtnCur();
        		cur.ubicarCurso();
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
		Dcodigo.setVisible(false);
		Dcodigo.setHorizontalAlignment(JTextField.CENTER);
		
		Dnombre = new Etiqueta();
		Dnombre.setPlaceholder("Nombre");
		Dnombre.setBounds(30,120,350,31);
		Dnombre.setVisible(false);
		Dnombre.setHorizontalAlignment(JTextField.CENTER);

		Dcreditos = new Etiqueta();
		Dcreditos.setPlaceholder("Créditos");
		Dcreditos.setBounds(30,170,350,31);
		Dcreditos.setVisible(false);
		Dcreditos.setHorizontalAlignment(JTextField.CENTER);
		
		DProfesor = new Etiqueta();
		DProfesor.setPlaceholder("Profesor");
		DProfesor.setBounds(30,220,350,31);
		DProfesor.setVisible(false);
		DProfesor.setHorizontalAlignment(JTextField.CENTER);
		
		borrar = new JLabel("Borrar");
		borrar.setBounds(56,5,37,20);
		borrar.setForeground(blanco);
		
		doSupr = new Boton(borrar);
		doSupr.setBounds(130,270,150,30);
		doSupr.setBackground(VMedio);
		doSupr.setVisible(false);
		doSupr.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FunBtnCur cur = new FunBtnCur();
        		cur.eliminarProfesor();
        	}
        });
		
		backSupr = new Boton("");
		backSupr.add(imgBack);
		backSupr.setBounds(339,70,40,40);
		backSupr.setBackground(null);
		backSupr.setVisible(false);
		backSupr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FunBtnCur cur = new FunBtnCur();
				cur.volver();
			}
		});
		
		buscarSupr = new Boton("");
		buscarSupr.add(imgSearch);
		buscarSupr.setBounds(140,70,30,30);
		buscarSupr.setBackground(null);
		buscarSupr.setVisible(false);
		buscarSupr.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FunBtnCur cur = new FunBtnCur();
        		cur.localizarCurso();
        	}
        });
	}
	public void addPanel2() {
		panel2.add(header);
		panel2.add(grafica);
		panel2.add(datos);
		
		panel2.add(codigo);
		panel2.add(nombre);
		panel2.add(creditos);
		panel2.add(profesorOpc);
		panel2.add(doCrear);
		panel2.add(backCr);
		
		panel2.add(ruta);
		panel2.add(doCargaM);
		panel2.add(backCM);
		panel2.add(Titulo);
		
		panel2.add(Acodigo);
		panel2.add(Anombre);
		panel2.add(Acreditos);
		panel2.add(Aprofesor);
		panel2.add(doAct);
		panel2.add(backAct);
		panel2.add(buscar);
		
		panel2.add(Dcodigo);
		panel2.add(Dnombre);
		panel2.add(Dcreditos);
		panel2.add(DProfesor);
		panel2.add(doSupr);
		panel2.add(backSupr);
		panel2.add(buscarSupr);
		
		panel2.add(crear);
		panel2.add(cargaM);
		panel2.add(act);
		panel2.add(supr);
		panel2.add(exp);
	}
}