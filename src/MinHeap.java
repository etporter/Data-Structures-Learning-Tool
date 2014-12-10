import java.lang.Math;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;


public class MinHeap implements DSLTtree {
	
    public Node root;
    public String message = "";
    public List<Node> minHeap = new ArrayList<Node>(10);
    public int size;
	
    
    //Constructor, empty tree, no root.
    public AvlTree( )
    {	minHeap.get(0).element 
    }

    //Constructor, with element of root
    public AvlTree(int element)
    {	root = new Node(element);
    }
    
	public void insert(int element)
	{
		
	}
	
	public void delete(int label)
	{
		
	}
	
	private Node insert(int element, Node parent)
	{
	
	}
	
	
	
	
	//Uses Lists to get a level order of all nodes
	public List<Node> allNodes()
	{	return minHeap;
	}
	
	
	public String getMessage()
	{	return message;
	}
	

}
