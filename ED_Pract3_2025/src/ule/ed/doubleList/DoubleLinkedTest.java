package ule.ed.doubleList;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.*;

public class DoubleLinkedTest {
	DoubleLinkedListImpl<String> lv;
	DoubleLinkedListImpl<String> listaConElems;
	
	@Before
	public void antesDe() {
		lv=new DoubleLinkedListImpl<String>();
		listaConElems=new DoubleLinkedListImpl<String>("A", "B", "C", "A", "B", "A");
	}

	@Test
	public void isEmptyTest() {
		Assert.assertTrue(lv.isEmpty());
		Assert.assertTrue(lv.size()==0);
		Assert.assertFalse(listaConElems.isEmpty());
	}

	@Test
	public void clearTest() {
		lv.clear();
		Assert.assertTrue(lv.isEmpty());
		Assert.assertTrue(lv.size()==0);

		listaConElems.clear();
		Assert.assertTrue(listaConElems.isEmpty());
		Assert.assertTrue(listaConElems.size()==0);
		Assert.assertEquals(listaConElems.toString(),listaConElems.toStringReverse());
	}

	@Test
	public void sizeTest() {
		Assert.assertTrue(lv.size()==0);
		Assert.assertTrue(listaConElems.size()==3);
	}

	@Test
	public void countInstancesTest() {
		Assert.assertTrue(lv.countInstances()==0);
		Assert.assertTrue(listaConElems.countInstances()==6);
	}

	@Test
	public void listTest() {
		ArrayList<String> cadena=listaConElems.listMaxRepeated();
		Assert.assertEquals("[A]", cadena.toString());
	}

	@Test(expected=IllegalArgumentException.class)
	public void IllegalArgumentException_removeAllPos_MayorSizeTest() throws EmptyCollectionException {
		listaConElems.removePos(10,2);
	}
	
	@Test
	public void testConstructorConElems() {
		listaConElems=new DoubleLinkedListImpl<String>("B", "A", "C", "A", "B", "A");
		Assert.assertEquals("[B(2) A(3) C(1) ]", listaConElems.toString());
	}
	
	@Test
	public void testAddFirstElemAndCount() {
		lv.addFirst("B", 3);
		lv.addFirst("A", 1);
		lv.addFirst("B", 1);
		lv.addFirst("C", 2);
		Assert.assertEquals("[C(2) A(1) B(4) ]", lv.toString());
		Assert.assertTrue(lv.size()==3);
	}
	
	@Test
	public void testRemoveFirst() throws EmptyCollectionException{
		Assert.assertEquals(2, listaConElems.removeFirst(2));
		Assert.assertEquals("[A(1) B(2) C(1) ]", listaConElems.toString());
		Assert.assertTrue(listaConElems.size()==3);
	}
	@Test
	public void testRemoveFirst2() throws EmptyCollectionException{
		Assert.assertEquals(3, listaConElems.removeFirst(4));
		Assert.assertEquals("[B(2) C(1) ]", listaConElems.toString());
		Assert.assertTrue(listaConElems.size()==2);
	}
	
	
	@Test (expected=EmptyCollectionException.class)
	public void testRemoveFirstEmptyList() throws EmptyCollectionException{
		lv.removeFirst(3);
	}
	
	@Test
	public void testRemoveAllFirst() throws EmptyCollectionException{
		Assert.assertEquals("A", listaConElems.removeAllFirst());
		Assert.assertEquals("[B(2) C(1) ]", listaConElems.toString());
		Assert.assertTrue(listaConElems.size()==2);
	}
	
	@Test (expected=EmptyCollectionException.class)
	public void testRemoveAllFirstEmptyList() throws EmptyCollectionException{
		lv.removeAllFirst();
	}
	
