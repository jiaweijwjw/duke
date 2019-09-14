/**
 * Parses through the input of the User to understand the command to be executed.
 */
public class Parser {

    /**
     * Understands the command that the User has input and checks if the command
     * that the User has input is what Duke can handle. Else the command will be
     * considered as an unknown command.
     * @param userInput
     * @return Specific command type by the User.
     */
    public static Command parse(String userInput) {

        Command command;
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

        } else {
            command = new UnknownCommand(userInput);
        }
        return command;
    }
}