package Pokemons;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class ControladorPokemon{
	public static Pokemon[] pokemons = new Pokemon[150];
	public static void Serializar() {
		try {
			FileOutputStream archivo = new FileOutputStream("Serializados/pokemon");
			ObjectOutputStream convertir = new ObjectOutputStream(archivo);
			convertir.writeObject(pokemons);
			convertir.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void Deserializar() {
		try {
			FileInputStream lector = new FileInputStream("Serializados/pokemon");
			ObjectInputStream regresar = new ObjectInputStream(lector);
			Pokemon[] pokemon = (Pokemon[])regresar.readObject();
			regresar.close();
			for(int i=0; i<pokemons.length; i++) {
				pokemons[i]=pokemon[i];
			}
		}catch(Exception e) {
		}
	}
	public static void limpiar() {
		for(int i=0; i<pokemons.length; i++) {
			pokemons[i]=null;
		}
	}
	public void cargamasiva(String ruta) {
		try {
			File archivo = new File(ruta);
			Scanner reader = new Scanner(archivo);
			limpiar();
			String[] actual;
			Pokemon pokemon;
			Boolean capturado,estado;
			while(reader.hasNextLine()) {
				actual = reader.nextLine().split(",");
				if(actual[5].equals("Capturado")||actual[5].equals("capturado")) {
					capturado=true;
				}else {
					capturado=false;
				}
				if(actual[6].equals("Vivo")||actual[6].equals("vivo")) {
					estado=true;
				}else {
					estado=false;
				}
				pokemon = new Pokemon(Integer.parseInt(actual[0]),actual[1],actual[2],Double.valueOf(actual[3]),Double.valueOf(actual[4]),capturado,estado);
				if(!this.agregarPokemon(pokemon)) {
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
			Pokemon pokemon;
			Boolean capturado,estado;
			reader.nextLine();
			while(reader.hasNextLine()) {
				actual = reader.nextLine().split(",");
				if(actual[5].equals("Capturado")||actual[5].equals("capturado")) {
					capturado=true;
				}else {
					capturado=false;
				}
				if(actual[6].equals("Vivo")||actual[6].equals("vivo")) {
					estado=true;
				}else {
					estado=false;
				}
				pokemon = new Pokemon(Integer.parseInt(actual[0]),actual[1],actual[2],Double.valueOf(actual[3]),Double.valueOf(actual[4]),capturado,estado);
				if(!this.agregarPokemon(pokemon)) {
					System.out.println("Se ha llenado");
				}
			}
			Serializar();
			imprimir();
		}catch(Exception e) {
			System.out.println("Ruta inválida");
		}
	}
	public boolean agregarPokemon(Pokemon pokemons) {
		for(int i=0; i<this.pokemons.length; i++) {
			if(this.pokemons[i]==null) {
				this.pokemons[i]=pokemons;
				return true;
			}
		}
		return false;
	}
	public void imprimir() {
		String estado;
		String capturado;
		for(int i=0; i<this.pokemons.length;i++) {
			if(this.pokemons[i]!=null) {
				if(this.pokemons[i].getCapturado()==true) {
					capturado="Capturado";
				}else {
					capturado="Salvaje";
				}
				if(this.pokemons[i].getEstado()==true) {
					estado="Vivo";
				}else {
					estado="Muerto";
				}
				System.out.printf("%-9s%-17s%-22s%-16s%-32s%-22s%-18s\n",	
						"ID: "+this.pokemons[i].getId(),
						"Tipo: "+this.pokemons[i].getTipo(),
						"Nombre: "+this.pokemons[i].getNombre(),
						"Vida: "+this.pokemons[i].getVida(),
						"Puntos de Ataque: "+this.pokemons[i].getPuntosAtaque(),
						"Capturado: "+capturado,
						"Estado: "+estado);
			}
		}
		System.out.println();
	}
}