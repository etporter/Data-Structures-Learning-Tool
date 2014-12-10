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
	{ 	int index = 1;
    
    	//While this item has a left child(index * 2)
    	while (minHeap.get(index*2) != null)
    	{
    		
	        // which of my children is smaller?
	        int smallerChild = minHeap.get(index*2).element;
	        
	        // bubble with the smaller child, if I have a smaller child
	        if (hasRightChild(index)
	            && array[leftIndex(index)].compareTo(array[rightIndex(index)]) > 0) 
	        {	smallerChild = rightIndex(index);
	        } 
	        
	        if (array[index].compareTo(array[smallerChild]) > 0)
	        {
	            swap(index, smallerChild);
	        } 
	        else {
	            // otherwise, get outta here!
	            break;
	        }
	        
	        // make sure to update loop counter/index of where last el is put
	        index = smallerChild;
    }        
		
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
	{
		
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
