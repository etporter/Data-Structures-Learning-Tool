import java.util.ArrayList;
import java.util.List;

/*	MinHeap
 * 	Implements DSLTtree
 * 	Conditions: Tree must be complete:	Every level must be full except the last
 * 										On last level, Nodes are leftmost
 * 				All parents are less than their children
 * 				Inserts done at bottom rightmost, percolated up
 * 				Deletions done from top, with bottom item moved to root and percolated down
 */
public class MinHeap implements DSLTtree {
	
    public Node root = new Node();							//Root node
    public String message = "";								//Message from tree to window
    public List<Node> minHeap = new ArrayList<Node>(30);	//List to hold order of nodes
    public int size;										//the size of the heap
	public static Node empty; 								//empty node to be placeholder
    
    //Constructor, empty tree, no root.
    public MinHeap()
    {	size = 0;
    	minHeap.add(root);
    }
    
    //Inserts into minHeap array. 
    //Skip index 0 b/c finding correct index's is easier when starting at 1
	public void insert(int element)
	{	Node insertThis = new Node(element);
		size++;
		minHeap.add(insertThis);    
        percolateUp();
        message = element + "was inserted. \n Percolate Up.";
	}
	
	//Function to match empty nodes
	//Only used for AVL and RB level order
	//In this class to match DSLTtree interface
    public boolean isEmpty(Node thisNode)
    {	if(thisNode == empty)
    		return true;
    	else
    		return false;
    }
    
	//Deletes minimum item, which is the first index
	public void delete(int label)
	{ 	int minItem = minHeap.get(1).element;
	
	
		//Overwrite first index with last index, which will be the rightmost bottom element
		//decrement size
		minHeap.set(1, minHeap.get(size));
		minHeap.set(size, null);
		size--;
		
		//Percolate this item down the tree
		percolateDown();
		
		//Set message for the display
		message = minItem + "was removed. \n Percolate Down.";
	}
	
	
	//Moves an inserted item up the binHeap until it is in the correct position
	//That is, until it is less than both of its children
	public void percolateUp()
	{	
		//set starting index to the last item in list
		int index = size;
		
		//While this index is not the root, and its parent's value is greater than the item
    	while (	(hasParent(index)) && (parentValue(index) > (minHeap.get(index).element)) )
    	{	//Swap the two items
    		swap(index, parentIndex(index));
    		index = parentIndex(index);
    	}	
	}
	
	//Moves the top node down the tree until it is not greater than its children
	public void percolateDown()
	{	//Find starting node, the first element
		Node moveDown = minHeap.get(1);
		int index = 1;
		
		//Loops until break statement hit
		while (true) 
		{	//Finds index of both children
			int lcIndex = index*2; 
			int rcIndex = lcIndex + 1;
			int child; 
			
			//If the left child index is larger than the size of the array
			//We have exceeded the bounds
			if (lcIndex > size) 
		    {	break;
		    }
			
			//If the left child is the size, set the child to this index
			//Because this would be the next index in a complete binHeap
			if (lcIndex == size) 
			{	child = lcIndex;
			} 
	      
			//Else, if the left child is less than the right child, set the index to the smaller child
			else if (minHeap.get(lcIndex).element < minHeap.get(rcIndex).element)
	    	{	child = lcIndex;
	    	} 
	      
			//Else, the right child must be less, so set it to that index
			else 
			{	child = rcIndex;
			}
	      
			
			//If the item we are percolating is smaller than its smallest child
			//It is in the correct position, so don't do anything
			if (moveDown.element < minHeap.get(child).element)
			{	break;

			}
	      
			//else one of these children is smaller, so switch them and repeat this process until
			// you hit a break statement next time through
			else 
			{	minHeap.set(index, minHeap.get(child));
				index = child;      
			}
	    }
		
		//Put the moveDown element in its correct ending position
		minHeap.set(index, moveDown);
	}
	
	
	
	//Swaps two nodes in list
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
	
    
    //Returns value of parent
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
	
	//Gets message from current action on tree
	public String getMessage()
	{	return message;
	}
	
}
