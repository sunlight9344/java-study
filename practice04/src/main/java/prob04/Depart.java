package prob04;

public class Depart extends Employee {
	
	String department;

	public Depart(String name, int salary, String department) {
		super(name,salary);
		this.department = department;
	}
	
	@Override
	public void getInformation() {
		System.out.println(
			"이름: " + super.getName() +
			"    연봉: " + super.getSalary() +
			"    부서: " + this.department
		);
	}
}
