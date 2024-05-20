package HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class ServicioDFS<T> {

    private HashMap<Integer, String> colores;
    private HashMap<Integer, LinkedList<Integer>> tiempos;

    public ServicioDFS() {
        this.colores = new HashMap<>();
    }
    
    public void DFS(Grafo<T> grafo){
        Iterator<Integer> it = grafo.obtenerVertices();
        while(it.hasNext()) {
            Integer vertice = it.next();
            colores.put(vertice,"Blanco");
        }
        int tiempo = 0;
        Iterator<Integer> it2 = grafo.obtenerVertices();
        while (it2.hasNext()) {
            Integer vertice = it2.next();
            if(colores.get(vertice) == "Blanco"){
                dfsVisit(grafo,vertice,tiempo);
            }
        }
    }

    private void dfsVisit(Grafo<T> grafo, Integer vertice, int tiempo) {
        System.out.println(" " + vertice);
        colores.put(vertice,"Amarillo");
        tiempo++;
        tiempos.put(vertice, null);
        tiempos.get(vertice).add(tiempo);
        Iterator<Integer> ady = grafo.obtenerAdyacentes(vertice);
        while(ady.hasNext()){
            Integer v = ady.next();
            if(colores.get(v) == "Blanco"){
                dfsVisit(grafo, v, tiempo);
            }
            else if(colores.get(v) == "Amarillo"){
                System.out.println("Hay ciclo");
            }
        }
        colores.put(vertice, "Negro");
        tiempo = tiempo+1;
        tiempos.get(vertice).add(tiempo);
    }

    
}
