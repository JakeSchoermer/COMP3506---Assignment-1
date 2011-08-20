package datastructures;

public interface IQueue<E> {

	public void enqueue(E element);

	public E dequeue() throws EmptyQueueException;

	public int size();

	public Boolean isEmpty();

	public E front() throws EmptyQueueException;

}