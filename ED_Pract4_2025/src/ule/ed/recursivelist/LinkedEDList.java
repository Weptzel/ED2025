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
		return front != null;
	}


	@Override
	public int size() {
		// TODO RECURSIVAMENTE
		return sizeRecursivo(front)
	}

	public int sizeRecursivo(Node node){ 
		if(node == null){
			return 0;
		}else{
			return 1 + sizeRecursivo(node.next)
		}
	}


	@Override
	public void addLast(T elem) {
		// TODO RECURSIVAMENTE
		if(elem == null){
			throw new NullPointerException();
		}
		if(isEmpty()){
			front = new Node<>(elem)
		}else{
			return addLastRecursivo(front, elem)
		}
		
	}

	public void addLastRecursivo(Node node, T elem){
		if(node.next == null){
			Node nuevo = new Node<>(elem)
			node.next = nuevo;
		}else{
			return addLastRecursivo(node.next, elem)
		}
	}

	
	@Override
	public void addPos(T elem, int position) {
		// TODO RECURSIVAMENTE
		if(elem == null){
			throw new NullPointerException();
		}
		if(position <= 0){
			throw new IllegalArgumentException();
		}else{
			return addPosRecursivo(front, elem, position);
		}
	}

	public void addPosRecursivo(Node node, T elem, int position){
		if(node == null){
			throw new IllegalArgumenException();
		}
		else if(position == 1){
			Node nuevo = new Node<>(elem)
			nuevo.next = front.next;
			front.next = nuevo;
		}else{
			return addPosRecursivo(node.next, elem, position - 1);
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
		if(isEmpty()){
			return new EmptyCollectionException()
				}else{
			return getLastRecursivo(front)
				}
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
