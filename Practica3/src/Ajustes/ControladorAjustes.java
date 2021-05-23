package Ajustes;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class ControladorAjustes {
	public static Ajustes[] config = new Ajustes[1];
	public static void Serializar() {
		try {
			FileOutputStream archivo = new FileOutputStream("ajustes/Ajustes");
			ObjectOutputStream convertir = new ObjectOutputStream(archivo);
			convertir.writeObject(config);
			convertir.close();
		}catch(Exception e) {
		}
	}
	public static void Deserializar() {
		try {
			FileInputStream lector = new FileInputStream("ajustes/Ajustes");
			ObjectInputStream regresar = new ObjectInputStream(lector);
			Ajustes[] setting = (Ajustes[])regresar.readObject();
			regresar.close();
			for(int i=0; i<config.length; i++) {
				config[i]=setting[i];
			}
		}catch(Exception e) {
		}
	}
	public static void configurar(boolean i1,boolean i2,boolean i3,boolean i4,boolean i5,boolean i6,String f,String v,int t) {
		config[0] = new Ajustes(i1,i2,i3,i4,i5,i6,f,v,t);
	}
	public static void imprimirAjustes() {
		for(int i=0; i<config.length; i++) {
			System.out.println("Item Tiempo (+): "+config[i].getIt1());
			System.out.println("Item Puntos (+): "+config[i].getIt2());
			System.out.println("Item Velocidad (+): "+config[i].getIt3());
			System.out.println("Item Tiempo (-): "+config[i].getIt4());
			System.out.println("Item Puntos (-): "+config[i].getIt5());
			System.out.println("Item Velocidad (-): "+config[i].getIt6());
			System.out.println("Frecuencia Items: "+config[i].getFre());
			System.out.println("Velocidad: "+config[i].getVel());
			System.out.println("Tiempo: "+config[i].getTmp());
		}
	}
}