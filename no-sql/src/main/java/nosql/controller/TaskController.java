package nosql.controller;

import nosql.dao.TaskRepository;
import nosql.model.Task;
import nosql.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Task> getAllTasks() {
        return taskService.findAllTasks();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Task getTaskById(@PathVariable("id") Integer id) throws Exception {
        return taskRepository.findById(id).orElseThrow(() -> new Exception("Task not found"));
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Task getTaskByName(@PathVariable("name") String name) throws Exception {
        return taskService.findTaskByName(name);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.PUT)
    public void modifyTaskByName(@PathVariable("name") String name, @Valid @RequestBody Task task) {
        task.setName(name);
        taskRepository.save(task);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Task createTask(@Valid @RequestBody Task task) {
        taskRepository.save(task);
        return task;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable("id") Integer id) throws Exception {
        taskRepository.delete(taskRepository.findById(id).orElseThrow(() -> new Exception("Task not found")));
    }

    @RequestMapping(value = "/overdueTasks", method = RequestMethod.GET)
    public List<Task> overdueTasks() {
        return taskService.findOverdueTasks();
    }

    @RequestMapping(value = "{id}/addSubTask", method = RequestMethod.POST)
    public void addSubTask(@PathVariable("id") Integer id, @Valid @RequestBody Task subTask) throws Exception {
        Task mainTask = taskRepository.findById(id).orElseThrow(() -> new Exception("Task not found"));
        mainTask.addSubTask(subTask);
        taskRepository.save(mainTask);
    }
}
