public class UndoAction {
    private String actionType;
    private Task task;

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
}

