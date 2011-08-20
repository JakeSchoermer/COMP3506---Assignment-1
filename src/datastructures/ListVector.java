package datastructures;

public class ListVector<E> implements IVector<E> {

	private LinkedList<E> items; // Linked list of the items

	/*
	 * Default constructor
	 */
	public ListVector() {
		this.items = new LinkedList<E>();
	}

	/*
	 * Return the element at the given index.
	 */
	public E get(int index) throws IndexOutOfBoundsException {
		// Check size and negative bounds
		if (index >= this.items.size() || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> n = this.items.getHead();
		int i = 0;
		while (i < index) {
			n = n.getNext();
			i++;
		}
		return n.getElement();

	}

	/*
	 * Set the element at the given index with the given element
	 */
	public void set(int index, E element) throws IndexOutOfBoundsException {
		// Check size and negative bounds
		if (index >= this.items.size() || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		Node<E> n = this.items.getHead();
		int i = 0;
		while (i < index) {
			n = n.getNext();
			i++;
		}
		n.setElement(element);

	}

	/*
	 * Add the given element to the given index.
	 */
	public void add(int index, E element) throws IndexOutOfBoundsException {
		// Check size and negative bounds
		if (index > this.items.size() || index < 0 || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> n = this.items.getHead();
		// Check to make sure there is a head, if not, add head
		if (n == null) {
			this.items.addHead(new Node<E>(element, null));
		} else {
			int i = 0;
			while (i < index - 1) {
				n = n.getNext();
				i++;
			}
			Node<E> newNode = new Node<E>(element, n.getNext());
			n.setNext(newNode);
		}
	}

	/*
	 * Remove the element at the given index.
	 */
	public void remove(int index) throws IndexOutOfBoundsException {
		// Check size
		if (index >= this.items.size() || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		// If the index is 0, we remove the head.
		if (index == 0) {
			this.items.removeHead();
		} else {
			// Otherwise, iterate through until we reach the index
			Node<E> n = this.items.getHead();
			int i = 0;
			while (i < index - 1) {
				n = n.getNext();
				i++;
			}
			Node<E> removeNode = n.getNext();
			n.setNext(removeNode.getNext());
		}
	}

	/*
	 * Return the size of the vector
	 */
	public int size() {
		return this.items.size();
	}

	/*
	 * Return true if the vector is empty (false if not)
	 */
	public Boolean isEmpty() {
		return this.items.isEmpty();
	}

	/*
	 * Converts the vector to a string
	 */
	public String toString() {
		return this.items.toString();
	}

}
