import java.lang.Math;

public class Node
    { 
	    int element;      		// The data in the node
	    Node leftChild;         // Left child
	    Node rightChild;        // Right child
	    int height;       		// Height
	    int color;				// 0 for black, 1 for red
	    int subTreeCount; 		// Count of subtrees for Red/Black
    
        // Constructors
        public Node(int thisElement)
        {	element = thisElement;
        	leftChild = null;
        	rightChild = null;
        	height = 0;
        	color = 0;
        }

        public Node(int thisElement, int thisColor)
        {	element = thisElement;
        	leftChild = null;
        	rightChild = null;
        	height = 0;
        	color = thisColor;
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
        
        public boolean isRed()
        {	if(color == 1)
        		return true;
        	else
        		return false;
        }
        
        public void flipColor()
        {	if(color == 1)
        		color = 0;
        	else
        		color = 1;
        	
        }
        


        
    }