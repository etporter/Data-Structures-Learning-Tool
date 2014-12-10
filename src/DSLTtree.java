public interface DSLTtree {
	
	public void insert(int label);
	
	public void delete(int label);
	
	/**
	 * @return the integers stored in the tree in level order
	 */
	public Node[] allNodes();
	
	public String getMessage();
}
