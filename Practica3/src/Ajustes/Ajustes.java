package Ajustes;
import java.io.Serializable;
public class Ajustes implements Serializable {
	private static final long serialVersionUID = 1L;
	private boolean it1;
	private boolean it2;
	private boolean it3;
	private boolean it4;
	private boolean it5;
	private boolean it6;
	private String fre;
	private String vel;
	private int tmp;
	public Ajustes(boolean it1,boolean it2,boolean it3,boolean it4,boolean it5,boolean it6,String fre,String vel,int tmp) {
		this.setIt1(it1);
		this.setIt2(it2);
		this.setIt3(it3);
		this.setIt4(it4);
		this.setIt5(it5);
		this.setIt6(it6);
		this.setFre(fre);
		this.setVel(vel);
		this.setTmp(tmp);
	}
	public boolean getIt1() {
		return it1;
	}
	public void setIt1(boolean it1) {
		this.it1 = it1;
	}
	public boolean getIt2() {
		return it2;
	}
	public void setIt2(boolean it2) {
		this.it2 = it2;
	}
	public boolean getIt3() {
		return it3;
	}
	public void setIt3(boolean it3) {
		this.it3 = it3;
	}
	public boolean getIt4() {
		return it4;
	}
	public void setIt4(boolean it4) {
		this.it4 = it4;
	}
	public boolean getIt5() {
		return it5;
	}
	public void setIt5(boolean it5) {
		this.it5 = it5;
	}
	public boolean getIt6() {
		return it6;
	}
	public void setIt6(boolean it6) {
		this.it6 = it6;
	}
	public String getFre() {
		return fre;
	}
	public void setFre(String fre) {
		this.fre = fre;
	}
	public String getVel() {
		return vel;
	}
	public void setVel(String vel) {
		this.vel = vel;
	}
	public int getTmp() {
		return tmp;
	}
	public void setTmp(int tmp) {
		this.tmp = tmp;
	}
}