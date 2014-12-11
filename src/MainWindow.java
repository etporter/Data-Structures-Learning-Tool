import java.awt.*;

import javax.swing.*;

public class MainWindow extends JFrame
{
	public MainWindow()
	{
		super("Data Structure Visualizations - A Learning Tool");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel windowLayout = new JPanel();
		
		JLabel title = new JLabel("Please select a type of data structure:");
		title.setFont(new Font("Serif", Font.BOLD, 30));
		
		JComboBox<String> typeSelector = new JComboBox<String>();
		String[] commands = {"AVL Tree","Red-Black Tree","Binary Heap - Min"};
		for(int i=0; i<commands.length; i++)
		{
			typeSelector.addItem(commands[i]);
		}
		
		JButton goButton = new JButton("Go!");
		
		windowLayout.add(title);
		windowLayout.add(typeSelector);
		windowLayout.add(goButton);
		getContentPane().add(windowLayout);
	}
}