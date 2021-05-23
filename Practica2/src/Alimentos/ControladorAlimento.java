package Alimentos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class ControladorAlimento {
	public static Alimento[] alimentos = new Alimento[15];
	public static void Serializar() {
		try {
			FileOutputStream archivo = new FileOutputStream("Serializados/alimento");
			ObjectOutputStream convertir = new ObjectOutputStream(archivo);
			convertir.writeObject(alimentos);
			convertir.close();
		}catch(Exception e) {
		}
	}
	public static void Deserializar() {
		try {
			FileInputStream lector = new FileInputStream("Serializados/alimento");
			ObjectInputStream regresar = new ObjectInputStream(lector);
			Alimento[] alimento = (Alimento[])regresar.readObject();
			regresar.close();
			for(int i=0; i<alimentos.length; i++) {
				alimentos[i]=alimento[i];
			}
		}catch(Exception e) {
		}
	}
	public static void limpiar() {
		for(int i=0; i<alimentos.length; i++) {
			alimentos[i]=null;
		}
	}
	public void cargamasiva(String ruta) {
		try {
			File archivo = new File(ruta);
			Scanner reader = new Scanner(archivo);
			limpiar();
			String[] actual;
			Alimento alimento;
			while(reader.hasNextLine()) {
				actual = reader.nextLine().split(",");
				alimento = new Alimento(Integer.parseInt(actual[0]),actual[1],Double.parseDouble(actual[2]));
				if(!this.agregarAlimento(alimento)) {
					//System.out.println("Se ha llenado");
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
			Alimento alimento;
			reader.nextLine();
			while(reader.hasNextLine()) {
				actual = reader.nextLine().split(",");
				alimento = new Alimento(Integer.parseInt(actual[0]),actual[1],Double.parseDouble(actual[2]));
				if(!this.agregarAlimento(alimento)) {
					System.out.println("Se ha llenado");
				}
			}
			Serializar();
			imprimir();
		}catch(Exception e) {
			System.out.println("Ruta inválida");
		}
	}
	public boolean agregarAlimento(Alimento alimentos) {
		for(int i=0; i<this.alimentos.length; i++) {
			if(this.alimentos[i]==null) {
				this.alimentos[i]=alimentos;
				return true;
			}
		}
		return false;
	}
	public void imprimir() {
		for(int i=0; i<this.alimentos.length;i++) {
			if(this.alimentos[i]!=null) {
				System.out.printf("%-9s%-28s%-20s\n",	
						"ID: "+this.alimentos[i].getId(),
						"Nombre: "+this.alimentos[i].getNombre(),
						"Vida: "+this.alimentos[i].getVida());
			}
		}
		System.out.println();
	}
}