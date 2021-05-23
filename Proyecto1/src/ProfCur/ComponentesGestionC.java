package ProfCur;
import static Interfaz.Colores.*;
import static ProfCur.GestionarCurso.*;
import static ProfCur.PBtnCur.*;
import static AsignacionCurso.AsignacionCurso.*;
import static Alumnos.ControladorAlumno.*;
import static Actividades.ControladorActividad.*;
import static Actividades.ControladorNota.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import Interfaz.Boton;
public class ComponentesGestionC {
	public void tablaLisAlu(int curso) {
		int l=0;
		JPanel fondo = new JPanel();
		fondo.setBounds(0,0,350,417);
		fondo.setBackground(blanco);
		fondo.setLayout(new BorderLayout());
		for(int i=0; i<50; i++) {
			for(int j=2; j<52; j++) {
				if(listado[i][0]==curso && listado[i][j]!=0) {
					l++;
				}
			}
		}
		JPanel h1,h2,h3,h4;
		JLabel c1,c2,c3,c4;
		header = new JPanel();
		header.setBounds(28,93,349,24);
		header.setBackground(VOscuro);
		header.setLayout(null);
		if(l>10) {
			h1 = new JPanel();
			h1.setBounds(1,1,53,22);
			h1.setBackground(VMedio);
			h1.setLayout(null);
			
			h2 = new JPanel();
			h2.setBounds(55,1,78,22);
			h2.setBackground(VMedio);
			h2.setLayout(null);
			
			h3 = new JPanel();
			h3.setBounds(134,1,79,22);
			h3.setBackground(VMedio);
			h3.setLayout(null);
			
			h4 = new JPanel();
			h4.setBounds(214,1,118,22);
			h4.setBackground(VMedio);
			h4.setLayout(null);
			
			c1 = new JLabel("Código");
			c1.setBounds(7,1,39,20);
			c1.setForeground(blanco);
			
			c2= new JLabel("Nombre");
			c2.setBounds(16,1,45,20);
			c2.setForeground(blanco);
			
			c3 = new JLabel("Apellido");
			c3.setBounds(17,1,45,20);
			c3.setForeground(blanco);
			
			c4 = new JLabel("Acciones");
			c4.setBounds(32,1,53,20);
			c4.setForeground(blanco);
			
			h1.add(c1);
			h2.add(c2);
			h3.add(c3);
			h4.add(c4);
			header.add(h1);
			header.add(h2);
			header.add(h3);
			header.add(h4);
			control.add(header);
		}else {
			h1 = new JPanel();
			h1.setBounds(1,1,57,22);
			h1.setBackground(VMedio);
			h1.setLayout(null);
			
			h2 = new JPanel();
			h2.setBounds(59,1,82,22);
			h2.setBackground(VMedio);
			h2.setLayout(null);
			
			h3 = new JPanel();
			h3.setBounds(142,1,82,22);
			h3.setBackground(VMedio);
			h3.setLayout(null);
			
			h4 = new JPanel();
			h4.setBounds(225,1,123,22);
			h4.setBackground(VMedio);
			h4.setLayout(null);
			
			c1 = new JLabel("Código");
			c1.setBounds(9,1,39,20);
			c1.setForeground(blanco);
			
			c2= new JLabel("Nombre");
			c2.setBounds(18,1,45,20);
			c2.setForeground(blanco);
			
			c3 = new JLabel("Apellido");
			c3.setBounds(19,1,45,20);
			c3.setForeground(blanco);
			
			c4 = new JLabel("Acciones");
			c4.setBounds(34,1,53,20);
			c4.setForeground(blanco);
			
			h1.add(c1);
			h2.add(c2);
			h3.add(c3);
			h4.add(c4);
			header.add(h1);
			header.add(h2);
			header.add(h3);
			header.add(h4);
			control.add(header);
		}
		String[][] alumnos = new String[l][5];
		String[] columnas = {"Código","Nombre","Apellido","Acciones"};
		tablaAlu = new JTable(alumnos,columnas) {
			private static final long serialVersionUID = 1L;
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		int f=0;
		for(int i=0; i<50; i++) {
			for(int j=2; j<52; j++) {
				if(listado[i][0]==curso && listado[i][j]!=0){
					for(int x=0; x<alumno.length; x++) {
						if(alumno[x]!=null && alumno[x].getCodigo()==listado[i][j]) {
							alumnos[f][0]=String.valueOf(alumno[x].getCodigo());
							alumnos[f][1]=alumno[x].getNombre();
							alumnos[f][2]=alumno[x].getApellido();
							int codigo=alumno[x].getCodigo();
							if(l>10) {
								JLabel ver = new JLabel("Ver más información");
								ver.setBounds(0,0,118,15);
						        ver.setHorizontalAlignment(JLabel.CENTER);
						        ver.setVerticalAlignment(JLabel.CENTER);
						        ver.setFont(new Font("Tahoma",Font.PLAIN,10));
						        ver.setForeground(fuente2);
								
								Boton info = new Boton(ver);
								info.setBounds(213,16*f,118,15);
								info.setBackground(blanco);
								info.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										control.setVisible(false);
										GestionarCurso supr = new GestionarCurso();
										supr.formSuprAlu(curso,codigo);
										FunBtnPCur.cargarPerfilAlu(codigo);
										eliminacion.setVisible(true);
									}
								});
								
								tablaAlu.add(info);
							}else {
								JLabel ver = new JLabel("Ver más información");
								ver.setBounds(0,0,122,15);
						        ver.setHorizontalAlignment(JLabel.CENTER);
						        ver.setVerticalAlignment(JLabel.CENTER);
						        ver.setFont(new Font("Tahoma",Font.PLAIN,11));
						        ver.setForeground(fuente2);
								
								Boton info = new Boton(ver);
								info.setBounds(224,16*f,122,15);
								info.setBackground(blanco);
								info.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										control.setVisible(false);
										GestionarCurso supr = new GestionarCurso();
										supr.formSuprAlu(curso,codigo);
										FunBtnPCur.cargarPerfilAlu(codigo);
										eliminacion.setVisible(true);
									}
								});
								
								tablaAlu.add(info);
							}
							f++;
						}
					}
				}
			}
		}
		tablaAlu.setRowSelectionAllowed(false);
		tablaAlu.getTableHeader().setReorderingAllowed(false);
		tablaAlu.getColumnModel().getColumn(0).setResizable(false);
		tablaAlu.getColumnModel().getColumn(1).setResizable(false);
		tablaAlu.getColumnModel().getColumn(2).setResizable(false);
		tablaAlu.getColumnModel().getColumn(3).setResizable(false);
		tablaAlu.getColumnModel().getColumn(0).setPreferredWidth(15);
		tablaAlu.getColumnModel().getColumn(1).setPreferredWidth(40);
		tablaAlu.getColumnModel().getColumn(2).setPreferredWidth(40);
		tablaAlu.getColumnModel().getColumn(3).setPreferredWidth(80);
		DefaultTableCellRenderer alineacion = new DefaultTableCellRenderer();
		alineacion.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		tablaAlu.getColumn("Código").setCellRenderer(alineacion);
		tablaAlu.getColumn("Nombre").setCellRenderer(alineacion); 
		tablaAlu.getColumn("Apellido").setCellRenderer(alineacion); 
		tablaAlu.getColumn("Acciones").setCellRenderer(alineacion);
		tablaAlu.setBounds(0,0,340,372);
		tablaAlu.setFont(new Font("Tahoma",Font.PLAIN,10));
		fondo.add(tablaAlu);
		JScrollPane sp = new JScrollPane(fondo);
		sp.setBounds(0,0,349,372);
		sp.setVisible(true);
		datosTAlu.add(sp);
	}
	public void tablaActividades(int curso) {
		JPanel fondo = new JPanel();
		fondo.setBounds(0,0,350,417);
		fondo.setBackground(blanco);
		fondo.setLayout(new BorderLayout());
		int l=0;
		for(int i=0; i<actividad.length; i++) {
			if(actividad[i]!=null && actividad[i].getCurso()==curso) {
				l++;
			}
		}
		JPanel h1,h2,h3,h4;
		JLabel c1,c2,c3,c4;
		header1 = new JPanel();
		header1.setBounds(388,93,349,24);
		header1.setBackground(VOscuro);
		header1.setLayout(null);
		if(l>5) {
			h1 = new JPanel();
			h1.setBounds(1,1,60,22);
			h1.setBackground(VMedio);
			h1.setLayout(null);
			
			h2 = new JPanel();
			h2.setBounds(62,1,129,22);
			h2.setBackground(VMedio);
			h2.setLayout(null);
			
			h3 = new JPanel();
			h3.setBounds(192,1,79,22);
			h3.setBackground(VMedio);
			h3.setLayout(null);
			
			h4 = new JPanel();
			h4.setBounds(272,1,60,22);
			h4.setBackground(VMedio);
			h4.setLayout(null);
			
			c1 = new JLabel("Nombre");
			c1.setBounds(7,1,45,20);
			c1.setForeground(blanco);
			
			c2= new JLabel("Descripción");
			c2.setBounds(31,1,68,20);
			c2.setForeground(blanco);
			
			c3 = new JLabel("Ponderación");
			c3.setBounds(4,1,72,20);
			c3.setForeground(blanco);
			
			c4 = new JLabel("Promedio");
			c4.setBounds(2,1,55,20);
			c4.setForeground(blanco);
			
			h1.add(c1);
			h2.add(c2);
			h3.add(c3);
			h4.add(c4);
			header1.add(h1);
			header1.add(h2);
			header1.add(h3);
			header1.add(h4);
			control.add(header1);
		}else {
			h1 = new JPanel();
			h1.setBounds(1,1,63,22);
			h1.setBackground(VMedio);
			h1.setLayout(null);
			
			h2 = new JPanel();
			h2.setBounds(65,1,133,22);
			h2.setBackground(VMedio);
			h2.setLayout(null);
			
			h3 = new JPanel();
			h3.setBounds(199,1,83,22);
			h3.setBackground(VMedio);
			h3.setLayout(null);
			
			h4 = new JPanel();
			h4.setBounds(283,1,65,22);
			h4.setBackground(VMedio);
			h4.setLayout(null);
			
			c1 = new JLabel("Nombre");
			c1.setBounds(9,1,45,20);
			c1.setForeground(blanco);
			
			c2= new JLabel("Descripción");
			c2.setBounds(33,1,68,20);
			c2.setForeground(blanco);
			
			c3 = new JLabel("Ponderación");
			c3.setBounds(5,1,72,20);
			c3.setForeground(blanco);
			
			c4 = new JLabel("Promedio");
			c4.setBounds(5,1,55,20);
			c4.setForeground(blanco);
			
			h1.add(c1);
			h2.add(c2);
			h3.add(c3);
			h4.add(c4);
			header1.add(h1);
			header1.add(h2);
			header1.add(h3);
			header1.add(h4);
			control.add(header1);
		}
		String[][] actividades = new String[l][4];
		int a=0;
		for(int i=0; i<50; i++) {
			for(int j=2; j<52; j++) {
				if(listado[i][0]==curso && listado[i][j]!=0) {
					a++;
				}
			}
		}
		int sumatoria=0;
		int f=0;
		double prom=0;
		for(int i=0; i<actividad.length; i++) {
			if(actividad[i]!=null && actividad[i].getCurso()==curso) {
				actividades[f][0]=actividad[i].getNombre();
				actividades[f][1]=actividad[i].getDescripcion();
				actividades[f][2]=String.valueOf((int)actividad[i].getPonderacion());
				for(int j=0; j<nota.length; j++) {
					if(nota[j]!=null && nota[j].getCodCur()==actividad[i].getCurso() && nota[j].getCodAct()==actividad[i].getCodigo()) {
						prom+=nota[j].getNota();
					}
				}
				actividades[f][3]=String.valueOf(redondearDecimales(prom/a,2));
				sumatoria+=actividad[i].getPonderacion();
				f++;
				prom=0;
			}
		}
		String[] columnas = {"Nombre","Descripción","Ponderación","Promedio"};
		tablaActividades = new JTable(actividades,columnas) {
			private static final long serialVersionUID = 1L;
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		tablaActividades.setRowSelectionAllowed(false);
		tablaActividades.getTableHeader().setReorderingAllowed(false);
		tablaActividades.getColumnModel().getColumn(0).setResizable(false);
		tablaActividades.getColumnModel().getColumn(1).setResizable(false);
		tablaActividades.getColumnModel().getColumn(2).setResizable(false);
		tablaActividades.getColumnModel().getColumn(3).setResizable(false);
		tablaActividades.getColumnModel().getColumn(0).setPreferredWidth(10);
		tablaActividades.getColumnModel().getColumn(1).setPreferredWidth(85);
		tablaActividades.getColumnModel().getColumn(2).setPreferredWidth(35);
		tablaActividades.getColumnModel().getColumn(3).setPreferredWidth(10);
		DefaultTableCellRenderer alineacion = new DefaultTableCellRenderer();
		alineacion.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		tablaActividades.getColumn("Nombre").setCellRenderer(alineacion);
		tablaActividades.getColumn("Descripción").setCellRenderer(alineacion); 
		tablaActividades.getColumn("Ponderación").setCellRenderer(alineacion); 
		tablaActividades.getColumn("Promedio").setCellRenderer(alineacion);
		tablaActividades.setBounds(0,0,340,372);
		tablaActividades.setFont(new Font("Tahoma",Font.PLAIN,10));
		fondo.add(tablaActividades);
		JScrollPane sp = new JScrollPane(fondo);
		sp.setBounds(0,0,349,372);
		sp.setVisible(true);
		datosActividades.add(sp);
		
		rotulo = new JLabel("Acumulado:");
		rotulo.setBounds(505,200,67,30);
		rotulo.setForeground(fuente2);
		control.add(rotulo);
		
		acumulado = new JLabel();
		acumulado.setText(String.valueOf(sumatoria));
		acumulado.setBounds(580,200,21,30);
		acumulado.setForeground(fuente2);
		control.add(acumulado);
		
		fraccion = new JLabel("/ 100");
		fraccion.setBounds(605,200,115,30);
		fraccion.setForeground(fuente2);
		control.add(fraccion);
	}
	private static double redondearDecimales(double valorInicial, int numeroDecimales) {
		double parteEntera, resultado;
		resultado=valorInicial;
		parteEntera=Math.floor(resultado);
		resultado=(resultado-parteEntera)*Math.pow(10,numeroDecimales);
		resultado=Math.round(resultado);
		resultado=(resultado/Math.pow(10,numeroDecimales))+parteEntera;
		return resultado;
	}
}