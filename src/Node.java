

public class Node
    { 
	    int element;      		// The data in the node
	    Node leftChild;         // Left child
	    Node rightChild;        // Right child
	    int height;       		// Height
	    int color;				// 0 for black, 1 for red
    
        // Constructors
        Node( int thisElement )
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


    }