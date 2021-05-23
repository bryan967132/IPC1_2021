package ProfCur;
import static DTT.InicioProf.*;
import static Interfaz.Colores.*;
import static ProfCur.PBtnCur.*;
public class NavegacionP {
	public void cursos() {
		cursos.setBackground(blanco);
		t1.setForeground(fuente1);
		t1Aux.setForeground(fuente1);
		perfil.setBackground(Medio);
		t2.setForeground(blanco);
		panel1.setVisible(true);
		panel2.setVisible(false);
		panel3.setVisible(false);
		cursos.setVisible(true);
		cursosAux.setVisible(false);
	}
	public void perfil() {
		cursos.setBackground(Medio);
		cursosAux.setBackground(Medio);
		t1.setForeground(blanco);
		t1Aux.setForeground(blanco);
		perfil.setBackground(blanco);
		t2.setForeground(fuente1);
		panel1.setVisible(false);
		panel2.setVisible(true);
		panel3.setVisible(false);
	}
	public void cursosG() {
		cursosAux.setBackground(blanco);
		t1Aux.setForeground(fuente1);
		perfil.setBackground(Medio);
		t2.setForeground(blanco);
		panel1.setVisible(false);
		panel2.setVisible(false);
		panel3.setVisible(true);
	}
	public void GestionarCurso(int codigo,String nombre) {
		cursosAux.setBackground(blanco);
		t1Aux.setForeground(fuente1);
		panel1.setVisible(false);
		panel2.setVisible(false);
		panel3.setVisible(true);
		cursos.setVisible(false);
		cursosAux.setVisible(true);
		control.setVisible(true);
		GestionarCurso cursos = new GestionarCurso();
		cursos.form(codigo,nombre);
	}
}
