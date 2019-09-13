public class DeleteCommand extends Command {

    private String userInput;

    public DeleteCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

        String[] temp = userInput.split(" ");
        try {

            if (temp.length == 1) {
                throw new DukeNoInfoException(); // user input: done 'blank'.
            } else {
                int taskNumber = Integer.parseInt(temp[1]); // user input: done 'string'.
                ui.printAcknowledgeDelete(taskNumber, tasks);
                tasks.remove(taskNumber - 1); // -1 to get the index of the task in myList. user input: done 'number not in list'.
                storage.save(ui, tasks);
            }

        } catch (IndexOutOfBoundsException e) {
            ui.printIndexOutOfBoundsException();
        } catch (NumberFormatException e) {
            ui.printNumberFormatException();
        } catch (DukeNoInfoException e) {
            ui.printDukeNoInfoException(e);
        }

    }

    @Override
    public boolean isExit() {
        return false;
    }
}