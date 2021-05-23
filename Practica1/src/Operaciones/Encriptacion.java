package Operaciones;
import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;
import Menus.Menu;
public class Encriptacion {
	public static int[][] codificado,ClaveA,ClaveB,oculto,encriptado;
	public static String[][] sobre;
	public static String[] filasA,filasB,columA,columB;
	public static String mensaje;
	public static int columnas;
	public static void Mensaje() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese el mensaje: ");
		mensaje = sc.nextLine();//LEE LA CADENA INGRESADA EN EL SISTEMA
		char[] hoja = mensaje.toCharArray();//CADENA A VECTOR
		columnas = hoja.length;//LONGITUD DEL VECTOR
		int letra=0;
		if(mensaje!="") {
			//AGREGAR POSICIONES FALTANTES EN EL ARREGLO PARA QUE SEA 3Xn
			while((columnas % 3) != 0) {
				columnas++;
			}
			sobre = new String[3][columnas/3];
			codificado = new int[3][columnas/3];
			//RECORRE EL ARREGLO
			for(int j=0; j<columnas/3; j++) {
				for(int i=0; i<3; i++) {
					try {
						//VECTOR A MATRIZ
						if(hoja[letra]==32) {
							sobre[i][j] = " ";
						}else {
							sobre[i][j] = String.valueOf(hoja[letra]);
						}
					}catch(Exception e) {
						//RELLENA POSICIONES ADICIONADAS
						sobre[i][j] = " ";
					}
					letra++;
				}
			}
			for(int i=0; i<3; i++) {
				for(int j=0; j<columnas/3; j++) {
					//CODIFICA LETRAS A NÚMEROS
					if(sobre[i][j].equals("A") || sobre[i][j].equals("a")) {
						codificado[i][j] = 0;
					}else if(sobre[i][j].equals("B") || sobre[i][j].equals("b")) {
						codificado[i][j] = 1;
					}else if(sobre[i][j].equals("C") || sobre[i][j].equals("c")) {
						codificado[i][j] = 2;
					}else if(sobre[i][j].equals("D") || sobre[i][j].equals("d")) {
						codificado[i][j] = 3;
					}else if(sobre[i][j].equals("E") || sobre[i][j].equals("e")) {
						codificado[i][j] = 4;
					}else if(sobre[i][j].equals("F") || sobre[i][j].equals("f")) {
						codificado[i][j] = 5;
					}else if(sobre[i][j].equals("G") || sobre[i][j].equals("g")) {
						codificado[i][j] = 6;
					}else if(sobre[i][j].equals("H") || sobre[i][j].equals("h")) {
						codificado[i][j] = 7;
					}else if(sobre[i][j].equals("I") || sobre[i][j].equals("i")) {
						codificado[i][j] = 8;
					}else if(sobre[i][j].equals("J") || sobre[i][j].equals("j")) {
						codificado[i][j] = 9;
					}else if(sobre[i][j].equals("K") || sobre[i][j].equals("k")) {
						codificado[i][j] = 10;
					}else if(sobre[i][j].equals("L") || sobre[i][j].equals("l")) {
						codificado[i][j] = 11;
					}else if(sobre[i][j].equals("M") || sobre[i][j].equals("m")) {
						codificado[i][j] = 12;
					}else if(sobre[i][j].equals("N") || sobre[i][j].equals("n")) {
						codificado[i][j] = 13;
					}else if(sobre[i][j].equals("Ñ") || sobre[i][j].equals("ñ")) {
						codificado[i][j] = 14;
					}else if(sobre[i][j].equals("O") || sobre[i][j].equals("o")) {
						codificado[i][j] = 15;
					}else if(sobre[i][j].equals("P") || sobre[i][j].equals("p")) {
						codificado[i][j] = 16;
					}else if(sobre[i][j].equals("Q") || sobre[i][j].equals("q")) {
						codificado[i][j] = 17;
					}else if(sobre[i][j].equals("R") || sobre[i][j].equals("r")) {
						codificado[i][j] = 18;
					}else if(sobre[i][j].equals("S") || sobre[i][j].equals("s")) {
						codificado[i][j] = 19;
					}else if(sobre[i][j].equals("T") || sobre[i][j].equals("t")) {
						codificado[i][j] = 20;
					}else if(sobre[i][j].equals("U") || sobre[i][j].equals("u")) {
						codificado[i][j] = 21;
					}else if(sobre[i][j].equals("V") || sobre[i][j].equals("v")) {
						codificado[i][j] = 22;
					}else if(sobre[i][j].equals("W") || sobre[i][j].equals("w")) {
						codificado[i][j] = 23;
					}else if(sobre[i][j].equals("X") || sobre[i][j].equals("x")) {
						codificado[i][j] = 24;
					}else if(sobre[i][j].equals("Y") || sobre[i][j].equals("y")) {
						codificado[i][j] = 25;
					}else if(sobre[i][j].equals("Z") || sobre[i][j].equals("z")) {
						codificado[i][j] = 26;
					}else {
						codificado[i][j] = 27;
					}
				}
			}
			System.out.println("El mensaje fue guardado exitosamente\n");
		}else{
			System.out.println("Debe insertar un mensaje\n");
			Encriptacion msg = new Encriptacion();
    		msg.Mensaje();
		}
	}
	public static void ClaveA() {
		Scanner sc = new Scanner(System.in);
		String ruta,data;
		System.out.print("Ingrese la ruta de matriz clave A: ");
		ruta=sc.next();
		try {
			File archA = new File(ruta);
			Scanner leerA = new Scanner(archA);
			data="";
			while(leerA.hasNextLine()) {
				data += leerA.nextLine()+"\n";
			}
			filasA = data.split("\n");
			columA=filasA[0].split(",");
			ClaveA = new int[filasA.length][columA.length];
			for(int i =0; i<filasA.length;i++) {
				columA=filasA[i].split(",");
				for(int j=0;j<columA.length;j++) {
					ClaveA[i][j]=Integer.parseInt(columA[j]);
				}
			}
			System.out.println("Clave A guardada\n");
			leerA.close();
		}catch(Exception e) {
			System.out.println("Ruta inválida\n");
			ClaveA();
		}
	}
	public static void ClaveB() {
		Scanner sc = new Scanner(System.in);
		String ruta,data;
		System.out.print("Ingrese la ruta de matriz clave B: ");
		ruta=sc.next();
		try {
			File archA = new File(ruta);
			Scanner leerB = new Scanner(archA);
			data="";
			while(leerB.hasNextLine()) {
				data += leerB.nextLine()+"\n";
			}
			filasB = data.split("\n");
			columB=filasB[0].split(",");
			ClaveB = new int[filasB.length][columB.length];
			for(int i =0; i<filasB.length;i++) {
				columB=filasB[i].split(",");
				for(int j=0;j<columB.length;j++) {
					ClaveB[i][j]=Integer.parseInt(columB[j]);
				}
			}
			System.out.println("Clave B guardada\n");
			leerB.close();
		}catch(Exception e) {
			System.out.println("Ruta inválida\n");
			ClaveB();
		}
	}
	public static void Encriptar() {
		encriptado = new int[3][columnas/3];
		oculto = new int[3][columnas/3];
		if(codificado!=null) {
			if(ClaveA!=null && ClaveB!=null) {
				for(int i=0; i<3; i++) {
					for(int j=0; j<(columnas/3); j++) {
						for(int k=0; k<3; k++) {
							oculto[i][j]+=ClaveA[i][k]*codificado[k][j];
						}
					}
				}
				for(int i=0; i<3; i++) {
					for(int j=0; j<(columnas/3); j++) {
						encriptado[i][j]=oculto[i][j]+ClaveB[i][j];
					}
				}
				System.out.println("Mensaje Encriptado");
				for(int j=0; j<(columnas/3); j++) {
					for(int i=0; i<3; i++) {
						System.out.print(encriptado[i][j]+"  ");
					}
				}
				System.out.println("\n");
				Menu menu = new Menu();
				menu.main(null);
			}else {
				System.out.println("No se han cargado todas las matrices clave\n");
			}
		}else {
				System.out.println("No se ha ingresado un mensaje aún\n");
		}
	}
}