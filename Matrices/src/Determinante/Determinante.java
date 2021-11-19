package Determinante;
public class Determinante {
    static int determinante;
    static int matriz[][] = {{1,0,0,-2},{5,-20,5,0},{0,-1,0,1},{2,3,-3,1}};
    public static void main(String[] args) {
        determinante = determinanteMatriz(matriz,matriz.length);
        System.out.println(determinante);
    }
    public static int determinanteMatriz(int matriz[][], int n_prueba) {
        int repuesta = 0;
        switch (n_prueba) {
            case 2:
                repuesta = ((matriz[0][0] * matriz[1][1]) - (matriz[1][0] * matriz[0][1]));
                break;
            case 3:
                repuesta = ((matriz[0][0]) * (matriz[1][1]) * (matriz[2][2])
                        + (matriz[1][0]) * (matriz[2][1]) * (matriz[0][2])
                        + (matriz[2][0]) * (matriz[0][1]) * (matriz[1][2]))
                        - ((matriz[2][0]) * (matriz[1][1]) * (matriz[0][2])
                                + (matriz[1][0]) * (matriz[0][1]) * (matriz[2][2])
                                + (matriz[0][0]) * (matriz[2][1]) * (matriz[1][2]));
                break;
            default:
                for (int z = 0; z < matriz.length; z++) {
                    repuesta += (matriz[z][0] * adj(matriz,z,0));
                }
        }
        return repuesta;
    }
    public static int adj(int matriz[][], int i, int j) {
        int adjunto;
        int matriz1[][] = new int[matriz.length - 1][matriz.length - 1];
        int m, n;
        for (int k = 0; k < matriz1.length; k++) {
            if (k < i) {
                m = k;
            } else {
                m = k + 1;
            }
            for (int l = 0; l < matriz1.length; l++) {
                if (l < j) {
                    n = l;
                } else {
                    n = l + 1;
                }
                matriz1[k][l] = matriz[m][n];
            }
        }
        adjunto = (int) Math.pow(-1, i + j) * determinanteMatriz(matriz1, matriz1.length);
        return adjunto;
    }
}