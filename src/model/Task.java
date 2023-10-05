import java.util.Date;

public class Task {

    private String title;
    private String description;
    private Date deadline;
    private String priority;

    public Task(String title, String description, Date deadline, String priority) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString(){
        return "Tarea{" +
                "titulo='" + title + '\'' +
                ", descripcion='" + description + '\'' +
                ", fechaLimite=" + deadline +
                ", prioritaria=" + priority +
                '}';
    }
}
