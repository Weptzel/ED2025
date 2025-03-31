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
			// TODO
			/* nodo inicial */
			this.node = aux;
		}

		@Override
		public boolean hasNext() {
			// TODO
			return node != null;
		}

		@Override
		public T next() {
			// TODO
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			/* Guardar elemento, avanzar al siguiente nodo y devolverlo */
			T elem = node.elem;
			node = node.next;
			return elem;

		}
	}

	public class LinkedListOddIterator<T> implements Iterator<T> {
		Node<T> node;

		public LinkedListOddIterator(Node<T> aux) {
			this.node = aux;
		}

		@Override
		public boolean hasNext() {
			// TODO
			return node != null;
		}

		@Override
		public T next() {
			// TODO
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T elem = node.elem;
			/* Avanzar al siguiente nodo impar */
			if (node.next != null) {
				node = node.next.next;
			} else {
				node = null;
			}
			return elem;
		}
	}

	public class LinkedListEvenIterator<T> implements Iterator<T> {

		Node<T> node;

		public LinkedListEvenIterator(Node<T> aux) {
			// TODO
			this.node = aux;
			if (this.node != null && this.node.next != null) {
				this.node = this.node.next;
			}
		}

		@Override
		public boolean hasNext() {
			// TODO
			return node != null;
		}

		@Override
		public T next() {
			// TODO
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T elem = node.elem;
			/* Avanzar al siguiente nodo par */
			if (node.next != null && node.next.next != null) {
				node = node.next.next;
			} else {
				node = null;
			}
			return elem;
		}
	}

	// AÑADIR RESTO DE CLASES DE ITERADORE

private class LinkedListRepeatNiterator implements Iterator<T> {
    private Node<T> current; // Nodo actual que se está iterando
    private int count;       // Contador para las repeticiones de cada elemento
    private final int n;     // Número de repeticiones por elemento

    public LinkedListRepeatNiterator(int n) {
        this.current = front; // Comienza desde el primer nodo
        this.count = 0;       // Inicializa el contador de repeticiones
        this.n = n;           // Almacena el número de repeticiones
    }

