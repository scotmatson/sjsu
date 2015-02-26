import java.util.ArrayList;
public class Employee
{
    private String name;
    private ArrayList<Double> salaries;
    
    /**
     * Constructs a Employee object with a name and no salaries
     * @param name the employee's name
     */
    public Employee(String name)
    {
        this.name = name;
        salaries = new ArrayList<Double>();
    }
    
    /**
     * Adds a salary for this employee
     * @param salary the new salary to add
     */
    public void add(double salary)
    {
        salaries.add(salary);
    }
    
    /**
     * Gets the average of this employee's salaries
     * @return the average salary for this employee
     */
    public double averageSalary()
    {
        double sum = 0;
        for (Double salary: salaries)
        {
            sum = sum + salary;
        }
        
        double average = 0;
        if (salaries.size() > 0)
        {
            average = sum / salaries.size();
        }
        
        return average;
    }
    
    /**
     * Gets the name of this Employee
     * @return the name
     */
    public String getName()
    {
        return name;
    }
    
    public String toString()
    {
        return "[" + this.getClass().getName() 
                + ":name=" + name 
                + ",salaries="+salaries.toString()
                + "]";
    }
}