public abstract class Command {

    private String userInput;

    public Command() {}

    public Command(String userInput) {
        this.userInput = userInput;
    }

    public abstract void execute(TaskList tasks, Ui ui, Storage storage);

    public abstract boolean isExit();
}