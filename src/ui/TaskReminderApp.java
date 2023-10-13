import java.util.Scanner;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class TaskReminderApp {
    private TaskHashStorage taskStorage;
    private TaskPriority priorityQueue;
    private TaskQueue taskQueue;
    private UndoStack<UndoAction> undoStack;

    public TaskReminderApp() {
        taskStorage = new TaskHashStorage();
        priorityQueue = new TaskPriority();
        taskQueue = new TaskQueue();
        undoStack = new UndoStack<>();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("===== Task and Reminder Management =====");
            System.out.println("1. Add Task");
            System.out.println("2. Add Reminder");
            System.out.println("3. Modify Task or Reminder");
            System.out.println("4. Delete Task or Reminder");
            System.out.println("5. View Tasks and Reminders");
            System.out.println("6. Undo Last Action");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    addReminder();
                    break;
                case 3:
                    modifyTaskOrReminder();
                    break;
                case 4:
                    deleteTaskOrReminder();
                    break;
                case 5:
                    viewTasksAndReminders();
                    break;
                case 6:
                    undoLastAction();
                    break;
                case 7:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private void addTask() {
        // lógica para agregar una tarea
        // acción a la pila de deshacer
    }

    private void addReminder() {
        // lógica para agregar un recordatorio
        // acción a la pila de deshacer
    }

    private void modifyTaskOrReminder() {
        // lógica para modificar una tarea o recordatorio
        // acción a la pila de deshacer
    }

    private void deleteTaskOrReminder() {
        // lógica para eliminar una tarea o recordatorio
        // acción a la pila de deshacer
    }

    private void viewTasksAndReminders() {
        // lógica para mostrar una lista de tareas y recordatorios
    }

    private void undoLastAction() {
        // lógica para deshacer la última acción utilizando la pila de deshacer
    }

    public static void main(String[] args) {
        TaskReminderApp app = new TaskReminderApp();
        app.run();
    }
}

