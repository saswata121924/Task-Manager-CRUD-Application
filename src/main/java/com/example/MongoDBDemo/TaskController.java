package com.example.MongoDBDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public void createTask(@RequestBody TaskCreateRequest taskCreateRequest){
        taskService.addTask(taskCreateRequest);
    }

    @PutMapping("/update")
    public Task updateTask(@RequestParam("id") String taskId, @RequestBody TaskCreateRequest taskCreateRequest)
            throws Exception {
        return taskService.updateTask(taskId, taskCreateRequest);
    }

    @DeleteMapping("/delete")
    public String deleteTask(@RequestParam("id") String taskId){
        return taskService.deleteTask(taskId);
    }

    @GetMapping("/get/all")
    public List<Task> getAllTasks(){
        return taskService.getTasks();
    }

    @GetMapping("/get")
    public Task getTaskById(@RequestParam("id") String taskId){
        return taskService.getTaskById(taskId);
    }
}
