package ListasExportadas;
import static Alumnos.ControladorAlumno.alumno;
import static Actividades.ControladorActividad.actividad;
import static Actividades.ControladorNota.nota;
import static Interfaz.Fuentes.*;
import static Interfaz.Colores.*;
import static AsignacionCurso.AsignacionCurso.listado;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
public class Top5Peores {
	private int alu;
	private double acum;
	public Top5Peores(int alu,double acum) {
		this.setAlu(alu);
		this.setAcum(acum);
	}
	public static void Exportar(int cur,String nom) {
		try {
			Document document = new Document(PageSize.LETTER.rotate());
            PdfWriter.getInstance(document, new FileOutputStream("Listados/Top5Peores.pdf"));
            document.open();
            addTitlePage(document,cur,nom);
            document.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"No se ha podido exportado la lista");
		}
	}
	private static void addTitlePage(Document document,int cur,String nom)
            throws DocumentException {
        int l=0;
        for(int i=0; i<nota.length; i++) {
        	if(nota[i]!=null && nota[i].getCodCur()==cur) {
        		l++;
        	}
        }
        
        Top5Mejores[] top = new Top5Mejores[l];
        int f=0;
        double punteo=0;
        double notaA=0;
        
        for(int i=0; i<50; i++) {
        	if(listado[i][0]!=0 && listado[i][0]==cur) {
        		for(int j=2; j<52; j++) {
        			if(listado[i][j]!=0) {
        				for(int x=0; x<nota.length; x++) {
        					if(nota[x]!=null && nota[x].getCodAlu()==listado[i][j]) {
        						for(int y=0; y<actividad.length; y++) {
        							if(actividad[y]!=null &&
        							   actividad[y].getCurso()==listado[i][0] &&
        							   actividad[y].getCodigo()==nota[x].getCodAct()) {
        								notaA=actividad[y].getPonderacion();
        								punteo+=notaA*nota[x].getNota();
        							}
        						}
        					}
        				}
        				top[f]=new Top5Mejores(listado[i][j],punteo/100);
        				f++;
        				punteo=0;
        			}
        		}
        	}
        }
        try {
	        for(int i=1; i<top.length; i++) {
	        	for(int j=i-1; j>=0; j--) {
	        		if(top[i].getAcum()<top[j].getAcum()) {
	        			Top5Mejores temp = top[i];
	        			top[i] = top[j];
	        			top[j] = temp;
	        			i--;
	        		}
	        	}
	        }
        }catch(Exception e) {
        	
        }
        Paragraph preface = new Paragraph();
        preface.add(new Paragraph("Alumnos Con Peor Desempeño En "+nom,catFont));
        addEmptyLine(preface,1);
        document.add(preface);
        
        PdfPTable tabla = new PdfPTable(7);
        tabla.setWidthPercentage(100f);
        
        PdfPCell columnas = new PdfPCell(new Phrase("Top",subFont));
        columnas.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnas.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnas.setBackgroundColor(FondoH);
        columnas.setBorderColor(BordeH);
        columnas.setPaddingBottom(5);
        columnas.setMinimumHeight(30);
        tabla.addCell(columnas);

        columnas = new PdfPCell(new Phrase("Código",subFont));
        columnas.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnas.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnas.setBackgroundColor(FondoH);
        columnas.setBorderColor(BordeH);
        columnas.setPaddingBottom(5);
        tabla.addCell(columnas);

        columnas = new PdfPCell(new Phrase("Nombre",subFont));
        columnas.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnas.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnas.setBackgroundColor(FondoH);
        columnas.setBorderColor(BordeH);
        columnas.setPaddingBottom(5);
        tabla.addCell(columnas);
        
        columnas = new PdfPCell(new Phrase("Apellido",subFont));
        columnas.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnas.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnas.setBackgroundColor(FondoH);
        columnas.setBorderColor(BordeH);
        columnas.setPaddingBottom(5);
        tabla.addCell(columnas);
        
        columnas = new PdfPCell(new Phrase("Correo",subFont));
        columnas.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnas.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnas.setBackgroundColor(FondoH);
        columnas.setBorderColor(BordeH);
        columnas.setPaddingBottom(5);
        tabla.addCell(columnas);
        
        columnas = new PdfPCell(new Phrase("Acumulado",subFont));
        columnas.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnas.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnas.setBackgroundColor(FondoH);
        columnas.setBorderColor(BordeH);
        columnas.setPaddingBottom(5);
        tabla.addCell(columnas);
        
        columnas = new PdfPCell(new Phrase("Calificaciones",subFont));
        columnas.setHorizontalAlignment(Element.ALIGN_CENTER);
        columnas.setVerticalAlignment(Element.ALIGN_MIDDLE);
        columnas.setBackgroundColor(FondoH);
        columnas.setBorderColor(BordeH);
        columnas.setPaddingBottom(5);
        tabla.addCell(columnas);
        
        tabla.setHeaderRows(1);
        float[] longCeldas = {0.2f, 0.3f, 0.4f, 0.4f,0.8f,0.4f,0.8f};
        tabla.setWidths(longCeldas);
        
        int multiFila=0;
        for(int i=0; i<actividad.length; i++) {
        	if(actividad[i]!=null && actividad[i].getCurso()==cur) {
        		multiFila++;
        	}
        }
        
        for(int i=0; i<5; i++) {
			if(top[i]!=null){
                for(int j=0; j<alumno.length; j++) {
                	if(alumno[j]!=null && alumno[j].getCodigo()==top[i].getAlu()) {
                		columnas = new PdfPCell(new Phrase(String.valueOf(i+1),smallBold));
        				columnas.setHorizontalAlignment(Element.ALIGN_CENTER);
        				columnas.setVerticalAlignment(Element.ALIGN_MIDDLE);
        				columnas.setBorderColor(BordeC);
        				columnas.setRowspan(multiFila);
        				columnas.setMinimumHeight(25);
        				columnas.setPaddingBottom(3);
                        tabla.addCell(columnas);
                        
                        columnas = new PdfPCell(new Phrase(String.valueOf(alumno[j].getCodigo()),smallBold));
                        columnas.setHorizontalAlignment(Element.ALIGN_CENTER);
                        columnas.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        columnas.setBorderColor(BordeC);
                        columnas.setRowspan(multiFila);
                        columnas.setPaddingBottom(3);
                        tabla.addCell(columnas);
                        
                        columnas = new PdfPCell(new Phrase(alumno[j].getNombre(),smallBold));
                        columnas.setHorizontalAlignment(Element.ALIGN_CENTER);
                        columnas.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        columnas.setBorderColor(BordeC);
                        columnas.setRowspan(multiFila);
                        columnas.setPaddingBottom(3);
                        tabla.addCell(columnas);
                        
                        columnas = new PdfPCell(new Phrase(alumno[j].getApellido(),smallBold));
                        columnas.setHorizontalAlignment(Element.ALIGN_CENTER);
                        columnas.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        columnas.setBorderColor(BordeC);
                        columnas.setRowspan(multiFila);
                        columnas.setPaddingBottom(3);
                        tabla.addCell(columnas);
                        
                        columnas = new PdfPCell(new Phrase(alumno[j].getCorreo(),smallBold));
                        columnas.setHorizontalAlignment(Element.ALIGN_CENTER);
                        columnas.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        columnas.setBorderColor(BordeC);
                        columnas.setRowspan(multiFila);
                        columnas.setPaddingBottom(3);
                        tabla.addCell(columnas);
                        
                        columnas = new PdfPCell(new Phrase(String.valueOf(redondearDecimales(top[i].getAcum(),2)),smallBold));
                        columnas.setHorizontalAlignment(Element.ALIGN_CENTER);
                        columnas.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        columnas.setBorderColor(BordeC);
                        columnas.setRowspan(multiFila);
                        columnas.setPaddingBottom(3);
                        tabla.addCell(columnas);
                        
                		for(int x=0; x<nota.length; x++) {
                			if(nota[x]!=null && nota[x].getCodAlu()==top[i].getAlu() && nota[x].getCodCur()==cur) {
		                        
                				String activ="";
                				for(int y=0; y<actividad.length; y++) {
                					if(actividad[y]!=null && actividad[y].getCurso()==cur && actividad[y].getCodigo()==nota[x].getCodAct()) {
                						activ=actividad[y].getNombre()+" ("+(int)actividad[y].getPonderacion()+" pts) ";
                					}
                				}
                				
                				columnas = new PdfPCell(new Phrase(activ+":   "+nota[x].getNota(),smallBold));
		                        columnas.setHorizontalAlignment(Element.ALIGN_CENTER);
		                        columnas.setVerticalAlignment(Element.ALIGN_MIDDLE);
		                        columnas.setBorderColor(BordeC);
		                        columnas.setRowspan(1);
		                        columnas.setPaddingBottom(3);
		                        tabla.addCell(columnas);
                			}
                		}
                	}
                }
			}
		}
        
        document.add(tabla);
        document.newPage();
        
        JOptionPane.showMessageDialog(null,"Se ha exportado la lista");
    }
	private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
	private static double redondearDecimales(double valorInicial, int numeroDecimales) {
		double parteEntera, resultado;
		resultado=valorInicial;
		parteEntera=Math.floor(resultado);
		resultado=(resultado-parteEntera)*Math.pow(10,numeroDecimales);
		resultado=Math.round(resultado);
		resultado=(resultado/Math.pow(10,numeroDecimales))+parteEntera;
		return resultado;
	}
	int getAlu() {
		return alu;
	}
	void setAlu(int alu) {
		this.alu = alu;
	}
	double getAcum() {
		return acum;
	}
	void setAcum(double acum) {
		this.acum = acum;
	}
}