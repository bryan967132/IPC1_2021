package ActividadComida;
import java.io.Serializable;
public class Comer implements Serializable {
	private int idAlimento;
	private int idPokemon;
	public Comer(int idAlimento,int idPokemon) {
		this.setIdAlimento(idAlimento);
		this.setIdPokemon(idPokemon);
	}
	public int getIdAlimento() {
		return idAlimento;
	}
	public void setIdAlimento(int idAlimento) {
		this.idAlimento = idAlimento;
	}
	public int getIdPokemon() {
		return idPokemon;
	}
	public void setIdPokemon(int idPokemon) {
		this.idPokemon = idPokemon;
	}
}
