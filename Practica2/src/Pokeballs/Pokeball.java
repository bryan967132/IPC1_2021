package Pokeballs;
import java.io.Serializable;
public class Pokeball implements Serializable {
	public int id;
	public String tipo;
	public Pokeball(int id,String tipo) {
		this.setId(id);
		this.setTipo(tipo);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}