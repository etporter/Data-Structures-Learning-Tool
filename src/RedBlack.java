import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

/*	Red Black Tree
 * 	Implements DSLTtree
 * 	Conditions: BST
 * 				Root is Black
 * 				Inserts are Red
 * 				Path from root to any leaf has same number of black nodes
 * 				A red node can only have two black children
 */
public class RedBlack implements DSLTtree {
	
    public Node root;											//Root node
    public String message = "";									//Message to send to display
    public List<Node> levelOrder = new ArrayList<Node>(30);		//Level Order list of Nodes
    public static Node empty;									//Placeholder of empty node for levelOrder
    
    //Constructor
    public RedBlack()
    {	root = null;
    }
    
    //Returns true if thisNode is the empty placeholder node
    public boolean isEmpty(Node thisNode)
    {	if(thisNode == empty)
    		return true;
    	else
    		return false;	
    }
    
    //Insert to match DSLTtree inferface
    //Calls internal insert method on the root
	public void insert(int element)
	{	root = insert(element, root, 0, null);
		message = element + " was inserted. \n";
		
	}
	
	//Inserts node correctly into RB tree
	private Node insert(int element, Node parent, int count, Node thisParents)
	{	
		//If current node is null, this is where to insert
		if(parent == null)
		{	if(count == 0)
			{	root = new Node(element);
				root.setColorBlack();
				parent = root;
			}
			else
				parent = new Node(element, 1, thisParents);
		}
		
		//Else if the element is smaller, or the same go to the left 
		//Recursively insert until hit null node
		else if(element < parent.element || element == parent.element)
		{	parent.leftChild = insert(element, parent.leftChild, count+1, parent);
			
		}
	
		//Else element must be greater, recursion on right side.
		else 
		{	parent.rightChild = insert(element, parent.rightChild, count+1, parent);
			
		}
		//check balance of current node
		//will check balance of all nodes it went through to get here by recursion
		parent = balance(parent);
		
		return parent;
	}
	
	//Delete method to match interface, calls internal delete on root
	public void delete(int element)
	{   message = "";
		//sets message if delete can occur
    	if(find(element, root) == true)
    	{	message = element + " was deleted. \n";
    		if (!root.leftChild.isRed() && !root.rightChild.isRed())
    		{	root.setColorRed();
    		}
    		
    		//call delete method
    		root = delete(element, root);
    		
    		if (root != null) 
    		{	root.setColorBlack();
    		}
       	}
    	
    	//else this item is not in the tree, return this message
    	else
    	{   message = element + " was not in the tree. \n";
    	}		
	}

	
	//Internal delete Method
	private Node delete(int element, Node parent)
	{	
		//If element to delete is less than current node, go to left. Check colors for imbalance
		if(element < parent.element)
		{	if(!parent.leftChild.isRed() && !parent.leftChild.leftChild.isRed())
			{	parent = moveLeft(parent);
			}
			parent.leftChild = delete(element, parent.leftChild);	
		}
		
		//Else it must be greater or equal
		else 
		{	//Three cases of greater and colors
			if(parent.leftChild.isRed())
			{	parent = rightRotate(parent);
			}
    	
        	if(parent.element == element && (parent.rightChild == null))
        	{	return null;
        	}
        	
        	if(!parent.rightChild.isRed() && !parent.rightChild.leftChild.isRed())
        	{	parent = moveRight(parent);
        	}
        	
        	//Case equal
        	if(element == parent.element)
        	{	Node temp = findMin(parent.rightChild);
        		parent.element = temp.element;
        		parent.rightChild = deleteMin(parent.rightChild);	
        	}
        	
        	else
        		parent.rightChild = delete(element, parent.rightChild);
		}
 
		//Balance this node
		parent = balance(parent);
		return parent;
	}
	
	
	//flip colors and double rotate a node 
	private Node moveLeft(Node parent)
	{
		if(parent.rightChild.leftChild.isRed())
		{	parent.rightChild = rightRotate(parent.rightChild);
			parent = leftRotate(parent);	
		}
		return parent;	
	}
	
