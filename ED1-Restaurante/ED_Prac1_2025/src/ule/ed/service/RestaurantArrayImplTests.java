package ule.ed.service;

import org.junit.*;


public class RestaurantArrayImplTests {

	
	private RestaurantArrayImpl res;
	
	
	@Before
	public void testBefore() throws Exception{
	    res = new RestaurantArrayImpl("Casa Pepe", 15, 100, 10);
	}
	
	@Test
	public void testRestauranteVacio() throws Exception {
		
	    Assert.assertTrue(res.getActualCapacity()==100);
	    Assert.assertEquals(res.getMaxCapacity(),100);
	    Assert.assertEquals(res.getNumberOfChildren(),0);
	}
	
	@Test
	public void testOcupa1Mesa() throws Exception{
		
			
	    Assert.assertEquals(1,res.occupyTable(4, 2)); // le asigna la mesa 1
	    Assert.assertEquals(96,res.getActualCapacity());
	    Assert.assertEquals(2,res.getNumberOfChildren());
 
	}


	@Test
	public void testGetTotal1plato() throws Exception{
		
			
	    Assert.assertEquals(1,res.occupyTable(4, 2)); // le asigna la mesa 1
	    res.addDishToTable(1,"Arroz", 10.0, 2);
	    Assert.assertEquals(18.0,res.getFinalPrice(1),0.0);
	    Assert.assertEquals(18.0,res.getFinalPriceRestaurant(),0.0);    
	}

	@Test
	public void testGetTotal2platos() throws Exception{
		
			
	    Assert.assertEquals(1,res.occupyTable(4, 2)); // le asigna la mesa 1
	    res.addDishToTable(1,"Arroz", 10.0, 2);
	    res.addDishToTable(1,"Macarrones", 10.0, 1);
	    Assert.assertEquals(27.0,res.getFinalPrice(1),0.0);
	    Assert.assertEquals(27.0,res.getFinalPriceRestaurant(),0.0);    
	}

	@Test
	public void testOcuparMesaHastaAforoMax(){
		res.occupyTable(10, 0);
		res.occupyTable(10, 0);
		res.occupyTable(10, 0);
		res.occupyTable(10, 0);
		res.occupyTable(10, 0);
		res.occupyTable(10, 0);
		res.occupyTable(10, 0);
		res.occupyTable(10, 0);
		res.occupyTable(10, 0);
		Assert.assertEquals(10, res.getActualCapacity());

		res.occupyTable(10, 0);
		Assert.assertEquals(0, res.getActualCapacity());
		Assert.assertEquals(100, res.getNumberOfPeople());

		int mesaFallida = res.occupyTable(10, 0);
		Assert.assertEquals(-1, mesaFallida); // No se debe permitir

		Assert.assertEquals(100, res.getNumberOfPeople());

	}

	@Test
	public void testAddPlatoVariasVecesDistintoPrecio(){
		Assert.assertEquals(1,res.occupyTable(4, 2)); // le asigna la mesa 1
	    res.addDishToTable(1,"Arroz", 1.0, 1);
	    res.addDishToTable(1,"Arroz", 1.5, 1);
	    Assert.assertEquals(2.25,res.getFinalPrice(1),0.0); 
	}

	@Test 
	public void testNMesasOcupadas(){
		Assert.assertEquals(1,res.occupyTable(4, 2)); // le asigna la mesa 1
		Assert.assertEquals(2,res.occupyTable(4, 2)); // le asigna la mesa 2
		Assert.assertEquals(2,res.getNumberTablesOccupied());
		Assert.assertEquals(13, res.getNumberOfEmptyTables());

	}

	@Test
	public void testGetMesasConNinios(){
		Assert.assertEquals(1, res.occupyTable(1, 0));
		Assert.assertEquals(2, res.occupyTable(2, 1));
		Assert.assertEquals(1, res.getNumberOfTablesWithChildren());

	}

	@Test
	public void testOcupaMesaOcupada(){
		
		Assert.assertTrue(res.occupyTable(1, 1, 0));
		Assert.assertFalse(res.occupyTable(1, 1, 0));
	}

	@Test 
	public void testOcupaMesaValAforoMax(){
		Assert.assertEquals(1, res.occupyTable(10, 0));
		Assert.assertEquals(2, res.occupyTable(0, 90));
	}

	@Test
	public void testOcuparMesaValorNoValido(){
		Assert.assertFalse(res.occupyTable(-1, 1, 1));
		Assert.assertFalse(res.occupyTable(0, 1, 0));
		Assert.assertFalse(res.occupyTable(16, 1, 1));
		
	}
}

