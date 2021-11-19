package Producto;
import java.util.Scanner;
public class Producto {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		double[][] matriz1 = matriz("Ingrese la matriz 1");
		impMatriz(matriz1);
		double[][] matriz2 = matriz("Ingrese la matriz 2");
		impMatriz(matriz2);
		double[][] producto = new double[matriz1.length][matriz2[0].length];
		for(int i = 0; i < matriz1.length; i ++) {
			for(int j = 0; j < matriz2[i].length; j ++) {
				for(int k = 0; k < matriz1[i].length; k ++) {
					producto[i][j] += matriz1[i][k] * matriz2[k][j];
				}
			}
		}
		System.out.println("Matriz Resultante");
		impMatriz(producto);
	}
	public static double[][] matriz(String texto) {
		System.out.println(texto);
		String m = entrada.nextLine();
		String[] filas = m.split(";");
		String[] columnas = filas[0].split(",");
		double[][] matriz = new double[filas.length][columnas.length];
		for(int i = 0; i < filas.length; i ++) {
			columnas = filas[i].split(",");
			for(int j = 0; j < columnas.length; j ++) {
				matriz[i][j] = Double.parseDouble(columnas[j]);
			}
		}
		System.out.println();
		return matriz;
	}
	public static void impMatriz(double[][] matriz) {
		for(double[] fila:matriz) {
			for(double columna:fila) {
				System.out.printf("%-12s",redondeo(columna,4));
			}
			System.out.println();
		}
		System.out.println();
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
}