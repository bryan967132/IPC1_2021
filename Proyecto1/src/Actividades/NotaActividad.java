package Actividades;
import java.io.Serializable;
public class NotaActividad implements Serializable {
	private static final long serialVersionUID = 1L;
	private int codAlu;
	private int codCur;
	private int codAct;
	private double nota;
	public NotaActividad(int codAlu,int codCur,int codAct,double nota) {
		this.setCodAlu(codAlu);
		this.setCodCur(codCur);
		this.setCodAct(codAct);
		this.setNota(nota);
	}
	public int getCodAlu() {
		return codAlu;
	}
	public void setCodAlu(int codAlu) {
		this.codAlu = codAlu;
	}
	public int getCodCur() {
		return codCur;
	}
	public void setCodCur(int codCur) {
		this.codCur = codCur;
	}
	public int getCodAct() {
		return codAct;
	}
	public void setCodAct(int codAct) {
		this.codAct = codAct;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
}