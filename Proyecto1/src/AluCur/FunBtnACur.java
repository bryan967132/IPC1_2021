package AluCur;
import static DTT.InicioAlu.*;
import static Interfaz.Colores.*;
import static Alumnos.ControladorAlumno.*;
import Alumnos.ControladorAlumno;
import Alumnos.Alumno;
public class FunBtnACur {
	public static void cargarPerfil() {
		for(int i=0; i<alumno.length; i++) {
			if(alumno[i]!=null && alumno[i].getCodigo()==getCodigo()) {
				name.setText(String.valueOf(alumno[i].getNombre()));
				lastname.setText(String.valueOf(alumno[i].getApellido()));
				mail.setText(String.valueOf(alumno[i].getCorreo()));
				password.setText(String.valueOf(alumno[i].getContraseña()));
				gender.setText(String.valueOf(alumno[i].getGenero()));
			}
		}
	}
	public static void editar() {
		imgEdit.setVisible(false);
		imgEditE.setVisible(true);
		
		name.setVisible(false);
		lastname.setVisible(false);
		mail.setVisible(false);
		password.setVisible(false);
		gender.setVisible(false);
		
		lastnameE.setText(lastname.getText());
		passwordE.setText(password.getText());
		mailE.setText(mail.getText());
		nameE.setText(name.getText());
		genderE.setSelectedItem(gender.getText());

		nameE.setVisible(true);
		lastnameE.setVisible(true);
		mailE.setVisible(true);
		passwordE.setVisible(true);
		genderE.setVisible(true);
		
		doModificar.setEnabled(true);
		doModificar.setBackground(VMedio);
		
		doCancelar.setEnabled(true);
		doCancelar.setBackground(VMedio);
		
		editar.setEnabled(false);
	}
	public static void cancelar() {
		imgEdit.setVisible(true);
		imgEditE.setVisible(false);
		
		name.setVisible(true);
		lastname.setVisible(true);
		mail.setVisible(true);
		password.setVisible(true);
		gender.setVisible(true);

		nameE.setVisible(false);
		lastnameE.setVisible(false);
		mailE.setVisible(false);
		passwordE.setVisible(false);
		genderE.setVisible(false);
		
		doModificar.setEnabled(false);
		doModificar.setBackground(VPalido);
		doModificar.setEnabled(true);
		
		doCancelar.setEnabled(false);
		doCancelar.setBackground(VPalido);
		editar.setEnabled(true);
	}
	public static void modificar() {
		for(int i=0; i<alumno.length; i++) {
			if(alumno[i]!=null && alumno[i].getCodigo()==getCodigo()) {
				alumno[i]=new Alumno(getCodigo(),
										  nameE.getText(),
										  lastnameE.getText(),
										  mailE.getText(),
										  passwordE.getText(),
										  genderE.getSelectedItem().toString());
				ControladorAlumno.Serializar();
				cargarPerfil();
				cancelar();
			}
		}
	}
}