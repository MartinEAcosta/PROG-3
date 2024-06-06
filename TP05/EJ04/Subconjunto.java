package TP05.EJ04;

import java.util.ArrayList;

public class Subconjunto {

    private ArrayList<Integer> elems;
    private int suma;
    private boolean visitado;

    public Subconjunto(){
        this.elems = new ArrayList<Integer>();
        this.suma = obtenerSuma();
        this.visitado = false;
    }
    public Subconjunto(ArrayList<Integer> elems){
        this.elems = elems;
        this.suma = obtenerSuma();
        this.visitado = false;
    }

    public void addElemento(int e){
        this.elems.add(e);
    }

    public void setSuma(int x){
        this.suma = x;
    } 

    public int obtenerSuma(){
        int suma = 0;
        for (Integer pos : elems) {
            suma += pos;
        }
        setSuma(suma);
        return suma;
    }

    public boolean estaVisitado(){
        return visitado;
    }

    public void setVisitado(boolean v){
        this.visitado = v;
    }

    public ArrayList<Integer> getElementos(){
        return elems;
    }

    @Override
    public String toString() {
        return "Subconjunto [elems=" + elems + "]";
    }

    
}
