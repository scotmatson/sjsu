/**
 * Task.
 * This class represents a task in a 
 * To-Do list. It also acts like a Node
 * class for a linked list. 
 */
public class Task
{
    private String name;
    private String description;
    private boolean complete;

    public Task next;

    public Task(String name, String description, boolean complete)
    {
        this.name = name;
        this.description = description;
        this.complete = complete;

        this.next = null;
    }

    public Task(String name, String description, boolean complete, Task next)
    {
        this.name = name;
        this.description = description;
        this.complete = complete;

        this.next = next;
    }

    public String getName(){ return this.name; }
    public String getDescription(){ return this.description; }
    public boolean getComplete(){ return this.complete; }

    public void setName(String name){ this.name = name; }
    public void setDescription(String description){ this.description = description; }
    public void setComplete(boolean complete){ this.complete = complete; }

    @Override
    public String toString()
    {
        return "Task[name=" + getName() + ", description=" + getDescription() + "]";
    }
}