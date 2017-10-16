import java.io.*;
import java.util.*;

public class Main {

	public static Scanner teclado = new Scanner(System.in);
	public static PrintStream out = System.out;
	
	public static void main(String[] args) {
		new WorkflowPrincipal().run();
		Almacen.instancia.guardar();
	}

}