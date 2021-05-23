package Reportes;
import static ActividadComida.ControladorComer.comidas;
import static Alimentos.ControladorAlimento.alimentos;
import static Pokemons.ControladorPokemon.pokemons;

import java.io.FileWriter;

import Menu.Menu;
public class ReporteAlimentar {
	public static void reportar() {
		if(comidas!=null) {
			try {
				FileWriter reporte = new FileWriter("Reportes/Comidas.html");
				reporte.write("<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "	<title>Comidas</title>\r\n"
						+ "	<meta charset=\"UTF-8\">\r\n"
						+ "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
						+ "<!--===============================================================================================-->	\r\n"
						+ "	<link rel=\"icon\" type=\"image/png\" href=\"images/icons/pokeball.png\"/>\r\n"
						+ "<!--===============================================================================================-->\r\n"
						+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/bootstrap/css/bootstrap.min.css\">\r\n"
						+ "<!--===============================================================================================-->\r\n"
						+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\">\r\n"
						+ "<!--===============================================================================================-->\r\n"
						+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animate/animate.css\">\r\n"
						+ "<!--===============================================================================================-->\r\n"
						+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/select2/select2.min.css\">\r\n"
						+ "<!--===============================================================================================-->\r\n"
						+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/perfect-scrollbar/perfect-scrollbar.css\">\r\n"
						+ "<!--===============================================================================================-->\r\n"
						+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"css/util.css\">\r\n"
						+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\r\n"
						+ "<!--===============================================================================================-->\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "	<ul class=\"Menu\">\r\n"
						+ "			<li> <img src=\"img/logoPokemon.png\" width=\"120\" height=\"35\"></li>\r\n"
						+ "			<li><a href=\"Entrenadores.html\"><img src=\"img/pokebola.png\" width=\"35\" height=\"35\"> Entrenadores</a></li>\r\n"
						+ "			<li><a href=\"PokemonSalvajes.html\"><img src=\"img/mewtwo.png\" width=\"25\" height=\"35\"> Pokemons Salvajes</a></li>\r\n"
						+ "			<li><a href=\"#\"><img src=\"img/comida.png\" width=\"35\" height=\"35\"> Comidas</a></li>\r\n"
						+ "			<li><a href=\"Peleas.html\"><img src=\"img/pelea.png\" width=\"35\" height=\"35\"> Peleas</a></li>\r\n"
						+ "			<li><a href=\"Top5Pokemons.html\"><img src=\"img/top5.png\" width=\"35\" height=\"35\"> Top 5 Pokemons</a></li>\r\n"
						+ "			<li><a href=\"Top5Alimentos.html\"><img src=\"img/top5.png\" width=\"35\" height=\"35\"> Top 5 Alimentos</a></li>\r\n"
						+ "		</ul>\r\n"
						+ "	<div class=\"limiter\">\r\n"
						+ "		<div class=\"container-table100\">\r\n"
						+ "			<div class=\"wrap-table100\">\r\n"
						+ "				<div class=\"table100 ver3 m-b-110\">\r\n"
						+ "					<div class=\"table100-head\">\r\n"
						+ "						<table>\r\n"
						+ "							<thead>\r\n"
						+ "								<tr class=\"row100 head\">\r\n"
						+ "									<th class=\"cell100 column5\">Alimento</th>\r\n"
						+ "									<th class=\"cell100 column2\">Salud</th>\r\n"
						+ "									<th class=\"cell100 column3\">Pokemon</th>\r\n"
						+ "								</tr>\r\n"
						+ "							</thead>\r\n"
						+ "						</table>\r\n"
						+ "					</div>\r\n"
						+ "\r\n"
						+ "					<div class=\"table100-body js-pscroll\">\r\n"
						+ "						<table>\r\n"
						+ "							<tbody>\r\n");
					for(int k=0; k<comidas.length;k++) {
						if(comidas[k]!=null) {
							for(int i=0; i<alimentos.length; i++) {
								if(alimentos[i]!=null) {
									if(alimentos[i].id==comidas[k].getIdAlimento()) {
										reporte.write("<tr class=\"row100 body\">\r\n");
										reporte.write("<td class=\"cell100 column5\">"+alimentos[i].getNombre()+"</td>\r\n");
										reporte.write("<td class=\"cell100 column2\">"+alimentos[i].getVida()+"</td>\r\n");
										//System.out.print(alimentos[i].getNombre()+" ");
										//System.out.print(alimentos[i].getVida()+" ");
										break;
									}
								}
							}
							for(int i=0; i<pokemons.length; i++) {
								if(pokemons[i]!=null) {
									if(pokemons[i].id==comidas[k].getIdPokemon()) {
										reporte.write("<td class=\"cell100 column2\">"+pokemons[i].getNombre()+"</td>\r\n");
										reporte.write("</tr>\r\n");
										//System.out.print(pokemons[i].getNombre()+"\n");
										break;
									}
								}
							}
						}
					}
					reporte.write("</tbody>\r\n"
							+ "						</table>\r\n"
							+ "					</div>\r\n"
							+ "				</div>\r\n"
							+ "			</div>\r\n"
							+ "		</div>\r\n"
							+ "	</div>\r\n"
							+ "\r\n"
							+ "\r\n"
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
					System.out.println("¡Reporte Enviado!\n");
					reporte.close();
			}catch(Exception e) {
				System.out.println("Aún no se puede reportar\n");
			}
			Menu menu = new Menu();
			menu.menu();
		}else {
			System.out.println("Aún no se puede reportar\n");
			Menu menu = new Menu();
			menu.menu();
		}
	}
}