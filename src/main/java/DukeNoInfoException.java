public class DukeNoInfoException extends DukeException {

    public DukeNoInfoException() {
        super();
    }

    @Override
    public String Feedback() {
        return "    No information provided. Please input your task information.";
    }
}