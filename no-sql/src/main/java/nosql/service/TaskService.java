package nosql.service;

import nosql.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> findOverDueTasks();
}
