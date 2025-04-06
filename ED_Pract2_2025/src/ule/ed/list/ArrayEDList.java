package ule.ed.list;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayEDList<T> implements EDList<T> {
	// private final int DEFAULT_CAPACITY=100;
	private T[] data;
	private int count;

	public ArrayEDList() {
		count = 0;
		data = (T[]) (new Object[5]);
	}

	public ArrayEDList(int initialCapacity) {
		count = 0;
		data = (T[]) (new Object[initialCapacity]);
	}

	@SuppressWarnings("hiding")
	private class ArrayListIterator<T> implements Iterator<T> {

		private int count;
		private T[] data;

		public ArrayListIterator(T[] data) {
			// TODO
			this.data = data;
			this.count = 0;
		}

		@Override
		public boolean hasNext() {
			// TODO

			return count < data.length;
		}

		@Override
		public T next() { // esto s�lo es una prueba
			// TODO
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return data[count++]; /* Devuelvo el elemento */
		}
	}

	////// FIN ITERATOR
	/// AÑADIR TANTAS CLASES DE ITERADORES COMO MÉTODOS DE ITERADOR HAYA EN EL
	////// INTERFACE

	@SuppressWarnings("hiding")
	private class ArrayListOddIterator<T> implements Iterator<T> {

		private int count;
		private T[] data;

		public ArrayListOddIterator(T[] data) {
			// TODO
			this.data = data;
			this.count = 1;
		}

		@Override
		public boolean hasNext() {
			// TODO

			return count < data.length && data[count] != null;
		}

		@Override
		public T next() {
			// TODO
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			/*
			 * Obtengo el elemento de la posicion impar actual, avanzo hacia la siguiente
			 * posicion impar y devuelvo el elemento
			 */
			T elem = data[count];
			count += 2;
			return elem;
		}
	}

	private class ArrayListEvenIterator<T> implements Iterator<T> {
		private int count;
		private T[] data;

		public ArrayListEvenIterator(T[] data) {
			this.count = 0;
			this.data = data;
		}

		public boolean hasNext() {
			return count < data.length && data[count] != null;
		}

		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T elem = data[count];
			count += 2;
			return elem;
		}
	}

	private class ArrayListNRepeatIterator<T> implements Iterator {
		private int index;
		private int n;
		private int count;
		private T[] data;

		public ArrayListNRepeatIterator(int n) {
			this.index = 0;
			this.n = n;
			this.count = 0;
			this.data = data;
		}

		public boolean hasNext() {
			return index < count;
		}

		/* modificar */
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T elem = data[index];
			count++;
			if(count == n) {
				count = 0;
				index++;
			}
			return elem;
		}
	}

	@Override
	public int size() {
		// TODO
		return count;
	}

	@Override
	public boolean isEmpty() {
		// TODO
		return count == 0;

	}

	@Override
	public void clear() {
		// TODO
		count = 0;
		for (int i = 0; i < count; i++) {
			data[i] = null;
		}

	}

	@Override
	public void addFirst(T elem) {
		// TODO
		if (elem == null) {
			throw new NullPointerException();
		}
		if (size() == data.length) {
			resize();
		}
		/* desplazar a la derecha todos los elementos */
		for (int i = size(); i > 0; i--) {
			data[i] = data[i - 1];
		}
		/* primer elemento */
		data[0] = elem;
		count++;

	}

	@Override
	public void addLast(T elem) {
		// TODO
		if (elem == null) {
			throw new NullPointerException();
		}
		if (size() == data.length) {
			resize();
		}
		data[count] = elem;
		count++;
	}

	@Override
	public void addPenult(T elem) {
		// TODO
		if (elem == null) {
			throw new NullPointerException();
		}
		if (data.length == size()) {
			resize();
		}
		/* si la lista esta vacia o solo hay un elemento */
		if (isEmpty() || size() == 1) {
			addFirst(elem);
			return;
		}
		int penultPos = count - 1;
		/* desplazar a la derecha desde el penultimo */
		for (int i = count; i > count - penultPos; i--) {
			data[i] = data[i - 1];
		}
		data[penultPos] = elem;
		count++;
	}

	@Override
	public void addPos(T elem, int position) {
		// TODO
		if (elem == null) {
			throw new NullPointerException();
		}
		if (position <= 0) {
			throw new IllegalArgumentException();
		}
		if (count == data.length) {
			resize();
		}

		if (position > size()) {
			addLast(elem);
			return;
		}

		/* desplazar a la derecha desde la posicion - 1 */
		for (int i = count; i >= position; i--) {
			data[i] = data[i - 1];
		}
		data[position - 1] = elem;
		count++;
	}

	@Override
	public T removeFirst() throws EmptyCollectionException {
		// TODO
		if (isEmpty()) {
			throw new EmptyCollectionException("ArrayEDList");
		}
		T elem = data[0];
		/* desplazar a la izquierda todos los elementos */
		for (int i = 0; i < count - 1; i++) {
			data[i] = data[i + 1];
		}
		data[count - 1] = null; /* Eliminar la referencia al ultimo elemento */
		count--;
		return elem;
	}

	@Override
	public T removelast() throws EmptyCollectionException {
		// TODO
		if (isEmpty()) {
			throw new EmptyCollectionException("ArrayEDList");
		}
		T elem = data[count - 1];
		data[count - 1] = null;
		count--;
		return elem;
	}

	@Override
	public T removePenult() throws EmptyCollectionException {
		// TODO
		if (isEmpty()) {
			throw new EmptyCollectionException("ArrayEDList");
		}
		if (size() == 1) {
			throw new NoSuchElementException();
		}
		if (size() == 2) {
			return removeFirst();
		}
		T elem = data[count - 2];
		/* desplazar a la izquierda desde el penultimo */
		for (int i = count - 2; i < count - 1; i++) {
			data[i] = data[i + 1];
		}
		data[count - 1] = null;
		count--;
		return elem;
	}

	@Override
	public T removeElem(T elem) throws EmptyCollectionException {
		// TODO
		if (isEmpty()) {
			throw new EmptyCollectionException("ArrayEDList");
		}

		if (elem == null) {
			throw new NullPointerException();
		}
		/* Buscar primera posicion del elemento */
		int position = getPosFirst(elem) - 1;

		if (position < 0) {
			throw new NoSuchElementException();
		}

		/* Mover elementos desde la primera aparicion hasta el final a la izquierda */
		for (int i = position; i < count - 1; i++) {
			data[i] = data[i + 1];
		}
		data[count - 1] = null;
		count--;
		return elem;
	}

	@Override
	public T getElemPos(int position) {
		// TODO
		if (position < 1 || position > size()) {
			throw new IllegalArgumentException();
		}
		return data[position];
	}

	@Override
	public int getPosFirst(T elem) {
		// TODO
		if (elem == null) {
			throw new NullPointerException();
		}

		for (int i = 0; i < size(); i++) {
			if (data[i].equals(elem)) {
				return i + 1;
			}
		}
		throw new NoSuchElementException();
	}

	@Override
	public int getPosLast(T elem) {
		// TODO
		if (elem == null) {
			throw new NullPointerException();
		}
		for (int i = size() - 1; i >= 0; i--) {
			if (data[i].equals(elem)) {
				return i + 1;
			}
		}
		throw new NoSuchElementException();
	}

	@Override
	public EDList<T> reverse() {
		// TODO
		EDList<T> listRev = new ArrayEDList<T>();
		if (isEmpty()) {
			return listRev;
		}
		for (int i = size() - 1; i >= 0; i--) {
			listRev.addLast(data[i]);
		}
		return listRev;
	}

	public String toString() {
		// TODO
		if (isEmpty()) {
			return "()";
		}
		StringBuilder sb = new StringBuilder("(");

		for (int i = 0; i < size(); i++) {
			sb.append(data[i].toString());
			if (i < size() - 1) {
				sb.append(" ");
			}
		}

		sb.append(" )");
		return sb.toString();
	}

	@Override
	public Iterator<T> iterator() {
		// TODO
		return new ArrayListIterator<>(data);
	}

	@Override
	public Iterator<T> evenPositionsIterator() {
		// TODO
		return new ArrayListEvenIterator<>(data);

	}

	@Override
	public Iterator<T> oddPositionsIterator() {
		// TODO
		return new ArrayListOddIterator<>(data);
	}

	@Override
	public int removeLastElem(T elem) throws EmptyCollectionException {
		// TODO
		int position = 0;
		if (elem == null) {
			throw new NullPointerException();
		}
		if (isEmpty()) {
			throw new EmptyCollectionException("ArrayEDList");
		}

		/* Encontrar ultima posicion */
		position = getPosLast(elem);

		if(position == 0){
			throw new NoSuchElementException();
		}	

		/* Desplazar a la izquierda */
		for (int i = position - 1; i < size() - 1; i++) {
			data[i] = data[i + 1];
		}
		data[count - 1] = null;
		count--;
		return position;
	}

	@Override
	public int removeN(T elem, int n) {
		// TODO Auto-generated method stub
		if (elem == null) {
			throw new NullPointerException();
		}
		int countElem = 0;
		for (int i = 0; i < size(); i++) {
			if (data[i].equals(elem)) {
				countElem++;
			}
		}

		if (countElem == 0) {
			throw new NoSuchElementException();
		}

		if (n > countElem) {
			n = countElem;
		}

		int countRemoved = 0;

		for (int i = 0; i < size() && countRemoved < n; i++) {
			if (data[i].equals(elem)) {
				/* Desplazar a la izquierda */
				for (int j = i; j < size() - 1; j++) {
					data[j] = data[j + 1];
				}
				data[count - 1] = null;
				count--;
				countRemoved++;
				i--;
			}
		}
		return countRemoved;
	}

	@Override
	public T mostFrequent() {
		/*
		 * if (isEmpty()) {
		 * throw new EmptyCollectionException("ArrayEDList");
		 * }
		 */

		T masFrecuente = null;
		int maxFrecuencia = 0;

		for (int i = 0; i < size(); i++) {
			T actual = data[i];

			// Si ya lo contamos antes, lo saltamos
			boolean yaContado = false;
			for (int k = 0; k < i; k++) {
				if (actual.equals(data[k])) {
					yaContado = true;
					break;
				}
			}
			if (yaContado)
				continue;

			int frecuenciaActual = 0;
			for (int j = 0; j < size(); j++) {
				if (actual.equals(data[j])) {
					frecuenciaActual++;
				}
			}

			if (frecuenciaActual > maxFrecuencia) {
				maxFrecuencia = frecuenciaActual;
				masFrecuente = actual;
			}
		}

		return masFrecuente;
	}

	@Override
	public T leastFrequent() {
		/*
		 * if(isEmpty()){
		 * throw new EmptyCollectionException("ArrayEDList");
		 * }
		 */
		T menosFrecuente = null;
		int minFrecuencia = Integer.MAX_VALUE; // Inicializar con el valor máximo posible

		for (int i = 0; i < size(); i++) {
			T actual = data[i];
			int frecuenciaActual = 0;

			// Calcular la frecuencia del elemento actual
			for (int j = 0; j < size(); j++) {
				if (actual.equals(data[j])) {
					frecuenciaActual++;
				}
			}

			// Actualizar el menos frecuente si encontramos una frecuencia menor
			if (frecuenciaActual < minFrecuencia) {
				menosFrecuente = actual;
				minFrecuencia = frecuenciaActual;
			}
		}

		return menosFrecuente;
	}

	@Override
	public Iterator<T> repeatNiterator(int n) {
		// TODO Auto-generated method stub
		if(n <= 0) {
			throw new IllegalArgumentException();
		}
		return new ArrayListNRepeatIterator<>(n);
	}

	public void resize() {
		// TODO
		T[] newData = (T[]) (new Object[data.length * 2]);
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

}
