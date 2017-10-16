
public class WorkflowOrdenarRegistros implements Runnable {

	@Override
	public void run() {
		if (Almacen.instancia.estaVacio()) {
			IOUtil.pausar("No hay registros.\n");
		}

		Almacen.instancia.ordenar();
		IOUtil.mostrar("Registros ordenados correctamente.");
	}

}
