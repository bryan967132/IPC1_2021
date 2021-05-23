package Profesores;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import DTT.InicioProf;
public class ControladorProfesor {
	public static Profesor[] profesor = new Profesor[50];
	public static void Serializar() {
		try {
			FileOutputStream archivo = new FileOutputStream("Serializados/Profesores");
			ObjectOutputStream convertir = new ObjectOutputStream(archivo);
			convertir.writeObject(profesor);
			convertir.close();
		}catch(Exception e) {
		}
	}
	public static void Deserializar() {
		try {
			FileInputStream lector = new FileInputStream("Serializados/Profesores");
			ObjectInputStream regresar = new ObjectInputStream(lector);
			Profesor[] profe = (Profesor[])regresar.readObject();
			regresar.close();
			for(int i=0; i<profesor.length; i++) {
				profesor[i]=profe[i];
			}
		}catch(Exception e) {
		}
	}
	public static void ordenado() {
		try {
			for(int i=1; i<profesor.length; i++) {
				for(int j=i-1; j>=0; j--) {
					if(profesor[i].getCodigo()<profesor[j].getCodigo()) {
						Profesor aux = profesor[i];
						profesor[i] = profesor[j];
						profesor[j] = aux;
						i--;
					}
				}
			}
		}catch(Exception e) {		
		}
	}
	public static void reordenado() {
		for (int i=0; i<profesor.length-1; i++) {
		    for (int j=0; j<profesor.length-i-1; j++) {
		        if(profesor[j]==null){
		            Profesor tmp = profesor[j+1];
		            profesor[j+1] = profesor[j];
		            profesor[j] = tmp;
		        }
		    }
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
				if(!this.insertarProfesor(Integer.parseInt(jobj.get("codigo").toString()),jobj.get("nombre").toString(),jobj.get("apellido").toString(),jobj.get("correo").toString(),"1234",genero));				
			}
			sc.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Ha ocurrido un error cargando el archivo");
		}
	}
	public boolean existeProfesor(int usuario) {
		for(Profesor u:profesor) {
			if(u!=null && u.getCodigo()==usuario)
				return true;
		}
		return false;
	}
	public boolean insertarProfesor(int codigo,String nombre,String apellido,String correo,String contraseña,String genero) {
		if(existeProfesor(codigo))return false;
		for(int i =0; i<profesor.length;i++) {
			if(profesor[i]==null) {
				profesor[i]= new Profesor(codigo,nombre,apellido,correo,contraseña,genero);
				ordenado();
				Serializar();
				return true;
			}
		}
		return false;
	}
	public void obtenerProfesor(int codigo) {
		for(int i=0; i<profesor.length; i++) {
			if(profesor[i]!=null && profesor[i].getCodigo()==codigo) {
				new InicioProf(codigo,profesor[i].getNombre(),profesor[i].getApellido(),profesor[i].getGenero());
			}
		}
	}
	public boolean iniciarsesion(int codigo, String password) {
		for(Profesor u:profesor) {
			if(u!=null && u.getCodigo()==codigo && u.getContraseña().equals(password)) {
				return true;
			}
		}
		return false;
	}
}