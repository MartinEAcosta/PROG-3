package tp1;

public class MySimpleLinkedList<T> {
	
	private Node<T> first;
	private int size;

	public MySimpleLinkedList() {
		this.first = null;
		this.size = 0;
	}
	
	public Node<T> getRoot(){
		return this.first;
	}

	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}
	
	public T extractFront() {		
		if(isEmpty()){
			System.out.println("No hay elementos en la lista");
			return null;
		}
		T info = this.first.getInfo();
		this.first = this.first.getNext();
		this.size--;
		return info;
	}

	public boolean isEmpty() {
		return first==null;
	}
	
	public T get(int index) {
		if(index <= this.size() && index > 0){
			Node<T> aux = this.first;
			for(int i = 0; i < index - 1; i++){
				aux = aux.getNext();
			}
			return aux.getInfo();
		}
		return null;
	}
	
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		// TODO
		return "";
	}

	public int indexOf(T elem){
		Node<T> aux = this.first;
		int index = 0;
		while(index <= size){
			if(aux.getInfo().equals(elem)){
				return index;
			}
		}
		return -1;
	}

	


	
}
