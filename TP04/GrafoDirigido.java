package TP04;

import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {

	private LinkedList<Vertice> vertices;

	public GrafoDirigido(){
		this.vertices = new LinkedList<Vertice>();
	}

	@Override
	public void agregarVertice(int verticeId) {
		if(!contieneVertice(verticeId)){
			vertices.add(new Vertice(verticeId));
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		for(int i = 0; i<vertices.size();i++){
			if(vertices.get(i).getID() == verticeId){
				vertices.remove(i);
			}
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if(contieneVertice(verticeId1) && contieneVertice(verticeId2) && !existeArco(verticeId1, verticeId2)){
			Arco<T> arco = new Arco<T>(verticeId1, verticeId2, etiqueta);
			Vertice v1 = obtenerVertice(verticeId1);
			v1.addAdyacente(arco);
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if(existeArco(verticeId1,verticeId2)){
			Vertice v1 = obtenerVertice(verticeId1);
			v1.borrarArco(verticeId1, verticeId2);
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		for(int i = 0; i<vertices.size();i++){
			if(vertices.get(i).getID() == verticeId){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		Vertice v1 = obtenerVertice(verticeId1);
		Vertice v2 = obtenerVertice(verticeId2);
		if(v1 != null && v2 != null){	
			if(v1.getArco(verticeId1, verticeId2) != null){
					return true;
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		Vertice v1 = obtenerVertice(verticeId1);
		Vertice v2 = obtenerVertice(verticeId2);
		if(v1 != null && v2 != null){
			return v1.getArco(verticeId1, verticeId2);
		}
		return null;
	}

	public Vertice obtenerVertice(int verticeId){
		for(Vertice elem : vertices){
			if(elem.getID() == verticeId){
				return elem;
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
		int aux = 0;
		for(Vertice elem : vertices){
			aux += elem.getCantAdyacentes();
		}
		return aux;
	}

	@Override
	public Iterator<Vertice> obtenerVertices() {
		return vertices.iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		Vertice v = obtenerVertice(verticeId);
		LinkedList<Integer> retorno = new LinkedList<Integer>();
		if(v != null){
			for(Arco<T> elem : v.getAdyacentes()){
				retorno.add(elem.getVerticeDestino());
			}
		}
		return retorno.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(){
		LinkedList<Arco<T>> retorno = new LinkedList<>();
		for(Vertice elem : vertices){
			retorno.addAll(elem.getAdyacentes());
		}
		return retorno.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		Vertice v1 = obtenerVertice(verticeId);
		LinkedList<Arco<T>> retorno = v1.getAdyacentes();
		return retorno.iterator();
	}

}