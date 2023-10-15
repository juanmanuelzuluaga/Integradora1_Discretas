public class UndoAction {
    private String actionType;
    private Task task;
    private Reminder reminder;

    public UndoAction(Reminder reminder, String actionType) {
        this.reminder = reminder;
        this.actionType = actionType;
    }

    public UndoAction(String actionType, Task task) {
        this.actionType = actionType;
        this.task = task;
    }

    public String getActionType() {
        return actionType;
    }

    public Task getTask() {
        return task;
    }

    public Reminder getReminder(){
        return reminder;
    }

    public Object getActionData() {
        return null;
    }
}

