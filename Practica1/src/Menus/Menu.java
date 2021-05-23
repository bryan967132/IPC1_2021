package Menus;
import java.util.InputMismatchException;
import java.util.Scanner;
import Operaciones.Desencriptacion;
import Reportes.*;
public class Menu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int opcion=0;
        while (opcion!=5) {
        	System.out.println("Menú");
            System.out.println("1. Encriptar");
            System.out.println("2. Desencriptar");
            System.out.println("3. Ataque Con Texto Claro");
            System.out.println("4. Generar Reportes");
            System.out.println("5. Salir");
            try {
                System.out.print("Elija una opción: ");
                opcion = sc.nextInt();
                System.out.println();
                switch (opcion) {
                    case 1:
                        MenuEncriptar encriptar = new MenuEncriptar();
                        encriptar.Menu();
                        break;
                    case 2:
                        Desencriptacion desencriptar = new Desencriptacion();
                        desencriptar.Desencriptar();
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        break;
                    case 4:
                        MenuReportes reportar = new MenuReportes();
                        reportar.Menu();
                        break;
                    case 5:
                    	System.exit(0);
                    	System.out.println("¡Finalizado!");
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sc.next();
            }
        }
	}
}