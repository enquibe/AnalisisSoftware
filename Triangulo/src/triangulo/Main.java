package triangulo;

public class Main {

	public static void main(String[] args) throws TrianguloInvalidoException {
		Triangulo t = new Triangulo(10, 15, 11);

		System.out.println(t.getTipoTriangulo());
	}

}
