package SimpleList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySimpleLinkedList< T extends Comparable<T> > implements Iterable<T>{
	
	private Node<T> first;
	private int size;

	
	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}

	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}
	
	public T extractFront() {
		if(isEmpty()){
			throw new NoSuchElementException("La lista se encuentra vacia.");
		}
		Node<T> extractFirst = first;
		first =	extractFirst.getNext();
		this.size--;
		return first.getInfo();
	}

	public MySimpleLinkedList<T> getOrderedUnion(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2){
		MySimpleLinkedList<T> result = new MySimpleLinkedList<T>();

		return result;

		/*Node<T> current = list1.getFirst();
		Node<T> comparado = list2.getFirst();
		T data = null;
		while(current.getNext() != null || comparado.getNext() != null){
			if(current.getInfo().equals(comparado.getInfo())){
				data = comparado.getInfo();
				result.insertFront(data);
			}
			current = current.getNext();
			comparado = comparado.getNext();
		} */



		//Busco elementos comunes
		/*for(int i = 0;i<list1.size();i++){
			T iterado = list1.get(i);
			for(int y = 0; y<list2.size();i++){
				T actual = list2.get(y);
				//Agrego elementos comunes a result
				if(iterado.equals(actual)){
					result.insertFront(actual);
				}
			}
		}
		//if no esta ordenada ordeno y devuelvo
		if(!isOrdered(result)){
			result = orderList(result);
		}
		return result;*/
	}

	public MySimpleLinkedList<T> getUnionWithoutEquals(MySimpleLinkedList<T> list, MySimpleLinkedList<T> list2){
		MySimpleLinkedList<T> result = new MySimpleLinkedList<>();
		for(int i = 0; i<list.size(); i++){ 
			T currentData = list.get(i);
			for(int z = 0; z<list2.size(); z++){
				T nextData = list2.get(z);
				if(!currentData.equals(nextData)){
					result.insertFront(currentData);
				}
			}
		}	
		return result;
	}
	
	private Node<T> getFirst() {
		return this.first;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	public T get(int index) {
		if(index <= size() && index > 0){
			Node <T> actual = first;
			for(int i = 0; i<index;i++){
				actual = actual.getNext();
			}
			return actual.getInfo();
		}
		throw new IndexOutOfBoundsException("Índice:" + index + "Esta fuera de rango.");
	}
	
	public int size() {
		return this.size;
	}

	public int indexOf(T element){
		Node<T> actual = first;
		for(int i = 0; i < size(); i++){
			if(actual == element){
				return i;
			}
			actual = actual.getNext();
		}
		return -1;
	}
	
	@Override
	public String toString() {
		String result = "Lista: ";
		Node<T> aux  = this.first;
		while(aux != null){
			result +="[" aux.getInfo() + "][-->" + aux.getNext() "]";
			aux = aux.getNext();
		}
		return result; 
	}

	@Override
	public LinkedListIterator<T> iterator() {
		return new LinkedListIterator<T>(first);
	}

}