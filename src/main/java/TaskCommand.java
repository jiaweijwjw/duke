import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.regex.PatternSyntaxException;

public class TaskCommand extends Command {

    private static final String dateTimePattern = "dd/MM/yyyy HHmm";
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);

    private String userInput;

    public TaskCommand(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

        String[] temp = userInput.split(" ", 2);
        String firstWord = temp[0]; // to extract the first word.

        try {

            switch (firstWord) {

                case "todo":

                    if (temp.length == 1) {
                        throw new DukeNoInfoException();
                    } else {
                        Todo newToDo = new Todo(temp[1]); // temp[1] is the remaining words after extracting first word.
                        tasks.add(newToDo);
                        ui.printTaskAdded(tasks);
                        storage.save(ui, tasks);
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
                                tasks.add(newEvent);
                                ui.printTaskAdded(tasks);
                                storage.save(ui, tasks);
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
                        } else {
                            String[] tempDeadlineWhen = tempDeadline[1].split(" ", 2); // to get the when without the at/by word.
                            String deadlineDescription = tempDeadline[0];

                            if (tempDeadlineWhen.length == 1) {
                                throw new DukeNoFullInfoException(tempDeadlineWhen[0]);
                            } else {
                                String deadlineWhen = tempDeadlineWhen[1];
                                LocalDateTime formattedDateTime = LocalDateTime.parse(deadlineWhen, formatter);
                                Deadline newDeadline = new Deadline(deadlineDescription, formattedDateTime);
                                tasks.add(newDeadline);
                                ui.printTaskAdded(tasks);
                                storage.save(ui, tasks);
                                break;
                            }
                        }

                    }

                default: // none of the 3 specified type of tasks.
                    throw new DukeException(userInput);
            }
        }
        catch (NullPointerException e) {
            System.out.println("cheebai");
            e.printStackTrace();
        }
        catch (PatternSyntaxException e) {
            ui.printPatternSyntaxException();
        }
        catch (DateTimeParseException e) {
            ui.printDateTimeParseException();
        }
        catch (DukeNoFullInfoException e) {
            ui.printDukeNoFullInfoException(e);
        }
        catch (DukeNoInfoException e) {
            ui.printDukeNoInfoException(e);
        }
        catch (DukeException e) {
            ui.printDukeException(e);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}