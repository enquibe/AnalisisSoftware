import java.util.Optional;

public class WorkflowConsulta implements Runnable {

	@Override
	public void run() {
		if (Almacen.instancia.estaVacio()) {
			IOUtil.pausar("No hay registros.\n");
			return;
		}

		String ISBN = IOUtil.leerCadena("Ingrese el ISBN del libro");
		Optional<Libro> dato = Almacen.instancia.get(ISBN);
		if (!dato.isPresent()) {
			IOUtil.mostrar("\nRegistro no encontrado.");
		} else {
			IOUtil.mostrar(dato.get());
		}
	}

}
