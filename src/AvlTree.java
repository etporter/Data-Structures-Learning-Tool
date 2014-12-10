

public class AvlTree implements DSLTtree {
	
        private Node root;
        
        /**
         * Construct the tree.
         */
        public AvlTree( )
        {	root = null;
        }

        /**
         * Insert into the tree; duplicates are ignored.
         * @param x the item to insert.
         */
        public void insert( int x )
        {
            root = insert( x, root );
        }

        /**
         * Remove from the tree. Nothing is done if x is not found.
         * @param x the item to remove.
         */
        public void remove( int x )
        {
            System.out.println( "Sorry, remove unimplemented" );
        }

        /**
         * Find an item in the tree.
         * @param x the item to search for.
         * @return the matching item or null if not found.
         */
        public int find( int x )
        {
            return elementAt( find( x, root ) );
        }

        /**
         * Make the tree logically empty.
         */
        public void makeEmpty( )
        {
            root = null;
        }

        /**
         * Test if the tree is logically empty.
         * @return true if empty, false otherwise.
         */
        public boolean isEmpty( )
        {
            return root == null;
        }

        /**
         * Print the tree contents in sorted order.
         */
        public void printTree( )
        {
            if( isEmpty( ) )
                System.out.println( "Empty tree" );
            else
                printTree( root );
        }

        /**
         * Internal method to get element field.
         * @param t the node.
         * @return the element field or null if t is null.
         */
        private int elementAt( Node t )
        {
            return t == null ? null : t.element;
        }

        //Inserts x into tree
        private Node insert(int x, Node parent)
        {
        	//If this location is null, this is the a new node
        	//Works for root, and when an empty tree is reached
            if( parent == null )
                parent = new Node(x);
            
            //If the item to be inserted is less than its parent, insert at left child.
            //Also, if item is equal, insert down left subtree.
            //Once inserted, checks the height of lowest level
            //As recursive calls return, checks height of other levels
            //If height at any level violates the rules, rotate accordingly
            else if(x < parent.element || x == parent.element)
            {
            	//recursion to insert down left subtree, which can split to right of left
                parent.leftChild = insert(x, parent.leftChild);
                
                //if the height of the left subtree is more than 1 different
                if(height(parent.leftChild) - height(parent.rightChild) > 1)
                {	
                	//if item is rightmost from parent, double rotation
                    if(x > parent.leftChild.element)
                    {	parent = doubleRotationLeft(parent);
                    }
                
                	//Else item is leftmost, single rotation
                    else
                    {	parent = singleRotationLeft(parent);
                    }
                }
                        
            }
            
            //Same process as left side, but now on right side
            else //if(x > parent.element)
            {
            	//recursion to insert down right subtree
                parent.rightChild = insert( x, parent.rightChild );
                
                //Checks height condition
                if(height( parent.rightChild ) - height( parent.leftChild ) > 1)
                {  
                	//if item is rightmost, single rotation
                	if(x > parent.rightChild.element)
                	{   parent = singleRotateRight(parent);
                	}
                	
                	//else item is leftmost, double rotation
                    else
                    {   parent = doubleRotateRight(parent);
                    }
                }
            }
            
            //Updates height of parent at each level, because recursive calls will cause this to be updated
            if(height(parent.leftChild) > height(parent.rightChild))
            {	parent.height = height(parent.leftChild) + 1;
            }
            else
            {	parent.height = height(parent.rightChild) + 1; 
            }
            
            //returns parent so recursion can occur
            return parent;
        }

        /**
         * Internal method to find an item in a subtree.
         * @param x is item to search for.
         * @param t the node that roots the tree.
         * @return node containing the matched item.
         */
        private Node find( int x, Node t )
        {
            while( t != null )
                if( x < t.element)
                    t = t.leftChild;
                else if( x > t.element)
                    t = t.rightChild;
                else
                    return t;    // Match

            return null;   // No match
        }

        /**
         * Internal method to print a subtree in sorted order.
         * @param t the node that roots the tree.
         */
        private void printTree( Node t )
        {
            if( t != null )
            {
                printTree( t.leftChild );
                System.out.println( t.element );
                printTree( t.rightChild );
            }
        }

        /**
         * Return the height of node t, or -1, if null.
         */
        private static int height( Node t )
        {
            return t == null ? -1 : t.height;
        }

        /**
         * Return maximum of lhs and rhs.
         */
        private static int max( int lhs, int rhs )
        {
            return lhs > rhs ? lhs : rhs;
        }

        /**
         * Rotate binary tree node with left child.
         * For AVL trees, this is a single rotation for case 1.
         * Update heights, then return new root.
         */
        private static Node singleRotationLeft( Node k2 )
        {
            Node k1 = k2.leftChild;
            k2.leftChild = k1.rightChild;
            k1.rightChild = k2;
            k2.height = max( height( k2.leftChild ), height( k2.rightChild ) ) + 1;
            k1.height = max( height( k1.leftChild ), k2.height ) + 1;
            return k1;
        }

        /**
         * Rotate binary tree node with right child.
         * For AVL trees, this is a single rotation for case 4.
         * Update heights, then return new root.
         */
        private static Node singleRotateRight( Node k1 )
        {
            Node k2 = k1.rightChild;
            k1.rightChild = k2.leftChild;
            k2.leftChild = k1;
            k1.height = max( height( k1.leftChild ), height( k1.rightChild ) ) + 1;
            k2.height = max( height( k2.rightChild ), k1.height ) + 1;
            return k2;
        }

        /**
         * Double rotate binary tree node: first left child
         * with its right child; then node k3 with new left child.
         * For AVL trees, this is a double rotation for case 2.
         * Update heights, then return new root.
         */
        private static Node doubleRotationLeft( Node k3 )
        {
            k3.leftChild = singleRotateRight( k3.leftChild );
            return singleRotationLeft( k3 );
        }

        /**
         * Double rotate binary tree node: first right child
         * with its left child; then node k1 with new right child.
         * For AVL trees, this is a double rotation for case 3.
         * Update heights, then return new root.
         */
        private static Node doubleRotateRight( Node k1 )
        {
            k1.rightChild = singleRotationLeft( k1.rightChild );
            return singleRotateRight( k1 );
        }

}