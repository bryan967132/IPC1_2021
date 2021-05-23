package AsignacionCurso;
import static AsignacionCurso.AsignacionCurso.*;
import static Cursos.ControladorCurso.*;
import static AdminCur.CompCur.*;
import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import Cursos.ControladorCurso;
import Cursos.Curso;
public class Controlador {
	public void cargarmasiva(String ruta,int cur) {
		try {
			File f = new File(ruta);
			Scanner sc = new Scanner(f);
			String data="";
			while(sc.hasNextLine()) {
				data+=sc.nextLine()+"\n";
			}
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(data);
			JSONArray array = (JSONArray)obj;
			JSONObject jobj;
			for(int i =0;i<array.size();i++) {
				jobj=(JSONObject)array.get(i);
				if(!this.insertarAlumno(cur,Integer.parseInt(jobj.get("codigo").toString())));
			}
			sc.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Ha ocurrido un error cargando el archivo");
		}
	}
	public boolean existeAlumno(int cur,int alu) {
		for(int i=0; i<50; i++){
			for(int j=2; j<52; j++){
				if(listado[i][0]==cur && listado[i][j]!=0  && listado[i][j]==alu){
					return true;
				}
			}
		}
		return false;
	}
	public boolean insertarAlumno(int cur,int alu) {
		if(existeAlumno(cur,alu))return false;
		for(int i=0; i<50;i++) {
			for(int j=2; j<52; j++){
				if(listado[i][0]==cur && listado[i][j]==0) {
					listado[i][j]=alu;
					AsignacionCurso.Serializar();
					return true;
				}
			}
		}
		return false;
	}
	public void actualizarB(int cur) {
		for(int i=0; i<curso.length; i++) {
			if(curso[i]!=null && curso[i].getCodigo()==cur) {
				int cantidad=0;
				for(int f=0; f<50; f++) {
					for(int j=2; j<52; j++) {
						if(listado[f][0]==curso[i].getCodigo() && listado[f][j]!=0) {
							cantidad++;
						}
					}
				}
				curso[i]=new Curso(curso[i].getCodigo(),
								   curso[i].getNombre(),
								   curso[i].getCreditos(),
								   cantidad,
								   curso[i].getProfesor());
				ControladorCurso.Serializar();
			}
		}
	}
	public void rellenado(int cur) {
		for(int i=0; i<50; i++) {
			if(listado[i][0]==cur) {
				for(int j=2; j<51; j++) {
					for(int y=2; y<51-j; y++) {
						if(listado[i][j]==0) {
							int temp = listado[i][j+1];
							listado[i][j+1] = listado[i][j];
							listado[i][j] = temp;
						}
					}
				}
			}
		}
	}
	public void ordenamiento(int cur){
		for(int i=0; i<50; i++) {
			if(listado[i][0]==cur) {
				for(int j=3; j<52; j++) {
					for(int y=j-1; y>=2; y--) {
						if(listado[i][j]!=0 && listado[i][j]<listado[i][y]) {
							int temp = listado[i][j];
							listado[i][j] = listado[i][y];
							listado[i][y] = temp;
							j--;
						}
					}
				}
			}
		}
	}
	public static void ver() {
		for(int i=0; i<50; i++) {
			//for(int j=0; j<52; j++) {
				System.out.printf("%-8s",temp[i].getAlumnos());
			//}
			//System.out.println();
		}
	}
}