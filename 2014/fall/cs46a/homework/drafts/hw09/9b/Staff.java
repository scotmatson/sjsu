/**
 * Scot Matson - 009602502
 * CS49A - 01
 * Homework 9b - Draft
 */
import java.util.ArrayList;

public class Staff
{
    private ArrayList<Employee> employees;

    /**
     * Creates an empty Staff containing no Employee
     */
    public Staff()
    {
        employees = new ArrayList<Employee>();
    }

    /**
     * Transforms the employees ArrayList into a String
     * @return empStr The employees ArrayList as a comma delimited String wrapped in brackets
     */
    public String toString()
    {
        String empStr = employees.toString();
        return empStr;
    }
    
    /**
     * Adds the Employee to this Staff
     * @param e The employee to add
     */
    public void add(Employee e) {
        employees.add(e);
    }
    
    /**
     * Returns the name of the employee with the highest average salary
     * @return highestPaid The highest paid employee
     */
    public String getHighestPaid() {
        return null;
    }
    
    /**
     * Returns the number of Employees whose average weekly
     * salary to date is over target
     * @param target The target weekly salary
     * @return overTarget The number of employees over the target
     */
    public int countOver(double target) {
        return 0;
    }
}
