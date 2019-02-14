package nosql.service;

import nosql.dao.TaskRepository;
import nosql.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;

    public Task findTaskByName(String name) {
        return taskRepository.findByName(name);
    }

    public void deleteTaskByName(String name) {
        taskRepository.delete(taskRepository.findByName(name));
    }

    public void addSubTask(String taskName, String subTaskName) {
        Task mainTask = taskRepository.findByName(taskName);
        if (mainTask != null) {
            Task subTask = new Task(subTaskName);
            taskRepository.insert(subTask);
            mainTask.addSubTask(subTask);
            taskRepository.save(mainTask);
        }
    }


}
