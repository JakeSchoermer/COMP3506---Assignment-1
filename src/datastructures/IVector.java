package datastructures;

public interface IVector<E> {

	public E get(int index) throws IndexOutOfBoundsException;

	public void set(int index, E element) throws IndexOutOfBoundsException;

	public void add(int index, E element) throws IndexOutOfBoundsException;

	public void remove(int index) throws IndexOutOfBoundsException;

	public int size();

	public Boolean isEmpty();

}