package ule.ed.list;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.*;

public class ArrayEDListTest {
	private ArrayEDList<String> lista;

	@Before
	public void test() {
		lista = new ArrayEDList<String>();

	}

	@Test
	public void testVacia() {
		assertEquals(0, lista.size());
	}

	@Test
	public void testAddFirst() {
		lista.addFirst("2");
		Assert.assertFalse(lista.isEmpty());
		Assert.assertEquals("(2 )", lista.toString());
		lista.addFirst("3");
		Assert.assertEquals("(3 2 )", lista.toString());
		lista.addFirst("7");
		Assert.assertEquals("(7 3 2 )", lista.toString());
	}

	@Test(expected = EmptyCollectionException.class)
	public void testRemoveFirst_Vacia() throws EmptyCollectionException {
		lista.removeFirst();
	}

	@Test(expected = NullPointerException.class)
	public void test_addFirst_ElementoNulo() {
		lista.addFirst(null);
	}

	@Test
	public void test_addLast() {
		lista.addLast("5");
		Assert.assertFalse(lista.isEmpty());
		Assert.assertEquals("(5 )", lista.toString());
		lista.addLast("3");
		Assert.assertEquals("(5 3 )", lista.toString());
	}

	@Test(expected = NullPointerException.class)
	public void test_addLastNull() {
		lista.addLast(null);
	}

	@Test
	public void test_addPenult() {
		lista.addPenult("5");
		Assert.assertFalse(lista.isEmpty());
		Assert.assertEquals("(5 )", lista.toString());
		lista.addPenult("3");
		Assert.assertEquals("(3 5 )", lista.toString());
		lista.addPenult("7");
		Assert.assertEquals("(3 7 5 )", lista.toString());
	}

	/*
	 * @Test
	 * public void test_addPos() {
	 * lista.addPos("5", 0);
	 * Assert.assertFalse(lista.isEmpty());
	 * Assert.assertEquals("(5 )", lista.toString());
	 * lista.addPos("3", 1);
	 * Assert.assertEquals("(5 3 )", lista.toString());
	 * 
	 * }
	 */

	@Test(expected = IllegalArgumentException.class)

	public void test_addPos() {

		lista.addPos("5", 0);

		// con posición 0 dispara la excepción

	}

	@Test
	public void test_addPos2() {

		lista.addPos("5", 1);

		Assert.assertFalse(lista.isEmpty());

		Assert.assertEquals("(5 )", lista.toString());

		lista.addPos("3", 1);

		Assert.assertEquals("(3 5 )", lista.toString());

	}

	@Test
	public void test_removeFirst() throws EmptyCollectionException {
		lista.addFirst("5");
		lista.addFirst("6");
		Assert.assertEquals("(6 5 )", lista.toString());
		lista.removeFirst();
		Assert.assertEquals("(5 )", lista.toString());

	}

	@Test
	public void test_removeLast() throws EmptyCollectionException {
		lista.addFirst("5");
		lista.addFirst("6");
		Assert.assertEquals("(6 5 )", lista.toString());
		lista.removelast();
		Assert.assertEquals("(6 )", lista.toString());
	}

	@Test
	public void test_removePenult() throws EmptyCollectionException {
		lista.addFirst("5");
		lista.addFirst("6");
		lista.addFirst("9");
		Assert.assertEquals("(9 6 5 )", lista.toString());
		lista.removePenult();
		Assert.assertEquals("(9 5 )", lista.toString());
	}

	@Test
	public void test_removeElem() throws EmptyCollectionException {
		lista.addFirst("5");
		lista.addFirst("6");
		Assert.assertEquals("(6 5 )", lista.toString());
		lista.removeElem("5");
		Assert.assertEquals("(6 )", lista.toString());
	}

	@Test
	public void test_iterator() {
		lista.addFirst("5");
		lista.addFirst("6");
		lista.addFirst("7");
		Iterator<String> it = lista.iterator();
		Assert.assertEquals("7", it.next());
	}

	@Test
	public void test_iteratorEven() {
		lista.addFirst("5");
		lista.addFirst("6");
		lista.addFirst("7");
		Iterator<String> it = lista.evenPositionsIterator();
		Assert.assertEquals("6", it.next());
	}

