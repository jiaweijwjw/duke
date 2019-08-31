public class Deadline extends Task {
    // 'By' field is specific to Deadline class and is not in the Task class.
    protected String byWhen;

    // Constructors are not members, so they are not inherited by subclasses,
    // but the constructor of the superclass can be invoked from the subclass.
    public Deadline(String description, String by) {
        super(description); // invocation of super class constructor.
        this.byWhen = by;
    }

    // @override annotation is a good practice. if there are mistakes like wrong method name,
    // it will be detected and there would be compile time error. it also improves readability.
    @Override
    public String getTaskLabel() {
        return " [D]" + super.getTaskLabel() + " (by: " + byWhen + ")";
    }
}