package datastructures;

public class LinkedList<E> implements ILinkedList<E> {
	private Node<E> head;
	private Node<E> tail;

	public LinkedList() {
		this.head = null;
		this.tail = null;
	}

	public Node<E> getHead() {
		return this.head;
	}

	public Node<E> getTail() {
		return this.tail;
	}

	public void addHead(Node<E> n) {
		if (this.head == null) {
			this.tail = n;
		} else {
			n.setNext(this.head);
		}
		this.head = n;
	}

	public void addTail(Node<E> n) {
		if (this.head == null) {
			this.head = n;
		} else {
			this.tail.setNext(n);
		}
		this.tail = n;
	}

	public Node<E> removeHead() {
		Node<E> element = this.head;
		if (this.head == this.tail) {
			this.head = null;
			this.tail = null;
			return element;
		} else {
			this.head = this.head.getNext();
			return element;
		}
	}

	public Node<E> removeTail() {
		Node<E> element = this.head;
		if (this.head == this.tail) {
			this.head = null;
			this.tail = null;
			return element;
		} else {
			while (!element.getNext().equals(this.tail)) {
				element = element.getNext();
			}
			element.setNext(null);
			Node<E> returnNode = this.tail;
			this.tail = element;
			return returnNode;
		}
	}

	public int size() {
		Node<E> n = this.head;
		if (n == null) {
			// Nothing in list, so return 0
			return 0;
		}
		int size = 1;
		while (n.getNext() != null) {
			n = n.getNext();
			size++;
		}
		return size;
	}

	public Boolean isEmpty() {
		return this.head == null;
	}

	public String toString() {
		Node<E> n = this.head;
		if (n == null) {
			// Nothing in list, so return empty
			return "[]";
		}
		String returnString = "[";
		while (n.getNext() != null) {
			returnString += n.toString() + ",\n";
			n = n.getNext();
		}
		returnString += n.toString() + "]";
		return returnString;
	}

}