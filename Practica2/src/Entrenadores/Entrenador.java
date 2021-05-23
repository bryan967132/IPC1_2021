package Entrenadores;
import java.io.Serializable;
public class Entrenador implements Serializable {
	public int id;
	public String nombre;
	public Entrenador(int id,String nombre) {
		this.setId(id);
		this.setNombre(nombre);
	}
	int getId() {
		return id;
	}
	void setId(int id) {
		this.id = id;
	}
	String getNombre() {
		return nombre;
	}
	void setNombre(String nombre) {
		this.nombre = nombre;
	}
}