import java.util.Objects;

public class Opcion {
	private final int codigo;
	private final String descripcion;
	private final boolean indicaSalir;
	private final Runnable workflow; // Puede ser null
	
	public Opcion(int codigo, String descripcion, boolean indicaSalir, Runnable workflow) {
        this.codigo = codigo;
        this.descripcion = Objects.requireNonNull(descripcion);
        this.indicaSalir = indicaSalir;
        this.workflow = workflow;
    }
	
	public int codigo() {
		return codigo;
	}
	
	public String descripcion() {
		return descripcion;
	}
	
	public boolean indicaSalir() {
		return indicaSalir;
	}
	
	public void ejecutar() {
		workflow.run();
	}
}