// package com.example.task_manager.tasks_manager;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
// public class WebConfig implements WebMvcConfigurer {

//   // @Override
//   // public void addViewControllers(ViewControllerRegistry registry) {
//   //   // Prefix all controllers with /api/v1
//   //   registry.addViewController("/api/v1/**");
//   // }

//   @Override
//   public void configurePathMatch(PathMatchConfigurer configurer) {
//     // Add a prefix globally
//     configurer.addPathPrefix("/api/v1", c -> true); // Apply the prefix to all controllers
//   }
// }
