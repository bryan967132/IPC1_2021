package AdminProf;
import static Profesores.ControladorProfesor.profesor;
import static AdminProf.Prof.*;
import static Interfaz.Colores.*;
import static DTT.InicioAdmin.*;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.util.Rotation;
import org.jfree.data.general.DefaultPieDataset;
public class CompProf {
	public void grafica() {
		grafica.setLayout(new BorderLayout());
        DefaultPieDataset datos = new DefaultPieDataset();
        int m=0,h=0;
        for(int i=0; i<profesor.length; i++) {
        	if(profesor[i]!=null) {
	        	if(profesor[i].getGenero().equals("F")) {
	        		m++;
	        	}else {
	        		h++;
	        	}
        	}
        }
        if(m!=0 || h!=0) {
	        datos.setValue("Masculino = "+h, h); 
	        datos.setValue("Femenino = "+m, m);
        }else{
           	datos.setValue("Masculino = "+h, 1); 
    	    datos.setValue("Femenino = "+m, 1);
        }
        JFreeChart chart = ChartFactory.createPieChart3D(null,datos,true,true,false); 
        PiePlot pieplot3d = (PiePlot)chart.getPlot(); 
        pieplot3d.setLabelGenerator(null);
        //pieplot3d.setDepthFactor(0.2); 
        pieplot3d.setStartAngle(290D); 
        pieplot3d.setDirection(Rotation.CLOCKWISE); 
        pieplot3d.setForegroundAlpha(1F);
        chart.setBorderPaint(null);
        ChartPanel chartPanel = new ChartPanel(chart);
        grafica.add(chartPanel);
	}
	public void tabla() {
		int l=0;
		JPanel fondo = new JPanel();
		fondo.setBounds(0,0,350,417);
		fondo.setBackground(blanco);
		fondo.setLayout(new BorderLayout());
		for(int i=0; i<profesor.length; i++) {
			if(profesor[i]!=null) {
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
			h2.setBounds(46,1,74,22);
			h2.setBackground(VMedio);
			h2.setLayout(null);
			
			h3 = new JPanel();
			h3.setBounds(121,1,75,22);
			h3.setBackground(VMedio);
			h3.setLayout(null);
			
			h4 = new JPanel();
			h4.setBounds(197,1,89,22);
			h4.setBackground(VMedio);
			h4.setLayout(null);
			
			h5 = new JPanel();
			h5.setBounds(287,1,45,22);
			h5.setBackground(VMedio);
			h5.setLayout(null);
			
			c1 = new JLabel("Código");
			c1.setBounds(2,1,39,20);
			c1.setForeground(blanco);
			
			c2= new JLabel("Nombre");
			c2.setBounds(14,1,45,20);
			c2.setForeground(blanco);
			
			c3 = new JLabel("Apellido");
			c3.setBounds(15,1,45,20);
			c3.setForeground(blanco);
			
			c4 = new JLabel("Correo");
			c4.setBounds(25,1,39,20);
			c4.setForeground(blanco);
			
			c5 = new JLabel("Género");
			c5.setBounds(2,1,41,20);
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
			panel1.add(header);
		}else {
			h1 = new JPanel();
			h1.setBounds(1,1,47,22);
			h1.setBackground(VMedio);
			h1.setLayout(null);
			
			h2 = new JPanel();
			h2.setBounds(49,1,77,22);
			h2.setBackground(VMedio);
			h2.setLayout(null);
			
			h3 = new JPanel();
			h3.setBounds(127,1,78,22);
			h3.setBackground(VMedio);
			h3.setLayout(null);
			
			h4 = new JPanel();
			h4.setBounds(206,1,92,22);
			h4.setBackground(VMedio);
			h4.setLayout(null);
			
			h5 = new JPanel();
			h5.setBounds(299,1,49,22);
			h5.setBackground(VMedio);
			h5.setLayout(null);
			
			c1 = new JLabel("Código");
			c1.setBounds(4,1,39,20);
			c1.setForeground(blanco);
			
			c2= new JLabel("Nombre");
			c2.setBounds(16,1,45,20);
			c2.setForeground(blanco);
			
			c3 = new JLabel("Apellido");
			c3.setBounds(17,1,45,20);
			c3.setForeground(blanco);
			
			c4 = new JLabel("Correo");
			c4.setBounds(26,1,39,20);
			c4.setForeground(blanco);
			
			c5 = new JLabel("Género");
			c5.setBounds(4,1,41,20);
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
			panel1.add(header);
		}
		String[][] profesores = new String[l][5];
		for(int i=0; i<profesor.length; i++) {
			if(profesor[i]!=null) {
				profesores[i][0]=String.valueOf(profesor[i].getCodigo());
				profesores[i][1]=profesor[i].getNombre();
				profesores[i][2]=profesor[i].getApellido();
				profesores[i][3]=profesor[i].getCorreo();
				profesores[i][4]=profesor[i].getGenero();
			}
		}
		String[] columnas = {"ID","Nombre","Apellidos","Correo","Género"};
		tabla = new JTable(profesores,columnas) {
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
		tabla.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(60);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(60);
		tabla.getColumnModel().getColumn(4).setPreferredWidth(30);
		DefaultTableCellRenderer alineacion = new DefaultTableCellRenderer();
		alineacion.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		tabla.getColumn("ID").setCellRenderer(alineacion);
		tabla.getColumn("Nombre").setCellRenderer(alineacion); 
		tabla.getColumn("Apellidos").setCellRenderer(alineacion); 
		tabla.getColumn("Correo").setCellRenderer(alineacion); 
		tabla.getColumn("Género").setCellRenderer(alineacion);
		tabla.setBounds(0,0,340,372);
		tabla.setFont(new Font("Tahoma",Font.PLAIN,10));
		fondo.add(tabla);
		JScrollPane sp = new JScrollPane(fondo);
		sp.setBounds(0,0,349,372);
		sp.setVisible(true);
		datos.add(sp);
	}
}