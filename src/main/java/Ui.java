import java.io.IOException;
import java.util.Scanner;

/**
 * Reads in the User's input.
 * Methods regarding interactions with the User are here.
 */
public class Ui {

    // final keyword for constants. constants to be in capital letters.
    // static keyword for class-level attributes rather than instance objects.
    private static final String LINE = "   ____________________________________________________________\n";

    private Scanner sc;

    public Ui() {
        this.sc = new Scanner(System.in);
    }

    public String readUserInput() {
        return sc.nextLine();
    }

    public static void printLine() {
        System.out.println(LINE);
    }

    public static void printGreeting() {
        System.out.println(LINE);
        System.out.println("   Hello! I'm Duke\n" + "   What can I do for you?\n");
        System.out.println(LINE);
    }

    public static void printBye() {
        System.out.println(LINE);
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }

    public static void printList(TaskList tasks) {
        System.out.println(LINE);
        System.out.println("    Here are the tasks in your list:");
        // use for loop because we want to print the number. if not can use enhanced for loop or iterator.
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("    " + (i + 1) + "." + tasks.get(i).getTaskLabel());
        }
        System.out.println(LINE);
    }

    public static void printTaskAdded(TaskList tasks) {
        System.out.println(LINE);
        System.out.println("    Got it. I've added this task:");
        System.out.println("    " + tasks.get(tasks.size() - 1).getTaskLabel());
        System.out.println("    Now you have " + tasks.size() + " tasks in the list.");
        System.out.println(LINE);
    }

    public static void printAcknowledgeDone(int taskNumber, TaskList tasks) {
        System.out.println(LINE);
        System.out.println("    Nice! I've marked this task as done:");
        // System.out.println("    " + taskList.get(taskNumber - 1).getStatusIcon() + " " + taskList.get(taskNumber - 1).getDescription());
        System.out.println("    " + tasks.get(taskNumber - 1).getTaskLabel());
        System.out.println(LINE);
    }

    public void printAcknowledgeDelete(int taskNumber, TaskList tasks) {
        System.out.println(LINE);
        System.out.println("    Noted. The task has been removed from the list.");
        // System.out.println("    " + taskList.get(taskNumber - 1).getStatusIcon() + " " + taskList.get(taskNumber - 1).getDescription());
        System.out.println("    " + tasks.get(taskNumber - 1).getTaskLabel());
        System.out.println(LINE);
    }

    public void printFileSaved() {
        System.out.println(LINE);
        System.out.println("    File has been successfully saved!");
        System.out.println(LINE);
    }

    public void printFileLoaded() {
        System.out.println(LINE);
        System.out.println("    File has been successfully loaded!");
        System.out.println(LINE);
    }

    public void printIOException(IOException e) {
        System.out.println(LINE);
        e.printStackTrace();
        System.out.println(LINE);
    }

    public void printClassNotFoundException(ClassNotFoundException e) {
        System.out.println(LINE);
        System.out.println("    Class not found.");
        e.printStackTrace();
        System.out.println(LINE);
    }

    public void printLoadingError() {
        System.out.println(LINE);
        System.out.println("    Duke cannot find the saved file. A new tasklist will be created.");
        System.out.println(LINE);
    }

    public void printDoneIndexOutOfBoundsException() {
        System.out.println(LINE);
        System.out.println("    You can only mark a task in the list as done. Please input another index within the list.");
        System.out.println(LINE);
    }

    public void printDoneNumberFormatException() {
        System.out.println(LINE);
        System.out.println("    The item you wanted to mark as done is not provided as its index. Please input the index of the task.");
        System.out.println(LINE);
    }

    public void printDeleteIndexOutOfBoundsException() {
        System.out.println(LINE);
        System.out.println("    You can only remove a task from the list. Please input another index within the list.");
        System.out.println(LINE);
    }

    public void printDeleteNumberFormatException() {
        System.out.println(LINE);
        System.out.println("    The item you wanted to delete is not provided as its index. Please input the index of the task.");
        System.out.println(LINE);
    }

    public static void printDukeException(DukeException e) {
        System.out.println(LINE);
        System.out.println(e.Feedback());
        System.out.println(LINE);
    }

    public static void printWrongCommand(String userInput) {
        System.out.println(LINE);
        System.out.println( "    Sorry, " + "'" + userInput + "'" + " is an invalid command. \n"
                + "    Duke only accept these few commands:\n"
                + "    1. todo _____.\n"
                + "    2. event _____ /at _____.\n"
                + "    3. deadline _____ /by _____.\n");
        System.out.println(LINE);
    }

    public void printDukeNoInfoException(DukeNoInfoException e) {
        System.out.println(LINE);
        System.out.println(e.Feedback());
        System.out.println(LINE);
    }

    public void printDukeNoFullInfoException(DukeNoFullInfoException e) {
        System.out.println(LINE);
        System.out.println(e.Feedback());
        System.out.println(LINE);
    }

    public void printPatternSyntaxException() {
        System.out.println(LINE);
        System.out.println("    Please provide the full information.\n"
                + "    1. For events, please include /at _____.\n"
                + "    2. For deadlines, please include /by _____.\n");
        System.out.println(LINE);
    }

    public void printDateTimeParseException() {
        System.out.println(LINE);
        System.out.println("    Format of Date/Time provided is incorrect.");
        System.out.println(LINE);
    }
}