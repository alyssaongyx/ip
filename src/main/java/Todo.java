public class Todo extends Task {

    /**
     * Constructor for todo.
     * @param description
     */
    public Todo(String description) {
        super(description);
    }

    @Override
    public String formatFile() {
        return "T" + " | " + (isDone ? "1" : "0") + " | " + description + "\n";
    }
    /**
     * Overrides the toString() method in Task.
     * @return the string
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
