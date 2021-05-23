package Gimnasios;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class ControladorGimnasio {
	public static Gimnasio[] gimnasios = new Gimnasio[25];
	public static void Serializar() {
		try {
			FileOutputStream archivo = new FileOutputStream("Serializados/gimnasio");
			ObjectOutputStream convertir = new ObjectOutputStream(archivo);
			convertir.writeObject(gimnasios);
			convertir.close();
		}catch(Exception e) {
		}
	}
	public static void Deserializar() {
		try {
			FileInputStream lector = new FileInputStream("Serializados/gimnasio");
			ObjectInputStream regresar = new ObjectInputStream(lector);
			Gimnasio[] entrenador = (Gimnasio[])regresar.readObject();
			regresar.close();
			for(int i=0; i<gimnasios.length; i++) {
				gimnasios[i]=entrenador[i];
			}
		}catch(Exception e) {
		}
	}
	public static void limpiar() {
		for(int i=0; i<gimnasios.length; i++) {
			gimnasios[i]=null;
		}
	}
	public void cargamasiva(String ruta) {
		try {
			File archivo = new File(ruta);
			Scanner reader = new Scanner(archivo);
			limpiar();
			String[] actual;
			Gimnasio gimnasio;
			while(reader.hasNextLine()) {
				actual = reader.nextLine().split(",");
				gimnasio = new Gimnasio(Integer.parseInt(actual[0]),actual[1]);
				if(!this.agregarGimnasio(gimnasio)) {
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
			Gimnasio gimnasio;
			reader.nextLine();
			while(reader.hasNextLine()) {
				actual = reader.nextLine().split(",");
				gimnasio = new Gimnasio(Integer.parseInt(actual[0]),actual[1]);
				if(!this.agregarGimnasio(gimnasio)) {
					System.out.println("Se ha llenado");
				}
			}
			Serializar();
			imprimir();
		}catch(Exception e) {
			System.out.println("Ruta inválida");
		}
	}
	public boolean agregarGimnasio(Gimnasio gimnasios) {
		for(int i=0; i<this.gimnasios.length; i++) {
			if(this.gimnasios[i]==null) {
				this.gimnasios[i]=gimnasios;
				return true;
			}
		}
		return false;
	}
	public void imprimir() {
		for(int i=0; i<this.gimnasios.length;i++) {
			if(this.gimnasios[i]!=null) {
				System.out.printf("%-9s%-20s\n",	
						"ID: "+this.gimnasios[i].getId(),
						"Lugar: "+this.gimnasios[i].getLugar());
			}
		}
		System.out.println();
	}
}