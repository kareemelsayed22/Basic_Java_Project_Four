import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.*;
public class EditMenuHandler implements ActionListener{
	JFrame jframe;
	String  menuName;
	public EditMenuHandler(JFrame jf) {
		jframe = jf;
	}
	public void actionPerformed(ActionEvent e) {
		menuName= e.getActionCommand();
		if (menuName.equals("Insert")){
			String temp = JOptionPane.showInputDialog("Input a date yyyymmdd");
			try {
				if(FileMenuHandler.isValid(temp)) { //Check for validity to be input into both lists correctly
					Date212 tempDate = new Date212(temp);
					FileMenuHandler.unsorted.add(tempDate);
					FileMenuHandler.sorted.put(tempDate.toInt(), tempDate);
				}
				else throw new Date212Exception(); //If date is invalid, tell the user
			}
			catch (Date212Exception e1) { 
				System.out.println(e1.getMessage()+ temp);
			}
		}
		JTextArea UnsortedDates = FileMenuHandler.UnsortedDates;
        UnsortedDates.setEditable(false);
        jframe.getContentPane().add(UnsortedDates);
        UnsortedDates.setText("Unsorted: \n");
		UnsortedDates.append(FileMenuHandler.unsorted.toString()+ "\n");
		JTextArea SortedDates = FileMenuHandler.SortedDates;
		SortedDates.setEditable(false);
		jframe.getContentPane().add(SortedDates);
		SortedDates.setText("Sorted: \n");
		Set<Entry<Integer, Date212>> set = FileMenuHandler.sorted.entrySet(); 
		Iterator<Entry<Integer, Date212>> i = set.iterator(); 
		Map.Entry <Integer,Date212> me;
		while(i.hasNext()) { 
		   me = (Map.Entry<Integer, Date212>)i.next(); 
		   SortedDates.append((me.getValue()).toString());
		}
		jframe.pack();
		jframe.setVisible(true);
	}
}