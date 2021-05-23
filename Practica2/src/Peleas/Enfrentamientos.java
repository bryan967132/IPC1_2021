package Peleas;
import static Pokemons.ControladorPokemon.*;
import Pokemons.Pokemon;
import static Gimnasios.ControladorGimnasio.*;
import static Peleas.Enfrentamientos.ataque1;
import static Peleas.Enfrentamientos.ataque2;
import static Peleas.Enfrentamientos.gimnasio;
import static Peleas.Enfrentamientos.nombre1;
import static Peleas.Enfrentamientos.nombre2;
import static Peleas.Enfrentamientos.vida1;
import static Peleas.Enfrentamientos.vida2;
public class Enfrentamientos {
	public static String nombre1,nombre2,tipo1,tipo2,gimnasio;
	public static double vida1,vida2,ataque1,ataque2;
	public static boolean capturado1,capturado2,estado1,estado2;
	public static Pokemon respaldo;
	public static String campeon;
	public static void enfrentar(int gym,int pokemon1,int pokemon2) {
		for(int i=0; i<gimnasios.length; i++) {
			if(gimnasios[i]!=null) {
				if(gimnasios[i].id==gym) {
					gimnasio = gimnasios[i].lugar;
				}
			}
		}
		for(int i=0; i<pokemons.length; i++) {
			if(pokemons[i]!=null) {
				if(pokemons[i].id==pokemon1) {
					tipo1 = pokemons[i].tipo;
					nombre1 = pokemons[i].nombre;
					vida1 = pokemons[i].vida;
					ataque1 = pokemons[i].puntosAtaque;
					capturado1 = pokemons[i].capturado;
					estado1 = pokemons[i].estado;
				}
				if(pokemons[i].id==pokemon2) {
					tipo2 = pokemons[i].tipo;
					nombre2 = pokemons[i].nombre;
					vida2 = pokemons[i].vida;
					ataque2 = pokemons[i].puntosAtaque;
					capturado2 = pokemons[i].capturado;
					estado2 = pokemons[i].estado;
				}
			}
		}
		VerificacionPeleas verificar = new VerificacionPeleas();
		verificar.Anunciar();
		AtaqueP1();
		verificar.Calificar(pokemon1,pokemon2);
	}
	public static void AtaqueP1() {
		for(int i=1; i<4; i++) {
			if(vida1>0) {
				vida2 -= ataque1;
				if(vida2>0) {
					System.out.println("\n   Ronda "+i);
					System.out.println("    - Ataque 1: "+nombre1+
									   " deja con "+vida2+" de vida a "+nombre2);
					AtaqueP2(i);
				}else {
					System.out.println("\n   Ronda "+i);
					System.out.println("    - Ataque 1: "+nombre1+
									   " deja con "+0+" de vida a "+nombre2);
					break;
				}
			}
		}
	}
	public static void AtaqueP2(int i1) {
		for(int i=i1; i<(i1+1); i++) {
			vida1 -= ataque2;
			if(vida1>0) {
				System.out.print("    - Ataque 2: "+nombre2+
								 " deja con "+vida1+" de vida a "+nombre1);
			}else {
				System.out.print("    - Ataque 2: "+nombre2+
						 " deja con "+0+" de vida a "+nombre1);
			}
		}
	}
	public static void resumen(int gym,int pokemon1,int pokemon2) {
		for(int i=0; i<gimnasios.length; i++) {
			if(gimnasios[i]!=null) {
				if(gimnasios[i].id==gym) {
					gimnasio = gimnasios[i].lugar;
				}
			}
		}
		for(int i=0; i<pokemons.length; i++) {
			if(pokemons[i]!=null) {
				if(pokemons[i].id==pokemon1) {
					tipo1 = pokemons[i].tipo;
					nombre1 = pokemons[i].nombre;
					vida1 = pokemons[i].vida;
					ataque1 = pokemons[i].puntosAtaque;
					capturado1 = pokemons[i].capturado;
					estado1 = pokemons[i].estado;
				}
				if(pokemons[i].id==pokemon2) {
					tipo2 = pokemons[i].tipo;
					nombre2 = pokemons[i].nombre;
					vida2 = pokemons[i].vida;
					ataque2 = pokemons[i].puntosAtaque;
					capturado2 = pokemons[i].capturado;
					estado2 = pokemons[i].estado;
				}
			}
		}
		System.out.printf("%-12s%-6s%-12s%-5s%-28s\n",nombre1," vs ",nombre2," | ","Gimnasio: "+gimnasio);
	}
}