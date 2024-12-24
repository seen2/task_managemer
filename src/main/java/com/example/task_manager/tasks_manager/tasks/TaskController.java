package com.example.task_manager.tasks_manager.tasks;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class TaskController {

  private final TaskRepository taskRepository;

  public TaskController(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @GetMapping("/tasks")
  public List<Task> getMethodName(@RequestParam(required = false) boolean status,
      @RequestParam(required = false) String search) {
    return taskRepository.findAll();
  }

  @GetMapping("/tasks/{id}")
  public Optional<Task> getTaskById(@PathVariable Integer id) {
    return taskRepository.findById(id);
  }

  @PostMapping("/tasks")
  @ResponseStatus(HttpStatus.CREATED)
  public void createTasks(@RequestBody @Valid Task task) {
    taskRepository.save(task);
  }

  @PutMapping("tasks/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateTasksByID(@PathVariable String id, @RequestBody @Valid Task task) {
    taskRepository.save(task);
  }

  @DeleteMapping("/tasks/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteTaskById(@PathVariable Integer id) {
    taskRepository.deleteById(id);
  }

}
