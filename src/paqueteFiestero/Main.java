package paqueteFiestero;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Casamiento c = new Casamiento("casamiento1.in");
		c.resolver();
		c.mostrarSolucion();

	}

}
