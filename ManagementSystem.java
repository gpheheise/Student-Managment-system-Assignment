import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * This is the ManagementSystem class of the the student management system
 * 
 *  @author Georg Philipp Erasmus Heise 
 *  @ SSID = 25912704 
 *  gphei2@student.monash.edu
 *  twitter = @gpheheise
 *  @version 1.0.3
 *  
 *  Management System Class 
 */

public class ManagementSystem 
{
	private File file;
    private List<Student> list = new ArrayList<Student>();
	
    public ManagementSystem()
	{
		
	}
	
	public ManagementSystem (File file)
	{
		this.file = file;
		if (!file.exists())
			return;
		try 
		{
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()){
				String[] store = scanner.nextLine().split("\\,");
				insert(store[0], store[1], store[2]);
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void close() 
	{
		try {
			PrintWriter writer = new PrintWriter(file);
			for (int i = 0; i < list.size(); i++)
				if (list.get(i) != null)
					writer.println(list.get(i).getStore());
			writer.close();
		} 
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
		// Used when the same student with the same phoneNo enrolls for several subjects
	public void insert(String name, String phoneNo, String subject) 
	{
		Student s = new Student(name.trim(), phoneNo.trim(), subject.trim());
		if (!list.contains(s))
			list.add(s);
		else
			System.out.println("ERROR: Student is already in the database");
     }

		// Used when one student can only enroll for one subject
	public void insertOne(String name, String phoneNo, String subject) 
	{
		for (int i = 0; i < list.size(); ++i)
			if (list.get(i).getName().equalsIgnoreCase(name))
			{
				System.out.println("ERROR: Student is already in the database");
				return;
			}
		list.add(new Student(name.trim(), phoneNo.trim(), subject.trim()));
		System.out.println("Student successfully inserted into database");
		return;
     }
	 
	public void list(String subject) 
	{
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getSubject().equalsIgnoreCase(subject))
				list.get(i).display();
	}

	public void listAll() {
		for (int i = 0; i < list.size(); i++)
		{
			list.get(i).display();
			System.out.println();
		}
	}


	public void remove(String name) 
	{
		for (int i = 0; i < list.size(); ++i)
			if (list.get(i).getName().equalsIgnoreCase(name))
			{
				list.remove(i);
				System.out.println("Student successfully removed");
			}
		return;
	}

	public List search(String name) 
	{
		List<Student> l = new ArrayList<Student>();
		
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getName().equalsIgnoreCase(name))
				l.add(list.get(i));
		return l;
	}

}
