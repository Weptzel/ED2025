package ule.ed.recursivelist;


public interface EDList<T> {
	/**
	 * TAD 'EDList'
	 * 
	 * Almacena una colección de objetos de tipo T, permitiendo
	 * elementos repetidos.
	 * 
	 * Ejemplo: (A B C A B D )
	 *
	 * 
	 * Excepciones
	 * 
	 * No se permiten elementos null. Si a cualquier método que recibe
	 * un elemento se le pasa el valor null, lanzará una excepción
	 * NullPointerException.
	 * 
	 * Los valores de parámetros position deben ser mayores que cero y
	 * nunca negativos. Si se recibe un valor negativo o cero se lanzará
	 * IllegalArgumentException.
	 * 
	 * 
	 * Constructores
	 * 
	 * Se definirá un constructor por defecto que inicialice la instancia como lista
	 * vacía.
	 * 
	 * 
	 * Método  Object#toString()
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
	 * Indica si esta lista está vacía
	 * 
	 * @return <code>true</code> si no contiene elementos
	 */
	public boolean isEmpty();

	/**
	 * TODO RECURSIVO: Devuelve el número total de elementos en esta lista. <br>
	 * 
	 * Ejemplo:<br>
	 * Si una lista l contiene (A B C B D A B ): <br>
	 * l.size() -> 7
	 * 
	 * @return número total de elementos en esta lista
	 */
	public int size();

	
	/**
	 * TODO RECURSIVO: Añade un elemento como último elemento de la lista
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
	 * TODO RECURSIVO: Añade un elemento en la posición pasada como parámetro desplazando los
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
	 * TODO RECURSIVO: Añade un elemento (elemAdd) pasado como primer parámetro delante del
	 *  elemento pasado como segundo parámetro (elemSearch)  
	 * <p>
	 * Si una lista l contiene (A B C ) y hacemos l.addBefore("Z", "B") la lista quedará
	 * (A Z B C ).
	 * <p>
	 * Si elemSearch no existe, se insertará como primer elemento.
	 * 
	 * @param elemAdd     el elemento a añadir
	 * @param elemSearch  el elemento buscado
     * @return true : si elemSearch estaba en la lista; false: en caso contrario
	 * @throws NullPointerException     si elemAdd o elemSearch es <code>null</code>
	 * 
	 */
	public boolean addBefore(T elemAdd, T elemSearch);

	/**
	 * TODO RECURSIVO: Añade un elemento (elemAdd) pasado como primer parámetro delantey detrás de la
	 *  primera aparición del elemento pasado como segundo parámetro (elemSearch)  
	 * <p>
	 * Si una lista l contiene (A B C ) y hacemos l.addBeforeAfter("Z", "B") la lista quedará
	 * (A Z B Z C ).
	 * <p>
	 * Si elemSearch no existe, se insertará como primer elemento.
	 * Si una lista l contiene (A B C ) y hacemos l.addBeforeAfter("Z", "K") la lista quedará
	 * (Z A B C ).
	 * 
	 * @param elemAdd     el elemento a añadir
	 * @param elemSearch  el elemento buscado
	 * @return true : si elemSearch estaba en la lista; false: en caso contrario
	 * 
	 * @throws NullPointerException     si elemAdd o elemSearch es <code>null</code>
	 * 
	 */
	public boolean addBeforeAfter(T elemAdd, T elemSearch);
		
	
	/**
	 * RECURSIVO
	 * 
	 * Devuelve el último elemento de la lista.
	 * <p>
	 * Si una lista l contiene (A B C D E ): <br>
	 * l.getLast -> E <br>
	 * 
	 * @return elem : último elemento de la lista
	 * 
     * @throws EmptyCollectionException si la lista es vacía 	
	 */
	public T getLast() throws EmptyCollectionException;
	
	/**
	 * Devuelve la posición donde está la primera aparición del elemento.
	 * <p>
	 * Si una lista l contiene (A B C D E C ): <br>
	 * l.getIndexOfFirst("C") -> 3 <br>
	 * 
	 * @param elem elemento a buscar en esta lista
	 * @return la posición en la que está la primera aparición del elemento
	 *  
	 * @throws NullPointerException   si elem es <code>null</code>
     * @throws EmptyCollectionException si la lista es vacía 
     * @throws NoSuchElementException si elem no estaba en la lista  
	 */
	public int getIndexOfFirst(T elem) throws EmptyCollectionException;
	
	/**
	 * Devuelve la posición donde está la primera aparición del elemento.
	 * <p>
	 * Si una lista l contiene (A B C D E C ): <br>
	 * l.getIndexOfLast("C") -> 6 <br>
	 * 
	 * @param elem elemento a buscar en esta lista
	 * @return la posición en la que está la ultima aparición del elemento
	 * 
	 * @throws NullPointerException   si elem es <code>null</code>
     * @throws EmptyCollectionException si la lista es vacía 	
	 * @throws NoSuchElementException si elem no estaba en la lista 
     */
	public int getIndexOfLast(T elem) throws EmptyCollectionException;
	
	
	/**
	 * TODO RECURSIVO: Devuelve el elemento que está en position.
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
	 * TODO RECURSIVO: Devuelve la posición de la primera aparición del elemento.
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
	 * TODO RECURSIVO: Devuelve la posición de la última aparición del elemento.
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
	 * TODO RECURSIVO:  Elimina y devuelve el último elemento de la lista.
	 * <p>
	 * Si una lista l contiene (A B C ) y hacemos l.removeLast() la lista quedará (A
	 * B ) y devolverá C
	 * 
	 * @throws EmptyCollectionException si la lista es vacía
	 * 
	 */
	public T removelast() throws EmptyCollectionException;


	
	
