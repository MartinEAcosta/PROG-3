package HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class ServicioBFS<T> {
    
    private HashMap<Integer,String> nodos;
    private Queue<Integer> cola = new LinkedList<>();
    
    public ServicioBFS(){
        this.nodos = new HashMap<Integer,String>();
        this.cola = new LinkedList<>();
    }

    public void BFS(Grafo<T> grafo){
        cola.clear();
        Iterator<Integer> it = grafo.obtenerVertices();
        while(it.hasNext()){
            Integer v = it.next();
            nodos.put(v, "NO VISITADO");
        }
        Iterator<Integer> it2 = grafo.obtenerVertices();
        while(it2.hasNext()){
            Integer v = it2.next();
            if(nodos.get(v).equals("NO VISITADO")){
                BFSvisit(grafo, v);
            }
        }
    }

    public void BFSvisit(Grafo<T> grafo, int vertice){
        nodos.put(vertice, "VISITADO");
        cola.add(vertice);
        while(!cola.isEmpty()){
            Integer v = cola.poll();
            Iterator<Integer> it = grafo.obtenerAdyacentes(v);
            while(it.hasNext()){
                Integer w = it.next();
                if(nodos.get(w).equals("NO VISITADO")){
                    nodos.put(w, "VISITADO");
                    cola.add(w);
                }

            }
        }
    }
}
