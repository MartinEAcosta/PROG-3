package TP05;

import java.util.Iterator;

public class IteradorArcos<T> implements Iterator<Integer> {
    
    private Iterator<Arco<T>> iterador;

    public IteradorArcos (Iterator<Arco<T>> iterador){
        this.iterador = iterador;
    }

    @Override
    public boolean hasNext() {
        return iterador.hasNext();
    }

    @Override
    public Integer next() {
        return iterador.next().getVerticeDestino();
    }
}
