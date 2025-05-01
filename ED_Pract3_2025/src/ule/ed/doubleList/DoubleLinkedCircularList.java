package ule.ed.doubleList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedCircularList<T> implements IDoubleList<T> {

	/*
	 * Representa un anillo que almacena datos en una estructura doblemente enlazada
	 * circular.
	 * 
	 * Siempre tiene un nodo fijo de 'referencia' (nodo cabecera)
	 * que tiene a <code>null</code> su contenido. Un anillo vacío será un
	 * nodo de referencia (R) que se apunta a sí mismo como 'next' y
	 * como 'previous', para cerrar el anillo.
	 * 
	 */

	// referencia al nodo cabecera de la lista
	private DoubleNode<T> cab;

	// Clase de los nodos de la lista doble

	@SuppressWarnings("hiding")
	protected class DoubleNode<T> {

		DoubleNode(T element, int count) {
			this.elem = element;
			this.count = count;
			this.next = null;
			this.prev = null;
		}

		T elem;
		int count;
		DoubleNode<T> next;
		DoubleNode<T> prev;

		public String toString() {
			// TODO
			return this.elem.toString() + "(" + this.count + ")";

		}
	}

	///// ITERADOR //////////

	private class DobleLinkedListIterator<T> implements Iterator<T> {
		DoubleNode<T> actual;

		public DobleLinkedListIterator(DoubleNode<T> nodo) {
			// TODO
			actual = nodo.next;
		}

		@Override
		public boolean hasNext() {
			// TODO
			boolean check = false;

			if (actual != cab) {
				check = true;
			}
			return check;
		}

		@Override
		public T next() {
			// TODO
			T aux = null;

			if (!hasNext()) {
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
			// TODO
			actual = nodo.prev;
		}

		@Override
		public boolean hasNext() {
			// TODO
			return actual != cab;
		}

		@Override
		public T next() {
			// TODO
			if (!hasNext()) {
				throw new NoSuchElementException();

			}
			T aux = actual.elem;
			actual = actual.prev;
			return aux;
		}
	}

	@SuppressWarnings("hiding")
	private class iteratorInstance<T> implements Iterator<T> {
		// añadir atributos
		DoubleNode<T> actual;
		int currentCount;

		public iteratorInstance(DoubleNode<T> nodo) {
			// TODO
			actual = nodo.next;
			currentCount = (actual != cab) ? actual.count : 0;
		}

		@Override
		public boolean hasNext() {
			// TODO
			return actual != cab;
		}

		@Override
		public T next() {
			// TODO
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T aux = actual.elem;
			currentCount--;
			if (currentCount == 0) {
				actual = actual.next;
				if (actual != cab) {
					currentCount = actual.count;
				}
			}
			return aux;
		}
	}

	@SuppressWarnings("hiding")
	private class reverseIteratorInstance<T> implements Iterator<T> {
		// añadir atributos
		DoubleNode<T> actual;
		int currentCount;

		public reverseIteratorInstance(DoubleNode<T> nodo) {
			// TODO
			actual = nodo.prev;
			currentCount = (actual != cab) ? actual.count : 0;
		}

		@Override
		public boolean hasNext() {
			// TODO
			return actual != cab;
		}

		@Override
		public T next() {
			// TODO
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T aux = actual.elem;
			currentCount--;
			if (currentCount == 0) {
				actual = actual.prev;
				if (actual != cab) {
					currentCount = actual.count;
				}
			}
			return aux;
		}
	}

	public DoubleLinkedCircularList() {
		// TODO crear el nodo cabecera, dejar next y prev apuntando a la misma cabecera
		cab = new DoubleNode<T>(null, 0);
		cab.next = cab;
		cab.prev = cab;
	}

	@SafeVarargs
	public DoubleLinkedCircularList(T... v) {
		// TODO Auto-generated constructor stub
		// constructor que añade elementos
		cab = new DoubleNode<T>(null, 0);
		cab.next = cab;
		cab.prev = cab;
		for (T elem : v) {
			this.addLast(elem, 1);
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		/* Vacio si cab apunta a sí mismo */
		return cab.next == cab && cab.prev == cab;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		cab.next = cab;
		cab.prev = cab;
	}

	@Override
	public void addFirst(T elem, int n) {
		// TODO Auto-generated method stub
		if (elem == null) {
			throw new NullPointerException();
		}
		if (n <= 0) {
			throw new IllegalArgumentException();
		}

		/* Buscar elemento */
		DoubleNode<T> current = cab.next;
		while (current != cab) {
			/* si ya está en la lista aumentar count */
			if (current.elem.equals(elem)) {
				current.count += n;
				return;
			}
			current = current.next;
		}
		DoubleNode<T> nuevoNodo = new DoubleNode<T>(elem, n);
		/* Insertar al principio */
		nuevoNodo.next = cab.next;
		nuevoNodo.prev = cab;
		cab.next.prev = nuevoNodo;
		cab.next = nuevoNodo;
	}

	@Override
	public void addLast(T elem, int n) {
		// TODO Auto-generated method stub
		if (elem == null) {
			throw new NullPointerException();
		}
		if (n <= 0) {
			throw new IllegalArgumentException();
		}
		DoubleNode<T> current = cab.next;
		while (current.next != cab) {
			if (current.elem.equals(elem)) {
				current.count += n;
				return;
			}
			current = current.next;
		}
		DoubleNode<T> nuevoNodo = new DoubleNode<T>(elem, n);
		/* Insertar al final */
		nuevoNodo.next = cab;
		nuevoNodo.prev = cab.prev;
		cab.prev.next = nuevoNodo;
		cab.prev = nuevoNodo;

	}

	@Override
	public int removeFirst(int num) throws EmptyCollectionException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new EmptyCollectionException("Lista vacía");
		}
		if (num <= 0) {
			throw new IllegalArgumentException();
		}

		DoubleNode<T> primero = cab.next;
		if (primero.count > num) {
			primero.count -= num;
			return num;
		}

		int borradas = primero.count;
		cab.next = primero.next;  
		primero.next.prev = cab; 
		return borradas;
	}

	@Override
	public T removeAllFirst() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new EmptyCollectionException("Lista vacía");
		}
		DoubleNode<T> primero = cab.next;
		T borrado = primero.elem;

		/* actualizar referencias */
		cab.next = primero.next;
		primero.next.prev = cab;
		return borrado;
	}

	@Override
	public int removeLast(int num) throws EmptyCollectionException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new EmptyCollectionException("Lista vacía");
		}
		if (num <= 0) {
			throw new IllegalArgumentException();
		}
		DoubleNode<T> ultimo = cab.prev;
		if (ultimo.count > num) {
			ultimo.count -= num;
			return num;
		}
		int borradas = ultimo.count;
		ultimo.prev.next = cab;
		cab.prev = ultimo.prev;
		return borradas;
	}

	@Override
	public T removePos(int pos, int num) throws EmptyCollectionException {
		// TODO Auto-generated method stub

		if (isEmpty()) {
			throw new EmptyCollectionException("La lista está vacía");
		}
		if (num <= 0) {
			throw new IllegalArgumentException("El número de instancias a eliminar debe ser mayor que 0");
		}
		int size = size();
		if (pos == 0 || Math.abs(pos) > size) {
			throw new IllegalArgumentException("La posición debe estar entre 1 y " + size);
		}

		DoubleNode<T> current;
		int index;

		if (pos > 0) {
			current = cab.next;
			index = 1;
			while (index < pos) {
				current = current.next;
				index++;
			}
		} else {
			current = cab.prev;
			index = -1;
			while (index > pos) {
				current = current.prev;
				index--;
			}
		}

		if (current.count > num) {
			current.count -= num;
			return current.elem;
		}

		T removedElement = current.elem;
		current.prev.next = current.next;
		current.next.prev = current.prev;

		return removedElement;

	}

	@Override
	public int remove(T elem, int num) throws EmptyCollectionException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new EmptyCollectionException("La lista está vacía");
		}
		if (elem == null) {
			throw new NullPointerException("El elemento no puede ser null");
		}
		if (num <= 0) {
			throw new IllegalArgumentException("El número de instancias a eliminar debe ser mayor que 0");
		}

		DoubleNode<T> current = cab.next;

		while (current != cab) {
			if (current.elem.equals(elem)) {
				if (current.count > num) {
					current.count -= num;
					return num;
				}

				int removedInstances = current.count;
				current.prev.next = current.next;
				current.next.prev = current.prev;
				return removedInstances;
			}
			current = current.next;
		}

		throw new NoSuchElementException("El elemento no está en la lista");

	}

	@Override
	public T getElemPos(int position) {
		// TODO Auto-generated method stub

		int size = size();

		if (position == 0 || Math.abs(position) > size) {
			throw new IllegalArgumentException("La posición debe estar entre 1 y " + size);
		}

		DoubleNode<T> current;
		int index;

		if (position > 0) {
			current = cab.next;
			index = 1;
			while (index < position) {
				current = current.next;
				index++;
			}
		} else {
			current = cab.prev;
			index = -1;
			while (index > position) {
				current = current.prev;
				index--;
			}
		}

		return current.elem;

	}

	@Override
	public boolean contains(T elem) {
		// TODO Auto-generated method stub
		if (elem == null) {
			throw new NullPointerException();
		}
		DoubleNode<T> current = cab.next;
		while (current != cab) {
			if (current.elem.equals(elem)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		int count = 0;
		DoubleNode<T> current = cab.next;
		while (current != cab) {
			count++;
			current = current.next;
		}
		return count;
	}

	@Override
	public int countInstances() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return 0;
		}
		int count = 0;
		DoubleNode<T> current = cab.next;
		while (current != cab) {
			count += current.count;
			current = current.next;
		}
		return count;
	}

	@Override
	public String toStringReverse() {
		if (cab == null || isEmpty()) {
			return "[]";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("[");

		DoubleNode<T> current = cab.prev;

		while (current != cab) {
			sb.append(current.elem).append("(").append(current.count).append(")");
			current = current.prev;
			if (current != cab) {
				sb.append(" ");
			}
		}

		sb.append(" ]");
		return sb.toString();
	}

	@Override
	public ArrayList<T> listMaxRepeated() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return new ArrayList<T>();
		}
		int maxCount = 0;
		DoubleNode<T> current = cab.next;
		while (current != cab) {
			if (current.count > maxCount) {
				maxCount = current.count;
			}
			current = current.next;
		}
		ArrayList<T> list = new ArrayList<T>();
		current = cab.next;
		while (current != cab) {
			if (current.count == maxCount) {
				list.add(current.elem);
			}
			current = current.next;
		}
		return list;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new DobleLinkedListIterator<T>(cab);
	}

	@Override
	public Iterator<T> reverseIterator() {
		// TODO Auto-generated method stub
		return new ReverseIterator<T>(cab);
	}

	@Override
	public Iterator<T> iteratorInstance() {
		// TODO Auto-generated method stub
		return new iteratorInstance<T>(cab);
	}

	@Override
	public Iterator<T> reverseIteratorInstance() {
		// TODO Auto-generated method stub
		return new reverseIteratorInstance<T>(cab);
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "[]";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("[");

		DoubleNode<T> current = cab.next;
		while (current != cab) {
			sb.append(current.elem).append("(").append(current.count).append(")");
			current = current.next;
			if (current != cab) {
				sb.append(" ");
			}
		}

		sb.append(" ]");
		return sb.toString();
	}
}
