package TP04.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {

	/*Se guarda el id del vertice y la lista de arcos, de aca en un futuro se saca la lista de adyacentes */
	private HashMap<Integer, LinkedList<Arco<T>>> arcos; 

    public GrafoDirigido(){
		arcos = new HashMap<Integer, LinkedList<Arco<T>>>();
    }

	@Override
	public void agregarVertice(int verticeId) {
		/*Si no contengo el vertice lo agrego a mi HashMap*/
		if(!arcos.containsKey(verticeId)){
			arcos.put(verticeId,null);
        }
	}

	@Override
	public void borrarVertice(int verticeId) {
		/*Si contengo el vertice */
		if(arcos.containsKey(verticeId)){
			/*Remuevo el vertice */
			arcos.remove(verticeId);
			/*Remuevo los arcos vinculados a mi vertice*/
			arcos.get(verticeId).clear();
			/*Recorro los vertices para ver si hay algun arco que contenga el verticeId*/
			eliminarRelacionAdyacencia(verticeId);
		}
	}


	/*Realicé este metodo creando el HashMap de arcos para no perder la etiqueta. Por otro lado 
	 *	agrego a la lista de adyacentes del vertice 1 de donde se genera la dirección del arco.
	 *	De esta manera quedarian separados por id los vertices y adyacentes, y por otro los vertices y arcos.
	*/
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if(arcos.containsKey(verticeId1) && arcos.containsKey(verticeId2)){
			/*Creo el arco a agregar*/
			Arco<T> arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
			arcos.get(verticeId1).add(arco);
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		/*Si existen los dos vertices */
		if(arcos.containsKey(verticeId1) && arcos.containsKey(verticeId2)){
			/*Pregunto si verticeId1 contiene como adyacente a verticeId2 */
			Arco<T> elemAEliminar = obtenerArco(verticeId1, verticeId2);
			if(elemAEliminar != null){
				/*Si existe el arco lo elimino*/
				arcos.get(verticeId1).remove(elemAEliminar);
			}
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return arcos.containsKey(verticeId);
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
		return arcos.size();
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
		return arcos.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		/*Pregunto si existe vertice*/
		if(arcos.containsKey(verticeId)){
			/*Creo la lista a retornar */
			LinkedList<Integer> retorno = new LinkedList<>();
			for(Arco<T> elem : arcos.get(verticeId)){
				retorno.add(elem.getVerticeDestino());
			}
			return retorno.iterator();
		}
		return null;
	}
	/*return arcos.get(verticeId).iterator();/ */

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		/*Creo la lista a retornar */
		LinkedList<Arco<T>> retorno = new LinkedList<Arco<T>>();
		/*Itero cada una de mis listas de arcos de cada uno de los vertices */
		for(LinkedList<Arco<T>> elem : arcos.values()){
			/*Agrego las listas de arcos de cada uno de mis vertices */
			retorno.addAll(elem);
		}
		return retorno.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		if(arcos.containsKey(verticeId)){
			return arcos.get(verticeId).iterator();
		}
		return null;
	}

	public void eliminarRelacionAdyacencia(int verticeId){
		for(LinkedList<Arco<T>> elem : arcos.values()){
			for(Arco<T> arco : elem){
				if(arco.getVerticeDestino() == verticeId){
					elem.remove(arco);
				}
			}
		}
	}
}