import java.lang.Math;

public class AvlTree implements DSLTtree {
	
        public Node root;
        public String message = "";
        public Node[] levelOrder;
        
        //Constructor, empty tree, no root.
        public AvlTree( )
        {	root = null;
        }

        //Constructor, with element set
        public AvlTree(int element)
        {	root = new Node(element);
        }
        
        //Removes first found instance of x from tree
        //Does nothing if x is not in tree
        public void delete(int element)
        {
        }
        
        //Returns String to update learning tool of what happened in tree
        public String getMessage()
        {
        	return message;
        }
        
        public Node[] allNodes()
        {
        	return levelOrder;
        }
        
        //Insert method, to follow interface. Implemented as a return function below for recursion.
        public void insert(int element)
        {	root = insert(element, root);
        }
        
        //Inserts x into tree, pass in root from outside. 
        public Node insert(int x, Node parent)
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


        //Single rotation of left sides
        private Node singleRotationLeft(Node parent)
        {
        	//Sets old left child as root, parent as right child and left subchild as left child.
            Node newRoot = parent.leftChild;
            parent.leftChild = newRoot.rightChild;
            newRoot.rightChild = parent;
            
            //updates heights based on max of children. 
            parent.height = Math.max(parent.getLCH(), parent.getRCH()) + 1;
            newRoot.height = Math.max(newRoot.getLCH(), parent.height) + 1;
            
            //returns newRoot for recursion in other methods
            return newRoot;
        }

        
        
        //Single rotation of right sides
        private Node singleRotateRight(Node parent)
        {	
        	//Sets old right child as root, parent as left child and right subchild as right child.
            Node newRoot = parent.rightChild;
            parent.rightChild = newRoot.leftChild;
            newRoot.leftChild = parent;
            
            //updates heights based on max of children. 
            parent.height = Math.max(parent.getLCH(), parent.getRCH()) + 1;
            newRoot.height = Math.max(newRoot.getRCH(), parent.height) + 1;
            
            //returns newRoot for recursion in other methods
            return newRoot;
        }

        
        //Double rotation on left side
        //Accomplished by rotating the left child on the right and then rotating the result to the left
        private Node doubleRotationLeft(Node parent)
        {
            parent.leftChild = singleRotateRight(parent.leftChild);
            return singleRotationLeft(parent);
        }

       
        //Double rotation on right side
        //Accomplished by rotating the right child on the left and then rotating the result to the right
        private Node doubleRotateRight(Node parent)
        {
            parent.rightChild = singleRotationLeft(parent.rightChild);
            return singleRotateRight(parent);
        }

}