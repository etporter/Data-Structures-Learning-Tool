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
	{
		
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

}
