public class FindCommand extends Command {

    public String userInput;

    public FindCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

        String[] temp = this.userInput.split(" ", 2);

        try {
            if (temp.length == 1) {
                throw new DukeNoInfoException();
            } else {
                String keyword = temp[1];
                int matchedCount = 0;
                ui.printLine();
                System.out.println("    Here are the matching tasks in your list:");
                for (int i = 0; i < tasks.size(); i++) {
                    if (tasks.get(i).getDescription().contains(keyword)) {
                        ++matchedCount;
                        System.out.println("    " + matchedCount + ". " + tasks.get(i).getTaskLabel());
                    }
                }
                ui.printLine();
            }
        } catch (DukeNoInfoException e) {
            ui.printDukeNoInfoException(e);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}