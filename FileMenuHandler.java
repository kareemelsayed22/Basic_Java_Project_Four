import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;
import java.util.Map.Entry;
import javax.swing.*;
public class FileMenuHandler implements ActionListener{
	JFrame jframe;
	public static TextFileInput inFile;
	public static String line;
   	public static UnsortedDate212List unsorted = new UnsortedDate212List();
   	public static TreeMap <Integer, Date212> sorted = new TreeMap <Integer, Date212>(new Date212Comparator());
	String  menuName;
	public static JTextArea UnsortedDates = new JTextArea(5,10);
	public static JTextArea SortedDates = new JTextArea(5,10);
	public static String ALLDATES;
	public FileMenuHandler (JFrame jf) {
	   jframe = jf;
	}
	public void actionPerformed(ActionEvent e) {
		menuName = e.getActionCommand(); // Will wait for user's input to then fill the string with user's input 
		if (menuName.equals("Open"))	//If user clicks on Open from File menu bar, it'll open the file chooser
			openFile(); 
		else if (menuName.equals("Quit"))	//If user clicks on Quit, the program will terminate
			System.exit(0);
	}
    private void openFile() {
        int status;				
        JFileChooser chooser = new JFileChooser(); //File chooser menu will prompt the user to look for a file to input
        status = chooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) // Checks if the input file is valid or if user cancelled
           readSource(chooser.getSelectedFile());
     }
    private void readSource(File chosenFile) {
        // getting File
        String chosenFileName = chosenFile.getName();
        inFile = new TextFileInput(chosenFileName);
        while ((line = inFile.readLine())!= null) {
        	StringTokenizer st = new StringTokenizer(line,",");
        	while(st.hasMoreTokens()) { //Will read the file
				String temp = st.nextToken(); 
				try {
					if(isValid(temp)) { //Check for validity to be input into both lists correctly
						Date212 tempDate = new Date212(temp);
						unsorted.add(tempDate);
						sorted.put(tempDate.toInt(), tempDate);
					}
					else throw new Date212Exception(); //If date is invalid, tell the user
				}
				catch (Date212Exception e) { //Display to console that the date is invalid and show it
					System.out.println(e.getMessage()+ temp);
				}
			}// end of second while
		} // end of first while 
		inFile.close(); //Close the file, it won't be needed again.
        UnsortedDates.setEditable(false);
        jframe.getContentPane().add(UnsortedDates);
        UnsortedDates.setText("Unsorted: \n");
		UnsortedDates.append(unsorted.toString()+ "\n");
		SortedDates.setEditable(false);
		jframe.getContentPane().add(SortedDates);
		SortedDates.setText("Sorted: \n");
		Set<Entry<Integer, Date212>> set = sorted.entrySet(); 
		Iterator<Entry<Integer, Date212>> i = set.iterator(); 
		Map.Entry <Integer,Date212> me;
		while(i.hasNext()) { 
		   me = (Map.Entry<Integer, Date212>)i.next(); 
		   SortedDates.append(me.getValue().toString());
		}
		jframe.pack();
		jframe.setVisible(true);
	}
    public static boolean isValid(String Date) { //Check validity of input date as a string before being input into lists
		int year = Integer.parseInt(Date.substring(0, 4)); //Turn the string into an integer for year
		if (year > 2018) return false; //Make sure the year from file isn't past our current year
		int month = Integer.parseInt(Date.substring(4, 6)); //Turn the string into an integer for month
		if (month > 12 || month < 0) return false;	//Make sure the month is a valid month from Jan. to Dec.
		int day = Integer.parseInt(Date.substring(6)); //Turn the string into an integer for day
		if (day < 0 || day > Date212.MaxDay[month-1]) return false; // Make sure the day is a valid day for it's month
		//MaxDay stores the maximum day the current month is and it's stored in the Date212 class
		return true; //Passed all validity checks, proceed to input date into lists
	}
}
