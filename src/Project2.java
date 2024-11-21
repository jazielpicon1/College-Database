import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

class IdException extends Exception {
	private String message;
	
	public IdException () {
		message = "\tInvalid ID format. Must be LetterLetterDigitDigitDigitDigit\n\n";
		}
	public String getMessage () {
		return message;
	}
	public String toString () {
		return message;
	}
}

public class Project2 {

	private static String menu() {
		String option;
		System.out.println("1-Enter the information of a faculty member");
		System.out.println("2-Enter information of a student");
		System.out.println("3-Print tuition invoice");
		System.out.println("4-Print faculty information");
		System.out.println("5-Enter the information of a staff member");
		System.out.println("6-Print the information of a staff member");
		System.out.println("7-Exit Program\n");

		System.out.print("\tEnter your selection: ");
		option = (new Scanner(System.in)).nextLine();
		return option;
		}
	
	

public static void main(String[] args)  throws Exception {
	String option;
	String data;
	Scanner myScan = new Scanner(System.in);
	Person people [] = new Person [100];
	int creditHours = 0;
	int i = 0;
	String name, id, department, rank, status;
	double gpa = 0.0;
	do {
		option = menu();
		switch(option) {
		
		case "1" :
			System.out.println("\nEnter the faculty info:");
			System.out.print("\tName of the faculty: ");
			name = myScan.nextLine();
			
			boolean checkId = false;
			do
			{
			System.out.print("\tID: ");
			id = myScan.nextLine();
			try {
				Integer.parseInt(id.substring(2 , 6));
				if((!(id.substring(0 , 1).matches("[a-zA-z]+" ))) || (id.length() != 6)) {
					throw new IdException();
				}
				checkId = true;
			}
			catch(Exception e) {
				System.out.println("\tInvalid ID format. Must be LetterLetterDigitDigitDigitDigit\n\n" );
			}
			
			} while(checkId == false);
			
			System.out.print("\n\n\tRank: ");
			rank = myScan.nextLine();
			while(!rank.equalsIgnoreCase("professor") && !rank.equalsIgnoreCase("adjunct")) {
				System.out.println("\t\t"+ '"' + rank + '"' + " is invalid \n\n");
				System.out.print("\tRank: ");
				rank = myScan.nextLine();
					        }
			
			System.out.print("\n\n\tDepartment: ");
			department = myScan.nextLine();
			while(!department.equalsIgnoreCase("mathematics") && !department.equalsIgnoreCase("engineering") && !department.equalsIgnoreCase("sciences")) {
				System.out.println("\t\t" +'"' + department + '"' + " is invalid \n\n");
				System.out.print("\tDepartment: ");
				department = myScan.nextLine();
					        }
			rank = rank.substring(0 , 1).toUpperCase() + rank.substring(1);
			department = department.substring(0 , 1).toUpperCase() + department.substring(1);
			people[i] = new Faculty(name, id, department, rank);
			i++;
			System.out.println("\nFaculty added!\n");
			break;
		case "2" :
			System.out.println("\nEnter the Student info:");
			System.out.print("\tName of Student: ");
			name = myScan.nextLine();
			
			checkId = false;
			do
			{
			System.out.print("\tID: ");
			id = myScan.nextLine();
			try {
				Integer.parseInt(id.substring(2 , 6));
				if((!(id.substring(0 , 1).matches("[a-zA-z]+" ))) || (id.length() != 6)) {
					throw new IdException();
				}
				checkId = true;
			}
			catch(Exception e) {
				System.out.println("\tInvalid ID format. Must be LetterLetterDigitDigitDigitDigit\n\n" );
			}
			
			} while(checkId == false);
			
			System.out.print("\tGpa: ");
			boolean isGpa = false;
			while(isGpa == false)
			{
				try {
					double checkGpa = Double.parseDouble(myScan.nextLine());
					isGpa = true;
					gpa = checkGpa;
				}
				catch(NumberFormatException e) {
					System.out.println("\n\tError! Please enter a valid GPA.\n");
					System.out.print("\tGpa: ");
				}
			}
			
			
			System.out.print("\tCredit hours: ");
			boolean isCreditHours = false;
			while(isCreditHours == false)
			{
				try {
					int checkCreditHours = Integer.parseInt(myScan.nextLine());
					isCreditHours = true;
					creditHours = checkCreditHours;
				}
				catch(NumberFormatException e) {
					System.out.println("\n\tError! Please enter valid credit Hours.\n");
					System.out.print("\tCredit hours: ");
				}
			}
			
			people[i] = new Student(name, id, gpa, creditHours);
			i++;
			System.out.println("\nStudent added!\n");
			break;
		case "3" :
			System.out.print("\nEnter the student’s id: ");
			id = myScan.nextLine();
			
			for(int index = 0; index < 100; index++) {
				if(people[index] == null) {
					System.out.println("No student matched!\n\n");
					break;
				}
				if(id.equals(people[index].getId())) {
					System.out.println("Here is the tuition invoice for " + ((Student) people[index]).getFullName() +  ":" );
					((Student) people[index]).print();
					break;
				}
				
			}
			break;
		case "4" :
			System.out.print("\nEnter the Faculty’s id: ");
			id = myScan.nextLine();
			
			for(int index = 0; index < 100; index++) {
				if(people[index] == null) {
					System.out.println("No Faculty matched!\n\n");
					break;
				}
				if(id.equals(people[index].getId())) {
					((Faculty) people[index]).print();
					break;
				}
				
			}
			break;
		case "5" :
			System.out.print("\nName of the staff member: ");
			name = myScan.nextLine();
			
			checkId = false;
			do
			{
			System.out.print("Enter the ID: ");
			id = myScan.nextLine();
			try {
				Integer.parseInt(id.substring(2 , 6));
				if((!(id.substring(0 , 1).matches("[a-zA-z]+" ))) || (id.length() != 6)) {
					throw new IdException();
				}
				checkId = true;
			}
			catch(Exception e) {
				System.out.println("\tInvalid ID format. Must be LetterLetterDigitDigitDigitDigit\n\n" );
			}
			
			} while(checkId == false);
			
			System.out.print("Department: ");
			department = myScan.nextLine();
			while(!department.equalsIgnoreCase("mathematics") && !department.equalsIgnoreCase("engineering") && !department.equalsIgnoreCase("sciences")) {
				System.out.println("\t\t" +'"' + department + '"' + " is invalid \n\n");
				System.out.print("\tDepartment: ");
				department = myScan.nextLine();
			}
			
			System.out.print("Status, Enter P for Part Time, or Enter F for Full Time: ");
			status = myScan.nextLine();
			while(!status.equalsIgnoreCase("P") && !status.equalsIgnoreCase("F")) {
				System.out.println("\t\t"+ '"' + status + '"' + " is invalid \n\n");
				System.out.print("\tStatus, Enter P for Part Time, or Enter F for Full Time: ");
				status = myScan.nextLine();
					        }
			if (status.equalsIgnoreCase("P")) {
				status = "Part Time";
			}
			else {
				status = "Full Time";
			}
			department = department.substring(0 , 1).toUpperCase() + department.substring(1);
			people[i] = new Staff(name, id, department, status);
			i++;
			System.out.println("\nStaff member added!\n");
			break;
		case "6" :
			System.out.print("\nEnter the Staff’s id: ");
			id = myScan.nextLine();
			
			for(int index = 0; index < 100; index++) {
				if(people[index] == null) {
					System.out.println("No Staff member matched!\n\n");
					break;
				}
				if(id.equals(people[index].getId())) {
					((Staff) people[index]).print();
					break;
				}
				
			}
			break;
		case "7" :
			System.out.print("\nWould you like to create the report? (Y/N):");
			String choice = myScan.nextLine();
			while (!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N")) {
				System.out.println("\t\tIncorrect input! Please enter Y or N\n\n");
				System.out.print("Would you like to create the report? (Y/N):");
				choice = myScan.nextLine();
			}
			if (choice.equalsIgnoreCase("y")) {
				System.out.println("Report created and saved on your hard drive!");
				File file = new File ("report.txt");
				PrintWriter myWriter = new PrintWriter("report.txt");
				myWriter.write("Faculty Members\n");
				myWriter.write("-------------------------\n");
				int index = 0;
				int listOrder = 0;
				while((people[index] != null)) {
					if(people[index] instanceof Faculty) {
						myWriter.write("\t" + (listOrder + 1) + ". " + ((Faculty) people[index]).getFullName() + "\n");
						myWriter.write("\tId: " + ((Faculty) people[index]).getId() + "\n");
						myWriter.write("\t" +((Faculty) people[index]).getRank() + "," + ((Faculty) people[index]).getDepartment() + "\n\n");
						listOrder++;
					}
					index++;
				}
				
				myWriter.write("\nStaff Members\n");
				myWriter.write("------------------- \n");
				index = 0;
				listOrder = 0;
				while((people[index] != null)) {
					if(people[index] instanceof Staff) {
						myWriter.write("\t" + (listOrder + 1) + ". " + ((Staff) people[index]).getFullName() + "\n");
						myWriter.write("\tId: " + ((Staff) people[index]).getId() + "\n");
						myWriter.write("\t" + ((Staff) people[index]).getDepartment() + "," + ((Staff) people[index]).getStatus() + "\n\n");
						listOrder++;
					}
					index++;
				}
				
				myWriter.write("\nStudents\n");
				myWriter.write("-----------\n");
				index = 0;
				listOrder = 0;
				while((people[index] != null)) {
					if(people[index] instanceof Student) {
						myWriter.write("\t" + (listOrder + 1) + ". " + ((Student) people[index]).getFullName() + "\n");
						myWriter.write("\tId: " + ((Student) people[index]).getId() + "\n");
						myWriter.println("\tGpa: " + ((Student) people[index]).getGpa());
						myWriter.write("\tCredit Hours: " + ((Student) people[index]).getCreditHours() + "\n\n");
						listOrder++;
					}
					index++;
				}
				myWriter.close();
			}
			System.out.println("\n\nGoodbye!");
			break;
		default :
			System.out.println("\nInvalid entry- please try again\n\n");
			break;
		}
	}while (!option.equals("7"));
}//end of main

}//end of main class


