package ule.ed.service;

import java.util.ArrayList;

public class Service {
	 private ArrayList<Dish> order;
	 private int nChildren;
	 private int nPeople;
	 
	 public Service(int nPeople, int nChildren) {
		 // TODO
		 }
	 
	 
	 /**
	  * Metodo que devuelve el numero de ninyos en una mesa
	  * @return nChildren
	  */
	 public int getNChildren(){
		 return this.nChildren;
	 }
	 
	 /**
	  * Metodo que devuelve el numero de personas de una mesa
	  * @return nPeople
	  */
	 
	 public int getNPeople() {
		 return this.nPeople;
	 }
	 
	 public ArrayList<Dish> getOrder(){
		 return this.order;
	 }
	 
	 
	 //Calcula el total de este servicio, tiene que recorrer el array de platos calculando el total de cada plato, teniendo en cuenta que hay una cantidad de esos platos
	 // total de un plato = count * price (número de platos * cantidad de platos)
	 
	 public double getTotalService() {
		 // TODO
		return 0;
		
			
	 }
	 
	 @Override
		public String toString() {
			return "{Servicio:" + nPeople +"personas," +nChildren + "niños, total= "+ getTotalService() + "}";
		}

	}

