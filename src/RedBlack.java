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
    
	public void insert(int element)
	{	root = insert(element, root);
		
	}
	
	public Node insert(int element, Node parent)
	{	if(parent == null)
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
        if (!parent.leftChild.isRed() && !parent.leftChild.leftChild.isRed())
        {	parent = moveLeft(parent);
        }
        parent.leftChild = deleteMin(parent.leftChild);
        return balance(parent);
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
	{ if(parent.rightChild != null && parent.leftChild != null)
		{if(parent.rightChild.isRed() && ! parent.leftChild.isRed())
		{	parent = leftRotate(parent);
		
		}
		if(parent.leftChild.leftChild != null)
		{if(parent.leftChild.isRed() && parent.leftChild.leftChild.isRed())
		{	parent = rightRotate(parent);
			
		}
		}
		if(parent.leftChild.isRed() && parent.rightChild.isRed())
		{	parent = flipColors(parent);
			
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
	
	public Node rightRotate(Node parent)
	{	Node newRoot = parent.leftChild;
		parent.leftChild = newRoot.rightChild;
		newRoot.rightChild = parent;
		newRoot.color = newRoot.rightChild.color;
		newRoot.rightChild.setColorRed();
		newRoot.subTreeCount = parent.subTreeCount;
		parent.subTreeCount = sizeSubtreeCount(parent.leftChild) + sizeSubtreeCount(parent.rightChild) + 1;
		return newRoot;	
	}
	
	public Node flipColors(Node parent)
	{	parent.flipColor();
		parent.leftChild.flipColor();
		parent.rightChild.flipColor();
		return parent;
		
	}
	
    public int sizeSubtreeCount(Node parent) 
    {	if(parent == null)
    	{	return 0;
    	}
    	else
    	{	return parent.subTreeCount;
    	} 
    }

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
}

