import java.text.SimpleDateFormat;
import java.util.Date;

public class Martyrobject {
	private int Age;
	private String Name;
	private Date DateOfDeth;
	private char Gender;

	public Martyrobject() {

	}

	public Martyrobject(String name, int age, Date DateOfDeth, char gender) {
		super();
		this.Age = age;
		this.Name = name;
		this.DateOfDeth = DateOfDeth;
		this.Gender = gender;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Date getDateOfDeth() {
		return DateOfDeth;
	}

	public void setDateOfDeth(Date dateOfDeth) {
		DateOfDeth = dateOfDeth;
	}

	public char getGender() {
		return Gender;
	}

	public void setGender(char gender) {
		Gender = gender;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
		String formattedDate = dateFormat.format(DateOfDeth);
		return "" + Name + "," + Age + "," + formattedDate + "," + Gender + "";
	}

	public String toString2() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
		String formattedDate = dateFormat.format(DateOfDeth);
		return "DateOfDeth: " + formattedDate + "";
	}

}
