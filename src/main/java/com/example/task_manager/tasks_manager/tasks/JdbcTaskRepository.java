package com.example.task_manager.tasks_manager.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class JdbcTaskRepository {

  JdbcClient jdbcClient;
  private static final Logger logger = LoggerFactory.getLogger(TaskRepository.class);

  public JdbcTaskRepository(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  // Initialize the task list
  // @PostConstruct
  // public void init() {
  //   this.taskList.add(new Task("1a", "1a", "Task 1", "Description 1", false));
  //   this.taskList.add(new Task("1", "2a", "Task 2", "Description 2", false));
  //   this.taskList.add(new Task("1", "3a", "Task 3", "Description 3", false));
  // }

  // Task List
  private final List<Task> taskList = new ArrayList<>();

  // Get all tasks
  public List<Task> getAllTask() {
    return jdbcClient.sql("select * from tasks").query(Task.class).list();
  }

  // find by Id

  public Optional<Task> findTaskById(String id) {
    return jdbcClient.sql("select * from tasks where id = ?").param(id).query(Task.class).optional();
  }

  // add tasks
  public void addTask(Task t) {
    var updated = jdbcClient.sql("insert into tasks (userId, title, description) values ( ?, ?, ?)")
        .params(List.of(t.userId(), t.title(), t.description())).update();
    Assert.state(updated == 1, "Failed to add");
    logger.info("Todo added");
  }

  // update task
  public void updateTask(Task t, String id) {
    jdbcClient.sql("update tasks set title = ?, description = ?, completed = ? where id = ?")
        .params(List.of(t.title(), t.description(), t.completed(), id)).update();
  }

  // delete Task
  public void deleteTask(String id) {
    var deleted=jdbcClient.sql("DELETE FROM tasks WHERE id = ?").param(id).update();
    logger.info("Todo deleted:"+deleted);
  }

  // search tasks
  public List<Task> searchTask(String search, boolean status) {
    List<Task> searchList = new ArrayList<>();
    if (search == null) {
      return this.taskList;
    }
    for (Task t : this.taskList) {
      if (t.title().contains(search) || t.description().contains(search) || t.completed() == status) {
        searchList.add(t);
      }
    }
    return searchList;
  }

}
