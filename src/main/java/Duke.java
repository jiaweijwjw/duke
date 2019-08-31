import java.util.*;

public class Duke {

    // final keyword for constants. constants to be in capital letters.
    // static keyword for class-level attributes.
    private static final String LINE = "   ____________________________________________________________\n";

    // reading in input from user.
    private static Scanner sc = new Scanner(System.in);

    // Obj is the type of object to be stored in List. (type-safe list)
    // List<Obj> list = new ArrayList<Obj> ();
    // a list of Tasks objects.
    protected static List<Task> taskList = new ArrayList<Task>();

    private static void PrintGreeting() {
        System.out.println(LINE);
        System.out.println("   Hello! I'm Duke\n" + "   What can I do for you?\n");
        System.out.println(LINE);
    }

    private static void PrintBye() {
        System.out.println(LINE);
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }

    private static void PrintList() {
        System.out.println(LINE);
        System.out.println("    Here are the tasks in your list:");
        // use for loop because we want to print the number. if not can use enhanced for loop or iterator.
        for (int i = 0; i < taskList.size(); i++) {
            // System.out.println("    " + (i + 1) + ". [" + taskList.get(i).getStatusIcon() + "] " + taskList.get(i).getDescription());
            System.out.println("    " + (i + 1) + "." + taskList.get(i).getTaskLabel());
        }
        System.out.println(LINE);
    }

    private static void PrintAcknowledgeDone(int taskNumber) {
        System.out.println(LINE);
        System.out.println("    Nice! I've marked this task as done:");
        System.out.println("   " + taskList.get(taskNumber - 1).getStatusIcon() + " " + taskList.get(taskNumber - 1).getDescription());
        System.out.println(LINE);
    }

    private static void PrintTaskAdded() {
        System.out.println(LINE);
        System.out.println("    Got it. I've added this task:");
        System.out.println("    " + taskList.get(taskList.size() - 1).getTaskLabel());
        System.out.println("    Now you have " + taskList.size() + " tasks in the list.");
        System.out.println(LINE);
    }

    // this line means this is the entry point to the program.
    public static void main(String[] args) {

        PrintGreeting();

        // keep reading input till there is "bye".
        while(true) {

            // store input into variable called command.
            String command = sc.nextLine();

            if (command.equals("list")) {
                PrintList();
            }

            // to end Duke.
            else if (command.equals("bye")) {
                PrintBye();
                break; // to get out of the while(true) loop.
            }

            // marking a task as done.
            else if (command.startsWith("done") || command.startsWith("Done")) {
                // Integer.valueOf() or Integer.parseInt converts string to integer.
                String temp[] = command.split(" ");
                int taskNumber = Integer.valueOf(temp[1]);
                taskList.get(taskNumber - 1).setAsDone(); // -1 to get the index of the task in myList.
                PrintAcknowledgeDone(taskNumber);
            }

            else { // there is a new task.
                String temp[] = command.split(" ", 2);
                String firstWord = temp[0]; // to extract the first word.
                switch (firstWord) {
                    case "todo":
                        Todo newToDo = new Todo(temp[1]); // temp[1] is the remaining words after extracting first word.
                        taskList.add(newToDo);
                        PrintTaskAdded();
                        break;
                    case "event":
                        String tempEvent[] = temp[1].split("/", 2); // to get the description and the by/at when.
                        String tempEventWhen[] = tempEvent[1].split(" ", 2); // to get the when without the at/by word.
                        String eventDescription = tempEvent[0];
                        String eventWhen = tempEventWhen[1];
                        Event newEvent = new Event(eventDescription, eventWhen);
                        taskList.add(newEvent);
                        PrintTaskAdded();
                        break;
                    case "deadline":
                        String tempDeadline[] = temp[1].split("/", 2); // to get the description and the by/at when.
                        String tempDeadlineWhen[] = tempDeadline[1].split(" ", 2); // to get the when without the at/by word.
                        String deadlineDescription = tempDeadline[0];
                        String deadlineWhen = tempDeadlineWhen[1];
                        Deadline newDeadline = new Deadline(deadlineDescription, deadlineWhen);
                        taskList.add(newDeadline);
                        PrintTaskAdded();
                        break;
                    default: // non of the 3 specified type of tasks.
                        Task otherTask = new Task(command);
                        taskList.add(otherTask);
                        PrintTaskAdded();
                }
            }
        }
    }
}

