package ule.ed.list;
import java.util.Iterator;

public interface EDList<T> {
	/**
	 * TAD 'EDList'
	 * 
	 * Almacena una colección de objetos de tipo <code>T</code>, permitiendo
	 * elementos repetidos.
	 * 
	 * Ejemplo: (A B C A B D )
	 *
	 * 
	 * Excepciones
	 * 
	 * No se permiten elementos <code>null</code>. Si a cualquier método que recibe
	 * un elemento se le pasa el valor <code>null</code>, lanzará una excepción
	 * {@link NullPointerException}.
	 * 
	 * Los valores de parámetros <code>position</code> deben ser mayores que cero y
	 * nunca negativos. Si se recibe un valor negativo o cero se lanzará
	 * {@link IllegalArgumentException}.
	 * 
	 * 
	 * Constructores
	 * 
	 * Se definirá un constructor por defecto que inicialice la instancia como lista
	 * vacía.
	 * 
	 * 
	 * Método {@link Object#toString()}
	 * 
	 * El formato será mostrar el toString de los elementos separados por espacios
	 * (A B C D D D B ) el toString
	 *
	 * 
	 * @author profesor
	 *
	 * @param <T> tipo de elementos en la lista
	 */

	/**
	 * Devuelve el número total de elementos en esta lista. <br>
	 * 
	 * Ejemplo:<br>
	 * Si una lista l contiene (A B C B D A B ): <br>
	 * l.size() -> 7
	 * 
	 * @return número total de elementos en esta lista
	 */
	public int size();

	/**
	 * Indica si esta lista está vacía
	 * 
	 * @return <code>true</code> si no contiene elementos
	 */
	public boolean isEmpty();

	/**
	 * Elimina todo el contenido de esta lista.
	 * 
	 * Deja la lista vacía
	 * 
	 */
	public void clear();

	/**
	 * Añade un elemento como primer elemento de la lista.
	 * <p>
	 * Si una lista l contiene (A B C ) y hacemos l.addFirst("C") la lista quedará
	 * (C A B C )
	 * 
	 * @param elem el elemento a añadir
	 * 
	 * @throws NullPointerException si elem es <code>null</code>
	 */
	public void addFirst(T elem);

	/**
	 * Añade un elemento como último elemento de la lista
	 * <p>
	 * Si una lista l contiene (A B C ) y hacemos l.addLast("C") la lista quedará (A
	 * B C C )
	 * 
	 * @param elem el elemento a añadir
	 * 
	 * @throws NullPointerException si elem es <code>null</code>
	 */
	public void addLast(T elem);

	/**
	 * Añade un elemento como penúltimo elemento de la lista
	 * <p>
	 * Si una lista l contiene (A B C ) y hacemos l.addPenult("D") la lista quedará
	 * (A B D C )
	 * 
	 * Si la lista está vacía lo inserta normal
	 * 
	 * @param elem el elemento a añadir
	 * 
	 * @throws NullPointerException si elem es <code>null</code>
	 */
	public void addPenult(T elem);

	/**
	 * Añade un elemento en la posición pasada como parámetro desplazando los
	 * elementos que estén a partir de esa posición.
	 * <p>
	 * Si una lista l contiene (A B C ) y hacemos l.addPos("Z", 2) la lista quedará
	 * (A Z B C ).
	 * <p>
	 * Si position>size() se insertará como último elemento.
	 * 
	 * @param elem     el elemento a añadir
	 * @param position la posición en la que añadirá el elemento
	 * 
	 * @throws NullPointerException     si elem es <code>null</code>
	 * @throws IllegalArgumentException si position <= 0
	 * 
	 */
	public void addPos(T elem, int position);

	/**
	 * Elimina y devuelve el primer elemento de la lista.
	 * <p>
	 * Si una lista l contiene (A B C ) y hacemos l.removeFirst() la lista quedará
	 * (B C ) y devolverá A
	 * 
	 * @throws EmptyCollectionException si la lista es vacía
	 * 
	 */
	public T removeFirst() throws EmptyCollectionException;

	/**
	 * Elimina y devuelve el último elemento de la lista.
	 * <p>
	 * Si una lista l contiene (A B C ) y hacemos l.removeLast() la lista quedará (A
	 * B ) y devolverá C
	 * 
	 * @throws EmptyCollectionException si la lista es vacía
	 * 
	 */
	public T removelast() throws EmptyCollectionException;;

	/**
	 * Elimina y devuelve el penúltimo elemento de la lista.
	 * <p>
	 * Si una lista l contiene (A B C ) y hacemos l.removePenult() la lista quedará
	 * (A C ) y devolverá B
	 * 
	 * @throws EmptyCollectionException si la lista es vacía
	 * @throws NoSuchElementException   si la lista solo tiene un elemento
	 * 
	 */
	public T removePenult() throws EmptyCollectionException;;

	/**
	 * Elimina la primera aparición del elemento y lo devuelve.
	 * <p>
	 * Si una lista l contiene (A B C B ) y hacemos l.removeElem("B") la lista
	 * quedará (A C B ) y devolverá B
	 * 
	 * @param elem el elemento a eliminar
	 * 
	 * @throws EmptyCollectionException si la lista es vacía
	 * @throws NoSuchElementException   si la lista no contiene el elemento
	 * 
	 */
	public T removeElem(T elem) throws EmptyCollectionException;;
	
	/**
	 * Elimina la última aparición del elemento y devuelve la posición en la que estaba.
	 * <p>
	 * Si una lista l contiene (A B C B ) y hacemos l.removeLastElem("B") la lista
	 * quedará (A B C ) y devolverá 4
	 * 
	 * @param elem el elemento a eliminar
	 * 
	 * @throws EmptyCollectionException si la lista es vacía
	 * @throws NoSuchElementException   si la lista no contiene el elemento
	 * 
	 */
	public int removeLastElem(T elem) throws EmptyCollectionException;;

