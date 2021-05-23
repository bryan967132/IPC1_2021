package Reportes;
import static Operaciones.Desencriptacion.*;
import static Operaciones.Encriptacion.*;
import java.io.FileWriter;
import java.util.Date;
import Menus.Menu;
public class ReporteDesencriptacion {
	public static int determinante;
	public static void Reportando() {
		if(desencriptado!=null) {
			try {
				Date fechahora = new Date(); 
				FileWriter reporte = new FileWriter("Reportes/Desencriptacion.html");
				//APERTURA DE ARCHIVO----------------------------------------------------------------------------------
				reporte.write("<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "	<title>Desencriptacion</title>\r\n"
						+ "	<meta charset=\"UTF-8\">\r\n"
						+ "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
						+ "	<link rel=\"icon\" type=\"image/png\" href=\"images/icons/IPC.png\"/>\r\n"
						+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/bootstrap/css/bootstrap.min.css\">\r\n"
						+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\">\r\n"
						+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animate/animate.css\">\r\n"
						+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/select2/select2.min.css\">\r\n"
						+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/perfect-scrollbar/perfect-scrollbar.css\">\r\n"
						+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"css/util.css\">\r\n"
						+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "	<div class=\"limiter\">\r\n"
						+ "		<div class=\"container-table100\">\r\n"
						+ "\r\n"
						+ "			<div class=\"wrap-table100\">\r\n"
						+ "				<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 28px;\" align=\"center\">Desencriptacion del Mensaje</p >\r\n"
						+ "				<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 18px;\" align=\"justify\">Se usaran las mismas Matrices Clave, el mismo codigo de letras a numeros y ahora la Matriz C.<br><br></p>");
				
				//MATRIZ CLAVE c----------------------------------------------------------------------------------------------
					//APERTURA DE TABLA-------------------------------------------------------------------------------
				reporte.write("<div class=\"table100 ver1 m-b-110\">\r\n"
						+ "					<div class=\"table100-head\">\r\n"
						+ "						<table>\r\n"
						+ "							<thead>\r\n"
						+ "								<tr class=\"row100 head\">\r\n"
						+ "									<th class=\"cell100 column1\">Matriz C</th>\r\n"
						+ "								</tr>\r\n"
						+ "							</thead>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "\r\n"
						+ "					<div class=\"table100-body js-pscroll\">\r\n"
						+ "						<table>\r\n"
						+ "							<tbody>\r\n");
						//LLENADO DE TABLA-------------------------------------------------------------------
				for(int i=0; i<3; i++) {
					reporte.write("<tr class=\"row100 body\">\r\n");
					for(int j=0; j<(columnas/3); j++) {
						reporte.write("<td class=\"cell100 column1\">"+encriptado[i][j]+"</td>\r\n");
					}
					reporte.write("</tr>\r\n");
				}
					//CIERRE DE TABLA----------------------------------------------------------------------------------
				reporte.write("</tbody>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "				</div>");
			
				//MATRIZ CLAVE A------------------------------------------------------------------------------------------
					//APERTURA DE TABLA-----------------------------------------------------------------------------
				reporte.write("<div class=\"table100 ver1 m-b-110\">\r\n"
						+ "					<div class=\"table100-head\">\r\n"
						+ "						<table>\r\n"
						+ "							<thead>\r\n"
						+ "								<tr class=\"row100 head\">\r\n"
						+ "									<th class=\"cell100 column1\">Matriz Clave A</th>\r\n"
						+ "								</tr>\r\n"
						+ "							</thead>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "\r\n"
						+ "					<div class=\"table100-body js-pscroll\">\r\n"
						+ "						<table>\r\n"
						+ "							<tbody>\r\n");
						//LLENADO DE TABLA--------------------------------------------------------------
				for(int i=0; i<3; i++) {
					reporte.write("<tr class=\"row100 body\">\r\n");
					for(int j=0; j<3; j++) {
						reporte.write("<td class=\"cell100 column1\">"+ClaveA[i][j]+"</td>\r\n");
					}
					reporte.write("</tr>\r\n");
				}
					//CIERRE DE TABLA---------------------------------------------------------------------------------
				reporte.write("</tbody>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "				</div>");
				
				//MATRIZ CLAVE B----------------------------------------------------------------------------------------------
					//APERTURA DE TABLA-------------------------------------------------------------------------------
				reporte.write("<div class=\"table100 ver1 m-b-110\">\r\n"
						+ "					<div class=\"table100-head\">\r\n"
						+ "						<table>\r\n"
						+ "							<thead>\r\n"
						+ "								<tr class=\"row100 head\">\r\n"
						+ "									<th class=\"cell100 column1\">Matriz Clave B</th>\r\n"
						+ "								</tr>\r\n"
						+ "							</thead>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "\r\n"
						+ "					<div class=\"table100-body js-pscroll\">\r\n"
						+ "						<table>\r\n"
						+ "							<tbody>\r\n");
						//LLENADO DE TABLA-------------------------------------------------------------------
				for(int i=0; i<3; i++) {
					reporte.write("<tr class=\"row100 body\">\r\n");
					for(int j=0; j<(columnas/3); j++) {
						reporte.write("<td class=\"cell100 column1\">"+ClaveB[i][j]+"</td>\r\n");
					}
					reporte.write("</tr>\r\n");
				}
					//CIERRE DE TABLA----------------------------------------------------------------------------------
				reporte.write("</tbody>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "				</div>");
				
				
				//PROCEDIMIENTO---------------------------------------------------------------------------------------------------
				//INSTRUCCION 1
				reporte.write("<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 20px;\" align=\"left\">Procedimiento:</p >\r\n"
						+ "				<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 18px;\" align=\"justify\">1. Calcular el Determinante de la Matriz Clave A.<br><br></p>");
				reporte.write("<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 18px;\" align=\"justify\">");
				reporte.write("Determinante = "+ClaveA[0][0]+"&#183;"+"(("+ClaveA[1][1]+")("+ClaveA[2][2]+") - ("+ClaveA[1][2]+")("+ClaveA[2][1]+")) - "
											   +ClaveA[0][1]+"&#183;"+"(("+ClaveA[1][0]+")("+ClaveA[2][2]+") - ("+ClaveA[1][2]+")("+ClaveA[2][0]+")) + "
											   +ClaveA[0][2]+"&#183;"+"(("+ClaveA[1][0]+")("+ClaveA[2][1]+") - ("+ClaveA[1][1]+")("+ClaveA[2][0]+")) = "+(x-y+z));
				reporte.write("<br><br></p>");
				
				//INSTRUCCION 2
				reporte.write("<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 18px;\" align=\"justify\">2. Obtener la Transpuesta de la Matriz Clave A.<br><br></p>");
				reporte.write("<div class=\"table100 ver1 m-b-110\">\r\n"
						+ "					<div class=\"table100-head\">\r\n"
						+ "						<table>\r\n"
						+ "							<thead>\r\n"
						+ "								<tr class=\"row100 head\">\r\n"
						+ "									<th class=\"cell100 column1\">Transpuesta A</th>\r\n"
						+ "								</tr>\r\n"
						+ "							</thead>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "\r\n"
						+ "					<div class=\"table100-body js-pscroll\">\r\n"
						+ "						<table>\r\n"
						+ "							<tbody>\r\n");
						//LLENADO DE TABLA--------------------------------------------------------------
				for(int i=0; i<3; i++) {
					reporte.write("<tr class=\"row100 body\">\r\n");
					for(int j=0; j<3; j++) {
						reporte.write("<td class=\"cell100 column1\">"+ClaveA[j][i]+"</td>\r\n");
					}
					reporte.write("</tr>\r\n");
				}
					//CIERRE DE TABLA---------------------------------------------------------------------------------
				reporte.write("</tbody>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "				</div>");
				
				//INSTRUCCION 3
				reporte.write("<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 18px;\" align=\"justify\">3. Calcular la Adjunta de la Transpuesta A.<br><br></p>");
				reporte.write("<div class=\"table100 ver1 m-b-110\">\r\n"
						+ "					<div class=\"table100-head\">\r\n"
						+ "						<table>\r\n"
						+ "							<thead>\r\n"
						+ "								<tr class=\"row100 head\">\r\n"
						+ "									<th class=\"cell100 column1\">Adjunta A</th>\r\n"
						+ "								</tr>\r\n"
						+ "							</thead>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "\r\n"
						+ "					<div class=\"table100-body js-pscroll\">\r\n"
						+ "						<table>\r\n"
						+ "							<tbody>\r\n"
						+ "								<tr class=\"row100 body\">\r\n"
						+ "									<td class=\"cell100 column1\">(-1)<sup>0+0</sup>&#183;[("+transpuesta[1][1]+")("+transpuesta[2][2]+") - ("+transpuesta[1][2]+")("+transpuesta[2][1]+")] = "+(+m00)+"</td>\r\n"
						+ "									<td class=\"cell100 column1\">(-1)<sup>0+1</sup>&#183;[("+transpuesta[1][0]+")("+transpuesta[2][2]+") - ("+transpuesta[1][2]+")("+transpuesta[2][0]+")] = "+(-m01)+"</td>\r\n"
						+ "									<td class=\"cell100 column1\">(-1)<sup>0+2</sup>&#183;[("+transpuesta[1][0]+")("+transpuesta[2][1]+") - ("+transpuesta[1][1]+")("+transpuesta[2][0]+")] = "+(+m02)+"</td>\r\n"
						+ "								</tr>\r\n"
						+ "								<tr class=\"row100 body\">\r\n"
						+ "									<td class=\"cell100 column1\">(-1)<sup>1+0</sup>&#183;[("+transpuesta[0][1]+")("+transpuesta[2][2]+") - ("+transpuesta[0][2]+")("+transpuesta[2][1]+")] = "+(-m10)+"</td>\r\n"
						+ "									<td class=\"cell100 column1\">(-1)<sup>1+1</sup>&#183;[("+transpuesta[0][0]+")("+transpuesta[2][2]+") - ("+transpuesta[0][2]+")("+transpuesta[2][0]+")] = "+(+m11)+"</td>\r\n"
						+ "									<td class=\"cell100 column1\">(-1)<sup>1+2</sup>&#183;[("+transpuesta[0][0]+")("+transpuesta[2][1]+") - ("+transpuesta[0][1]+")("+transpuesta[2][0]+")] = "+(-m12)+"</td>\r\n"
						+ "								</tr>\r\n"
						+ "								<tr class=\"row100 body\">\r\n"
						+ "									<td class=\"cell100 column1\">(-1)<sup>2+0</sup>&#183;[("+transpuesta[0][1]+")("+transpuesta[1][2]+") - ("+transpuesta[0][2]+")("+transpuesta[1][1]+")] = "+(+m20)+"</td>\r\n"
						+ "									<td class=\"cell100 column1\">(-1)<sup>2+1</sup>&#183;[("+transpuesta[0][0]+")("+transpuesta[1][2]+") - ("+transpuesta[0][2]+")("+transpuesta[1][0]+")] = "+(-m21)+"</td>\r\n"
						+ "									<td class=\"cell100 column1\">(-1)<sup>2+2</sup>&#183;[("+transpuesta[0][0]+")("+transpuesta[1][1]+") - ("+transpuesta[0][1]+")("+transpuesta[1][0]+")] = "+(+m22)+"</td>\r\n"
						+ "								</tr>\r\n"
						+ "							</tbody>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "				</div>\r\n");
				
				//INSTRUCCION 4
				reporte.write("<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 18px;\" align=\"justify\">4. Calcular la Inversa de Matriz Clave A.<br>Ecuacion: </p>");
				reporte.write("<div class=\"eq-c\">\r\n"
						+ "				A<sup>-1</sup> =\r\n"
						+ "				<div class=\"fraction\">\r\n"
						+ "				<span class=\"fup\">Adj A</span>\r\n"
						+ "				<span class=\"bar\">/</span>\r\n"
						+ "				<span class=\"fdn\">det A</span>\r\n"
						+ "				</div>\r\n"
						+ "				</div><br>");
				//APERTURA DE TABLA-----------------------------------------------------------------------------
				reporte.write("<div class=\"table100 ver1 m-b-110\">\r\n"
						+ "					<div class=\"table100-head\">\r\n"
						+ "						<table>\r\n"
						+ "							<thead>\r\n"
						+ "								<tr class=\"row100 head\">\r\n"
						+ "									<th class=\"cell100 column1\">Inversa de A o A<sup>-1</sup></th>\r\n"
						+ "								</tr>\r\n"
						+ "							</thead>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "\r\n"
						+ "					<div class=\"table100-body js-pscroll\">\r\n"
						+ "						<table>\r\n"
						+ "							<tbody>\r\n");
						//LLENADO DE TABLA--------------------------------------------------------------
				for(int i=0; i<3; i++) {
					reporte.write("<tr class=\"row100 body\">\r\n");
					for(int j=0; j<3; j++) {
						reporte.write("<td class=\"cell100 column1\"><div class=\"eq-c\">\r\n"
								+ "				<div class=\"fraction\">\r\n"
								+ "				<span class=\"fup\">"+adjunta[i][j]+"</span>\r\n"
								+ "				<span class=\"bar\">/</span>\r\n"
								+ "				<span class=\"fdn\">"+(x-y+z)+"</span>\r\n"
								+ "				</div>\r\n"
								+ "				</div></td>");
					}
					reporte.write("</tr>\r\n");
				}
					//CIERRE DE TABLA---------------------------------------------------------------------------------
				reporte.write("</tbody>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "				</div>");
				
				//INSTRUCCION 5
				reporte.write("<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 18px;\" align=\"justify\">5. Calcular C - B<br><br></p>");
				//APERTURA DE TABLA-----------------------------------------------------------------------------
				reporte.write("<div class=\"table100 ver1 m-b-110\">\r\n"
						+ "					<div class=\"table100-head\">\r\n"
						+ "						<table>\r\n"
						+ "							<thead>\r\n"
						+ "								<tr class=\"row100 head\">\r\n"
						+ "									<th class=\"cell100 column1\">Matriz C - B</sup></th>\r\n"
						+ "								</tr>\r\n"
						+ "							</thead>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "\r\n"
						+ "					<div class=\"table100-body js-pscroll\">\r\n"
						+ "						<table>\r\n"
						+ "							<tbody>\r\n");
						//LLENADO DE TABLA--------------------------------------------------------------
				for(int i=0; i<3; i++) {
					reporte.write("<tr class=\"row100 body\">\r\n");
					for(int j=0; j<(columnas/3); j++) {
						reporte.write("<td class=\"cell100 column1\">"+encriptado[i][j]+" - "+ClaveB[i][j]+" = "+(encriptado[i][j]-ClaveB[i][j])+"</td>");
					}
					reporte.write("</tr>\r\n");
				}
					//CIERRE DE TABLA---------------------------------------------------------------------------------
				reporte.write("</tbody>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "				</div>");
				
				//INSTRUCCION 6
				reporte.write("<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 18px;\" align=\"justify\">6. Multiplicar A<sup>-1</sup> por C - B.<br><br></p>");
				//APERTURA DE TABLA-------------------------------------------------------------------------------
				reporte.write("<div class=\"table100 ver1 m-b-110\">\r\n"
						+ "					<div class=\"table100-head\">\r\n"
						+ "						<table>\r\n"
						+ "							<thead>\r\n"
						+ "								<tr class=\"row100 head\">\r\n"
						+ "									<th class=\"cell100 column1\">Matriz A<sup>-1</sup>(C - B) = M</th>\r\n"
						+ "								</tr>\r\n"
						+ "							</thead>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "\r\n"
						+ "					<div class=\"table100-body js-pscroll\">\r\n"
						+ "						<table>\r\n"
						+ "							<tbody>\r\n");
						//LLENADO DE TABLA-------------------------------------------------------------------
				for(int i=0; i<3; i++) {
					reporte.write("<tr class=\"row100 body\">\r\n");
					for(int j=0; j<(columnas/3); j++) {
						reporte.write("<td class=\"cell100 column1\"><div class=\\\"eq-c\\\">");
						for(int k=0; k<3; k++) {
							reporte.write("<div class=\"fraction\">\r\n"
									+ "					<span class=\"fup\">("+adjunta[i][k]+")("+(encriptado[k][j]-ClaveB[k][j])+")</span>\r\n"
									+ "					<span class=\"bar\">/</span>\r\n"
									+ "					<span class=\"fdn\">"+(x-y+z)+"</span>\r\n"
									+ "					</div>");
							if(k<2) {
								reporte.write(" + ");
							}
						}
						reporte.write(" = "+Math.round(desencriptado[i][j])+"</td>\r\n");
					}
					reporte.write("</div></tr>\r\n");
				}
					//CIERRE DE TABLA---------------------------------------------------------------------------------
				reporte.write("</tbody>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "				</div>");
				
							
				//INSTRUCCION 7
				reporte.write("<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 18px;\" align=\"justify\">7. Sustituir los numeros por sus respectivas letras para descubrir el mensaje<br><br></p>");
				//MATRIZ TEXTO DEL MENSAJE------------------------------------------------------------------------------------
					//APERTURA DE TABLA-----------------------------------------------------------------------------
				reporte.write("<div class=\"table100 ver1 m-b-110\">\r\n"
						+ "					<div class=\"table100-head\">\r\n"
						+ "						<table>\r\n"
						+ "							<thead>\r\n"
						+ "								<tr class=\"row100 head\">\r\n"
						+ "									<th class=\"cell100 column1\">Matriz M</th>\r\n"
						+ "								</tr>\r\n"
						+ "							</thead>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "\r\n"
						+ "					<div class=\"table100-body js-pscroll\">\r\n"
						+ "						<table>\r\n"
						+ "							<tbody>\r\n");
						//LLENADO DE TABLA-----------------------------------------------------------
				for(int i=0; i<3; i++) {
					reporte.write("<tr class=\"row100 body\">\r\n");
					for(int j=0; j<(columnas/3); j++) {
						reporte.write("<td class=\"cell100 column1\">"+decodificado[i][j]+"</td>\r\n");
					}
					reporte.write("</tr>\r\n");
				}
					//CIERRE DE TABLA-------------------------------------------------------------------------------
				reporte.write("</tbody>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "				</div>");
				
				//MOSTRAR MENSAJE DESENCRIPTADO	
				reporte.write("<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 25px;\" align=\"justify\">El mensaje desencriptado es: <br>");
				for(int j=0; j<(columnas/3); j++) {
					for(int i=0; i<3; i++) {
						reporte.write(decodificado[i][j]+"&nbsp;&nbsp;");
					}
				}
				reporte.write("<br><br></p>\r\n");
				
				//FECHA Y HORA DE GENERACION
				reporte.write("<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 15px;\" align=\"right\">Generado: "+fechahora.toString()+"<br><br></p>\r\n");
				
				//CAMBIAR DE REPORTE
				reporte.write("<div align=\"center\">\r\n"
						+ "				<a class=\"boton\" href=\"Encriptacion.html\" style=\"color: #ffffff;\">Reporte Encriptacion</a>\r\n"
						+ "				</div>");
				
				//CIERRE DE ARCHIVO------------------------------------------------------------------------------------
				reporte.write("</div>\r\n"
						+ "		</div>\r\n"
						+ "	</div>\r\n"
						+ "<!--===============================================================================================-->	\r\n"
						+ "	<script src=\"vendor/jquery/jquery-3.2.1.min.js\"></script>\r\n"
						+ "<!--===============================================================================================-->\r\n"
						+ "	<script src=\"vendor/bootstrap/js/popper.js\"></script>\r\n"
						+ "	<script src=\"vendor/bootstrap/js/bootstrap.min.js\"></script>\r\n"
						+ "<!--===============================================================================================-->\r\n"
						+ "	<script src=\"vendor/select2/select2.min.js\"></script>\r\n"
						+ "<!--===============================================================================================-->\r\n"
						+ "	<script src=\"vendor/perfect-scrollbar/perfect-scrollbar.min.js\"></script>\r\n"
						+ "	<script>\r\n"
						+ "		$('.js-pscroll').each(function(){\r\n"
						+ "			var ps = new PerfectScrollbar(this);\r\n"
						+ "\r\n"
						+ "			$(window).on('resize', function(){\r\n"
						+ "				ps.update();\r\n"
						+ "			})\r\n"
						+ "		});\r\n"
						+ "			\r\n"
						+ "		\r\n"
						+ "	</script>\r\n"
						+ "<!--===============================================================================================-->\r\n"
						+ "	<script src=\"js/main.js\"></script>\r\n"
						+ "\r\n"
						+ "</body>\r\n"
						+ "</html>");
				
				reporte.close();
				System.out.println("¡Reporte Enviado!\n");
			}catch(Exception e) {
				System.out.println("Aún no se ha desencriptado ningún mensaje\\n");
			}
			Menu menu = new Menu();
			menu.main(null);
		}else {
			System.out.println("No se puede reportar si no se ha insertado un mensaje\n");
			Menu menu = new Menu();
			menu.main(null);
		}
	}
}