package ule.ed.recursivelist;

import java.util.NoSuchElementException;

public class LinkedEDList<T> implements EDList<T> {

	// referencia al primer de la lista
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
		return sizeRecursivo(front);
	}

	public int sizeRecursivo(Node<T> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + sizeRecursivo(node.next);
		}
	}

	@Override
	public void addLast(T elem) {
		// TODO RECURSIVAMENTE
		if (elem == null) {
			throw new NullPointerException();
		}
		if (isEmpty()) {
			front = new Node<>(elem);
		} else {
			addLastRecursivo(front, elem);
		}

	}

	public void addLastRecursivo(Node<T> node, T elem) {
		if (node.next == null) {
			Node<T> nuevo = new Node<>(elem);
			node.next = nuevo;
		} else {
			addLastRecursivo(node.next, elem);
		}
	}

	@Override
	public void addPos(T elem, int position) {
		// TODO RECURSIVAMENTE
		if (elem == null) {
			throw new NullPointerException();
		}
		if (position <= 0) {
			throw new IllegalArgumentException();
		} else {
			addPosRecursivo(front, elem, position);
		}
	}

	public void addPosRecursivo(Node node, T elem, int position) {
		if (node == null) {
			throw new IllegalArgumentException();
		} else if (position == 1) {
			Node<T> nuevo = new Node<>(elem);
			nuevo.next = node.next;
			node.next = nuevo;
		} else {
			addPosRecursivo(node.next, elem, position - 1);
		}
	}

	@Override
	public boolean addBefore(T elem, T target) {
		// TODO RECURSIVAMENTE
		if(elem == null || target == null){
			throw new NullPointerException();
		}else{
			return addBeforeRecursivo(front, null, elem, target);
		}
		
	}

	

	private boolean addBeforeRecursivo(Node<T> node, Node<T> prev, T elem, T target) {
		if(node == null){
			Node<T> nuevo = new Node<>(elem);
			if(prev == null){
				front = nuevo;
			}else{
				nuevo.next = front;
				front = nuevo;
			}
			return false;
		}
		if(node.elem.equals(target)){
			Node<T> nuevo = new Node<>(elem);
			nuevo.next = node;

			if(prev == null){
				front = nuevo;
			}else{
				prev.next = nuevo;
			}
			return true;
		}

		return addBeforeRecursivo(node.next, node, elem, target);
		
	}

	@Override
	public T getElemPos(int position) {
		// TODO RECURSIVAMENTE
		if(position < 1 || position > size()){
			throw new IllegalArgumentException();
		}
		return getElemPosRecursivo(front, position);
		
	}

	private T getElemPosRecursivo(Node<T> node, int position) {
		// TODO Auto-generated method stub
		if(position == 1){
			return node.elem;
		}
		return getElemPosRecursivo(node.next, position - 1);
	}

	@Override
	public int getPosFirst(T elem) {
		// TODO RECURSIVAMENTE
		if(elem == null){
			throw new NullPointerException();
		}

		return getPosFirstRecursivo(front, elem, 1);
	}

	private int getPosFirstRecursivo(Node<T> node, T elem, int pos) {
		// TODO Auto-generated method stub
		if(node == null){
			throw new NoSuchElementException();
		}
		if(node.elem.equals(elem)){
			return pos;
		}

		return getPosFirstRecursivo(node.next, elem, pos + 1);
	}	

	@Override
	public int getPosLast(T elem) {
		// TODO RECURSIVAMENTE
		if(elem == null){
			throw new NullPointerException();
		}
		int posLast =  getPosLastRecursivo(front, elem, 1);
		if(posLast == -1){
			throw new NoSuchElementException();
		}

		return posLast;
	}

	private int getPosLastRecursivo(Node<T> node, T elem, int currentPos) {
		// TODO Auto-generated method stub
		if(node == null){
			return -1;
		}
		
		int pos = getPosLastRecursivo(node.next, elem, currentPos + 1);

		if(pos != -1){
			return pos;
		}

		if(node.elem.equals(elem)){
			return currentPos;
		}

		return -1;
	}

	@Override
	public T removelast() throws EmptyCollectionException {
		// TODO RECURSIVAMENTE
		if(isEmpty()){
			throw new EmptyCollectionException("");
		}

		return removeLastRecursivo(front);
	}

	private T removeLastRecursivo(Node<T> node) {
		// TODO Auto-generated method stub
		if(node.next.next == null){
			T elem = node.next.elem;
			node.next = null;
			return elem;
		}
		return removeLastRecursivo(node.next);
	}

	@Override
	public int removeLastElem(T elem) throws EmptyCollectionException {
		// TODO RECURSIVAMENTE
		if(isEmpty()){
			throw new EmptyCollectionException("");
		}
		int[] lastPos = {0};
		front = removeLastElemRecursive(front, elem, 1, lastPos);
		return lastPos[0];
	}

	private Node<T> removeLastElemRecursive(Node<T> node, T elem, int pos, int[] lastPos) {
		// TODO Auto-generated method stub
		if(node == null){
			return null;
		}

		node.next = removeLastElemRecursive(node.next, elem, pos + 1, lastPos);

		if(node.elem.equals(elem) && lastPos[0] == 0){
			lastPos[0] = pos;
			return node.next;
		}

		return node;
	}

	@Override
	public EDList<T> reverse() {
		// TODO RECURSIVAMENTE
		LinkedEDList<T> list = new LinkedEDList<>();
		list.front = reverseRecursivo(this.front, null);
		return list;
	}

	private LinkedEDList<T>.Node<T> reverseRecursivo(Node<T> node, Node<T> aux) {
		// TODO Auto-generated method stub
		if(node == null){
			return aux;
		}

		Node<T> nuevo = new Node<>(node.elem);
		nuevo.next = aux;
		return reverseRecursivo(node.next, nuevo);
	}

	@Override
	public int removeConsecDuplicates() throws EmptyCollectionException {
		// TODO RECURSIVAMENTE
		if(isEmpty()){
			throw new EmptyCollectionException("");
		}
		return removeConsecDuplicatesRecursivo(front);
	}

	private int removeConsecDuplicatesRecursivo(Node<T> node) {
		// TODO Auto-generated method stub
		if(node == null || node.next == null){
			return 0;
		}

		if(node.elem.equals(node.next.elem)){
			node.next = node.next.next;
			return 1 + removeConsecDuplicatesRecursivo(node);
		}else{
			removeConsecDuplicatesRecursivo(node.next);
		}
	}

	@Override
	public int removeFirstElem(T elem) throws EmptyCollectionException {
		// TODO RECURSIVAMENTE
		if(isEmpty()){
			throw new EmptyCollectionException("");
		}
		int[] removedPos = {0};
		front = removeFirstElemRecursivo(front, elem, 1, removedPos);
		return removedPos[0];
	}

	private Node<T> removeFirstElemRecursivo(Node<T> node, T elem, int pos,
			int[] removedPos) {
		// TODO Auto-generated method stub
			if(node == null){
				return null;
			}

			if(node.elem.equals(elem) && removedPos[0] == 0){
				removedPos[0] = pos;
				return node.next;
			}

			node.next = removeFirstElemRecursivo(node.next, elem, pos + 1, removedPos);
			return node;
	}

	@Override
	public String toString() {
		// TODO RECURSIVAMENTE

		return null;
	}

	@Override
	public boolean addBeforeAfter(T elemAdd, T elemSearch) {
		// TODO RECURSIVAMENTE
		if(elemAdd == null || elemSearch == null){
			throw new NullPointerException();
		}
		return addBeforeAfterRecursivo(front, null, elemAdd, elemSearch);
	}

	private boolean addBeforeAfterRecursivo(Node<T> node, Node<T> prev, T elemAdd, T elemSearch) {
		// TODO Auto-generated method stub
		if(node == null){
			Node<T> nuevo = new Node<>(elemAdd);
			if(prev == null){
				front = nuevo;
			}else{
				nuevo.next = front;
				front = nuevo;
			}
			return false;
		}

		if(node.elem.equals(elemSearch)){
			Node<T> nuevoBefore = new Node<>(elemAdd);
			nuevoBefore.next = node;

			if(prev == null){
				front = nuevoBefore;
			}else{
				prev.next = nuevoBefore;
			}

			Node<T> nuevoAfter = new Node<>(elemAdd);
			nuevoAfter.next = node.next;
			node.next = nuevoAfter;

			return true;
		}

		return addBeforeAfterRecursivo(node.next, node, elemAdd, elemSearch);
	}

	@Override
	public T getLast() throws EmptyCollectionException {
		// TODO RECURSIVAMENTE
		if (isEmpty()) {
			throw new EmptyCollectionException("");
		} else {
			return getLastRecursivo(front);
		}
	}

	public T getLastRecursivo(Node<T> node) {
		if (node.next == null) {
			return node.elem;
		} else {
			return getLastRecursivo(node.next);
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
