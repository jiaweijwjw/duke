import java.io.Serializable;
import java.time.LocalDateTime;

public class Event extends Task implements Serializable {

    // private static final long serialVersionUID = 3L;

    // 'By' field is specific to Deadline class and is not in the Task class.
    private String atWhere;
    private LocalDateTime formattedTime;

    // Constructors are not members, so they are not inherited by subclasses,
    // but the constructor of the superclass can be invoked from the subclass.
    /*
    public Event(String description, String at) {
        super(description); // invocation of super class constructor.
        this.atWhere = at;
    }
     */

    public Event(String description, LocalDateTime formattedTime) {
        super(description);
        this.formattedTime = formattedTime;
    }

    // @override annotation is a good practice. if there are mistakes like wrong method name,
    // it will be detected and there would be compile time error. it also improves readability.
    @Override
    public String getTaskLabel() {
        return " [E]" + super.getTaskLabel() + " (at: " + formattedTime + ")";
    }
}