	@Test
	public void test_reverse() {
		lista.addFirst("5");
		lista.addFirst("6");
		lista.addFirst("7");
		ArrayEDList<String> rev = (ArrayEDList<String>) lista.reverse();
		Assert.assertEquals("(5 6 7 )", rev.toString());

	}

	@Test(expected = IllegalArgumentException.class)
	public void test_getElemPosIllegal() {
		lista.addFirst("5");
		lista.addFirst("6");
		lista.addFirst("7");
		Assert.assertEquals("6", lista.getElemPos(7));

	}

	@Test(expected = IllegalArgumentException.class)
	public void test_getElemPosIllegal2() {
		lista.addFirst("5");
		lista.addFirst("6");
		lista.addFirst("7");
		Assert.assertEquals("6", lista.getElemPos(-5));

	}

	@Test
	public void test_clear() {
		lista.addLast("5");
		lista.addLast("6");
		lista.addLast("7");
		lista.clear();
		Assert.assertEquals("[]", lista.toString());
	}

	@Test
	public void test_size() {
		lista.addLast("5");
		lista.addLast("6");
		lista.addLast("7");
		Assert.assertEquals(3, lista.size());
	}

	/* propios */
	
	

	@Test
	public void testRemoveLastElem() throws EmptyCollectionException {
		lista.addFirst("A");
		lista.addFirst("B");
		lista.addFirst("C");
		lista.addFirst("B");
		lista.addFirst("D");
		Assert.assertEquals("(D B C B A )", lista.toString());
		int position = lista.removeLastElem("B");
		Assert.assertEquals(4, position);
		Assert.assertEquals("(D B C A )", lista.toString());
	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveLastElemNotFound() throws EmptyCollectionException {
		lista.addFirst("A");
		lista.addFirst("B");
		lista.addFirst("C");
		lista.removeLastElem("D");
	}

	@Test(expected = NoSuchElementException.class)
	public void testRemoveLastElemNoSuchElement() throws EmptyCollectionException {
		lista.addFirst("5");
		lista.addFirst("6");
		Assert.assertEquals("(6 5 )", lista.toString());
		lista.removeLastElem("7");
		Assert.assertEquals("(6 5 )", lista.toString());
	}

	@Test
	public void testGetPosFirstElementExists() {
		ArrayEDList<String> lista = new ArrayEDList<>();
		lista.addLast("A");
		lista.addLast("B");
		lista.addLast("C");
		lista.addLast("B");
		Assert.assertEquals(2, lista.getPosFirst("B")); // La primera aparición de "B" está en la posición 2
	}

	@Test(expected = NoSuchElementException.class)
	public void testGetPosFirstElementNotFound() {
		// Caso 3: El elemento no existe en la lista
		ArrayEDList<String> lista = new ArrayEDList<>();
		lista.addLast("A");
		lista.addLast("B");
		lista.addLast("C");
		lista.getPosFirst("D"); // "D" no está en la lista, debe lanzar NoSuchElementException
	}

	@Test
	public void testGetPosLastElementExists() {
		ArrayEDList<String> lista = new ArrayEDList<>();
		lista.addLast("A");
		lista.addLast("B");
		lista.addLast("C");
		lista.addLast("B");
		lista.addLast("D");
		lista.addLast("A");
		Assert.assertEquals(6, lista.getPosLast("A"));
		Assert.assertEquals(4, lista.getPosLast("B"));
	}

	@Test(expected = NoSuchElementException.class)
	public void testGetPosLastElementNotFound() {
		ArrayEDList<String> lista = new ArrayEDList<>();
		lista.addLast("A");
		lista.addLast("B");
		lista.addLast("C");
		lista.getPosLast("Z");
	}

	@Test(expected = NullPointerException.class)
	public void testGetPosLastNullElement() {
		ArrayEDList<String> lista = new ArrayEDList<>();
		lista.addLast("A");
		lista.addLast("B");
		lista.getPosLast(null);
	}

	@Test
	public void testAddPenultInMiddle(){
		lista.addFirst("2");
		lista.addFirst("4");
		lista.addFirst("7");
		lista.addPenult("1");
		lista.addFirst("3");
		Assert.assertEquals("(3 7 4 1 2 )", lista.toString());

	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetElemPos(){
		lista.addFirst("2");
		lista.addFirst("4");
		lista.addFirst("7");
		lista.getElemPos(2);
		Assert.assertEquals("4", lista.getElemPos(2));
	}
}
