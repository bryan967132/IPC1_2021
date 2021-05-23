package Actividades;
import java.io.Serializable;
public class Actividad implements Serializable {
	private static final long serialVersionUID = 1L;
	private int curso;
	private int codigo;
	private String nombre;
	private String descripcion;
	private double ponderacion;
	public Actividad(int curso,int codigo,String nombre,String descripcion,double ponderacion) {
		this.setCurso(curso);
		this.setCodigo(codigo);
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setPonderacion(ponderacion);
	}
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPonderacion() {
		return ponderacion;
	}
	public void setPonderacion(double ponderacion) {
		this.ponderacion = ponderacion;
	}
}
