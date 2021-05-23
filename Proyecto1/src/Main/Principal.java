package Main;
import Actividades.ControladorActividad;
import Actividades.ControladorNota;
import Administracion.GestorAdministrador;
import Alumnos.ControladorAlumno;
import AsignacionCurso.AsignacionCurso;
import Cursos.ControladorCurso;
import Profesores.ControladorProfesor;
import DTT.*;
public class Principal {
	public static void main(String[] args) {
		ControladorActividad.Deserializar();
		ControladorProfesor.Deserializar();
		ControladorAlumno.Deserializar();
		ControladorCurso.Deserializar();
		ControladorNota.Deserializar();
		AsignacionCurso.Deserializar();
		Start();
	}
	public static void Start() {
		GestorAdministrador usuario  = new GestorAdministrador();
		ControladorProfesor profesor = new ControladorProfesor();
		ControladorAlumno alumno = new ControladorAlumno();
		usuario.insertarusuario("admin","admin");
		new Login(usuario,profesor,alumno);
	}
}