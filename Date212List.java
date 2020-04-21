public abstract class Date212List {
	protected Date212Node first;
	protected Date212Node last;
	private int length = 0;
	
	public Date212List() {
		Date212Node head = new Date212Node(null);
		first = head;
		last = head;
	}
	
	public void append (Date212 d) {
		  Date212Node n = new Date212Node(d);
		  last.Next = n;
		  last = n;
		  length++;
	}
	public void insert(Date212 d) {
		Date212Node temp = first;
		while (temp.Next != null && temp.Next.Data.toInt() < d.toInt()) {
			temp = temp.Next;
		}
		if (temp.Next == null) {
			append(d);
		}
		else {
			Date212Node NodeNext = temp.Next;
			Date212Node NodeIn = new Date212Node(d);
			NodeIn.Next = NodeNext;
			temp.Next = NodeIn;
			length++;
		}
	}
	public String toString() {
		String s = "";
		Date212Node temp = first.Next;
		while(temp != null) {
			s += temp.Data.toString();
			temp = temp.Next;
		}
		return s;
	}
}
