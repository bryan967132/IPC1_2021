package AluCur;
import static Interfaz.Colores.*;
import static AluCur.ABtnCur.*;
import static AluCur.GestCurso.*;
import static Actividades.ControladorNota.*;
import static Actividades.ControladorActividad.*;
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
import DTT.InicioAlu;
public class ComponentesVerAct {
	public void grafica(int cur) {
		grafica.setLayout(new BorderLayout());
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i=0; i<nota.length; i++) {
        	if(nota[i]!=null && nota[i].getCodAlu()==InicioAlu.getCodigo() && nota[i].getCodCur()==cur) {
        		String act="";
        		int pond=0;
        		for(int j=0; j<actividad.length; j++) {
        			if(actividad[j]!=null && actividad[j].getCurso()==nota[i].getCodCur() && actividad[j].getCodigo()==nota[i].getCodAct()) {
        				act=actividad[j].getNombre();
        				pond=(int)actividad[j].getPonderacion();
        			}
        		}
        		dataset.setValue(nota[i].getNota()*pond/100,act,"");
        	}
        }
        JFreeChart chart = ChartFactory.createBarChart
        ("","Actividades", "Notas Obtenidas", 
        dataset,PlotOrientation.VERTICAL,true,false, false);
        chart.setBackgroundPaint(Color.WHITE);
        chart.getTitle().setPaint(Color.RED);
        chart.getBackgroundPaint();
        CategoryPlot p = chart.getCategoryPlot(); 
        p.setRangeGridlinePaint(Color.black); 
        ChartPanel chartPanel = new ChartPanel(chart);
        grafica.add(chartPanel);
	}
	
	public void tablaActR(int cur) {
		int l=0;
		JPanel fondo = new JPanel();
		fondo.setBounds(0,0,350,417);
		fondo.setBackground(blanco);
		fondo.setLayout(new BorderLayout());
		for(int i=0; i<nota.length; i++) {
        	if(nota[i]!=null && nota[i].getCodAlu()==InicioAlu.getCodigo() && nota[i].getCodCur()==cur) {
        		l++;
        	}
        }
		JPanel h1,h2,h3,h4;
		JLabel c1,c2,c3,c4;
		header = new JPanel();
		header.setBounds(28,93,705,24);
		header.setBackground(VOscuro);
		header.setLayout(null);
		
		int sumatoria=0;
		for(int i=0; i<actividad.length; i++) {
			if(actividad[i]!=null && actividad[i].getCurso()==cur) {
				sumatoria+=actividad[i].getPonderacion();
			}
		}
		double punteo=0;
		double notaA=0;
		for(int i=0; i<nota.length; i++) {
        	if(nota[i]!=null && nota[i].getCodAlu()==InicioAlu.getCodigo() && nota[i].getCodCur()==cur) {
        		for(int j=0; j<actividad.length; j++) {
        			if(actividad[j]!=null && actividad[j].getCurso()==nota[i].getCodCur() && actividad[j].getCodigo()==nota[i].getCodAct()) {
        				notaA=actividad[j].getPonderacion();
        			}
        		}
        		punteo+=notaA*nota[i].getNota();
        	}
        }
		if(l>5) {
			JPanel footer = new JPanel();
			footer.setBounds(133,198,600,24);
			footer.setBackground(VOscuro);
			footer.setLayout(null);
			
			h1 = new JPanel();
			h1.setBounds(1,1,104,22);
			h1.setBackground(VMedio);
			h1.setLayout(null);
			
			h2 = new JPanel();
			h2.setBounds(106,1,313,22);
			h2.setBackground(VMedio);
			h2.setLayout(null);
			
			h3 = new JPanel();
			h3.setBounds(420,1,134,22);
			h3.setBackground(VMedio);
			h3.setLayout(null);
			
			h4 = new JPanel();
			h4.setBounds(555,1,133,22);
			h4.setBackground(VMedio);
			h4.setLayout(null);
			
			c1 = new JLabel("Nombre");
			c1.setBounds(29,1,45,20);
			c1.setForeground(blanco);
			
			c2= new JLabel("Descripción");
			c2.setBounds(122,1,68,20);
			c2.setForeground(blanco);
			
			c3 = new JLabel("Ponderación");
			c3.setBounds(31,1,72,20);
			c3.setForeground(blanco);
			
			c4 = new JLabel("Nota Obtenida");
			c4.setBounds(26,1,80,20);
			c4.setForeground(blanco);
			
			JPanel Total = new JPanel();
			Total.setBounds(1,1,313,22);
			Total.setBackground(VMedio);
			Total.setLayout(null);
			
			JLabel T= new JLabel("Total");
			T.setBounds(142,1,28,20);
			T.setForeground(blanco);
			
			JLabel acum= new JLabel(String.valueOf(sumatoria));
			acum.setBounds(0,0,134,22);
			acum.setForeground(blanco);
			acum.setHorizontalAlignment(JLabel.CENTER);
			acum.setVisible(true);
			
			JPanel pndT = new JPanel();
			pndT.setBounds(315,1,134,22);
			pndT.setBackground(VMedio);
			pndT.setLayout(null);
			
			JLabel pts= new JLabel(String.valueOf(redondearDecimales(punteo/100,2)));
			pts.setBounds(0,0,133,22);
			pts.setForeground(blanco);
			pts.setHorizontalAlignment(JLabel.CENTER);
			pts.setVisible(true);
			
			JPanel ntoT = new JPanel();
			ntoT.setBounds(450,1,133,22);
			ntoT.setBackground(VMedio);
			ntoT.setLayout(null);
			
			h1.add(c1);
			h2.add(c2);
			h3.add(c3);
			h4.add(c4);
			Total.add(T);
			pndT.add(acum);
			ntoT.add(pts);
			header.add(h1);
			header.add(h2);
			header.add(h3);
			header.add(h4);
			footer.add(Total);
			footer.add(pndT);
			footer.add(ntoT);
			verCurso.add(header);
			verCurso.add(footer);
		}else {
			JPanel footer = new JPanel();
			footer.setBounds(136,197,597,24);
			footer.setBackground(VOscuro);
			footer.setLayout(null);
			
			h1 = new JPanel();
			h1.setBounds(1,1,107,22);
			h1.setBackground(VMedio);
			h1.setLayout(null);
			
			h2 = new JPanel();
			h2.setBounds(109,1,317,22);
			h2.setBackground(VMedio);
			h2.setLayout(null);
			
			h3 = new JPanel();
			h3.setBounds(427,1,138,22);
			h3.setBackground(VMedio);
			h3.setLayout(null);
			
			h4 = new JPanel();
			h4.setBounds(566,1,138,22);
			h4.setBackground(VMedio);
			h4.setLayout(null);
			
			c1 = new JLabel("Nombre");
			c1.setBounds(31,1,45,20);
			c1.setForeground(blanco);
			
			c2= new JLabel("Descripción");
			c2.setBounds(124,1,68,20);
			c2.setForeground(blanco);
			
			c3 = new JLabel("Ponderación");
			c3.setBounds(33,1,72,20);
			c3.setForeground(blanco);
			
			c4 = new JLabel("Nota Obtenida");
			c4.setBounds(26,1,80,20);
			c4.setForeground(blanco);
			
			JPanel Total = new JPanel();
			Total.setBounds(1,1,317,22);
			Total.setBackground(VMedio);
			Total.setLayout(null);
			
			JLabel T= new JLabel("Total");
			T.setBounds(144,1,28,20);
			T.setForeground(blanco);
			
			JLabel acum= new JLabel(String.valueOf(sumatoria));
			acum.setBounds(0,0,134,22);
			acum.setForeground(blanco);
			acum.setHorizontalAlignment(JLabel.CENTER);
			acum.setVisible(true);
			
			JPanel pndT = new JPanel();
			pndT.setBounds(319,1,138,22);
			pndT.setBackground(VMedio);
			pndT.setLayout(null);
			
			JLabel pts= new JLabel(String.valueOf(redondearDecimales(punteo/100,2)));
			pts.setBounds(0,0,133,22);
			pts.setForeground(blanco);
			pts.setHorizontalAlignment(JLabel.CENTER);
			pts.setVisible(true);
			
			JPanel ntoT = new JPanel();
			ntoT.setBounds(458,1,138,22);
			ntoT.setBackground(VMedio);
			ntoT.setLayout(null);
			
			h1.add(c1);
			h2.add(c2);
			h3.add(c3);
			h4.add(c4);
			Total.add(T);
			pndT.add(acum);
			ntoT.add(pts);
			header.add(h1);
			header.add(h2);
			header.add(h3);
			header.add(h4);
			footer.add(Total);
			footer.add(pndT);
			footer.add(ntoT);
			verCurso.add(header);
			verCurso.add(footer);
		}
		String[][] cursos = new String[l][4];
		int f=0;
		for(int i=0; i<nota.length; i++) {
        	if(nota[i]!=null && nota[i].getCodAlu()==InicioAlu.getCodigo() && nota[i].getCodCur()==cur) {
        		String act="";
        		String des="";
        		double pnd=0;
        		for(int j=0; j<actividad.length; j++) {
        			if(actividad[j]!=null && actividad[j].getCurso()==nota[i].getCodCur() && actividad[j].getCodigo()==nota[i].getCodAct()) {
        				act=actividad[j].getNombre();
        				des=actividad[j].getDescripcion();
        				pnd=actividad[j].getPonderacion();
        			}
        		}
				cursos[f][0]=act;
				cursos[f][1]=des;
				cursos[f][2]=String.valueOf((int)pnd);
				cursos[f][3]=String.valueOf(redondearDecimales(nota[i].getNota()*pnd/100,2));
				f++;
			}
		}
		String[] columnas = {"Nombre","Descripción","Ponderación","Nota Obtenida"};
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
		tabla.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(240);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(60);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(60);
		DefaultTableCellRenderer alineacion = new DefaultTableCellRenderer();
		alineacion.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		tabla.getColumn("Nombre").setCellRenderer(alineacion);
		tabla.getColumn("Descripción").setCellRenderer(alineacion); 
		tabla.getColumn("Ponderación").setCellRenderer(alineacion); 
		tabla.getColumn("Nota Obtenida").setCellRenderer(alineacion);
		tabla.setBounds(0,0,340,372);
		tabla.setFont(new Font("Tahoma",Font.PLAIN,10));
		fondo.add(tabla);
		JScrollPane sp = new JScrollPane(fondo);
		sp.setBounds(0,0,349,372);
		sp.setVisible(true);
		datosAct.add(sp);
	}
	private static double redondearDecimales(double valorInicial, int numeroDecimales) {
		double parteEntera, resultado;
		resultado=valorInicial;
		parteEntera=Math.floor(resultado);
		resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
		resultado=Math.round(resultado);
		resultado=(resultado/Math.pow(10,numeroDecimales))+parteEntera;
		return resultado;
	}
}