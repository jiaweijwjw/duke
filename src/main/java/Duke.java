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
        List<String> myList = new ArrayList<String>();

        // keep reading input till there is "bye".
        while(true) {
            String command = sc.nextLine(); // store input into variable called command.
            if (command.equals("list")) {
                System.out.println(line);
                // use for loop because want to print the number. if not can use enhanced for loop or iterator.
                for (int i = 0; i < myList.size(); i++) {
                    System.out.println("    " + (i + 1) + ". " + myList.get(i));
                }
                System.out.println(line);
            } else if (command.equals("bye")) {
                System.out.println(line);
                System.out.println("    Bye. Hope to see you again soon!");
                System.out.println(line);
                break; // to get out of the while(true) loop.
            } else {
                myList.add(command);
                System.out.println(line);
                System.out.println("    added: " + command);
                System.out.println(line);
            }
        }
    }
}

