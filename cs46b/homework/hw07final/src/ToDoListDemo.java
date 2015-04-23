public class ToDoListDemo
{
    public static void main(String[] args)
    {
        Task a = new Task("Walk the dog", "Spot desperately needs to go out.", false);
        Task b = new Task("Buy Groceries", "Go to Safeway to buy groceries.", false);
        Task c = new Task("Exercise", "Go to the gym.", false);
        Task d = new Task("Pick up Kai", "Pick up Kai from school.", false);

        ToDoList list = new ToDoList();
        list.addFirst(a);
        list.addLast(b);
        list.addFirst(d);

        list.print();

        list.addLast(c);

        list.setComplete("Walk the dog");

        list.print();
    }
}