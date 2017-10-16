import java.util.Optional;

public class WorkflowAlta implements Runnable {

	@Override
	public void run() {
		String ISBN = IOUtil.leerCadena("Ingrese el ISBN del libro");
		Optional<Libro> dato = Almacen.instancia.get(ISBN);
		if (dato.isPresent()) {
			IOUtil.mostrar(dato.get());
			IOUtil.mostrar("El registro ya existe.");
			return;
		}

		Libro nuevoLibro = new Libro();
		nuevoLibro.setISBN(ISBN);
		nuevoLibro.setTitulo(IOUtil.leerCadena("Ingrese el titulo"));
		nuevoLibro.setAutor(IOUtil.leerCadena("Ingrese el autor"));
		nuevoLibro.setEditorial(IOUtil.leerCadena("Ingrese el editorial"));
		nuevoLibro.setEdicion(IOUtil.leerEntero("Ingrese el edicion"));
		nuevoLibro.setAnno_de_publicacion(IOUtil.leerEntero("Ingrese el anno de publicacion"));
		Almacen.instancia.agregar(nuevoLibro);
		IOUtil.mostrar("\nRegistro agregado correctamente.");
	}

}