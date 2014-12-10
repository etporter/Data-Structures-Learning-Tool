import javax.swing.*;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

public class DSLTcanvas extends JPanel {
	
		  public DSLTcanvas()
		  {
		  }
		  
		  private void drawNode(Graphics g, Node node)
		  {
			  int x;
			  int y;
			  
			  x = 200;
			  y = 200;
			  
			  if (node.color == 0) g.setColor(Color.black);
			  else if(node.color == 1) g.setColor(Color.red);
			  
			  g.drawOval(x, y, 50, 50);
			  g.drawString(Integer.toString(node.element), x+10, y+30);
		  }
		  
		  public void paintComponent(Graphics g/*, List<Node> nodes*/)
		  {
			  Node aNode = new Node(1000);
			  aNode.setColorRed();
			  
			  drawNode(g, aNode);
			  
			  //Make sure we check for null nodes in this
			  /*for(int i = 0; i<nodes.size(); i++)
			  {
				  drawNode(g,nodes.get(i));
			  }*/
		  }
	
}
