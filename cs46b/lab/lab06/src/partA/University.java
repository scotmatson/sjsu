package partA;

// Extending partA.AbstractFiniteSet does not necessarily make sense here
// because there is not real relationship coupling the two classes
public class University extends AbstractFiniteSet
{
    private int students;

    public University(int size)
    {
        students = size;
    }

    public int number()
    {
        // This is possible because of polymorphism.
        Countable c = new University(30438);
        return students;

        // Any code placed here would be unreachable.
    }
}