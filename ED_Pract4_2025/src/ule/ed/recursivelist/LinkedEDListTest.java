package ule.ed.recursivelist;

import static org.junit.Assert.*;

import org.junit.*;


public class LinkedEDListTest {
	private LinkedEDList<String> list;
	
	@Before
	public void setup() {
		 list= new LinkedEDList<String>();
	}
	
	@Test
	public void test_Vacia() {
		assertEquals(0,list.size());
	}
	
	@Test
	public void test_AddLast() {
		list.addLast("2");
		Assert.assertFalse(list.isEmpty());
		Assert.assertEquals("(2 )", list.toString());
		list.addLast("3");
		Assert.assertEquals("(2 3 )", list.toString());
		list.addLast("7");
		Assert.assertEquals("(2 3 7 )", list.toString());
	}
	
	@Test(expected=EmptyCollectionException.class)
	public void test_RemoveLastElem_Vacia() throws EmptyCollectionException{
		list.removeLastElem("A");
	}

	@Test(expected=NullPointerException.class)
	public void test_addLast_ElementoNulo() {
			list.addLast(null);
			
	}
	
	@Test
	public void linkedtestAddPos_Varios() {
		list.addPos("2",1);
		Assert.assertFalse(list.isEmpty());
		Assert.assertEquals("(2 )", list.toString());
		list.addPos("3",1);
		Assert.assertEquals("(3 2 )", list.toString());
		list.addPos("7",2);
		Assert.assertEquals("(3 7 2 )", list.toString());
		list.addPos("10",3);
		Assert.assertEquals("(3 7 10 2 )", list.toString());
		
	}

	
}
