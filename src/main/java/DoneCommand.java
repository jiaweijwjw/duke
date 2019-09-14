/**
 * Marks a specific task as done.
 */
public class DoneCommand extends Command {

    private String userInput;

    public DoneCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {

            // 1. user could input number that is out of bounds of the list array
            // 2. or user did not input any number at all.
            // 3. or user input something else rather than a number.

            // Integer.valueOf() or Integer.parseInt() converts string to integer.
            String[] temp = userInput.split(" ");
            if (temp.length == 1) {
                throw new DukeNoInfoException(); // user input: done 'blank'.
            } else {
                int taskNumber = Integer.parseInt(temp[1]); // user input: done 'string'.
                tasks.get(taskNumber - 1).setAsDone(); // -1 to get the index of the task in myList. user input: done 'number not in list'.
                ui.printAcknowledgeDone(taskNumber, tasks);
                storage.save(ui, tasks);
            }

        }
        // if want to catch 2 exceptions that are can be handled the same way, use (exception1 | exception2).
        catch (IndexOutOfBoundsException e) {
            ui.printDoneIndexOutOfBoundsException();
        } catch (NumberFormatException e) {
            ui.printDoneNumberFormatException();
        } catch (DukeNoInfoException e) {
            ui.printDukeNoInfoException(e);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}