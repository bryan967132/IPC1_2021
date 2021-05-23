package ProfCur;
import static DTT.InicioProf.*;
import static Interfaz.Colores.*;
import static ProfCur.PBtnCur.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Interfaz.*;
import ListasExportadas.Top5Mejores;
import ListasExportadas.Top5Peores;
public class GestionarCurso {
	public static JTable tablaAlu,tablaActividades;
	public static JPanel datosTAlu,datosActividades,header,header1;
	public static Boton cargaM,doCarga,mejores,peores,crAct;
	public static JText ruta,nom,desc,pnd,notas;
	public static JLabel acumulado,rotulo,fraccion;
	public void form(int codigo,String nombre) {
		datosTAlu = new JPanel();
		datosTAlu.setLayout(new BorderLayout());
		datosTAlu.setBounds(28,116,350,165);
		datosTAlu.setBackground(Medio);
		
		datosActividades = new JPanel();
		datosActividades.setLayout(new BorderLayout());
		datosActividades.setBounds(388,116,350,85);
		datosActividades.setBackground(Medio);
		
		JLabel imgBack = new JLabel();
        imgBack.setBounds(0,0,40,40);
		ImageIcon img1 = new ImageIcon("Imagenes/backL.png");
        Icon icono1 = new ImageIcon(img1.getImage().getScaledInstance(imgBack.getWidth(), imgBack.getHeight(), Image.SCALE_DEFAULT));
        imgBack.setIcon(icono1);
        
        JLabel Curso = new JLabel(nombre);
        Curso.setBounds(28,30,706,30);
        Curso.setForeground(fuente2);
        Curso.setFont(new Font("", Font.BOLD, 25));
        
        JLabel tT1 = new JLabel("Listado Alumnos");
        tT1.setBounds(28,70,200,20);
        tT1.setForeground(fuente2);
		
		JLabel tT2 = new JLabel("Actividades");
		tT2.setBounds(388,70,200,20);
		tT2.setForeground(fuente2);
        
        Boton back = new Boton("");
		back.add(imgBack);
		back.setBounds(699,30,40,40);
		back.setBackground(null);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NavegacionP cursos = new NavegacionP();
				cursos.cursos();
				control.removeAll();
			}
		});
		
		ComponentesGestionC tabla = new ComponentesGestionC();
		tabla.tablaLisAlu(codigo);
		tabla.tablaActividades(codigo);
		cMasAlu(codigo);
		reportes(codigo);
		formActi(codigo);
		
		control.add(datosActividades);
		control.add(datosTAlu);
		control.add(Curso);
		control.add(tT1);
		control.add(tT2);
		control.add(back);
		panel3.add(control);
		panel3.add(eliminacion);
	}
	public void cMasAlu(int codigo) {
		JLabel b1 = new JLabel("Carga Masiva Alumnos");
		b1.setBounds(0,0,350,30);
		b1.setHorizontalAlignment(JLabel.CENTER);
		b1.setForeground(blanco);
				
		cargaM = new Boton(b1);
		cargaM.setBounds(28,300,350,30);
		cargaM.setBackground(VMedio);
		cargaM.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FunBtnPCur.formC();
        	}
        });
		
		ruta = new JText();
		ruta.setPlaceholder("Ingrese la ruta de asignación");
		ruta.setBounds(28,300,215,30);
		ruta.setVisible(false);
		
		JLabel b2 = new JLabel("Cargar");
		b2.setBounds(0,0,127,30);
		b2.setHorizontalAlignment(JLabel.CENTER);
		b2.setForeground(blanco);
				
		doCarga = new Boton(b2);
		doCarga.setBounds(251,300,127,30);
		doCarga.setBackground(VMedio);
		doCarga.setVisible(false);
		doCarga.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FunBtnPCur.cargar(codigo);
        	}
        });
		
		control.add(cargaM);
		control.add(ruta);
		control.add(doCarga);
	}
	public void reportes(int codigo) {
		JLabel tR = new JLabel("Reportes");
		tR.setBounds(28,380,200,20);
		tR.setForeground(fuente2);
		
		JLabel b1 = new JLabel("Top 5 - Estudiantes con Mejor Rendimiento");
		b1.setBounds(0,0,350,30);
		b1.setHorizontalAlignment(JLabel.CENTER);
		b1.setForeground(blanco);
				
		mejores = new Boton(b1);
		mejores.setBounds(28,415,350,30);
		mejores.setBackground(VMedio);
		mejores.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Top5Mejores.Exportar(codigo,PBtnCur.nomC(codigo));
        	}
        });
		
		JLabel b2 = new JLabel("Top 5 - Estudiantes con Peor Rendimiento");
		b2.setBounds(0,0,350,30);
		b2.setHorizontalAlignment(JLabel.CENTER);
		b2.setForeground(blanco);
				
		peores = new Boton(b2);
		peores.setBounds(28,459,350,30);
		peores.setBackground(VMedio);
		peores.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Top5Peores.Exportar(codigo,PBtnCur.nomC(codigo));
        	}
        });
		
		control.add(tR);
		control.add(peores);
		control.add(mejores);
	}
	public void formActi(int codigo) {
		JLabel crA = new JLabel("Crear Actividad");
		crA.setBounds(431,239,100,30);
		crA.setForeground(fuente2);
		
		JLabel nm = new JLabel("Nombre:");
		nm.setBounds(431,283,100,30);
		nm.setForeground(fuente2);
		
		nom = new JText();
		nom.setBounds(532,283,206,30);
		
		JLabel ds = new JLabel("Descripción:");
		ds.setBounds(431,327,100,30);
		ds.setForeground(fuente2);
		
		desc = new JText();
		desc.setBounds(532,327,206,30);
		
		JLabel pd = new JLabel("Ponderación:");
		pd.setBounds(431,371,100,30);
		pd.setForeground(fuente2);
		
		pnd = new JText();
		pnd.setBounds(532,371,206,30);
		
		JLabel nt = new JLabel("Notas:");
		nt.setBounds(431,415,100,30);
		nt.setForeground(fuente2);
		
		notas = new JText();//-----------------------------------------
		notas.setBounds(532,415,206,30);
		notas.setPlaceholder("Ingrese la ruta");
		
		/*JLabel csv = new JLabel("Seleccionar archivo csv");
		csv.setBounds(0,0,206,30);
		csv.setForeground(blanco);
		csv.setHorizontalAlignment(JLabel.CENTER);
				
		notas = new Boton(csv);
		notas.setBounds(532,415,206,30);
		notas.setBackground(VMedio);
		notas.setVisible(false);
		notas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		eleccion();
        	}
        });*/
		
		JLabel cr = new JLabel("Crear Actividad");
		cr.setBounds(0,0,307,30);
		cr.setForeground(blanco);
		cr.setHorizontalAlignment(JLabel.CENTER);
				
		crAct = new Boton(cr);
		crAct.setBounds(431,459,307,30);
		crAct.setBackground(VMedio);
		crAct.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FunBtnPCur.crearActividad(codigo);
        	}
        });
		
		control.add(crA);
		control.add(nm);
		control.add(nom);
		control.add(ds);
		control.add(desc);
		control.add(pd);
		control.add(pnd);
		control.add(nt);
		control.add(notas);
		control.add(crAct);
	}
	/*public static void eleccion() {
		JFrame frame = new JFrame();
		JFileChooser elegir = new JFileChooser();
		int opciones = elegir.showOpenDialog(frame);
		if(opciones == JFileChooser.APPROVE_OPTION) {
			pnd.setText(elegir.getSelectedFile().toString());
		}
	}*/
	public void formSuprAlu(int cur,int alum) {                
        JLabel nom = new JLabel("Nombres:");
        nom.setBounds(206,113,100,15);
        nom.setForeground(fuente2);
        eliminacion.add(nom);
        
        JLabel ape = new JLabel("Apellidos:");
        ape.setBounds(206,163,100,15);
        ape.setForeground(fuente2);
        eliminacion.add(ape);
        
        JLabel cor = new JLabel("Correo:");
        cor.setBounds(206,213,100,15);
        cor.setForeground(fuente2);
        eliminacion.add(cor);
        
        JLabel con = new JLabel("Contraseña:");
        con.setBounds(206,263,100,15);
        con.setForeground(fuente2);
        eliminacion.add(con);
        
        JLabel gen = new JLabel("Género:");
        gen.setBounds(206,313,100,15);
        gen.setForeground(fuente2);
        eliminacion.add(gen);
        
        getterCodS = new Etiqueta();
        //getterCodS.setBounds(50,50,250,31);
        //getterCodS.setHorizontalAlignment(JTextField.CENTER);
        //getterCodS.setVisible(false);
    	//eliminacion.add(getterCodS);
			
    	nameS = new Etiqueta();
    	nameS.setBounds(306,105,250,31);
    	nameS.setHorizontalAlignment(JTextField.CENTER);
    	eliminacion.add(nameS);

        lastnameS = new Etiqueta();
        lastnameS.setBounds(306,155,250,31);
        lastnameS.setHorizontalAlignment(JTextField.CENTER);
        eliminacion.add(lastnameS);
		
		mailS = new Etiqueta();
		mailS.setBounds(306,205,250,31);
		mailS.setHorizontalAlignment(JTextField.CENTER);
		eliminacion.add(mailS);
		
		passwordS = new Etiqueta();
		passwordS.setBounds(306,255,250,31);
		passwordS.setHorizontalAlignment(JTextField.CENTER);
		eliminacion.add(passwordS);
		
		genderS = new Etiqueta();
		genderS.setBounds(306,305,150,31);
		genderS.setHorizontalAlignment(JTextField.CENTER);
		eliminacion.add(genderS);
				
		JLabel eliminar = new JLabel("Eliminar Estudiante del Curso");
		eliminar.setBounds(0,0,200,30);
		eliminar.setHorizontalAlignment(JTextField.CENTER);
		eliminar.setForeground(blanco);	
		
		doEliminar = new Boton(eliminar);
		doEliminar.setBounds(281,380,200,30);
		doEliminar.setBackground(VMedio);
		doEliminar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FunBtnPCur.eliminando(cur,alum);
				eliminacion.setVisible(false);
				eliminacion.removeAll();
				control.setVisible(true);
				FunBtnPCur.TabAlu(cur);
        	}
        });
		eliminacion.add(doEliminar);
		
		JLabel imgBack = new JLabel();
        imgBack.setBounds(0,0,40,40);
		ImageIcon img1 = new ImageIcon("Imagenes/backL.png");
        Icon icono1 = new ImageIcon(img1.getImage().getScaledInstance(imgBack.getWidth(), imgBack.getHeight(), Image.SCALE_DEFAULT));
        imgBack.setIcon(icono1);
        
        Boton back = new Boton("");
		back.add(imgBack);
		back.setBounds(699,30,40,40);
		back.setBackground(null);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminacion.setVisible(false);
				eliminacion.removeAll();
				control.setVisible(true);
			}
		});
		eliminacion.add(back);
	}
}
