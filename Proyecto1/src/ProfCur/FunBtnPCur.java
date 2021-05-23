package ProfCur;
import static DTT.InicioProf.*;
import static Interfaz.Colores.*;
import static Profesores.ControladorProfesor.*;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import static Alumnos.ControladorAlumno.*;
import static ProfCur.GestionarCurso.*;
import static AsignacionCurso.AsignacionCurso.*;
import static Actividades.ControladorActividad.*;
import Actividades.ControladorNota;
import AsignacionCurso.AsignacionCurso;
import AsignacionCurso.Controlador;
import Profesores.ControladorProfesor;
import Profesores.Profesor;
public class FunBtnPCur {
	public static void cargarPerfil() {
		for(int i=0; i<profesor.length; i++) {
			if(profesor[i]!=null && profesor[i].getCodigo()==getCodigo()) {
				name.setText(String.valueOf(profesor[i].getNombre()));
				lastname.setText(String.valueOf(profesor[i].getApellido()));
				mail.setText(String.valueOf(profesor[i].getCorreo()));
				password.setText(String.valueOf(profesor[i].getContraseña()));
				gender.setText(String.valueOf(profesor[i].getGenero()));
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
		for(int i=0; i<profesor.length; i++) {
			if(profesor[i]!=null && profesor[i].getCodigo()==getCodigo()) {
				profesor[i]=new Profesor(getCodigo(),
										  nameE.getText(),
										  lastnameE.getText(),
										  mailE.getText(),
										  passwordE.getText(),
										  genderE.getSelectedItem().toString());
				ControladorProfesor.Serializar();
				cargarPerfil();
				cancelar();
			}
		}
	}
	//ActualizaTablaGrafico
	public static void TabAlu(int curso) {
		ComponentesGestionC TabGraph = new ComponentesGestionC();
		TabGraph.tablaLisAlu(curso);
	}
	public static void TabAct(int curso) {
		ComponentesGestionC TabGraph = new ComponentesGestionC();
		TabGraph.tablaActividades(curso);
	}
	public static void resetTabAlu() {
		datosTAlu.removeAll();
	}
	public static void resetTabAct() {
		datosActividades.removeAll();
	}
	//carga masiva
	public static void formC() {
		ruta.setVisible(true);
		doCarga.setVisible(true);
		cargaM.setVisible(false);
	}
	public static void cargar(int codigo) {
		Controlador asignar = new Controlador();
		asignar.cargarmasiva(ruta.getText(),codigo);
		asignar.ordenamiento(codigo);
		AsignacionCurso.Serializar();
		
		datosTAlu.setVisible(false);
		header.setVisible(false);
		
		resetTabAlu();
		TabAlu(codigo);
		asignar.actualizarB(codigo);

		datosTAlu.setVisible(true);
		header.setVisible(true);
		ruta.setVisible(false);
		doCarga.setVisible(false);
		cargaM.setVisible(true);
		ruta.setText("");
	}
	public static void cargarPerfilAlu(int codigo) {
		for(int i=0; i<alumno.length; i++) {
			if(alumno[i]!=null && alumno[i].getCodigo()==codigo) {
				getterCodS.setText(String.valueOf(codigo));
				nameS.setText(String.valueOf(alumno[i].getNombre()));
				lastnameS.setText(String.valueOf(alumno[i].getApellido()));
				mailS.setText(String.valueOf(alumno[i].getCorreo()));
				passwordS.setText(String.valueOf(alumno[i].getContraseña()));
				genderS.setText(String.valueOf(alumno[i].getGenero()));
			}
		}
	}
	public static void eliminando(int cur,int alum) {
		eliminarAlu(cur,alum);
		header.setVisible(false);
		resetTabAlu();
		Controlador asignar = new Controlador();
		asignar.rellenado(cur);
		asignar.ordenamiento(cur);
		AsignacionCurso.Serializar();
		Controlador act = new Controlador();
		act.actualizarB(cur);
	}
	public static void eliminarAlu(int cur,int alum) {
		for(int i=0; i<50; i++) {
			if(listado[i][0]==cur) {
				for(int j=2; j<52; j++) {
					if(listado[i][j]==alum) {
						listado[i][j]=0;
					}
				}
			}
		}
	}
	public static void crearActividad(int cur) {
		int genCodA=0;
		if(nom.getText().equals("")) {
			nom.setBorder(BorderFactory.createLineBorder(Rojo));
			desc.setBorder(BorderFactory.createLineBorder(GrisB));
			pnd.setBorder(BorderFactory.createLineBorder(GrisB));
			notas.setBorder(BorderFactory.createLineBorder(GrisB));
		}else if(desc.getText().equals("")) {
			nom.setBorder(BorderFactory.createLineBorder(GrisB));
			desc.setBorder(BorderFactory.createLineBorder(Rojo));
			pnd.setBorder(BorderFactory.createLineBorder(GrisB));
			notas.setBorder(BorderFactory.createLineBorder(GrisB));
		}else if(pnd.getText().equals("")) {
			nom.setBorder(BorderFactory.createLineBorder(GrisB));
			desc.setBorder(BorderFactory.createLineBorder(GrisB));
			pnd.setBorder(BorderFactory.createLineBorder(Rojo));
			notas.setBorder(BorderFactory.createLineBorder(GrisB));
		}else if(notas.getText().equals("")){
			nom.setBorder(BorderFactory.createLineBorder(GrisB));
			desc.setBorder(BorderFactory.createLineBorder(GrisB));
			pnd.setBorder(BorderFactory.createLineBorder(GrisB));
			notas.setBorder(BorderFactory.createLineBorder(Rojo));
		}else {
			for(int i=0; i<actividad.length; i++) {
				if(actividad[i]!=null) {
					genCodA = actividad[i].getCodigo();
				}
			}
			try {
				ControladorNota calificar = new ControladorNota();
				calificar.cargamasiva(notas.getText(),cur,genCodA+1);
			}catch(Exception e) {
				nom.setBorder(BorderFactory.createLineBorder(GrisB));
				desc.setBorder(BorderFactory.createLineBorder(GrisB));
				pnd.setBorder(BorderFactory.createLineBorder(Rojo));
				notas.setBorder(BorderFactory.createLineBorder(GrisB));
				JOptionPane.showMessageDialog(null,"Formato no válido");
			}
			datosActividades.setVisible(false);
			header1.setVisible(false);
			acumulado.setText("");
			rotulo.setText("");
			fraccion.setText("");
			resetTabAct();
			TabAct(cur);
			datosActividades.setVisible(true);
			header1.setVisible(true);
			nom.setBorder(BorderFactory.createLineBorder(GrisB));
			desc.setBorder(BorderFactory.createLineBorder(GrisB));
			pnd.setBorder(BorderFactory.createLineBorder(GrisB));
			notas.setBorder(BorderFactory.createLineBorder(GrisB));
		}
	}
}