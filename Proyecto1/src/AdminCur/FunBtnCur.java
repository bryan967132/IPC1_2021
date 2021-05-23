package AdminCur;
import static AdminCur.Cur.*;
import static AsignacionCurso.AsignacionCurso.*;
import static Interfaz.Colores.*;
import static Cursos.ControladorCurso.*;
import static Profesores.ControladorProfesor.*;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

import AsignacionCurso.AsignacionCurso;
import Cursos.*;
import ListasExportadas.ListaCursos;
public class FunBtnCur {
	public static int code=0;
	//Cursos
	//--CrearCurso
	public void formCrear() {
		crear.setEnabled(false);
		cargaM.setEnabled(true);
		act.setEnabled(true);
		supr.setEnabled(true);
		exp.setEnabled(true);
		
		datos.setVisible(false);
		
		codigo.setVisible(true);
		nombre.setVisible(true);
		creditos.setVisible(true);
		profesorOpc.setVisible(true);
		doCrear.setVisible(true);
		backCr.setVisible(true);
		
		ruta.setVisible(false);
		doCargaM.setVisible(false);
		backCM.setVisible(false);
		
		Acodigo.setVisible(false);
		Anombre.setVisible(false);
		Acreditos.setVisible(false);
		Aprofesor.setVisible(false);
		doAct.setVisible(false);
		backAct.setVisible(false);
		buscar.setVisible(false);
		
		Dcodigo.setVisible(false);
		Dnombre.setVisible(false);
		Dcreditos.setVisible(false);
		DProfesor.setVisible(false);
		doSupr.setVisible(false);
		backSupr.setVisible(false);
		buscarSupr.setVisible(false);
		
		crear.setBackground(VMedio);
		cargaM.setBackground(VPalido);
		act.setBackground(VPalido);
		supr.setBackground(VPalido);
		exp.setBackground(VPalido);
		
		Titulo.setText("Agregar Nuevo Curso");
		header.setVisible(false);
	}
	public void nuevoCurso() {
		ControladorCurso cur = new ControladorCurso();
		try {
			if(cur.existeCurso(Integer.parseInt(codigo.getText()))) {
				JOptionPane.showMessageDialog(null,"El código de profesor ya existe");
				codigo.setText("");
			}else if(nombre.getText().equals("") ||
					 creditos.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Son Campos Obligatorios","Campos Vacios",JOptionPane.WARNING_MESSAGE);
				codigo.setBorder(BorderFactory.createLineBorder(GrisB));
			}else {
				int pro=0;
				for(int i=0; i<profesor.length; i++) {
					if(profesor[i]!=null && profesorOpc.getSelectedItem().equals(profesor[i].getNombre()+" "+profesor[i].getApellido())) {
						pro=profesor[i].getCodigo();
					}
				}
				cur.insertarCurso(Integer.parseInt(codigo.getText()),
									   nombre.getText(),
									   Integer.parseInt(creditos.getText()),
									   pro);
				resetTabGraph();
				TabGraph();
				volver();
			}
		}catch(Exception e) {
			codigo.setBorder(BorderFactory.createLineBorder(Rojo));
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
		creditos.setVisible(false);
		profesorOpc.setVisible(false);
		doCrear.setVisible(false);
		backCr.setVisible(false);
		
		ruta.setVisible(true);
		doCargaM.setVisible(true);
		backCM.setVisible(true);
		
		Acodigo.setVisible(false);
		Anombre.setVisible(false);
		Acreditos.setVisible(false);
		Aprofesor.setVisible(false);
		doAct.setVisible(false);
		backAct.setVisible(false);
		buscar.setVisible(false);
		
		Dcodigo.setVisible(false);
		Dnombre.setVisible(false);
		Dcreditos.setVisible(false);
		DProfesor.setVisible(false);
		doSupr.setVisible(false);
		backSupr.setVisible(false);
		buscarSupr.setVisible(false);
		
		crear.setBackground(VPalido);
		cargaM.setBackground(VMedio);
		act.setBackground(VPalido);
		supr.setBackground(VPalido);
		exp.setBackground(VPalido);
		
		Titulo.setText("Carga Masiva De Cursos");
		header.setVisible(false);
	}
	public void cargaMasiva() {
		resetTabGraph();
		ControladorCurso cargar = new ControladorCurso();
		cargar.cargarmasiva(ruta.getText());
		ruta.setText("");
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
		creditos.setVisible(false);
		profesorOpc.setVisible(false);
		doCrear.setVisible(false);
		backCr.setVisible(false);
		
		ruta.setVisible(false);
		doCargaM.setVisible(false);
		backCM.setVisible(false);
		
		Acodigo.setVisible(true);
		Anombre.setVisible(true);
		Acreditos.setVisible(true);
		Aprofesor.setVisible(true);
		doAct.setVisible(true);
		backAct.setVisible(true);
		buscar.setVisible(true);
		
		Dcodigo.setVisible(false);
		Dnombre.setVisible(false);
		Dcreditos.setVisible(false);
		DProfesor.setVisible(false);
		doSupr.setVisible(false);
		backSupr.setVisible(false);
		buscarSupr.setVisible(false);
		
		crear.setBackground(VPalido);
		cargaM.setBackground(VPalido);
		act.setBackground(VMedio);
		supr.setBackground(VPalido);
		exp.setBackground(VPalido);
		
		Titulo.setText("Actualizar Datos Del Curso");
		header.setVisible(false);
	}
	public void ubicarCurso() {
		ControladorCurso ubicar = new ControladorCurso();
		try {
			if(ubicar.existeCurso(Integer.parseInt(Acodigo.getText()))) {
				for(int i=0; i<curso.length; i++) {
					if(curso[i]!=null && curso[i].getCodigo()==Integer.parseInt(Acodigo.getText())) {
						Acodigo.setText(String.valueOf(curso[i].getCodigo()));
						Anombre.setText(String.valueOf(curso[i].getNombre()));
						Acreditos.setText(String.valueOf(curso[i].getCreditos()));
						int cod=0;
						for(int j=0; j<50; j++) {
							if(listado[j][0]==Integer.parseInt(Acodigo.getText())) {
								cod=listado[j][1];
							}
						}
						String linea = "";
						for(int j=1; j<profe.length; j++) {
							if(profesor[j-1].getCodigo()==cod) {
								Aprofesor.setSelectedItem(profe[j]);
							}else if(cod==0){
								Aprofesor.setSelectedItem("Asigne un profesor");
							}
						}
						Aprofesor.setSelectedItem(linea);
						Acodigo.setBorder(BorderFactory.createLineBorder(GrisB));
						code=curso[i].getCodigo();
					}
				}
			}else {
				JOptionPane.showMessageDialog(null,"El curso que busca no está registrado");
				Acodigo.setBorder(BorderFactory.createLineBorder(GrisB));
				Acodigo.setText("");
				Anombre.setText("");
				Acreditos.setText("");
				Aprofesor.setSelectedItem("Asigne un profesor");
				code=0;
			}
		}catch(Exception e) {
			Acodigo.setBorder(BorderFactory.createLineBorder(Rojo));
			Acodigo.setText("");
			Anombre.setText("");
			Acreditos.setText("");
			Aprofesor.setSelectedItem("Asigne un profesor");
			code=0;
		}
	}
	public void actualizarcurso() {
		try {
			if (code!=0) {
				for(int i=0; i<curso.length; i++) {
					if(curso[i]!=null && curso[i].getCodigo()==code) {
						int cantidad=0;
						int pro=0;
						for(int f=0; f<50; f++) {
							for(int j=2; j<52; j++) {
								if(listado[f][0]==curso[i].getCodigo() && listado[f][j]!=0) {
									cantidad++;
								}
							}
						}
						for(int r=0; r<profesor.length; r++) {
							if(profesor[r]!=null && Aprofesor.getSelectedItem().equals(profesor[r].getNombre()+" "+profesor[r].getApellido())) {
								pro=profesor[r].getCodigo();
							}
						}
						curso[i]=new Curso(Integer.parseInt(Acodigo.getText()),
												  Anombre.getText(),
												  Integer.parseInt(Acreditos.getText()),
												  cantidad,
												  pro);
						ControladorCurso.ordenado();
						ControladorCurso.llenadoSalon();
						ControladorCurso.Serializar();
						AsignacionCurso.Serializar();
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
		creditos.setVisible(false);
		profesorOpc.setVisible(false);
		doCrear.setVisible(false);
		backCr.setVisible(false);
		
		ruta.setVisible(false);
		doCargaM.setVisible(false);
		backCM.setVisible(false);
		
		Acodigo.setVisible(false);
		Anombre.setVisible(false);
		Acreditos.setVisible(false);
		Aprofesor.setVisible(false);
		doAct.setVisible(false);
		backAct.setVisible(false);
		buscar.setVisible(false);
		
		Dcodigo.setVisible(true);
		Dnombre.setVisible(true);
		Dcreditos.setVisible(true);
		DProfesor.setVisible(true);
		doSupr.setVisible(true);
		backSupr.setVisible(true);
		buscarSupr.setVisible(true);
		
		crear.setBackground(VPalido);
		cargaM.setBackground(VPalido);
		act.setBackground(VPalido);
		supr.setBackground(VMedio);
		exp.setBackground(VPalido);
		
		Titulo.setText("Eliminar Curso");
		header.setVisible(false);
	}
	public void localizarCurso() {
		ControladorCurso delete = new ControladorCurso();
		try {
			if(delete.existeCurso(Integer.parseInt(Dcodigo.getText()))) {
				for(int i=0; i<curso.length; i++) {
					if(curso[i]!=null && curso[i].getCodigo()==Integer.parseInt(Dcodigo.getText())) {
						Dcodigo.setText(String.valueOf(curso[i].getCodigo()));
						Dnombre.setText(String.valueOf(curso[i].getNombre()));
						Dcreditos.setText(String.valueOf(curso[i].getCreditos()));
						int cod=0;
						for(int j=0; j<50; j++) {
							if(listado[j][0]==Integer.parseInt(Dcodigo.getText())) {
								cod=listado[j][1];
							}
						}
						for(int j=1; j<profe.length; j++) {
							if(profesor[j-1].getCodigo()==cod) {
								DProfesor.setText(profe[j]);
							}else if(cod==0){
								DProfesor.setText("Asigne un profesor");
							}
						}
						Dcodigo.setBorder(BorderFactory.createLineBorder(GrisB));
						code=curso[i].getCodigo();
					}
				}
			}else {
				JOptionPane.showMessageDialog(null,"El curso que busca no está registrado");
				Dcodigo.setBorder(BorderFactory.createLineBorder(GrisB));
				Dcodigo.setText("");
				Dnombre.setText("");
				Dcreditos.setText("");
				DProfesor.setText("");
				code=0;
			}
		}catch(Exception e) {
			Dcodigo.setBorder(BorderFactory.createLineBorder(Rojo));
			Dcodigo.setText("");
			Dnombre.setText("");
			Dcreditos.setText("");
			code=0;
		}
	}
	public void eliminarProfesor() {
		try {
			if(code!=0) {
				for(int i=0; i<curso.length; i++) {
					if(curso[i]!=null && curso[i].getCodigo()==code) {
						curso[i]=null;
						ControladorCurso.reordenado();
						ControladorCurso.ordenado();
						ControladorCurso.Serializar();
						
						ControladorCurso.eliminado(code);
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
		ListaCursos exportar = new ListaCursos();
		exportar.Exportar();
		volver();
	}
	//ActualizaTablaGrafico
	public void TabGraph() {
		CompCur TabGraph = new CompCur();
		TabGraph.tabla();
		TabGraph.grafica();
		//cant.header();
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
		creditos.setVisible(false);
		profesorOpc.setVisible(false);
		doCrear.setVisible(false);
		backCr.setVisible(false);
		
		doCargaM.setVisible(false);
		backCM.setVisible(false);
		datos.setVisible(true);
		cargaM.setEnabled(true);
		
		Acodigo.setVisible(false);
		Anombre.setVisible(false);
		Acreditos.setVisible(false);
		Aprofesor.setVisible(false);
		doAct.setVisible(false);
		backAct.setVisible(false);
		buscar.setVisible(false);
		
		Dcodigo.setVisible(false);
		Dnombre.setVisible(false);
		Dcreditos.setVisible(false);
		DProfesor.setVisible(false);
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
		creditos.setText("");
		
		Acodigo.setText("");
		Anombre.setText("");
		Acreditos.setText("");
		Aprofesor.setSelectedItem("Asigne un profesor");
		profesorOpc.setSelectedItem("Asigne un profesor");
		
		Dcodigo.setText("");
		Dnombre.setText("");
		Dcreditos.setText("");
		DProfesor.setText("");
		
		codigo.setBorder(BorderFactory.createLineBorder(GrisB));
		Acodigo.setBorder(BorderFactory.createLineBorder(GrisB));
		Dcodigo.setBorder(BorderFactory.createLineBorder(GrisB));
	}
}