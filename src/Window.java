import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JComboBox<String> dropDown = new JComboBox<String>();
	JTextField inputBox = new JTextField(20);
	JButton goButton = new JButton("Go");
	JButton backButton = new JButton("Back");
	JTextArea infoBox = new JTextArea(10,20);
	JTextArea updateBox = new JTextArea(25,20);
	JLabel header1 = new JLabel("--------------");
	DSLTcanvas treeDisplay = new DSLTcanvas();
	
	public Window()
	{
		super("Tree Visualisation - Term Project");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
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
		
		treeDisplay.setPreferredSize(new Dimension(900,600));
		List<Node> nodeList = new ArrayList<Node>();
		Node node1 = new Node(2000);
		Node node2 = new Node(1000);
		Node node3 = new Node(3000);
		node2.setColorRed();
		nodeList.add(node1);
		nodeList.add(node2);
		nodeList.add(node3);
		treeDisplay.updateList(nodeList);
		
		windowLayout.add(sidePanel, BorderLayout.WEST);
		windowLayout.add(treeDisplay, BorderLayout.EAST);
		
		getContentPane().add(windowLayout, BorderLayout.WEST);
	}
}
