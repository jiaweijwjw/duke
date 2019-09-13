import java.io.Serializable;
import java.util.ArrayList;

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

    public void remove(int index) {

        taskList.remove(index);
    }

    public void add(Task task) {
        taskList.add(task);
    }
}