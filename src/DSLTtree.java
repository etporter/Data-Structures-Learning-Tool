import java.util.List;

public interface DSLTtree {
	
	public void insert(int label);
	
	public Node delete(int label, Node root);
	
	/**
	 * @return the integers stored in the tree in level order
	 */
	public List<Node> allNodes();
	
	public String getMessage();
}
