package ule.ed.doubleList;


import java.util.ArrayList;
import java.util.Iterator;


public interface IDoubleList<T> extends Iterable<T>{
	/**
	 * TAD 'DoubleList'
	 * 
	 * Almacena una colección no ordenada de objetos de tipo <code>T</code>, sin permitir elementos repetidos. Almacena para cada elemento, el elemento y el número de unidades que hay de ese elemento. 
	 * 
	 * Ejemplo: [A(3) B(2) C(1) ]
	 *
	 * 
	 * Excepciones
	 * 
	 * No se permiten elementos <code>null</code>. Si a cualquier método que recibe un elemento se le pasa el 
	 * valor <code>null</code>, lanzará una excepción {@link NullPointerException}.
	 * 
	 * Los valores de parámetros <code>position</code> deben ser distintos de 0.
	 *     Si se recibe un valor cero se lanzará {@link IllegalArgumentException}.
	 *     Si se recibe un valor negativo se empezará a recorrer la lista por el final. 
	 * 
	 * Los valores de parámetros num, deben ser >0 sino disparará IllegalArgumentException
	 * Constructores
	 * 
	 * Se definirá un constructor por defecto que inicialice la instancia
	 * como lista vacía.
	 * 
	 *  
	 * Método {@link Object#toString()}
	 * 
	 * El formato será mostrar el toString de los elementos seguido de la multiplicidad del elemento entre paréntesis, separados por espacios entre corchetes
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
	 * Elimina todo el contenido de esta lista.
	 * <p>
	 * Deja la lista vacía
	 * 
	 */
	public void clear();

	/**
	 * Añade un elemento al principio de la lista si el elemento no está en la lista.
	 * Si está en la lista, incrementa el número de unidades del elemento
	 * <p>
	 * Si una lista l contiene [A(3) B(2) D(1) ] y hacemos:
	 *    l.addFirst("D",2) -> [A(3) B(2) D(3) ]
	 *    l.addFirst("C",2) -> [C(2) A(3) B(2) D(3) ]
	 * 
	 * @param elem el elemento a añadir
	 * @param n  numero de instancias del elemento a añadir
	 * 
	 * @throws NullPointerException si elem es <code>null</code>
	 * @throws IllegalArgumentException si n es cero o negativo 
	 */
	public void addFirst(T elem, int n);

	/**
	 * Añade un elemento al final de la lista si el elemento no está en la lista.
	 * Si está en la lista, incrementa el número de unidades del elemento
	 * <p>
	 * Si una lista l contiene [A(3) B(2) D(1) ] y hacemos:
	 *    l.addLast("D",2) -> [A(3) B(2) D(3) ]
	 *    l.addLast("C",2) -> [A(3) B(2) D(3) C(2) ]
	 * 
	 * @param elem el elemento a añadir
	 * @param n  numero de instancias del elemento a añadir
	 * 
	 * @throws NullPointerException si elem es <code>null</code>
	 * @throws IllegalArgumentException si n es cero o negativo 
	 */
	public void addLast(T elem,int n);

	/**
	 * Elimina num instancias del primer elemento de la lista y devuelve el número de instancias eliminadas.
	 * <p>
	 * Si una lista l contiene [A(3) B(2) D(1) ] y hacemos:
	 *     l.removeFirst(1)  -> la lista quedará [A(2) B(2) D(1) ] y devolverá 1
	 *
	 * Si una lista l contiene [A(1) B(2) D(1) ] y hacemos:
	 *     l.removeFirst(2)  -> la lista quedará [B(2) D(1) ] y devolverá 1
	 *
	 * @param num número de instancias a eliminar del elemento. Si num es mayor que el número de instancias del elemento, elimina las que haya.
	 *
	 * @throws EmptyCollectionException si la lista es vacía 
	 * 
	 */
	public int removeFirst(int num) throws EmptyCollectionException;

