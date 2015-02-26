public class StaffTester
{
    public static void main(String[] args)
    {
        Staff myStaff = new Staff();
       
        Employee employee1 = new Employee("Billy");
        employee1.add(320);
        employee1.add(480);
        employee1.add(320);
        employee1.add(480);
        myStaff.add(employee1);
        System.out.println(myStaff.getHighestPaid());
        System.out.println("Expected: Billy");
         
        Employee employee2 = new Employee("Sarah");
        employee2.add(320);
        employee2.add(400);
        employee2.add(520);
        employee2.add(480);
        employee2.add(480);
        myStaff.add(employee2);
        System.out.println(myStaff.getHighestPaid());
        System.out.println("Expected: Sarah");

        Employee employee3 = new Employee("Fred");
        employee3.add(400);
        employee3.add(320);
        employee3.add(380);
        myStaff.add(employee3);
        System.out.println(myStaff.getHighestPaid());
        System.out.println("Expected: Sarah");
        
        int target = 500;
        System.out.println("Count Over $"+ target + ": " 
            + myStaff.countOver(target));
        System.out.println("Expected: 0");
        
        target = 400;
        System.out.println("Count Over $"+ target + ": " 
            + myStaff.countOver(target));
        System.out.println("Expected: 1");
        
        target = 350;
        System.out.println("Count Over $"+ target + ": " 
            + myStaff.countOver(target));
        System.out.println("Expected: 3");
        
        myStaff = new Staff();
        System.out.println(myStaff.getHighestPaid());
        System.out.println("Expected: null");
        
        target = 350;
        System.out.println("Count Over $"+ target + ": " 
            + myStaff.countOver(target));
        System.out.println("Expected: 0");
    }
}