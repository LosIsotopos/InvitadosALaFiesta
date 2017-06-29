package paqueteFiestero;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;

public class Casamiento {
	private int cantNodos;
	private int cantAristas;
	private boolean[][] matAdy;
	private int solucion;
	
	public Casamiento(String path) throws FileNotFoundException {
		int origen;
		int destino;
		Scanner sc = new Scanner(new File(path));
		cantNodos = sc.nextInt();
		cantAristas = sc.nextInt();
		matAdy = new boolean[cantNodos][cantNodos];
		for (int i = 0; i < cantAristas; i++) {
			origen = sc.nextInt() -1;
			destino = sc.nextInt() -1;
			matAdy[origen][destino] = true;
			matAdy[destino][origen] = true;
		}
		sc.close();
	}
	
	private void resolverColoreo(int[] coloreados) {
		int cantColores = 1;
		int noColoreado = -1;
		int colorBase = 1;
		int color = colorBase;
		int j;
		for (int i = 0; i < coloreados.length; i++) {
			coloreados[i] = noColoreado;
		}
		coloreados[0] = color;
		for (int i = 1; i < coloreados.length; i++) {
			coloreados[i] = color;
			j = 0;
			while (j < cantNodos) {
				if (coloreados[j] == coloreados[i] && matAdy[i][j]) {
					color++;
					coloreados[i] = color;
					if (color > cantColores) {
						cantColores = color;
					}
					j = -1;
				}
				j++;
			}
			color = colorBase;
		}
		
	}
	
	
	public void resolver() {
		int[] coloreados = new int[cantNodos];
		int[] freq = new int[cantNodos];
		int max;
		resolverColoreo(coloreados);
		for (int i = 0; i < freq.length; i++) {
			System.out.print(coloreados[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < coloreados.length; i++) {
			freq[coloreados[i]-1]++;
		}
		max = freq[0];
		for (int i = 1; i < freq.length; i++) {
			if(max < freq[i]) {
				max = freq[i];
			}
		}
		solucion = max;
	}
	
	public void mostrarSolucion() {
		System.out.println(solucion);
	}
}
