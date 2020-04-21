import java.awt.*;
import javax.swing.*;

public class DateGUI extends JFrame{
	/**
	 * This class, when created, will create a GUI and display the sorted list on the right of the GUI window 
	 * and the unsorted list on the left of the GUI window. 
	 */
	private static final long serialVersionUID = 1L;
	public DateGUI(){
		super("Project 4"); // Calls JFrame super to construct a title GUI
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(100,100);//x, y);
        createFileMenu();	//Creates a File menu for the GUI
        this.setLayout(new GridLayout(1,2));
        this.pack();
		this.setVisible(true);
	}
    private void createFileMenu( ) {
        JMenuBar    menuBar  = new JMenuBar();		//Creates a menu bar which will be displayed on upper GUI
        JMenu       fileMenu = new JMenu("File");	//Displays File in menu bar when GUI is shown 
        JMenu		EditMenu = new JMenu("Edit");
        JMenuItem   item;							//Holds the items that will be in the File Menu
        JMenuItem	Edit;
        FileMenuHandler fmh = new FileMenuHandler(this);
        EditMenuHandler emh = new EditMenuHandler(this);
        item = new JMenuItem("Open");   // adds title for menu item
        item.addActionListener( fmh );	// When clicked, it will look for a file
        fileMenu.add( item );			// Adds the Open option to the item bar for when File is clicked on GUI
        fileMenu.addSeparator();        // add a horizontal separator line      
        item = new JMenuItem("Quit");   // adds quit title for menu item
        item.addActionListener( fmh );	// When clicked, it will terminate the program        
        fileMenu.add( item );			// Adds the Quit option to the item bar for when Open is clicked on GUI
        Edit = new JMenuItem("Insert");
        Edit.addActionListener(emh);
        EditMenu.add(Edit);
        setJMenuBar(menuBar);			// Menu bar is attacked to GUI and will be displayed when GUI is displayed
        menuBar.add(fileMenu);			// Adds File to the menu bar
        menuBar.add(EditMenu);
      
     } 
}