/**
 * This is the student class of the the student management system
 * 
 *  @author Georg Philipp Erasmus Heise 
 *  @ SSID = 25912704 
 *  gphei2@student.monash.edu
 *  twitter = @gpheheise
 *  @version 1.0.3
 *  
 *  Student Class 
 */
public class Student
{
    private String name;
    private String phoneNo;
    private String subject;

    public String getName()
    {
        return this.name;
    }
    
    
    public String getPhoneNo()
    {
        return this.phoneNo;
    }
    
    public String getSubject()
    {
        return this.subject;
    }
    
    public String getStore()
    {
        return this.name + ", " + this.phoneNo + ", " + this.subject;
    }
    
    public Student ()
    { 
        name ="StudentName";
        phoneNo ="999999999"; //could have set it to "9x-8" but decided that no student has 999999999 as the phone nr
        subject = "Subject";
    }
    
    public Student (String name, String phoneNo, String subject)
    {
        if (name.trim().length() > 0)
            this.name = name;  
        else
            this.name = "student Name";
        
        if (phoneNo.trim().length() ==9 && phoneNo.substring(0,1).equals("9"))
            this.phoneNo = phoneNo;
            
            else 
                this.phoneNo = "999999999";
                
       if (subject.equalsIgnoreCase("Computing") || subject.equalsIgnoreCase("Maths") || subject.equalsIgnoreCase("English"))
            this.subject = subject;
        
       else
            this.subject = "Subject";
       
    }
   
    public void display()
    {
        System.out.println("Student name: " + name);
        System.out.println("Student number: " + phoneNo);
        System.out.println("Subject: " + subject);
    }
    
        public void setName(String name)
    {
        if (name.trim().length() > 0)
            this.name = name;  
        else
            this.name = "student Name";
    }
    
    public void setPhoneNo(String phoneNo)
    {
        //if (phoneNo.charAt(0) == '9')
        if (phoneNo.trim().length() == 9 && phoneNo.substring(0,1).equals("9"))
            this.phoneNo = phoneNo;
            
        else 
            this.phoneNo = "999999999";
    }


    public void setSubject(String subject)
    {
       if (subject.equalsIgnoreCase("Computing") || subject.equalsIgnoreCase("Maths") || subject.equalsIgnoreCase("English"))
            this.subject = subject;
        
       else
            this.subject = "Subject";
    }

}