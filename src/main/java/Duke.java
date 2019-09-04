import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.PatternSyntaxException;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Duke {

    // final keyword for constants. constants to be in capital letters.
    // static keyword for class-level attributes.
    private static final String LINE = "   ____________________________________________________________\n";

    // reading in input from user.
    private static Scanner sc = new Scanner(System.in);

    // Obj is the type of object to be stored in List. (type-safe list)
    // List<Obj> list = new ArrayList<Obj> ();
    // a list of Tasks objects.
    private static ArrayList<Task> taskList = new ArrayList<Task>();

    private static final String dateTimePattern = "dd/MM/yyyy HHmm";
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);

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

    private static void SaveToFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream("/Users/jiawei/Desktop/duke/data/duke.txt");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(taskList);
            objOut.close();
            fileOut.close();
            System.out.println(LINE);
            System.out.println("    File has been successfully saved!");
            System.out.println(LINE);
        } catch (IOException e) {
            System.out.println(LINE);
            e.printStackTrace();
            System.out.println(LINE);
        }
    }

    private static void LoadFromFile() {
        try {

            FileInputStream fileIn = new FileInputStream("/Users/jiawei/Desktop/duke/data/duke.txt");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            // taskList = (ArrayList<Task>) Arrays.asList((Task[]) objIn.readObject());
            taskList = (ArrayList) objIn.readObject();
            objIn.close();
            fileIn.close();

            System.out.println(LINE);
            System.out.println("    File has been successfully loaded!");
            System.out.println(LINE);
        } catch (IOException e) {
            System.out.println(LINE);
            e.printStackTrace();
            System.out.println(LINE);
        } catch (ClassNotFoundException e) {
            System.out.println(LINE);
            System.out.println("    Class not found.");
            e.printStackTrace();
            System.out.println(LINE);
        }
    }


    // the following line indicates the entry point to the program.
    public static void main(String[] args) {

        PrintGreeting();

        LoadFromFile();

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
                try {

                    // 1. user could input number that is out of bounds of the list array
                    // 2. or user did not input any number at all.
                    // 3. or user input something else rather than a number.

                    // Integer.valueOf() or Integer.parseInt() converts string to integer.
                    String[] temp = command.split(" ");
                    if (temp.length == 1) {
                        throw new DukeNoInfoException(); // user input: done 'blank'.
                    } else {
                        int taskNumber = Integer.parseInt(temp[1]); // user input: done 'string'.
                        taskList.get(taskNumber - 1).setAsDone(); // -1 to get the index of the task in myList. user input: done 'number not in list'.
                        PrintAcknowledgeDone(taskNumber);
                        SaveToFile();
                    }

                }
                // if want to catch 2 exceptions that are can be handled the same way, use (exception1 | exception2).
                catch (IndexOutOfBoundsException e) {
                    System.out.println(LINE);
                    System.out.println("    You can only mark a task in the list as done. Please input another index within the list.");
                    System.out.println(LINE);
                }

                catch (NumberFormatException e) {
                    System.out.println(LINE);
                    System.out.println("    The item you wanted to mark as done is not provided as its index. Please input the index of the task.");
                    System.out.println(LINE);
                }

                catch (DukeNoInfoException e) {
                    System.out.println(LINE);
                    System.out.println(e.Feedback());
                    System.out.println(LINE);
                }
            }

            else { // there is a new task.
                try {
                    String[] temp = command.split(" ", 2);
                    String firstWord = temp[0]; // to extract the first word.

                    switch (firstWord) {

                        case "todo":

                            if (temp.length == 1) {
                                throw new DukeNoInfoException();
                            } else {
                                Todo newToDo = new Todo(temp[1]); // temp[1] is the remaining words after extracting first word.
                                taskList.add(newToDo);
                                PrintTaskAdded();
                                SaveToFile();
                                break;
                            }

                        case "event":

                            if (temp.length == 1) {
                                throw new DukeNoInfoException();
                            } else {

                                // PatternSyntaxException on splitting with regex "/" if no "/" is provided.
                                String[] tempEvent = temp[1].split("/", 2); // to get the description and the by/at when.

                                if (tempEvent.length == 1) {
                                    throw new DukeNoFullInfoException();
                                } else {

                                    // input: event xxxx /at cccc
                                    // temp: event | xxxx /at cccc
                                    // tempEvent: xxxx | at cccc
                                    // tempEventWhen: at | cccc

                                    String[] tempEventWhen = tempEvent[1].split(" ", 2); // to get the when without the at/by word.
                                    String eventDescription = tempEvent[0];

                                    if (tempEventWhen.length == 1) {
                                        throw new DukeNoFullInfoException(tempEventWhen[0]);
                                    } else {
                                        String eventAt = tempEventWhen[1];
                                        LocalDateTime formattedDateTime = LocalDateTime.parse(eventAt, formatter); // LocalDatetime.parse(String, DateTimeFormatter).
                                        Event newEvent = new Event(eventDescription, formattedDateTime);
                                        taskList.add(newEvent);
                                        PrintTaskAdded();
                                        SaveToFile();
                                        break;
                                    }
                                }
                            }

                        case "deadline":

                            if (temp.length == 1) {
                                throw new DukeNoInfoException();
                            } else {

                                String[] tempDeadline = temp[1].split("/", 2); // to get the description and the by/at when.

                                if (tempDeadline.length == 1) {
                                    throw new DukeNoFullInfoException();
                                }
                                else {
                                String[] tempDeadlineWhen = tempDeadline[1].split(" ", 2); // to get the when without the at/by word.
                                String deadlineDescription = tempDeadline[0];

                                if (tempDeadlineWhen.length == 1) {
                                    throw new DukeNoFullInfoException(tempDeadlineWhen[0]);
                                } else {
                                    String deadlineWhen = tempDeadlineWhen[1];
                                    LocalDateTime formattedDateTime = LocalDateTime.parse(deadlineWhen, formatter);
                                    Deadline newDeadline = new Deadline(deadlineDescription, formattedDateTime);
                                    taskList.add(newDeadline);
                                    PrintTaskAdded();
                                    SaveToFile();
                                    break;
                                }
                                }

                            }

                        default: // none of the 3 specified type of tasks.
                            throw new DukeException(command);

                    }
                }

                catch (PatternSyntaxException e) { // no /by or /at provided for events/deadlines.
                    System.out.println(LINE);
                    System.out.println("    Please provide the full information.\n"
                            + "    1. For events, please include /at _____.\n"
                            + "    2. For deadlines, please include /by _____.\n");
                    System.out.println(LINE);
                }

                catch (DukeNoInfoException e) {
                    System.out.println(LINE);
                    System.out.println(e.Feedback());
                    System.out.println(LINE);
                }

                catch (DukeNoFullInfoException e) {
                    System.out.println(LINE);
                    System.out.println(e.Feedback());
                    System.out.println(LINE);
                }

                catch (DateTimeParseException e) {
                    System.out.println(LINE);
                    System.out.println("    Format of Date/Time provided is incorrect.");
                    System.out.println(LINE);
                }

                catch (DukeException e) {
                   System.out.println(LINE);
                   System.out.println(e.Feedback());
                   System.out.println(LINE);
                }
            }
        }
    }
}


