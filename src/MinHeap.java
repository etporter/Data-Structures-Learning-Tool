import java.lang.Math;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;


public class MinHeap implements DSLTtree {
	
    public Node root;
    public String message = "";
    public List<Node> minHeap = new ArrayList<Node>(30);
    public int size;
	
    
    //Constructor, empty tree, no root.
    public MinHeap( )
    {	size = 0;
    	minHeap.set(size, null);
    }
    
    //Inserts into minHeap array. 
    //Skip index 0 b/c finding correct index's is easier when starting at 1
	public void insert(int element)
	{	size++;
		int index = size;
		minHeap.get(index).element = element;     
        percolateUp();	

	}
	
	public void delete(int label)
	{
		
	}
	
	
	
	public void percolateUp()
	{	int index = this.size;
		//While this index is not the root, and its parent is greater than the item
    	while (hasParent(index) && (
    			parent(index).compareTo(array[index]) > 0))
    	{	//Swap the two items
    		swap(index, parentIndex(index));
    		index = parentIndex(index);
    	}	
	}
	
	public void percolateDown()
	{
		
	}
	
	
	//Returns index of this items parent
	//This is why the index's start at 1, because then the truncated result of this division
	//will result in the correct parent every time
    private int parentIndex(int i) 
    {	int retVal = i/2;
    	return retVal;
    }
	
    //Returns true if this index is not the root
    protected boolean hasParent(int i) 
    {	boolean retVal = (i > 1);
    	return retVal;
    }
    
	//Uses Lists to get a level order of all nodes
	public List<Node> allNodes()
	{	return minHeap;
	}
	
	
	public String getMessage()
	{	return message;
	}
	

}
