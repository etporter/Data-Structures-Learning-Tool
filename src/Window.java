import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Window extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JComboBox<String> dropDown = new JComboBox<String>();
	JTextField inputBox = new JTextField(20);
	JButton goButton = new JButton("Go");
	JButton backButton = new JButton("Back");
	JTextArea infoBox = new JTextArea(10,20);
	JTextArea updateBox = new JTextArea(25,20);
	JLabel header1 = new JLabel("Rotation Descriptions");
	DSLTcanvas treeDisplay = new DSLTcanvas();
	DSLTtree tree;
	
	public Window(String treeType)
	{
		super(treeType);
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
		
		goButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int newLabel = Integer.parseInt(inputBox.getText());
				tree.insert(newLabel);
			}
		});
		
		treeDisplay.setPreferredSize(new Dimension(950,600));
		List<Node> nodeList = new ArrayList<Node>();
		Node node1 = new Node(50);
		Node node2 = new Node(30);
		Node node3 = new Node(70);
		Node node4 = new Node(26);
		Node node5 = new Node(37);
		Node node6 = new Node(55);
		Node node7 = new Node(76);
		Node node8 = new Node(17);
		Node node9 = new Node(28);
		Node node10 = new Node(35);
		Node node11 = new Node(46);
		Node node12 = new Node(53);
		Node node13 = new Node(60);
		Node node14 = new Node(72);
		Node node15 = new Node(80);
		Node node16 = new Node(15);
		Node node17 = new Node(20);
		Node node18 = new Node(27);
		Node node19 = new Node(29);
		Node node20 = new Node(31);
		Node node21 = new Node(20);
		Node node22 = new Node(21);
		Node node23 = new Node(22);
		Node node24 = new Node(23);
		Node node25 = new Node(24);
		Node node26 = new Node(25);
		Node node27 = new Node(26);
		Node node28 = new Node(27);
		Node node29 = new Node(28);
		Node node30 = new Node(29);
		Node node31 = new Node(30);
		nodeList.add(node1);
		nodeList.add(node2);
		nodeList.add(node3);
		nodeList.add(node4);
		nodeList.add(node5);
		nodeList.add(node6);
		nodeList.add(node7);
		nodeList.add(node8);
		nodeList.add(node9);
		nodeList.add(node10);
		nodeList.add(node11);
		nodeList.add(node12);
		nodeList.add(node13);
		nodeList.add(node14);
		nodeList.add(node15);
		nodeList.add(node16);
		nodeList.add(node17);
		nodeList.add(node18);
		nodeList.add(node19);
		nodeList.add(node20);
		/*nodeList.add(node21);
		nodeList.add(node22);
		nodeList.add(node23);
		nodeList.add(node24);
		nodeList.add(node25);
		nodeList.add(node26);
		nodeList.add(node27);
		nodeList.add(node28);
		nodeList.add(node29);
		nodeList.add(node30);
		nodeList.add(node31);*/
		treeDisplay.updateList(nodeList);
		
		windowLayout.add(sidePanel, BorderLayout.WEST);
		windowLayout.add(treeDisplay, BorderLayout.EAST);
		
		getContentPane().add(windowLayout, BorderLayout.WEST);
	}
	public void addTree(DSLTtree t)
	{
		tree = t;
	}
}
