import java.util.*;

public class Duke {
    // this line means this is the entry point to the program.
    public static void main(String[] args) {
        // greeting.
        String line = "   ____________________________________________________________\n";
        String greeting = "   Hello! I'm Duke\n" + "   What can I do for you?\n";
        System.out.println(line);
        System.out.println(greeting);
        System.out.println(line);

        // reading in input from user.
        Scanner sc = new Scanner(System.in);

        // Obj is the type of object to be stored in List. (type-safe list)
        // List<Obj> list = new ArrayList<Obj> ();
        // a list of Tasks objects.
        List<Task> myList = new ArrayList<Task>();

        // keep reading input till there is "bye".
        while(true) {
            String command = sc.nextLine(); // store input into variable called command.
            if (command.equals("list")) {
                System.out.println(line);
                System.out.println("    Here are the tasks in your list:");
                // use for loop because we want to print the number. if not can use enhanced for loop or iterator.
                for (int i = 0; i < myList.size(); i++) {
                    System.out.println("    " + (i + 1) + ". " + myList.get(i).getStatusIcon() + " " + myList.get(i).getDescription());
                }
                System.out.println(line);
            } else if (command.equals("bye")) {
                System.out.println(line);
                System.out.println("    Bye. Hope to see you again soon!");
                System.out.println(line);
                break; // to get out of the while(true) loop.
            } else if (command.startsWith("done") || command.startsWith("Done")) {
                // Integer.valueOf() or Integer.parseInt converts string to integer.
                String temp[] = command.split(" ");
                int taskNumber = Integer.valueOf(temp[1]) - 1; // -1 to get the index of the task in myList.
                myList.get(taskNumber).setAsDone();
                System.out.println(line);
                System.out.println("    Nice! I've marked this task as done:");
                System.out.println("   " + myList.get(taskNumber).getStatusIcon() + " " + myList.get(taskNumber).getDescription());
                System.out.println(line);
            } else {
                Task newTask = new Task(command); // calling the constructor to create an object for this task.
                myList.add(newTask);
                System.out.println(line);
                System.out.println("    added: " + command);
                System.out.println(line);
            }
        }
    }
}

