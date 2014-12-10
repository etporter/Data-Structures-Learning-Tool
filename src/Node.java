import java.lang.Math;

public class Node
    { 
	    int element;      		// The data in the node
	    Node leftChild;         // Left child
	    Node rightChild;        // Right child
	    int height;       		// Height
	    int color;				// 0 for black, 1 for red
    
        // Constructors
        public Node( int thisElement )
        {	element  = thisElement;
        	leftChild  = null;
        	rightChild   = null;
        	height   = 0;
        	color = 0;
        	
        	//this(element, null, null);
        }

      //  Node( int thisElement, Node left, Node right )
        {
            
        }


        public int maxHeightChildren()
        {	
        	int thisHeight = 0;
        	if(leftChild != null && rightChild != null)
	        {	thisHeight = Math.max(leftChild.height, rightChild.height);
        	}
        	else if(leftChild == null)
        	{	if(rightChild != null)
        			thisHeight = rightChild.height;
        	}
        	else
        	{	if(leftChild != null)
        			thisHeight = leftChild.height;
        	}
        	return thisHeight;
        	
        }
        
        public int getLCH()
        {	if(leftChild != null)
				return leftChild.height;
        	else
        		return -1;
        	
        }
        
        public int getRCH()
        {	if(rightChild != null)
				return rightChild.height;
    		else
    			return -1;
        	
        }
        
        
    }