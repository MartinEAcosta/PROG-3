package TP04.HashMap;

import java.util.LinkedList;

public class Vertice {
    
    private int id;
    private int valor;
    private LinkedList<Arco> listaAdyacentes;
    
    
    public Vertice(int id, int valor){
        this.id = id;
        this.valor = valor;
    }

    public Vertice(int id){
        this.id = id;
        this.valor = -1;
    }

    public int getId() {
        return id;
    }

    public int getValor() {
        return valor;
    }

    public LinkedList<Arco> getListaAdyacentes() {
        return listaAdyacentes;
    }

}