	/**
	 * Elimina todas las instancias del primer elemento de la lista y devuelve el elemento eliminado.
	 * <p>
	 * Si una lista l contiene [A(3) B(2) D(1) ] y hacemos:
	 *     l.removeAllFirst()  -> la lista quedará [B(2) D(1) ] y devolverá A
	 *
	 * Si una lista l contiene [A(1) B(2) D(1) ] y hacemos:
	 *     l.removeAllFirst()  -> la lista quedará [B(2) D(1) ] y devolverá A
	 * 
	 * @throws EmptyCollectionException si la lista es vacía 
	 * 
	 */
	public T removeAllFirst() throws EmptyCollectionException;

	/**
	 * Elimina num instancias del último elemento de la lista y devuelve el número de instancias eliminadas.
	 * <p>
	 * Si una lista l contiene [A(3) B(2) D(1) ] y hacemos:
	 *     l.removeLast(3)  -> la lista quedará [A(3) B(2) ] y devolverá 1
	 *
	 * Si una lista l contiene [A(1) B(2) D(3) ] y hacemos:
	 *     l.removeLast(2)  -> la lista quedará [A(1) B(2) D(1) ] y devolverá 2
	 *
	 * @param num número de instancias a eliminar del elemento. Si num es mayor que el número de instancias del elemento, elimina las que haya.
	 *
	 * @throws EmptyCollectionException si la lista es vacía 
	 * 
	 */
	public int removeLast(int num) throws EmptyCollectionException;

	

	
	/**
	 * Elimina num instancias del elemento que está en position y devuelve el elemento.
	 * Si position es negativa
	 * <p>
	 * Si una lista l contiene [A(3) B(2) D(2) ] y hacemos:
	 *     l.removePos(3,1)  -> la lista quedará [A(3) B(2) D(1)] y devolverá D
	 *     l.removePos(-3,1)  -> la lista quedará [A(2) B(2) D(2)] y devolverá A
	 *     l.removePos(10,1) -> IllegalArgumentException
	 *    
	 * 
	 * @param position posición a comprobar para devolver el elemento.
	 * @param num numero de instancias a eliminar del elemento. Si num es mayor que el número de instancias del elemento, elimina las que haya.
	 * 
	 * @throws IllegalArgumentException si position no está entre 1 y size().
	 * @throws EmptyCollectionException si la lista está vacía.
	 * 
	 */
	public T removePos(int pos, int num) throws EmptyCollectionException;;

	
	/**
	 * Elimina num instancias del elemento y devuelve el número de instancias eliminadas.
	 * <p>
	 * Si una lista l contiene [A(3) B(2) D(1) ]: <br>
	 * l.remove("A",1) -> 1, dejando la lista[A(2) B(2) D(1) ] <br>
	 * l.remove("B",3) -> 2, dejando la lista [A(2) D(1) ] <br>
	 * l.remove("Z",1) -> NoSuchElementException 
	 * 
	 * @param elem elemento a eliminar.
	 * @param num número de instancias a eliminar del elemento. Si num es mayor que el número de instancias del elemento, elimina las que haya.
	 * @return el número de instancias realmente eliminadas
	 * 
	 * @throws NullPointerException si elem es <code>null</code>
	 * @throws NoSuchElementException si elem no está en la lista.
	 * @throws EmptyCollectionException si la lista está vacía.
	 * 
	 * 
	 */
	public int remove(T elem, int num) throws EmptyCollectionException;;


