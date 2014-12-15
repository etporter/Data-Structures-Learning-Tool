import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JComboBox<String> typeSelector = new JComboBox<String>();
	
	public MainWindow()
	{	
		super("Data Structure Visualizations - A Learning Tool");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel windowLayout = new JPanel();
		
		JLabel title = new JLabel("Please select a type of data structure:");
		title.setFont(new Font("Serif", Font.BOLD, 30));
		
		
		String[] commands = {"AVL Tree","Red-Black Tree","Binary Heap - Min", "Binary Search Tree"};
		for(int i=0; i<commands.length; i++)
		{
			typeSelector.addItem(commands[i]);
		}
		
		JButton goButton = new JButton("Go!");
		goButton.addActionListener(this);
		
		windowLayout.add(title);
		windowLayout.add(typeSelector);
		windowLayout.add(goButton);
		getContentPane().add(windowLayout);
	}
	
	private void startTreeWindow(int treeType, String title)
	{	//Creates new Window, and sets to visible
		Window thisWindow = new Window(treeType);
		thisWindow.setSize(1250,750);
		thisWindow.setVisible(true);
		thisWindow.setTitle(title); 
	}
	
	//When go button is pressed
	public void actionPerformed(ActionEvent e) 
	{ 	
		if(typeSelector.getSelectedIndex() == 0)
		{	// Creates new Window, and sets to visible
			startTreeWindow(0,"AVL Tree");
		}
		
		if(typeSelector.getSelectedIndex() == 1)
		{	// Creates new Window, and sets to visible
			startTreeWindow(1,"Red-Black Tree");
		}
		
		if(typeSelector.getSelectedIndex() == 2)
		{	// Creates new Window, and sets to visible
			startTreeWindow(2,"Binary Heap - Min");
		}
		
		if(typeSelector.getSelectedIndex() == 3)
		{	// Creates new Window, and sets to visible
			startTreeWindow(3,"Binary Search Tree");
		}
	    
		dispose();
	}
}