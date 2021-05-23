package AsignacionPokeballs;
import static AsignacionPokeballs.ControladorAsigPbl.asigPokeballs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class ControladorAsigPbl {
	public static AsignacionPokeball[] asigPokeballs = new AsignacionPokeball   [150];
	public static void Serializar() {
		try {
			FileOutputStream archivo = new FileOutputStream("Serializados/aisgnarPokeballs");
			ObjectOutputStream convertir = new ObjectOutputStream(archivo);
			convertir.writeObject(asigPokeballs);
			convertir.close();
		}catch(Exception e) {
		}
	}
	public static void Deserializar() {
		try {
			FileInputStream lector = new FileInputStream("Serializados/aisgnarPokeballs");
			ObjectInputStream regresar = new ObjectInputStream(lector);
			AsignacionPokeball[] asignacionpokeball = (AsignacionPokeball[])regresar.readObject();
			regresar.close();
			for(int i=0; i<asigPokeballs.length; i++) {
				asigPokeballs[i]=asignacionpokeball[i];
			}
		}catch(Exception e) {
		}
	}
	public static void limpiar() {
		for(int i=0; i<asigPokeballs.length; i++) {
			asigPokeballs[i]=null;
		}
	}
	public void cargamasiva(String ruta) {
		try {
			File archivo = new File(ruta);
			Scanner reader = new Scanner(archivo);
			limpiar();
			String[] actual;
			AsignacionPokeball asignacionpokeball;
			while(reader.hasNextLine()) {
				actual = reader.nextLine().split(",");
				asignacionpokeball = new AsignacionPokeball(Integer.parseInt(actual[0]),Integer.parseInt(actual[1]));
				if(!this.agregarAsignacionPokeball(asignacionpokeball)) {
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
			AsignacionPokeball asignacionpokeball;
			reader.nextLine();
			while(reader.hasNextLine()) {
				actual = reader.nextLine().split(",");
				asignacionpokeball = new AsignacionPokeball(Integer.parseInt(actual[0]),Integer.parseInt(actual[1]));
				if(!this.agregarAsignacionPokeball(asignacionpokeball)) {
					System.out.println("Se ha llenado");
				}
			}
			Serializar();
			imprimir();
		}catch(Exception e) {
			System.out.println("Ruta inválida");
		}
	}
	public boolean agregarAsignacionPokeball(AsignacionPokeball asigPokeballs) {
		for(int i=0; i<this.asigPokeballs.length; i++) {
			if(this.asigPokeballs[i]==null) {
				this.asigPokeballs[i]=asigPokeballs;
				return true;
			}
		}
		return false;
	}
	public void imprimir() {
		for(int i=0; i<this.asigPokeballs.length;i++) {
			if(this.asigPokeballs[i]!=null) {
				Asignar asignar = new Asignar();
				asignar.asignar(asigPokeballs[i].entrenador,
								asigPokeballs[i].pokeball);
			}
		}
		System.out.println();
		Asignar matriz = new Asignar();
		matriz.rellenar();
		matriz.Serializar();
	}
}