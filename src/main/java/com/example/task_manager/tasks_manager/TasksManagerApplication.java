package com.example.task_manager.tasks_manager;

// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;

// import com.example.task_manager.tasks_manager.tasks.Task;

@SpringBootApplication
public class TasksManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksManagerApplication.class, args);

	}

	// @Bean
	// CommandLineRunner commandLineRunner() {
	// 	return args -> {
	// 		Task task = new Task("1", "1", "Task 1", "Description 1", false);
	// 		System.out.println(task);
	// 	};
	// }

}
