import java.io.Serializable;

public class Task implements Serializable {

    // private static final long serialVersionUID = 1L;

    // attributes of the tasks.
    protected String description;
    protected boolean isDone;

    // constructor Task()
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    // getter method.
    public String getStatusIcon() {
        // Returns Tick symbol if task is done and Cross symbol is task is not done.
        return (isDone ? "\u2713" : "\u2718");
    }


    public String getDescription() {
        return this.description;
    }

    // setter method.
    public void setAsDone() {
        this.isDone = true;
    }

    public String getTaskLabel() {
        return " [" + getStatusIcon() + "] " + getDescription();
    }
}