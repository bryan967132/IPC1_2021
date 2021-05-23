package AdminAlu;
import static AdminAlu.Alu.*;
import static Interfaz.Colores.*;
import Alumnos.*;
import ListasExportadas.ListaAlumnos;
public class FunBtnAlu {
	public static int code=0;
	//Alumnos
	//--CargaMasiva
	public void formCarga() {
		cargaM.setEnabled(false);
		exp.setEnabled(true);
		
		datos.setVisible(false);
		
		ruta.setVisible(true);
		doCargaM.setVisible(true);
		backCM.setVisible(true);

		cargaM.setBackground(VMedio);
		exp.setBackground(VPalido);
		
		Titulo.setText("Carga Masiva De Alumnos");
		header.setVisible(false);
	}
	public void cargaMasiva() {
		ControladorAlumno cargar = new ControladorAlumno();
		cargar.cargarmasiva(ruta.getText());
		ruta.setText("");
		resetTabGraph();
		TabGraph();
	}
	//--ExportarPDF
	public void exportarLista() {
		ListaAlumnos exportar = new ListaAlumnos();
		exportar.Exportar();
		volver();
	}
	//ActualizaTablaGrafico
	public void TabGraph() {
		CompAlu TabGraph = new CompAlu();
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
		
		doCargaM.setVisible(false);
		backCM.setVisible(false);
		datos.setVisible(true);
		cargaM.setEnabled(true);

		cargaM.setEnabled(true);
		exp.setEnabled(true);

		cargaM.setBackground(VMedio);
		exp.setBackground(VMedio);
		
		cambiar();
		
		Titulo.setText("Listado Oficial");
		header.setVisible(true);
	}
	//CambioFuncion
	public void cambiar() {
		ruta.setText("");
	}
}