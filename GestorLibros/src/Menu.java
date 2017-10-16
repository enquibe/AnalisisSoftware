
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;


public abstract class Menu {
	
	private final String cabecera;
	private final Opcion[] opciones;
	
	public Menu(String cabecera, Opcion[] opciones) {
		this.cabecera = cabecera;
		this.opciones = Objects.requireNonNull(opciones);
	}
	
	public Opcion mostrar() {
		IOUtil.mostrar(cabecera);
		Arrays.stream(opciones).forEach(this::imprimirOpcion);
		
		Optional<Opcion> opcion = get(IOUtil.leerEntero("Seleccione una opción"));
		while (!opcion.isPresent()) {
			IOUtil.mostrar("Opción no válida");
			opcion = get(IOUtil.leerEntero("Seleccione una opción"));
		}
		return opcion.get();
	}
	
	private Optional<Opcion> get(int codigo) {
		return Arrays.stream(opciones).filter(x -> x.codigo() == codigo).findAny();
	}
	
	private void imprimirOpcion(Opcion opcion) {
		IOUtil.mostrar(opcion.codigo() + " - " + opcion.descripcion());
	}
}