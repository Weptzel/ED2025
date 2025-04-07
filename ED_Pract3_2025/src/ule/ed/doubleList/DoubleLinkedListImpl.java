package ule.ed.doubleList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedListImpl<T> implements IDoubleList<T> {

	// referencia al primer nodo de la lista
	private DoubleNode<T> front;

	// referencia al Último nodo de la lista
	private DoubleNode<T> last;

	private class DoubleNode<T> {

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
	public DoubleLinkedListImpl(T... v) {
		// permite añadir varios elementos a la lista en el constructor
		for (T elem : v) {
			this.addLast(elem, 1);
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return front == null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		front = null;
		last = null;
	}

	@Override
	public void addFirst(T elem, int n) {
		// TODO Auto-generated method stub
		if (elem == null) {
			throw new NullPointerException("Elemento nulo no permitido");
		}
		if (n <= 0) {
			throw new IllegalArgumentException("El número de instancias debe ser mayor que cero");
		}
		/* buscar si ya existe el elemento y añadir las instancias */
		DoubleNode<T> current = front;
		while (current != null) {
			if (current.elem.equals(elem)) {
				current.count += n;
				return;
			}
			current = current.next;
		}

		DoubleNode<T> newNode = new DoubleNode<>(elem, n);
		if (isEmpty()) {
			front = newNode;
			last = newNode;
		} else {
			newNode.next = front;
			front.prev = newNode;
			front = newNode;
		}
	}

	@Override
	public void addLast(T elem, int n) {
		// TODO Auto-generated method stub
		if (elem == null) {
			throw new NullPointerException("Elemento nulo no permitido");
		}
		if (n <= 0) {
			throw new IllegalArgumentException("El número de instancias debe ser mayor que cero");
		}
		/* BUscar elemento y añadir instancias */
		DoubleNode<T> current = front;
		while (current != null) {
			if (current.elem.equals(elem)) {
				current.count += n;
				return;
			}
			current = current.next;
		}

		DoubleNode<T> newNode = new DoubleNode<>(elem, n);
		if (isEmpty()) {
			front = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			newNode.prev = last;
			last = newNode;
		}

	}

	@Override
	public int removeFirst(int num) throws EmptyCollectionException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new EmptyCollectionException("Lista vacía");
		}
		if (num <= 0) {
			throw new IllegalArgumentException("El número de instancias debe ser mayor que cero");
		}

		DoubleNode<T> primero = front;
		if (primero.count > num) {
			primero.count = -num;
			return num;
		}

		int numInstancias = primero.count;
		front = front.next;
		if (front != null) {
			front.prev = null;
		} else {
			last = null;
		}
		return numInstancias;
	}

	@Override
	public T removeAllFirst() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new EmptyCollectionException("Lista vacía");
		}
		DoubleNode<T> primero = front;

		front = front.next;
		if (front != null) {
			front.prev = null;
		} else {
			last = null;
		}
		return primero.elem;
	}

	@Override
	public int removeLast(int num) throws EmptyCollectionException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new EmptyCollectionException("Lista vacía");
		}
		if (num <= 0) {
			throw new IllegalArgumentException("El número de instancias debe ser mayor que cero");
		}
		DoubleNode<T> ultimo = last;
		if (ultimo.count > num) {
			ultimo.count -= num;
			return num;
		}
		int numInstancias = ultimo.count;
		last = last.prev;
		if (last != null) {
			last.next = null;
		} else {
			front = null;
		}
		return numInstancias;
	}

	@Override
	public T removePos(int pos, int num) throws EmptyCollectionException {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new EmptyCollectionException("Lista vacía");
		}
		if (num <= 0) {
			throw new IllegalArgumentException("El número de instancias debe ser mayor que cero");
		}
		if (pos == 0 || Math.abs(pos) > size()) {
			throw new IllegalArgumentException("Posición no válida");
		}
		DoubleNode<T> current;
		int index;

		// Si la posición es positiva, recorrer desde el inicio
		if (pos > 0) {
			current = front;
			index = 1;
			while (index < pos) {
				current = current.next;
				index++;
			}
		} else {
			// Si la posición es negativa, recorrer desde el final
			current = last;
			index = -1;
			while (index > pos) {
				current = current.prev;
				index--;
			}
		}

		T elemento = current.elem;

		// Caso 1: Reducir la multiplicidad si es mayor que `num`
		if (current.count > num) {
			current.count -= num;
			return elemento;
		}

		// Caso 2: Eliminar el nodo si la multiplicidad es menor o igual a `num`
		if (current.prev != null) {
			current.prev.next = current.next;
		} else {
			front = current.next; // Actualizar `front` si es el primer nodo
		}
		if (current.next != null) {
			current.next.prev = current.prev;
		} else {
			last = current.prev; // Actualizar `last` si es el último nodo
		}

		return elemento;
	}

	@Override
	public int remove(T elem, int num) throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T getElemPos(int position) {
		// TODO Auto-generated method stub
		int positionAux = Math.abs(position);
		if (position == 0 || positionAux >= size()) {
			throw new NoSuchElementException("Posición no válida");
		}
		DoubleNode<T> current;
		if(position > 0) {
			current = front;
			for (int i = 0; i < positionAux; i++) {
				current = current.next;
			}
			return current.elem;
		} else {
			current = last;
			for (int i = -1; i > positionAux; i--) {
				current = current.prev;
			}
			return current.elem;
		}
		
	}

	@Override
	public boolean contains(T elem) {
		// TODO Auto-generated method stub
		if(elem == null) {
			throw new NullPointerException("Elemento nulo no permitido");
		}
		boolean found = false;
		DoubleNode<T> current = front;
		while (current != null && !found) {
			if (current.elem.equals(elem)) {
				found = true;
				return found;
			}
			current = current.next;
		}
		return found;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		int count = 0;
		DoubleNode<T> current = front;
		while (current != null) {
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
		DoubleNode<T> current = front;
		int count = 0;
		while(current != null){
			count += current.count;
			current = current.next;
		} 
		
		return count;
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