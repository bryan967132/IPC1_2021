package ListasExportadas;
import static Alumnos.ControladorAlumno.*;
import static Interfaz.Fuentes.*;
import static Interfaz.Colores.*;
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
public class ListaAlumnos {
	public void Exportar() {
		try {
			Document document = new Document(PageSize.LETTER.rotate());
            PdfWriter.getInstance(document, new FileOutputStream("Listados/Alumnos.pdf"));
            document.open();
            addTitlePage(document);
            document.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"No se ha podido exportado la lista");
		}
	}
	private static void addTitlePage(Document document)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        preface.add(new Paragraph("Listado Oficial De Alumnos",catFont));
        addEmptyLine(preface,1);
        document.add(preface);
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);

        PdfPCell c1 = new PdfPCell(new Phrase("Código",subFont));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        c1.setBackgroundColor(FondoH);
        c1.setBorderColor(BordeH);
        c1.setPaddingBottom(5);
        c1.setMinimumHeight(30);
        
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Nombre",subFont));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        c1.setBackgroundColor(FondoH);
        c1.setBorderColor(BordeH);
        c1.setPaddingBottom(5);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Apellido",subFont));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        c1.setBackgroundColor(FondoH);
        c1.setBorderColor(BordeH);
        c1.setPaddingBottom(5);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Correo",subFont));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        c1.setBackgroundColor(FondoH);
        c1.setBorderColor(BordeH);
        c1.setPaddingBottom(5);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Género",subFont));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        c1.setBackgroundColor(FondoH);
        c1.setBorderColor(BordeH);
        c1.setPaddingBottom(5);
        table.addCell(c1);
        
        table.setHeaderRows(1);
        float[] medidaCeldas = {0.27f, 0.45f, 0.45f, 0.7f,0.3f};
        table.setWidths(medidaCeldas);
        
        for(int i=0; i<alumno.length; i++) {
			if(alumno[i]!=null){
				
				c1 = new PdfPCell(new Phrase(String.valueOf(alumno[i].getCodigo()),smallBold));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                c1.setBorderColor(BordeC);
                c1.setMinimumHeight(25);
                c1.setPaddingBottom(3);
                table.addCell(c1);
                
                c1 = new PdfPCell(new Phrase(alumno[i].getNombre(),smallBold));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                c1.setBorderColor(BordeC);
                c1.setPaddingBottom(3);
                table.addCell(c1);
                
                c1 = new PdfPCell(new Phrase(alumno[i].getApellido(),smallBold));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                c1.setBorderColor(BordeC);
                c1.setPaddingBottom(3);
                table.addCell(c1);
                
                c1 = new PdfPCell(new Phrase(alumno[i].getCorreo(),smallBold));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                c1.setBorderColor(BordeC);
                c1.setPaddingBottom(3);
                table.addCell(c1);
                
				c1 = new PdfPCell(new Phrase(alumno[i].getGenero(),smallBold));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                c1.setBorderColor(BordeC);
                c1.setPaddingBottom(3);
                table.addCell(c1);
			}
		}
        
        document.add(table);
        document.newPage();
        
        JOptionPane.showMessageDialog(null,"Se ha exportado la lista");
    }
	private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}