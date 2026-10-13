package Grup1;

public class Student {
	// default values---- String null , int 0 , double 0.0 boolean false 
	
	// encapsulation --- 
	private String name ;  // instance variables , fields , properties
	private int birthYear ;
	private String email ;
	private double average ;
	
	
	
	// accessor - modifier methods 
	// getter - setter methods 
	
	// set methods -> mutator - modifier methods
	// get methods -> accesor methods 
	// stu1.setName("Mehmet Can");
	public void setName(String myName)
	{
		if(myName.length() == 0) {
			System.out.println("Invalid name!");
		} else {
			name = myName;
		}
	}
	public void setMail(String mail)
	{
		if(mail.length() == 0) {
			System.out.println("Invalid mail!");
		} else if (mail.indexOf("@") <= 0) {
			System.out.println("Invalid mail!");

		}
		else {
			email = mail;
		}
	}
	public void setYear(int y) {
		if(y > 1900 && y <= 2026) {
			birthYear = y ;
		}
		else {
			System.out.println("Invalid value!");
		}
	}
	public void setAvg(double avg) {
		if(avg < 0 || avg > 100) {
			System.out.println("Invalid value!");
		} else {
			average = avg ;
		}
	}
	
	
	public String getName()
	{
		return name;
	}
	public String getMail() {
		return email;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public double getAverage() {
		return average;
	}
	
	public int calculateAge() {
		return 2026 - birthYear;
	}
	
	public void printStudentInfos() {
		System.out.println("*****STUDENT INFOS=====");
		System.out.println("Student's name: " + name);
		System.out.println("Student's age: " + calculateAge());
		System.out.println("Student's mail: " + email);
		System.out.println("Student's average: " + average);
	}
	
	
	
}
