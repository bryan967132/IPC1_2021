package Alumnos;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import DTT.InicioAlu;
public class ControladorAlumno {
	public static Alumno[] alumno = new Alumno[300];
	public static void Serializar() {
		try {
			FileOutputStream archivo = new FileOutputStream("Serializados/Alumnos");
			ObjectOutputStream convertir = new ObjectOutputStream(archivo);
			convertir.writeObject(alumno);
			convertir.close();
		}catch(Exception e) {
		}
	}
	public static void Deserializar() {
		try {
			FileInputStream lector = new FileInputStream("Serializados/Alumnos");
			ObjectInputStream regresar = new ObjectInputStream(lector);
			Alumno[] alum = (Alumno[])regresar.readObject();
			regresar.close();
			for(int i=0; i<alumno.length; i++) {
				alumno[i]=alum[i];
			}
		}catch(Exception e) {
		}
	}
	public static void ordenado() {
		try {
			for(int i=1; i<alumno.length; i++) {
				for(int j=i-1; j>=0; j--) {
					if(alumno[i].getCodigo()<alumno[j].getCodigo()) {
						Alumno aux = alumno[i];
						alumno[i] = alumno[j];
						alumno[j] = aux;
						i--;
					}
				}
			}
		}catch(Exception e) {
		}
	}
	public void cargarmasiva(String ruta) {
		try {
			File f = new File(ruta);
			Scanner sc = new Scanner(f);
			String data="";
			String genero="";
			while(sc.hasNextLine()) {
				data+=sc.nextLine()+"\n";
			}
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(data);
			JSONArray array = (JSONArray)obj;
			JSONObject jobj;
			for(int i =0;i<array.size();i++) {
				jobj=(JSONObject)array.get(i);
				if(jobj.get("genero").toString().equals("m") || jobj.get("genero").toString().equals("M")) {
					genero="M";
				}else {
					genero="F";
				}
				if(!this.insertarAlumno(Integer.parseInt(jobj.get("codigo").toString()),jobj.get("nombre").toString(),jobj.get("apellido").toString(),jobj.get("correo").toString(),"1234",genero));				
			}
			sc.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Ha ocurrido un error cargando el archivo");
		}
	}
	public boolean existeAlumno(int usuario) {
		for(Alumno u:alumno) {
			if(u!=null && u.getCodigo()==usuario)
				return true;
		}
		return false;
	}
	public boolean insertarAlumno(int codigo,String nombre,String apellido,String correo,String contraseña,String genero) {
		if(existeAlumno(codigo))return false;
		for(int i =0; i<alumno.length;i++) {
			if(alumno[i]==null) {
				alumno[i]= new Alumno(codigo,nombre,apellido,correo,contraseña,genero);
				ordenado();
				Serializar();
				return true;
			}
		}
		return false;
	}
	public void obtenerAlumno(int codigo) {
		for(int i=0; i<alumno.length; i++) {
			if(alumno[i]!=null && alumno[i].getCodigo()==codigo) {
				new InicioAlu(codigo,alumno[i].getNombre(),alumno[i].getApellido(),alumno[i].getGenero());
			}
		}
	}
	public boolean iniciarsesion(int codigo, String password) {
		for(Alumno u:alumno) {
			if(u!=null && u.getCodigo()==codigo && u.getContraseña().equals(password)) {
				return true;
			}
		}
		return false;
	}
}