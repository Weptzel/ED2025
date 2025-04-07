package ule.ed.doubleList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedCircularList<T> implements IDoubleList<T> {

	/* Representa un anillo que almacena datos en una estructura doblemente enlazada circular.
	 * 
	 * Siempre tiene un nodo fijo de 'referencia' (nodo cabecera)
	 * que tiene a <code>null</code> su contenido. Un anillo vacío será un
	 * nodo de referencia (R) que se apunta a sí mismo como 'next' y
	 * como 'previous', para cerrar el anillo.
	 * 
	*/
	
	//	referencia al nodo cabecera de la lista
	private DoubleNode<T> cab;

	// Clase de los nodos de la lista doble

	@SuppressWarnings("hiding")
	protected class DoubleNode<T> {

		DoubleNode(T element, int count) {
			this.elem = element;
			this.count= count;
			this.next = null;
			this.prev = null;
		}

		T elem;
        int count; 
		DoubleNode<T> next;
		DoubleNode<T> prev;
	   
		public String toString(){
			//TODO 
			return this.elem.toString()+"("+this.count+")";
			
		}
	}


	///// ITERADOR //////////


	
	private class DobleLinkedListIterator<T> implements Iterator<T> {
		DoubleNode<T> actual;


		public DobleLinkedListIterator(DoubleNode<T> nodo) {
			// TODO
			actual=nodo.next;
		}

		@Override
		public boolean hasNext() {
			// TODO
			boolean check=false;
			
			if(actual!=cab) {
				check=true;
			}
			return check;
		}

		@Override
		public T next() {
			// TODO
			T aux = null;

			if(! hasNext()) {
				throw new NoSuchElementException();
			}
			aux = actual.elem;
			actual = actual.next;

			return aux;
		}
	}

	////// ITERATOR REVERSE

	@SuppressWarnings("hiding")
	private class ReverseIterator<T> implements Iterator<T> {
		// añadir atributos
		DoubleNode<T> actual;


		public ReverseIterator(DoubleNode<T> nodo) {
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
	
	@SuppressWarnings("hiding")
	private class iteratorInstance<T> implements Iterator<T> {
		// añadir atributos
	
		public iteratorInstance(DoubleNode<T> nodo) {
	 //TODO	
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
	
	@SuppressWarnings("hiding")
	private class reverseIteratorInstance<T> implements Iterator<T> {
		// añadir atributos
	
		public reverseIteratorInstance(DoubleNode<T> nodo) {
			//TODO
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

	
	public DoubleLinkedCircularList() {
		// TODO crear el nodo cabecera, dejar next y prev apuntando a la misma cabecera
	
	}

	@SafeVarargs
	public DoubleLinkedCircularList(T...v) {
		// TODO Auto-generated constructor stub
		// constructor que añade elementos
		cab=new DoubleNode<T>(null,0);
		cab.next=cab;
		cab.prev=cab;
		for (T elem:v) {
			this.addLast(elem,1);
		}
	}

	@Override
	public boolean isEmpty() {
		return false;
		// TODO Auto-generated method stub
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


