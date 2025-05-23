package ule.edi.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * arbol binario de busqueda (binary search tree, BST).
 * 
 * El codigo fuente esta en UTF-8, y la constante EMPTY_TREE_MARK definida en
 * AbstractTreeADT del proyecto API deberia ser el simbolo de conjunto vacio:
 * ∅
 * 
 * Si aparecen caracteres "raros", es porque el proyecto no esta bien
 * configurado en Eclipse para usar esa codificacion de caracteres.
 *
 * En el toString() que esta ya implementado en AbstractTreeADT se usa el
 * formato:
 * 
 * Un arbol vaci­o se representa como "∅". Un Ã¡rbol no vacio como
 * "{(informacion rai­z), sub-arbol 1, sub-arbol 2, ...}".
 * 
 * Por ejemplo, {A, {B, ∅, ∅}, ∅} es un arbol binario con rai­z "A" y un
 * unico sub-arbol, a su izquierda, con rai­z "B".
 * 
 * El metodo render() tambien representa un arbol, pero con otro formato; por
 * ejemplo, un arbol {M, {E, ∅, ∅}, {S, ∅, ∅}} se muestra como:
 * 
 * M
 * | E
 * | | ∅
 * | | ∅
 * | S
 * | | ∅
 * | | ∅
 * 
 * Cualquier nodo puede llevar asociados pares (clave,valor) para adjuntar
 * informacion extra. Si es el caso, tanto toString() como render() mostraran
 * los pares asociados a cada nodo.
 * 
 * Con {@link #setTag(String, Object)} se inserta un par (clave,valor) y con
 * {@link #getTag(String)} se consulta.
 * 
 * 
 * Con <T extends Comparable<? super T>> se pide que exista un orden en los
 * elementos. Se necesita para poder comparar elementos al insertar.
 * 
 * Si se usara <T extends Comparable<T>> seria muy restrictivo; en su lugar se
 * permiten tipos que sean comparables no solo con exactamente T sino tambien
 * con tipos por encima de T en la herencia.
 * 
 * @param <T> tipo de la informacion en cada nodo, comparable.
 */
public class BinarySearchTreeImpl<T extends Comparable<? super T>> extends AbstractBinaryTreeADT<T> {

	/**
	 * arbol BST vaci­o
	 */
	public BinarySearchTreeImpl() {
		// TODO HACER QUE THIS SEA EL NODO VACIO
		this.root = null;
	}

	public int getMaxDegree() {
		return 2;
	}

	/**
	 * Indica si el árbol es hoja (todos sus hijos vacíos)
	 * 
	 * @return cierto si todos los hijos son vacíos
	 * @throws EmptyCollectionException
	 */
	public boolean isLeaf(BinaryTreeNode<T> node) {
		// TODO Implementar el metodo
		if (node == null) {
			return false;
		}
		return (node.left == null && node.right == null);
	}

	/**
	 * Inserta los elementos que no sean null, de una coleccion en el arbol.
	 * (si alguno es 'null', no lo inserta)
	 * 
	 * No se permiten elementos null.
	 * 
	 * @param elements valores a insertar.
	 * @return numero de elementos insertados en el arbol (elementos diferentes de
	 *         null)
	 */
	@SuppressWarnings("unchecked")
	public int insert(Collection<T> elements) {
		// si alguno es 'null', no se inserta
		// TODO Implementar el metodo
		if (elements == null) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < elements.size(); i++) {
			if (elements[i] != null) {
				root = insertCollectionRecursivo(root, elements);
				count++;
			}
		}
		return count;
	}

	private BinaryTreeNode<T> insertCollectionRecursivo(BinaryTreeNode<T> node, T element) {
		if (node == null) {
			return new BinaryTreeNode<>(element);
		}
		int comparacion = element.compareTo(node.elem);
		if (comparacion < 0) {
			node.left = insertCollectionRecursivo(node.left, elements);
		} else if (comparacion > 0) {
			node.right = insertCollectionRecursivo(node.right, elements);
		} else {
			node.count++;
		}
		return node;
	}

	/**
	 * Inserta los elementos que no sean null, de un array en el arbol. 
	 * (si alguno es 'null', no lo inserta), devolviendo el nº de elems insertados en nodo nuevo
	 * 
	 * No se permiten elementos null.
	 * 
	 * @param elements elementos a insertar.
	 * @return  	numero de elementos insertados en el arbol en un nodo nuevo
	 */
	public int insert(T... elements) {
		// TODO Implementar el metodo
		if(elements == null){
			return 0;
		}
		int count = 0;
		for(int i = 0; i < elements.length: i++){
			if(elements[i] != null && insertTRecursivo(elements)){
				count++;
			}
		}
		return count;

	
	}

	private boolean insertTRecursivo(T element) {
		if (root == null) {
			root = new BinaryTreeNode<>(element);
			return true;
		}

		BinaryTreeNode<T> current = root;
		BinaryTreeNode<T> parent = null;
		int comparacion = 0;

		while (current != null) {
			parent = current;
			comparacion = element.compareTo(current.elem);

			if (comparacion < 0) {
				current = current.left;
			} else if (comparacion > 0) {
				current = current.right;
			} else {
				current.count++;
				return false;
			}
		}

		BinaryTreeNode<T> nuevo = new BinaryTreeNode<>(element);
		if (comparacion < 0) {
			parent.left = nuevo;
		} else if (comparacion > 0) {
			parent.right = nuevo;
		}
		return true;
	}

	/**
	 * Inserta (como hoja) un nuevo elemento en el arbol de busqueda.
	 * 
	 * Debe asignarse valor a su atributo father (referencia a su nodo padre o null
	 * si es la rai­z)
	 * 
	 * No se permiten elementos null. Si element es null dispara
	 * excepcion:IllegalArgumentException
	 * Si el elemento ya existe en el arbol
	 * no inserta un nodo nuevo, sino que incrementa el atributo count del nodo que
	 * tiene igual contenido.
	 * 
	 * @param element valor a insertar.
	 * @return true si se insertó en un nuevo nodo (no existia ese elemento en el
	 *         arbol),
	 *         false en caso contrario
	 * @throws IllegalArgumentException si element es null
	 */
	public boolean insert(T element) {
		// TODO Implementar el metodo
		return false;
	}

	/**
	 * Busca el elemento en el arbol.
	 * 
	 * No se permiten elementos null.
	 * 
	 * @param element valor a buscar.
	 * @return true si el elemento esta en el arbol, false en caso contrario
	 * @throws IllegalArgumentException si element es null
	 *
	 */
	public boolean contains(T element) {
		// TODO Implementar el metodo
		if (element == null) {
			throw new IllegalArgumentException("El elemento no puede ser nulo");
		}
		return containsRecursivo(raiz, element);
	}

	private boolean containsRecursivo(BinaryTreeNode<T> node, T element) {
		if (node == null) {
			return false;
		}
		int comparacion = element.compareTo(node.elem);
		if (comparacion < 0) {
			return containsRecursivo(node.left, element);
		} else if (comparacion > 0) {
			return containsRecursivo(node.right, element);
		} else {
			return true;
		}
	}

	/**
	 * Devuelve un iterador que recorre los elementos (sin tener en cuenta el número
	 * de instancias)del arbol por niveles segun
	 * el recorrido en anchura
	 * 
	 * Por ejemplo, con el arbol
	 * 
	 * {50, {30(2), {10, ∅, ∅}, {40, ∅, ∅}}, {80(2), {60, ∅, ∅}, ∅}}
	 * 
	 * y devolvera el iterador que recorrera los nodos en el orden: 50, 30, 80, 10,
	 * 40, 60
	 * 
	 * 
	 * 
	 * @return iterador para el recorrido en anchura
	 */
	public Iterator<T> iteratorWidth() {
		// TODO Implementar metodo
		// puede implementarse creando una lista con el recorrido en anchura de los
		// elementos del arbol y devolver el iterador de dicha lista
		return null;
	}

	/**
	 * Devuelve un iterador que recorre los elementos (teniendo en cuenta el número
	 * de instancias)del arbol por niveles segun
	 * el recorrido en anchura
	 * 
	 * Por ejemplo, con el arbol
	 * 
	 * {50, {30(2), {10, ∅, ∅}, {40, ∅, ∅}}, {80(2), {60, ∅, ∅}, ∅}}
	 * 
	 * y devolvera el iterador que recorrera los nodos en el orden: 50, 30, 30, 80,
	 * 80, 10, 40, 60
	 * 
	 * @return iterador para el recorrido en anchura
	 */
	public Iterator<T> iteratorWidthInstances() {
		// TODO Implementar metodo
		// puede implementarse creando una lista con el recorrido en anchura de los
		// elementos del arbol (teniendo el número de instancias que tiene el elemento)
		// y devolver el iterador de dicha lista
		return null;
	}

	/**
	 * Cuenta el número de elementos diferentes del arbol (no tiene en cuenta las
	 * instancias)
	 * 
	 * Por ejemplo, con el arbol
	 * 
	 * {50, {30(2), {10, ∅, ∅}, {40(4), ∅, ∅}}, {80(2), {60, ∅, ∅}, ∅}}
	 * 
	 * la llamada a ejemplo.instancesCount() devolvera 6
	 * 
	 * @return el numero de elementos diferentes del arbol
	 */
	public int size() {
		// TODO implementar este metodo
		return sizeRec(root);
	}

	private int sizeRec(BinaryTreeNode<T> node) {
		if (node == null)
			return 0;
		else
			return 1 + sizeRec(node.left) + sizeRec(node.right);
	}

	/**
	 * Cuenta el número de instancias de elementos diferentes del arbol
	 * 
	 * Por ejemplo, con el arbol ejemplo=
	 * 
	 * {50, {30(2), {10, ∅, ∅}, {40(4), ∅, ∅}}, {80(2), {60, ∅, ∅}, ∅}}
	 * 
	 * la llamada a ejemplo.instancesCount() devolvera 11
	 * 
	 * @return el número de instancias de elementos del arbol
	 */
	public int instancesCount() {
		// TODO implementar este metodo
		return instancesCountRecursivo(root);
	}

	private int instancesCountRecursivo(BinaryTreeNode<T> node) {
		if (node == null) {
			return 0;
		}
		return node.count + instancesCountRecursivo(node.left) + instancesCountRecursivo(node.right);
	}

	/**
	 * Elimina los valores en un array del Arbol.
	 * Devuelve el número de elementos que pudo eliminar del árbol
	 * (no podrá eliminar los elemenots 'null' o que no los contiene el arbol)
	 * 
	 * return numero de elementos eliminados del arbol
	 */
	public int remove(T... elements) {
		// TODO Implementar el metodo
		int numRemoved = 0;

		for (T elem : elements) {
			// terminar de incorporar el código
		}

		return numRemoved;

	}

	/**
	 * Elimina un elemento del arbol. Si el atributo count del nodo que contiene el
	 * elemento es >1, simplemente se decrementará este valor en una unidad
	 * 
	 * Si hay que eliminar el nodo, y tiene dos hijos, se tomara el criterio de
	 * sustituir el
	 * elemento por el menor de sus mayores y eliminar el menor de los mayores.
	 * 
	 * @throws NoSuchElementException   si el elemento a eliminar no esta en el
	 *                                  arbol
	 * @throws IllegalArgumentException si element es null
	 *
	 */
	public void remove(T element) {

		// TODO Implementar el metodo
		if (element == null) {
			throw new IllegalArgumentException("El elemento no puede ser nulo");
		}
		if (!contains(element)) {
			throw new NoSuchElementException("El elemento no se encuentra en el arbol");
		}
		remove(element, 1);
	}

	/**
	 * Decrementa el número de instancias del elemento en num unidades.
	 * Si count queda en cero o negativo, se elimina el elemento del arbol.
	 * Devuelve el número de instancias que pudo eliminar
	 * 
	 * 
	 * Si hay que eliminar el nodo, y tiene dos hijos, se tomara el criterio de
	 * sustituir el
	 * elemento por el menor de sus mayores y eliminar el menor de los mayores.
	 * 
	 * @throws NoSuchElementException   si el elemento a eliminar no esta en el
	 *                                  arbol
	 * @throws IllegalArgumentException si element es null
	 * @return numero de instancias eliminadas
	 * 
	 */
	public int remove(T element, int num) {
		// TODO Implementar el metodo
		if (element == null) {
			throw new IllegalArgumentException("El elemento no puede ser nulo");
		}
		if (num <= 0) {
			throw new IllegalArgumentException("El número de instancias a eliminar no puede ser menor o igual a cero");
		}
		int[] removed = { 0 };
		root = removeRecursivo(root, element, num, removed);
		if (removed[0] == 0) {
			throw new NoSuchElementException("El elemento no se encuentra en el arbol");
		}
		return removed[0];
	}

	private BinaryTreeNode<T> removeRecursivo(BinaryTreeNode<T> node, T element, int num, int[] removed) {
		if (node == null) {
			return null;
		}
		int comparacion = element.compareTo(node.elem);
		if (comparacion < 0) {
			node.left = removeRecursivo(node, element, num, removed);
		} else if (comparacion > 0) {
			node.right = removeRecursivo(node.right, element, num, removed);
		} else {
			/* Encontrado el nodo */
			int removeCount = Math.min(node.count);
			removed[0] = removeCount;
			node.count -= removeCount;

			if (node.count <= 0) {
				if (node.left == null) {
					return node.right;
				} else if (node.right == null) {
					return node.left;
				} else {
					/* tiene dos hijos, se sustituye por el menor de los mayores */
					BinaryTreeNode<T> minNode = getMinNode(node.right);
					node.elem = minNode.elem;
					node.count = minNode.count;
					node.right = removeRecursivo(node.right, minNode.elem, minNode.count, new int[1]);
				}
			}
		}
		return node;
	}

	private BinaryTreeNode<T> getMinNode(BinaryTreeNode<T> node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	/**
	 * Elimina todas las instancias del elemento en el árbol
	 * eliminando del arbol el nodo que contiene el elemento .
	 * 
	 * 
	 * Se tomara el criterio de sustituir el elemento por el menor de sus mayores
	 * y eliminar el menor de los mayores.
	 * 
	 * @throws NoSuchElementException   si el elemento a eliminar no esta en el
	 *                                  arbol
	 * @throws IllegalArgumentException si element es null
	 */
	public int removeAll(T element) {
		// TODO Implementar el metodo
		if (elemet == null) {
			throw new IllegalArgumentException("El elemento no puede ser nulo");
		}
		int[] removed = { 0 };
		root = removeAllRecursivo(root, element, removed);
		if (removed[0] == 0) {
			throw new NoSuchElementException("El elemento no se encuentra en el arbol");
		}
		return removed[0];
	}

	private BinaryTreeNode<T> removeAllRecursivo(BinaryTreeNode<T> node, T element, int[] removed) {
		if (node == null) {
			return null;
		}
		int comparacion = element.compareTo(node.elem);
		if (comparacion < 0) {
			node.left = removeAllRecursivo(node.left, element, removed);
		} else if (comparacion > 0) {
			node.right = removeAllRecursivo(node.right, element, removed);
		} else {
			/* Encontrado */
			removed[0] = node.count;
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				/* tiene dos hijos, se sustituye por el menor de los mayores */
				BinaryTreeNode<T> minNode = getMinNode(node.right);
				node.elem = minNode.elem;
				node.count = minNode.count;
				node.right = removeAllRecursivo(node.right, minNode.elem, new int[1]);
			}
		}
		return node;
	}

	/**
	 * Devuelve el sub-árbol indicado. (para tests)
	 * path será el camino para obtener el sub-arbol. Está formado por 0 y 1.
	 * Si se codifica "bajar por la izquierda" como "0" y
	 * "bajar por la derecha" como "1", el camino desde un
	 * nodo N hasta un nodo M (en uno de sus sub-árboles) será * la cadena de 0s y
	 * 1s que indica cómo llegar desde N hasta M.
	 *
	 * Se define también el camino vacío desde un nodo N hasta
	 * él mismo, como cadena vacía.
	 * 
	 * Si el subarbol no existe lanzará la excepción NoSuchElementException.
	 * 
	 * @param path
	 * @return el nodo no vacío que se alcanza con ese camino
	 * @throws NoSuchElementException   si el camino no alcanza un nodo no vacío en
	 *                                  el árbol
	 * @throws IllegalArgumentException si el camino no contiene sólamente 0s y 1s
	 */
	public BinaryTreeNode<T> getSubtreeWithPath(String path) {
		// TODO Implementar el metodo

		return null;
	}

	/**
	 * Devuelve el contenido del nodo alcanzado desde la raíz
	 * de éste árbol, con el camino dado.
	 * 
	 * Por ejemplo, sea un árbol "A" {10, {5, ∅, ∅}, {20, ∅, {30, ∅, ∅}}}:
	 * 
	 * 10
	 * | 5
	 * | | ∅
	 * | | ∅
	 * | 20
	 * | | ∅
	 * | | 30
	 * | | | ∅
	 * | | | ∅
	 * 
	 * Entonces se tiene que A.getContentWithPath("1") es 20 y
	 * que A.getContentWithPath("") es 10.
	 * 
	 * @param path camino a seguir desde la raíz.
	 * @return contenido del nodo alcanzado.
	 * @throws NoSuchElementException   si el camino no alcanza un nodo no vacío en
	 *                                  el árbol
	 * @throws IllegalArgumentException si el camino no contiene sólamente 0s y 1s
	 */
	public T getContentWithPath(String path) {
		// TODO implementar el método
		return null;
	}

	/**
	 * Etiqueta solamente los nodos que son hijos izquierdos
	 * de su padre con el valor de su posición en postorden,
	 * devolviendo el número de nodos que son hijos izquierdos.
	 *
	 * Por ejemplo, sea un árbol "A":
	 * 
	 * {10, {5, {2, ∅, ∅}, ∅}, {20, ∅, {30, ∅, ∅}}}
	 * 
	 * 10
	 * | 5
	 * | | 2
	 * | | | ∅
	 * | | | ∅
	 * | | ∅
	 * | 20
	 * | | ∅
	 * | | 30
	 * | | | ∅
	 * | | | ∅
	 * 
	 * devolverá 2
	 * y el árbol quedaría etiquetado como:
	 * Solo etiqueta el 5 y el 2, porque son los únicos nodos
	 * que son hijos izquierdos
	 * {10,
	 * {5 [(postorder, 2)] , {2 [(postorder, 1)], ∅, ∅}, ∅},
	 * {20, ∅, {30, ∅, ∅}}}
	 * 
	 * @return numero de nodos hijos izquierdos
	 */
	public int tagLeftChildrenPostorder() {
		// TODO el método

		return 0;
	}

	/**
	 * Devuelve el toString del nodo simétrico al (this)
	 * o la cadena vacía si no tiene nodo simétrico
	 *
	 ** Por ejemplo, sea un árbol "A":
	 * 
	 * {10, {5, {2, ∅, ∅}, ∅}, {20, ∅, {30, ∅, ∅}}}
	 * la llamada a a.toStringSimetric() devolverá "",
	 * porque al ser la raiz no tiene simétrico
	 * 
	 * la llamada a a.getSubtreeWithPath("0").toStringSimetric() devolverá ,
	 * "{20, ∅, {30, ∅, ∅}}"
	 * la llamada a a.getSubtreeWithPath("00").toStringSimetric() devolverá ,
	 * "{30, ∅, ∅}"
	 * 
	 * @return la cadena vacía si no tiene nodo simétrico o el toString del nodo
	 *         simétrico.
	 * 
	 */
	public String toStringSimetric(String path) {
		// TODO el método
		return "";
	}

	/**
	 * Elimina el nodo que contiene el elemento menor del árbol.
	 * Este método busca el nodo con el menor valor en el árbol, lo elimina y
	 * regresa la cantidad total de instancias que tenía el nodo (count).
	 * Si el nodo mínimo tiene un hijo derecho, este hijo asciende para
	 * reemplazarlo.
	 * Si no hay hijos, simplemente se elimina el nodo.
	 * 
	 * Si el árbol está vacío devuelve 0.
	 * 
	 * Para el árbol {30, {10, {5, ∅, {6, ∅, ∅}}, {20, {15, ∅, ∅}, ∅}},∅},
	 * se eliminaría el 5, y el árbol quedaría:
	 * {30, {10, {6, ∅, ∅}, {20, {15, ∅, ∅}, ∅}},∅}
	 * 
	 * @return int La cantidad de instancias del nodo con el mínimo valor
	 */
	public int removeAllMin() {
		// TODO EL MÉTOD
		if(root == null){
			return 0;
		}
		int removed[] = { 0 };
		root = removeMinRec(root, removed);
		return removed[0];
	}

	private BinaryTreeNode<T> removeAllMinRec(BinaryTreeNode<T> node, int[] removed){
		if(node.left == null){
			/* nodo minimo */
			removed[0] = node.count;
			return node.right;
		}
		node.left = removeAllMinRec(node.left, removed);
		return node;
	}

	/**
	 * Importante: Solamente se puede recorrer el arbol una vez
	 * 
	 * Etiqueta cada nodo con la etiqueta "height" y el valor correspondiente a la
	 * altura del nodo.
	 * 
	 * Por ejemplo, sea un arbol "A":
	 * 
	 * {10, {5, {2, ∅, ∅}, ∅}, {20, {15, ∅, ∅}, {30, ∅, ∅}}}
	 * 
	 * 
	 * el arbol quedara etiquetado:
	 * 
	 * {10 [(height, 1)],
	 * {5 [(height, 2)], {2 [(height, 3)],∅, ∅}, ∅},
	 * {20[(height, 2)], {15 [(height, 3)], {12 [(height, 4)], ∅, ∅}, ∅}, ∅}}
	 * 
	 */
	public void tagHeight() {
		// TODO implementar el metodo
	}

	/**
	 * Importante: Solamente se puede recorrer el arbol una vez
	 * 
	 * Etiqueta cada nodo hoja con la etiqueta "height" y el valor correspondiente a
	 * la
	 * altura del nodo.
	 * 
	 * Por ejemplo, sea un arbol "A":
	 * 
	 * {10, {5, {2, ∅, ∅}, ∅}, {20, {15, ∅, ∅}, {30, ∅, ∅}}}
	 * 
	 * el arbol quedara etiquetado:
	 * 
	 * {10,
	 * {5, {2 [(height, 3)],∅, ∅}, ∅},
	 * {20,{15, {12 [(height, 4)], ∅, ∅}, ∅}, ∅}
	 * }
	 * 
	 */
	public void tagHeightLeaf() {
		// TODO implementar el mÃ©todo

	}

	/**
	 * Importante: Solamente se puede recorrer el arbol una vez
	 * 
	 * Etiqueta cada nodo que tiene 2 hijos con la etiqueta "2Hijos" y el valor
	 * correspondiente a su
	 * posicion en inorden.
	 * 
	 * Por ejemplo, sea un arbol "A":
	 * 
	 * {10, {5, {2, ∅, ∅}, ∅}, {20, {15, ∅, ∅}, {30, ∅, ∅}}}
	 * 
	 * el arbol quedara etiquetado:
	 * 
	 * {10 [(2hijos, 3)],
	 * {5, {2 ,∅, ∅}, ∅},
	 * {20 [(2hijos, 5)],{15, {12, ∅, ∅}, ∅}, ∅}
	 * }
	 * 
	 */
	public int tagNodos2HijosInorden() {
		// TODO EL MÉTODO
		return 0;
	}

	/**
	 * Importante: Solamente se puede recorrer el arbol una vez
	 * 
	 * Etiqueta todos los nodos del árbol con la etiqueta "preorden"
	 * y el valor correspondiente a su posicion en preorden.
	 * 
	 * 
	 * Por ejemplo, sea un arbol "A":
	 * 
	 * {10, {5, {2, ∅, ∅}, ∅}, {20, {15, ∅, ∅}, {30, ∅, ∅}}}
	 * 
	 * el arbol quedara etiquetado:
	 * 
	 * {10 [(preorden, 1)],
	 * {5 [(preorden, 2)], {2 [(preorden, 3)],∅, ∅}, ∅},
	 * {20 [(preorden, 4)],{15 [(preorden, 5)], {12 [(preorden, 6)], ∅, ∅}, ∅}, ∅}
	 * }
	 * 
	 */
	public void tagPosPreorden() {
		// TODO EL MÉTODO
		return;
	}

	/**
	 * Importante: Solamente se puede recorrer el arbol una vez
	 * 
	 * Devuelve el elemento que está en la posición n en postorden
	 * 
	 * Por ejemplo, sea un arbol "A":
	 * 
	 * {10, {5, {2, ∅, ∅}, ∅}, {20, {15, ∅, ∅}, {30, ∅, ∅}}}
	 * 
	 * la llamada con n=4, devolverá 30
	 * 
	 */
	public T postordenN(int n) {
		// TODO EL MÉTODO
		return null;
	}

}
