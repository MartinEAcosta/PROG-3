package DoubleList;

import java.util.NoSuchElementException;

public class MyDoubleLinkedList<T> {
    

    private Node<T> first;
    private Node<T> last;
    private int size;

    public MyDoubleLinkedList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int size(){
        return this.size;
    }


    public void insertFront(T info){
        Node<T> aux = new Node<T>(info,null);
        aux.setNext(this.first);
        this.first = aux;La
        this.size++;
    }

    public T extractFront(){
        if(isEmpty()){
            throw new NoSuchElementException("No hay elementos en la lista.");
        }
        Node <T> toDelete = first;
        first = toDelete.getNext();
        this.size--;
        return toDelete.getInfo();
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    public T get(int index){
        if(index <= size() && index >= 0){
            Node<T> actual = first;
            for(int i = 0; i<index; i++){
                actual = actual.getNext();
                if(i == index){
                    return actual.getInfo();
                }
            }
        }
        return null;
    }

    public Node<T> getLast(){
        Node<T> index = ;
    }

    public Node<T> get
}
