package com.example.task_manager.tasks_manager.tasks;

import org.springframework.data.repository.ListCrudRepository;

// @Repository
public interface TaskRepository extends ListCrudRepository<Task,Integer>{

  
}
