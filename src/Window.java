import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Window extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	JComboBox<String> dropDown = new JComboBox<String>();
	JTextField inputBox = new JTextField(20);
	JButton goButton = new JButton("Go");
	JButton backButton = new JButton("Back");
	JTextArea infoBox = new JTextArea(10,20);
	JTextArea updateBox = new JTextArea(25,20);
	JLabel header1 = new JLabel("Rotation Descriptions");
	DSLTcanvas treeDisplay;// = new DSLTcanvas();
	DSLTtree tree;
	
	public Window(int treeType)
	{

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
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
		}
		
		else if(treeType == 3)
		{
			tree = new BST();
		}
		
		treeDisplay = new DSLTcanvas(tree);
		
		JPanel windowLayout = new JPanel();
		JPanel sidePanel = new JPanel();
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));

		String[] commands = {"Insert","Delete"};
		
		for(int i=0; i<commands.length; i++)
		{
			dropDown.addItem(commands[i]);
		}
		
		dropDown.setAlignmentX(Component.CENTER_ALIGNMENT);
		inputBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		goButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		goButton.addActionListener(this);
		infoBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		header1.setAlignmentX(Component.CENTER_ALIGNMENT);
		updateBox.setAlignmentX(Component.CENTER_ALIGNMENT);
		backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		sidePanel.add(dropDown);
		sidePanel.add(inputBox);
		sidePanel.add(goButton);
		
		sidePanel.add(infoBox);
		sidePanel.add(header1);
		sidePanel.add(updateBox);
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
