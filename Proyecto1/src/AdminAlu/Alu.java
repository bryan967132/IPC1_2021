package AdminAlu;
import static DTT.InicioAdmin.*;
import static Interfaz.Colores.*;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Interfaz.*;
public class Alu {
	static Boton cargaM,exp;
	static Boton doCargaM;
	static Boton backCM;
	static JPanel datos,grafica;
	static JPanel header;
	static JLabel Titulo;
	static JTable tabla;
	static JText ruta;
	static JLabel capacidad;
	public void Componentes() {
		JLabel b1,b2;
		FunBtnAlu alu = new FunBtnAlu();
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
		
		FormCargar();
				
		b1 = new JLabel("Carga Masiva");
		b1.setBounds(124,5,78,20);
		b1.setForeground(blanco);
				
		cargaM = new Boton(b1);
		cargaM.setBounds(407,70,325,30);
		cargaM.setBackground(VMedio);
		cargaM.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		alu.formCarga();
        		alu.cambiar();
        	}
        });
		
		b2 = new JLabel("Exportar Listado a PDF");
		b2.setBounds(98,5,130,20);
		b2.setForeground(blanco);
		
		exp = new Boton(b2);
		exp.setBounds(407,120,325,30);
		exp.setBackground(VMedio);
		exp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		alu.exportarLista();
        	}
        });
		
		//header();
		alu.TabGraph();
	
		addPanel3();
	}
	public void FormCargar() {
		JLabel carga = new JLabel();
		JLabel imgBack = new JLabel();
        imgBack.setBounds(0,0,40,40);
		ImageIcon img = new ImageIcon("Imagenes/back.png");
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(imgBack.getWidth(), imgBack.getHeight(), Image.SCALE_DEFAULT));
        imgBack.setIcon(icono);
		
		ruta = new JText();
		ruta.setPlaceholder("Ingrese la ruta de los alumnos");
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
        		FunBtnAlu alu = new FunBtnAlu();
        		alu.cargaMasiva();
        		alu.volver();
        	}
        });
		
		backCM = new Boton("");
		backCM.add(imgBack);
		backCM.setBounds(339,110,40,40);
		backCM.setBackground(null);
		backCM.setVisible(false);
		backCM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FunBtnAlu alu = new FunBtnAlu();
				alu.volver();
			}
		});
	}
	public void addPanel3() {
		panel3.add(header);
		panel3.add(grafica);
		panel3.add(datos);
		
		panel3.add(ruta);
		panel3.add(doCargaM);
		panel3.add(backCM);
		panel3.add(Titulo);
		
		panel3.add(cargaM);
		panel3.add(exp);
	}
}