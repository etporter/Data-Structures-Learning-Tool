import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

/*	BST
 * 	Implements DSLTtree
 * 	Conditions: BST
 * 				Items in left subtree <= Root
 * 				Items in right subtree > Root
 */
public class BST implements DSLTtree {
	
        public Node root;											//Root Node
        public String message = "";									//Message to send to display
        public List<Node> levelOrder =  new ArrayList<Node>(30);	//Tree Nodes in Level Order
        public static Node empty;									//Empty Node marker for level order
        
        
        //Constructor, empty tree, no root.
        public BST( )
        {	root = null;
        }

        //Constructor, with element of root
        public BST(int element)
        {	root = new Node(element);
        }
        
        //Returns true if this node is the empty node
        //Used to keep track of positions in levelOrder method
        public boolean isEmpty(Node thisNode)
        {	if(thisNode == empty)
        		return true;
        	else
        		return false;
        }
        
        
        //Delete stub, to match that of implementation.
        //Calls internal delete method
        //Does nothing if x is not in tree
        public void delete(int element)
        {	message = "";
        	if(find(element, root) == true)
        	{	message = element + " was deleted. \n";
        		root = delete(element, root);
        	}
        	else
        	{   message = element + " was not in the tree. \n";
        	}
        }
        
        //Removes first found instance of x from tree
        private Node delete(int element, Node parent)
        {		
        		//If we have hit a null node, return
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
        			
        			//else the node has two children, continue down right subtree
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
	        			nextLevel.add(empty);
	        			nextLevel.add(empty);
	        		}
		        	//Adds children to next level, including placeholder empty
		        	if(currentNode != null) 	
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
		        if(isListAllEmpty(thisLevel) == true)
		        {	break;
		        }
		        nextLevel = new ArrayList<Node>();
			}
			return levelOrder;
		}
		
		public boolean isListAllEmpty(List<Node> thisList)
		{	for(int i = 0; i < thisList.size(); i++)
			{	if(thisList.get(i) != empty)
					return false;
			}
			return true;
		}
	        
        
        //Insert method, to follow interface. Implemented as a return function below for recursion.
        public void insert(int element)
        {	root = insert(element, root);
        	message = element + " was inserted. \n";
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
                        
            }
            
            //Same process as left side, but now on right side
            else if(x > parent.element)
            {
            	//recursion to insert down right subtree
                parent.rightChild = insert( x, parent.rightChild );
            }
                   
           
            return parent;
        }

        
        //Method to determine if a node is in the tree or not
        private boolean find(int x, Node node)
        {	//Loops through correct side until it hits a null node 
        	//Or finds the element
            while(node != null)
                if(x < node.element)
                {	node = node.leftChild;
                }
                else if(x > node.element)
                {	node = node.rightChild;
                }
                else
                {	return true;    
                }
            return false;
        }


       

}