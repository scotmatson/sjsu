public class Student
{
    private String firstName;
    private String lastName;
    private int id;
    private String email;

    public Student(String NewFirstName, String NewLastName, int NewId, String NewEmail)
    {
        firstName = NewFirstName;
        lastName = NewLastName;
        id = NewId;
        email = NewEmail;
    }

    public String getFirstName(){ return firstName; }
    public void setFirstName(String NewFirstName){ firstName = NewFirstName; }

    public String getLastName(){ return lastName; }
    public void setLastName(String NewLastName){ lastName = NewLastName; }

    public int getId(){ return id; }
    public void setId(int NewId){ id = NewId; }

    public String getEmail(){ return email; }
    public void setEmail(String NewEmail){ email = NewEmail; }

    public String toString()
    {
        return firstName + " " + lastName;
    }
}