public class DukeException extends Exception {

    private String userInput;

    // default constructor.
    DukeException() {
        super();
    }

    // overloaded constructor.
    public DukeException(String userInput) {
        super(userInput);
        this.userInput = userInput;
    }

    public String Feedback() {
        return "    Sorry, " + "'" + userInput + "'" + " is an invalid command. \n"
                + "    Duke only accept these few commands:\n"
                + "    1. todo _____.\n"
                + "    2. event _____ /at _____.\n"
                + "    3. deadline _____ /by _____.\n";
    }
}