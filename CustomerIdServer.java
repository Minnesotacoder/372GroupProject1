
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Generates member ids.
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 *
 */
public class CustomerIdServer implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idCounter;
	private static CustomerIdServer server;

	/**
	 * Private constructor for singleton pattern
	 * 
	 */
	private CustomerIdServer() {
		idCounter = 1;
	}

	/**
	 * Supports the singleton pattern
	 * 
	 * @return the singleton object
	 */
	public static CustomerIdServer instance() {
		if (server == null) {
			return (server = new CustomerIdServer());
		} else {
			return server;
		}
	}

	/**
	 * Getter for id
	 * 
	 * @return id of the member
	 */
	public int getId() {
		return idCounter++;
	}

	/**
	 * String form of the collection
	 * 
	 */
	@Override
	public String toString() {
		return ("IdServer" + idCounter);
	}


	public static void retrieve(ObjectInputStream input) {
		try {
			server = (CustomerIdServer) input.readObject();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception cnfe) {
			cnfe.printStackTrace();
		}
	}
}