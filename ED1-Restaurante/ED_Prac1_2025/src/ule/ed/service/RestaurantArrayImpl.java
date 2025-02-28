package ule.ed.service;

import java.util.List;
import java.util.ArrayList;

public class RestaurantArrayImpl implements IRestaurant {

	// ATRIBUTOS
	
	private String name;
	private int nTables;
	private int maxCapacity; // máximo número de clientes admitidos
	private int nClients; // contador de clientes actuales en el restaurante

	private int discount;    // Descuento a aplicar (ejemplo: 10%)

	private Service[] tables; // array de servicios (cada servicio se corresponde con una mesa)
	                          


	// CONSTRUCTOR

	public RestaurantArrayImpl(String name, int nTables,int aforoMax, int discount){ 
		// Debe crear el array de mesas con todas las posiciones a null
		this.name = name;
		this.nTables = nTables;
		this.maxCapacity = aforoMax;
		this.nClients = 0;
		this.discount = discount;
		this.tables = new Service[nTables];	
	}



	@Override
	public String getName() {
		return this.name;
		
	}



	@Override
	public int getMaxCapacity() {
		return this.maxCapacity;
	}



	@Override
	public int getNumberOfChildren() {
		int nChildren = 0;
		for(int i = 0; i < tables.length; i++){
			if(tables[i] != null){
				nChildren += tables[i].getNChildren();
			}
		}
		return nChildren;
	}



	@Override
	public int getNumberOfPeople() {
		int numPeople = 0;
		for(int i = 0; i < tables.length; i++){
			if(tables[i] != null){
				numPeople += tables[i].getNPeople() + tables[i].getNChildren();
			}
		}
		return numPeople;
	}



	@Override
	public int getActualCapacity() {
		return maxCapacity - nClients;
	}



	@Override
	public int getNumberTablesOccupied() {
		int nTablesOcuppied = 0;
		for(int i = 0; i < tables.length; i++){
			if(tables[i] != null && tables[i].getNPeople() != 0){
				nTablesOcuppied++;
			}
		}
		return nTablesOcuppied;
	}



	@Override
	public int getNumberOfEmptyTables() {
		return tables.length - this.getNumberTablesOccupied();
	}



	@Override
	public int getNumberOfTablesWithChildren() {
		int nTablesWithChildren = 0;
		for(int i = 0; i < tables.length; i++){
			if(tables[i] != null && tables[i].getNChildren() != 0){
				nTablesWithChildren++;
			}
		}
		return nTablesWithChildren;
	}



	@Override
	public List<Integer> getNumbersOfEmptyTables() {
		List<Integer> lista = new ArrayList<>();
		for(int i = 0; i < tables.length; i++){
			if(tables[i] != null){
				lista.add(i + 1);
			}
		}
		return lista;
	}



	@Override
	public Service getService(int ntable) {
		if(ntable < 1 || ntable > this.nTables){
			return null;
		}
		Service service = tables[ntable - 1];
		if(service == null || service.getNPeople() == 0){
			return null;
		}
		return service;
	}



	@Override
	public void addDishToTable(int nTable, String name, double price, int count) {
		Service service = tables[nTable];
		Dish dish = new Dish(name, price);
		for(int i = 0; i < service.getOrder().size(); i++){
			if(service.getOrder().get(i).equals(dish)){
				dish.setCount(count + 1);
			}else{
				service.getOrder().add(dish);
			}
		}
	}



	@Override
	public double getFinalPrice(int ntable) {
		if(ntable < 1 || ntable > nTables){
			return 0.0;
		}
		Service service = getService(ntable - 1);
		if(service == null){
			return 0.0;
		}
		double finalPrice = service.getTotalService();
		return finalPrice * (1 - discount / 100.0);
	}



	@Override
	public double getFinalPriceRestaurant() {
		double finalPrice = 0.0;
		for(int i = 0; i < tables.length; i++){
			finalPrice += getFinalPrice(i + 1);
		}
		return finalPrice;
    }



	@Override
	public boolean emptyTable(int nTable) {
		if(nTable < 1 || nTable > nTables || tables[nTable - 1] == null){
			return false;
		}
		tables[nTable - 1] = null;
		return true;
	}



	@Override
	public int occupyTable(int nPeople, int nChildren) {
		int count = 0;
		if(maxCapacity - getActualCapacity() < nChildren + nPeople){
			return -1;
		}
		while(count < tables.length){
			if(occupyTable(count + 1, nPeople, nChildren)){
				tables[count] = new Service(nPeople, nChildren);
				nClients += nPeople + nChildren;
				return count;
			}
			count++;	
		}
			
		return -2;
	}
	
	@Override
	public boolean occupyTable(int nTable, int nPeople, int nChildren) {
		if(nTable < 1 || nTable > nTables || (maxCapacity - getActualCapacity() < nPeople + nChildren)){
			return false;
		}
		if(tables[nTable - 1] != null){
			return false;
		}
		return true;
		
	}
	
}