public class Student extends Customer
{
    String studentID;
    int studentDiscount;
    
    public Student()
    {
        studentID = null;
        studentDiscount = null;
    }
    
    public Student(String ID, int discount)
    {
        studentID = ID;
        studentDiscount = discount;
    }
    
    public void createStudent()
    {
        Student();
    }
}
