import java.util.UUID;

/**
 * InventoryItem.
 *
 * Abstract superclass for items in the inventory
 * of a store.
 *
 */
public abstract class InventoryItem
{
    private UUID id;

    // constructor - set the id randomly
    public InventoryItem()
    {
        setId();
    }

    // mutator - called by the constructor
    private void setId()
    {
        id = UUID.randomUUID();
    }

    // accessor
    public UUID getId() { return id; }

    // getPrice - calculate the price of an item - must be overridden by subclass
    public abstract double getPrice();
}