package datastructures;

public class Node<E> {

	private E element;
	private Node<E> next;

	public Node(E e, Node<E> n) {
		this.element = e;
		this.next = n;
	}

	public E getElement() {
		return this.element;
	}

	public Node<E> getNext() {
		return this.next;
	}

	public void setElement(E e) {
		this.element = e;
	}

	public void setNext(Node<E> n) {
		this.next = n;
	}

	public String toString() {
		return this.element.toString();
	}

}