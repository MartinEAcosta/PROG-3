package TP05;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		/* 	
		// Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
		GrafoDirigido<Integer> grafito = new GrafoDirigido<>();
		
		// Agrego los vertices 1 y 2
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
		
		LongestBranch<Integer> branch = new LongestBranch<>();

		ArrayList<Integer> camino = branch.getLongestExit(grafito, 1, 5);

		for(int i = 0; i<camino.size();i++){
			System.out.print(camino.get(i) + " ");
		}
		*/

		/*
		Casilla[][] valores = {
			{new Casilla(7, false, true, true, false), new Casilla(11, false, true, false, false), new Casilla(6, false, false, true, false)},
			{new Casilla(3, false, false, true, false), new Casilla(9, false, false, false, false), new Casilla(4, false, false, true, false)},
			{new Casilla(5, false, true, false, false), new Casilla(2, false, true, false, false), new Casilla(1, false, false, false, true)}
		};
		
		
		Matriz mat = new Matriz(valores);
		
		for(int i = 0; i<3;i++){
			for(int j = 0; j<3;j++){
				System.out.print(mat.getByPos(j, i) +" ");
			}
			System.out.println("");
		}



		ShortestWay algoritmo = new ShortestWay();

		System.out.println(algoritmo.getShortestWay(mat, 0, 0, 1, 2));
 	*/

	Conjunto algortimo = new Conjunto();
	algortimo.addSubconjunto(6);
	algortimo.addSubconjunto(15);
	algortimo.addSubconjunto(5);
	algortimo.addSubconjunto(3);
	algortimo.addSubconjunto(2);

	HashMap<Integer,ArrayList<Integer>> combinaciones = algortimo.combinacionesIgualAX(20);

	for(Integer elem : combinaciones.values().iterator().next()){
		System.out.println(elem + " : " + combinaciones.get(elem));
	}
	}

}
