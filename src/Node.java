

class Node
    {  // Friendly data; accessible by other package routines
	    int element;      // The data in the node
	    Node leftChild;         // Left child
	    Node rightChild;        // Right child
	    int height;       // Height
	    int color;
    
        // Constructors
        Node( int element )
        {
            this( element, null, null );
        }

        Node( int thisElement, Node lt, Node rt )
        {
            element  = thisElement;
            leftChild  = lt;
            rightChild   = rt;
            height   = 0;
            color = 0;
        }


    }