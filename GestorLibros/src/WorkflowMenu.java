
public abstract class WorkflowMenu implements Runnable {

	private final Menu menu;
	
	public WorkflowMenu(Menu menu) {
		this.menu = menu;
	}
	
	@Override
	public void run() {
		while (true) {
			Opcion opcion = menu.mostrar();
			if (opcion.indicaSalir()) return;
			opcion.ejecutar();
		}
	}

}
