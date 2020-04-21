/* This project will do the following
 * 1) Execute with an input file called Input.txt which as stored dates
 * 2) The Program will read a dates and accept those with the proper format. If any dates aren't in the proper format,
 * 	the console will print the input date, tell the user it's invalid and not store the date. 
 * 3) Once read and checked, the program will store the input date into a dynamic structure and a sorted map tree. 
 * 	The map tree will always be sorted from the smallest date (2000) to the largest date (2018) and the dynamic structure 
 * will be store from the first date read (from the file) to the last date (read from the file).
 * 4) Once both structures are filled, the program will generate a GUI to display to the unsorted dates on the left
 * 	of the GUI and the sorted dates on the right of the GUI
 * 5)The user has the option to insert their own date by choosing "Insert" from the edit menu. Thus inserting the date if
 * if valid and following the same rules as before. 
 * 6) Once the GUI is closed, the program will be completed. Thus terminated.
 */
public class Project4{
	//This project uses the given TextFileInput class	   
	public static void main (String[]args) {
		DateGUI Output = new DateGUI(); //Calls DateGUI constructor to do everything else in this project 
	}
}