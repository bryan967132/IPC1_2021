package GaussSiedel;
public class GaussSiedelEstatico {
	public static void main(String[] args) {
		System.err.println("Método Iterativo de Gauss-Siedel");
		double[][] aum = {{8,2,1,5.8},{2,8,1,4.6},{1,-2,8,1.4}};
		String[] lit = {"x1","x2","x3"};
		double[] x = {0,0,0,0};
		double tolerancia = 0.00001;
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
		System.out.println("\nTOL = "+tolerancia);
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
		System.out.println("\n"+gausssiedel(aum,x,lit,tolerancia));
	}
	public static String gausssiedel(double[][] aum,double[] x,String[] lit,double tolerancia) {
		double[] solucion = new double[aum.length];
		double[] dif = new double[aum.length];
		int iteraciones = 1;
		do {
			double[] aux = new double[x.length];
			for(int i = 0; i < aux.length; i ++) {
				aux[i] = x[i];
			}
			for(int i = 0; i < aum.length; i ++) {
				solucion[i] = aum[i][aum[i].length - 1];
				for(int j = 0; j < aum[i].length - 1; j ++) {
					if(j == i) continue;
					solucion[i] -= aum[i][j]*x[j];
				}
				solucion[i] /= aum[i][i];
				x[i] = solucion[i];
			}
			System.out.println("\nIteración "+iteraciones);
			for(int i = 0; i < solucion.length; i ++) {
				System.out.printf("%-16s",lit[i]+" = "+redondeo(solucion[i],6));
			}
			for(int i = 0; i < solucion.length; i ++) {
				dif[i] = abs(solucion[i]-aux[i]);
			}
			double linfinito = linfinity(dif);
			System.out.println("||X"+iteraciones+" - X"+(iteraciones - 1)+"||∞ = "+redondeo(linfinito,6));
			if(linfinito < tolerancia) {
				String resultado = "";
				for(int i = 0; i < solucion.length; i ++) {
					resultado += "\n"+lit[i]+" = "+redondeo(solucion[i],6);
				}
				return "Procedimiento exitoso"+resultado;
			}
			for(int i = 0; i < solucion.length; i ++) {
				x[i] = solucion[i];
			}
			iteraciones++;
		} while(iteraciones <= 300);
		return "Sin éxito";
	}
	public static double linfinity(double[] dif) {
		for(int i = 0; i < dif.length; i ++) {
			for(int x = 0; x < dif.length - i - 1; x ++) {
				if(dif[x] < dif[x + 1]) {
					double tmp = dif[x + 1];
					dif[x + 1] = dif[x];
					dif[x] = tmp;
				}
			}
		}
		return dif[0];
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