/**
 * ToDoList. This class encapsulates a task
 * list using a singly-linked list.
 */
public class ToDoList
{
    private Task first;

    public ToDoList()
    {
        first = null;
    }
    public ToDoList(Task first)
    {
        this.first = first;
    }

    /**
     * addFirst. Add a Task at the front
     * of the list.
     * @param newTask the Task to add
     */
    public void addFirst(Task newTask)
    {
        newTask.next = first;
        first = newTask;
    }

    /**
     * addLast. Add a Task at the end of
     * the list.
     * @param newTask the Task to add
     */
    public void addLast(Task newTask)
    {
        Task theLink = first;

        while (theLink.next != null) {
            theLink = theLink.next;
        }

        theLink.next = newTask;
    }

    /**
     * setComplete. For the task with the given name,
     * mark it as complete. If the Task doesn't exist,
     * then do nothing.
     * @param name the name of the task to mark complete (set complete = true)
     */
    public void setComplete(String name)
    {
        Task theLink = first;

        while(theLink.next != null) {

            if (theLink.getName().equals(name)) {
                theLink.setComplete(true);
                break;
            }
            else {
                theLink = theLink.next;
            }
        }
    }

    /**
     * get. Return the Task at position i, if one
     * exists. Otherwise, return null. The first
     * item is at index 0.
     * @param i the index to check
     * @return the Task at that index
     */
    public Task get(int i)
    {
        // You cannot return null from this method because the
        //  List class will throw a NullPointerException which we cannot
        //  handle without being able to access the Test class
        Task theLink = first;
        int pos = 0;
        
        while (pos != i && theLink.next != null) {
            theLink = theLink.next;
            ++i;
        }

        return theLink;
    }

    /**
     * print. Print ONLY THE INCOMPLETE tasks
     * to console. So print only the tasks where
     * complete == false. Print a numbered list.
     *
     * 1. name of first incomplete Task
     * 2. name of second incomplete Task
     * 3. name of third ...
     * 4. etc
     */
    public void print()
    {
        Task theLink = first;
        int i = 0;

        while (theLink.next != null) {
            if (!theLink.getComplete()) {
                ++i;
                System.out.println(i + ". " + theLink.getName());
            }
            theLink = theLink.next;
        }
        // The final case is not checked since we broke out of the loop early
        //  Not sure of a more elegant way to accomplish this.
        if (!theLink.getComplete()) {
            ++i;
            System.out.println(i + ". " + theLink.getName());
        }
    }
}
