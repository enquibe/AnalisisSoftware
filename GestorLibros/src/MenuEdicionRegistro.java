
public class MenuEdicionRegistro extends Menu {

	private final static String CABECERA = "Menú de modificación de campos";
	private final static Opcion[] OPCIONES = {
	        new Opcion(CampoEditable.TITULO, "Título", true, null),
	        new Opcion(CampoEditable.AUTOR, "Autor", true, null),
	        new Opcion(CampoEditable.EDITORIAL, "Editorial", true, null),
	        new Opcion(CampoEditable.EDICION, "Edición", true, null),
	        new Opcion(CampoEditable.ANIOPUBLICACION, "Año de publicación", true, null)
	    };
	public MenuEdicionRegistro() {
		super(CABECERA, OPCIONES);
	}
}
