package nosql;

import nosql.dao.TaskRepository;
import nosql.model.Task;
import nosql.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

@SpringBootApplication
public class NoSqlApplication implements CommandLineRunner {

    @Autowired
    TaskService taskService;
    @Autowired
    TaskRepository taskRepository;

    public static void main(String[] args) {
        SpringApplication.run(NoSqlApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("no args provided");
        } else {
            taskRepository.deleteAll();
            Task overdueTask = new Task(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).minusDays(1).toInstant()), "overDueTask", "1");
            Task normalTask = new Task(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()), "normalTask", "normalCategory");
            Task oneCategoryTask = new Task(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()), "oneCategory", "1");
            taskRepository.saveAll(Arrays.asList(normalTask, overdueTask, oneCategoryTask));
            Scanner sc = new Scanner(System.in).useDelimiter("\n");
            while (sc.hasNext()) {
                String[] message = sc.next().split(" ");
                String command = message[0];
                switch (command) {
                    case "display_all":
                        System.out.println("Display all tasks\n");
                        System.out.println(taskService.findAllTasks());
                        break;
                    case "overdue":
                        System.out.println("Display one overdue task\n");
                        System.out.println(taskService.findOverdueTasks());
                        break;
                    case "category":
                        System.out.println("OneCategory task\n");
                        System.out.println(taskService.findTasksByCategory("1"));
                        break;
                    case "new":
                        Task task;
                        if (message.length == 3) {
                            task = new Task(message[1], message[2], message[3]);
                        } else
                            task = new Task(message[1]);
                        taskRepository.save(task);
                        System.out.println(String.format("task_with name %s created", task.getName()));
                        break;
                    case "delete":
                        try {
                            taskService.deleteTaskByName(message[1]);
                            System.out.println(String.format("task_with name %s is deleted", message[1]));
                        } catch (Exception e) {
                            System.err.println("Error:\n" + e.getMessage());
                        }
                        break;
                    case "description":
                        System.out.println(String.format("detected task by description: %s", message[1]));
                        System.out.println(taskRepository.findByDescription(message[1]));
                        break;
                    case "add_subtask":
                        try {
                            Task mainTask = taskService.findTaskByName(message[1]);
                            Task subTask = new Task(message[2]);
                            mainTask.addSubTask(new Task(message[2]));
                            taskRepository.saveAll(Arrays.asList(mainTask, subTask));
                            System.out.println(String.format("Subtask with name %s added to task with name %s", message[1], message[2]));
                        } catch (Exception e) {
                            System.err.println("Error:\n" + e.getMessage());
                        }
                    case "remove_subtasks":
                        try {
                            Task mainTask = taskService.findTaskByName(message[1]);
                            mainTask.setSubtasks(Collections.emptyList());
                            taskRepository.save(mainTask);
                        } catch (Exception e) {
                            System.err.println("Error:\n" + e.getMessage());
                        }
                    default:
                        System.out.println("Error in arguments; Displaying all tasks");
                        System.out.println(taskService.findAllTasks());
                }
            }
        }
    }
}