    @Override
    public boolean hasNext() {
        // Hay más elementos si el nodo actual no es nulo
        return current != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        // Obtener el elemento actual
        T elem = current.elem;

        // Incrementar el contador de repeticiones
        count++;

        // Si se han alcanzado las n repeticiones, avanzar al siguiente nodo
        if (count == n) {
            current = current.next;
            count = 0; // Reiniciar el contador para el siguiente nodo
        }

        return elem;
    }
}
	///////
	@Override
	public int size() {
		// TODO
		int count = 0;
		Node<T> current = front;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	@Override
	public boolean isEmpty() {
		// TODO
		return front == null;
	}

	@Override
	public void clear() {
		// TODO
		if (isEmpty()) {
			return;
		}
		/* Recorrer lista desde el primer elemento */
		Node<T> current = front;
		while (current != null) {
			/* Guardar el siguiente nodo */
			Node<T> next = current.next;
			/* Eliminar el nodo actual y romper el enlace al siguiente elemento */
			current.elem = null;
			current.next = null;
			/* Avanzar al siguiente nodo */
			current = next;
		}
		front = null;
	}

	@Override
	public void addFirst(T elem) {
		// TODO
		if (elem == null) {
			throw new NullPointerException();
		}
		Node<T> newNode = new Node<T>(elem);
		newNode.next = front;
		front = newNode;
	}

	@Override
	public void addLast(T elem) {
		// TODO
		if (elem == null) {
			throw new NullPointerException();
		}
		if (isEmpty()) {
			addFirst(elem);
		} else {
			Node<T> current = front;
			/* Recorrer hasta el ultimo */
			while (current.next != null) {
				current = current.next;
			}
			Node<T> nuevo = new Node<T>(elem);
			current.next = nuevo;
		}

	}

	@Override
	public void addPenult(T elem) {
		// TODO
		if (elem == null) {
			throw new NullPointerException();
		}
		Node<T> newNode = new Node<T>(elem);
		if (isEmpty()) {
		addFirst(elem);
			return;
		}
		/* un elemento */
		if (front.next == null) {
			addFirst(elem);
			return;
		}
		Node<T> current = front;
		while (current.next.next != null) {
			current = current.next;
		}
		newNode.next = current.next;
		current.next = newNode;
	}

	@Override
	public void addPos(T elem, int position) {
		// TODO
		if (elem == null) {
			throw new NullPointerException();
		}
		if (position < 0) {
			throw new IllegalArgumentException();
		}
		if (position == 0) {
			addFirst(elem);
			return;
		}
		if (position > size()) {
			addLast(elem);
			return;
		}
		Node<T> newNode = new Node<T>(elem);
		Node<T> current = front;
		int i = 0;
		while (current != null && i < position) {
			if(i == position) {
				newNode.next = current.next;
				current.next = newNode;
				break;
			}
			i++;
		current = current.next;;
		}
	}

	@Override
	public T removeFirst() throws EmptyCollectionException {
		// TODO
		if (isEmpty()) {
			throw new EmptyCollectionException("LinkedEDList");
		}
		T elem = front.elem;
		front = front.next;
		return elem;
	}

	@Override
	public T removelast() throws EmptyCollectionException {
		// TODO
		if (isEmpty()) {
			throw new EmptyCollectionException("LinkedEDList");
		}
		/* un elemento */
		if (front.next == null) {
			T elem = removeFirst();
			return elem;
		}
		Node<T> current = front;
		while (current.next != null) {
			current = current.next;
		}
		T elem = current.elem;
		current.next = null;
		return elem;
	}

	@Override
	public T removePenult() throws EmptyCollectionException {
		// TODO
		if (isEmpty()) {
			throw new EmptyCollectionException("LinkedEDList vacia");
		}
		/* Un elemento */
		if (front.next == null) {
			throw new EmptyCollectionException("LinkedEDList no tiene para borrar penul");
		}
		/* Dos elementos */
		if (front.next.next == null) {
			return removeFirst();
		}
		Node<T> current = front;
		while (current.next.next != null) {
			current = current.next;
		}
		T elem = current.elem;
		current.next = current.next.next;
		return elem;

	}

	@Override
	public T removeElem(T elem) throws EmptyCollectionException {
		// TODO
		int pos = 0;
		if (isEmpty()) {
			throw new EmptyCollectionException("LinkedEDList");
		}
		if (elem == null) {
			throw new NullPointerException();
		}
		if(front.elem.equals(elem)) {
			return removeFirst();
		}
		Node<T> current = front;
		Node<T> previous = null;
		while (current != null && !current.next.elem.equals(elem)) {
			current = current.next;
			pos++;
		}
		if (current.next != null) {
			current.next = current.next.next;
		}else{
			throw new NoSuchElementException("Elemento no encontrado");
		}
		return current.elem;
	}

	@Override
	public T getElemPos(int position) {
		// TODO
		if(position < 0 || position >= size()){
			throw new IllegalArgumentException();
		}
		Node<T> current = front;
		int index = 0;
		while (current != null) {
			if(index == position) {
				return current.elem;
			}
			current = current.next;
			index++;
		}
		throw new NoSuchElementException();
	}

	@Override
	public int getPosFirst(T elem) {
		// TODO
		if(elem == null) {
			throw new NullPointerException();
		}
		Node<T> current = front;
		int index = 0;
		while (current != null) {
			if(current.elem.equals(elem)) {
				return index;
			}
			current = current.next;
			index++;
		}
		throw new NoSuchElementException();
	}

	@Override
	public int getPosLast(T elem) {
		// TODO
		if (elem == null) {
			throw new NullPointerException();
		}
		Node<T> current = front;
		int index = 0;
		int lastIndex = -1;
		while (current != null) {
			if (current.elem.equals(elem)) {
				lastIndex = index;
			}
			current = current.next;
			index++;
		}
		if (lastIndex == -1) {
			throw new NoSuchElementException();
		}
		return lastIndex;
	}

	@Override
	public EDList<T> reverse() {
		// TODO
		LinkedEDList<T> listRev = new LinkedEDList<T>();
		if (isEmpty()) {
			return listRev;
		}
		Node<T> current = front;
		while(current != null){
			listRev.addFirst(current.elem);
			current = current.next;
		} 
		return listRev;
	}

	public String toString() {
		// TODO
		StringBuilder sb = new StringBuilder();
		Node<T> current = front;
		while (current != null) {
			sb.append(current.elem);
			if (current.next != null) {
				sb.append(" ");
			}
			current = current.next;
		}
		return sb.toString();

	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator(this.front);
	}

	@Override
	public Iterator<T> evenPositionsIterator() {
		return new LinkedListEvenIterator(this.front);
	}

	@Override
	public Iterator<T> oddPositionsIterator() {
		// TODO
		return new LinkedListOddIterator(this.front);
	}

	@Override
	public int removeLastElem(T elem) throws EmptyCollectionException {
		if (isEmpty()) {
			throw new EmptyCollectionException("La lista está vacía");
		}
		if (elem == null) {
			throw new NullPointerException("El elemento no puede ser null");
		}
	
		Node<T> current = front;
		Node<T> previous = null;
		Node<T> lastMatch = null;
		Node<T> lastMatchPrevious = null;
		int index = 0;
		int lastMatchIndex = -1;
	
		// Recorrer la lista para encontrar la última aparición del elemento
		while (current != null) {
			if (current.elem.equals(elem)) {
				lastMatch = current;
				lastMatchPrevious = previous;
				lastMatchIndex = index;
			}
			previous = current;
			current = current.next;
			index++;
		}
	
		if (lastMatch == null) {
			throw new NoSuchElementException("El elemento no está en la lista");
		}
	
		/* Eliminar el nodo que contiene la última aparición del elemento */
		if (lastMatchPrevious == null) {
			front = front.next;
		} else {
			lastMatchPrevious.next = lastMatch.next;
		}
	
		return lastMatchIndex;
	}

	@Override
	public int removeN(T elem, int n) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T mostFrequent() {
		// TODO Auto-generated method stub
		T elem = front.elem;
		return elem;
	}

	@Override
	public T leastFrequent() {
		// TODO Auto-generated method stub
		T elem = front.elem;
		return elem;
	}

	@Override
	public Iterator<T> repeatNiterator(int n) {
		// TODO Auto-generated method stub
		if (n <= 0) {
			throw new IllegalArgumentException("El valor de n debe ser mayor que 0");
		}
		return new LinkedListRepeatNiterator(n);
	}

}
