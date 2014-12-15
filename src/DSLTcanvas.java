import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

public class DSLTcanvas extends JPanel {

	List<Node> nodes;
	DSLTtree tree;
	int startIndex;
	
	public DSLTcanvas(DSLTtree t, int index)
	{
		tree = t;
		nodes = tree.allNodes();
		this.setBorder(BorderFactory.createBevelBorder(1));
	}
	
	public void updateList()
	{
		nodes = tree.allNodes();
	}
	
	
	private void drawNode(Graphics g, Node node, int x, int y)
	{
		if(!(tree.isEmpty(node)))
		{
			if (node.color == 0) g.setColor(Color.black);
			else if(node.color == 1) g.setColor(Color.red);

			g.drawOval(x, y, 50, 50);
			g.drawString(Integer.toString(node.element), x+10, y+30);
		}
		
		g.setColor(Color.black);
	}
		  
	public void paintComponent(Graphics g)
	{
		nodes = tree.allNodes();
		for(int i = 0; i<nodes.size(); i++)
		{
			if(i == startIndex)
			{	
				drawNode(g,nodes.get(i), 450, 30);
			}
			else if (i == startIndex+1)
			{
				drawNode(g,nodes.get(i), 225, 120);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(475, 80, 250, 120);
			}
			else if (i == startIndex+2)
			{
				drawNode(g,nodes.get(i), 675, 120);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(475, 80, 700, 120);
			}
			else if (i == startIndex+3)
			{
				drawNode(g,nodes.get(i), 113, 210);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(250, 170, 138, 210);
			}
			else if (i == startIndex+4)
			{
				drawNode(g,nodes.get(i), 338, 210);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(250, 170, 363, 210);
			}
			else if (i == startIndex+5)
			{
				drawNode(g,nodes.get(i), 562, 210);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(675+25, 120+50, 562+25, 210);
			}
			else if (i == startIndex+6)
			{
				drawNode(g,nodes.get(i), 788, 210);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(675+25, 120+50, 788+25, 210);
			}
			else if (i == startIndex+7)
			{
				drawNode(g,nodes.get(i), 56, 300);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(113+25, 210+50, 56+25, 300);
			}
			else if (i == startIndex+8)
			{
				drawNode(g,nodes.get(i), 113+56, 300);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(113+25, 210+50, 113+56+25, 300);
			}
			else if (i == startIndex+9)
			{
				drawNode(g,nodes.get(i), 338-56, 300);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(338+25, 210+50, 338-56+25, 300);
			}
			else if (i == startIndex+10)
			{
				drawNode(g,nodes.get(i), 338+56, 300);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(338+25, 210+50, 338+56+25, 300);
			}
			else if (i == startIndex+11)
			{
				drawNode(g,nodes.get(i), 562-56, 300);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(562+25, 210+50, 562-56+25, 300);
			}
			else if (i == startIndex+12)
			{
				drawNode(g,nodes.get(i), 562+56, 300);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(562+25, 210+50, 562+56+25, 300);
			}
			else if (i == startIndex+13)
			{
				drawNode(g,nodes.get(i), 788-56, 300);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(788+25, 210+50, 788-56+25, 300);
			}
			else if (i == startIndex+14)
			{
				drawNode(g,nodes.get(i), 788+56, 300);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(788+25, 210+50, 788+56+25, 300);
			}
			else if (i == startIndex+15)
			{
				drawNode(g,nodes.get(i), 28, 390);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(56+25, 300+50, 28+25, 390);
			}
			else if (i == startIndex+16)
			{
				drawNode(g,nodes.get(i), 56+28, 390);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(56+25, 300+50, 56+28+25, 390);
			}
			else if (i == startIndex+17)
			{
				drawNode(g,nodes.get(i), 113+56-28, 390);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(113+56+25, 300+50, 113+56-28+25, 390);
			}
			else if (i == startIndex+18)
			{
				drawNode(g,nodes.get(i), 112+56+28, 390);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(113+56+25, 300+50, 112+56+28+25, 390);
			}
			else if (i == startIndex+19)
			{
				drawNode(g,nodes.get(i), 338-56-28, 390);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(338-56+25, 300+50, 338-56-28+25, 390);
			}
			else if (i == startIndex+20)
			{
				drawNode(g,nodes.get(i), 338-56+28, 390);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(338-56+25, 300+50, 338-56+28+25, 390);
			}
			else if (i == startIndex+21)
			{
				drawNode(g,nodes.get(i), 338+56-28, 390);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(338+56+25, 300+50, 338+56-28+25, 390);
			}
			else if (i == startIndex+22)
			{
				drawNode(g,nodes.get(i), 338+56+28, 390);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(338+56+25, 300+50, 338+56+28+25, 390);
			}
			else if (i == startIndex+23)
			{
				drawNode(g,nodes.get(i), 562-56-28, 390);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(562-56+25, 300+50, 562-56-28+25, 390);
			}
			else if (i == startIndex+24)
			{
				drawNode(g,nodes.get(i), 562-56+28, 390);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(562-56+25, 300+50, 562-56+28+25, 390);
			}
			else if (i == startIndex+25)
			{
				drawNode(g,nodes.get(i), 562+56-28, 390);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(562+56+25, 300+50, 562+56-28+25, 390);
			}
			else if (i == startIndex+26)
			{
				drawNode(g,nodes.get(i), 562+56+28, 390);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(562+56+25, 300+50, 562+56+28+25, 390);
			}
			else if (i == startIndex+27)
			{
				drawNode(g,nodes.get(i), 788-56-28, 390);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(788-56+25, 300+50, 788-56-28+25, 390);
			}
			else if (i == startIndex+28)
			{
				drawNode(g,nodes.get(i), 788-56+28, 390);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(788-56+25, 300+50, 788-56+28+25, 390);
			}
			else if (i == startIndex+29)
			{
				drawNode(g,nodes.get(i), 788+56-28, 390);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(788+56+25, 300+50, 788+56-28+25, 390);
			}
			else if (i == startIndex+30)
			{
				drawNode(g,nodes.get(i), 788+56+28, 390);
				if(!(tree.isEmpty(nodes.get(i)))) g.drawLine(788+56+25, 300+50, 788+56+28+25, 390);
			}
		}
	}
}
