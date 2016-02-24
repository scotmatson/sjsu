public class StudentManagerTester
{
    public static void main(String[] args)
    {
        StudentManager manager = new StudentManager();
        manager.add(new Student("Jake", 90));
        manager.add(new Student("Christine", 100));
        
        System.out.println(manager.toString());
        System.out.println("Expected: [[Student:name=Jake,score=90], [Student:name=Christine,score=100]]");
        manager.add(new Student("Dennis", 85));
        System.out.println(manager.toString());
        System.out.println("Expected: [[Student:name=Jake,score=90], [Student:name=Christine,score=100], [Student:name=Dennis,score=85]]");
    }
}