/**
 * models a person with a name and an age
 */
public class Person
{
    private String name;
    private int age;
    
    public Person(String theName, int age)
    {
        name = theName;
        this.age = age;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public String toString()
    {
        String s = "[" + getClass().getName() + ":"
           + "name="+ name + ","
           + "age=" + age + "]";
        return s;
    }
}