	/**
	 * Devuelve el elemento que está en position. 
	 * Si position es negativa empieza por el final.
	 * <p>
	 * Si una lista l contiene [A(3) B(2) D(1) ]: <br>
	 * l.getElemPos(1) -> A <br>
	 * l.getElemPos(3) -> D <br>
	 * l.getElemPos(-3) -> A <br>
	 * l.getElemPos(10) -> IllegalArgumentException
	 * 
	 * 
	 * @param position posición a comprobar para devolver el elemento.
	 * 
	 * @throws IllegalArgumentException si position no está entre 1 y size() 
	 * 
	 */
	public T getElemPos(int position);

	
	/**
	 * Indica si el elemento está en esta lista. <br>
	 * 
	 * Devuelve <code>true</code> si al menos existe una
	 * instancia del elemento dado en esta lista (es decir,
	 * un elemento 'x' tal que <code>x.equals(element)</code>)
	 * y <code>false</code> en caso contrario.
	 * 
	 * @param elem elemento a buscar en esta lista
	 * @return <code>true</code>/<code>false</code> según el resultado
	 * 
	 * @throws NullPointerException el elemento indicado es <code>null</code>
	 */
	public boolean contains(T elem);

	/**
	 * Devuelve el número total de elementos en esta lista. <br>
	 * 
	 * Ejemplo:<br>
	 * Si una lista l contiene [A(3) B(2) D(1) ]: <br>
	 *  l.size() -> 3
	 *   
	 * @return número total de elementos en esta lista
	 */
	public int size();

	/**
	 * Devuelve el número total de instancias elementos en esta lista. <br>
	 * 
	 * Ejemplo:<br>
	 * Si una lista l contiene [A(3) B(2) D(1) ]: <br>
	 *  l.countInstances() -> 6
	 *   
	 * @return número total de instancias de elementos en esta lista
	 */
	public int countInstances();

	/**
	 * Crea y devuelve un String con el contenido de la lista empezando por el final hasta el principio.
	 * 
	 * <br> Si esta lista es vacía devuelve el toString() de la lista vacía ->[]  
	 * 
	 * <br> Ejemplo:<br>
	 * Si una lista l contiene [A(4) B(2) C(1) ] : <br>
	 *  l.toStringReverse() -> [C(1) B(2) A(4) ] 
	 * @return recorrido inverso de la lista (desde el final al principio)
	 */
	public String toStringReverse();


	/**
	 * Devuelve un ArrayList del JDK con los elementos que más se repiten. <br>
	 * Ejemplo:<br>
	 * Si una lista l contiene [A(4) B(2) C(4) ]: <br>
	 *  l.listMaxRepeated() ->[A, C]    // lista con los elementos que más se repiten
	 * @return lista con los elementos que más se repiten 
	 */
	public ArrayList<T> listMaxRepeated();

	/**
	 * Devuelve un iterador que recorre la lista en orden normal. <br>
	 *
	 * Por ejemplo, para una lista x con elementos [A(4) B(2) C(4) ]
	 *
	 * el iterador creado con x.iterator() devuelve en sucesivas llamadas a next(): A, B y C.
	 *
	 * @return iterador para orden normal.
	 */
	public Iterator<T> iterator();


	/**
	 * Devuelve un iterador que recorre la lista en orden inverso. <br>
	 *
	 * Por ejemplo, para una lista x con elementos [A(4) B(2) C(4) ]
	 *
	 * el iterador creado con x.reverseIterator() devuelve en sucesivas llamadas a next(): C, B y A.
	 *
	 * @return iterador para orden inverso.
	 */
	public Iterator<T> reverseIterator();


	/**
	 * Devuelve un iterador que recorre la lista en orden normal. <br>
	 *
	 * Por ejemplo, para una lista x con elementos [A(4) B(2) C(1) ]
	 *
	 * el iterador creado con x.iteratorInstance() devuelve en sucesivas llamadas a next(): A, A, A, A, B, B y C.
	 *
	 * @return iterador para orden normal.
	 */
	public Iterator<T> iteratorInstance();


	/**
	 * Devuelve un iterador que recorre la lista en orden inverso. <br>
	 *
	 * Por ejemplo, para una lista x con elementos [A(4) B(2) C(1) ]
	 *
	 * el iterador creado con x.reverseIteratorInstance() devuelve en sucesivas llamadas a next(): C, B, B, A, A, A y A.
	 *
	 * @return iterador para orden inverso.
	 */
	public Iterator<T> reverseIteratorInstance();

}
