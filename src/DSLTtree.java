public interface DSLTtree {
	
	public void insert(int label);
	
	public void delete(int label);
	
	/**
	 * @return the integers stored in the tree in level order
	 */
	public node[] allNodes();
	
	public String getMessage();
}
