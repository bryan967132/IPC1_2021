package AdminProf;
import static AdminProf.Prof.*;
import static AsignacionCurso.AsignacionCurso.*;
import static Interfaz.Colores.*;
import static Profesores.ControladorProfesor.*;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import AsignacionCurso.AsignacionCurso;
import Profesores.*;
import ListasExportadas.ListaProfesores;
public class FunBtnProf {
	public static int code=0;
	//Profesores
	//--CrearProfesor
	public void formCrear() {
		crear.setEnabled(false);
		cargaM.setEnabled(true);
		act.setEnabled(true);
		supr.setEnabled(true);
		exp.setEnabled(true);
		
		datos.setVisible(false);
		
		codigo.setVisible(true);
		nombre.setVisible(true);
		apellido.setVisible(true);
		correo.setVisible(true);
		contraseña.setVisible(true);
		genero.setVisible(true);
		doCrear.setVisible(true);
		backCr.setVisible(true);
		
		ruta.setVisible(false);
		doCargaM.setVisible(false);
		backCM.setVisible(false);
		
		Acodigo.setVisible(false);
		Anombre.setVisible(false);
		Aapellido.setVisible(false);
		Acorreo.setVisible(false);
		Acontraseña.setVisible(false);
		Agenero.setVisible(false);
		doAct.setVisible(false);
		backAct.setVisible(false);
		buscar.setVisible(false);
		
		Dcodigo.setVisible(false);
		Dnombre.setVisible(false);
		Dapellido.setVisible(false);
		Dcorreo.setVisible(false);
		doSupr.setVisible(false);
		backSupr.setVisible(false);
		buscarSupr.setVisible(false);
		
		crear.setBackground(VMedio);
		cargaM.setBackground(VPalido);
		act.setBackground(VPalido);
		supr.setBackground(VPalido);
		exp.setBackground(VPalido);
		
		Titulo.setText("Agregar Nuevo Profesor");
		header.setVisible(false);
	}
	@SuppressWarnings("deprecation")
	public void nuevoProfesor() {
		ControladorProfesor profe = new ControladorProfesor();
		try {
			if(profe.existeProfesor(Integer.parseInt(codigo.getText()))) {
				JOptionPane.showMessageDialog(null,"El código de profesor ya existe");
				codigo.setText("");
			}else if(nombre.getText().equals("") ||
					 apellido.getText().equals("") ||
					 correo.getText().equals("") ||
					 contraseña.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Son Campos Obligatorios","Campos Vacios",JOptionPane.WARNING_MESSAGE);
				codigo.setBorder(BorderFactory.createLineBorder(GrisB));
			}else {
				profe.insertarProfesor(Integer.parseInt(codigo.getText()),
									   nombre.getText(),
									   apellido.getText(),
									   correo.getText(),
									   contraseña.getText(),
									   genero.getSelectedItem().toString());
				resetTabGraph();
				TabGraph();
				volver();
			}
		}catch(Exception e) {
			codigo.setBorder(BorderFactory.createLineBorder(Rojo,15));
			codigo.setText("");
		}
	}
	//--CargaMasiva
	public void formCarga() {
		crear.setEnabled(true);
		cargaM.setEnabled(false);
		act.setEnabled(true);
		supr.setEnabled(true);
		exp.setEnabled(true);
		
		datos.setVisible(false);
		
		codigo.setVisible(false);
		nombre.setVisible(false);
		apellido.setVisible(false);
		correo.setVisible(false);
		contraseña.setVisible(false);
		genero.setVisible(false);
		doCrear.setVisible(false);
		backCr.setVisible(false);
		
		ruta.setVisible(true);
		doCargaM.setVisible(true);
		backCM.setVisible(true);
		
		Acodigo.setVisible(false);
		Anombre.setVisible(false);
		Aapellido.setVisible(false);
		Acorreo.setVisible(false);
		Acontraseña.setVisible(false);
		Agenero.setVisible(false);
		doAct.setVisible(false);
		backAct.setVisible(false);
		buscar.setVisible(false);
		
		Dcodigo.setVisible(false);
		Dnombre.setVisible(false);
		Dapellido.setVisible(false);
		Dcorreo.setVisible(false);
		doSupr.setVisible(false);
		backSupr.setVisible(false);
		buscarSupr.setVisible(false);
		
		crear.setBackground(VPalido);
		cargaM.setBackground(VMedio);
		act.setBackground(VPalido);
		supr.setBackground(VPalido);
		exp.setBackground(VPalido);
		
		Titulo.setText("Carga Masiva De Profesores");
		header.setVisible(false);
	}
	public void cargaMasiva() {
		ControladorProfesor cargar = new ControladorProfesor();
		cargar.cargarmasiva(ruta.getText());
		ruta.setText("");
		resetTabGraph();
		TabGraph();
	}
	//--Actualizar
	public void formAct() {
		crear.setEnabled(true);
		cargaM.setEnabled(true);
		act.setEnabled(false);
		supr.setEnabled(true);
		exp.setEnabled(true);
		
		datos.setVisible(false);
		
		codigo.setVisible(false);
		nombre.setVisible(false);
		apellido.setVisible(false);
		correo.setVisible(false);
		contraseña.setVisible(false);
		genero.setVisible(false);
		doCrear.setVisible(false);
		backCr.setVisible(false);
		
		ruta.setVisible(false);
		doCargaM.setVisible(false);
		backCM.setVisible(false);
		
		Acodigo.setVisible(true);
		Anombre.setVisible(true);
		Aapellido.setVisible(true);
		Acorreo.setVisible(true);
		Acontraseña.setVisible(true);
		Agenero.setVisible(true);
		doAct.setVisible(true);
		backAct.setVisible(true);
		buscar.setVisible(true);
		
		Dcodigo.setVisible(false);
		Dnombre.setVisible(false);
		Dapellido.setVisible(false);
		Dcorreo.setVisible(false);
		doSupr.setVisible(false);
		backSupr.setVisible(false);
		buscarSupr.setVisible(false);
		
		crear.setBackground(VPalido);
		cargaM.setBackground(VPalido);
		act.setBackground(VMedio);
		supr.setBackground(VPalido);
		exp.setBackground(VPalido);
		
		Titulo.setText("Actualizar Datos Profesor");
		header.setVisible(false);
	}
	public void ubicarProf() {
		ControladorProfesor ubicar = new ControladorProfesor();
		try {
			if(ubicar.existeProfesor(Integer.parseInt(Acodigo.getText()))) {
				for(int i=0; i<profesor.length; i++) {
					if(profesor[i]!=null && profesor[i].getCodigo()==Integer.parseInt(Acodigo.getText())) {
						Acodigo.setText(String.valueOf(profesor[i].getCodigo()));
						Anombre.setText(String.valueOf(profesor[i].getNombre()));
						Aapellido.setText(String.valueOf(profesor[i].getApellido()));
						Acorreo.setText(String.valueOf(profesor[i].getCorreo()));
						Acontraseña.setText(String.valueOf(profesor[i].getContraseña()));
						Agenero.setSelectedItem(profesor[i].getGenero());
						Acodigo.setBorder(BorderFactory.createLineBorder(GrisB));
						code=profesor[i].getCodigo();
					}
				}
			}else {
				JOptionPane.showMessageDialog(null,"El profesor al que busca no está registrado");
				Acodigo.setBorder(BorderFactory.createLineBorder(GrisB));
				Acodigo.setText("");
				Anombre.setText("");
				Aapellido.setText("");
				Acorreo.setText("");
				Acontraseña.setText("");
				code=0;
			}
		}catch(Exception e) {
			Acodigo.setBorder(BorderFactory.createLineBorder(Rojo));
			Acodigo.setText("");
			Anombre.setText("");
			Aapellido.setText("");
			Acorreo.setText("");
			Acontraseña.setText("");
			code=0;
		}
	}
	public void actualizarProfesor() {
		try {
			if (code!=0) {
			for(int i=0; i<profesor.length; i++) {
				if(profesor[i]!=null && profesor[i].getCodigo()==code) {
					profesor[i]=new Profesor(Integer.parseInt(Acodigo.getText()),
											  Anombre.getText(),
											  Aapellido.getText(),
											  Acorreo.getText(),
											  Acontraseña.getText(),
											  Agenero.getSelectedItem().toString());
					ordenado();
					ControladorProfesor.Serializar();
					resetTabGraph();
					TabGraph();
					volver();
					code=0;
				}
			}
			}else {
				Acodigo.setBorder(BorderFactory.createLineBorder(Rojo));
			}
		}catch(Exception e) {
		}
	}
	//--Eliminar
	public void formEliminar() {
		crear.setEnabled(true);
		cargaM.setEnabled(true);
		act.setEnabled(true);
		supr.setEnabled(false);
		exp.setEnabled(true);
		
		datos.setVisible(false);
		
		codigo.setVisible(false);
		nombre.setVisible(false);
		apellido.setVisible(false);
		correo.setVisible(false);
		contraseña.setVisible(false);
		genero.setVisible(false);
		doCrear.setVisible(false);
		backCr.setVisible(false);
		
		ruta.setVisible(false);
		doCargaM.setVisible(false);
		backCM.setVisible(false);
		
		Acodigo.setVisible(false);
		Anombre.setVisible(false);
		Aapellido.setVisible(false);
		Acorreo.setVisible(false);
		Acontraseña.setVisible(false);
		Agenero.setVisible(false);
		doAct.setVisible(false);
		backAct.setVisible(false);
		buscar.setVisible(false);
		
		Dcodigo.setVisible(true);
		Dnombre.setVisible(true);
		Dapellido.setVisible(true);
		Dcorreo.setVisible(true);
		doSupr.setVisible(true);
		backSupr.setVisible(true);
		buscarSupr.setVisible(true);
		
		crear.setBackground(VPalido);
		cargaM.setBackground(VPalido);
		act.setBackground(VPalido);
		supr.setBackground(VMedio);
		exp.setBackground(VPalido);
		
		Titulo.setText("Eliminar Profesor");
		header.setVisible(false);
	}
	public void localizarProf() {
		ControladorProfesor delete = new ControladorProfesor();
		try {
			if(delete.existeProfesor(Integer.parseInt(Dcodigo.getText()))) {
				for(int i=0; i<profesor.length; i++) {
					if(profesor[i]!=null && profesor[i].getCodigo()==Integer.parseInt(Dcodigo.getText())) {
						Dcodigo.setText(String.valueOf(profesor[i].getCodigo()));
						Dnombre.setText(String.valueOf(profesor[i].getNombre()));
						Dapellido.setText(String.valueOf(profesor[i].getApellido()));
						Dcorreo.setText(String.valueOf(profesor[i].getCorreo()));
						Dcodigo.setBorder(BorderFactory.createLineBorder(GrisB));
						code=profesor[i].getCodigo();
					}
				}
			}else {
				JOptionPane.showMessageDialog(null,"El profesor al que busca no está registrado");
				Dcodigo.setBorder(BorderFactory.createLineBorder(GrisB));
				Dcodigo.setText("");
				Dnombre.setText("");
				Dapellido.setText("");
				Dcorreo.setText("");
				code=0;
			}
		}catch(Exception e) {
			Dcodigo.setBorder(BorderFactory.createLineBorder(Rojo));
			Dcodigo.setText("");
			Dnombre.setText("");
			Dapellido.setText("");
			Dcorreo.setText("");
			code=0;
		}
	}
	public void eliminarProfesor() {
		try {
			if(code!=0) {
			for(int i=0; i<profesor.length; i++) {
				if(profesor[i]!=null && profesor[i].getCodigo()==code) {
					profesor[i]=null;
					reordenado();
					ordenado();
					ControladorProfesor.Serializar();
					for(int x=0; x<50; x++) {
						if(listado[x][1]==code) {
							listado[x][1] = 0;
						}
					}
					AsignacionCurso.Serializar();
					resetTabGraph();
					TabGraph();
					volver();
					code=0;
				}
			}
			}else {
				Dcodigo.setBorder(BorderFactory.createLineBorder(Rojo));
			}
		}catch(Exception e) {
		}
	}
	//--ExportarPDF
	public void exportarLista() {
		ListaProfesores exportar = new ListaProfesores();
		exportar.Exportar();
		volver();
	}
	//ActualizaTablaGrafico
	public void TabGraph() {
		CompProf TabGraph = new CompProf();
		TabGraph.tabla();
		TabGraph.grafica();
	}
	public void resetTabGraph() {
		datos.removeAll();
		grafica.removeAll();
	}
	//VolverVentanaAdmin
	public void volver() {
		ruta.setVisible(false);
		
		codigo.setVisible(false);
		nombre.setVisible(false);
		apellido.setVisible(false);
		correo.setVisible(false);
		contraseña.setVisible(false);
		genero.setVisible(false);
		doCrear.setVisible(false);
		backCr.setVisible(false);
		
		doCargaM.setVisible(false);
		backCM.setVisible(false);
		datos.setVisible(true);
		cargaM.setEnabled(true);
		
		Acodigo.setVisible(false);
		Anombre.setVisible(false);
		Aapellido.setVisible(false);
		Acorreo.setVisible(false);
		Acontraseña.setVisible(false);
		Agenero.setVisible(false);
		doAct.setVisible(false);
		backAct.setVisible(false);
		buscar.setVisible(false);
		
		Dcodigo.setVisible(false);
		Dnombre.setVisible(false);
		Dapellido.setVisible(false);
		Dcorreo.setVisible(false);
		doSupr.setVisible(false);
		backSupr.setVisible(false);
		buscarSupr.setVisible(false);
		
		crear.setEnabled(true);
		cargaM.setEnabled(true);
		act.setEnabled(true);
		supr.setEnabled(true);
		exp.setEnabled(true);
		
		crear.setBackground(VMedio);
		cargaM.setBackground(VMedio);
		act.setBackground(VMedio);
		supr.setBackground(VMedio);
		exp.setBackground(VMedio);
		
		cambiar();
		
		Titulo.setText("Listado Oficial");
		header.setVisible(true);
	}
	//CambioFuncion
	public void cambiar() {
		code=0;
		ruta.setText("");
		
		codigo.setText("");
		nombre.setText("");
		apellido.setText("");
		correo.setText("");
		contraseña.setText("");
		
		Acodigo.setText("");
		Anombre.setText("");
		Aapellido.setText("");
		Acorreo.setText("");
		Acontraseña.setText("");
		
		Dcodigo.setText("");
		Dnombre.setText("");
		Dapellido.setText("");
		Dcorreo.setText("");
		
		codigo.setBorder(BorderFactory.createLineBorder(GrisB));
		Acodigo.setBorder(BorderFactory.createLineBorder(GrisB));
		Dcodigo.setBorder(BorderFactory.createLineBorder(GrisB));
	}
}