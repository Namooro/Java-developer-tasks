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
            Task overdueTask = new Task(1, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).minusDays(1).toInstant()), "overDueTask", "1");
            Task normalTask = new Task(2, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()), "normalTask", "normalCategory");
            Task oneCategoryTask = new Task(3, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()), "oneCategory", "1");
            taskRepository.saveAll(Arrays.asList(normalTask, overdueTask, oneCategoryTask));
            switch (args[0]) {
                case "display_all":
                    System.out.println("Display all tasks");
                    System.out.println(taskService.findAllTasks());
                    break;
                case "overdue":
                    System.out.println("Display one overdue task");
                    System.out.println(taskService.findOverdueTasks());
                    break;
                case "category":
                    System.out.println("OneCategory task");
                    System.out.println(taskService.findTasksByCategory("1"));
                    break;
                default:
                    System.out.println("Error in arguments; Displaying all tasks");
                    System.out.println(taskService.findAllTasks());
            }
        }
    }
}

