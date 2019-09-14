import java.io.Serializable;
import java.util.ArrayList;

/**
 * Creates the taskList object and contains all the methods to do basic
 * manipulations to the list. These include adding and deleting a task
 * from the list and getting the information of a specific task.
 */
public class TaskList implements Serializable {

    protected ArrayList<Task> taskList;

    // constructor for new taskList.
    public TaskList() {

        this.taskList = new ArrayList<Task>();
    }

    // constructor to load from saved tasks.
    public TaskList(ArrayList<Task> loadedArrayList) {

        this.taskList = loadedArrayList;
    }

    public Task get(int index) {

        return taskList.get(index);
    }

    public int size() {

        return taskList.size();
    }

    public void remove(int index) throws IndexOutOfBoundsException {

        taskList.remove(index);
    }

    public void add(Task task) {
        taskList.add(task);
    }
}