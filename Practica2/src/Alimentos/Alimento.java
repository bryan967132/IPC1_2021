package Alimentos;
import java.io.Serializable;
public class Alimento implements Serializable {
	public int id;
	public String nombre;
	public double vida;
	public Alimento(int id,String nombre,double vida) {
		this.setId(id);
		this.setNombre(nombre);
		this.setVida(vida);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getVida() {
		return vida;
	}
	public void setVida(double vida) {
		this.vida = vida;
	}
}
