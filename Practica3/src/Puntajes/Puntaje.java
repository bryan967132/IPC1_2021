package Puntajes;
import java.io.Serializable;
public class Puntaje implements Serializable {
	private static final long serialVersionUID = 1L;
	String nombre;
	int puntos;
	public Puntaje(String nombre,int puntos) {
		this.setNombre(nombre);
		this.setPuntos(puntos);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
}