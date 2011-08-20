package datastructures;

public interface ILinkedList<E> {

	public Node<E> getHead();

	public Node<E> getTail();

	public void addHead(Node<E> n);

	public void addTail(Node<E> n);

	public Node<E> removeHead();

	public Node<E> removeTail();

	public int size();

	public Boolean isEmpty();

}