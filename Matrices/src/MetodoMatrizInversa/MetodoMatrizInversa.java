package MetodoMatrizInversa;
import java.util.Scanner;
public class MetodoMatrizInversa {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.err.println("Método de Matriz Inversa");
		System.out.print("Cantidad de variables y ecuaciones = ");
		int n = sc.nextInt();
		System.out.println("Variables para trabajar");
		double[][] aum = new double[n][n + 1];
		double[][] aux = new double[n][n];
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
				if(j == aum[i].length - 2) {sp = "%-4s"; System.out.printf(sp,"|");}
			}
			System.out.println();
		}
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < n; j ++) {
				aux[i][j] = aum[i][j];
			}
		}
		double[][] inversa = invertir(aux);
		System.out.println("\nMatriz inversa");
		for(double[] fila:inversa) {
			for(double elemento:fila) {
				System.out.printf("%-15s",redondeo(elemento,6));
			}
			System.out.println("");
		}
		double[] constante = new double[n];
		for(int i = 0; i < aum.length; i ++) {
			constante[i] = aum[i][n];
		}
		double[] producto = new double[aum.length];
		for(int i = 0; i < inversa.length; i ++) {
			for(int j = 0; j < constante.length; j ++) {
				producto[i] += inversa[i][j] * constante[j];
			}
		}
		System.out.println("\nSolución del Sistema");
		for(int i = 0; i < n; i ++) {
			System.out.printf("%-10s\n",lit[i]+" = "+redondeo(producto[i],6));
		}
		sc.close();
		
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