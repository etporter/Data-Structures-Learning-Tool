import java.util.List;

public interface DSLTtree {
	
	public void insert(int label);
	
	public void delete(int label);
	
	/**
	 * @return the integers stored in the tree in level order
	 */
	public List<Node> allNodes();
	
	public String getMessage();
	
	public boolean isEmpty(Node node);
	
	
}
