public class Tester
{
    public static void main(String[] args)
    {
        Task a = new Task("Walk the dog", "Practice my sweet yo-yo tricks.", false);
        Task b = new Task("Buy Groceries", "Go to Safeway to buy groceries.", false);
        Task c = new Task("Exercise", "Go to the gym.", false);
        Task d = new Task("Pick up Kai", "Pick up Kai from school.", false);

        ToDoList list = new ToDoList();
        list.addFirst(a);

        System.out.println("Actual: " + list.get(0).getName());
        System.out.println("Expected: Walk the dog");

        list.addLast(b);

        System.out.println("Actual: " + list.get(1).getName());
        System.out.println("Expected: Buy Groceries");
        try {
            System.out.println("Actual: " + list.get(2));
        }
        catch (NullPointerException e) {
             System.out.println("Expected: null");
        }
        list.addFirst(d);

        System.out.println("Actual: " + list.get(0).getName());
        System.out.println("Expected: Pick up Kai");

        list.addLast(c);

        list.setComplete("Pick up Kai");
        System.out.println("Actual: " + list.get(0).getComplete());
        System.out.println("Expected: true");

        System.out.println("Actual: " + list.get(2).getComplete());
        System.out.println("Expected: false");

        list.setComplete("asdsdf");

        System.out.println("Actual: " + list.get(1).getComplete());
        System.out.println("Expected: false");


    }

}