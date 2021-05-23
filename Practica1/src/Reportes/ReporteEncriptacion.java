package Reportes;
import java.io.FileWriter;
import java.util.Date;
import Menus.Menu;
import static Operaciones.Encriptacion.*;
public class ReporteEncriptacion {
	public static void Reportando() {
		if(encriptado!=null) {
			try {
				Date fechahora = new Date(); 
				FileWriter reporte = new FileWriter("Reportes/Encriptacion.html");
				//APERTURA DE ARCHIVO----------------------------------------------------------------------------------
				reporte.write("<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "	<title>Encriptacion</title>\r\n"
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
						+ "			<div class=\"wrap-table100\">\r\n"
						+ "				<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 28px;\" align=\"center\">Encriptacion del Mensaje</p >\r\n"
						+ "				<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 18px;\" align=\"justify\">Se ingreso un mensaje por teclado, cada letra sera sustituida por un numero comenzando en a = 0 hasta llegar a z = 26, y el espacio u otro caracter diferente a los alfabeticos se sustituira por 27. Cada caracter del mensaje se ordenara en una matriz de 3 filas por n columnas, la matriz sera llenada por columnas. Tambien se ingreso dos matrices clave.<br><br></p>\r\n"
						+ "				<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 25px;\" align=\"center\">El mensaje ingresado es: "+mensaje+"<br><br>\r\n"
						+ "				</p>\r\n");
				
				
				
				//MATRIZ TEXTO DEL MENSAJE------------------------------------------------------------------------------------
					//APERTURA DE TABLA-----------------------------------------------------------------------------
				reporte.write("<div class=\"table100 ver1 m-b-110\">\r\n"
						+ "					<div class=\"table100-head\">\r\n"
						+ "						<table>\r\n"
						+ "							<thead>\r\n"
						+ "								<tr class=\"row100 head\">\r\n"
						+ "									<th class=\"cell100 column1\">Matriz Textual Del Mensaje</th>\r\n"
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
						reporte.write("<td class=\"cell100 column1\">"+sobre[i][j]+"</td>\r\n");
					}
					reporte.write("</tr>\r\n");
				}
					//CIERRE DE TABLA-------------------------------------------------------------------------------
				reporte.write("</tbody>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "				</div>");
				
				//REQUERIMIENTOS PARA ENCRIPTAR
				reporte.write("<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 18px;\" align=\"justify\">Para poder encriptar el mensaje se debe hacer la sustitucion de las letras, sin importar si son mayasculas o minusculas, por sus respectivos numeros.<br><br></p>\r\n"
						+ "				<div class=\"table100 ver1 m-b-110\">\r\n"
						+ "					<div class=\"table100-head\">\r\n"
						+ "						<table>\r\n"
						+ "							<thead>\r\n"
						+ "								<tr class=\"row100 head\">\r\n"
						+ "									<th class=\"cell100 column1\">Codigo</th>\r\n"
						+ "								</tr>\r\n"
						+ "							</thead>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "\r\n"
						+ "					<div class=\"table100-body js-pscroll\">\r\n"
						+ "						<table>\r\n"
						+ "							<tbody>\r\n"
						+ "								<tr class=\"row100 body\">\r\n"
						+ "									<td class=\"cell100 column1\">A</td>\r\n"
						+ "									<td class=\"cell100 column1\">B</td>\r\n"
						+ "									<td class=\"cell100 column1\">C</td>\r\n"
						+ "									<td class=\"cell100 column1\">D</td>\r\n"
						+ "									<td class=\"cell100 column1\">E</td>\r\n"
						+ "									<td class=\"cell100 column1\">F</td>\r\n"
						+ "									<td class=\"cell100 column1\">G</td>\r\n"
						+ "									<td class=\"cell100 column1\">H</td>\r\n"
						+ "									<td class=\"cell100 column1\">I</td>\r\n"
						+ "									<td class=\"cell100 column1\">J</td>\r\n"
						+ "								</tr>\r\n"
						+ "								<tr class=\"row100 body\">\r\n"
						+ "									<td class=\"cell100 column1\">0</td>\r\n"
						+ "									<td class=\"cell100 column1\">1</td>\r\n"
						+ "									<td class=\"cell100 column1\">2</td>\r\n"
						+ "									<td class=\"cell100 column1\">3</td>\r\n"
						+ "									<td class=\"cell100 column1\">4</td>\r\n"
						+ "									<td class=\"cell100 column1\">5</td>\r\n"
						+ "									<td class=\"cell100 column1\">6</td>\r\n"
						+ "									<td class=\"cell100 column1\">7</td>\r\n"
						+ "									<td class=\"cell100 column1\">8</td>\r\n"
						+ "									<td class=\"cell100 column1\">9</td>\r\n"
						+ "								</tr>\r\n"
						+ "								<tr class=\"row100 body\">\r\n"
						+ "									<td class=\"cell100 column1\">K</td>\r\n"
						+ "									<td class=\"cell100 column1\">L</td>\r\n"
						+ "									<td class=\"cell100 column1\">M</td>\r\n"
						+ "									<td class=\"cell100 column1\">N</td>\r\n"
						+ "									<td class=\"cell100 column1\">&Ntilde;</td>\r\n"
						+ "									<td class=\"cell100 column1\">O</td>\r\n"
						+ "									<td class=\"cell100 column1\">P</td>\r\n"
						+ "									<td class=\"cell100 column1\">Q</td>\r\n"
						+ "									<td class=\"cell100 column1\">R</td>\r\n"
						+ "									<td class=\"cell100 column1\">S</td>\r\n"
						+ "								</tr>\r\n"
						+ "								<tr class=\"row100 body\">\r\n"
						+ "									<td class=\"cell100 column1\">10</td>\r\n"
						+ "									<td class=\"cell100 column1\">11</td>\r\n"
						+ "									<td class=\"cell100 column1\">12</td>\r\n"
						+ "									<td class=\"cell100 column1\">13</td>\r\n"
						+ "									<td class=\"cell100 column1\">14</td>\r\n"
						+ "									<td class=\"cell100 column1\">15</td>\r\n"
						+ "									<td class=\"cell100 column1\">16</td>\r\n"
						+ "									<td class=\"cell100 column1\">17</td>\r\n"
						+ "									<td class=\"cell100 column1\">18</td>\r\n"
						+ "									<td class=\"cell100 column1\">19</td>\r\n"
						+ "								</tr>\r\n"
						+ "								<tr class=\"row100 body\">\r\n"
						+ "									<td class=\"cell100 column1\">T</td>\r\n"
						+ "									<td class=\"cell100 column1\">U</td>\r\n"
						+ "									<td class=\"cell100 column1\">V</td>\r\n"
						+ "									<td class=\"cell100 column1\">W</td>\r\n"
						+ "									<td class=\"cell100 column1\">X</td>\r\n"
						+ "									<td class=\"cell100 column1\">Y</td>\r\n"
						+ "									<td class=\"cell100 column1\">Z</td>\r\n"
						+ "									<td class=\"cell100 column1\">Espacio/Caracter</td>\r\n"
						+ "									<td class=\"cell100 column1\"></td>\r\n"
						+ "									<td class=\"cell100 column1\"></td>\r\n"
						+ "								</tr>\r\n"
						+ "								<tr class=\"row100 body\">\r\n"
						+ "									<td class=\"cell100 column1\">20</td>\r\n"
						+ "									<td class=\"cell100 column1\">21</td>\r\n"
						+ "									<td class=\"cell100 column1\">22</td>\r\n"
						+ "									<td class=\"cell100 column1\">23</td>\r\n"
						+ "									<td class=\"cell100 column1\">24</td>\r\n"
						+ "									<td class=\"cell100 column1\">25</td>\r\n"
						+ "									<td class=\"cell100 column1\">26</td>\r\n"
						+ "									<td class=\"cell100 column1\">27</td>\r\n"
						+ "									<td class=\"cell100 column1\"></td>\r\n"
						+ "									<td class=\"cell100 column1\"></td>\r\n"
						+ "								</tr>\r\n"
						+ "							</tbody>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "				</div>\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "				<p style=\"color: #0f3007;font-family: sans-serif;font-size: 18px;\" align=\"left\">Lo que se requiere para encriptar el mensaje es lo siguiente:<br>\r\n"
						+ "				<ol style=\"color: #0f3007;font-family: sans-serif;font-size: 18px;\" align=\"left\">\r\n"
						+ "				  <li>1. Matriz M Del Mensaje</li>\r\n"
						+ "				  <li>2. Matriz Clave A</li>\r\n"
						+ "				  <li>3. Matriz Clave B</li>\r\n"
						+ "				</ol>\r\n"
						+ "				</p>");
				
				//MATRIZ DEL MENSAJE------------------------------------------------------------------------------------
					//APERTURA DE TABLA-----------------------------------------------------------------------------
				reporte.write("<div class=\"table100 ver1 m-b-110\">\r\n"
						+ "					<div class=\"table100-head\">\r\n"
						+ "						<table>\r\n"
						+ "							<thead>\r\n"
						+ "								<tr class=\"row100 head\">\r\n"
						+ "									<th class=\"cell100 column1\">Matriz M Del Mensaje</th>\r\n"
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
						reporte.write("<td class=\"cell100 column1\">"+codificado[i][j]+"</td>\r\n");
					}
					reporte.write("</tr>\r\n");
				}
					//CIERRE DE TABLA-------------------------------------------------------------------------------
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
						+ "				<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 18px;\" align=\"justify\">1. Multiplicar los elementos de cada fila de la Matriz Clave A por los elementos de cada columna de la Matriz M del Mensaje, y sumar los productos para encontrar cada elemento de la nueva matriz.<br>\r\n"
						+ "				Ecuacion: &#931;(A<sub>ik</sub> x M<sub>kj</sub>) = AM<sub>ij</sub><br><br></p>");
					//MULTIPLICACIÓN-----------------------------------------------------------------------------------
						//APERTURA DE TABLA-------------------------------------------------------------------------------
				reporte.write("<div class=\"table100 ver1 m-b-110\">\r\n"
						+ "					<div class=\"table100-head\">\r\n"
						+ "						<table>\r\n"
						+ "							<thead>\r\n"
						+ "								<tr class=\"row100 head\">\r\n"
						+ "									<th class=\"cell100 column1\">Matriz AM</th>\r\n"
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
						reporte.write("<td class=\"cell100 column1\">");
						for(int k=0; k<3; k++) {
							reporte.write("("+ClaveA[i][k]+")("+codificado[k][j]+")");
							if(k<2) {
								reporte.write(" + ");
							}
						}
						reporte.write(" = "+oculto[i][j]+"</td>\r\n");
					}
					reporte.write("</tr>\r\n");
				}
					//CIERRE DE TABLA---------------------------------------------------------------------------------
				reporte.write("</tbody>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "				</div>");
				
					//INSTRUCCION 2
				reporte.write("<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 18px;\" align=\"justify\">2. Sumar cada elemento de la Matriz AM con los correspondientes elementos de la Matriz Clave B.<br><br></p>\r\n"
						+ "");
					//SUMA------------------------------------------------------------------------------------------
						//APERTURA DE TABLA-----------------------------------------------------------------------------
				reporte.write("<div class=\"table100 ver1 m-b-110\">\r\n"
						+ "					<div class=\"table100-head\">\r\n"
						+ "						<table>\r\n"
						+ "							<thead>\r\n"
						+ "								<tr class=\"row100 head\">\r\n"
						+ "									<th class=\"cell100 column1\">Matriz AM + B = C</th>\r\n"
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
						reporte.write("<td class=\"cell100 column1\">"+oculto[i][j]+" + "+ClaveB[i][j]+" = "+encriptado[i][j]+"</td>\r\n");
					}
					reporte.write("</tr>\r\n");
				}
						//CIERRE DE TABLA---------------------------------------------------------------------------------
				reporte.write("</tbody>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "				</div>");
				
				//MOSTRAR MENSAJE ENCRIPTADO
				reporte.write("<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 25px;\" align=\"justify\">El mensaje encriptado es: <br>");
				for(int j=0; j<(columnas/3); j++) {
					for(int i=0; i<3; i++) {
						reporte.write(encriptado[i][j]+"&nbsp;&nbsp;");
					}
				}
				reporte.write("<br><br></p>\r\n");
				
				//FECHA Y HORA DE GENERACION
				reporte.write("<p  style=\"color: #0f3007;font-family: sans-serif;font-size: 15px;\" align=\"right\">Generado: "+fechahora.toString()+"<br><br></p>\r\n");
				
				//CAMBIAR DE REPORTE
				reporte.write("<div align=\"center\">\r\n"
						+ "				<a class=\"boton\" href=\"Desencriptacion.html\" style=\"color: #ffffff;\">Reporte Desencriptacion</a>\r\n"
						+ "				</div>");
				
				//CIERRE DE ARCHIVO-----------------------------------------------------------------------------------------------
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
				System.out.println("Aún no se ha encriptado ningún mensaje\n");
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