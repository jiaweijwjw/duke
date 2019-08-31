public class Todo extends Task { // Todo class is a subclass. Task class is the superclass.

    public Todo(String description) {
        super(description);
        isDone = false;
    }

    // @override annotation is a good practice. if there are mistakes like wrong method name,
    // it will be detected and there would be compile time error. it also improves readability.
    @Override
    public String getTaskLabel() {
        return " [D]" + super.getTaskLabel();
    }
}