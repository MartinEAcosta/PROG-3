package HashMap;

import java.util.ArrayList;
import java.util.Iterator;

public class ListarVertices{


    public ArrayList<Integer> verticesQueLlegan(GrafoDirigido<Integer> grafo, int destino){
		ArrayList<Integer> llegaron = new ArrayList<>();
		Iterator<Integer> listaVertices = grafo.obtenerVertices();
		while (listaVertices.hasNext()) {
			int i = listaVertices.next();
			if(!llegaron.contains(i)){
				llegaron.addAll(verticesQueLlegan(grafo, destino,i,new ArrayList<Integer>()));
			}
		}
		return llegaron;
	}

	private ArrayList<Integer> verticesQueLlegan(GrafoDirigido<Integer> grafo, int destino, int actual,ArrayList<Integer> camino){
		if(actual != destino){
			Iterator<Integer> ady = grafo.obtenerAdyacentes(actual);
			while(ady.hasNext()){
				int vAdy = ady.next();
				camino = verticesQueLlegan(grafo, destino, vAdy, camino);
                if(camino.contains(destino)){
                    camino.add(actual);
                    return camino;
			    }
                  
            }
		}
		else{
            camino.add(actual);
			return camino;
		}
        return new ArrayList<>();
	}
	
}