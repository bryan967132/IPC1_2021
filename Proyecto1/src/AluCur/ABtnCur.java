package AluCur;
import static Interfaz.Colores.*;
import static Cursos.ControladorCurso.*;
import static Profesores.ControladorProfesor.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Interfaz.Boton;
public class ABtnCur extends JPanel {
	private static final long serialVersionUID = 1L;
	public static JPanel verCurso;
	public ABtnCur(int cur,int x,int y) {
		this.setBounds(x+78,y+20,275,80);
        this.setBackground(blanco);
        this.setLayout(new BorderLayout());
        
        verCurso = new JPanel();
        verCurso.setBounds(0,0,762,517);
        verCurso.setBackground(blanco);
        verCurso.setVisible(false);
        verCurso.setLayout(null);
        
        JLabel nomC = new JLabel(nomC(cur));
        nomC.setBounds(0,15,275,30);
        nomC.setHorizontalAlignment(JLabel.CENTER);
        nomC.setFont(new Font("", Font.BOLD, 25));
        nomC.setForeground(blanco);
        
        JLabel cantA = new JLabel("Profesor: "+nomP(cur));
        cantA.setBounds(5,58,260,20);
        cantA.setForeground(blanco);
        
        Boton curso = new Boton(nomC);
        curso.setBackground(VMedio);
        curso.add(cantA);
        curso.setBorder(BorderFactory.createLineBorder(VOscuro, 4));
        curso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NavAlu ver = new NavAlu();
				ver.verCurso(cur,String.valueOf(nomC(cur)));
			}
		});
        
        this.add(curso);
	}
	public String nomC(int cod) {
		for(int i=0; i<curso.length; i++) {
        	if(curso[i]!=null && curso[i].getCodigo()==cod) {
        		return curso[i].getNombre();
        	}
        }
		return null;
	}
	public String nomP(int cod) {
		for(int i=0; i<curso.length; i++) {
        	if(curso[i]!=null && curso[i].getCodigo()==cod) {
        		for(int j=0; j<profesor.length; j++) {
        			if(profesor[j]!=null && profesor[j].getCodigo()==curso[i].getProfesor()) {
        				return profesor[j].getNombre()+" "+profesor[j].getApellido();
        			}
        		}
        	}
        }
		return null;
	}
}