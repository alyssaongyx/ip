package ally;

import java.util.ArrayList;
import java.util.Scanner;

import ally.exceptions.AllyException;
import ally.tasks.AllyList;
import ally.tasks.Task;

/**
 * Ui Class for the design of the chatbot.
 */
public class Ui {
    private static final String LINE = "____________________________________________________________";
    private static final String GREETING = "Hello! I'm ALLY\nWhat can I do for you?\n";
    private static final String BYE = "Bye. Hope to see you again soon!";

    private Scanner ipt = new Scanner(System.in);

    /**
     * Reads the next line of the input.
     *
     * @return next line of the input
     */
    public String readCommand() {
        return this.ipt.nextLine();
    }

    /**
     * Prints LINE.
     */
    public static void showLine() {
        System.out.println(LINE);
    }

    /**
     * Function that provides the starting message and greeting.
     */
    public void start() {
        showLine();
        System.out.println(GREETING);
        showLine();
    }

    /**
     * Function that provides the bye message when the user
     * ends the chatbot.
     */
    public void bye() throws AllyException {
        System.out.println(LINE);
        System.out.println(BYE);
        System.out.println(LINE);
    }

    /**
     * Prints the list of tasks in allyList.
     *
     * @param allyList
     */
    public void showList(AllyList allyList) {
        System.out.println("Here are the tasks in your list:\n");
        for (int i = 0, len = allyList.getSize(); i < len; i++) {
            System.out.println((i + 1) + ". " + allyList.getTask(i).toString());
        }
    }

    /**
     * Prints the deleted tasks and total number of tasks left.
     *
     * @param task
     * @param total
     */
    public void showDelete(Task task, int total) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("\t" + task);
        System.out.println("Now you have " + total + " tasks in the list.");
    }

    /**
     * Marks the task as done and prints to inform the user the task is done.
     *
     * @param task
     */
    public void showMarked(Task task) {
        task.setMarkDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("\t" + task);
    }

    /**
     * Marks the task as not done and prints to inform the user the task is not done.
     *
     * @param task
     */
    public void showNotMarked(Task task) {
        task.setMarkNotDone();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("\t" + task);
    }

    /**
     * Throws AllyException if load() function fails.
     *
     * @throws AllyException
     */
    public void showLoadingError() throws AllyException {
        throw new AllyException("Unable to load!");
    }

    /**
     * Shows error from run() function in Ally.
     *
     * @param message
     */
    public void showError(String message) {
        System.out.println(message);
    }

    /**
     * Shows the matching tasks.
     *
     * @param tasks ArrayList
     */
    public void showMatchingTask(ArrayList<Task> tasks) {
        System.out.println("Here are the matching tasks in your list:\n");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + tasks.get(i));
        }
    }
}
