package ally.commands;

import ally.Storage;
import ally.Ui;
import ally.exceptions.AllyException;
import ally.exceptions.EmptyArgumentException;
import ally.tasks.AllyList;
import ally.tasks.Event;

import java.io.IOException;

/**
 * AddEventCommand class inherits from Commands.
 */
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
    public String run(AllyList allyList, Ui ui, Storage storage) {
        try {
            assert ui != null;
            assert storage != null;
            if (description == null || description.trim().isEmpty()) {
                throw new EmptyArgumentException();
            }
            Event event = new Event(description, from, to);
            allyList.addElements(event);
            storage.appendToFile(event);
            return allyList.printNewList(event);
        } catch (EmptyArgumentException e) {
            return ui.showEmptyError();
        } catch (IOException e) {
            return ui.showLoadingError();
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
