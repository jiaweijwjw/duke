public class UnknownCommand extends Command {

    private static String userInput;

    public UnknownCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Ui.printWrongCommand(userInput);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}