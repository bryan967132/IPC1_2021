package Inversa;
import java.util.Scanner;
public class Inversa {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese la longitud de la matriz cuadrada: ");
		int n = sc.nextInt();
		double[][] matriz = new double[n][n];
		double[][] inversa = new double[n][n];
		System.out.println("Ingrese los elementos de la matriz");
		for(int i = 0; i < matriz.length; i ++) {
			for(int j = 0; j < matriz[i].length; j ++) {
				System.out.print("Matriz["+(i + 1)+"]["+(j + 1)+"] = ");
				matriz[i][j] = sc.nextDouble();
			}
		}
		sc.close();
		System.out.println("\nMatriz "+n+"x"+n);
		for(double[] fila:matriz) {
			for(double elemento:fila) {
				System.out.printf("%-6s",elemento);
			}
			System.out.println("");
		}
		inversa = invertir(matriz);
		System.out.println("\nMatriz inversa");
		for(double[] fila:inversa) {
			for(double elemento:fila) {
				System.out.printf("%-10s",redondear(elemento,4));
			}
			System.out.println("");
		}
	}
	public static double[][] invertir(double[][] matriz){
		double[][] inversa = new double[matriz.length][matriz[0].length];
		for(int i = 0; i < matriz.length; i ++) {
			int j = i;
			double pivote = matriz[i][j];
			inversa[i][j] = frac(1,pivote);
			for(int y = 0; y < matriz.length; y ++) {
				if(y != i) {
					inversa[i][y] = frac(matriz[i][y],pivote); 
				}
			}
			for(int x = 0; x < matriz.length; x ++) {
				if(x != j) {
					inversa[x][j] = -frac(matriz[x][j],pivote);
				}
			}
			for(int x = 0; x < matriz.length; x ++) {
				for(int y = 0; y < matriz[x].length; y ++) {
					if(x != i && y != j) {
						inversa[x][y] = matriz[x][y] - frac(matriz[i][y] * matriz[x][j],pivote);
					}
				}
			}
			for(int x = 0; x < matriz.length; x ++) {
				for(int y = 0; y < matriz[x].length; y ++) {
					matriz[x][y] = inversa[x][y];
				}
			}
		}
		return inversa;
	}
	public static double redondear(double valor,int decimales) {
		return frac(Math.round(valor*potencia(10,decimales)),potencia(10,decimales));
	}
	public static double potencia(double base,double exponente) {
		return Math.pow(base,exponente);
	}
	public static double frac(double a,double b) {
		return a/b;
	}
}