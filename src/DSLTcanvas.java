import javax.swing.*;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class DSLTcanvas extends JPanel {
	
		  public DSLTcanvas()
		  {
		  }
		  
		  private void drawNode(Graphics g)
		  {
			  g.setColor(Color.black);
			  g.drawOval(200, 200, 40, 40);
		  }
		  
		  public void paintComponent(Graphics g)
		  {
			  drawNode(g);
		  }
	
}
