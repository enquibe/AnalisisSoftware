package triangulo;

public class Triangulo {
	private int a, b, c;

	public Triangulo(int ladoA, int ladoB, int ladoC) throws TrianguloInvalidoException {
		
		if (!esTriangulo(ladoA, ladoB, ladoC)) {
			throw new TrianguloInvalidoException("Las medidas no forman un triangulo");
		}
		
		this.a = ladoA;
		this.b = ladoB;
		this.c = ladoC;

	}

	private boolean esTriangulo(int a, int b, int c) {
		return (a + b > c) && (a + c > b) && (b + c > a);
	}

	public TipoTriangulo getTipoTriangulo() {
		if (this.a == this.b && this.b == this.c)
			return TipoTriangulo.EQUILATERO;
		if (this.a == this.b || this.a == this.c || this.b == this.c)
			return TipoTriangulo.ISOSCELES;
		return TipoTriangulo.ESCALENO;
	}

}
