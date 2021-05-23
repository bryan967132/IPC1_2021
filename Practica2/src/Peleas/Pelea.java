package Peleas;
import java.io.Serializable;
public class Pelea implements Serializable {
	public int gym,pokemon1,pokemon2;
	public Pelea(int gym,int pokemon1,int pokemon2) {
		this.setGym(gym);
		this.setPokemon1(pokemon1);
		this.setPokemon2(pokemon2);
	}
	int getGym() {
		return gym;
	}
	void setGym(int gym) {
		this.gym = gym;
	}
	int getPokemon1() {
		return pokemon1;
	}
	void setPokemon1(int pokemon1) {
		this.pokemon1 = pokemon1;
	}
	int getPokemon2() {
		return pokemon2;
	}
	void setPokemon2(int pokemon2) {
		this.pokemon2 = pokemon2;
	}
}