package TP04;

import java.util.LinkedList;

public class Vertice {

    private int value;
    private LinkedList<Arco> listaAdyacencia;
    private int id;

    public Vertice(int value, int id) {
        this.value = value;
        this.id = id;
        listaAdyacencia = new LinkedList<Arco>();
    }

    public Vertice(int id){
        this.value = -1;
        this.id = id;
        listaAdyacencia = new LinkedList<Arco>();
    }

    public int getID(){
        return this.id;
    }

    public int getValue(){
        return this.value;
    }

    public void addAdyacente(Arco v){
        listaAdyacencia.add(v);
    }

    public void setValue(int v){
        this.value = v;
    }

    public LinkedList<Arco> getAdyacentes(){
        return listaAdyacencia;
    }

    public void borrarArco(int origen, int destino){
        for(int i = 0; i<listaAdyacencia.size();i++){
            if(listaAdyacencia.get(i).getVerticeOrigen() == origen && listaAdyacencia.get(i).getVerticeDestino() == destino){
                listaAdyacencia.remove(i);
            }
        }
    }

    public Arco getArco(int verticeId1, int verticeId2){
        for(int i = 0; i<listaAdyacencia.size();i++){
            if(listaAdyacencia.get(i).getVerticeOrigen() == verticeId1 && listaAdyacencia.get(i).getVerticeDestino() == verticeId2){
                return listaAdyacencia.get(i);
            }
        }
        return null;
    }

    public int getCantAdyacentes(){
        return listaAdyacencia.size();
    }
}
