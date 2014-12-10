import java.util.List;

public class Tester {

		  public static void main (String[] args) {
			  
		    //Creates new Window, and sets to visible
		    Window thisWindow = new Window();
		    thisWindow.setSize(1500,800);
		    thisWindow.setVisible(true);
		    
		    
		    AvlTree thisTree = new AvlTree();
		    thisTree.insert(8);
		    thisTree.insert(5);
		    thisTree.insert(21);
		    thisTree.insert(3);
		    thisTree.insert(9);
		    thisTree.insert(7);
		    thisTree.insert(1);
		    thisTree.insert(2);
		    thisTree.insert(11);
		    thisTree.insert(14);
		    List<Node> thisList = thisTree.allNodes();
		    for(int i = 0; i<thisList.size(); i++)
		    {	if(thisList.get(i) != AvlTree.empty)
		    		System.out.println(thisList.get(i).element);
		    	else
		    		System.out.println("Null Node");
		    }
		    
		    System.out.println("");
		    thisTree.delete(14);
		    thisTree.delete(7);
		    thisTree.delete(8);
		    thisTree.delete(1);
		    thisList = thisTree.allNodes();
		    for(int i = 0; i<thisList.size(); i++)
		    {	if(thisList.get(i) != AvlTree.empty)
		    		System.out.println(thisList.get(i).element);
		    	else
		    		System.out.println("Null Node");
		    }
		    /*
		    System.out.println("");
		   
		    
		    
		    thisList = thisTree.allNodes();
		    for(int i = 0; i<thisList.size(); i++)
		    {	if(thisList.get(i) != AvlTree.empty)
		    		System.out.println(thisList.get(i).element);
		    	else
		    		System.out.println("Null Node");
		    }*/
		  }
		

}
