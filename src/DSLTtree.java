import java.util.List;

/**
 * @author Ethan Porter, Seraphina Orsini
 * The interface defined for all data structures in our project
 * As long as any given data structure implements this interface, the GUI can work with it
 */
public interface DSLTtree {
	
	/**
	 * Insert a given label into the tree
	 * @param label The integer to be inserted
	 */
	public void insert(int label);
	
	/**
	 * Delete a given label from the tree
	 * @param label The integer to be deleted
	 */
	public void delete(int label);
	
	/**
	 * Returns a list of all the nodes in a tree in level order
	 * @return the integers stored in the tree in level order
	 */
	public List<Node> allNodes();
	
	/**
	 * Gets the last move made in the tree (e.g. insertion, rotation, etc.)
	 * @return The last move(s) made in the tree
	 */
	public String getMessage();
	
	/**
	 * Check to see if a node is empty
	 * @param node The node to check
	 * @return Boolean value of whether the node is empty or not
	 */
	public boolean isEmpty(Node node);
	
	
}
