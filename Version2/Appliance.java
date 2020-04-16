
/**
 * 
 *
 */
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Represents a single Appliance
 * 
 *
 */
public class Appliance implements Serializable {
	private static final long serialVersionUID = 1L;
	private String brandName;
	private String modelName;
	private String id;
	private int stock;
	private Customer purchasedBy;
	private List backOrders = new LinkedList();
	private Calendar dueDate;

	/**
	 * Creates a appliance with the given id, brandName, and modelName name
	 * 
	 * @param brandName  appliance brandName
	 * @param modelName modelName name
	 * @param id     appliance id
	 */
	
	//                                                      Remove ID
	public Appliance(String brandName, String modelName, String id) {
		this.brandName = brandName;
		this.modelName = modelName;
		this.id = id;
	}

	/**
	 * Marks the appliance as purchased to a customer
	 * 
	 * @param customer the borrower
	 * @return true iff the appliance could be purchased. True currently
	 */
	public boolean purchase(Customer customer) {
		purchasedBy = customer;
		dueDate = new GregorianCalendar();
		dueDate.add(Calendar.MONTH, 1);
		return true;
	}

	/**
	 * Marks the appliance as returned
	 * 
	 * @return The customer who had purchased the appliance
	 */
	public Customer returnAppliance() {
		if (purchasedBy == null) {
			return null;
		} else {
			Customer borrower = purchasedBy;
			purchasedBy = null;
			return borrower;
		}
	}

	/**
	 * Renews the appliance
	 * 
	 * @param customer who wants to renew the appliance
	 * @return true iff the appliance could be renewed
	 */
	public boolean renew(Customer customer) {
		if (hasBackOrder()) {
			return false;
		}
		if ((customer.getId()).equals(purchasedBy.getId())) {
			return (purchase(customer));
		}
		return false;
	}

	/**
	 * Adds one more backOrder to the appliance
	 * 
	 * @param backOrder the new backOrder on the appliance
	 */
	public void placeBackOrder(BackOrder backOrder) {
		backOrders.add(backOrder);
	}

	/**
	 * Removes backOrder for a specific customer
	 * 
	 * @param customerId whose backOrder has to be removed
	 * @return true iff the backOrder could be removed
	 */
	public boolean removeBackOrder(String customerId) {
		for (ListIterator iterator = backOrders.listIterator(); iterator.hasNext();) {
			BackOrder backOrder = (BackOrder) iterator.next();
			String id = backOrder.getCustomer().getId();
			if (id.equals(customerId)) {
				iterator.remove();
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns a valid backOrder
	 * 
	 * @return the next valid backOrder
	 */
	public BackOrder getNextBackOrder() {
		for (ListIterator iterator = backOrders.listIterator(); iterator.hasNext();) {
			BackOrder backOrder = (BackOrder) iterator.next();
			iterator.remove();
			if (backOrder.isValid()) {
				return backOrder;
			}
		}
		return null;
	}

	/**
	 * Checks whether there is a backOrder on this appliance
	 * 
	 * @return true iff there is a backOrder
	 */
	public boolean hasBackOrder() {
		ListIterator iterator = backOrders.listIterator();
		if (iterator.hasNext()) {
			return true;
		}
		return false;
	}

	/**
	 * Returns an iterator for the backOrders
	 * 
	 * @return iterator for the backOrders on the appliance
	 */
	public Iterator getBackOrders() {
		return backOrders.iterator();
	}

	/**
	 * Getter for modelName
	 * 
	 * @return modelName name
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * getter for brandName
	 * 
	 * @return brandName of the appliance
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * Getter for id
	 * 
	 * @return id of the appliance
	 */
	public String getId() {
		return id;
	}

	/**
	 * Getter for borrower
	 * 
	 * @return the customer who purchased the appliance
	 */
	public Customer getPurchaser() {
		return purchasedBy;
	}

	/**
	 * Getter for due date
	 * 
	 * @return the date on which the appliance is due
	 */
	public String getDueDate() {
		return (dueDate.getTime().toString());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null) {
			return false;
		}
		if (getClass() != object.getClass()) {
			return false;
		}
		Appliance other = (Appliance) object;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	/**
	 * String form of the appliance
	 * 
	 */
	public String toString() {
		return "brandName " + brandName + " modelName " + modelName + " id " + id + " purchased by " + purchasedBy;
	}
}
