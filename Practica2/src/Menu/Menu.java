package Menu;
import java.util.InputMismatchException;
import java.util.Scanner;
import ActividadComida.ControladorComer;
import Alimentos.ControladorAlimento;
import AsignacionPokeballs.Asignar;
import AsignacionPokeballs.ControladorAsigPbl;
import AsignacionPokemons.ControladorAsigPkm;
import Entrenadores.ControladorEntrenador;
import Gimnasios.ControladorGimnasio;
import Peleas.ControladorPelea;
import Pokeballs.ControladorPokeball;
import Pokemons.ControladorPokemon;
import Reportes.*;
public class Menu {
	public static void main(String[] args) {
		ControladorPokemon desPok = new ControladorPokemon();
		ControladorEntrenador desEnt = new ControladorEntrenador();
		ControladorPokeball desPbl = new ControladorPokeball();
		ControladorGimnasio desGym = new ControladorGimnasio();
		ControladorAlimento desAli = new ControladorAlimento();
		ControladorAsigPkm desAPk = new ControladorAsigPkm();
		ControladorAsigPbl desAPl = new ControladorAsigPbl();
		ControladorComer desCom = new ControladorComer();
		ControladorPelea desPel = new ControladorPelea();
		Asignar guarPk = new Asignar(); 
		desPok.Deserializar();
		desPbl.Deserializar();
		desEnt.Deserializar();
		desGym.Deserializar();
		desAli.Deserializar();
		desAPk.Deserializar();
		desAPl.Deserializar();
		desCom.Deserializar();
		desPel.Deserializar();
		guarPk.Deserializar();
		menu();
	}
	public static void menu() {
		Scanner sc = new Scanner(System.in);
        int opcion=0;
        String ruta;
        while (opcion!=12) {
        	System.out.println("Menu");
            System.out.println("1. Cargar Pokémons");
            System.out.println("2. Cargar Entrenadores");
            System.out.println("3. Cargar Pokéballs");
            System.out.println("4. Cargar Gimnasios");
            System.out.println("5. Cargar Alimentos");
            System.out.println("6. Asignar Pokémons");
            System.out.println("7. Asignar Pokéballs");
            System.out.println("8. Asignar Actividad de Comida");
            System.out.println("9. Asignar Actividad de Pelea");
            System.out.println("10. Reportes");
            System.out.println("11. Actividades");
            System.out.println("12. Salir");
            try {
                System.out.print("Elija una opción: ");
                opcion = sc.nextInt();
                System.out.println();
                switch (opcion) {
                    case 1:
                    	System.out.print("Ingrese la ruta de los Pókemon: ");
                    	ruta = sc.next();
                    	System.out.println();
                    	ControladorPokemon regPokemon = new ControladorPokemon(); 
                    	regPokemon.cargamasiva(ruta);
                    	break;
                    case 2:
                    	System.out.print("Ingrese la ruta de los Entrenadores: ");
                    	ruta = sc.next();
                    	System.out.println();
                    	ControladorEntrenador regEntrenador = new ControladorEntrenador();
                    	regEntrenador.cargamasiva(ruta);
                        break;
                    case 3:
                    	System.out.print("Ingrese la ruta de las Pokeballs: ");
                    	ruta = sc.next();
                    	System.out.println();
                    	ControladorPokeball regPokeball = new ControladorPokeball();
                    	regPokeball.cargamasiva(ruta);
                        break;
                    case 4:
                    	System.out.print("Ingrese la ruta de los Gimnasios: ");
                    	ruta = sc.next();
                    	System.out.println();
                    	ControladorGimnasio regGimnasio = new ControladorGimnasio();
                    	regGimnasio.cargamasiva(ruta);
                        break;
                    case 5:
                    	System.out.print("Ingrese la ruta de los Alimentos: ");
                    	ruta = sc.next();
                    	System.out.println();
                    	ControladorAlimento regAlimento = new ControladorAlimento();
                    	regAlimento.cargamasiva(ruta);
                    	break;
                    case 6:
                    	System.out.print("Ingrese la ruta de Asignacion de Pokemons: ");
                    	ruta = sc.next();
                    	System.out.println();
                    	ControladorAsigPkm regAPkm = new ControladorAsigPkm();
                    	regAPkm.cargamasiva(ruta);
                    	break;
                    case 7:
                    	System.out.print("Ingrese la ruta de Asignacion de Pokeballs: ");
                    	ruta = sc.next();
                    	System.out.println();
                    	ControladorAsigPbl regAPlb = new ControladorAsigPbl();
                    	regAPlb.cargamasiva(ruta);
                    	break;
                    case 8:
                    	System.out.print("Ingrese la ruta de Asignacion de los Alimentos: ");
                    	ruta = sc.next();
                    	System.out.println();
                    	ControladorComer regComer = new ControladorComer();
                    	regComer.cargamasiva(ruta);
                    	break;
                    case 9:
                    	System.out.print("Ingrese la ruta de las Peleas: ");
                    	ruta = sc.next();
                    	System.out.println();
                    	ControladorPelea regPelea = new ControladorPelea();
                    	regPelea.cargamasiva(ruta);
                    	break;
                    case 10:
                    	mReportes();
                    	break;
                    case 11:
                    	mActividades();
                    	break;
                    case 12:
                    	System.out.println("¡Finalizado!");
                    	System.exit(0);
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 10");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sc.next();
            }
        }
	}
	public static void mReportes() {
		Scanner sc = new Scanner(System.in);
        int opcion=0;
        while (opcion!=7) {
        	System.out.println("Menu Reportes");
            System.out.println("1. Reporte de Entrenadores");
            System.out.println("2. Reporte de Pokémons Salvajes");
            System.out.println("3. Reporte de Comidas");
            System.out.println("4. Reporte de Peleas");
            System.out.println("5. Top 5 de Pokémons");
            System.out.println("6. Top 5 de Alimentos");
            System.out.println("7. Regresar");
            try {
                System.out.print("Elija una opción: ");
                opcion = sc.nextInt();
                System.out.println();
                switch (opcion) {
                    case 1:
                    	ReporteEntrenadores repEnt = new ReporteEntrenadores();
                    	repEnt.reportar();
                    	break;
                    case 2:
                    	ReportePokemonsSalvajes repPok = new ReportePokemonsSalvajes();
                    	repPok.reportar();
                    	break;
                    case 3:
                    	ReporteAlimentar repAli = new ReporteAlimentar();
                    	repAli.reportar();
                    	break;
                    case 4:
                    	ReportePeleas repPel = new ReportePeleas();
                    	repPel.reportar();
                    	break;
                    case 5:
                    	ReporteTopPokemons repToP = new ReporteTopPokemons();
                    	repToP.reportar();
                    	break;
                    case 6:
                    	ReporteTopAlimentos repToA = new ReporteTopAlimentos();
                    	repToA.reportar();
                    	break;
                    case 7:
                    	menu();
                    	break;
                    default:
                    	System.out.println("Solo números entre 1 y 6");
                }
            }catch(Exception e) {
            	System.out.println("Debes insertar un número");
                sc.next();
            }
        }
	}
	public static void mActividades() {
		Scanner sc = new Scanner(System.in);
        int opcion=0;
        while (opcion!=4) {
        	System.out.println("Menu Actividades");
            System.out.println("1. Alimentarlos");
            System.out.println("2. Enfrentarlos");
            System.out.println("3. Resumen de las Peleas");
            System.out.println("4. Volver");
            try {
                System.out.print("Elija una opción: ");
                opcion = sc.nextInt();
                System.out.println();
                switch (opcion) {
                    case 1:
                    	ControladorComer regComer = new ControladorComer();
                    	regComer.imprimir();
                    	menu();
                    	break;
                    case 2:
                    	ControladorPelea regPelea = new ControladorPelea();
                    	regPelea.imprimir();
                    	menu();
                    	break;
                    case 3:
                    	ControladorPelea resumen = new ControladorPelea();
                    	resumen.resumen();
                    	menu();
                    	break;
                    case 4:
                    	break;
                    default:
                    	System.out.println("Solo números entre 1 y 2");
                }
            }catch(Exception e) {
            	System.out.println("Debes insertar un número");
                sc.next();
            }
        }
	}
}