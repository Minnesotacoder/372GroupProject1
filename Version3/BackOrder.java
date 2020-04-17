/**
 * 
 * @modelName Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The modelNames do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents a single backOrder on a appliance by a customer
 * 
 * @modelName Brahma Dathan and Sarnath Ramnath
 *
 */
public class BackOrder implements Serializable {
	private Appliance appliance;
	private Customer customer;
	private int quantity;

	Queue<BackOrder> backOrderQueue = new LinkedList<BackOrder>();

	/**
	 * The customer and appliance and quantity are stored.
	 * 
	 * @param customer  who places the backOrder
	 * @param appliance the appliance on which backOrder is placed
	 * @param quantity  of which customer has purchased
	 */

	public BackOrder(Customer customer, Appliance appliance, int quantity) {
		this.appliance = appliance;
		this.customer = customer;
		this.quantity = quantity;

	}

	/**
	 * Getter for Customer
	 * 
	 * @return Customer who has the backOrder
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Getter for Appliance
	 * 
	 * @return Appliance on backOrder
	 */
	public Appliance getAppliance() {
		return appliance;
	}

	/**
	 * Getter for quantity
	 * 
	 * @return quantity of specific backOrder
	 */
	public int getQuantity() {
		return quantity;
	}

}
