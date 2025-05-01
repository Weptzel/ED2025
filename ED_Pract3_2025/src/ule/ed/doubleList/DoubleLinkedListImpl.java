package ule.ed.doubleList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import ule.ed.doubleList.DoubleLinkedCircularList.DoubleNode;

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
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			T elem = node.elem;
			node = node.next;
			return elem;
		}
	}

	////// FIN ITERATOR

	@SuppressWarnings("hiding")
	private class DoubleLinkedListIteratorReverse<T> implements Iterator<T> {
		DoubleNode<T> node;

		public DoubleLinkedListIteratorReverse(DoubleNode<T> aux) {
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
			node = node.prev;
			return elem;
		}
	}

	// TODO: añadir clases para el resto de iteradores


	@SuppressWarnings("hiding")
	private class DoubleLinkedListIteratorInstance<T> implements Iterator<T> {
		private DoubleNode<T> current;
		private int currentCount;
		public DoubleLinkedListIteratorInstance(DoubleNode<T> start) {
			this.current = start;
			this.currentCount = (start != null) ? start.count : 0;
		}

		@Override
		public boolean hasNext() {
			// TODO
			return current != null;
		}

		@Override
		public T next() {
			// TODO
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T elem = current.elem;
			currentCount--;
			if (currentCount == 0) {
				current = current.next;
				if (current != null) {
					currentCount = current.count;
				}
			}
			return elem;
		}
	}


	@SuppressWarnings("hiding")
	private class DoubleLinkedListIteratorReverseInstance<T> implements Iterator<T> {
		private DoubleNode<T> current;
		private int currentCount;

		public DoubleLinkedListIteratorReverseInstance(DoubleNode<T> start) {
			this.current = start;
			this.currentCount = (start != null) ? start.count : 0;
		}

		@Override
		public boolean hasNext() {
			// TODO
			return current != null;
		}

		@Override
		public T next() {
			// TODO
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T elem = current.elem;
			currentCount--;
			if (currentCount == 0) {
				current = current.prev;
				if (current != null) {
					currentCount = current.count;
				}
			}
			return elem;
		}
	}

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
			primero.count -= num;
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

		if (pos > 0) {
			current = front;
			index = 1;
			while (index < pos) {
				current = current.next;
				index++;
			}
		} else {
			current = last;
			index = -1;
			while (index > pos) {
				current = current.prev;
				index--;
			}
		}

		T elemento = current.elem;

		if (current.count > num) {
			current.count -= num;
			return elemento;
		}

		if (current.prev != null) {
			current.prev.next = current.next;
		} else {
			front = current.next; 
		}
		if (current.next != null) {
			current.next.prev = current.prev;
		} else {
			last = current.prev; 
		}

		return elemento;
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
	
		DoubleNode<T> current = front;
	
		while (current != null) {
			if (current.elem.equals(elem)) {

				if (current.count > num) {
					current.count -= num;
					return num; 
				}
	
				
				int removedInstances = current.count; 
				if (current.prev != null) {
					current.prev.next = current.next;
				} else {
					front = current.next; 
				}
				if (current.next != null) {
					current.next.prev = current.prev;
				} else {
					last = current.prev; 
				}
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
        throw new IllegalArgumentException("Posición no válida");
    }

    DoubleNode<T> current;

    if (position > 0) {
        current = front;
        for (int i = 1; i < position; i++) {
            current = current.next;
        }
    } else {
        current = last;
        for (int i = -1; i > position; i--) {
            current = current.prev;
        }
    }

    return current.elem;
		
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
		if (last == null) {
			return "[]";
		}
	
		StringBuilder sb = new StringBuilder();
		sb.append("[");
	
		DoubleNode<T> current = last;
	
		while (current != null) {
			sb.append(current.elem).append("(").append(current.count).append(")");
			current = current.prev;
			if (current != null) {
				sb.append(" "); 
			}
		}
	
		sb.append(" ]"); 
		return sb.toString();
	}

	@Override
	public ArrayList<T> listMaxRepeated() {
		// TODO Auto-generated method stub
		if(front == null){
			return new ArrayList<>();
		}

		/* Buscar max de repes */
		int maxCount = 0;
		DoubleNode<T> current = front;
		while (current != null) {
			if (current.count > maxCount) {
				maxCount = current.count;
			}
			current = current.next;
		}

		/* Obtener los elementos */
		ArrayList<T> list = new ArrayList<>();
		current = front;
		while (current != null) {
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
		return new DoubleLinkedListIterator<>(front);
	}

	@Override
	public Iterator<T> reverseIterator() {
		// TODO Auto-generated method stub
		return new DoubleLinkedListIteratorReverse<>(last);
	}

	@Override
	public Iterator<T> iteratorInstance() {
		// TODO Auto-generated method stub
		return new DoubleLinkedListIteratorInstance<>(front);
	}

	@Override
	public Iterator<T> reverseIteratorInstance() {
		// TODO Auto-generated method stub
		return new DoubleLinkedListIteratorReverseInstance<>(last);
	}

	@Override
public String toString() {
	 if (isEmpty()) {
        return "[]";
    }

    StringBuilder sb = new StringBuilder();
    sb.append("[");

    DoubleNode<T> current = front;
    while (current != null) {
        sb.append(current.elem).append("(").append(current.count).append(")");
        current = current.next;
        if (current != null) {
            sb.append(" "); 
        }
    }

    sb.append(" ]"); 
    return sb.toString();
}

}