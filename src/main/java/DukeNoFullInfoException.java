public class DukeNoFullInfoException extends DukeException {

    private String byOrAt = "";

    DukeNoFullInfoException() {
        super();
    }

    DukeNoFullInfoException(String byOrAt) {
        super();
        this.byOrAt = byOrAt;
    }

    @Override
    public String Feedback() {
        if (byOrAt.equals("by") || byOrAt.equals("By")) {
            return "    Please provide the full information.\n"
                    + "    For deadlines, please include /by _____.\n";
        }
         else if (byOrAt.equals("at") || byOrAt.equals("At")) {
            return "    Please provide the full information.\n"
                    + "    For events, please include /at _____.\n";
        } else {
            return "    Please provide the full information.\n"
                    + "    1. For events, please include /at _____.\n"
                    + "    2. For deadlines, please include /by _____.\n";
        }
    }
}