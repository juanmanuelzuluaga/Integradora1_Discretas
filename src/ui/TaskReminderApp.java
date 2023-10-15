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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adding a new task:");
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter deadline (dd/MM/yyyy): ");
        String deadlineStr = scanner.nextLine();

        System.out.print("Enter priority (Prioritaria/No prioritaria): ");
        String priority = scanner.nextLine();

        UserValidator UserInputValidator = null;
        if (!UserValidator.isValidDate(deadlineStr) || !UserValidator.isValidPriority(priority)) {
            System.out.println("Invalid input. Task not added.");
            return;
        }

        Date deadline = DateUtil.parseDate(deadlineStr);

        Task newTask = new Task(title, description, deadline, priority);

        String taskId = generateUniqueId();
        taskStorage.addTask(taskId, newTask);

        undoStack.push(new UndoAction("Add Task", newTask));

        System.out.println("Task added successfully.");
    }

    private String generateUniqueId() {
        return null;
    }


    private void addReminder() {

    }



    private void modifyTaskOrReminder() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Modifying a task or reminder:");
        System.out.print("Enter the unique ID of the task or reminder to modify: ");
        String taskIdOrReminderId = scanner.nextLine();

        if (!taskStorage.containsTask(taskIdOrReminderId) && !taskStorage.containsReminder(taskIdOrReminderId)) {
            System.out.println("Task or reminder not found. Nothing to modify.");
            return;
        }

        boolean isTask = taskStorage.containsTask(taskIdOrReminderId);

        if (isTask) {
            System.out.println("Modifying a task:");
        } else {
            System.out.println("Modifying a reminder:");
        }

        System.out.print("Enter new title: ");
        String newTitle = scanner.nextLine();

        System.out.print("Enter new description: ");
        String newDescription = scanner.nextLine();

        if (newTitle.isEmpty() || newDescription.isEmpty()) {
            System.out.println("Invalid input. Title and description cannot be empty.");
            return;
        }

        if (isTask) {
            Task existingTask = taskStorage.getTask(taskIdOrReminderId);
            existingTask.setTitle(newTitle);
            existingTask.setDescription(newDescription);
            taskStorage.modifyTask(taskIdOrReminderId, existingTask);
            undoStack.push(new UndoAction("Modify Task", existingTask));
        } else {
            Reminder existingReminder = taskStorage.getReminder(taskIdOrReminderId);
            existingReminder.setTitle(newTitle);
            existingReminder.setDescription(newDescription);
            taskStorage.modifyReminder(taskIdOrReminderId, existingReminder);
            undoStack.push(new UndoAction(existingReminder, "Modify Reminder"));
        }

        System.out.println("Task or reminder modified successfully.");
    }


    private void deleteTaskOrReminder() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Deleting a task or reminder:");
        System.out.print("Enter the unique ID of the task or reminder to delete: ");
        String taskIdOrReminderId = scanner.nextLine();

        if (!taskStorage.containsTask(taskIdOrReminderId) && !taskStorage.containsReminder(taskIdOrReminderId)) {
            System.out.println("Task or reminder not found. Nothing to delete.");
            return;
        }

        boolean isTask = taskStorage.containsTask(taskIdOrReminderId);

        if (isTask) {
            System.out.println("Deleting a task:");
        } else {
            System.out.println("Deleting a reminder:");
        }

        if (isTask) {
            Task deletedTask = taskStorage.getTask(taskIdOrReminderId);
            taskStorage.deleteTask(taskIdOrReminderId);
            undoStack.push(new UndoAction("Delete Task", deletedTask));
        } else {
            Reminder deletedReminder = taskStorage.getReminder(taskIdOrReminderId);
            taskStorage.deleteReminder(taskIdOrReminderId);
            undoStack.push(new UndoAction(deletedReminder, "Delete Reminder"));
        }

        System.out.println("Task or reminder deleted successfully.");
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

