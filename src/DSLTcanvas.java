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
				drawNode(g,nodes.get(i), 113, 210);
				g.drawLine(250, 170, 138, 210);
			}
			else if (i == 4)
			{
				drawNode(g,nodes.get(i), 338, 210);
				g.drawLine(250, 170, 363, 210);
			}
			else if (i == 5)
			{
				drawNode(g,nodes.get(i), 562, 210);
				g.drawLine(675+25, 120+50, 562+25, 210);
			}
			else if (i == 6)
			{
				drawNode(g,nodes.get(i), 788, 210);
				g.drawLine(675+25, 120+50, 788+25, 210);
			}
			else if (i == 7)
			{
				drawNode(g,nodes.get(i), 56, 300);
				g.drawLine(113+25, 210+50, 56+25, 300);
			}
			else if (i == 8)
			{
				drawNode(g,nodes.get(i), 113+56, 300);
				g.drawLine(113+25, 210+50, 113+56+25, 300);
			}
			else if (i == 9)
			{
				drawNode(g,nodes.get(i), 338-56, 300);
				g.drawLine(338+25, 210+50, 338-56+25, 300);
			}
			else if (i == 10)
			{
				drawNode(g,nodes.get(i), 338+56, 300);
				g.drawLine(338+25, 210+50, 338+56+25, 300);
			}
			else if (i == 11)
			{
				drawNode(g,nodes.get(i), 562-56, 300);
				g.drawLine(562+25, 210+50, 562-56+25, 300);
			}
			else if (i == 12)
			{
				drawNode(g,nodes.get(i), 562+56, 300);
				g.drawLine(562+25, 210+50, 562+56+25, 300);
			}
			else if (i == 13)
			{
				drawNode(g,nodes.get(i), 788-56, 300);
				g.drawLine(788+25, 210+50, 788-56+25, 300);
			}
			else if (i == 14)
			{
				drawNode(g,nodes.get(i), 788+56, 300);
				g.drawLine(788+25, 210+50, 788+56+25, 300);
			}
			else if (i == 15)
			{
				drawNode(g,nodes.get(i), 28, 390);
				g.drawLine(56+25, 300+50, 28+25, 390);
			}
			else if (i == 16)
			{
				drawNode(g,nodes.get(i), 56+28, 390);
				g.drawLine(56+25, 300+50, 56+28+25, 390);
			}
			else if (i == 17)
			{
				drawNode(g,nodes.get(i), 113+56-28, 390);
				g.drawLine(113+56+25, 300+50, 113+56-28+25, 390);
			}
			else if (i == 18)
			{
				drawNode(g,nodes.get(i), 112+56+28, 390);
				g.drawLine(113+56+25, 300+50, 112+56+28+25, 390);
			}
			else if (i == 19)
			{
				drawNode(g,nodes.get(i), 338-56-28, 390);
				g.drawLine(338-56+25, 300+50, 338-56-28+25, 390);
			}
			else if (i == 20)
			{
				drawNode(g,nodes.get(i), 338-56+28, 390);
				g.drawLine(338-56+25, 300+50, 338-56+28+25, 390);
			}
			else if (i == 21)
			{
				drawNode(g,nodes.get(i), 338+56-28, 390);
				g.drawLine(338+56+25, 300+50, 338+56-28+25, 390);
			}
			else if (i == 22)
			{
				drawNode(g,nodes.get(i), 338+56+28, 390);
				g.drawLine(338+56+25, 300+50, 338+56+28+25, 390);
			}
			else if (i == 23)
			{
				drawNode(g,nodes.get(i), 562-56-28, 390);
				g.drawLine(562-56+25, 300+50, 562-56-28+25, 390);
			}
			else if (i == 24)
			{
				drawNode(g,nodes.get(i), 562-56+28, 390);
				g.drawLine(562-56+25, 300+50, 562-56+28+25, 390);
			}
			else if (i == 25)
			{
				drawNode(g,nodes.get(i), 562+56-28, 390);
				g.drawLine(562+56+25, 300+50, 562+56-28+25, 390);
			}
			else if (i == 26)
			{
				drawNode(g,nodes.get(i), 562+56+28, 390);
				g.drawLine(562+56+25, 300+50, 562+56+28+25, 390);
			}
			else if (i == 27)
			{
				drawNode(g,nodes.get(i), 788-56-28, 390);
				g.drawLine(788-56+25, 300+50, 788-56-28+25, 390);
			}
			else if (i == 28)
			{
				drawNode(g,nodes.get(i), 788-56+28, 390);
				g.drawLine(788-56+25, 300+50, 788-56+28+25, 390);
			}
			else if (i == 29)
			{
				drawNode(g,nodes.get(i), 788+56-28, 390);
				g.drawLine(788+56+25, 300+50, 788+56-28+25, 390);
			}
			else if (i == 30)
			{
				drawNode(g,nodes.get(i), 788+56+28, 390);
				g.drawLine(788+56+25, 300+50, 788+56+28+25, 390);
			}
		}
	}
	
}
