import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 * This is the StudentMangement class of the the student management system
 * 
 *  @author Georg Philipp Erasmus Heise 
 *  @ SSID = 25912704 
 *  gphei2@student.monash.edu
 *  twitter = @gpheheise
 *  @version 1.0.3
 *  
 *  StudentMangenent Class 
 */
public class StudentManagement 
{
    
    private File file = new File("assets/students.txt");
    private ManagementSystem ms = new ManagementSystem(file);
    private Scanner scanner = new Scanner(System.in);
    
    //private void evaluate(int choice)  evelluates the number entered by the user
    private void evaluate(int choice) 
    {
        if (choice == 1) {
            print("Enter the student's name: ");
            String name = scanner.nextLine();
            name = name.replaceAll("[^a-zA-Z]+","");
            if (!name.isEmpty())
            {
                print("Enter the student's phone number: ");
                String phoneNo = scanner.nextLine();
                if (phoneNo.substring(0, 1).equals("9") && phoneNo.length() == 9)
                {
                    print("Enter the student's subject to enrol him/her (Computing, Maths or English): ");
                    String subject = scanner.nextLine();
                    if (subject.equalsIgnoreCase("Computing") || subject.equalsIgnoreCase("Maths") || subject.equalsIgnoreCase("English"))
                    {
                        ms.insert(name, phoneNo, subject.toLowerCase());
                        println("\nSuccessfully added\n");  
                    }
                    else
                        println("\nPlease choose one of the given subjects\n");
                }
                else
                    println("\nPlease enter a phonenumber beginning with a 9 and a length of 9 digits\n");
            }
            else
                println("Please enter a valid name for the student");
        }
        else 
          if (choice == 2)
          { 
              print("Enter student's name: ");
              String name = scanner.nextLine();
              ms.remove(name);
              println("");
           }
        else 
          if (choice == 3)
          {
            print("Enter student's name: ");
            String name = scanner.nextLine();
            println("");
            List<Student> s;
             if ((s = ms.search(name)).size() != 0)
                for (int i = 0; i < s.size(); i++)
                {
                    s.get(i).display();
                    println("");
                }
             else
                println("No student found\n");
        }
        else 
          if (choice == 4)
          {
            /** Used for one subject only
                print("Enter the subject's name (Computing, Maths or English): ");
                String subject = scanner.nextLine();
                if (subject.toLowerCase().equalsIgnoreCase("Computing") || subject.toLowerCase().equalsIgnoreCase("Maths") || subject.toLowerCase().equalsIgnoreCase("English"))
                    ms.list(subject);
            */
            print("Enter one or more subject's name seperated by a , (Computing, Maths or English): ");
            String[] subjects = scanner.nextLine().split("\\,");
            println("");
            for (int i = 0; i < subjects.length; i++)
            {
                String subject = subjects[i].trim();
                    if (subject.equalsIgnoreCase("Computing") || subject.equalsIgnoreCase("Maths") || subject.equalsIgnoreCase("English"))
                        ms.list(subject);
            }
        }
        else 
          if (choice == 5)
          {
              ms.listAll();
          }
          else 
            if (choice == 6)
            { 
              ms.close();
              System.exit(0);
            }
    }
    // public static void main(String[] args) starts the terminal 
    public static void main(String[] args)
    {
        StudentManagement sm = new StudentManagement();
        sm.start();
    }
    // public void print(String string) prints the string to the terminal
    public void print(String string)
    {
        System.out.print(string);
    }
    // public void printConsol() prints the console to the terminal when started as well as everytime an action has taken place
    public void printConsole()
    {
        println("Welcome to the Simple Student Management System");
        println("================================");
        println("(1) Add new student");
        println("(2) Delete a student");
        println("(3) Find Student By Name");
        println("(4) List Students By Subject");
        println("(5) List All Students");
        println("(6) Exit System");
        print("Enter your choice: ");
        try
        {
            String schoice = scanner.next();
            println("");
            scanner.nextLine();
            int choice = Integer.parseInt(schoice);
            evaluate(choice);
        }
        catch (Exception e)
        {
            println("An error occured, please enter only numbers between 1 and 6");
            // System.out.println(e.getLocalizedMessage());
            // System.exit(0);
        }
    }
    
    public void println(String string)
    {
        System.out.println(string);
    }
   // public void start starts the system / runs the loop inside the system
    public void start()
    {
        while (true)
            this.printConsole();
    }
}
