package nosql.service;

import nosql.dao.TaskRepository;
import nosql.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Task findTaskByName(String name) {
        return taskRepository.findByName(name);
    }

    @Override
    public void deleteTaskByName(String name) {
        taskRepository.delete(taskRepository.findByName(name));
    }

    @Override
    public void addSubTask(Task mainTask, String subTaskName) {
        if (mainTask != null) {
            Task subTask = new Task(subTaskName);
            taskRepository.insert(subTask);
            mainTask.addSubTask(subTask);
            taskRepository.save(mainTask);
        }
    }

    @Override
    public void addTasks(List<String> taskList) {
        for (String taskName : taskList) {
            if (taskRepository.findByName(taskName) == null) {
                Task task = new Task(taskName);
                taskRepository.save(task);
            }
        }
    }

    @Override
    public void removeSubTask(Task mainTask, Task subTask) {
        mainTask.getSubtasks().remove(subTask);
        taskRepository.save(mainTask);
        taskRepository.delete(subTask);
    }

    @Override
    public void removeSubTasks(Task mainTask) {
        List<Task> subTasksForDelete = mainTask.getSubtasks();
        mainTask.setSubtasks(Collections.emptyList());
        taskRepository.save(mainTask);
        taskRepository.deleteAll(subTasksForDelete);
    }


    @Override
    public List<Task> findOverdueTasks() {
        Query query = new Query();
        query.addCriteria(Criteria.where("due_date").lt(LocalDate.now()));
        return mongoTemplate.find(query, Task.class);
    }

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

}
