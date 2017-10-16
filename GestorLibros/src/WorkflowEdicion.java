import java.util.Optional;

public class WorkflowEdicion implements Runnable {
	
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
			return;
		}
		
		Libro libroModificar = dato.get();
		IOUtil.mostrar(libroModificar);
		new WorkflowEdicionRegistro(libroModificar).run();
	}

}
