import java.util.HashMap;
import java.util.Map;

public class TaskHashStorage {
    private Map<String, Task> taskMap; // Usamos una tabla hash para almacenar las tareas

    public TaskHashStorage() {
        taskMap = new HashMap<>();
    }

    // Método para agregar una tarea o recordatorio a la tabla hash
    public void addTask(String taskId, Task task) {
        taskMap.put(taskId, task);
    }

    // Método para obtener una tarea o recordatorio por su identificador único
    public Task getTask(String taskId) {
        return taskMap.get(taskId);
    }

    // Método para modificar una tarea o recordatorio existente
    public void modifyTask(String taskId, Task modifiedTask) {
        if (taskMap.containsKey(taskId)) {
            taskMap.put(taskId, modifiedTask);
        }
    }

    // Método para eliminar una tarea o recordatorio por su identificador único
    public void deleteTask(String taskId) {
        taskMap.remove(taskId);
    }

    // Método para obtener una lista de todas las tareas y recordatorios almacenados
    public Map<String, Task> getAllTasks() {
        return taskMap;
    }
}

