package ule.ed.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedEDList<T> implements EDList<T> {

	// referencia al primer de la lista
	private Node<T> front;

	public LinkedEDList() {
		front = null;
	}

	private class Node<T> {

		Node(T element) {
			this.elem = element;
			this.next = null;
		}

		T elem;

		Node<T> next;
	}
	///////
	///// ITERADOR normal //////////

	@SuppressWarnings("hiding")
	private class LinkedListIterator<T> implements Iterator<T> {
		Node<T> node;

		public LinkedListIterator(Node<T> aux) {
			//TODO
	
		}

		@Override
		public boolean hasNext() {
			//TODO
			return false;
		}

		@Override
		public T next() {
			//TODO
			return null;
	
		}
	}

	public class LinkedListOddIterator<T> implements Iterator<T> {
		Node<T> node;

		public LinkedListOddIterator(Node<T> aux) {
		
		}

		@Override
		public boolean hasNext() {
			//TODO
			return false;
		}

		@Override
		public T next() {
			//TODO
			return null;
		}
	}

	public class LinkedListEvenIterator<T> implements Iterator<T> {

		Node<T> node;

		public LinkedListEvenIterator(Node<T> aux) {
			//TODO
		}

		@Override
		public boolean hasNext() {
			//TODO
			return false;
		}

		@Override
		public T next() {
			//TODO
			return null;
		}
	}

	//AÑADIR RESTO DE CLASES DE ITERADORES
	
	///////
	@Override
	public int size() {
		//TODO
		return 0;
	}

	@Override
	public boolean isEmpty() {
		//TODO
				return false;
	}

	@Override
	public void clear() {
		//TODO
				
	}

	@Override
	public void addFirst(T elem) {
		//TODO
				
	}

	@Override
	public void addLast(T elem) {
		//TODO
		
	}

	@Override
	public void addPenult(T elem) {
		//TODO
			
	}

	@Override
	public void addPos(T elem, int position) {
		//TODO
			

	}

	@Override
	public T removeFirst() throws EmptyCollectionException {
		//TODO
				return null;
	}

	@Override
	public T removelast() throws EmptyCollectionException {
		//TODO
		return null;
	}

	@Override
	public T removePenult() throws EmptyCollectionException {
		//TODO
		return null;

	}

	@Override
	public T removeElem(T elem) throws EmptyCollectionException {
		//TODO
		return null;
	}

	@Override
	public T getElemPos(int position) {
		//TODO
		return null;
	}

	@Override
	public int getPosFirst(T elem) {
		//TODO
		return 0;
	}

	@Override
	public int getPosLast(T elem) {
		//TODO
		return 0;
	}

	
	@Override
	public EDList<T> reverse() {
		//TODO
		return null;
	}


	public String toString() {
		//TODO
		return null;

	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator(this.front);
	}

	@Override
	public Iterator<T> evenPositionsIterator() {
		return new LinkedListOddIterator(this.front);
	}

	@Override
	public Iterator<T> oddPositionsIterator() {
		//TODO
		return null;
	}

	
	@Override
	public int removeLastElem(T elem) throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeN(T elem, int n) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T mostFrequent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T leastFrequent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> repeatNiterator(int n) {
		// TODO Auto-generated method stub
		return null;
	}

}
