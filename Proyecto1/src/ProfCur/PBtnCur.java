package ProfCur;
import static Interfaz.Colores.*;
import static Cursos.ControladorCurso.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Interfaz.Boton;
public class PBtnCur extends JPanel {
	private static final long serialVersionUID = 1L;
	public static JPanel control,eliminacion;
	public PBtnCur(int cod,int x,int y) {
		this.setBounds(x+78,y+20,275,80);
        this.setBackground(blanco);
        this.setLayout(new BorderLayout());
        
        control = new JPanel();
        control.setBounds(0,0,762,517);
        control.setBackground(blanco);
        control.setVisible(false);
        control.setLayout(null);
        
        eliminacion = new JPanel();
        eliminacion.setBounds(0,0,762,517);
        eliminacion.setBackground(blanco);
        eliminacion.setVisible(false);
        eliminacion.setLayout(null);

        JLabel nomC = new JLabel(nomC(cod));
        nomC.setBounds(0,15,275,30);
        nomC.setHorizontalAlignment(JLabel.CENTER);
        nomC.setFont(new Font("",Font.BOLD,25));
        nomC.setForeground(blanco);
        
        JLabel rotulo = new JLabel("Alumnos:");
        rotulo.setBounds(195,60,53,10);
        rotulo.setForeground(blanco);
        
        JLabel cantA = new JLabel(String.valueOf(cantA(cod)));
        cantA.setBounds(251,60,14,10);
        cantA.setForeground(blanco);
        
        Boton Vcurso = new Boton(nomC);
        Vcurso.setBackground(VMedio);
        Vcurso.add(rotulo);
        Vcurso.add(cantA);
        Vcurso.setBorder(BorderFactory.createLineBorder(VOscuro,4));
        Vcurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NavegacionP cursos = new NavegacionP();
				cursos.GestionarCurso(cod,String.valueOf(nomC(cod)));
			}
		});
        
        this.add(Vcurso);
	}
	public static String nomC(int cod) {
		for(int i=0; i<curso.length; i++) {
        	if(curso[i]!=null && curso[i].getCodigo()==cod) {
        		return curso[i].getNombre();
        	}
        }
		return null;
	}
	public static int cantA(int cur) {
		for(int i=0; i<curso.length; i++) {
        	if(curso[i]!=null && curso[i].getCodigo()==cur) {
        		return curso[i].getAlumnos();
        	}
        }
		return 0;
	}
}