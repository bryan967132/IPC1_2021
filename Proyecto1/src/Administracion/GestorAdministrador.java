package Administracion;
public class GestorAdministrador {
	public static Administrador[] administrador = new Administrador[1];
	public boolean existeusuario(String usuario) {
		for(Administrador u:administrador) {
			if(u!=null && u.usuario.equals(usuario))
				return true;
		}
		return false;
	}
	public boolean insertarusuario(String nombre, String password) {
		if(existeusuario(nombre))return false;
		for(int i =0; i<10;i++) {
			if(administrador[i]==null) {
				administrador[i]= new Administrador(nombre,password);
				return true;
			}
		}
		return false;
	}	
	public Administrador getusuario(String nombre) {
		for(Administrador u:administrador) {
			if(u!=null && u.usuario.equals(nombre))
				return u;
		}
		return null;
	}
	public boolean iniciarsesion(String nombre, String password) {
		for(Administrador u:administrador) {
			if(u!=null && u.usuario.equals(nombre) && u.contraseña.equals(password)) {
				return true;
			}
		}
		return false;
	}
}