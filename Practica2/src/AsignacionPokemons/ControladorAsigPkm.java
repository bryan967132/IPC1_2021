package AsignacionPokemons;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class ControladorAsigPkm {
	public static AsignacionPokemon[] asigPokemons = new AsignacionPokemon[150];
	public static void Serializar() {
		try {
			FileOutputStream archivo = new FileOutputStream("Serializados/aisgnarPokemons");
			ObjectOutputStream convertir = new ObjectOutputStream(archivo);
			convertir.writeObject(asigPokemons);
			convertir.close();
		}catch(Exception e) {
		}
	}
	public static void Deserializar() {
		try {
			FileInputStream lector = new FileInputStream("Serializados/aisgnarPokemons");
			ObjectInputStream regresar = new ObjectInputStream(lector);
			AsignacionPokemon[] asignacionpokemon = (AsignacionPokemon[])regresar.readObject();
			regresar.close();
			for(int i=0; i<asigPokemons.length; i++) {
				asigPokemons[i]=asignacionpokemon[i];
			}
		}catch(Exception e) {
		}
	}
	public static void limpiar() {
		for(int i=0; i<asigPokemons.length; i++) {
			asigPokemons[i]=null;
		}
	}
	public void cargamasiva(String ruta) {
		try {
			File archivo = new File(ruta);
			Scanner reader = new Scanner(archivo);
			limpiar();
			String[] actual;
			AsignacionPokemon asignacionpokemon;
			while(reader.hasNextLine()) {
				actual = reader.nextLine().split(",");
				asignacionpokemon = new AsignacionPokemon(Integer.parseInt(actual[0]),Integer.parseInt(actual[1]));
				if(!this.agregarAsignacionPokemon(asignacionpokemon)) {
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
			AsignacionPokemon asignacionpokemon;
			reader.nextLine();
			while(reader.hasNextLine()) {
				actual = reader.nextLine().split(",");
				asignacionpokemon = new AsignacionPokemon(Integer.parseInt(actual[0]),Integer.parseInt(actual[1]));
				if(!this.agregarAsignacionPokemon(asignacionpokemon)) {
					System.out.println("Se ha llenado");
				}
			}
			Serializar();
			imprimir();
		}catch(Exception e) {
			System.out.println("Ruta inválida");
		}
	}
	public boolean agregarAsignacionPokemon(AsignacionPokemon asigPokemons) {
		for(int i=0; i<this.asigPokemons.length; i++) {
			if(this.asigPokemons[i]==null) {
				this.asigPokemons[i]=asigPokemons;
				return true;
			}
		}
		return false;
	}
	public void imprimir() {
		for(int i=0; i<this.asigPokemons.length;i++) {
			if(this.asigPokemons[i]!=null) {
				Asignar asignar = new Asignar();
				asignar.asignar(asigPokemons[i].pokeball,asigPokemons[i].pokemon);
			}
		}
		System.out.println();
	}
}