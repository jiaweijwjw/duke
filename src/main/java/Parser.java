public class Parser {

    private static Command command;

    public static Command parse(String userInput) {

        if (userInput.equals("list")) {

            command = new ListCommand();

        } else if (userInput.equals("exit")) {

            command = new ExitCommand();

        } else if (userInput.startsWith("done")) {

            command = new DoneCommand(userInput);

        } else if (userInput.startsWith("delete")) {

            command = new DeleteCommand(userInput);

        } else if (userInput.startsWith("find")) {

            command = new FindCommand(userInput);

        } else if (userInput.startsWith("todo") || userInput.startsWith("event") || userInput.startsWith("deadline")) {

            command = new TaskCommand(userInput);

        }
        return command;
    }
}