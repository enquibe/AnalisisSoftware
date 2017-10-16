import java.util.Optional;

public class WorkflowBaja implements Runnable {

	@Override
	public void run() {
		if (Almacen.instancia.estaVacio()) {
			IOUtil.pausar("No hay registros.\n");
		}

		String ISBN = IOUtil.leerCadena("Ingrese el ISBN del libro");
		Optional<Libro> dato = Almacen.instancia.get(ISBN);
		if (!dato.isPresent()) {
			IOUtil.mostrar("\nRegistro no encontrado.");
		} else {
			Libro libroEliminar = dato.get();
			IOUtil.mostrar(libroEliminar);
			Almacen.instancia.eliminar(libroEliminar);
			IOUtil.mostrar("Registro borrado correctamente.");
		}
	}

}
