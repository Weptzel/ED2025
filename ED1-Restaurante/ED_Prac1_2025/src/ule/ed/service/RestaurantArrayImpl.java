package ule.ed.service;

import java.util.List;
import java.util.ArrayList;

public class RestaurantArrayImpl implements IRestaurant {

	// ATRIBUTOS

	private String name;
	private int nTables;
	private int maxCapacity; // máximo número de clientes admitidos
	private int nClients; // contador de clientes actuales en el restaurante

	private int discount; // Descuento a aplicar (ejemplo: 10%)

	private Service[] tables; // array de servicios (cada servicio se corresponde con una mesa)

	// CONSTRUCTOR

	public RestaurantArrayImpl(String name, int nTables, int aforoMax, int discount) {
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
		for (int i = 0; i < tables.length; i++) {
			if (tables[i] != null) {
				nChildren += tables[i].getNChildren();
			}
		}
		return nChildren;
	}

	@Override
	public int getNumberOfPeople() {
		int numPeople = 0;
		for (int i = 0; i < tables.length; i++) {
			if (tables[i] != null) {
				numPeople += tables[i].getNPeople();
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
		for (int i = 0; i < tables.length; i++) {
			if (tables[i] != null && tables[i].getNPeople() != 0) {
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
		for (int i = 0; i < tables.length; i++) {
			if (tables[i] != null && tables[i].getNChildren() != 0) {
				nTablesWithChildren++;
			}
		}
		return nTablesWithChildren;
	}

	@Override
	public List<Integer> getNumbersOfEmptyTables() {
		List<Integer> lista = new ArrayList<>();
		for (int i = 0; i < tables.length; i++) {
			if (tables[i] != null) {
				lista.add(i + 1);
			}
		}
		return lista;
	}

	@Override
	public Service getService(int ntable) {
		if (ntable < 1 || ntable > this.nTables) {
			return null;
		}
		Service service = tables[ntable - 1];
		if (service == null) {
			return null;
		}
		return service;
	}

	@Override
	public void addDishToTable(int nTable, String name, double price, int count) {
		if (nTable < 1 || nTable > nTables) {
			return; // Salimos si la mesa no es válida
		}
	
		Service service = tables[nTable - 1]; // Corregimos el índice
		if (service != null) {
			boolean found = false;
	
			// Buscamos si el plato ya está en la lista
			for (Dish dish : service.getOrder()) {
				if (dish.getName().equals(name)) { 
					dish.setCount(dish.getCount() + count); // Sumamos la cantidad
					found = true;
					break;
				}
			}
	
			// Si no encontramos el plato, lo añadimos a la lista
			if (!found) {
				Dish newDish = new Dish(name, price);
				newDish.setCount(count);
				service.getOrder().add(newDish);
			}
		}
	}

	@Override
	public double getFinalPrice(int ntable) {
		double finalPrice = 1.0;
		if (ntable < 1 || ntable > nTables) {
			return 0.0;
		}
		Service service = getService(ntable);
		if (service == null) {
			return 0.0;
		}
		finalPrice = service.getTotalService() - (service.getTotalService() * discount / 100);
		return finalPrice;
	}

	@Override
	public double getFinalPriceRestaurant() {
		double finalPrice = 0.0;
		for (int i = 0; i < tables.length; i++) {
			finalPrice += getFinalPrice(i + 1);
		}
		return finalPrice;
	}

	@Override
	public boolean emptyTable(int nTable) {
		if (nTable < 1 || nTable > nTables || tables[nTable - 1] == null) {
			return false;
		}
		tables[nTable - 1] = null;
		return true;
	}

	@Override
	public int occupyTable(int nPeople, int nChildren) {
		if (getActualCapacity() < nChildren + nPeople) {
			return -1;
		}
		for (int i = 0; i < tables.length; i++) {
			if (tables[i] == null) { // Si la mesa está libre
				// Ocupamos la mesa con los datos proporcionados (número de personas y niños)
				tables[i] = new Service(nPeople, nChildren);
				nClients += nPeople; // Incrementamos el contador de clientes
				return i + 1; // Retornamos el número de la mesa (comienza en 1)
			}
		}
		return -2;
	}

	@Override
	public boolean occupyTable(int nTable, int nPeople, int nChildren) {
		if (nTable < 1 || nTable > nTables || (getActualCapacity() < nPeople + nChildren)) {
			return false;
		}
		if (tables[nTable - 1] != null) {
			return false;
		}
		return true;

	}

}