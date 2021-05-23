package Pokemons;
import java.io.Serializable;
public class Pokemon implements Serializable {
	public int id;
	public String tipo;
	public String nombre;
	public double vida;
	public double puntosAtaque;
	public boolean capturado;
	public boolean estado;
	public Pokemon(int id,String tipo,String nombre, double vida,double puntosAtaque,boolean capturado,boolean estado) {
		this.setId(id);
		this.setTipo(tipo);
		this.setNombre(nombre);
		this.setVida(vida);
		this.setPuntosAtaque(puntosAtaque);
		this.setCapturado(capturado);
		this.setEstado(estado);
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
	public double getPuntosAtaque() {
		return puntosAtaque;
	}
	public void setPuntosAtaque(double puntosAtaque) {
		this.puntosAtaque = puntosAtaque;
	}
	public boolean getCapturado() {
		return capturado;
	}
	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}