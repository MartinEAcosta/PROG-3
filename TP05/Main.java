package TP05;

import java.util.ArrayList;
import java.util.Iterator;

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


	

		ArrayList<ArrayList<Integer>> combi = algortimo.combinacionesPosibles(20);
		for(int i = 0; i<combi.size();i++){
			for(int j = 0; j<combi.get(i).size();j++){
				System.out.print(combi.get(i).get(j) + " ");
			}
			System.out.println("|");
		}
			

	}

}



My apologies for the previous response in English. I am still under development, and I am always learning to improve my ability to respond in Spanish. I will try my best to provide responses in Spanish in the future.

Análisis del Algoritmo Greedy

El algoritmo greedy proporcionado intenta asignar claves a ciudades mientras se asegura de que ninguna ciudad conectada comparta la misma clave y que el número total de claves utilizadas no exceda un límite dado (K). Itera a través de las ciudades, asignando a cada ciudad la primera clave disponible de una copia de las claves disponibles, asegurando que ninguna ciudad conectada comparta la misma clave. Si no queda ninguna clave válida, devuelve falso, lo que indica que no es posible una asignación válida.

Fortalezas

Simplicidad: El algoritmo es sencillo y fácil de entender, lo que lo hace adecuado para su implementación y comprensión.

Eficiencia: El enfoque iterativo del algoritmo permite un procesamiento eficiente de ciudades y asignaciones de claves.

Limitaciones

No optimalidad: El enfoque greedy puede no encontrar siempre la solución óptima, ya que prioriza la optimalidad local sobre la global. En algunos casos, una estrategia diferente de asignación de claves podría conducir a un uso más eficiente de las claves.

Naturaleza heurística: El algoritmo se basa en la suposición de que tomar decisiones localmente óptimas en cada paso conducirá a una solución globalmente óptima. Sin embargo, esto no siempre está garantizado, y el algoritmo puede no encontrar la mejor asignación de claves posible.

Aplicaciones

A pesar de sus limitaciones, el algoritmo greedy puede ser útil en situaciones en las que encontrar una solución óptima es computacionalmente costoso o impráctico. Puede proporcionar una solución rápida y razonablemente buena, especialmente para problemas grandes o complejos.

Mejoras

Las posibles mejoras al algoritmo podrían incluir:

Considerar estrategias alternativas de asignación de claves: Explorar diferentes enfoques para asignar claves, como retroceso o heurísticas más sofisticadas, podría conducir a mejores soluciones.

Evaluar el rendimiento del algoritmo: Analizar el rendimiento del algoritmo en varios conjuntos de datos y tamaños de problemas puede proporcionar información sobre su efectividad y limitaciones.

En general, el algoritmo greedy proporcionado ofrece un enfoque simple y eficiente para asignar claves a ciudades mientras se satisfacen ciertas restricciones. Sin embargo, es importante reconocer sus limitaciones y considerar estrategias alternativas para la optimización.

Additional Notes

I have translated the provided pseudocode into Spanish for better understanding:
Java
Grafo ciudades;
ArrayList<String> claves;
ArrayList<String> clavesDistintas;
// k claves distintas, valor dado por el usuario 
public boolean obtenerClaves(int k){
	ArrayList<String> copiaC = copiar(claves);
	//previamente estarian seteados las claves de las ciudades en "-"
	for(Ciudad a : ciudades.obtenerVertices()){
		if(a.getAdyacentes() != null){
			For(Ciudad ady : a.getAdyacentes){
				if(ady.getClave() != "-"){
					copiaC.remove(ady.getClave());
				}
			}
			if(!copiaC.isEmpty){
				if(!clavesDistintas.contains(copiaC.getFirst())){
					clavesDistintas.add(copiaC.getFirst());
				}
				a.setClave(copiaC.getFirst());
				copiaC = claves;
			}
			else{
				return false;
			}
		}
	}
	if(clavesDistintas.size()<claves.size()){
		return true;
	}
	else{
		return false;
	}
}

//k
public boolean clavesCiudades(Grafo ciudades){
	for(Ciudad c : ciudades.obtenerCiudades()){
		c.setValue('-');
	}
	Iterator<Ciudad> it  = ciudades.obtenerCiudades();
	While(it.hasNext()){
		Ciudad c = it.next();
		for(String clave : mClaves){
			if(sePuede(c,ciudades,clave)){
				c.setClave(clave);
				if(!k.contains(clave)){
					k.add(clave);
				}
			}
		}
	}
	if(k<m.size()){
		return true;
	}
	return false;
}

public boolean sePuede(Ciudad c, Grafo ciudades,String clave){
	ArrayList<Ciudad> ady = ciudades.obtenerAdyacentes(c);
	for(Ciudad ciudadAdyacente : Ciudades){
		if(ciudadAdyacente.getClave().equals(clave)){
			return false;
		}
	}
	return true;
}


public ArrayList<Vertice> obtenerCamino(Vertice origen, Vertice destino, Grafo g){
	ArrayList<Vertice> camino = new ArrayList<Vertice>();
	camino.add(origen);
	camino = obtenerCamino(origen, destino, g,camino);
	return camino;
}

private ArrayList<Vertice> obtenercamino(Vertice actual,Vertice destino, Grafo g){
	if(actual == destino){
		return camino;
	}
	else{
		Iterator<Vettice> it = g.obtenerAdyacentes(actual);
		while(it.hasNext()){
			Vertice ad = it.next();
			if(!actual.getColor().equals(ad.getColor())){
				camino.add(ad);
				obtenerCamino(ad,destino,g,camino);
				camino.remove(ad);
			}
		}
	}
}


public ArrayList<Celda> obtenerCamino(Celda origen, Celda destino){
	ArrayList<Celda> camino = new ArrayList<Celda>();
	camino.add(origen);
	while(origen != destino && !origen.estaVisitado()){
		Celda adyacente = seleccionarMovimiento(origen.obtenerAdyacentes(),origen.getValor());
		if(!adyacente.estaVisitado()){
			camino.add(adyacente);
			adyacente.setVisitado(true);
			origen = adyacente;
		}
	}
	if(origen == destino){
		return caminoActual;
	}
	return null;
}

public Celda seleccionarMovimiento(ArrayList<Celda> ady , int value){
	Celda mejor = null;
	for(Celda c : ady){
		if(c.getValor() > value){
			if(mejor == null || c.getValor() > mejor.getValor()){
				mejor = c;
			}
		}
	}
}


Conjunto;
Sol;
public arraylist<Arraylist<integer>> obtenerSumaIgualAT(int t){
	ArrayList<ArrayList<Integer>> camino = new ArrayList<ArrayList<Integer>();
	while(sol.size() > 4){
		for(Integer nro : Conjunto){
			camino.add(nro);
			obtenerSumaIgualAT(t,camino,nro,nro);
			camino.remove(nro)
		}
	}
	return sol;
}

private ArrayList<ArrayList<Integer>> obtenerSumaIgualAT(int t, ArrayList<ArrayList<Integer>> camino,int nro, int sumaActual){
	if(sumaActual == t){
		sol.add(camino);
		return camino;
	}
	else{
		Iterator<Integer> it = Conjunto.iterator();
		while(it.hasNext()){
			Integer sig = it.next();
			if(sumaActual + sig <= t && sig != nro){
				camino.add(sig);
				obtenerSumaIgualAT(t,camino,sig,sumaActual + sig);
				camino.remove(sig);	
			}
		}
	}
	return null;
}