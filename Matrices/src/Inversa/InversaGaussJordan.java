package Inversa;
import java.util.Scanner;
public class InversaGaussJordan {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Ingrese la matriz cuadrada");
		String m = sc.nextLine();
		String[] filas = m.split(";");
		String[] columnas = filas[0].split(",");
		double[][] matriz = new double[filas.length][columnas.length];
		for(int i = 0; i < filas.length; i ++) {
			columnas = filas[i].split(",");
			for(int j = 0; j < columnas.length; j ++) {
				matriz[i][j] = Double.valueOf(columnas[j]);
			}
		}
		double[][] inversa;
		System.out.println("\nMatriz "+filas.length+"x"+columnas.length);
		for(double[] fila:matriz) {
			for(double elemento:fila) {
				System.out.printf("%-6s",elemento);
			}
			System.out.println("");
		}
		inversa = gaussjordan(matriz);
		System.out.println("\nMatriz inversa");
		for(double[] fila:inversa) {
			for(double elemento:fila) {
				System.out.printf("%-15s",redondeo(elemento,4));
			}
			System.out.println("");
		}
	}
	public static double[][] gaussjordan(double[][] matriz) {
		double[][] aum = new double[matriz.length][2*matriz.length];
		double[][] inversa = new double[matriz.length][matriz.length];
		for(int i = 0; i < matriz.length; i ++) {
			for(int j = 0; j < matriz.length; j ++) {
				aum[i][j] = matriz[i][j];
			}
			for(int j = matriz[i].length; j < aum[i].length; j ++) {
				if(i == j - matriz[i].length) aum[i][j] = 1;
			}
		}
		impAum(aum,"");
		for(int i = 0; i < aum.length; i ++) {
			double factor = aum[i][i];
			for(int j = i; j < aum[i].length; j ++) {
				aum[i][j] /= factor;
			}
			impAum(aum,String.valueOf(i));
			for(int x = 0; x < aum.length; x ++) {
				if(x == i) continue;
				double multiplo = aum[x][i];
				for(int y = i; y < aum[i].length; y ++) {
					aum[x][y] -= aum[i][y] * multiplo;
				}
			}
			impAum(aum,String.valueOf(i));
		}
		for(int i = 0; i < inversa.length; i ++) {
			for(int j = 0; j < inversa[i].length; j ++) {
				inversa[i][j] = aum[i][j + matriz[i].length];
			}
		}
		return inversa;
	}
	public static void impAum(double[][] aum,String i) {
		System.out.println("\nMatriz "+i);
		for(int x = 0; x < aum.length; x ++) {
			for(int j = 0; j < aum[x].length; j ++) {
				String sp = "%-10s";
				if(j >= aum.length) sp = "%-15s";
				System.out.printf(sp,redondeo(aum[x][j],6));
				if(j == aum.length - 1) {sp = "%-3s"; System.out.printf(sp,"|");}
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