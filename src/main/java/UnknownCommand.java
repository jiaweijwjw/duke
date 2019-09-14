/**
 * Handles any command that Duke does not support and reports back
 * to the User that Duke does not support this specific command.
 */
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