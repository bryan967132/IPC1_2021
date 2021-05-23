package AluCur;
import static DTT.InicioAlu.*;
import static Interfaz.Colores.*;
import static AluCur.ABtnCur.*;
public class NavAlu {
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
	public void verCurso(int cur,String nom) {
		cursosAux.setBackground(blanco);
		t1Aux.setForeground(fuente1);
		panel1.setVisible(false);
		panel2.setVisible(false);
		panel3.setVisible(true);
		cursos.setVisible(false);
		cursosAux.setVisible(true);
		verCurso.setVisible(true);
		GestCurso cursos = new GestCurso();
		cursos.form(cur,nom);
	}
}
