import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Almacen {
	private static final String NOMBRE_ARCHIVO = "datos.dat";
	public static final Almacen instancia = new Almacen();
	public final List<Libro> libros;


	private Almacen() {
		libros = new ArrayList<>();
		try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO))) {
			Object objeto;
			while (true) {
				objeto = stream.readObject();
				if (objeto instanceof Libro) {
					libros.add((Libro)objeto);
				}
			}
		} catch (FileNotFoundException | EOFException e) {
			// No pasa naranja.
		} catch (IOException | ClassCastException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Libro> get() {
		return libros;
	}
	
	public Optional<Libro> get(String ISBN) {
		return libros.stream().filter(libro -> libro.getISBN().equals(ISBN)).findAny();
	}
	
	public void agregar(Libro libro) {
		libros.add(libro);
	}
	
	public void eliminar(Libro libro) {
		libros.remove(libro);
	}
	
	public boolean estaVacio() {
		return libros.isEmpty();
	}
	
	public void ordenar() {
		Collections.sort(libros);
	}

	public void guardar() {
		try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))) {
			for (Object objeto : libros)
				stream.writeObject(objeto);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
