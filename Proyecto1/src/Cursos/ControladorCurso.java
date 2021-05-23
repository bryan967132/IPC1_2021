package Cursos;
import static AsignacionCurso.AsignacionCurso.*;

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import AsignacionCurso.AsignacionCurso;
public class ControladorCurso {
	public static Curso[] curso = new Curso[50];
	public static void Serializar() {
		try {
			FileOutputStream archivo = new FileOutputStream("Serializados/Cursos");
			ObjectOutputStream convertir = new ObjectOutputStream(archivo);
			convertir.writeObject(curso);
			convertir.close();
		}catch(Exception e) {
		}
	}
	public static void Deserializar() {
		try {
			FileInputStream lector = new FileInputStream("Serializados/Cursos");
			ObjectInputStream regresar = new ObjectInputStream(lector);
			Curso[] cur = (Curso[])regresar.readObject();
			regresar.close();
			for(int i=0; i<curso.length; i++) {
				curso[i]=cur[i];
			}
		}catch(Exception e) {
		}
	}
	public static void ordenado() {
		try {
			for(int i=1; i<curso.length; i++) {
				for(int j=i-1; j>=0; j--) {
					if(curso[i].getCodigo()<curso[j].getCodigo()) {
						Curso aux = curso[i];
						curso[i] = curso[j];
						curso[j] = aux;
						i--;
					}
				}
			}
		}catch(Exception e) {		
		}
	}
	public static void reordenado() {
		for(int i=0; i<curso.length-1; i++) {
		    for (int j=0; j<curso.length-i-1; j++) {
		        if(curso[j]==null){
		        	Curso tmp = curso[j+1];
		        	curso[j+1] = curso[j];
		        	curso[j] = tmp;
		        }
		    }
		}
	}
	public static void reestructurado() {
		for(int i=0; i<50; i++) {
			listado[i][0]=0;
			listado[i][1]=0;
		}
	}
	public static void matriz() {
		for(int i=0; i<49; i++) {
			if(listado[i][0]==0) {
				for(int j=0; j<52; j++) {
				int[] temp = new int[52];
				temp[j] = listado[i+1][j];
				listado[i+1][j] = listado[i][j];
				listado[i][j] = temp[j];
				}
			}
		}
	}
	public static void eliminado(int codigo) {
		for(int i=0; i<50; i++) {
			if(listado[i][0]==codigo) {
				for(int j=0; j<52; j++) {
					listado[i][j]=0;
				}
			}
		}
		matriz();
	}
	public static void llenadoSalon() {
		reestructurado();
		for(int i=0; i<curso.length; i++) {
			if(curso[i]!=null) {
				if(listado[i][0]==0 && listado[i][1]==0) {
					listado[i][0]=curso[i].getCodigo();
					listado[i][1]=curso[i].getProfesor();
				}
			}
		}
	}
	public void cargarmasiva(String ruta) {
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
				if(!this.insertarCurso(Integer.parseInt(jobj.get("codigo").toString()),jobj.get("nombre").toString(),Integer.parseInt(jobj.get("creditos").toString()),Integer.parseInt(jobj.get("profesor").toString())));				
			}
			sc.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Ha ocurrido un error cargando el archivo");
		}
	}
	public boolean existeCurso(int id) {
		for(Curso u:curso) {
			if(u!=null && u.getCodigo()==id)
				return true;
		}
		return false;
	}
	public boolean insertarCurso(int codigo,String nombre,int creditos,int profe) {
		if(existeCurso(codigo))return false;
		for(int i =0; i<curso.length;i++) {
			if(curso[i]==null) {
				int cantidad=0;
				for(int curso=0; curso<50; curso++) {
					for(int j=2; j<52; j++) {
						if(listado[i][0]==codigo && listado[i][j]!=0) {
							cantidad++;
						}
					}
				}
				curso[i]= new Curso(codigo,nombre,creditos,cantidad,profe);
				ordenado();
				llenadoSalon();
				Serializar();
				AsignacionCurso.Serializar();
				return true;
			}
		}
		return false;
	}
	public static void imprimir() {
		for(int i =0; i<curso.length;i++) {
			if(curso[i]!=null) {
				System.out.println(curso[i].getCodigo()+" "+curso[i].getAlumnos());
			}
		}
	}
}