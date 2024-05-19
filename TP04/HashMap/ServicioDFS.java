package HashMap;

import java.util.HashMap;
import java.util.Iterator;

public class ServicioDFS<T> {

    private HashMap<Integer, String> colores;
 
    public ServicioDFS() {
        this.colores = new HashMap<>();
    }
    
    public void DFS(Grafo<T> grafo){
        Iterator<Integer> it = grafo.obtenerVertices();
        while(it.hasNext()) {
            Integer vertice = it.next();
            colores.put(vertice,"Blanco");
        }
        Iterator<Integer> it2 = grafo.obtenerVertices();
        while (it2.hasNext()) {
            Integer vertice = it2.next();
            if(colores.get(vertice) == "Blanco"){
                dfsVisit(grafo,vertice);
            }
        }
    }

    private void dfsVisit(Grafo<T> grafo, Integer vertice) {
        System.out.println(" " + vertice);
        colores.put(vertice,"Amarillo");
        Iterator<Integer> ady = grafo.obtenerAdyacentes(vertice);
        while(ady.hasNext()){
            Integer v = ady.next();
            if(colores.get(v) == "Blanco"){
                dfsVisit(grafo, v);
            }
            else if(colores.get(v) == "Amarillo"){
                System.out.println("Hay ciclo");
            }
            colores.put(v, "Negro");
        }
    }
}
