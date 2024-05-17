package HashMap;

import java.util.Iterator;

public class IteradorArcos<T> implements Iterator<Integer> {
    
    private Iterator<Arco<T>> iterador;

    public IteradorArcos (Iterator<Arco<T>> iterador){
        this.iterador = iterador;
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasNext'");
    }

    @Override
    public Integer next() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }
}
