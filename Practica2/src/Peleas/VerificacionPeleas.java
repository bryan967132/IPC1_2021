package Peleas;
import static Pokemons.ControladorPokemon.pokemons;
import static Peleas.Enfrentamientos.*;
import Pokemons.ControladorPokemon;
import Pokemons.Pokemon;
public class VerificacionPeleas {
	public static void Anunciar() {
		System.out.printf("%-3s%-12s%-6s%-12s%-5s%-28s\n"," * ",nombre1," vs ",nombre2," | ","Gimnasio: "+gimnasio);
		System.out.printf("%-3s%-12s%-6s%-12s\n","   ","Vida: "+vida1,"    ","Vida: "+vida2);
		System.out.printf("%-3s%-12s%-6s%-12s\n","   ","Ataque: "+ataque1,"    ","Ataque: "+ataque2);
	}
	public static void Calificar(int pokemon1,int pokemon2) {
		if(vida1==vida2) {
			Actualizar(pokemon1,pokemon2);;
			System.out.printf("\n%-10s%-5s\n\n\n","","Los 2 Pokémons estaban muertos");
		}else if(vida1>vida2) {
			Actualizar(pokemon1,pokemon2);
			System.out.printf("\n%-10s%-5s\n\n\n","","!!!Ha Ganado "+nombre1+"!!!");
		}else {
			Actualizar(pokemon1,pokemon2);
			System.out.printf("\n%-10s%-5s\n\n\n","","!!!Ha Ganado "+nombre2+"!!!");
		}
	}
	public static void Actualizar(int pokemon1,int pokemon2) {
		if(vida1>0) {
			respaldo = new Pokemon(pokemon1,tipo1,nombre1,vida1,ataque1,capturado1,true);
			for(int i=0; i<pokemons.length; i++) {
				if(pokemons[i]!=null) {
					if(pokemons[i].id==pokemon1) {
						pokemons[i]=respaldo;
					}
				}
			}
			ControladorPokemon serPok = new ControladorPokemon();
			serPok.Serializar();
		}else {
			respaldo = new Pokemon(pokemon1,tipo1,nombre1,0,ataque1,capturado1,false);
			for(int i=0; i<pokemons.length; i++) {
				if(pokemons[i]!=null) {
					if(pokemons[i].id==pokemon1) {
						pokemons[i]=respaldo;
					}
				}
			}
			ControladorPokemon serPok = new ControladorPokemon();
			serPok.Serializar();
		}
		if(vida2>0) {
			respaldo = new Pokemon(pokemon2,tipo2,nombre2,vida2,ataque2,capturado2,true);
			for(int i=0; i<pokemons.length; i++) {
				if(pokemons[i]!=null) {
					if(pokemons[i].id==pokemon2) {
						pokemons[i]=respaldo;
					}
				}
			}
			ControladorPokemon serPok = new ControladorPokemon();
			serPok.Serializar();
		}else {
			respaldo = new Pokemon(pokemon2,tipo2,nombre2,0,ataque2,capturado2,false);
			for(int i=0; i<pokemons.length; i++) {
				if(pokemons[i]!=null) {
					if(pokemons[i].id==pokemon2) {
						pokemons[i]=respaldo;
					}
				}
			}
			ControladorPokemon serPok = new ControladorPokemon();
			serPok.Serializar();
		}
	}
}