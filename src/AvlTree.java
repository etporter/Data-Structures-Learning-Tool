import java.lang.Math;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;


/*	AVLTree
 * 	Implements DSLTtree
 * 	Conditions: BST
 * 				|leftSubtree.height - rightSubtree.height| cannot be greater than 1
 * 				Deletions: Smallest item in right subtree replaces item
 */
public class AvlTree implements DSLTtree {
	
        public Node root;
        public String message = "";
        public List<Node> levelOrder =  new ArrayList<Node>(30);
        public static Node empty;
        
        
        //Constructor, empty tree, no root.
        public AvlTree( )
        {	root = null;
        }

        //Constructor, with element of root
        public AvlTree(int element)
        {	root = new Node(element);
        }
        
        public boolean isEmpty(Node thisNode)
        {	if(thisNode == empty)
        		return true;
        	else
        		return false;
        }
        
        
        //Delete stub, to match that of implementation.
        //Calls internal delete method
        public void delete(int element)
        {	message = "";
        	if(find(element, root) == true)
        	{	message = element + "was deleted.";
        		root = delete(element, root);
        	}
        	else
        	{   message = element + "was not in the tree.";
        	}
        }
        
        //Removes first found instance of x from tree
        //Does nothing if x is not in tree
        private Node delete(int element, Node parent)
        {	
        		if(parent == null)
        		{	return parent;
        		}
        		
        		//If in left subtree
        		if(parent.element > element)
        		{	parent.leftChild = delete(element, parent.leftChild);
        		}
        		//If in right subtree
        		else if(parent.element < element)
        		{	parent.rightChild = delete(element, parent.rightChild);
        		}
        		
        		//else this is the key to be deleted
        		else
        		{	//if one or less children
        			if(parent.leftChild == null || parent.rightChild == null)
        			{	//if zero children, set to null
        				if(parent.leftChild == null && parent.rightChild == null)
        				{	parent = null;   				
        				}
        				//else pick the child and overwrite the parent
        				else
        				{	if(parent.leftChild != null)
        						parent = parent.leftChild;
        					else
        						parent = parent.rightChild;		
        				}
        			}
        			
        			//else the node has two children
        			else
        			{	Node temp = findSmallest(parent.rightChild);
        				parent.element = temp.element;
        				parent.rightChild = delete(temp.element, parent.rightChild);
        			}	
        		}
        		
        		//If tree is now empty, ie. parent has been set to null
        		if(parent == null)
        		{	return parent;
        		}
        		
        		parent.height = Math.max(parent.getLCH(), parent.getRCH()) + 1;
        		
        		
        		   if(parent.getLCH() - parent.getRCH() > 1)
                   {	
                   	//if item is rightmost from parent, double rotation
                       if(element > parent.leftChild.element)
                       {	message += ("Double rotation about" + parent.element);
                       		parent = doubleRotateLeft(parent);
                       }
                   
                   	//Else item is leftmost, single rotation
                       else
                       {	message += ("Single rotation about" + parent.element);
                       		parent = singleRotateLeft(parent);
                       }
                   }
        		   
        		   else if(parent.getRCH() - parent.getLCH() > 1)
                   {  
                   	//if item is rightmost, single rotation
                   	if(element > parent.rightChild.element)
                   	{   message += ("Single rotation about" + parent.element);
                   		parent = singleRotateRight(parent);
                   	}
                   	
                   	//else item is leftmost, double rotation
                       else
                       { 	message += ("Double rotation about" + parent.element);
                       		parent = doubleRotateRight(parent);
                       }
                   }
        		   
        		   
        
        	    return parent;
        }
        	
        
        

        
        //Finds the smallest element in a tree, used when finding a replacement
        public Node findSmallest(Node parent)
        {	//If this doesn't have a left child, return the parent
        	if(parent.leftChild == null)
        		return parent;
        	//If it does have left child, call method again on the leftChild
        	else
        	{	return findSmallest(parent.leftChild);
        	}	
        }
        
        //Returns String to update learning tool of what happened in tree
        public String getMessage()
        {	return message;
        }
        
        //Uses Lists to get a level order of all nodes
        public List<Node> allNodes()
        {	levelOrder.clear();
        	List<Node> thisLevel = new ArrayList<Node>();
        	List<Node> nextLevel = new ArrayList<Node>();
        	
        	//Add root
        	thisLevel.add(root);

        	//While this level is not empty
        	while (!thisLevel.isEmpty()) 
        	{	Iterator<Node> iter = thisLevel.iterator();
        	
        		//While there is a next item
	            while (iter.hasNext()) 
	            {	//Add the children of the next node
	            	Node currentNode = iter.next();
	            	if(currentNode == empty)
	            		{	levelOrder.add(empty);
	            		}
	            	else if(currentNode != null && currentNode != empty) 	
	            	{	levelOrder.add(currentNode);
	            	
		                if(currentNode.leftChild == null)
		                {	nextLevel.add(empty);}
		                else
		                {	nextLevel.add(currentNode.leftChild);}
		                
		                if	(currentNode.rightChild == null)
		                {	nextLevel.add(empty);}
		                else
		                {	nextLevel.add(currentNode.rightChild);}
		               
	            	}
	            
	            }
        	
	            
	            //Sets this level to be next row down, creates a new next level
	            thisLevel = nextLevel;
	            nextLevel = new ArrayList<Node>();
        	}
        	
        	return levelOrder;
        }
        
        
        //Insert method, to follow interface. Implemented as a return function below for recursion.
        public void insert(int element)
        {	root = insert(element, root);
        	message = element + "was inserted.";
        }
        
        //Inserts x into tree, pass in root from outside. 
        public Node insert(int x, Node parent)
        {
        	//If this location is null, this is the a new node
        	//Works for root, and when an empty tree is reached
            if( parent == null )
            {	parent = new Node(x);
            }
            
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
                    {	message += ("Double rotation about" + parent.element);
                    	parent = doubleRotateLeft(parent);
                    }
                
                	//Else item is leftmost, single rotation
                    else
                    {	message += ("Single rotation about" + parent.element);
                    	parent = singleRotateLeft(parent);
                    }
                }
                        
            }
            
            //Same process as left side, but now on right side
            else if(x > parent.element)
            {
            	//recursion to insert down right subtree
                parent.rightChild = insert( x, parent.rightChild );
                
                //Checks height condition
                if(parent.getRCH() - parent.getLCH() > 1)
                {  
                	//if item is rightmost, single rotation
                	if(x > parent.rightChild.element)
                	{   message += ("Single rotation about" + parent.element);
                		parent = singleRotateRight(parent);
                	}
                	
                	//else item is leftmost, double rotation
                    else
                    { 	message += ("Double rotation about" + parent.element);
                    	parent = doubleRotateRight(parent);
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
        private Node singleRotateLeft(Node parent)
        {	
        	//Sets old left child as root, parent as right child and left subchild as left child.
        	Node newRoot = parent.leftChild;
        	//if(newRoot.rightChild != null)
            {
            parent.leftChild = newRoot.rightChild;
            }
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
        private Node doubleRotateLeft(Node parent)
        {
            parent.leftChild = singleRotateRight(parent.leftChild);
            return singleRotateLeft(parent);
        }

       
        //Double rotation on right side
        //Accomplished by rotating the right child on the left and then rotating the result to the right
        private Node doubleRotateRight(Node parent)
        {
            parent.rightChild = singleRotateLeft(parent.rightChild);
            return singleRotateRight(parent);
        }

}