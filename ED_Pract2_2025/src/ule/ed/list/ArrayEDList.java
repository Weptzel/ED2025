package ule.ed.list;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArrayEDList<T> implements EDList<T> {
	//private final int DEFAULT_CAPACITY=100; 
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
		
		public ArrayListIterator(T[] data){
	//TODO
	}
		
		@Override
		public boolean hasNext() {
			//TODO
			
			return false;
	}

		@Override
		public T next() { //esto s�lo es una prueba
			//TODO
			
			return null;
	}	
	}
	
//////FIN ITERATOR
/// AÑADIR TANTAS CLASES DE ITERADORES COMO MÉTODOS DE ITERADOR HAYA EN EL INTERFACE


	@SuppressWarnings("hiding")
	private class ArrayListOddIterator<T> implements Iterator<T> {
		
		private int count;
		private T[] data;
		
		public ArrayListOddIterator(T[] data){
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
		return null;
		//TODO
		
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
		//TODO
		return null;

	}

	@Override
	public Iterator<T> evenPositionsIterator() {
		//TODO
		return null;

	}

	@Override
	public Iterator<T> oddPositionsIterator() {
		//TODO
		return null;
	}



	@Override
	public int removeLastElem(T elem) throws EmptyCollectionException {
		//TODO
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
