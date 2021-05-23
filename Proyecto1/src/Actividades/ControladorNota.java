package Actividades;
import static ProfCur.GestionarCurso.desc;
import static ProfCur.GestionarCurso.nom;
import static ProfCur.GestionarCurso.notas;
import static ProfCur.GestionarCurso.pnd;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class ControladorNota {
	public static NotaActividad[] nota = new NotaActividad[1000];
	public static void Serializar() {
		try {
			FileOutputStream archivo = new FileOutputStream("Serializados/Notas");
			ObjectOutputStream convertir = new ObjectOutputStream(archivo);
			convertir.writeObject(nota);
			convertir.close();
		}catch(Exception e) {
		}
	}
	public static void Deserializar() {
		try {
			FileInputStream lector = new FileInputStream("Serializados/Notas");
			ObjectInputStream regresar = new ObjectInputStream(lector);
			NotaActividad[] notas = (NotaActividad[])regresar.readObject();
			regresar.close();
			for(int i=0; i<nota.length; i++) {
				nota[i]=notas[i];
			}
		}catch(Exception e) {
		}
	}
	public void cargamasiva(String ruta,int cur,int act) {
		try {					
			File archivo = new File(ruta);
			Scanner reader = new Scanner(archivo);
			String[] actual;
			NotaActividad nota;
			reader.nextLine();
			while(reader.hasNextLine()) {
				actual = reader.nextLine().split(",");
				nota = new NotaActividad(Integer.parseInt(actual[0]),cur,act,Double.valueOf(actual[1]));
				if(!this.agregarNota(nota));
			}
			Serializar();
			reader.close();
			ControladorActividad crear = new ControladorActividad();
			crear.insertarActividad(cur,act,nom.getText(),desc.getText(),Double.valueOf(pnd.getText()));	
			nom.setText("");
			desc.setText("");
			pnd.setText("");
			notas.setText("");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"El archivo no se encuentra en la ruta especificada");
			notas.setText("");
		}
	}
	public boolean agregarNota(NotaActividad nt) {
		for(int i=0; i<nota.length; i++) {
			if(nota[i]==null) {
				nota[i]=nt;
				return true;
			}
		}
		return false;
	}
}