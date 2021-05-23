package AsignacionCurso;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class AsignacionCurso implements Serializable {
	private static final long serialVersionUID = 1L;
	public static int[][] listado = new int[50][52];
	public static void Serializar() {
		try {
			FileOutputStream archivo = new FileOutputStream("Serializados/Salon");
			ObjectOutputStream convertir = new ObjectOutputStream(archivo);
			convertir.writeObject(listado);
			convertir.close();
		}catch(Exception e) {
		}
	}
	public static void Deserializar() {
		try {
			FileInputStream lector = new FileInputStream("Serializados/Salon");
			ObjectInputStream regresar = new ObjectInputStream(lector);
			int[][] cur = (int[][])regresar.readObject();
			regresar.close();
			for(int i=0; i<50; i++) {
				for(int j=0; j<52; j++) {
					listado[i][j]=cur[i][j];
				}
			}
		}catch(Exception e) {
		}
	}
}