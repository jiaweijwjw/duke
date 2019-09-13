public class ExitCommand extends Command {

    public ExitCommand() {
        super();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Ui.printBye();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}