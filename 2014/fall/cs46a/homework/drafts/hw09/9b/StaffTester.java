public class StaffTester
{
    public static void main(String[] args)
    {
        Staff myStaff = new Staff();
       
        Employee employee1 = new Employee("Billy");
        employee1.add(320);
        employee1.add(400);
        employee1.add(320);
        employee1.add(480);
        myStaff.add(employee1);
         
        Employee employee2 = new Employee("Sarah");
        employee2.add(320);
        employee2.add(400);
        employee2.add(520);
        employee2.add(480);
        employee2.add(480);
        myStaff.add(employee2);

        Employee employee3 = new Employee("Fred");
        employee3.add(400);
        employee3.add(320);
        employee3.add(380);
        myStaff.add(employee3);
        
        System.out.println(myStaff);
        System.out.println("Expected: [[Employee:name=Billy,salaries=[320.0, 400.0, 320.0, 480.0]], [Employee:name=Sarah,salaries=[320.0, 400.0, 520.0, 480.0, 480.0]], [Employee:name=Fred,salaries=[400.0, 320.0, 380.0]]]");
        
        myStaff = new Staff();
        System.out.println(myStaff);
        System.out.println("Expected: []");
        
    }
}