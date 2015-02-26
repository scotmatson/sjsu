/**
 * Scot Matson - 009602502
 * CS49A - 01
 * Homework 9b - Final
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
        String highestPaid = null;
        //If an Employee object exists in the array...
        if (employees.size() > 0) {
            double highestPay = 0;
            //Iterate through all of the known array elements.
            for (int i = 0; i < employees.size(); ++i) {
                //Store the name and salary of the employee that holds the highest average.
                if (highestPay < employees.get(i).averageSalary()) {
                    highestPay = employees.get(i).averageSalary();
                    highestPaid = employees.get(i).getName();
                }
            }
        }

        return highestPaid;
    }

    /**
     * Returns the number of Employees whose average weekly
     * salary to date is over target
     * @param target The target weekly salary
     * @return overTarget The number of employees over the target
     */
    public int countOver(double target) {
        int overTarget = 0;
        //Check for existing array elements
        if (employees.size() > 0) {
            //Iterate through the array
            for (Employee employee : employees) {
                //For each employee with an average salary over the target, increment the conter by 1
                if(employee.averageSalary() > target) {
                    ++overTarget;
                }
            }
        }

        return overTarget;
    }
}
