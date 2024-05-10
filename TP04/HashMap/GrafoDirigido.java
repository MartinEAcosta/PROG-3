package TP04.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {

	/*Integer seria el id del vertice, Luego el vertice en si */
    private HashMap<Integer, Vertice> vertices;
	/*Se guarda el id del vertice y la lista de arcos, de aca en un futuro se saca la lista de adyacentes */
	private HashMap<Integer, LinkedList<Arco<T>>> arcos; 

    public GrafoDirigido(){
        vertices = new HashMap<Integer,Vertice>();
		arcos = new HashMap<Integer, LinkedList<Arco<T>>>();
    }

	@Override
	public void agregarVertice(int verticeId) {
		/*Si no contengo el vertice lo agrego a mi HashMap*/
		if(!vertices.containsKey(verticeId)){
			/*Creo el vertice*/
			Vertice vertice = new Vertice(verticeId,null);
			/*Agrego el vertice*/
			vertices.put(verticeId, vertice);
        }
	}

	@Override
	public void borrarVertice(int verticeId) {
		/*Si contengo el vertice */
		if(vertices.containsKey(verticeId)){
			/*Remuevo el vertice */
			vertices.remove(verticeId);
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
		if(vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)){
			LinkedList<Arco<T>> listaArcos = new LinkedList<>();
			if(!arcos.containsKey(verticeId1)){
				arcos.put(verticeId1, listaArcos);
			}
			else{
				listaArcos = arcos.get(verticeId1);
			}
			/*Creo el arco a agregar*/
			Arco<T> arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
			listaArcos.add(arco);
			arcos.put(verticeId1, listaArcos);
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		/*Si existen los dos vertices */
		if(vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)){
			/*Pregunto si verticeId1 contiene como adyacente a verticeId2 */
			Arco<T> elemAEliminar = obtenerArco(verticeId1, verticeId2);
			if(elemAEliminar != null){
				/*Si existe el arco lo elimino*/
				arcos.remove(verticeId1,elemAEliminar);
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
			for(Arco<T> elem : arcos.get(verticeId)){
				retorno.add(elem.getVerticeDestino());
			}
			return retorno.iterator();
		}
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		/*Creo la lista a retornar */
		LinkedList<Arco<T>> retorno = new LinkedList<>();
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