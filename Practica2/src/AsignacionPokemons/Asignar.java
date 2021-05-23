package AsignacionPokemons;
import static Pokeballs.ControladorPokeball.*;
import static Pokemons.ControladorPokemon.*;
import Pokemons.ControladorPokemon;
import Pokemons.Pokemon;
public class Asignar {
	public static String pokeball,tipo,pokemon;
	public static double vida,ataque;
	public static boolean capturado,estado;
	public static Pokemon actual;
	public static void asignar(int Pokeball,int Pokemon) {
		for(int i=0; i<150; i++) {
			if(pokeballs[i]!=null) {
				if(pokeballs[i].id==Pokeball) {
					pokeball = pokeballs[i].tipo;
				}
			}
			if(pokemons[i]!=null) {
				if(pokemons[i].id==Pokemon) {
					tipo = pokemons[i].tipo;
					pokemon = pokemons[i].nombre;
					vida = pokemons[i].vida;
					ataque = pokemons[i].puntosAtaque;
					estado = pokemons[i].estado;
				}
			}
		}
		for(int i=0; i<150; i++) {
			if(pokeballs[i]!=null && pokemons[i]!=null) {
				System.out.printf("%-13s%-15s\n",pokeball+": ",pokemon);
				actualizar(Pokemon);
				break;
			}
		}
	}
	public static void actualizar(int pokemones) {
		actual  = new Pokemon(pokemones,tipo,pokemon,vida,ataque,true,estado);
		for(int i=0; i<pokemons.length; i++) {
			if(pokemons[i]!=null) {
				if(pokemons[i].id==pokemones) {
					pokemons[i]=actual;
				}
			}
		}
		ControladorPokemon serPok = new ControladorPokemon();
		serPok.Serializar();
	}
}