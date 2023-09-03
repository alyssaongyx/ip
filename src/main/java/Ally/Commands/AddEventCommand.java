package Ally.Commands;

import Ally.*;
import Ally.Exceptions.AllyException;
import Ally.Tasks.AllyList;
import Ally.Tasks.Event;

public class AddEventCommand extends Commands {
    private final String description;
    private final String from;
    private final String to;

    /**
     * Constructor for AddEventCommand.
     *
     * @param description
     * @param from
     * @param to
     */
    public AddEventCommand(String description, String from, String to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    /**
     * Creates new instance of Event.
     * Add the event task into allyList.
     * Saved the tasks into the saved file.
     * Prints the task.
     *
     * @param allyList
     * @param ui
     * @param storage
     * @throws AllyException
     */
    @Override
    public void run(AllyList allyList, Ui ui, Storage storage) throws AllyException {
        try {
            Event event = new Event(description, from, to);
            allyList.addElements(event);
            storage.appendToFile(event);
            allyList.printNewList(event);
        } catch (AllyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
