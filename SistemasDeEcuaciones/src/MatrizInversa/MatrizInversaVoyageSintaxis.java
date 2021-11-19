package MatrizInversa;
import java.util.Scanner;
public class MatrizInversaVoyageSintaxis {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.err.println("M�todo de Matriz Inversa");
		System.out.println("Ingrese la matriz aumentada de coeficientes");
		String m = sc.nextLine();
		String[] filas = m.split(";");
		String[] columnas = filas[0].split(",");
		double[][] aum = new double[filas.length][columnas.length];
		double[][] aux = new double[filas.length][filas.length];
		String[] lit = new String[aum.length];
		for(int i = 0; i < filas.length; i ++) {
			columnas = filas[i].split(",");
			for(int j = 0; j < columnas.length; j ++) {
				aum[i][j] = Double.valueOf(columnas[j]);
			}
		}
		System.out.println("\nVariables para trabajar");
		String v = sc.nextLine();
		for(int i = 0; i < lit.length; i ++) {
			lit[i] = v.split(",")[i];
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
				if(j == aum[i].length - 2) {sp = "%-4s"; System.out.printf(sp,"|");}
			}
			System.out.println();
		}
		for(int i = 0; i < aum.length; i ++) {
			for(int j = 0; j < aum.length; j ++) {
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
		double[] constante = new double[aum.length];
		for(int i = 0; i < aum.length; i ++) {
			constante[i] = aum[i][aum.length];
		}
		double[] producto = new double[aum.length];
		for(int i = 0; i < inversa.length; i ++) {
			for(int j = 0; j < constante.length; j ++) {
				producto[i] += inversa[i][j] * constante[j];
			}
		}
		System.out.println("\nSoluci�n del Sistema");
		for(int i = 0; i < aum.length; i ++) {
			System.out.println(lit[i]+" = "+redondeo(producto[i],6));
		}
		sc.close();
	}
	public static double[][] invertir(double[][] matriz) {
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
		for(int i = 0; i < aum.length; i ++) {
			double factor = aum[i][i];
			for(int j = i; j < aum[i].length; j ++) {
				aum[i][j] /= factor;
			}
			for(int x = 0; x < aum.length; x ++) {
				if(x == i) continue;
				double multiplo = aum[x][i];
				for(int y = i; y < aum[i].length; y ++) {
					aum[x][y] -= aum[i][y] * multiplo;
				}
			}
		}
		for(int i = 0; i < inversa.length; i ++) {
			for(int j = 0; j < inversa[i].length; j ++) {
				inversa[i][j] = aum[i][j + matriz[i].length];
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