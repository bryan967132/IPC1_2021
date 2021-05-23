package Operaciones;
import static Operaciones.Encriptacion.*;
public class Desencriptacion {
	public static double[][] inversa,desencriptado;
	public static int[][] transpuesta,adjunta;
	public static String[][] decodificado;
	public static double determinante;
	public static int x,y,z,m00,m01,m02,m10,m11,m12,m20,m21,m22;
	public static void Desencriptar() {
		if(codificado!=null) {
			if(ClaveA!=null && ClaveB!=null) {
				inversa = new double[3][3];
				desencriptado = new double[3][columnas/3];
				transpuesta = new int[3][3];
				adjunta = new int[3][3];
				decodificado = new String[3][columnas/3];
				x=ClaveA[0][0]*((ClaveA[1][1]*ClaveA[2][2])-(ClaveA[1][2]*ClaveA[2][1]));
				y=ClaveA[0][1]*((ClaveA[1][0]*ClaveA[2][2])-(ClaveA[1][2]*ClaveA[2][0]));
				z=ClaveA[0][2]*((ClaveA[1][0]*ClaveA[2][1])-(ClaveA[1][1]*ClaveA[2][0]));
				determinante=x-y+z;
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						transpuesta[i][j]=ClaveA[j][i];
					}
				}
				m00=(transpuesta[1][1]*transpuesta[2][2])-(transpuesta[1][2]*transpuesta[2][1]);
				m01=(transpuesta[1][0]*transpuesta[2][2])-(transpuesta[1][2]*transpuesta[2][0]);
				m02=(transpuesta[1][0]*transpuesta[2][1])-(transpuesta[1][1]*transpuesta[2][0]);
				m10=(transpuesta[0][1]*transpuesta[2][2])-(transpuesta[0][2]*transpuesta[2][1]);
				m11=(transpuesta[0][0]*transpuesta[2][2])-(transpuesta[0][2]*transpuesta[2][0]);
				m12=(transpuesta[0][0]*transpuesta[2][1])-(transpuesta[0][1]*transpuesta[2][0]);
				m20=(transpuesta[0][1]*transpuesta[1][2])-(transpuesta[0][2]*transpuesta[1][1]);
				m21=(transpuesta[0][0]*transpuesta[1][2])-(transpuesta[0][2]*transpuesta[1][0]);
				m22=(transpuesta[0][0]*transpuesta[1][1])-(transpuesta[0][1]*transpuesta[1][0]);
				adjunta[0][0]=(+m00);
				adjunta[0][1]=(-m01);
				adjunta[0][2]=(+m02);
				adjunta[1][0]=(-m10);
				adjunta[1][1]=(+m11);
				adjunta[1][2]=(-m12);
				adjunta[2][0]=(+m20);
				adjunta[2][1]=(-m21);
				adjunta[2][2]=(+m22);
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						inversa[i][j]=(adjunta[i][j]/determinante);
					}
				}
				for(int i=0; i<3; i++) {
					for(int j=0; j<(columnas/3); j++) {
						for(int k=0; k<3; k++) {
							desencriptado[i][j]+=inversa[i][k]*(encriptado[k][j]-ClaveB[k][j]);
						}
						if(Math.round(desencriptado[i][j])==0) {
							decodificado[i][j]="a";
						}else if(Math.round(desencriptado[i][j])==1) {
							decodificado[i][j]="b";
						}else if(Math.round(desencriptado[i][j])==2) {
							decodificado[i][j]="c";
						}else if(Math.round(desencriptado[i][j])==3) {
							decodificado[i][j]="d";
						}else if(Math.round(desencriptado[i][j])==4) {
							decodificado[i][j]="e";
						}else if(Math.round(desencriptado[i][j])==5) {
							decodificado[i][j]="f";
						}else if(Math.round(desencriptado[i][j])==6) {
							decodificado[i][j]="g";
						}else if(Math.round(desencriptado[i][j])==7) {
							decodificado[i][j]="h";
						}else if(Math.round(desencriptado[i][j])==8) {
							decodificado[i][j]="i";
						}else if(Math.round(desencriptado[i][j])==9) {
							decodificado[i][j]="j";
						}else if(Math.round(desencriptado[i][j])==10) {
							decodificado[i][j]="k";
						}else if(Math.round(desencriptado[i][j])==11) {
							decodificado[i][j]="l";
						}else if(Math.round(desencriptado[i][j])==12) {
							decodificado[i][j]="m";
						}else if(Math.round(desencriptado[i][j])==13) {
							decodificado[i][j]="n";
						}else if(Math.round(desencriptado[i][j])==14) {
							decodificado[i][j]="ñ";
						}else if(Math.round(desencriptado[i][j])==15) {
							decodificado[i][j]="o";
						}else if(Math.round(desencriptado[i][j])==16) {
							decodificado[i][j]="p";
						}else if(Math.round(desencriptado[i][j])==17) {
							decodificado[i][j]="q";
						}else if(Math.round(desencriptado[i][j])==18) {
							decodificado[i][j]="r";
						}else if(Math.round(desencriptado[i][j])==19) {
							decodificado[i][j]="s";
						}else if(Math.round(desencriptado[i][j])==20) {
							decodificado[i][j]="t";
						}else if(Math.round(desencriptado[i][j])==21) {
							decodificado[i][j]="u";
						}else if(Math.round(desencriptado[i][j])==22) {
							decodificado[i][j]="v";
						}else if(Math.round(desencriptado[i][j])==23) {
							decodificado[i][j]="w";
						}else if(Math.round(desencriptado[i][j])==24) {
							decodificado[i][j]="x";
						}else if(Math.round(desencriptado[i][j])==25) {
							decodificado[i][j]="y";
						}else if(Math.round(desencriptado[i][j])==26) {
							decodificado[i][j]="z";
						}else{
							decodificado[i][j]=" ";
						}
					}
				}
				System.out.print("Mensaje Desencriptado: ");
				for(int j=0; j<(columnas/3); j++) {
					for(int i=0; i<3; i++) {
						System.out.print(decodificado[i][j]);
					}
				}
				System.out.println("\n");
			}else {
				System.out.println("No se han cargado todas las matrices clave\n");
			}
		}else {
				System.out.println("No se ha ingresado un mensaje aún\n");
		}
	}
}