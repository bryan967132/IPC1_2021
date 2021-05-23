package ProfCur;
import static AsignacionCurso.AsignacionCurso.*;
import static DTT.InicioProf.*;
import static Interfaz.Colores.*;

import javax.swing.*;
public class PCur {
	public static JPanel fondo1;
	public static void GenerarBtnCursos() {
		fondo1 = new JPanel();
		fondo1.setBounds(0,0,762,517);
		fondo1.setBackground(blanco);
		fondo1.setLayout(null);
		fondo1.setVisible(true);
		try {
			int s=1;
			for(int i=0; i<50; i++) {
				if(listado[i][1]==getCodigo()) {
					for(int x=0; x<5;) {
						for(int j=0; j<2;) {
							if(s==1) {
								fondo1.add(new PBtnCur(listado[i][0],330*j,100*s-100));
								s++;
							}else if(s==2) {
								fondo1.add(new PBtnCur(listado[i][0],330*j+330,100*s-200));
								s++;
							}else if(s==3) {
								fondo1.add(new PBtnCur(listado[i][0],330*j,100*s-200));
								s++;
							}else if(s==4) {
								fondo1.add(new PBtnCur(listado[i][0],330*j+330,100*s-300));
								s++;
							}else if(s==5) {
								fondo1.add(new PBtnCur(listado[i][0],330*j,100*s-300));
								s++;
							}else if(s==6) {
								fondo1.add(new PBtnCur(listado[i][0],330*j+330,100*s-400));
								s++;
							}else if(s==7) {
								fondo1.add(new PBtnCur(listado[i][0],330*j,100*s-400));
								s++;
							}else if(s==8) {
								fondo1.add(new PBtnCur(listado[i][0],330*j+330,100*s-500));
								s++;
							}else if(s==9) {
								fondo1.add(new PBtnCur(listado[i][0],330*j,100*s-500));
								s++;
							}else {
								fondo1.add(new PBtnCur(listado[i][0],330*j+330,100*s-600));
								s++;
							}
							break;
						}
						break;
					}
				}
			}
		}catch(Exception e) {
		}
		panel1.add(fondo1);
	}
}