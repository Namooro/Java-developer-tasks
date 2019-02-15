package nosql.service;

import nosql.model.Task;

import java.util.List;

public interface TaskService {
    void addSubTask(Task mainTask, String subTaskName);

    void addTasks(List<String> taskList);

    void removeSubTask(Task mainTask, Task subTask);

    void removeSubTasks(Task mainTask);

    List<Task> findOverdueTasks();

    List<Task> findAllTasks();

    Task findTaskByName(String name);

    List<Task> findTasksByCategory(String category);

    void deleteTaskByName(String name);
}
