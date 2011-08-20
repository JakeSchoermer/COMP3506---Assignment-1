package datastructures;

public class ArrayQueue<E> implements IQueue<E> {
	private E[] items;
	private int capacity;
	private int size = 0;

	/*
	 * Default constructor
	 */
	public ArrayQueue() {
		this.capacity = 32;
		this.items = (E[]) new Object[this.capacity];
	}

	/*
	 * Constructor for a given capacity
	 */
	public ArrayQueue(int maxCapacity) {
		this.capacity = maxCapacity;
		this.items = (E[]) new Object[this.capacity];
	}

	/*
	 * Add an element to the back of the queue
	 */
	public void enqueue(E element) {
		// Check capacity of queue
		if (this.size == this.capacity) {
			// We need to increase capacity. We'll double it.
			E[] newItems = (E[]) new Object[this.capacity * 2];
			for (int i = 0; i < this.capacity; i++) {
				newItems[i] = this.items[i];
			}
			this.capacity = this.capacity * 2;
			this.items = newItems;
		}
		items[this.size] = element;
		this.size++;
	}

	/*
	 * Remove and return element from the front of the queue
	 */
	public E dequeue() throws EmptyQueueException {
		// Check size of queue
		if (this.isEmpty()) {
			throw new EmptyQueueException("The queue is empty.");
		}
		E element = this.items[0];
		// Move all items up one position
		for (int i = 1; i < this.size; i++) {
			this.items[i - 1] = this.items[i];
		}
		this.size--;
		return element;
	}

	/*
	 * Return the size of the queue
	 */
	public int size() {
		return this.size;
	}

	/*
	 * Return true if the queue is empty (false if not)
	 */
	public Boolean isEmpty() {
		return this.size == 0;
	}

	/*
	 * Returns (but does not remove) the element from the front of the queue
	 */
	public E front() throws EmptyQueueException {
		if (this.isEmpty()) {
			throw new EmptyQueueException("The queue is empty.");
		}
		return this.items[0];
	}

	/*
	 * Converts the queue to a string
	 */
	public String toString() {
		String returnString = "[";
		for (int i = 0; i < size; i++) {
			returnString += this.items[i].toString() + ",\n";
		}
		if (returnString.length() > 1) {
			returnString = returnString.substring(0, returnString.length() - 2);
		}
		return returnString + "]";
	}

}
