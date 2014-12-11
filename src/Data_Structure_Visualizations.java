import java.util.List;

public class Data_Structure_Visualizations {

	public static void main (String[] args)
	{ 
		MainWindow mainWindow = new MainWindow();
		mainWindow.setSize(1250,750);
		mainWindow.setVisible(true);
	}
	
	private void startTreeWindow(String treeType)
	{
		// Creates new Window, and sets to visible
		Window thisWindow = new Window(treeType);
		thisWindow.setSize(1250,750);
		thisWindow.setVisible(true);
	}
}
