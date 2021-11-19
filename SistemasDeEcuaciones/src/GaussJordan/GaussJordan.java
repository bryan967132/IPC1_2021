package GaussJordan;
import java.util.Scanner;
public class GaussJordan {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.err.println("Método de Gauss-Jordan");
		System.out.print("Cantidad de variables y ecuaciones = ");
		int n = sc.nextInt();
		System.out.println("Variables para trabajar");
		double[][] aum = new double[n][n + 1];
		String[] lit = new String[n];
		for(int i = 0; i < lit.length; i ++) {
			System.out.print("Variable "+(i + 1)+": ");
			lit[i] = sc.next();
		}
		for(int i = 0; i < aum.length; i ++) {
			System.out.println("\nEcuación "+(i + 1));
			for(int j = 0; j < aum[i].length - 1; j ++) {
				System.out.print("Coeficiente de "+lit[j]+" = ");
				aum[i][j] = sc.nextDouble();
			}
			for(int j = 0; j < aum[i].length - 1; j ++) {
				if(aum[i][j] < 0 && j == 0) System.out.print("- ");
				System.out.print(abs(aum[i][j])+lit[j]);
				if(j < aum[i].length - 2) {
					if(aum[i][j + 1] >= 0) System.out.print(" + ");
					else System.out.print(" - ");
				}
			}
			System.out.print(" = ");
			aum[i][aum[i].length - 1] = sc.nextDouble();
		}
		System.out.println("\nSistema de Ecuaciones");
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
		System.out.println("\n"+gaussjordan(aum,lit));
		sc.close();
	}
	public static String gaussjordan(double[][] aum,String[] lit) {
		for(int i = 0; i < aum.length; i ++) {
			double factor = aum[i][i];
			for(int j = i; j < aum[i].length; j ++) {
				aum[i][j] /= factor;
			}
			impAum(aum,i);
			for(int x = 0; x < aum.length; x ++) {
				if(x == i) continue;
				double multiplo = aum[x][i];
				for(int y = i; y < aum[i].length; y ++) {
					aum[x][y] -= aum[i][y] * multiplo;
				}
			}
			impAum(aum,i);
		}
		String resultado = "Solución del Sistema";
		for(int i = 0; i < aum.length; i ++) {
			resultado += "\n"+lit[i]+" = "+redondeo(aum[i][aum.length],6);
		}
		return resultado;
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