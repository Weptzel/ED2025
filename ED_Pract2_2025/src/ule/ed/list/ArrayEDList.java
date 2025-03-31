package ule.ed.list;

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

			return count < data.length;
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
		public ArrayListEvenIterator(T[] data){
			this.count = 0;
			this.data = data; 
		}

		public boolean hasNext(){
			return count < data.length;
		}

		public T next(){
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			T elem = data[count];
			count += 2;
			return elem;
		}
	}

	private class ArrayListNRepeatIterator<T> implements Iterator {
		private int count;
		private T[] data;

		public ArrayListNRepeatIterator(int n){
			this.count = 0;
			this.data = data;
		}

		public boolean hasNext(){
			return count < data.length;
		}

		/* modificar */
		public T next(){
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T elem = data[count];
			count++;
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
		for (int i = 0; i < data.length; i++) {
			data[i] = null;
		}

	}

	@Override
	public void addFirst(T elem) {
		// TODO
		if (elem == null) {
			throw new NullPointerException();
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
		data[count] = elem;
		count++;
	}

	@Override
	public void addPenult(T elem) {
		// TODO
		if (elem == null) {
			throw new NullPointerException();
		}
		/* si la lista esta vacia */
		if (isEmpty()) {
			addFirst(elem);
		}
		/* Si solo hay un elemento */
		if (size() == 1) {
			addFirst(elem);
		}
		/* desplazar a la derecha desde el penultimo */
		for (int i = size(); i > size() - 1; i--) {
			data[i] = data[i - 1];
		}
		data[count - 1] = elem;
		count++;
	}

	@Override
	public void addPos(T elem, int position) {
		// TODO
		if(elem == null) {
			throw new NullPointerException();
		}
		if(position < 0) {
			throw new IllegalArgumentException();
		}
		if(position == 0){
			addFirst(elem);
		}
		if(position >= size()){
			addLast(elem);
		}
		/* desplazar a la derecha desde la posicion */
		for(int i = size(); i > position; i--){
			data[i] = data[i - 1];
		}
		data[position] = elem;
		count++;
	}

	@Override
	public T removeFirst() throws EmptyCollectionException {
		// TODO
		if(isEmpty()) {
			throw new EmptyCollectionException("ArrayEDList");
		}
		T elem = data[0];
		/* desplazar a la izquierda todos los elementos */
		for(int i = 0; i < size() - 1; i++) {
			data[i] = data[i + 1];
		}
		data[count - 1] = null; /* Eliminar la referencia al ultimo elemento */
		count--; 
		return elem;
	}

	@Override
	public T removelast() throws EmptyCollectionException {
		// TODO
		if(isEmpty()) {
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
		if(isEmpty()) {
			throw new EmptyCollectionException("ArrayEDList");
		}
		if(size() == 2) {
			return removeFirst();
		}
		T elem = data[count - 2];
		/* desplazar a la izquierda desde el penultimo */
		for(int i = size(); i > size() - 1; i++) {
			data[i] = data[i + 1];
		}
		data[count - 1] = null;
		count--;
		return elem;
	}

	@Override
	public T removeElem(T elem) throws EmptyCollectionException {
		// TODO
		int position = 0;
		if(isEmpty()){
			throw new EmptyCollectionException("ArrayEDList");
		}

		if(elem == null){
			throw new NullPointerException();
		}
		/* Buscar primera posicion del elemento */
		position = getPosFirst(elem);
		/* Mover elementos desde la primera aparicion hasta el final a la izquierda */
		for(int i = position; i < size() - 1; i++){
			data[i] = data[i + 1];
		}
		data[count - 1] = null;
		count--;
		return elem;
	}

	@Override
	public T getElemPos(int position) {
		// TODO
		if(position < 0 || position >= size()) {
			throw new IndexOutOfBoundsException();
		}
		return data[position];
	}

	@Override
	public int getPosFirst(T elem) {
		// TODO
		int pos = 0;
		boolean found = false; 
		if(elem == null){
			throw new NullPointerException();
		}

		for(int i = 0; i < size(); i++){
			if(data[i] == elem && !found){
				pos = i;
			}
		}
		return pos;
	}

	@Override
	public int getPosLast(T elem) {
		// TODO
		int pos = 0;
		boolean found = false;

		for(int i = size(); i > 0; i--){
			if(data[i] == elem && !found){
				pos = i;
			}
		}
		return pos;
	}

	@Override
	public EDList<T> reverse() {
		// TODO
		EDList<T> listRev = new ArrayEDList<T>();
		if(isEmpty()){
			return listRev;
		}
		for(int i = size() - 1; i >= 0; i--){
			listRev.addLast(data[i]);
		}
		return listRev;
	}

	public String toString() {
		// TODO
		return "toString()";

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
		if(isEmpty()){
			throw new EmptyCollectionException("ArrayEDList");
		}
		if(elem == null){
			throw new NullPointerException();
		}
		/* Encontrar ultima posicion */
		position = getPosLast(elem);

		/* Desplazar a la izquierda */
		for(int i = position; i < size() - 1; i++){
			data[i] = data[i + 1];
		}
		data[count - 1] = null;
		count--;
		return position;
	}

	@Override
	public int removeN(T elem, int n) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T mostFrequent() {
		// TODO Auto-generated method stub
		T masfrecuente = (T) data[0];
		int maxFrecuencia = 1;

		for(int i = 0; i < size(); i++){
			T actual = (T) data[i];
			int frecuenciaActual = 1;

			for(int j = i + 1; j < size(); j++){
				if(actual.equals(data[j])){
					frecuenciaActual++;
				}
			}
			if(frecuenciaActual > maxFrecuencia){
				maxFrecuencia = frecuenciaActual;
				masfrecuente = actual;
			}
		}
		return masfrecuente;
	}

	@Override
	public T leastFrequent() {
		T menosFrecuente = (T) data[0];
		int minFrecuencia = 1;
		int indiceMenosfrec = 0;

		for(int i = 0; i < size(); i++){
			T actual = (T) data[i];
			boolean yaContado = false;
			
			for(int j = 0; j < i; j++){
				if(actual.equals(data[j])){
					yaContado = true;
					break;
				}
			}
			if(!yaContado){
				int frecuenciaActual = 1;
				for(int j = i; j < size(); j++){
					if(actual.equals(data[j])){
						frecuenciaActual++;
					}
				}
				if(frecuenciaActual < minFrecuencia || (frecuenciaActual == minFrecuencia && i < indiceMenosfrec)){
					menosFrecuente = actual;
					minFrecuencia = frecuenciaActual;
					indiceMenosfrec = i;
				}
			}
		}
		// TODO Auto-generated method stub
		return menosFrecuente;
	}

	@Override
	public Iterator<T> repeatNiterator(int n) {
		// TODO Auto-generated method stub
		return new ArrayListNRepeatIterator<>(n);
	}

}
