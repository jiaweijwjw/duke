public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    private Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage.load(ui));
    }

    /**
     * The main method that runs Duke.
     * The User's input on the command line is parsed through to make sense of the command given.
     * Duke then executes the command respectively.
     */
    private void run() {
        ui.printGreeting();
        boolean isExit = false;
        while (!isExit) {
            String userInput = ui.readUserInput();
            Command c = Parser.parse(userInput);
            c.execute(tasks, ui, storage);
            isExit = c.isExit();
        }
    }

    // The following line indicates the entry point to the program.
    public static void main(String[] args) {
        Duke duke = new Duke("/Users/jiawei/Desktop/duke/data/duke.txt");
        duke.run();
    }
}


