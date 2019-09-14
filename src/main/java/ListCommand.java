/**
 * lists all the current tasks that are stored in the tasklist.
 */
public class ListCommand extends Command {

    public ListCommand() {
        super();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Ui.printList(tasks);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}