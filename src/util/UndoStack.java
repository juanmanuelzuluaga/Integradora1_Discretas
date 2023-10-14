import java.util.Stack;

public class UndoStack<T> {
    private Stack<T> stack;

    private UndoStack<UndoAction> undoStack;


    public UndoStack() {
        stack = new Stack<>();
    }

    public void push(T action) {
        stack.push(action);
    }

    public T pop() {
        if (!isEmpty()) {
            return stack.pop();
        }
        return null;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }


}

