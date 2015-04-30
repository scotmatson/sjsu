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
        Task link = first;

        while (link.next != null) {
            link = link.next;
        }

        link.next = newTask;
    }

    /**
     * setComplete. For the task with the given name,
     * mark it as complete. If the Task doesn't exist,
     * then do nothing.
     * @param name the name of the task to mark complete (set complete = true)
     */
    public void setComplete(String name)
    {
        Task link = first;

        while(link.next != null) {

            if (link.getName().equals(name)) {
                link.setComplete(true);
                break;
            }
            else {
                link = link.next;
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
        Task link = first;
        if (i > 0) {
            for (int j = 0; j < i; j++) {
                link = link.next;
                if (link == null) break;
            }
        }

        return link;
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
        Task link = first;
        int i = 0;

        while (link.next != null) {
            if (!link.getComplete()) {
                ++i;
                System.out.println(i + ". " + link.getName());
            }
            link = link.next;
        }
        // The final case is not checked since we broke out of the loop early
        //  Not sure of a more elegant way to accomplish this.
        if (!link.getComplete()) {
            ++i;
            System.out.println(i + ". " + link.getName());
        }
    }
}
