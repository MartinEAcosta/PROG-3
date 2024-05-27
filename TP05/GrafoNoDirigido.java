package TP05;

import java.util.ArrayList;
import java.util.Iterator;

public class GrafoNoDirigido<T> extends GrafoDirigido<T> {

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		super.agregarArco(verticeId1, verticeId2, etiqueta);
		super.agregarArco(verticeId2, verticeId1, etiqueta);
	}
	
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		super.borrarArco(verticeId1, verticeId2);
		super.borrarArco(verticeId2, verticeId1);
	}

	@Override
	public int cantidadArcos() {
		return super.cantidadArcos() / 2;
	}

	public ArrayList<Integer> caminoMenor(int origen, int destino,ArrayList<Integer> visitados){
		visitados.add(origen);
		ArrayList<Integer> caminoMenor = new ArrayList<Integer>();
		if(origen == destino){
			caminoMenor.add(origen);
		}
		else{
			Iterator<Integer> ady = obtenerAdyacentes(origen);
			while(ady.hasNext()){
				int verticeAdy = ady.next();
				if(!visitados.contains(verticeAdy)){
					ArrayList<Integer> camino = caminoMenor(verticeAdy, destino, visitados);
					if((camino != null) && (camino.size() <= caminoMenor.size())){
						caminoMenor.clear();
						caminoMenor.add(origen);
						caminoMenor.addAll(camino);
					}
				}
			}
		}
		visitados.remove(destino);
		return caminoMenor;
	}
}