package GaussLibro;
public class GaussLibro {
	public static void main(String[] args) {
		System.err.println("Método de Gauss (Libro: Algoritmo 6.1)");
		double[][] aum = {{1,1,1,50},{0,2,-1,0},{.1,.3,.5,16}};
		String[] lit = {"x","y","z","u"};
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
				if(j == aum[i].length - 2) {sp = "%-4s"; System.out.printf(sp,"|");}
			}
			System.out.println();
		}
		System.out.println("\n"+gauss(aum,lit));
	}
	public static String gauss(double[][] aum,String[] lit) {
		int n = aum.length - 1;
		for(int i = 0; i <= n - 1; i ++) {
			for(int j = i + 1; j <= n; j ++) {
				double mji = frac(aum[j][i],aum[i][i]);
				aum[j][i] = mji;
				for(int x = 0; x <= n; x ++) {
					double Ej_x = aum[j][x];
					aum[j][x] = Ej_x - mji*aum[i][x];
				}
			} 
			impAum(aum);
		}
		if(aum[n][n] == 0) return "Sin solución única";
		double[] solucion = new double[aum.length];
		solucion[n] = frac(aum[n][n+1],aum[n][n]);
		for(int i = n - 1; i >= 0; i --) {
			solucion[i] = aum[i][n+1];
			double aii = aum[i][i];
			for(int j = i; j <= n; j ++) {
				solucion[i] -= aum[i][j] * solucion[j];
			}
			solucion[i] /= aii;
		}
		String resultado = "Solución del Sistema";
		for(int i = 0; i < solucion.length; i ++) {
			resultado += "\n"+lit[i]+" = "+redondeo(solucion[i],6);
		}
		return resultado;
	}
	public static void impAum(double[][] aum) {
		System.out.println("\nMatriz de Aumentada");
		for(int i = 0; i < aum.length; i ++) {
			for(int j = 0; j < aum[i].length; j ++) {
				String sp = "%-8s";
				if(j >= aum[i].length - 2) sp = "%-6s";
				System.out.printf(sp,redondeo(aum[i][j],3));
				if(j == aum[i].length - 2) {sp = "%-4s"; System.out.printf(sp,"|");}
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