package Gauss;
public class GaussEstatico {
	public static void main(String[] args) {
		System.err.println("M�todo de Gauss");
		double[][] aum = {{2,-2,(double)5/2,1},{1,1,1,0},{0,0,(double)-3/2,3}};
		String[] lit = {"C1","C2","C3"};
		System.out.println("Sistema de Ecuaciones");
		for(int i = 0; i < aum.length; i ++) {
			for(int j = 0; j < aum[i].length - 1; j ++) {
				if(aum[i][j] < 0 && j == 0) System.out.print("- ");
				System.out.print(abs(aum[i][j])+lit[j]);
				if(j < aum[i].length - 2) {
					if(aum[i][j + 1] >= 0) System.out.print(" + ");
					else System.out.print(" - ");
				}
			}
			System.out.println(" = "+aum[i][aum[i].length - 1]);
		}
		System.out.println("\nMatriz de Aumentada");
		for(int i = 0; i < aum.length; i ++) {
			for(int j = 0; j < aum[i].length; j ++) {
				String sp = "%-8s";
				if(j >= aum[i].length - 2) sp = "%-6s";
				System.out.printf(sp,aum[i][j]);
				if(j == aum[i].length - 2) {sp = "%-3s"; System.out.printf(sp,"|");}
			}
			System.out.println();
		}
		System.out.println("\n"+gauss(aum,lit));
	}
	public static String gauss(double[][] aum,String[] lit) {
		for(int i = 0; i < aum.length; i ++) {
			double factor = aum[i][i];
			for(int j = i; j < aum[i].length; j ++) {
				aum[i][j] /= factor;
			}
			impAum(aum,i);
			for(int x = i + 1; x < aum.length; x ++) {
				double multiplo = aum[x][i];
				for(int y = i; y < aum[i].length; y ++) {
					aum[x][y] -= aum[i][y] * multiplo;
				}
			}
			impAum(aum,i);
		}
		double[] solucion = sustRev(aum);
		String resultado = "Soluci�n del Sistema";
		for(int i = 0; i < solucion.length; i ++) {
			resultado += "\n"+lit[i]+" = "+redondeo(solucion[i],6);
		}
		return resultado;
	}
	public static double[] sustRev(double[][] aum) {
		double[] solucion = new double[aum.length];
		solucion[aum.length - 1] = aum[aum.length - 1][aum.length];
		for(int i = aum.length - 2; i >= 0; i --) {
			solucion[i] = aum[i][aum.length];
			for(int j = i + 1; j < aum.length; j ++) {
				solucion[i] -= aum[i][j] * solucion[j];
			}
		}
		return solucion;
	}
	public static void impAum(double[][] aum,int i) {
		System.out.println("\nMatriz de Aumentada "+i);
		for(int x = 0; x < aum.length; x ++) {
			for(int j = 0; j < aum[x].length; j ++) {
				String sp = "%-8s";
				if(j >= aum[x].length - 2) sp = "%-6s";
				System.out.printf(sp,redondeo(aum[x][j],3));
				if(j == aum[x].length - 2) {sp = "%-3s"; System.out.printf(sp,"|");}
			}
			System.out.println();
		}
	}
	public static double redondeo(double valor,int decimales) {
		return frac(Math.round(valor*potencia(10,decimales)),potencia(10,decimales));
	}
	public static double potencia(double base,double exponente) {
		return Math.pow(base,exponente);
	}
	public static double frac(double a,double b) {
		return a/b;
	}
	public static double abs(double a) {
		return Math.abs(a);
	}
}