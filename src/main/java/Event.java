import java.io.Serializable;

public class Event extends Task implements Serializable {

    // private static final long serialVersionUID = 3L;

    // 'By' field is specific to Deadline class and is not in the Task class.
    protected String atWhere;

    // Constructors are not members, so they are not inherited by subclasses,
    // but the constructor of the superclass can be invoked from the subclass.
    public Event(String description, String at) {
        super(description); // invocation of super class constructor.
        this.atWhere = at;
    }

    // @override annotation is a good practice. if there are mistakes like wrong method name,
    // it will be detected and there would be compile time error. it also improves readability.
    @Override
    public String getTaskLabel() {
        return " [E]" + super.getTaskLabel() + " (at: " + atWhere + ")";
    }
}