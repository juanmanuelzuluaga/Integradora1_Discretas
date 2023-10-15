import java.util.HashMap;
import java.util.Map;

public class TaskHashStorage {
    private Map<String, Task> taskMap; 

    public TaskHashStorage() {
        taskMap = new HashMap<>();
    }

    public void addTask(String taskId, Task task) {
        taskMap.put(taskId, task);
    }

    public Task getTask(String taskId) {
        return taskMap.get(taskId);
    }

    public void modifyTask(String taskId, Task modifiedTask) {
        if (taskMap.containsKey(taskId)) {
            taskMap.put(taskId, modifiedTask);
        }
    }

    public void deleteTask(String taskId) {
        taskMap.remove(taskId);
    }

    public Map<String, Task> getAllTasks() {
        return taskMap;
    }

    public void addReminder(String reminderId, Reminder newReminder) {
    }

    public boolean containsTask(String taskIdOrReminderId) {
        return false;
    }

    public boolean containsReminder(String taskIdOrReminderId) {
        return false;
    }

    public Reminder getReminder(String taskIdOrReminderId) {
        return null;
    }

    public void modifyReminder(String taskIdOrReminderId, Reminder existingReminder) {
    }

    public void deleteReminder(String taskIdOrReminderId) {
    }
}

