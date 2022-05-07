public class Professor extends Customer
{
    String professorID;
    int professorDiscount;
    
    public Student()
    {
        professorID = null;
        professorDiscount = null;
    }
    
    public Student(String ID, int discount)
    {
        professorID = ID;
        professorDiscount = discount;
    }
    
    public void createProfessor()
    {
        Professor();
    }
}
