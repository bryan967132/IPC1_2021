package Alumnos;
import java.io.Serializable;
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nombre;
	private String apellido;
	private String correo;
	private String contraseña;
	private String genero;
	public Alumno(int codigo,String nombre,String apellido,String correo,String contraseña,String genero) {
		this.setCodigo(codigo);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCorreo(correo);
		this.setContraseña(contraseña);
		this.setGenero(genero);
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
}