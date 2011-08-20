package datastructures;

public class ListQueue<E> implements IQueue<E> {

	private LinkedList<E> items;

	/*
	 * Default constructor
	 */
	public ListQueue() {
		this.items = new LinkedList<E>();
	}

	/*
	 * Add an element to the back of the queue
	 */
	public void enqueue(E element) {
		items.addTail(new Node<E>(element, null));
	}

	/*
	 * Remove and return element from the front of the queue
	 */
	public E dequeue() throws EmptyQueueException {
		if (items.getHead() == null) {
			throw new EmptyQueueException("The queue is empty");
		}
		return items.removeHead().getElement();
	}

	/*
	 * Return the size of the queue
	 */
	public int size() {
		return items.size();
	}

	/*
	 * Return true if the queue is empty (false if not)
	 */
	public Boolean isEmpty() {
		return items.isEmpty();
	}

	/*
	 * Returns (but does not remove) the element from the front of the queue
	 */
	public E front() throws EmptyQueueException {
		if (items.getHead() == null) {
			throw new EmptyQueueException("The queue is empty");
		}
		return items.getHead().getElement();
	}

	/*
	 * Converts the queue to a string
	 */
	public String toString() {
		String returnString = "[";
		Node<E> node = this.items.getHead();
		for (int i = 0; i < this.items.size(); i++) {
			returnString += node.toString() + ",\n";
			node = node.getNext();
		}
		if (returnString.length() > 1) {
			returnString = returnString.substring(0, returnString.length() - 2);
		}
		return returnString + "]";
	}

}
