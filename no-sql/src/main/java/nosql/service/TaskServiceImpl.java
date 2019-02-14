package nosql.service;

import nosql.dao.TaskRepository;
import nosql.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    protected MongoTemplate mongoTemplate;

    public Task findTaskByName(String name) {
        return taskRepository.findByName(name);
    }

    public void deleteTaskByName(String name) {
        taskRepository.delete(taskRepository.findByName(name));
    }

    public void addSubTask(Task mainTask, String subTaskName) {
        if (mainTask != null) {
            Task subTask = new Task(subTaskName);
            taskRepository.insert(subTask);
            mainTask.addSubTask(subTask);
            taskRepository.save(mainTask);
        }
    }

    public void removeSubTask(Task mainTask, Task subTask) {
        mainTask.getSubtasks().remove(subTask);
        taskRepository.save(mainTask);
        taskRepository.delete(subTask);
    }


    @Override
    public List<Task> findOverDueTasks() {
        Query query = new Query();
        query.addCriteria(Criteria.where("due_date").lt(LocalDate.now()));
        return mongoTemplate.find(query, Task.class);
    }
}
