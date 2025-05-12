package ule.ed.recursivelist;


public class LinkedEDList<T> implements EDList<T> {

	//	referencia al primer  de la lista
	private Node<T> front;

	

	private class Node<T> {

		Node(T element) {
			this.elem = element;
			this.next = null;
		}

		T elem;

		Node<T> next;
	}

	@Override
	public boolean isEmpty() {
		// TODO 
		return false;
	}


	@Override
	public int size() {
		// TODO RECURSIVAMENTE
		return 0;
	}


	@Override
	public void addLast(T elem) {
		// TODO RECURSIVAMENTE
		
	}

	
	@Override
	public void addPos(T elem, int position) {
		// TODO RECURSIVAMENTE
		
	}

	@Override
	public boolean addBefore(T elem, T target) {
		// TODO RECURSIVAMENTE
		return false;
	}

	@Override
	public T getElemPos(int position) {
		// TODO RECURSIVAMENTE
		return null;
	}



	@Override
	public int getPosFirst(T elem) {
		// TODO RECURSIVAMENTE
		return 0;
	}



	@Override
	public int getPosLast(T elem) {
		// TODO RECURSIVAMENTE
		return 0;
	}



	@Override
	public T removelast() throws EmptyCollectionException {
		// TODO RECURSIVAMENTE
		return null;
	}



	

	@Override
	public int removeLastElem(T elem) {
		// TODO RECURSIVAMENTE
		return 0;
	}



	@Override
	public EDList<T> reverse() {
		// TODO RECURSIVAMENTE
		return null;
	}


	@Override
	public int removeConsecDuplicates() throws EmptyCollectionException {
		// TODO RECURSIVAMENTE
		return 0;
	}




	@Override
	public int removeFirstElem(T elem) throws EmptyCollectionException {
		// TODO RECURSIVAMENTE
		return 0;
	}

	@Override
	public String toString() {
		// TODO RECURSIVAMENTE
	
		return null;
	}


	@Override
	public boolean addBeforeAfter(T elemAdd, T elemSearch) {
		// TODO RECURSIVAMENTE
		return false;
	}


	@Override
	public T getLast() throws EmptyCollectionException {
		// TODO RECURSIVAMENTE
		return null;
	}


	@Override
	public int getIndexOfFirst(T elem) throws EmptyCollectionException {
		// TODO RECURSIVAMENTE
		return 0;
	}


	@Override
	public int getIndexOfLast(T elem) throws EmptyCollectionException {
		// TODO RECURSIVAMENTE
		return 0;
	}


	@Override
	public String toStringAtPosMultiple(int n) {
		// TODO RECURSIVAMENTE
		return null;
	}


	@Override
	public String toStringReverse() {
		// TODO RECURSIVAMENTE
		return null;
	}


	@Override
	public int removeDuplicConsec(T elem) throws EmptyCollectionException {
		// TODO RECURSIVAMENTE
		return 0;
	}


	

	
	
}
