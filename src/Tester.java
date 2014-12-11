import java.util.List;

public class Tester {

		  public static void main (String[] args) {
			  
		    //Creates new Window, and sets to visible
		    Window thisWindow = new Window();
		    thisWindow.setSize(1250,750);
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
		    
		    MinHeap thisHeap = new MinHeap();
		    thisHeap.insert(40);
		    thisHeap.insert(41);
		    thisHeap.insert(52);
		    thisHeap.insert(38);
		    thisHeap.insert(56);
		    thisHeap.insert(42);
		    thisHeap.delete(-1);
		    List<Node> thisHeapList = thisHeap.allNodes();
		    for(int i = 0; i<= thisHeap.size; i++)
		    {System.out.println(thisHeapList.get(i).element);
		    
		    }

	}
		

}
