import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class IOUtil {
	
	private static PrintStream out;
	private static Scanner in;
	
	public static void pausar(String mensaje) {
		out().print(mensaje + "\nPresione <ENTER> para continuar . . . ");
		in().nextLine();
		out().println();
	}
	
	public static int leerEntero(String mensaje) {
		try {
			return Integer.parseInt(leerCadena(mensaje));
		} catch (NumberFormatException e) {
			out.print("Número incorrecto.");
			return leerEntero(mensaje);
		}
	}
	
	public static String leerCadena(String mensaje) {
		System.out.println(mensaje + ": ");
		return leerCadena();
	}
	
	public static String leerCadena() {
		return in().nextLine();
	}
	
	public static void mostrar(Object mensaje) {
		out().println(mensaje);
	}
	
	private static PrintStream out() {
		if (out == null) {
			try {
				out = requiereEncoding() ? new PrintStream(System.out, true, "CP850") : System.out;
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException("Error al instanciar la consola");
			}
		}
		return out;
	}
	
	private static Scanner in() {
		if (in == null) {
			in = requiereEncoding() ? new Scanner(System.in, "CP850") : new Scanner(System.in);
		}
		return in;
	}
	
	private static boolean requiereEncoding() {
		return !System.getProperties().get("os.name").equals("Linux") && System.console() != null;
	}
}
