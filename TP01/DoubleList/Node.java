package DoubleList;

public class Node<T> {

	private T info;
	private Node<T> next;
    private Node<T> prev;

	public Node() {
		this.info = null;
		this.next = null;
        this.prev = null;
	}
	
	public Node(T info, Node<T> next) {
		this.setInfo(info);
		this.setNext(next);
	}
	
	public Node<T> getNext() {
		return next;
	}

    public Node<T> getPrev(){
        return prev;
    }

	public void setNext(Node<T> next) {
		this.next = next;
	}

    public void setPrev(Node<T> prev){
        this.prev = prev;
    }

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

}