abstract class Person {
private String fullName;
private String id;

public String getFullName() {
	return fullName;
}

public void setFullName(String fullName) {
	this.fullName = fullName;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public Person() {
	this.fullName = "NULL";
	this.id = "0";
}

public Person(String fullName, String id) {
	this.fullName = fullName;
	this.id = id;
}

@Override
public String toString() {
	return fullName + "\t\t\t" + id;
}

public abstract void print();
}// end of person

class Student extends Person {
 private double gpa;
 private int creditHours;
 
public double getGpa() {
	return gpa;
}

public void setGpa(double gpa) {
	this.gpa = gpa;
}

public int getCreditHours() {
	return creditHours;
}

public void setCreditHours(int creditHours) {
	this.creditHours = creditHours;
}

public Student() {
	super();
	this.gpa = 0.0;
	this.creditHours = 0;
}

public Student(String fullName, String id, double gpa, int creditHours) {
	super(fullName, id);
	this.gpa = gpa;
	this.creditHours = creditHours;
}

private double generateTuitionInvoice(double gpa, int creditHours) {
		double payment = (creditHours * 236.45) + 52; 
		 return payment;

}

@Override
public void print() {
	double finalPayment = generateTuitionInvoice(gpa,creditHours);
	double deduction = (finalPayment * 0.25);
	System.out.println("\n--------------------------------------------------------------------------- ");
	System.out.println(super.toString());
	System.out.println("Credit Hours:" + creditHours + " ($236.45/credit hour)");
	System.out.println("Fees: $" + 52);
	if (gpa < 3.85) {
		System.out.println("\n\nTotal payment (after discount): $" + finalPayment + "\t($0 discount applied)");
	}
	else {
		System.out.println("\n\nTotal payment (after discount): $" +  (finalPayment - deduction) + "\t"  + "($" + deduction + " discount applied)");
	}
	System.out.println("--------------------------------------------------------------------------- \n\n");
}

@Override
public String toString() {
	return super.toString() + "gpa: "+  gpa + "Total credit hours: " + creditHours;
}
}//end of student

abstract class Employee extends Person {
  private String department;

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

public Employee() {
	super();
	this.department = "NULL";
}

public Employee(String fullName, String id, String department) {
	super(fullName, id);
	this.department = department;
}

@Override
public String toString() {
	return super.toString() + "\n" + department + " Department";
}

}//end of employee

class Faculty extends Employee {
  private String rank;

public String getRank() {
	return rank;
}

public void setRank(String rank) {
	this.rank = rank;
}

public Faculty() {
	super();
	this.rank = "NULL";
}

public Faculty(String fullName, String id, String department, String rank) {
	super(fullName, id, department);
	this.rank = rank;
}

@Override
public String toString() {
	return super.toString() + "[Rank:" + rank + "]";
}

public void print() {
	System.out.println("\n--------------------------------------------------------------------------- ");
	System.out.println(super.toString() + ", " + rank);
	System.out.println("\n--------------------------------------------------------------------------- ");
}

}//end of Faculty

class Staff extends Employee {
  private String status;

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public Staff() {
	super();
	this.status = "NULL";
}

public Staff(String fullName, String id, String department, String status) {
	super(fullName, id, department);
	this.status = status;
}

@Override
public String toString() {
	return super.toString() + "[status:" + status + "]";
}

public void print() {
	System.out.println("\n--------------------------------------------------------------------------- ");
	System.out.println(super.toString() + ", " + status);
	System.out.println("\n--------------------------------------------------------------------------- ");
	}
}

