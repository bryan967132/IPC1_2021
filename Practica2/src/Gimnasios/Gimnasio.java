package Gimnasios;
import java.io.Serializable;
public class Gimnasio implements Serializable {
	public int id;
	public String lugar;
	public Gimnasio(int id,String lugar) {
		this.setId(id);
		this.setLugar(lugar);
	}
	int getId() {
		return id;
	}
	void setId(int id) {
		this.id = id;
	}
	String getLugar() {
		return lugar;
	}
	void setLugar(String lugar) {
		this.lugar = lugar;
	}
}