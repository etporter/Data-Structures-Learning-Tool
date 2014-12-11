import java.lang.Math;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class RedBlack implements DSLTtree {
	
	
    public Node root;
    public String message = "";
    public List<Node> levelOrder = new ArrayList<Node>(30);
    public static Node empty;
    
    public RedBlack()
    {	root = null;
    }
    
    public boolean isEmpty(Node thisNode)
    {	if(thisNode == empty)
    		return true;
    else
    	return false;
    	
    }
	public void insert(int element)
	{	root = insert(element, root);
		
	}
	
	public Node insert(int element, Node parent)
	{	
		
		if(parent == null)
		{	parent = new Node(element, 1);
		}
		
		else if(element < parent.element || element == parent.element)
		{	 parent.leftChild = insert(element, parent.leftChild);
		}
	
		else 
		{
			parent.rightChild = insert(element, parent.rightChild);
		}

		parent = balance(parent);
		return parent;
		
	}
	
	
	
	
	public void delete(int element)
	{   message = "";
    	if(find(element, root) == true)
    	{	message = element + "was deleted.";
    		if (!root.leftChild.isRed() && !root.rightChild.isRed())
    		{	root.setColorRed();
    		}
    		
    		root = delete(element, root);
    		
    		if (root != null) 
    		{	root.setColorBlack();
    		}
       	}
    	
    	else
    	{   message = element + "was not in the tree.";
    	}		
	}

	
	
	private Node delete(int element, Node parent)
	{	
		if(element < parent.element)
		{	if(!parent.leftChild.isRed() && !parent.leftChild.leftChild.isRed())
			{	parent = moveLeft(parent);
			}
				
				parent.leftChild = delete(element, parent.leftChild);	
		}
		
		else 
		{	if(parent.leftChild.isRed())
			{	parent = rightRotate(parent);
			
			}
    	
        	if(parent.element == element && (parent.rightChild == null))
        	{	return null;
        	}
        	
        	if(!parent.rightChild.isRed() && !parent.rightChild.leftChild.isRed())
        	{	parent = moveRight(parent);
        	}
        	
        	if(element == parent.element)
        	{	Node temp = findMin(parent.rightChild);
        		parent.element = temp.element;
        		parent.rightChild = deleteMin(parent.rightChild);
        		
        	}
        		
        	else
        		parent.rightChild = delete(element, parent.rightChild);
		}
 
		parent = balance(parent);
		return parent;
	}
	
	
	private Node moveLeft(Node parent)
	{	parent = flipColors(parent);
		if(parent.rightChild.leftChild.isRed())
		{	parent.rightChild = rightRotate(parent.rightChild);
			parent = leftRotate(parent);	
		}
		return parent;	
	}
	
	private Node moveRight(Node parent)
	{	parent = flipColors(parent);
		if(parent.leftChild.leftChild.isRed())
		{	parent = rightRotate(parent);
		}
		return parent;	
	}
	
	private Node findMin(Node parent)
	{	if (parent.leftChild == null) 
		{	return parent;
		}
    	else
    	{	return findMin(parent.leftChild); 
    	}
		
	}
	
	
    private Node deleteMin(Node parent) 
    {	if (parent.leftChild == null)
            return null;
    	
    	if(parent.rightChild != null && parent.rightChild.leftChild != null)
    	{	if (parent.rightChild.leftChild.isRed())
        	{	parent = moveLeft(parent);
        	}
    	}
        parent.leftChild = deleteMin(parent.leftChild);
        return parent;
       
    }
	
    
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
	
	
	
	public String getMessage()
	{	return message;
	}

	
	private Node balance(Node parent)
	{	if(parent.rightChild != null && parent.leftChild != null)
		{	if(parent.rightChild.isRed() && !parent.leftChild.isRed())
			{	parent = leftRotate(parent);
			}
			else if(parent.leftChild.isRed() && parent.rightChild.isRed())
			{	parent = flipColors(parent);
			
			}
		}
		
		if(parent.leftChild != null)
		{	if(parent.leftChild.leftChild != null)
			{	if(parent.leftChild.isRed() && parent.leftChild.leftChild.isRed())
				{	parent = rightRotate(parent);
				
				}
			}
		}
		
		
			
		
		else if(parent.rightChild != null)
		{	if(parent.isRed() && parent.rightChild.isRed())
			{	parent = leftRotate(parent);
			
			}
			
		}
		
		
		parent.subTreeCount = sizeSubtreeCount(parent.leftChild) + sizeSubtreeCount(parent.rightChild) +1;
		return parent;	
	}
	
	
	public Node leftRotate(Node parent)
	{	Node newRoot = parent.rightChild;
		parent.rightChild = newRoot.leftChild;
		newRoot.leftChild = parent;
		
		newRoot.color = newRoot.leftChild.color;
		newRoot.leftChild.setColorRed();
		newRoot.subTreeCount = parent.subTreeCount;
		parent.subTreeCount = sizeSubtreeCount(parent.leftChild) + sizeSubtreeCount(parent.rightChild) + 1;
		return newRoot;
		
	}
	
	
	//Method to rotate to the right
	//POST: Parent's left child is new 'root'
	//Parent is the right child, parents right child is the roots left child.
	
	public Node rightRotate(Node parent)
	{	Node newRoot = parent.leftChild;
		parent.leftChild = newRoot.rightChild;
		newRoot.rightChild = parent;
		
		newRoot.color = newRoot.rightChild.color;
		newRoot.rightChild.setColorRed();
		newRoot.subTreeCount = parent.subTreeCount;
		parent.subTreeCount = sizeSubtreeCount(parent.leftChild) + 
				sizeSubtreeCount(parent.rightChild) + 1;
		return newRoot;	
	}
	
	
	//Method takes the parent node and switches its color
	//and the color of its children
	public Node flipColors(Node parent)
	{	parent.flipColor();
		parent.leftChild.flipColor();
		parent.rightChild.flipColor();
		return parent;
	}
	
	
	
	
	//Method to return of the number of black nodes from the parent to a leaf
    public int sizeSubtreeCount(Node parent) 
    {	if(parent == null)
    	{	return 0;
    	}
    	else
    	{	return parent.subTreeCount;
    	} 
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

