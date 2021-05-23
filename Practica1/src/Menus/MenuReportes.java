package Menus;
import java.util.InputMismatchException;
import java.util.Scanner;
import Reportes.*;
public class MenuReportes {
	public static void Menu() {
		Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        while (!salir) {
        	System.out.println("Menú Reportes");
            System.out.println("1. Reporte Encriptacion");
            System.out.println("2. Reporte Desencriptacion");
            System.out.println("3. Volver");
            try {
            	System.out.print("Elija una opción: ");
                opcion = sc.nextInt();
                System.out.println();
                switch (opcion) {
                    case 1:
                		ReporteEncriptacion reporte1 = new ReporteEncriptacion();
                		reporte1.Reportando();
                        break;
                    case 2:
                    	ReporteDesencriptacion reporte2 = new ReporteDesencriptacion();
                		reporte2.Reportando();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo solo 1 o 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sc.next();
            }
        }
	}
}
