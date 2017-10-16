
public class MenuPrincipal extends Menu {
	
	private final static String CABECERA = "GESTOR DE LIBROS";
	
    private final static Opcion[] OPCIONES = {
        new Opcion(1, "Altas", false, new WorkflowAlta()),
        new Opcion(2, "Consultas", false, new WorkflowConsulta()),
        new Opcion(3, "Actualizaciones", false, new WorkflowEdicion()),
        new Opcion(4, "Bajas", false, new WorkflowBaja()),
        new Opcion(5, "Ordenar registros", false, new WorkflowOrdenarRegistros()),
        new Opcion(6, "Listar registros", false, new WorkflowListarRegistros()),
        new Opcion(7, "Salir", true, null)
    };
	
	public MenuPrincipal() {
		super(CABECERA, OPCIONES);
	}
}