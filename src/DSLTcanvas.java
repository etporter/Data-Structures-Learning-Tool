import javax.swing.*;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

public class DSLTcanvas extends JPanel {

	List<Node> nodes;
	
	public DSLTcanvas()
	{
	}
	
	public void updateList(List<Node> newNodes)
	{
		nodes = newNodes;
	}
		  
	private void drawNode(Graphics g, Node node, int x, int y)
	{
		if (node.color == 0) g.setColor(Color.black);
		else if(node.color == 1) g.setColor(Color.red);
			  
		g.drawOval(x, y, 50, 50);
		g.drawString(Integer.toString(node.element), x+10, y+30);
		
		g.setColor(Color.black);
	}
		  
	public void paintComponent(Graphics g)
	{		  
		for(int i = 0; i<nodes.size(); i++)
		{
			if(i == 0)
			{
				drawNode(g,nodes.get(i), 450, 30);
			}
			else if (i == 1)
			{
				drawNode(g,nodes.get(i), 225, 120);
				g.drawLine(475, 80, 250, 120);
			}
			else if (i == 2)
			{
				drawNode(g,nodes.get(i), 675, 120);
				g.drawLine(475, 80, 700, 120);
			}
			else if (i == 3)
			{
				drawNode(g,nodes.get(i), 113, 310);
				g.drawLine(475, 80, 700, 120);
			}
		}
	}
	
}
