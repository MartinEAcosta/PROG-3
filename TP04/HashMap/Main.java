package HashMap;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		// Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
		GrafoDirigido<Integer> grafito = new GrafoDirigido<>();
		
		grafito.agregarVertice(1);
		grafito.agregarVertice(2);
		grafito.agregarVertice(3);
		grafito.agregarVertice(4);
		grafito.agregarVertice(5);
		grafito.agregarVertice(6);


		// Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
		grafito.agregarArco(1, 2, 12);
		grafito.agregarArco(1, 4, 14);
		grafito.agregarArco(2, 3, 23);
		grafito.agregarArco(2, 5, 25);
		grafito.agregarArco(3, 6, 36);
		grafito.agregarArco(6, 5, 65);
		grafito.agregarArco(4, 5, 45);

		ListarVertices algoritmo = new ListarVertices();

		ArrayList<Integer> cam = algoritmo.verticesQueLlegan(grafito,6);

		for(int i = 0; i<cam.size(); i++){
			System.out.println(cam.get(i) + " ");
		}
		
	}

}