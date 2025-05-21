package ule.edi.tree;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Implementación del nodo de un árbol binario.
 * 
 * 
 * @author profesor
 *
 * @param <T> tipo de la información almacenada en cada nodo.
 */
	
//	El código fuente está en UTF-8, debería ser el símbolo de
//	conjunto vacío. Si aparecen caracteres "raros", es porque
//	el proyecto no está bien configurado en Eclipse para
//	usar esa codificación de caracteres. 
//
    
	public class BinaryTreeNode<T> {

		protected BinaryTreeNode<T> left;
		protected BinaryTreeNode<T> right;
	
		protected T elem;//	Información en el nodo raíz
		
		public BinaryTreeNode<T> father; // referencia a su nodo padre)
		int count;  // contador de instancias 

	
		protected Map<String, Object> tags = new HashMap<>();
		
		//constructor del nodo del árbol
		public BinaryTreeNode(T element) {
			elem=element;
			count=1;
		}

		public BinaryTreeNode<T> getLeft() {
			return left;
		}
		
		
		public BinaryTreeNode<T> getRight() {
			return right;
		}

		/**
		 * Devuelve el mapa de etiquetas para este nodo.
		 * 
		 * @return
		 */
		public Map<String, Object> getTags() {
			return tags;
		}
		
		/**
		 * Asigna un par (clave,valor) como etiqueta a este nodo.
		 * 
		 * @param key
		 * @param value
		 */
		public void setTag(String k, Object v) {
			tags.put(k, v);
		}
		
		/**
		 * Consulta un valor para la clave dada en este nodo, null si no existe.
		 * 
		 * @param key
		 * @return
		 */
		public Object getTag(String k) {
			return tags.get(k);
		}
		
		/**
		 * Elimina todas las etiquetas cuya clave no se corresponda con las dadas en keep, 
		 * en el árbol completo.
		 * 
		 * @param keep
		 */
		public void filterTags(String ... keep) {
				
			if (! tags.isEmpty()) {
				HashMap<String, Object> rx = new HashMap<>();
				for (int i = 0; i < keep.length; i++) {
					if (tags.containsKey(keep[i])) {
						rx.put(keep[i], tags.get(keep[i]));
					}
				}
				this.tags = rx;
			}
			
			 left.filterTags(keep);
			 right.filterTags(keep);
		}
		
		public String toString() {
				//	Construye el resultado de forma eficiente
				StringBuffer result = new StringBuffer();
					
				//	Raíz
				result.append("{" + this.elem.toString());
	
				// si el atributo count del nodo es >1 se añade entre paréntesis el número de instancias, 
				// detras del contenido del nodo 
				if (this.count>1)
					result.append("(" + this.count+")");
				    //
					// si tiene etiquetas se añaden entre corchetes
				if (! this.tags.isEmpty()) {
					result.append(" [");
					
					List<String> sk = new LinkedList<String>(this.tags.keySet());
					
					Collections.sort(sk);
					for (String k : sk) {
						result.append("(" + k + ", " + this.tags.get(k) + "), ");
					}
					result.delete(result.length() - 2, result.length());
					result.append("]");
				}
				
				//	Y cada sub-árbol			
					if (this.left==null)
						result.append(", ∅");
					else result.append(", " + this.left.toString());
					
					if (this.right==null)
						result.append(", ∅");
						
					else result.append(", " + this.right.toString());
					
					
				
				//	Cierra la "}" de este árbol
				result.append("}");
				
				return result.toString();
			
		}
	}


