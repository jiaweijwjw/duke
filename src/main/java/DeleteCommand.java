/**
 * Handles the delete command. Deletes the specified task from the tasklist.
 * If the specified task to be deleted is blank / as a String / non-existent,
 * Duke will respond to the User accordingly.
 */
public class DeleteCommand extends Command {

    private String userInput;

    public DeleteCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    /**
     * Executes the deletion of the specific task from the tasklist.
     * Saves the file after the deletion.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {

        String[] temp = userInput.split(" ");
        try {

            if (temp.length == 1) {
                throw new DukeNoInfoException(); // user input: done 'blank'.
            } else {
                int taskNumber = Integer.parseInt(temp[1]); // user input: done 'string'.
                tasks.remove(taskNumber - 1); // -1 to get the index of the task in taskList. user input: done 'number not in list'.
                ui.printAcknowledgeDelete(taskNumber, tasks);
                storage.save(ui, tasks);
            }

        } catch (IndexOutOfBoundsException e) {
            ui.printDeleteIndexOutOfBoundsException();
        } catch (NumberFormatException e) {
            ui.printDeleteNumberFormatException();
        } catch (DukeNoInfoException e) {
            ui.printDukeNoInfoException(e);
        }

    }

    @Override
    public boolean isExit() {
        return false;
    }
}