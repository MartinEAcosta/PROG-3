package SimpleList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T>{

    private Node<T> cursor;

    public LinkedListIterator(Node<T> first) {
        this.cursor = first;
    }

    @Override
    public boolean hasNext() {
        return cursor != null;
    }

    @Override
    public T next() {
        T data = get();
        cursor = this.cursor.getNext();
        return data;
    }

    public T get(){
        return cursor.getInfo();
    }

}
