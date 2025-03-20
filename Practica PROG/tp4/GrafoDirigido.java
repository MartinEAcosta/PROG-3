package tp4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap<Integer, LinkedList<Arco<T>>> arcos;

	public GrafoDirigido(){
		this.arcos = new HashMap<Integer,LinkedList<Arco<T>>>();
	}
	@Override
	public void agregarVertice(int verticeId) {
		if(!arcos.containsKey(verticeId)){
			arcos.put(verticeId, new LinkedList<Arco<T>>());
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		if(arcos.containsKey(verticeId)){
			arcos.get(verticeId).clear();
			arcos.remove(verticeId);
			eliminarReferencias(verticeId);
		}
	}

	private void eliminarReferencias(int verticeId) {
		Iterator<Integer> it = arcos.keySet().iterator();
		while(it.hasNext()){
			Integer key = it.next();
			borrarArco(key, verticeId);
		}
	}
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if(arcos.containsKey(verticeId1) && arcos.containsKey(verticeId2)){
			arcos.get(verticeId1).add(new Arco<T>(verticeId1,verticeId2,etiqueta));
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if(arcos.containsKey(verticeId1) && arcos.containsKey(verticeId2)){
			for (Arco<T> arco : arcos.get(verticeId1)) {
				if(arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2){
					arcos.get(verticeId1).remove(arco);
				}
			}
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return arcos.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if(arcos.containsKey(verticeId1) && arcos.containsKey(verticeId2)){
			for (Arco<T> arco : arcos.get(verticeId1)) {
				if(arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if(arcos.containsKey(verticeId1) && arcos.containsKey(verticeId2)){
			for (Arco<T> arco : arcos.get(verticeId1)) {
				if(arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2){
					return arco;
				}
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return arcos.keySet().size();
	}

	@Override
	public int cantidadArcos() {
		int cantidadArcos = 0;
		for(LinkedList<Arco<T>> lista : arcos.values()){
			cantidadArcos += lista.size();
		}
		return cantidadArcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return arcos.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		if(arcos.containsKey(verticeId)){
			LinkedList<Integer> adyacentes = new LinkedList<Integer>();
			for (Arco<T> arco : arcos.get(verticeId)) {
				adyacentes.add(arco.getVerticeDestino());
			}
			return adyacentes.iterator();
		}
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		LinkedList<Arco<T>> retorno = new LinkedList<Arco<T>>();
		for(LinkedList<Arco<T>> lista : arcos.values()){
			retorno.addAll(lista);
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

}
