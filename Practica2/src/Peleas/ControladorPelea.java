package Peleas;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class ControladorPelea {
	public static Pelea[] peleas = new Pelea[500];
	public static void Serializar() {
		try {
			FileOutputStream archivo = new FileOutputStream("Serializados/peleas");
			ObjectOutputStream convertir = new ObjectOutputStream(archivo);
			convertir.writeObject(peleas);
			convertir.close();
		}catch(Exception e) {
		}
	}
	public static void Deserializar() {
		try {
			FileInputStream lector = new FileInputStream("Serializados/peleas");
			ObjectInputStream regresar = new ObjectInputStream(lector);
			Pelea[] pelea = (Pelea[])regresar.readObject();
			regresar.close();
			for(int i=0; i<peleas.length; i++) {
				peleas[i]=pelea[i];
			}
		}catch(Exception e) {
		}
	}
	public static void limpiar() {
		for(int i=0; i<peleas.length; i++) {
			peleas[i]=null;
		}
	}
	public void cargamasiva(String ruta) {
		try {
			File archivo = new File(ruta);
			Scanner reader = new Scanner(archivo);
			limpiar();
			String[] actual;
			Pelea pelea;
			while(reader.hasNextLine()) {
				actual = reader.nextLine().split(",");
				pelea = new Pelea(Integer.parseInt(actual[0]),Integer.parseInt(actual[1]),Integer.parseInt(actual[2]));
				if(!this.agregarPelea(pelea)) {
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
			Pelea pelea;
			reader.nextLine();
			while(reader.hasNextLine()) {
				actual = reader.nextLine().split(",");
				pelea = new Pelea(Integer.parseInt(actual[0]),Integer.parseInt(actual[1]),Integer.parseInt(actual[2]));
				if(!this.agregarPelea(pelea)) {
					System.out.println("Se ha llenado");
				}
			}
			Serializar();
			imprimir();
		}catch(Exception e) {
			System.out.println("Ruta inválida");
		}
	}
	public boolean agregarPelea(Pelea peleas) {
		for(int i=0; i<this.peleas.length; i++) {
			if(this.peleas[i]==null) {
				this.peleas[i]=peleas;
				return true;
			}
		}
		return false;
	}
	public void imprimir() {
		for(int i=0; i<this.peleas.length;i++) {
			if(this.peleas[i]!=null) {
				Enfrentamientos pelear = new Enfrentamientos();
				pelear.enfrentar(peleas[i].getGym(),
								 peleas[i].getPokemon1(),
								 peleas[i].getPokemon2());
			}
		}
		System.out.println();
	}
	public void resumen() {
		for(int i=0; i<this.peleas.length;i++) {
			if(this.peleas[i]!=null) {
				Enfrentamientos pelear = new Enfrentamientos();
				pelear.resumen(peleas[i].getGym(),
								 peleas[i].getPokemon1(),
								 peleas[i].getPokemon2());
			}
		}
		System.out.println();
	}
}