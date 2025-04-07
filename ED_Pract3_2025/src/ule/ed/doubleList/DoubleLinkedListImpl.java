package ule.ed.doubleList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedListImpl<T> implements IDoubleList<T> {


	//	referencia al primer nodo de la lista
	private DoubleNode<T> front;

	//	referencia al Último nodo de la lista
	private DoubleNode<T> last;


	private class DoubleNode<T> {

		DoubleNode(T element, int count) {
			this.elem = element;
			this.count=count;
			this.next = null;
			this.prev = null;
		}

		T elem;
        int count;
		DoubleNode<T> next;
		DoubleNode<T> prev;
	}

	///// ITERADOR normal //////////

	@SuppressWarnings("hiding")
	private class DoubleLinkedListIterator<T> implements Iterator<T> {
		DoubleNode<T> node;
		public DoubleLinkedListIterator(DoubleNode<T> aux) {
			
		}

		@Override
		public boolean hasNext() {
			// TODO
			return false;
		}
	

		@Override
		public T next() {
		// TODO
			return null;
		}
	}

	////// FIN ITERATOR



	@SuppressWarnings("hiding")
	private class DoubleLinkedListIteratorReverse<T> implements Iterator<T> {
		DoubleNode<T> node;
		public DoubleLinkedListIteratorReverse(DoubleNode<T> aux) {
			// TODO	
			}

		@Override
		public boolean hasNext() {
			// TODO	
			return false;
			}

		@Override
		public T next() {
			// TODO
			return null;
		}
	}
	
	// TODO: añadir clases para el resto de iteradores

	/////

	@SafeVarargs
	public DoubleLinkedListImpl(T...v ) {
		// permite añadir varios elementos a la lista en el constructor
		for (T elem:v) {
			this.addLast(elem,1);
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFirst(T elem, int n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLast(T elem, int n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int removeFirst(int num) throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T removeAllFirst() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeLast(int num) throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T removePos(int pos, int num) throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(T elem, int num) throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T getElemPos(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countInstances() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toStringReverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<T> listMaxRepeated() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> reverseIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> reverseIteratorInstance() {
		// TODO Auto-generated method stub
		return null;
	}



}