	/**
	 * Devuelve el elemento que está en position.
	 * <p>
	 * Si una lista l contiene (A B C D E ): <br>
	 * l.getElemPos(1) -> A <br>
	 * l.getElemPos(3) -> C <br>
	 * l.getElemPos(10) -> IllegalArgumentException
	 * 
	 * 
	 * @param position posición a comprobar para devolver el elemento
	 * 
	 * @throws IllegalArgumentException si position no está entre 1 y size()
	 * 
	 */
	public T getElemPos(int position);

	/**
	 * Devuelve la posición de la primera aparición del elemento.
	 * <p>
	 * Si una lista l contiene (A B C B D A ): <br>
	 * l.getPosFirst("A") -> 1 <br>
	 * l.getPosFirst("B") -> 2 <br>
	 * l.getPosFirst("Z") -> NoSuchElementException
	 * 
	 * @param elem elemento a encontrar.
	 *
	 * @throws NullPointerException   si elem es <code>null</code>
	 * @throws NoSuchElementException si elem no está en la lista.
	 * 
	 */
	public int getPosFirst(T elem);

	/**
	 * Devuelve la posición de la última aparición del elemento.
	 * <p>
	 * Si una lista l contiene (A B C B D A ): <br>
	 * l.getPosLast("A") -> 6 <br>
	 * l.getPosLast("B") -> 4 <br>
	 * l.getPosLast("Z") -> NoSuchElementException
	 * 
	 * @param elem elemento a encontrar.
	 * 
	 * @throws NullPointerException   si elem es <code>null</code>
	 * @throws NoSuchElementException si elem no está en la lista.
	 * 
	 */
	public int getPosLast(T elem);

	/**
	 * Intenta eliminar n apariciones del elemento y devuelve el número de instancias
	 * eliminadas.
	 * <p>
	 * Si una lista l contiene (A B C B A A B ): <br>
	 * l.removeN("A",2) -> 2, dejando la lista (B C B A B ): <br>
	 * l.removeAll("B",4) -> 3, dejando la lista (C A ): <br>
	 * l.removeAll("Z") -> NoSuchElementException
	 * 
	 * @param elem elemento a eliminar.
	 * 
	 * @throws NullPointerException   si elem es <code>null</code>
	 * @throws NoSuchElementException si elem no está en la lista.
	 * 
	 */
	public int removeN(T elem, int n);

	/**
	 * Crea una nueva lista inversa de esta lista. <br>
	 * Si esta lista es vacía devuelve la lista vacía. <br>
	 * 
	 * Ejemplo:<br>
	 * Si una lista l contiene (A B C ): <br>
	 * l.reverse().toString() -> (C B A )
	 * 
	 * @return lista inversa de esta lista
	 */
	public EDList<T> reverse();

	/**
	 * Devuelve el elemento más frecuente en la lista. 
	 * Si hay varios elementos con la misma frecuencia, devuelve el 1º que aparezca
	 * 
	 * Ejemplo: Si una lista l contiene (A B A B A B C ): <br>
	 * l.mostFrequent() devolverá A
	* @return el elemento con más apariciones en la lista.
	 * 
	 * @throws EmptyCollectionException si la lista está vacía.
	 */
	public T mostFrequent();
	
	/**
	 * Devuelve el elemento menos frecuente en la lista.
	 * Si hay varios elementos con la misma frecuencia, devuelve el 1º que aparezca
	 * 
	 * Ejemplo: Si una lista l contiene (A D A B A B C ): <br>
	 * l.mostFrequent() devolverá D
	 * 
	 * @return el elemento con menos apariciones en la lista.
	 * 
	 * @throws EmptyCollectionException si la lista está vacía.
	 */
	public T leastFrequent();
	
	/**
	 * Devuelve un iterador que recorre la lista desde el primero hasta el último
	 * elemento. <br>
	 *
	 * Por ejemplo, para una lista x con elementos (A B C D E)
	 *
	 * el iterador creado con x.iterator() devuelve en sucesivas llamadas a next():
	 * A, B, C, D y E.
	 *
	 * @return iterador .
	 */
	public Iterator<T> iterator();

	/**
	 * Devuelve un iterador que recorre los elementos con posición par de la lista.
	 * <br>
	 *
	 * Por ejemplo, para una lista x con elementos (A B C D E )
	 *
	 * el iterador creado con x.evenPositionsIterator() devuelve en sucesivas
	 * llamadas a next(): B y D.
	 *
	 * @return iterador para recorrer elementos en posiciones pares.
	 */
	public Iterator<T> evenPositionsIterator();

	/**
	 * Devuelve un iterador que recorre los elementos con posición impar de la
	 * lista. <br>
	 *
	 * Por ejemplo, para una lista x con elementos (A B C D E )
	 *
	 * el iterador creado con x.oddPositionsIterator() devuelve en sucesivas llamadas
	 * a next(): A, C y E.
	 *
	 * @return iterador para recorrer elementos en posiciones impares.
	 */
	public Iterator<T> oddPositionsIterator();

	/**
	 * Devuelve un iterador que devuelve n veces cada elemento de la lista
	 * 
	 * Por ejemplo, para una lista x con elementos (1 2 3 )
	 * 
	 * el iterador creado con x.repeatNiterator(3) devuelve en sucesivas llamadas a
	 * next(): 1, 1, 1, 2, 2, 2, 3, 3 y 3.
	 *
	 * @return iterador para recorrer los elementos de la lista 
     *        tratando n veces cada elemento).
	
	 */
	public Iterator<T> repeatNiterator(int n);
}
