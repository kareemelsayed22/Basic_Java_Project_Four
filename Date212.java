public class Date212 {
	private int dd;
	private int mm;
	private int yyyy;
	public final static int[] MaxDay = {31, 28, 29, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // stored for validity check
	
	public Date212(String Date) { //Still will create the instance of the input string date and store it as integers.
		yyyy = Integer.parseInt(Date.substring(0, 4));
		mm = Integer.parseInt(Date.substring(4, 6));
		dd = Integer.parseInt(Date.substring(6));
	}
	public String toString(){ // This method is used to convert the stored integers into their proper date format
		String s = "";
		if (mm < 10) 
			s += "0" + mm + "/";
		else 
			s += mm + "/";
		if (dd < 10)
			s += "0" + dd + "/";
		else 
			s += dd + "/";
		s += yyyy + "\n";
		return s;
	}
	public int toInt() {	//This method is used to compare dates by converting it into an integer with it's 
		//proper date format
		return yyyy*10000 + mm *100 + dd;
	}
}
