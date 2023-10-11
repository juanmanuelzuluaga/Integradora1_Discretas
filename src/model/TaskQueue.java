import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {
    private Queue<Task> queue;

    public TaskQueue() {
        queue = new LinkedList<>();
    }

    public void enqueue(Task task) {
        queue.offer(task);
    }

    public Task dequeue() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