	//Flip colors and double rotate a node
	private Node moveRight(Node parent)
	{
		if(parent.leftChild.leftChild.isRed())
		{	parent = rightRotate(parent);
		}
		return parent;	
	}

	
	//find the minimum node
	private Node findMin(Node parent)
	{	if (parent.leftChild == null) 
		{	return parent;
		}
    	else
    	{	return findMin(parent.leftChild); 
    	}
	}
	
	
	//Delete the minimum item
    private Node deleteMin(Node parent) 
    {	//if no smaller item, return
    	if (parent.leftChild == null)
            return null;
    	
    	//find smaller items
    	if(parent.rightChild != null && parent.rightChild.leftChild != null)
    	{	if (parent.rightChild.leftChild.isRed())
        	{	parent = moveLeft(parent);
        	}
    	}
    	
        parent.leftChild = deleteMin(parent.leftChild);
        return parent;
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
	
	//returns the message
	public String getMessage()
	{	return message;
	}

	
	//Method to balance a node
	private Node balance(Node parent)
	{	//Case where node has two children
		if(hasBothChildren(parent))
		{	if(parent.rightChild.rightChild != null) 
			{	if(parent.rightChild.isRed() && parent.rightChild.rightChild.isRed())
				{	parent.rightChild.setColorBlack();
					parent.leftChild.setColorBlack();
				}
			}
			else if(parent.rightChild.leftChild != null)
			{	if(parent.rightChild.isRed() && parent.rightChild.leftChild.isRed())
				{	parent.rightChild.setColorBlack();
					parent.leftChild.setColorBlack();
					
				}
			}
			else if(parent.leftChild.leftChild != null) 
			{	if(parent.leftChild.isRed() && parent.leftChild.leftChild.isRed())
				{	parent.rightChild.setColorBlack();
					parent.leftChild.setColorBlack();
				}
			}
			else if(parent.leftChild.rightChild != null)
			{	if(parent.leftChild.isRed() && parent.leftChild.rightChild.isRed())
				{	parent.rightChild.setColorBlack();
					parent.leftChild.setColorBlack();
				}	
			}
			if(!parent.leftChild.isRed() && !parent.rightChild.isRed())
				{	parent.setColorRed();
				}
		
		}
		
		//Case of just left child
		if(parent.leftChild != null)
		{	if(parent.leftChild.leftChild != null)
			{	if(parent.leftChild.isRed() && parent.leftChild.leftChild.isRed())
				{	parent = rightRotate(parent);
				}
			}
			if(parent.leftChild.rightChild != null)
			{	if(parent.leftChild.isRed() && parent.leftChild.rightChild.isRed())
				{	parent.leftChild = leftRotate(parent.leftChild);
					parent = rightRotate(parent);
				}
			}
			
		}
		
		
		//case of just right child
		if(parent.rightChild != null)
		{	if(parent.rightChild.rightChild != null)
			{	if(parent.rightChild.isRed() && parent.rightChild.rightChild.isRed())
				{	parent = leftRotate(parent);
				}
			}
			if(parent.rightChild.leftChild != null)
			{	if(parent.rightChild.isRed() && parent.rightChild.leftChild.isRed())
				{	parent.rightChild = rightRotate(parent.rightChild);
					parent = leftRotate(parent);
				}
			}
			
		}
		
		root.setColorBlack();
		//update subtree counts 
		//parent.subTreeCount = sizeSubtreeCount(parent.leftChild) + sizeSubtreeCount(parent.rightChild) +1;
		return parent;	
	}
	
	
	public boolean hasBothChildren(Node thisNode)
	{	if(thisNode.rightChild != null && thisNode.leftChild != null)
			return true;
		else
			return false;
	}
	
	
	//Method to rotate to the left
	//POST: Parent's right child is new 'root'
	//Parent is the left child, parents left child is the roots right child.
	//Updates colors and subtreecount
	public Node leftRotate(Node oldRoot)
	{	Node newRoot = oldRoot.rightChild;
        oldRoot.rightChild = newRoot.leftChild; 
        newRoot.leftChild = oldRoot;
		    
		newRoot.setColorBlack();
		newRoot.leftChild.setColorRed();
		
		if(oldRoot == root)
			root = newRoot;
		
		message += "Left Rotation at " + oldRoot.element + "\n";
		return newRoot;
	}
	
	
	//Method to rotate to the right
	//POST: Parent's left child is new 'root'
	//Parent is the right child, parents right child is the roots left child.
	//Updates colors and subtreecount
	public Node rightRotate(Node oldRoot)
	{	
		Node newRoot = oldRoot.leftChild;
        oldRoot.leftChild = newRoot.rightChild;
        newRoot.rightChild = oldRoot;
		
        newRoot.setColorBlack();
        newRoot.rightChild.setColorRed();

        if(oldRoot == root)
			root = newRoot;
        
		message += "Right Rotation at " + oldRoot.element +  "\n";
		return newRoot;
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

