package ActividadComida;
import static Pokemons.ControladorPokemon.pokemons;
import Pokemons.ControladorPokemon;
import static Alimentos.ControladorAlimento.alimentos;
import Pokemons.Pokemon;
public class Alimentar {
	public static String nombre,tipo,gimnasio,comida;
	public static double vida,ataque,salud;
	public static boolean capturado,estado;
	public static Pokemon respaldo;
	public static void alimentar(int alimento,int pokemon) {
		for(int i=0; i<alimentos.length; i++) {
			if(alimentos[i]!=null) {
				if(alimentos[i].id==alimento) {
					comida = alimentos[i].nombre;
					salud = alimentos[i].vida;
				}
			}
		}
		for(int i=0; i<pokemons.length; i++) {
			if(pokemons[i]!=null) {
				if(pokemons[i].id==pokemon) {
					tipo = pokemons[i].tipo;
					nombre = pokemons[i].nombre;
					vida = pokemons[i].vida;
					ataque = pokemons[i].puntosAtaque;
					capturado = pokemons[i].capturado;
					estado = pokemons[i].estado;
				}
			}
		}
		comer(pokemon);
		System.out.println(nombre+" ha comido "+comida+" y ha recuperado "+salud+" de vida");
	}
	public static void comer(int pokemon) {
		vida+=salud;
		if(vida>0) {
			respaldo = new Pokemon(pokemon,tipo,nombre,vida,ataque,capturado,true);
			for(int i=0; i<pokemons.length; i++) {
				if(pokemons[i]!=null) {
					if(pokemons[i].id==pokemon) {
						pokemons[i]=respaldo;
					}
				}
			}
			ControladorPokemon serPok = new ControladorPokemon();
			serPok.Serializar();
		}else {
			respaldo = new Pokemon(pokemon,tipo,nombre,0,ataque,capturado,false);
			for(int i=0; i<pokemons.length; i++) {
				if(pokemons[i]!=null) {
					if(pokemons[i].id==pokemon) {
						pokemons[i]=respaldo;
					}
				}
			}
			ControladorPokemon serPok = new ControladorPokemon();
			serPok.Serializar();
		}
	}
}