package partA;

// Making this class abstract allows us to use the partA.Countable interface without
// implementing its methods.
public abstract class AbstractFiniteSet implements Countable
{
    // Making this final prevents any modification by a subclass
    public final boolean isInfinite()
    {
        return false;
    }
}