	@Test
	public void testRemoveLastAll() throws EmptyCollectionException{
		Assert.assertEquals(1, listaConElems.removeLast(1));
		Assert.assertEquals("[A(3) B(2) ]",listaConElems.toString());
		Assert.assertTrue(listaConElems.size()==2);	
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRemoveLastInstance() throws EmptyCollectionException{
		Assert.assertEquals("C", listaConElems.removeLast(0));
		Assert.assertEquals("[A(3) B(2) C(1) ]", listaConElems.toString());
	}
	
	@Test (expected=EmptyCollectionException.class)
	public void testRemoveLastEmptyList() throws EmptyCollectionException{
		lv.removeLast(3);
	}
	

	@Test
	public void testRemovePosFirst_NegativaPos() throws EmptyCollectionException{
		Assert.assertEquals("C", listaConElems.removePos(-1, 1));
		Assert.assertEquals("[A(3) B(2) ]",listaConElems.toString());
		Assert.assertTrue(listaConElems.size()==2);
	}
	
	@Test
	public void testRemoveAllPosLast() throws EmptyCollectionException{
		Assert.assertEquals("C", listaConElems.removePos(3,1));
		Assert.assertEquals("[A(3) B(2) ]",listaConElems.toString());
		Assert.assertTrue(listaConElems.size()==2);
	}
	
	
	
	@Test
	public void testRemoveAllPos3() throws EmptyCollectionException{
		lv.addLast("B", 3);
		lv.addLast("A", 1);
		lv.addLast("B", 1);
		lv.addLast("C", 2);
		lv.addLast("D", 1);
		Assert.assertEquals("[B(4) A(1) C(2) D(1) ]", lv.toString());
		Assert.assertTrue(lv.size()==4);
		Assert.assertEquals("C", lv.removePos(3,2));
		Assert.assertEquals("[B(4) A(1) D(1) ]",lv.toString());
		Assert.assertTrue(lv.size()==3);
	}
		
	@Test
	public void testRemovePosFirst() throws EmptyCollectionException{
		Assert.assertEquals("A", listaConElems.removePos(1, 3));
		Assert.assertEquals("[B(2) C(1) ]", listaConElems.toString());
		Assert.assertTrue(listaConElems.size()==2);
	}
	
	@Test
	public void testRemovePosFirst2() throws EmptyCollectionException{
		Assert.assertEquals("A", listaConElems.removePos(1, 4));
		Assert.assertEquals("[B(2) C(1) ]", listaConElems.toString());
		Assert.assertTrue(listaConElems.size()==2);
	}
	
	@Test
	public void testRemovePosFirstInstance() throws EmptyCollectionException{
		Assert.assertEquals("A", listaConElems.removePos(1, 2));
		Assert.assertEquals("[A(1) B(2) C(1) ]", listaConElems.toString());
		Assert.assertTrue(listaConElems.size()==3);
	}
	
	
	@Test
	public void testRemovePosLastAll2() throws EmptyCollectionException{
		Assert.assertEquals("C", listaConElems.removePos(3, 2));
		Assert.assertEquals("[A(3) B(2) ]",listaConElems.toString());
		Assert.assertTrue(listaConElems.size()==2);
	}
	
	@Test
	public void testRemovePosLastInstance() throws EmptyCollectionException{
		Assert.assertEquals("C", listaConElems.removePos(3, 0));
		Assert.assertEquals("[A(3) B(2) C(1) ]", listaConElems.toString());
		Assert.assertTrue(listaConElems.size()==3);
	}
	
	@Test (expected=EmptyCollectionException.class)
	public void testRemovePosEmptyList() throws EmptyCollectionException{
		lv.removePos(3, 1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testRemovePosHigherSize() throws IllegalArgumentException, EmptyCollectionException{
		listaConElems.removePos(4, 1);
	}
	
	@Test
	public void testRemovePos2() throws EmptyCollectionException{
		Assert.assertEquals("B", listaConElems.removePos(2, 2));
		Assert.assertEquals("[A(3) C(1) ]",listaConElems.toString());
		Assert.assertTrue(listaConElems.size()==2);
	}
	
	
	@Test
	public void testContains() {
		Assert.assertTrue(listaConElems.contains("A"));
	}
	
	@Test
	public void testContains2() {
		Assert.assertTrue(listaConElems.contains("C"));
	}
	
	@Test
	public void testNotContains() {
		Assert.assertFalse(listaConElems.contains("D"));
	}
	
	@Test (expected=NullPointerException.class)
	public void testContainsNull() {
		listaConElems.contains(null);
	}
	
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetElemPosLess1() throws IllegalArgumentException, EmptyCollectionException{
		listaConElems.getElemPos(0);
	}
	
	@Test 
	public void testGetElemPos() throws IllegalArgumentException, EmptyCollectionException{
		Assert.assertEquals("A",listaConElems.getElemPos(1));
	}
	
	@Test
	public void testToStringReverse() {
		Assert.assertEquals("[A(3) B(2) C(1) ]",listaConElems.toString());
		Assert.assertEquals("[C(1) B(2) A(3) ]",listaConElems.toStringReverse());
	}
	
@Test (expected=EmptyCollectionException.class)
	public void testRemoveEmptyList() throws EmptyCollectionException{
		lv.remove("B", 2);
	}
	
	@Test (expected=NullPointerException.class)
	public void testRemoveElemNull() throws EmptyCollectionException{
		listaConElems.remove(null, 1);
	}
	
	@Test (expected=NoSuchElementException.class)
	public void testRemoveNoElem() throws NoSuchElementException, EmptyCollectionException{
		listaConElems.remove("S", 2);
	}
	
	@Test
	public void testRemove1() throws EmptyCollectionException{
		Assert.assertEquals(3, listaConElems.remove("A", 3));
		Assert.assertEquals("[B(2) C(1) ]",listaConElems.toString());
		Assert.assertTrue(listaConElems.size()==2);
	}
	
	@Test
	public void testRemoveFirst2Instances() throws EmptyCollectionException{
		Assert.assertEquals(2, listaConElems.remove("A", 2));
		Assert.assertEquals("[A(1) B(2) C(1) ]",listaConElems.toString());
		Assert.assertTrue(listaConElems.size()==3);
	}
	
	
	
	@Test
	public void listTest2() {
		listaConElems.addLast("B",1);
		Assert.assertEquals("[A(3) B(3) C(1) ]",listaConElems.toString());
		ArrayList<String> cadena=listaConElems.listMaxRepeated();
		Assert.assertEquals("[A, B]", cadena.toString());
	}
	
	@Test (expected=NoSuchElementException.class)
	public void testIteratorHasntNext() throws NoSuchElementException{
		Iterator<String> iter= lv.iterator();
		iter.next();
	}

	@Test
	public void testIteratorHasntNext2() {
		Iterator<String> iter= lv.iterator();
		Assert.assertFalse(iter.hasNext());
	}

	@Test
	public void testIteratorHasNext() {
		Iterator<String> iter= listaConElems.iterator();
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("A", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("B", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("C", iter.next());
		Assert.assertFalse(iter.hasNext());
	}
	
	@Test (expected=NoSuchElementException.class)
	public void testReverseIteratorHasntNext() throws NoSuchElementException{
		Iterator<String> iter= lv.reverseIterator();
		iter.next();
	}

	@Test
	public void testReverseIteratorHasntNext2() {
		Iterator<String> iter= lv.reverseIterator();
		Assert.assertFalse(iter.hasNext());
	}

	@Test
	public void testReverseIteratorHasNext() {
		Iterator<String> iter= listaConElems.reverseIterator();
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("C", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("B", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("A", iter.next());
		Assert.assertFalse(iter.hasNext());
	}
	
	@Test (expected=NoSuchElementException.class)
	public void testIteratorInstanceHasntNext() throws NoSuchElementException{
		Iterator<String> iter= lv.iteratorInstance();
		iter.next();
	}

	@Test
	public void testIteratorInstanceHasntNext2() {
		Iterator<String> iter= lv.iteratorInstance();
		Assert.assertFalse(iter.hasNext());
	}

	@Test 
	public void testIteratorInstanceHasNext() {
		Iterator<String> iter= listaConElems.iteratorInstance();
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("A", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("A", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("A", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("B", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("B", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("C", iter.next());
		Assert.assertFalse(iter.hasNext());
	}
	
	@Test (expected=NoSuchElementException.class)
	public void testReverseIteratorInstanceHasntNext() throws NoSuchElementException{
		Iterator<String> iter= lv.reverseIteratorInstance();
		iter.next();
	}

	@Test
	public void testReverseIteratorInstanceHasntNext2() {
		Iterator<String> iter= lv.reverseIteratorInstance();
		Assert.assertFalse(iter.hasNext());
	}

	@Test 
	public void testReverseIteratorInstanceHasNext() {
		Iterator<String> iter= listaConElems.reverseIteratorInstance();
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("C", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("B", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("B", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("A", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("A", iter.next());
		Assert.assertTrue(iter.hasNext());
		Assert.assertEquals("A", iter.next());
		Assert.assertFalse(iter.hasNext());
	}

}
