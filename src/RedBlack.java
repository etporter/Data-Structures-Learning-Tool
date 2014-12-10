import java.lang.Math;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class RedBlack implements DSLTtree {
	
	
    public Node root;
    public String message = "";
    public List<Node> levelOrder;
    
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
	{
		
	}
	
	public List<Node> allNodes()
	{	return levelOrder;
	}
	
	public String getMessage()
	{	return message;
	}

	private Node balance(Node parent)
	{	if(parent.rightChild.isRed() && ! parent.leftChild.isRed())
		{	parent = leftRotate(parent);
		
		}
		
		if(parent.leftChild.isRed() && parent.leftChild.leftChild.isRed())
		{	parent = rightRotate(parent);
			
		}
		
		if(parent.leftChild.isRed() && parent.rightChild.isRed())
		{	parent = flipColors(parent);
			
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
	{	
		parent.flipColor();
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
	
}

