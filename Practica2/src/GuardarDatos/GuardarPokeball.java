package GuardarDatos;
import java.io.Serializable;
public class GuardarPokeball implements Serializable {
	public int idEntrenador;
	public int idPokeball1;
	public int idPokeball2;
	public int idPokeball3;
	public GuardarPokeball(int idEntrenador,int idPokeball1,int idPokeball2,int idPokeball3) {
		this.setIdEntrenador(idEntrenador);
		this.setIdPokeball1(idPokeball1);
		this.setIdPokeball2(idPokeball2);
		this.setIdPokeball3(idPokeball3);
	}
	public int getIdEntrenador() {
		return idEntrenador;
	}
	public void setIdEntrenador(int idEntrenador) {
		this.idEntrenador = idEntrenador;
	}
	public int getIdPokeball1() {
		return idPokeball1;
	}
	public void setIdPokeball1(int idPokeball1) {
		this.idPokeball1 = idPokeball1;
	}
	public int getIdPokeball2() {
		return idPokeball2;
	}
	public void setIdPokeball2(int idPokeball2) {
		this.idPokeball2 = idPokeball2;
	}
	public int getIdPokeball3() {
		return idPokeball3;
	}
	public void setIdPokeball3(int idPokeball3) {
		this.idPokeball3 = idPokeball3;
	}
}