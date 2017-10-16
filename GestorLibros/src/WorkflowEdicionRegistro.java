import java.util.Objects;

public class WorkflowEdicionRegistro implements Runnable {

	private final Menu menu;
	private Libro libro; 
	
	public WorkflowEdicionRegistro(Libro libro) {
		menu = new MenuEdicionRegistro();
		this.libro = Objects.requireNonNull(libro);
	}

	@Override
	public void run() {
		Opcion opcion = menu.mostrar();
		switch (opcion.codigo()) {
		case CampoEditable.TITULO:
			libro.setTitulo(IOUtil.leerCadena("Ingrese el nuevo titulo"));
			break;
		case CampoEditable.AUTOR:
			libro.setAutor(IOUtil.leerCadena("Ingrese el nuevo autor"));
			break;
		case CampoEditable.EDITORIAL:
			libro.setEditorial(IOUtil.leerCadena("Ingrese el nuevo editorial"));
			break;
		case CampoEditable.EDICION:
			libro.setEdicion(IOUtil.leerEntero("Ingrese el nuevo edicion"));
			break;
		case CampoEditable.ANIOPUBLICACION:
			libro.setAnno_de_publicacion(IOUtil.leerEntero("Ingrese el nuevo anno de publicacion"));
			break;
		}
		IOUtil.mostrar("\nRegistro actualizado correctamente.");
	}

}
