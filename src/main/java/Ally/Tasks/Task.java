package Ally.Tasks;

public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor for Ally.Tasks.Task.
     * @param description
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public String toString() {
        return "[" + getStatusIcon() + "] " + this.description;
    }

    public void setMarkDone() {
        this.isDone = true;
    }

    public void setMarkNotDone() {
        this.isDone = false;
    }

    public String formatFile() {
        return " ";
    }
}
