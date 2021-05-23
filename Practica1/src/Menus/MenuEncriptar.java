package Menus;
import java.util.InputMismatchException;
import java.util.Scanner;
import Operaciones.Encriptacion;
public class MenuEncriptar {
	public static void Menu() {
		Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        while (!salir) {
        	System.out.println("Menú Encriptar");
            System.out.println("1. Ingreso Mensaje");
            System.out.println("2. Ingreso Matriz Clave A");
            System.out.println("3. Ingreso Matriz Clave B");
            System.out.println("4. Encriptar");
            System.out.println("5. Volver");
            try {
            	System.out.print("Elija una opción: ");
                opcion = sc.nextInt();
                System.out.println();
                switch (opcion) {
                    case 1:
                		Encriptacion mensaje = new Encriptacion();
                		mensaje.Mensaje();
                        break;
                    case 2:
                    	Encriptacion claveA = new Encriptacion();
                		claveA.ClaveA();
                        break;
                    case 3:
                    	Encriptacion claveB = new Encriptacion();
                		claveB.ClaveB();
                        break;
                    case 4:
                    	Encriptacion encriptar = new Encriptacion();
                    	encriptar.Encriptar();
                        break;
                    case 5:
                        salir = true;
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