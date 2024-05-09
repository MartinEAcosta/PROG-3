package TP04.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {

	/*Integer seria el vertice, y la linkedList los adyacentes a el. */
    private HashMap<Integer, LinkedList<Vertice>> vertices;
	private HashMap<Integer, LinkedList<Arco<T>>> arcos; 

    public GrafoDirigido(){
        vertices = new HashMap<Integer,LinkedList<Vertice>>();
    }

	@Override
	public void agregarVertice(int verticeId) {
		/*Si no contengo el vertice lo agrego*/
		if(!vertices.containsKey(verticeId)){
			/*Al agregar un vertice nuevo no tendra adyacentes
			 * por lo tanto creo la lista vacia.			*/
			LinkedList<Vertice> adyacentes = new LinkedList<>();
			vertices.put(verticeId, adyacentes);
        }
	}

	@Override
	public void borrarVertice(int verticeId) {
		/*Si contengo el vertice */
		if(vertices.containsKey(verticeId)){
			/*Remuevo el vertice */
			vertices.remove(verticeId);
		}
	}


	/*Realicé este metodo creando el HashMap de arcos para no perder la etiqueta. Por otro lado 
	 *	agrego a la lista de adyacentes del vertice 1 de donde se genera la dirección del arco.
	 *	De esta manera quedarian separados por id los vertices y adyacentes, y por otro los vertices y arcos.
	*/
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if(vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)){
			/*Agrego el vertice a la lista de adyacentes del vertice 1*/
			vertices.get(verticeId1).addAll(vertices.get(verticeId2));
			/*Creo la lista de arcos*/
			LinkedList<Arco<T>> relacionArco = new LinkedList<Arco<T>>();
			/*Creo el arco a agregar*/
			Arco<T> arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
			relacionArco.add(arco);
			arcos.put(verticeId1, relacionArco);
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		/*Si existen los dos vertices */
		if(vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)){
			/*Pregunto si verticeId1 contiene como adyacente a verticeId2 */
			Vertice adyacente = vertices.get(verticeId1).get(verticeId2);
			if(adyacente != null){
				/*Elimino el vertice de la lista de adyacentes del vertice 1*/
				vertices.get(verticeId1).remove(adyacente);
				/*Si el verticeId1 contiene arcos*/
				if(arcos.containsKey(verticeId1)){
					/*Elimino el arco*/
					arcos.get(verticeId1).remove(obtenerArco(verticeId1, verticeId2));
				}
			}
		}
	}
	/*Aclaración el arco va existir por que lo creo siempre que agrego un arco tambien. */

	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		return obtenerArco(verticeId1, verticeId2) != null;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if(arcos.containsKey(verticeId1)){
			for(Arco<T> elem : arcos.get(verticeId1)){
				if(elem.getVerticeDestino() == verticeId2){
					return elem;
				}
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		int cant = 0;
		for(LinkedList<Arco<T>> elem : arcos.values()){
			cant += elem.size();
		}
		return cant;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		/*Pregunto si existe vertice*/
		if(vertices.containsKey(verticeId)){
			/*Creo la lista a retornar */
			LinkedList<Integer> retorno = new LinkedList<>();
			/*Por cada vertice adyacente agrego el id a la lista*/
			for(Vertice elem : vertices.get(verticeId)){
				retorno.add(elem.getId());
			}
			return retorno.iterator();
		}
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

}