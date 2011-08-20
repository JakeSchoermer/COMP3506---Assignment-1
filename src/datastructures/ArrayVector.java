package datastructures;

public class ArrayVector<E> implements IVector<E> {

	private E[] items; // Array holding all the elements
	private int capacity; // Capacity of the array
	private int size = 0; // Current number of elements in the array (default is
							// 0)

	/*
	 * Default constructor
	 */
	public ArrayVector() {
		this.capacity = 32; // Default max capacity
		this.items = (E[]) new Object[this.capacity];
	}

	/*
	 * Constructor for a given capacity
	 */
	public ArrayVector(int maxCapacity) {
		this.capacity = maxCapacity;
		this.items = (E[]) new Object[this.capacity];
	}

	/*
	 * Return the element at the given index.
	 */
	public E get(int index) throws IndexOutOfBoundsException {
		// Check size and negative bounds
		if (index >= this.size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		return items[index];
	}

	/*
	 * Set the element at the given index with the given element
	 */
	public void set(int index, E element) throws IndexOutOfBoundsException {
		// Check size and negative bounds
		if (index >= this.size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		items[index] = element;
	}

	/*
	 * Add the given element to the given index. The array may be re-sized.
	 */
	public void add(int index, E element) throws IndexOutOfBoundsException {
		// Check size and negative bounds
		if (index > this.size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (size + 1 >= capacity) {
			// Need to increase size. We'll double it.
			E[] newItems = (E[]) new Object[this.capacity * 2];
			for (int i = 0; i < this.capacity; i++) {
				newItems[i] = this.items[i];
			}
			this.capacity = this.capacity * 2;
			this.items = newItems;
		}
		// Shift all elements down
		for (int i = size + 1; i > index; i--) {
			items[i] = items[i - 1];
		}
		// Add the element
		items[index] = element;
		this.size++;
	}

	/*
	 * Remove the element at the given index.
	 */
	public void remove(int index) throws IndexOutOfBoundsException {
		// Check size and negative bounds
		if (index >= this.capacity || index >= this.size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		// Shift the remaining elements up the list
		for (int i = index; i < size - 1; i++) {
			items[i] = items[i + 1];
		}
		this.items[this.size - 1] = null; // Remove element
		this.size--; // Decrease size
	}

	/*
	 * Return the size of the vector
	 */
	public int size() {
		return this.size;
	}

	/*
	 * Return true if the vector is empty (false if not)
	 */
	public Boolean isEmpty() {
		return this.size == 0;
	}

	/*
	 * Converts the vector to a string
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
