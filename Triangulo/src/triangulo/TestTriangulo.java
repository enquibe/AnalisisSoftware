package triangulo;

import org.junit.Assert;
import org.junit.Test;

public class TestTriangulo {

	@Test
	public void test1() throws Exception {
		Triangulo t = new Triangulo(10, 15, 11);
		Assert.assertTrue(t.getTipoTriangulo() == TipoTriangulo.ESCALENO);
	}

	@Test
	public void test2() throws Exception {
		Triangulo t = new Triangulo(10, 10, 5);
		Assert.assertTrue(t.getTipoTriangulo() == TipoTriangulo.ISOSCELES);
	}

	@Test
	public void test3() throws Exception {
		Triangulo t = new Triangulo(5, 5, 5);
		Assert.assertTrue(t.getTipoTriangulo() == TipoTriangulo.EQUILATERO);
	}

	@Test
	public void test4a() throws Exception {
		Triangulo t = new Triangulo(5, 5, 6);
		Assert.assertTrue(t.getTipoTriangulo() == TipoTriangulo.ISOSCELES);
	}

	@Test
	public void test4b() throws Exception {
		Triangulo t = new Triangulo(5, 6, 5);
		Assert.assertTrue(t.getTipoTriangulo() == TipoTriangulo.ISOSCELES);
	}

	@Test
	public void test4c() throws Exception {
		Triangulo t = new Triangulo(6, 5, 5);
		Assert.assertTrue(t.getTipoTriangulo() == TipoTriangulo.ISOSCELES);
	}

	@Test(expected = TrianguloInvalidoException.class)
	public void test5() throws Exception {
		new Triangulo(0, 5, 7);
	}

	@Test(expected = TrianguloInvalidoException.class)
	public void test6() throws Exception {
		new Triangulo(-2, 3, 4);

	}

	@Test(expected = TrianguloInvalidoException.class)
	public void test7() throws Exception {
		new Triangulo(5, 5, 10);

	}

	@Test(expected = TrianguloInvalidoException.class)
	public void test8a() throws Exception {
		new Triangulo(3, 3, 6);

	}

	@Test(expected = TrianguloInvalidoException.class)
	public void test8b() throws Exception {
		new Triangulo(3, 6, 3);

	}

	@Test(expected = TrianguloInvalidoException.class)
	public void test8c() throws Exception {
		new Triangulo(6, 3, 3);

	}

	@Test(expected = TrianguloInvalidoException.class)
	public void test9() throws Exception {
		new Triangulo(2, 5, 10);
	}

	@Test(expected = TrianguloInvalidoException.class)
	public void test10a() throws Exception {
		new Triangulo(3, 4, 10);
	}

	@Test(expected = TrianguloInvalidoException.class)
	public void test10b() throws Exception {
		new Triangulo(3, 10, 4);
	}

	@Test(expected = TrianguloInvalidoException.class)
	public void test10c() throws Exception {
		new Triangulo(10, 3, 4);
	}

	@Test(expected = TrianguloInvalidoException.class)
	public void test11() throws Exception {
		new Triangulo(0, 0, 0);
	}

	@Test
	public void test12() throws Exception {
		// Triangulo t = new Triangulo(10.5, 5, 12);
	}

	@Test
	public void test13() throws Exception {
		// Triangulo t = new Triangulo(10, 2, 15);
	}
}
