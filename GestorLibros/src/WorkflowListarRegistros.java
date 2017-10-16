import java.util.List;

public class WorkflowListarRegistros implements Runnable {

	@Override
	public void run() {
		if (Almacen.instancia.estaVacio()) {
			IOUtil.pausar("No hay registros.\n");
			return;
		}
		List<Libro> libros = Almacen.instancia.get(); 
		libros.forEach(x -> IOUtil.mostrar(x));
		IOUtil.mostrar("Total de registros: " + libros.size() + ".");
	}

}