	/**
	 * TODO RECURSIVO: Crea una nueva lista inversa de esta lista. <br>
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
	 * RECURSIVO
	 * 
	 * Crea y devuelve un String con el contenido de la lista desde el principio al final.
	 * 
	 * <br> Si esta lista es vacía devuelve el toString() de la lista vacía -> () <br>
	 * 
	 * <br> Ejemplo:<br>
	 * Si una lista l contiene (A B C ): <br>
	 *  l.toString() -> (A B C ) 
	 * @return recorrido  de la lista
	 */
	public String toString();
			

	/**
	 * RECURSIVO
	 * 
	 * Crea y devuelve un String con el contenido de la lista empezando por el final hasta el principio.
	 * 
	 * <br> Si esta lista es vacía devuelve el toString() de la lista vacía -> (). <br>
	 * 
	 * <br> Ejemplo:<br>
	 * Si una lista l contiene (A B C ): <br>
	 *  l.toStringReverse() -> (C B A ) 
	 * @return recorrido inverso de la lista (desde el final al principio)
	 */
	public String toStringReverse();

	
	
	/**
	 * RECURSIVO
	 *
	 * Devuelve una cadena con todos los elementos cuya posición sea múltiplo del n pasado como parámetro. 
	 *  
	 * <br> Ejemplos:<br>
	 * l1=(A B C D E ) ; l1.toStringAtPosMultiple(1)  -> (A B C D E ) <br>
	 * l1=(A B C D E F ) ; l1.toStringAtPosMultiple(2)  -> (B D F ) <br>
	 * l1=(A B C D E ) ;l1.toStringAtPosMultiple(3) -> (C ) <br>
	 * l1=(A B C D E ) ;l1.toStringAtPosMultiple(84) -> () <br>
	 * 
	 * 
	 * @param n numero, cuya posición debe ser múltiplo de n para que se incluya en la cadena
	 *  
	 * @return String formado por el toString de los elementos que están en posiciones múltiples de n.
	 *
	 *@throws IllegalArgumentException si n <=0 
	 *
	 */
	// Devuelve una cadena con todos los elementos cuyo índice sea múltiplo de un número dado.
	public String toStringAtPosMultiple(int n);
	
	/**
	 * TODO RECURSIVO:   Elimina duplicados consecutivos sobre la propia lista.
	 * 
	 * Ejemplo: si lista=[A A B B A A A B] >> lista.removeConsecDuplicates() devuelve 4
	 *     y deja la lista=[A B A B]
	 * Si la lista es vacía devuelve 0
	 * 
	 * @return número de elementos eliminados.
	 *
	 * @throws EmptyCollectionException si la lista está vacía.
	 *
	 */
	public int removeConsecDuplicates() throws EmptyCollectionException;;
	
		
	/**
	 * RECURSIVO 
	 * 
	 * Elimina todos los duplicados consecutivos de cada aparición del elemento
	 *  pasado como parámetro y devuelve el nº de apariciones eliminadas.
	 * <p>
	 * Si una lista l contiene (A B B C B B D A B ): <br>
	 * l.removeDuplicConsec("B") -> 2 , dejando la lista (A B C B D A B ) <br>
	 * 
	 *  Si una lista l contiene (B B B C B B B B ): <br> 
	 * l.removeDuplicConsec("B") -> 5, dejando la lista (B C B ) <br>
 	 * l.removeDuplicConsec("Z") -> NoSuchElementException 
 	 * 
     * @param elem:  elemento a eliminar.
     * 
     * @return el número de elementos que elimina
     * 
	 * @throws EmptyCollectionException si la lista está vacía.
	 * 
	 */
	public int removeDuplicConsec(T elem) throws EmptyCollectionException;

	
	/**
	 * TODO RECURSIVO: Elimina la primera aparición del elemento y devuelve la posición en la que estaba.
	 * <p>
	 * Si una lista l contiene (A B C B ) y hacemos l.removeFirstElem("B") la lista
	 * quedará (A C B ) y devolverá 2
	 * 
	 * Si la lista no contiene el elemento devolverá 0
	 * 
	 * @param elem el elemento a eliminar
	 * @return pos del elemento eliminado
	 * 
	 *  
	 * @throws EmptyCollectionException si la lista está vacía.
	 *
	 */
	public int removeFirstElem(T elem) throws EmptyCollectionException;;

	/**
     *
	 * TODO RECURSIVO: Elimina la última aparición del elemento y devuelve la posición en la que estaba.
     * Si l contiene (A B C B ) y hacemos l.removeLastElem("B") la lista
	 * quedará (A C B ) y devolverá 4
	 * Si la lista no contiene el elemento devolverá 0
	 *
	 * 
	 * @param elem el elemento a eliminar
	 * @return pos del elemento eliminado
	 * 
     * @throws EmptyCollectionException si la lista está vacía.
	 *
	 */
	public int removeLastElem(T elem) throws EmptyCollectionException;;

	
	

	
}

