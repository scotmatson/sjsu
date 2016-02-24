public class Tester
{
    public static void main(String[] args)
    {
        Book a = new Book(123, "The Remains of the Day", "aa a aaaa a aaa a a aa a");

        System.out.println("Actual: " + a.toString());
        System.out.println("Expected: Book[number=123, title=The Remains of the Day]");

        a.saveToFile("new.txt");

        Book b = Book.loadFromFile("PrideAndPrejudice.txt");

        System.out.println("Actual: " + b.toString());
        System.out.println("Expected: Book[number=11111, title=Pride and Prejudice]");

        System.out.println("Actual: " + b.getText().substring(0, 32));
        System.out.println("Expected: It is a truth universally acknow");

        Book c = Book.loadFromFile("new.txt");

        System.out.println("Actual: " + c.toString());
        System.out.println("Expected: Book[number=123, title=The Remains of the Day]");


        Book d = Book.loadFromFile("TheShining.txt");

        System.out.println("Actual: " + d.toString());
        System.out.println("Expected: Book[number=12345, title=The Shining]");

        System.out.println("Actual: " + d.getText().substring(0, 32));
        System.out.println("Expected: Jack Torrance thought: Officious");

        System.out.print("Actual: ");
        Book.loadFromFile("kjhdf.txt");
        System.out.println("Expected: Error: File not found.");

        System.out.print("Actual: ");
        Book.loadFromFile("TheMoreYouIgnoreMe.txt");
        System.out.println("Expected: Error while loading TheMoreYouIgnoreMe.txt.");

    }

}