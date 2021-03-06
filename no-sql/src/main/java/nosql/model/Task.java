package nosql.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Document
public class Task {


    @Field("create_date")
    private LocalDate createDate;
    @Field("due_date")
    private Date dueDate;
    @Field("category")
    private String category;
    @Indexed
    @Id
    @Field("name")
    private String name;
    @Field("description")
    private String description;
    @Field("subtasks")
    private List<Task> subtasks;

    public Task(Date dueDate, String name, String description, List<Task> subtasks, String category) {
        this.createDate = LocalDate.now();
        this.dueDate = dueDate;
        this.name = name;
        this.description = description;
        this.subtasks = subtasks;
        this.category = category;
    }

    public Task(Date dueDate, String name)  {
        this.createDate = LocalDate.now();
        this.dueDate = dueDate;
        this.name = name;
    }
    public Task() {
    }


    public Task(Date dueDate, String name, String category) {
        this.createDate = LocalDate.now();
        this.dueDate = dueDate;
        this.category = category;
        this.name = name;
    }

    public Task(String name) {
        this.name = name;
        this.createDate = LocalDate.now();
        this.dueDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).plusDays(1).toInstant());
    }

    public Task(String name, String category, String description) {
        this.category = category;
        this.name = name;
        this.dueDate = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).plusDays(1).toInstant());
    }

    @Override
    public String toString() {
        return "Task{" +
                "createDate=" + createDate +
                ", dueDate=" + dueDate +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", subtasks=" + subtasks +
                '}' + "\n";
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getTaskName() {
        return name;
    }

    public void setTaskName(String taskName) {
        this.name = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Task> subtasks) {
        this.subtasks = subtasks;
    }

    public void addSubTask(Task subTask) {
        this.subtasks.add(subTask);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
