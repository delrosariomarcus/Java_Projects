/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_StudentInfoSystem;

import java.util.Scanner;

/**
 *
 * @author delro
 */
public class StudentInfoSystemProg 
{
   public static void main(String[]args)
   {
       StudentInfoSystem myList = new StudentInfoSystem();
       myList.addStudents("11111111", "Del Rosario", "Marcus", "5805551520", "Computer Science", 3.9, 
           2001, 03, 03, "1601 N 3rd Ave.");
       myList.addStudents("22222222", "Myers", "Yasmine", "5801234256", "Psychology", 4.0, 
               1999, 9, 27, "425 W. University Blvd.");
       myList.addStudents("33333333", "Nelson", "Brian", "5802345678", "Health and Wellness", 
               3.7, 1970, 1, 1, "1240 Main Street");
       myList.addStudents("44444444", "Naraya", "Gen", "5803456789", "Graphic Design", 
               3.8, 2000, 5, 7, "College Inn");
       myList.addStudents("55555555", "Ncube", "Thabo", "5804567890", "Business Management", 
               3.5, 2001, 8, 11, "Shearer Hall");
   
    Scanner scanner = new Scanner (System.in);
    
    String select ="yup";
       while(select!="")
       {
           System.out.println("================================================================");
           System.out.println("Please enter the following options");
           System.out.println("\ta) Enter a new student record" );
           System.out.println("\tb) delete a record by giving 8-digit ID number");
           System.out.println("\tc) List all students in the system");
           System.out.println("\td) Sort the database");
           System.out.println("\te) List students in a given ID or major");
           System.out.println("Enter the letter of choice (e.g., a) or -1 to end program");
           System.out.println("================================================================\n");
           System.out.print("=>" + " ");
           select = scanner.nextLine();
           
           switch (select)
           {
               case "a":
                   System.out.println("Enter the eight digit student ID: ");
                   String id = scanner.nextLine();
                   System.out.println("Enter student's last name: ");
                   String ln = scanner.nextLine();
                   System.out.println("Enter student's first name: ");
                   String fn = scanner.nextLine();
                   System.out.println("Enter students phone number: ");
                   String phone = scanner.nextLine();
                   System.out.println("Enter student's major");
                   String mj = scanner.nextLine();
                   System.out.println("Enter student's GPA");
                   double gp = scanner.nextDouble();
                   System.out.println("Enter student's birth year");
                   int yr = scanner.nextInt();
                   System.out.println("Enter student's birth month");
                   int mn = scanner.nextInt();
                   System.out.println("Enter student's day of birth");
                   int dy = scanner.nextInt();
                   scanner.nextLine();
                   System.out.println("Enter student's home address");
                   String addr = scanner.nextLine();
                   
                   myList.addStudents(id, ln, fn, phone, mj, gp, yr, mn, dy, addr);
                   break;
               case "b":
                   System.out.println("Enter the desired 8-digit ID number for deletion: ");
                   String s_id = scanner.nextLine();
                   System.out.println(myList.deleteStudent(s_id));
                   break;
               case "c":
                   System.out.println(myList.toString());
                   break;
               case "d":
                   System.out.println("Sort in ascending or descending: ");
                   System.out.println("Type\n a = Ascending \n d= Descending");
                   System.out.print("=>" + " ");
                   char dec = scanner.next().charAt(0);
                   System.out.println("Sort by ID, GPA, birthday: ");
                   System.out.println("Type\n 1=ID \n 2=GPA \n 3=birthday");
                   System.out.print("=>" + " ");
                   char var = scanner.next().charAt(0);
                   String choice = "";
                   String by = "";
                   
                   if (dec =='a')
                   {
                       choice = "ascending";
                       if (var=='1')
                       {
                           by = "ID";
                           myList.sortList(choice, by);
                       }
                       else if (var =='2')
                       {
                           by = "GPA";
                           myList.sortList(choice, by);
                       }
                       else if (var =='3')
                       {
                           by = "Birthday";
                           myList.sortList(choice, by);
                       }
                       scanner.nextLine();
                   }
                   else if (dec == 'd')
                   {
                       choice = "descending";
                       if (var=='1')
                       {
                           by = "ID";
                           myList.sortList(choice, by);
                       }
                       else if (var =='2')
                       {
                           by = "GPA";
                           myList.sortList(choice, by);
                       }
                       else if (var =='3')
                       {
                           by = "Birthday";
                           myList.sortList(choice, by);
                       } 
                       scanner.nextLine();
                   }
                   else
                   {
                       System.out.println("Error");
                       scanner.nextLine();
                   }
                   break;
               case "e":
                   System.out.println("List by ID or major: ");
                   System.out.println("Type \n i = ID \n m = major");
                   System.out.print("=>" + " ");
                   char in= scanner.next().charAt(0);
                   String list;
                   String sel;
                   if (in=='i')
                   {
                       scanner.nextLine();
                       System.out.println("Enter the 8-digit ID number: ");
                       sel = scanner.nextLine();
                       list = "StudentID";
                       myList.listStudent(list, sel);
                       break;
                   }
                   else if (in=='m')
                   {
                       scanner.nextLine();
                       System.out.println("Enter the student's major (*case-sensitive*)(e.g., Computer Science): ");
                       sel = scanner.nextLine();
                       list = "Major";
                       myList.listStudent(list, sel);
                       break;
                   }
                   else
                       break;
               default:
                   System.out.println("Enter a valid option (e.g., b): ");
                   break;
           }
       }
   }
}
