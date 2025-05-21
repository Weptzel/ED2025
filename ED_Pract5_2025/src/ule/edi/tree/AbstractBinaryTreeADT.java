package ule.edi.tree;

/**
 * arbol binario.
 * 

 * 
 * @author profesor
 *
 * @param <T>
 */
public abstract class AbstractBinaryTreeADT<T>  {
	
	//	Como arbol binario, tiene dos sub-arboles binarios
	//	"izquierdo" y "derecho"
	//
	//	Podrian ser vacios
	
	public static final String NULL_MARK ="∅";
	public BinaryTreeNode<T> root;
	
	
	/**
	 *  devuelve el grado del nodo,
	 *  si tiene 0, 1 o 2 hijos distintos de null
	 *  
	 *  
	 * @return nº de hijos distintos de null 
	 */
	
	public int getDegree(BinaryTreeNode<T> node) {
		if (node==null)
			return 0;
		else if (node.left!=null && node.right!=null)
			return 2;
		else if(node.left!=null || node.right!=null)
			return 1;
		else return 0;
	}
	
	public boolean isEmpty() {
		return root==null;
	}
	
	/**
	 *  devuelve la cadena formada por el contenido del árbol teniendo en cuenta que 
	 *  si un nodo tiene su atributo count>1 pone entre paréntesis su valor justo detrás del atributo elem
	 *  También debe mostrar las etiquetas que tenga el nodo (si las tiene)
	 * 
	 * Por ejemplo: {M, {E(2), ∅, ∅}, {K(5), ∅, ∅}}
	 * 
	 * @return cadena con el contenido del árbol incluyendo su atributo count entre paréntesis si elemento tiene más de 1 instancia
	 */
	
	@Override
	public String toString() {
		 if (root==null)
			 return NULL_MARK;
		 else
			return root.toString();
	}
	
}