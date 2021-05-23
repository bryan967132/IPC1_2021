package AsignacionPokemons;
import java.io.Serializable;
public class AsignacionPokemon implements Serializable {
	public int pokeball;
	public int pokemon;
	public AsignacionPokemon(int pokeball,int pokemon) {
		this.setPokeball(pokeball);
		this.setPokemon(pokemon);
	}
	public int getPokeball() {
		return pokeball;
	}
	public void setPokeball(int pokeball) {
		this.pokeball = pokeball;
	}
	public int getPokemon() {
		return pokemon;
	}
	public void setPokemon(int pokemon) {
		this.pokemon = pokemon;
	}
}