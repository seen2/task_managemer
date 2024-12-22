package com.example.task_manager.tasks_manager.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class TaskRepository {

  // Initialize the task list
  @PostConstruct
  public void init(){
    this.taskList.add(new Task("1a", "1a", "Task 1", "Description 1", false));
    this.taskList.add(new Task("1", "2a", "Task 2", "Description 2", false));
    this.taskList.add(new Task("1", "3a", "Task 3", "Description 3", false));
  }

  // Task List
  private final List<Task> taskList = new ArrayList<>();

  // Get all tasks
  public List<Task> getAllTask() {
    return this.taskList;
  }

  //find by Id

  public Optional<Task> findTaskById(String id){
    return this.taskList.stream().filter(t->t.taskId().equals(id)).findFirst();
  }

  // add tasks
  public void addTask(Task t) {
    this.taskList.add(t);
  }

  //update task
  public void updateTask(Task t, String id){
    this.findTaskById(id).ifPresent(existingTask -> {
        int index = this.taskList.indexOf(existingTask);
        this.taskList.set(index, t);
      });
  }

  //delete Task
  public void deleteTask(String id){
    this.taskList.removeIf(task -> task.taskId().equals(id));
  }

  //search tasks
  public List<Task> searchTask(String search, boolean status){
    List<Task> searchList = new ArrayList<>();
    if(search == null){
      return this.taskList;
    }
    for(Task t: this.taskList){
      if(t.title().contains(search) || t.description().contains(search) || t.completed()==status){
        searchList.add(t);
      }
    }
    return searchList;
  }

}
