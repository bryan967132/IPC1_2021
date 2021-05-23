package AdminCur;
import static Cursos.ControladorCurso.*;
import static AdminCur.Cur.*;
import static AsignacionCurso.AsignacionCurso.listado;
import static Interfaz.Colores.*;
import static DTT.InicioAdmin.*;
import static Profesores.ControladorProfesor.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import Cursos.Curso;
public class CompCur {
	public static Curso[] temp = new Curso[50];
	public void grafica() {
		grafica.setLayout(new BorderLayout());
		 // Fuente de Datos
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i=0; i<curso.length; i++) {
        	temp[i]=curso[i];
        }
        try {
			for(int i=1; i<temp.length; i++) {
				for(int j=i-1; j>=0; j--) {
					if(temp[i].getAlumnos()>temp[j].getAlumnos()) {
						Curso aux = temp[i];
						temp[i] = temp[j];
						temp[j] = aux;
						i--;
					}
				}
			}
		}catch(Exception e) {		
		}
        for(int i=0; i<3; i++) {
        	if(temp[i]!=null && temp[i].getAlumnos()!=0){
        		if(i==0) {
        			dataset.setValue(temp[i].getAlumnos(),temp[i].getNombre(),String.valueOf(i+1)+"ro");
        		}else if(i==0) {
        			dataset.setValue(temp[i].getAlumnos(),temp[i].getNombre(),String.valueOf(i+1)+"do");
        		}else {
        			dataset.setValue(temp[i].getAlumnos(),temp[i].getNombre(),String.valueOf(i+1)+"ro");
        		}
        	}
        }
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createBarChart
        ("","Cursos", "Estudiantes", 
        dataset,PlotOrientation.VERTICAL,true,false, false);
        chart.setBackgroundPaint(Color.WHITE);
        chart.getTitle().setPaint(Color.RED);
        chart.getBackgroundPaint();
        CategoryPlot p = chart.getCategoryPlot(); 
        p.setRangeGridlinePaint(Color.black); 
        ChartPanel chartPanel = new ChartPanel(chart);
        grafica.add(chartPanel);
	}
	public void tabla() {
		int l=0;
		JPanel fondo = new JPanel();
		fondo.setBounds(0,0,350,417);
		fondo.setBackground(blanco);
		fondo.setLayout(new BorderLayout());
		for(int i=0; i<curso.length; i++) {
			if(curso[i]!=null) {
				l++;
			}
		}
		
		JPanel h1,h2,h3,h4,h5;
		JLabel c1,c2,c3,c4,c5;
		header = new JPanel();
		header.setBounds(30,70,349,24);
		header.setBackground(VOscuro);
		header.setLayout(null);
		if(l>24) {
			h1 = new JPanel();
			h1.setBounds(1,1,44,22);
			h1.setBackground(VMedio);
			h1.setLayout(null);
			
			h2 = new JPanel();
			h2.setBounds(46,1,79,22);
			h2.setBackground(VMedio);
			h2.setLayout(null);
			
			h3 = new JPanel();
			h3.setBounds(126,1,50,22);
			h3.setBackground(VMedio);
			h3.setLayout(null);
			
			h4 = new JPanel();
			h4.setBounds(177,1,50,22);
			h4.setBackground(VMedio);
			h4.setLayout(null);
			
			h5 = new JPanel();
			h5.setBounds(228,1,104,22);
			h5.setBackground(VMedio);
			h5.setLayout(null);
			
			c1 = new JLabel("Código");
			c1.setBounds(2,1,39,20);
			c1.setForeground(blanco);
			
			c2= new JLabel("Nombre");
			c2.setBounds(17,1,45,20);
			c2.setForeground(blanco);
			
			c3 = new JLabel("Créditos");
			c3.setBounds(1,1,48,20);
			c3.setForeground(blanco);
			
			c4 = new JLabel("Alumnos");
			c4.setBounds(0,1,50,20);
			c4.setForeground(blanco);
			
			c5 = new JLabel("Profesor");
			c5.setBounds(27,1,50,20);
			c5.setForeground(blanco);
			
			h1.add(c1);
			h2.add(c2);
			h3.add(c3);
			h4.add(c4);
			h5.add(c5);
			header.add(h1);
			header.add(h2);
			header.add(h3);
			header.add(h4);
			header.add(h5);
			panel2.add(header);
		}else {
			h1 = new JPanel();
			h1.setBounds(1,1,47,22);
			h1.setBackground(VMedio);
			h1.setLayout(null);
			
			h2 = new JPanel();
			h2.setBounds(49,1,82,22);
			h2.setBackground(VMedio);
			h2.setLayout(null);
			
			h3 = new JPanel();
			h3.setBounds(132,1,53,22);
			h3.setBackground(VMedio);
			h3.setLayout(null);
			
			h4 = new JPanel();
			h4.setBounds(186,1,53,22);
			h4.setBackground(VMedio);
			h4.setLayout(null);
			
			h5 = new JPanel();
			h5.setBounds(240,1,108,22);
			h5.setBackground(VMedio);
			h5.setLayout(null);
			
			c1 = new JLabel("Código");
			c1.setBounds(4,1,39,20);
			c1.setForeground(blanco);
			
			c2= new JLabel("Nombre");
			c2.setBounds(19,1,45,20);
			c2.setForeground(blanco);
			
			c3 = new JLabel("Créditos");
			c3.setBounds(3,1,48,20);
			c3.setForeground(blanco);
			
			c4 = new JLabel("Alumnos");
			c4.setBounds(2,1,50,20);
			c4.setForeground(blanco);
			
			c5 = new JLabel("Profesor");
			c5.setBounds(29,1,50,20);
			c5.setForeground(blanco);
			
			h1.add(c1);
			h2.add(c2);
			h3.add(c3);
			h4.add(c4);
			h5.add(c5);
			header.add(h1);
			header.add(h2);
			header.add(h3);
			header.add(h4);
			header.add(h5);
			panel2.add(header);
		}
		String[][] cursos = new String[l][5];
		for(int i=0; i<curso.length; i++) {
			if(curso[i]!=null) {
				cursos[i][0]=String.valueOf(curso[i].getCodigo());
				cursos[i][1]=curso[i].getNombre();
				cursos[i][2]=String.valueOf(curso[i].getCreditos());
				int cantidad = 0;
				for(int x=0; x<50; x++) {
					for(int j=2; j<52; j++) {
						if(listado[x][0]==curso[i].getCodigo() && listado[i][j]!=0) {
							cantidad++;
						}
					}
				}
				cursos[i][3]=String.valueOf(cantidad);
				String nombre="";
				for(int filas=0; filas<profesor.length; filas++) {
					if(profesor[filas]!=null && profesor[filas].getCodigo()==curso[i].getProfesor()) {
						nombre = profesor[filas].getNombre()+" "+profesor[filas].getApellido();
					}
				}
				cursos[i][4]=nombre;
			}
		}
		String[] columnas = {"ID","Nombre","Creditos","Alumnos","Profesor"};
		tabla = new JTable(cursos,columnas) {
			private static final long serialVersionUID = 1L;
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		tabla.setRowSelectionAllowed(false);
		tabla.getTableHeader().setReorderingAllowed(false);
		tabla.getColumnModel().getColumn(0).setResizable(false);
		tabla.getColumnModel().getColumn(1).setResizable(false);
		tabla.getColumnModel().getColumn(2).setResizable(false);
		tabla.getColumnModel().getColumn(3).setResizable(false);
		tabla.getColumnModel().getColumn(4).setResizable(true);
		tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(50);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(20);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(20);
		DefaultTableCellRenderer alineacion = new DefaultTableCellRenderer();
		alineacion.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		tabla.getColumn("ID").setCellRenderer(alineacion);
		tabla.getColumn("Nombre").setCellRenderer(alineacion); 
		tabla.getColumn("Creditos").setCellRenderer(alineacion); 
		tabla.getColumn("Alumnos").setCellRenderer(alineacion); 
		tabla.getColumn("Profesor").setCellRenderer(alineacion);
		tabla.setBounds(0,0,340,372);
		tabla.setFont(new Font("Tahoma",Font.PLAIN,10));
		fondo.add(tabla);
		JScrollPane sp = new JScrollPane(fondo);
		sp.setBounds(0,0,349,372);
		sp.setVisible(true);
		datos.add(sp);
	}
}