package Potencia;
import java.util.Scanner;
public class Potencia {
	static Scanner entrada = new Scanner(System.in);
	static int exponente;
	public static void main(String[] args) {
		double[][] matriz = matriz("Ingrese la matriz cuadrada");
		double[][] producto = new double[matriz.length][matriz[0].length];
		double[][] aux = matriz;
		System.out.println("Matriz de "+matriz.length+"x"+matriz.length);
		impMatriz(matriz);
		System.out.print("Ingrese la potencia: ");
		exponente = entrada.nextInt();
		if(exponente > 1) {
			impMatriz(matriz,String.valueOf(1));
			for(int exp = 1; exp < exponente; exp ++) {
				producto = producto(matriz,aux,exp);
				aux = producto;
			}
		}else if(exponente == 1) {
			producto = matriz;
			impMatriz(producto,String.valueOf(exponente));
		}
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
				System.out.printf("%-9s",redondeo(columna,4));
			}
			System.out.println();
		}
		System.out.println();
	}
	public static double[][] producto(double[][] matriz,double[][] aux,int exp){
		double[][] producto = new double[matriz.length][matriz[0].length];
		for(int i = 0; i < matriz.length; i ++) {
			for(int j = 0; j < matriz[0].length; j ++) {
				for(int k = 0; k < matriz[0].length; k ++) {
					producto[i][j] += aux[i][k]*matriz[k][j];
				}
			}
		}
		impMatriz(producto,String.valueOf(exp+1));
		return producto;
	}
	public static void impMatriz(double[][] matriz,String exponente) {
		System.out.println("\nMatriz elevada a la potencia "+exponente);
		for(double[] fila:matriz) {
			for(double columna:fila) {
				System.out.printf("%-9s",redondeo(columna,4));
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
}