

public class Node
    { 
	    int element;      		// The data in the node
	    Node leftChild;         // Left child
	    Node rightChild;        // Right child
	    int height;       		// Height
	    int color;				// 0 for black, 1 for red
    
        // Constructors
        Node( int element )
        {	 this(element, null, null);
        }

        Node( int thisElement, Node left, Node right )
        {
            element  = thisElement;
            leftChild  = left;
            rightChild   = right;
            height   = 0;
            color = 0;
        }


    }