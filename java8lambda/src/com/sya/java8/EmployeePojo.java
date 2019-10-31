/**
 * 
 */
package com.sya.java8;

/**
 * @author sammar
 *
 */
public class EmployeePojo {

	private long empId;
	private String firstName;
	private String lastName;
	private int age;

	public EmployeePojo(long empId, String firstName, String lastName, int age) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}


	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "EmployeePojo{" +
				"empId=" + empId +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", age=" + age +
				'}';
	}
}
