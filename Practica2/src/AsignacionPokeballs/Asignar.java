package AsignacionPokeballs;
import static Entrenadores.ControladorEntrenador.entrenadores;
import static Pokeballs.ControladorPokeball.pokeballs;
import static AsignacionPokeballs.ControladorAsigPbl.asigPokeballs;
import static AsignacionPokemons.ControladorAsigPkm.asigPokemons;
import static Pokemons.ControladorPokemon.pokemons;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import GuardarDatos.GuardarPokeball;
public class Asignar {
	public static String entrenador,pokeball,pokemon;
	static int entr,BuscarPkbl,EncontradoPkm,entrenadorG=0,pokemon1=0,pokemon2=0,pokemon3=0;
	public static GuardarPokeball[] guardarPokeball = new GuardarPokeball[25];
	public static void asignar(int Entrenador,int Pokeball) {
		for(int i=0; i<entrenadores.length; i++) {
			if(entrenadores[i]!=null) {
				if(entrenadores[i].id==Entrenador) {
					entrenador = entrenadores[i].nombre;
					guardar(Entrenador);
				}
			}
		}
		for(int i=0; i<pokeballs.length; i++) {
			if(pokeballs[i]!=null) {
				if(pokeballs[i].id==Pokeball) {
					BuscarPkbl = pokeballs[i].id;
					pokeball = pokeballs[i].tipo;
				}
			}
		}
		for(int i=0; i<asigPokemons.length; i++) {
			if(asigPokemons[i]!=null) {
				if(asigPokemons[i].pokeball==BuscarPkbl) {
					EncontradoPkm = asigPokemons[i].pokemon;
				}
			}
		}
		for(int i=0; i<pokemons.length; i++) {
			if(pokemons[i]!=null) {
				if(pokemons[i].id==EncontradoPkm) {
					pokemon = pokemons[i].nombre;
				}
			}
		}
		for(int i=0; i<150; i++) {
			if(entrenadores[i]!=null && pokeballs[i]!=null) {
				System.out.printf("%-13s\n%-15s\n"," - "+entrenador,"   * Una "+pokeball+" con "+pokemon);
				break;
			}
		}
	}
	public static void guardar(int entrenador) {
		for(int i=0; i<asigPokeballs.length; i++) {
			if(asigPokeballs[i]!=null) {
				if(asigPokeballs[i].entrenador==entrenador) {
					entrenadorG=asigPokeballs[i].entrenador;
					if(pokemon1==0) {
						pokemon1 = asigPokeballs[i].pokeball;
					}else if(pokemon2==0) {
						pokemon2 = asigPokeballs[i].pokeball;
					}else {
						pokemon3 = asigPokeballs[i].pokeball;
					}
				}
			}
		}
		for(int i=0; i<asigPokeballs.length;i++) {
			if(guardarPokeball[i]==null || (i+1)==entrenadorG) {
				guardarPokeball[i] = new GuardarPokeball(entrenadorG,pokemon1,pokemon2,pokemon3);
				break;
			}
		}
		entrenadorG=0;
		pokemon1=0;
		pokemon2=0;
		pokemon3=0;
	}
	public static void rellenar() {
		for(int i=0; i<guardarPokeball.length; i++) {
			if(guardarPokeball[i]==null) {
				guardarPokeball[i] = new GuardarPokeball((i+1),0,0,0);
			}
		}
	}
	public static void Serializar() {
		try {
			FileOutputStream archivo = new FileOutputStream("Serializados/matrizEP");
			ObjectOutputStream convertir = new ObjectOutputStream(archivo);
			convertir.writeObject(guardarPokeball);
			convertir.close();
		}catch(Exception e) {
		}
	}
	public static void Deserializar() {
		try {
			FileInputStream lector = new FileInputStream("Serializados/matrizEP");
			ObjectInputStream regresar = new ObjectInputStream(lector);
			GuardarPokeball[] asignacionpokeball = (GuardarPokeball[])regresar.readObject();
			regresar.close();
			for(int i=0; i<guardarPokeball.length; i++) {
				guardarPokeball[i]=asignacionpokeball[i];
			}
		}catch(Exception e) {
		}
	}
	public static void imprimir() {
		try {
		for(int i=0; i<entrenadores.length; i++) {
			if(entrenadores[i]!=null) {
				System.out.println(guardarPokeball[i].idEntrenador+" "+guardarPokeball[i].idPokeball1+" "+guardarPokeball[i].idPokeball2+" "+guardarPokeball[i].idPokeball3);
			}
		}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}