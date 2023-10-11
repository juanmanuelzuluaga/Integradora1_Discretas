import java.util.PriorityQueue;
import java.util.Comparator;

public class TaskPriority {
    private PriorityQueue<Task> priorityQueue;

    public TaskPriority() {
        priorityQueue = new PriorityQueue<>(new TaskPriorityComparator());
    }

    public void add(Task task) {
        priorityQueue.offer(task);
    }

    public Task poll() {
        return priorityQueue.poll();
    }

    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    private class TaskPriorityComparator implements Comparator<Task> {
        @Override
        public int compare(Task task1, Task task2) {
            return task1.getPriority().compareTo(task2.getPriority());
        }
    }
}

