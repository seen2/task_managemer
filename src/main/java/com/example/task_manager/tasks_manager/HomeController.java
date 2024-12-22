package com.example.task_manager.tasks_manager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
  @GetMapping("/")
  public String getHme() {
      return "Task Managment";
  }
  
}
