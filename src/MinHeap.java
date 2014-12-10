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
        message = element + "was inserted. \n Percolate Up.";

	}
	
	//Deletes minimum item
	public void delete(int label)
	{ 	int minItem = minHeap.get(1).element;
	
		//Overwrite first index with last index, decrement size
		minHeap.set(1, minHeap.get(size));
		minHeap.set(size, null);
		size--;
		
		//Percolate this item down the tree
		percolateDown();
		message = minItem + "was removed. \n Percolate Down.";
	}
	
	
	
	public void percolateUp()
	{	int index = size;
		
		//While this index is not the root, and its parent's value is greater than the item
    	while (	(hasParent(index)) && (parentValue(index) > (minHeap.get(index).element)) )
    	{	//Swap the two items
    		swap(index, parentIndex(index));
    		index = parentIndex(index);
    	}	
	}
	
	public void percolateDown()
	{	int index = 1;
		int LCIndex = index*2;
		int RCIndex = (index*2) + 1;
		//While this item has a left child(index * 2)
		while (minHeap.get(LCIndex) != null)
		{
			
	        //Sets smallerChild to left
	        int smallerChildIndex = LCIndex;
	        int smallerChild = minHeap.get(LCIndex).element;
	        
	        //Check right side for a smallerChild, and replace if necessary
	        if (minHeap.get(RCIndex) != null)
	        {	int compareChild = minHeap.get(RCIndex).element;
	        	if(smallerChild > compareChild)
	        	{	smallerChildIndex = RCIndex;
	        	}
	        }
	           
	        if(minHeap.get(index).element > minHeap.get(smallerChildIndex).element)
	        {	swap(index, smallerChildIndex);
	        }
	        
	        else
	        {
	        	break;
	        }
	        
	        //Update index to continue loop
	        index = smallerChild;
	        LCIndex = index*2;
			RCIndex = (index*2) + 1;
		}        
		
	}
	
	public void swap(int i1, int i2)
	{  	Node temporary = minHeap.get(i1);
		minHeap.set(i1, minHeap.get(i2));
		minHeap.set(i2, temporary);	
	}
	
	//Returns index of this items parent
	//This is why the index's start at 1, because then the truncated result of this division
	//will result in the correct parent every time
    private int parentIndex(int i) 
    {	int retVal = i/2;
    	return retVal;
    }
	
    private int parentValue(int i)
    {	int parentIndex = parentIndex(i);
    	int retVal = minHeap.get(parentIndex).element;
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
