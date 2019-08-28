import java.util.*;

public class Duke {
    // this line means this is the enty point to the program.
    public static void main(String[] args) {
        /*
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
         */
        String line = "   ____________________________________________________________\n";
        String greeting = "   Hello! I'm Duke\n" + "   What can I do for you?\n";
        System.out.println(line);
        System.out.println(greeting);
        System.out.println(line);
        // read in input until there is a "bye".
        Scanner sc = new Scanner(System.in);
        while(true) {
            String command = sc.nextLine();
            if (command.equals("bye")) {
                System.out.println(line);
                System.out.println("   " + command);
                System.out.println(line);
                break;
            } else {
                System.out.println(line);
                System.out.println("   " + command);
                System.out.println(line);
            }
        }
    }
}

