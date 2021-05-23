package ActividadComida;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class ControladorComer {
	public static Comer[] comidas = new Comer[150];
	public static void Serializar() {
		try {
			FileOutputStream archivo = new FileOutputStream("Serializados/comer");
			ObjectOutputStream convertir = new ObjectOutputStream(archivo);
			convertir.writeObject(comidas);
			convertir.close();
		}catch(Exception e) {
		}
	}
	public static void Deserializar() {
		try {
			FileInputStream lector = new FileInputStream("Serializados/comer");
			ObjectInputStream regresar = new ObjectInputStream(lector);
			Comer[] comer = (Comer[])regresar.readObject();
			regresar.close();
			for(int i=0; i<comidas.length; i++) {
				comidas[i]=comer[i];
			}
		}catch(Exception e) {
		}
	}
	public static void limpiar() {
		for(int i=0; i<comidas.length; i++) {
			comidas[i]=null;
		}
	}
	public void cargamasiva(String ruta) {
		try {
			File archivo = new File(ruta);
			Scanner reader = new Scanner(archivo);
			limpiar();
			String[] actual;
			Comer comida;
			while(reader.hasNextLine()) {
				actual = reader.nextLine().split(",");
				comida = new Comer(Integer.parseInt(actual[0]),Integer.parseInt(actual[1]));
				if(!this.agregarComer(comida)) {
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
			Comer comida;
			reader.nextLine();
			while(reader.hasNextLine()) {
				actual = reader.nextLine().split(",");
				comida = new Comer(Integer.parseInt(actual[0]),Integer.parseInt(actual[1]));
				if(!this.agregarComer(comida)) {
					System.out.println("Se ha llenado");
				}
			}
			Serializar();
			imprimir();
		}catch(Exception e) {
			System.out.println("Ruta inválida");
		}
	}
	public boolean agregarComer(Comer comidas) {
		for(int i=0; i<this.comidas.length; i++) {
			if(this.comidas[i]==null) {
				this.comidas[i]=comidas;
				return true;
			}
		}
		return false;
	}
	public void imprimir() {
		for(int i=0; i<this.comidas.length;i++) {
			if(this.comidas[i]!=null) {
				Alimentar alimentar = new Alimentar();
				alimentar.alimentar(comidas[i].getIdAlimento(),comidas[i].getIdPokemon());
			}
		}
		System.out.println();
	}
}