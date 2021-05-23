package Pokeballs;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class ControladorPokeball {
	public static Pokeball[] pokeballs = new Pokeball[150];
	public static void Serializar() {
		try {
			FileOutputStream archivo = new FileOutputStream("Serializados/pokeballs");
			ObjectOutputStream convertir = new ObjectOutputStream(archivo);
			convertir.writeObject(pokeballs);
			convertir.close();
		}catch(Exception e) {
		}
	}
	public static void Deserializar() {
		try {
			FileInputStream lector = new FileInputStream("Serializados/pokeballs");
			ObjectInputStream regresar = new ObjectInputStream(lector);
			Pokeball[] pokeball = (Pokeball[])regresar.readObject();
			regresar.close();
			for(int i=0; i<pokeballs.length; i++) {
				pokeballs[i]=pokeball[i];
			}
		}catch(Exception e) {
		}
	}
	public static void limpiar() {
		for(int i=0; i<pokeballs.length; i++) {
			pokeballs[i]=null;
		}
	}
	public void cargamasiva(String ruta) {
		try {
			File archivo = new File(ruta);
			Scanner reader = new Scanner(archivo);
			limpiar();
			String[] actual;
			Pokeball pokeball;
			while(reader.hasNextLine()) {
				actual = reader.nextLine().split(",");
				pokeball = new Pokeball(Integer.parseInt(actual[0]),actual[1]);
				if(!this.agregarPokeball(pokeball)) {
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
			Pokeball pokeball;
			reader.nextLine();
			while(reader.hasNextLine()) {
				actual = reader.nextLine().split(",");
				pokeball = new Pokeball(Integer.parseInt(actual[0]),actual[1]);
				if(!this.agregarPokeball(pokeball)) {
					System.out.println("Se ha llenado");
				}
			}
			Serializar();
			imprimir();
		}catch(Exception e) {
			System.out.println("Ruta inválida");
		}
	}
	public boolean agregarPokeball(Pokeball pokeballs) {
		for(int i=0; i<this.pokeballs.length; i++) {
			if(this.pokeballs[i]==null) {
				this.pokeballs[i]=pokeballs;
				return true;
			}
		}
		return false;
	}
	public void imprimir() {
		for(int i=0; i<this.pokeballs.length;i++) {
			if(this.pokeballs[i]!=null) {
				System.out.printf("%-9s%-20s\n",	
						"ID: "+this.pokeballs[i].getId(),
						"Tipo: "+this.pokeballs[i].getTipo());
			}
		}
		System.out.println();
	}
}