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
        // if task is done, tick. if task is NOT done, cross.
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
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