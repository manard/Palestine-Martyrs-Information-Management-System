import java.util.Date;

public class DateStack {
	private Date date;
	private Stack stack;

	public DateStack() {

	}

	public DateStack(Date date) {
		this.date = date;
		this.stack = new Stack();
	}

	public Date getDate() {
		return date;
	}

	public Stack getStack() {
		return stack;
	}

	@Override
	public String toString() {
		return "In Date: " + date + ",\n" + stack.toString() + "\n";
	}

}