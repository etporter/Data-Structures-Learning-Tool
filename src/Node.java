import java.lang.Math;

public class Node
    { 
	    int element;      		// The data in the node
	    Node leftChild;         // Left child
	    Node rightChild;        // Right child
	    int height;       		// Height
	    int color;				// 0 for black, 1 for red
    
        // Constructors
        public Node(int thisElement)
        {	element = thisElement;
        	leftChild = null;
        	rightChild = null;
        	height = 0;
        	color = 0;
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
        
        public void setColorRed()
        {	color = 1;
        	
        }
        
        public void setColorBlack()
        {	color = 0;
        }
        
        public boolean isRed()
        {	if(color == 1)
        		return true;
        	else
        		return false;
        }

        
    }