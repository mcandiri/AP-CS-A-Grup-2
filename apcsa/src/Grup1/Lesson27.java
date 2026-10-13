package Grup1;

public class Lesson27 {

	public static void main(String[] args) {
		
		
		String name = "mehmet can" ; 
		int age = 34 ;
		
		
		
		String name2 = "ali" ;
		int age2 = 17 ;
		
		// Students --> class 
		
		// name  birthday  school email (properties)
//         selin  2010	               (OBJECT) 
//         ruzgar  ..    ..  ..
		
		
		// stu1 -> instance , object 
		Student stu1 = new Student();
		
		
//		stu1.name = "Mehmet can";
//		stu1.birthYear = 1992 ;
//		stu1.email = "mehmetcandiri@gmail.com";
//		stu1.average = 34.67 ;
		System.out.println("Student's name: " + stu1.getName());
		stu1.setName("");
		System.out.println("Student's name: " + stu1.getName());

		stu1.setName("Ahmet");
		stu1.setMail("@sdfjds.com");
		System.out.println("Student's name: " + stu1.getName());
		System.out.println("Student's mail: " + stu1.getMail());
		stu1.setMail("asjkdsajk.sdfjds.com");
		System.out.println("Student's mail: " + stu1.getMail());
		stu1.setMail("asjkdsajk@sdfjds.com");
		System.out.println("Student's mail: " + stu1.getMail());
		stu1.setAvg( 67.9);
		stu1.setYear(2000);
		Student stu2 = new Student();
//		stu2.name = ""; 
//		stu2.birthYear = -1234 ;
//		if(stu2.birthYear < 0)
//		{
//			System.out.println("Invalid birth year!");
//		}
//		
//		stu2.birthYear = -3 ;
//		stu2.email = "ödmns";
//		stu2.average = -34.56;
		
		
		// public  --  private 
		
		
		stu2.setName("Mehmet");
		stu2.setMail("mehmet@gmail.com");
		stu2.setAvg(77.9);
		stu2.setYear(1992);
		
		
		
		stu2.printStudentInfos();
		stu1.printStudentInfos();
	}

		
}
