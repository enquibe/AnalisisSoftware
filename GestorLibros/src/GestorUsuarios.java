import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestorUsuarios {
	
	private ArrayList<Usuario> usuarios;
	private Usuario loggedUser;
	
	public GestorUsuarios() {
		this.setUsuarios(obtenerUsuarios());
	}
	
	private ArrayList<Usuario> obtenerUsuarios() {
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(Constantes.archivoUsuarios));
			String s = "";
			ArrayList<Usuario> ret = new ArrayList<Usuario>();
			while ((s = entrada.readLine()) != null) {
				String cd = "";
				try {
					cd = Encriptacion.Desencriptar(s);
				} catch (Exception e) {
					e.printStackTrace();
				}
				String[] cadena = cd.split(",");
				String usu = cadena[0];
				String con = cadena[1];
				ret.add(new Usuario(usu, con));
			}
			entrada.close();
			return ret;
		} catch (java.io.IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Usuario devuelveUsuario(String u) {
		for (Usuario usuario : usuarios) {
			if (usuario.getUsuario().equals(u))
				return usuario;
		}
		return null;
	}

	public void registrarUsuario(String u, String p) {
		this.usuarios.add(new Usuario(u,p));
		try {
			FileWriter datopac = new FileWriter(Constantes.archivoUsuarios, true);
			String registro = Encriptacion.Encriptar(u + "," + p);
			datopac.write(registro + "\n");
			datopac.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(Usuario loggedUser) {
		this.loggedUser = loggedUser;
	}

}
