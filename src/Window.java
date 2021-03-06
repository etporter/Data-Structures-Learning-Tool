import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author Ethan Porter, Seraphina Orsina
 * The window for displaying the trees, commands, etc.
 * Extends JFrame
 * Implements ActionListener
 */
public class Window extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	JComboBox<String> dropDown = new JComboBox<String>();
	JTextField inputBox = new JTextField(20);
	JButton goButton = new JButton("Go");
	JButton backButton = new JButton("Back");
	JTextArea infoBox = new JTextArea(10,20);
	JTextArea updateBox = new JTextArea(25,20);
	JLabel header1 = new JLabel("Rotation Descriptions");
	DSLTcanvas treeDisplay;
	DSLTtree tree;
	int startIndex = 0;
	
	public Window(int treeType)
	{

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Create tree depending on which was selected
		if(treeType == 0)
		{
			tree = new AvlTree();
		}
		else if(treeType == 1)
		{
			tree = new RedBlack();
		}
		else if(treeType == 2)
		{
			tree = new MinHeap();
			startIndex = 1;
		}
		/*else if(treeType == 3)
		{
			tree = new BST();
		}*/
		
		// Create the display for the tree
		treeDisplay = new DSLTcanvas(tree, startIndex);
		
		// Setup the layout JPanels
		JPanel windowLayout = new JPanel();
		JPanel sidePanel = new JPanel();
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		
		// Define the commands for the dropdown
		String[] commands = {"Insert","Delete"};
		
		// Add the commands to the dropdown
		for(int i=0; i<commands.length; i++)
		{
			dropDown.addItem(commands[i]);
		}
		
		// Create the scroll panes
		JScrollPane scroll = new JScrollPane(infoBox);
		JScrollPane scroll2 = new JScrollPane(updateBox); 
		
		infoBox.setPreferredSize(new Dimension(240,125));
		updateBox.setPreferredSize(new Dimension(240,175));
		infoBox.setEditable(false);
		updateBox.setEditable(false);
		
		dropDown.setAlignmentX(Component.CENTER_ALIGNMENT);
		inputBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		goButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		goButton.addActionListener(this);
		scroll.setAlignmentX(Component.CENTER_ALIGNMENT);
		header1.setAlignmentX(Component.CENTER_ALIGNMENT);
		scroll2.setAlignmentX(Component.CENTER_ALIGNMENT);
		backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		backButton.addActionListener( new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
            	dispose();
            	MainWindow mainWindow = new MainWindow();
        		mainWindow.setSize(600, 300);
        		mainWindow.setLocationRelativeTo(null);
        		mainWindow.setVisible(true);
                
            }
        });      
	
		
		sidePanel.add(dropDown);
		sidePanel.add(inputBox);
		sidePanel.add(goButton);
		
		sidePanel.add(scroll);
		sidePanel.add(header1);
		sidePanel.add(scroll2);
		sidePanel.add(backButton);
		
		treeDisplay.setPreferredSize(new Dimension(950,600));

		windowLayout.add(sidePanel, BorderLayout.WEST);
		windowLayout.add(treeDisplay, BorderLayout.EAST);
		
		
		
		getContentPane().add(windowLayout, BorderLayout.WEST);
	}
	
	public void addTree(DSLTtree t)
	{
		tree = t;
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{ 	
		if(dropDown.getSelectedIndex() == 0)
		{	String input = inputBox.getText();
			Integer insertVal = Integer.parseInt(input);	
			tree.insert(insertVal);
			inputBox.setText("");
			
			
			
		}
		
		if(dropDown.getSelectedIndex() == 1)
		{	String input = inputBox.getText();
			Integer removeVal = Integer.parseInt(input);	
			tree.delete(removeVal);
			inputBox.setText("");
			
		}
		
		treeDisplay.updateList();
		treeDisplay.repaint();
		infoBox.append(tree.getMessage());
		
	    
	}
}
