package Entrenadores;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class ControladorEntrenador {
	public static Entrenador[] entrenadores = new Entrenador[25];
	public static void Serializar() {
		try {
			FileOutputStream archivo = new FileOutputStream("Serializados/entrenador");
			ObjectOutputStream convertir = new ObjectOutputStream(archivo);
			convertir.writeObject(entrenadores);
			convertir.close();
		}catch(Exception e) {
		}
	}
	public static void Deserializar() {
		try {
			FileInputStream lector = new FileInputStream("Serializados/entrenador");
			ObjectInputStream regresar = new ObjectInputStream(lector);
			Entrenador[] entrenador = (Entrenador[])regresar.readObject();
			regresar.close();
			for(int i=0; i<entrenadores.length; i++) {
				entrenadores[i]=entrenador[i];
			}
		}catch(Exception e) {
		}
	}
	public static void limpiar() {
		for(int i=0; i<entrenadores.length; i++) {
			entrenadores[i]=null;
		}
	}
	public void cargamasiva(String ruta) {
		try {
			File archivo = new File(ruta);
			Scanner reader = new Scanner(archivo);
			limpiar();
			String[] actual;
			Entrenador entrenador;
			while(reader.hasNextLine()) {
				actual = reader.nextLine().split(",");
				entrenador = new Entrenador(Integer.parseInt(actual[0]),actual[1]);
				if(!this.agregarEntrenador(entrenador)) {
					System.out.println("Se ha llenado");
				}
			}
			Serializar();
			imprimir();
		}catch(Exception e) {
			cargaauxiliar(ruta);
		}
	}
	public void cargaauxiliar(String ruta) {
		try {
			File archivo = new File(ruta);
			Scanner reader = new Scanner(archivo);
			limpiar();
			String[] actual;
			Entrenador entrenador;
			reader.nextLine();
			while(reader.hasNextLine()) {
				actual = reader.nextLine().split(",");
				entrenador = new Entrenador(Integer.parseInt(actual[0]),actual[1]);
				if(!this.agregarEntrenador(entrenador)) {
					System.out.println("Se ha llenado");
				}
			}
			Serializar();
			imprimir();
		}catch(Exception e) {
			System.out.println("Ruta inválida");
		}
	}
	public boolean agregarEntrenador(Entrenador entrenadores) {
		for(int i=0; i<this.entrenadores.length; i++) {
			if(this.entrenadores[i]==null) {
				this.entrenadores[i]=entrenadores;
				return true;
			}
		}
		return false;
	}
	public void imprimir() {
		for(int i=0; i<this.entrenadores.length;i++) {
			if(this.entrenadores[i]!=null) {
				System.out.printf("%-9s%-20s\n",	
						"ID: "+this.entrenadores[i].getId(),
						"Nombre: "+this.entrenadores[i].getNombre());
			}
		}
		System.out.println();
	}
}