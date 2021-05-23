package AsignacionPokeballs;
import java.io.Serializable;
public class AsignacionPokeball implements Serializable {
	public int entrenador;
	public int pokeball;
	public AsignacionPokeball(int entrenador,int pokeball) {
		this.setEntrenador(entrenador);
		this.setPokeball(pokeball);
	}
	public int getEntrenador() {
		return entrenador;
	}
	public void setEntrenador(int entrenador) {
		this.entrenador = entrenador;
	}
	public int getPokeball() {
		return pokeball;
	}
	public void setPokeball(int pokeball) {
		this.pokeball = pokeball;
	}
}