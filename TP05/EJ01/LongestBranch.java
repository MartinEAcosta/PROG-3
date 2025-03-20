package TP05.EJ01;

import java.util.ArrayList;
import java.util.Iterator;

import TP05.GrafoDirigido;


public class LongestBranch<T> {
    
    private ArrayList<Integer> visitados;
    private ArrayList<Integer> caminoMayor;

    public LongestBranch(){
        this.visitados = new ArrayList<>();
        this.caminoMayor = new ArrayList<>();
    }

    public ArrayList<Integer> getLongestExit(GrafoDirigido<T> grafo,int entrada, int salida){
        ArrayList<Integer> camino = new ArrayList<>();
        return getLongestExit(grafo,entrada, salida,camino);
    }

	private ArrayList<Integer> getLongestExit(GrafoDirigido<T> grafo,int entrada, int salida, ArrayList<Integer> recorridoActual){
        recorridoActual.add(entrada);
        visitados.add(entrada);
        if(entrada == salida){
            return recorridoActual;
        }    
        else{
            Iterator<Integer> ady = grafo.obtenerAdyacentes(entrada);
            if(ady.hasNext()){
                int puertaAdy = ady.next();
                if(!visitados.contains(puertaAdy)){
                    recorridoActual = getLongestExit(grafo, puertaAdy, salida,recorridoActual);
                }
                if(recorridoActual.size() > caminoMayor.size()){
                    caminoMayor = recorridoActual;
                }
            }
        }
        return caminoMayor;
	}

}
