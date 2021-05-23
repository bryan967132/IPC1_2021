package Actividades;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;
public class ControladorActividad {
	public static Actividad[] actividad = new Actividad[1000];
	public static void Serializar() {
		try {
			FileOutputStream archivo = new FileOutputStream("Serializados/Actividades");
			ObjectOutputStream convertir = new ObjectOutputStream(archivo);
			convertir.writeObject(actividad);
			convertir.close();
		}catch(Exception e) {
		}
	}
	public static void Deserializar() {
		try {
			FileInputStream lector = new FileInputStream("Serializados/Actividades");
			ObjectInputStream regresar = new ObjectInputStream(lector);
			Actividad[] act = (Actividad[])regresar.readObject();
			regresar.close();
			for(int i=0; i<actividad.length; i++) {
				actividad[i]=act[i];
			}
		}catch(Exception e) {
		}
	}
	public boolean verificarAcumulado(int cur,double pnd) {
		if(pnd==0) {
			JOptionPane.showMessageDialog(null,"La ponderación debe ser diferente de cero");
			return true;
		}
		double acumulado=0;
		for(int i=0; i<actividad.length; i++) {
			if(actividad[i]!=null && actividad[i].getCurso()==cur) {
				double prueba = 0;
				acumulado+=actividad[i].getPonderacion();
				prueba = acumulado + pnd;
				if(prueba>100) {
					JOptionPane.showMessageDialog(null,"El acumulado de ponderación no debe exceder los 100 pts.");
					return true;
				}
			}
		}
		return false;
	}
	public boolean insertarActividad(int cur,int cod,String nom,String desc,double pnd) {
		if(verificarAcumulado(cur,pnd))return true;
		for(int i=0; i<actividad.length; i++) {
			if(actividad[i]==null) {
				actividad[i] = new Actividad(cur,cod,nom,desc,pnd);
				Serializar();
				return true;
			}
		}
		return false;
	}
}