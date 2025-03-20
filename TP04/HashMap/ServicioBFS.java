package HashMap;

import java.util.ArrayList;
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

    public void bfsAlgorithm(Grafo<T> grafo){
        cola.clear();
        Iterator<Integer> ver = grafo.obtenerVertices();
        while(ver.hasNext()){
            Integer w = ver.next();
            if(!nodos.containsKey(w)){
                nodos.put(w, "NO VISITADO");
            }
        }
        Iterator<Integer> verBfs = grafo.obtenerVertices();
        while(verBfs.hasNext()){
            Integer w = ver.next();
            if(nodos.get(w) == "NO VISITADO"){
                bfsAlgorithm(grafo, w);
            }
        }
        
    }

    public void bfsAlgorithm(Grafo<T> grafo, int vertice){
        nodos.put(vertice,"VISITADO");
        cola.add(vertice);
        System.out.println(cola);
        while(!cola.isEmpty()){
            Integer v = cola.poll();
            Iterator<Integer> it = grafo.obtenerAdyacentes(v);
            while(it.hasNext()){
                Integer w = it.next();
                if(nodos.get(w).equals("NO VISITADO")){
                    nodos.put(w, "VISITADO");
                    System.out.println(cola);
                    cola.add(w);
                }
            }
        }
    }
}


//He supuesto que existe una variable camion
public ArrayList<Estacion> greedy(LinkedList<Estacion> ruta,Estacion destino){
    ArrayList<Estacion> paradas = new ArrayList<Estacion>();
    if(!ruta.isEmpty()){
        System.out.println("Se lleno el tanque");
        this.camion.llenarTanque();
        Estacion actual = ruta.getFirst();
        paradas.add(actual);
        ruta.remove(actual);
        while(!ruta.isEmpty() && !actual.equals(destino)){
            //La funcion seleccionar se encargara de tomar el primer elemento de la lista
            //Debido a que ya tome el actual, siempre tomara el proximo, debido que se va seteando.
            Estacion siguiente = ruta.getFirst();
            float dis = Distancia(actual,siguiente);
            //La funcion getKmRestantes devolvera los km que quedan disponibles por recorrer
            //con el tanque actual.
            if(dis<= this.camion.getKmRestantes()){
                //En caso de llegar a la proxima estacion seteo el nuevo actual
                actual = siguiente;
                this.camion.restarCapacidad(dis);
                ruta.remove(siguiente);
            }
            else{
                //En caso de no llegar a la proxima estacion, se debe recargar el tan
                //que en la estacion actual
                System.out.println("Se lleno el tanque");
                this.camion.llenarTanque();
                paradas.add(actual);
                if(this.camion.getKmRestantes() < dis){
                    System.out.println("No hay suficiente capacidad para llegar a la siguiente estacion.");
                    break;
                }
                //Creo que aqui podria haber un error.
            }
        }
        if(actual.equals(destino)){
            this.camion.llenarTanque();
            paradas.add(actual);
            return paradas;
        }
    }
    return null;
}


//He abarcado el mismo problema mediante un enfoque backtracking, me gustaria que me des un feedback
//De implementacion al igual que lo hiciste con el anterior

public ArrayList<Estacion> ej(LinkedList<Estacion> ruta){
    ArrayList<Estacion> paradas = new ArrayList<Estacion>();
    if(!ruta.isEmpty()){
        System.out.println("Se lleno el tanque");
        this.camion.llenarTanque();
        Estacion origen = ruta.getFirst();
        paradas.add(actual);
        Estacion destino = ruta.getLast();
        ej(ruta,origen,destino,paradas);
        if(this.solucion != null){
            return this.solucion;
        }
    }
    return null;
}

private ArrayList<Estacion> ej(LinkedList<Estacion> ruta, Estacion actual, Estacion destino, ArrayList<Estacion> solucion){
    if(actual.equals(destino)){
        solucion.add(actual);
        this.camion.llenarTanque();
        this.mejorSolucion = solucion;
    }
    else{
        Estacion siguiente = actual.getNext();
        float dis = distancia(actual,siguiente);
        if(dis>this.camion.getAutonomiaKm()){
            paradas.add(actual);
            ej(ruta,actual,destino,solucion);
            paradas.remove
        }
        else{
            this.camion.restarAutonomia(dis);
            ej(ruta,siguiente,destino,solucion);
        }
    }
}

public boolean trazar(Grafo g , Vertice dado){
    ArrayList<Arco> camino = new ArrayList<>();
    for(Arco a : g.obtenerArcos()){
        a.setColor("Blanco");
    }
    Iterator<Arco> it  = g.obtenerArcos(dado);
    while(it.hasNext()){
        Arco a = it.next();
        camino = trazar(g,dado,a,camino);
        if(esSolucion(g,camino)){
            return true;
        }
        else{
            pintarArcos(g);
        }
    }
    return false;
}

private ArrayList<Arco> trazar(Grafo g, Vertice origen, Arco actual, ArrayList<Arco> camino){
    camino.add(actual);
    actual.setColor("Amarillo");
    Iteartor<Arco> it = g.obtenerArcos(actual);
    while(it.hasNext()){
        Arco sig = it.next();
        if(sig.getColor() == "Blanco"){
            camino = trazar(g,actual.getDestino(),sig,camino);
        }
    }
    actual.setColor("Negro");
    return camino;
}