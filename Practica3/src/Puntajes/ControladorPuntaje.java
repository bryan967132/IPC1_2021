package Puntajes;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class ControladorPuntaje {
	public static Puntaje[] ranking = new Puntaje[6];
	public static void Serializar() {
		try {
			FileOutputStream archivo = new FileOutputStream("puntajes/JugadoresTop");
			ObjectOutputStream convertir = new ObjectOutputStream(archivo);
			convertir.writeObject(ranking);
			convertir.close();
		}catch(Exception e) {
		}
	}
	public static void Deserializar() {
		try {
			FileInputStream lector = new FileInputStream("puntajes/JugadoresTop");
			ObjectInputStream regresar = new ObjectInputStream(lector);
			Puntaje[] player = (Puntaje[])regresar.readObject();
			regresar.close();
			for(int i = 0; i < ranking.length-1; i++) {
				ranking[i] = player[i];
			}
		}catch(Exception e) {
		}
	}
	public static void ordenado() {
		try {
			for(int i = 0; i < ranking.length-1; i++) {
				for(int j = 0; j < ranking.length-i-1; j++) {
					if(ranking[j].getPuntos() < ranking[j+1].getPuntos()) {
						Puntaje aux = ranking[j+1];
						ranking[j+1] = ranking[j];
						ranking[j] = aux;
					}
				}
			}
		}catch(Exception e) {
		}
	}
	public boolean insertarJugador(String nombre,int puntos) {
		for(int i = 0; i < ranking.length; i++) {
			if(ranking[i] == null) {
				ranking[i] = new Puntaje(nombre,puntos);
				ordenado();
				Serializar();
				Deserializar();
				return true;
			}
		}
		return false;
	}
	public static void imprimirTopJugadores() {
		for(int i = 0; i < ranking.length; i++) {
			if(ranking[i] != null) {
				System.out.println((i+1)+".- "+ranking[i].getNombre()+" "+ranking[i].getPuntos()+" Pts");
			}
		}
	}
}