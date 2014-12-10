import java.lang.Math;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;


public class MinHeap implements DSLTtree {
	
    public Node root = new Node();
    public String message = "";
    public List<Node> minHeap = new ArrayList<Node>(30);
    public int size;
	
    
    //Constructor, empty tree, no root.
    public MinHeap( )
    {	size = 0;
    	minHeap.add(root);
    }
    
    //Inserts into minHeap array. 
    //Skip index 0 b/c finding correct index's is easier when starting at 1
	public void insert(int element)
	{	Node insertThis = new Node(element);
		size++;
		//int index = size;
		minHeap.add(insertThis);    
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
	{	int startIndex = 1;
		int child;
		   Node tmp = minHeap.get(startIndex);

	        for( ; startIndex * 2 <= size; startIndex = child )
	        {	child = startIndex * 2;
	            if( child != size && (minHeap.get(child+1).element < minHeap.get(child).element))
	            {     
	                child++;
	            }
	            if(minHeap.get(child).element < tmp.element)
	         
	            {     minHeap.set(startIndex, minHeap.get(child));
	            
	            
	            }
	            else
	                break;
	        }
	        
	        minHeap.set(startIndex, tmp);
		
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
