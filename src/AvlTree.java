import java.lang.Math;

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
                if(parent.getLCH() - parent.getRCH() > 1)
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
                if(parent.getRCH() - parent.getLCH() > 1)
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
            if(parent.getLCH() > parent.getRCH())
            {	parent.height = parent.getLCH() + 1;
            }
            else
            {	parent.height = parent.getRCH() + 1; 
            }
            
            //returns parent so recursion can occur
            return parent;
        }

        //Boolean to tell if item is in the tree or not
        private boolean find(int x, Node node)
        {
            while( node != null )
                if(x < node.element)
                {	//Check left side if less
                    node = node.leftChild;
                }
                else if(x > node.element)
                {	//Check right side if greater
                	node = node.rightChild;
                }
                else
                {	//Match
                    return true;    
                }
            
            //Hit a null node
            return false;
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
            k2.height = Math.max(k2.getLCH(), k2.getRCH()) + 1;
            k1.height = Math.max(k1.getLCH(), k2.height) + 1;
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
            k1.height = Math.max(k1.getLCH(), k1.getRCH()) + 1;
            k2.height = Math.max(k2.getRCH(), k1.height) + 1;
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