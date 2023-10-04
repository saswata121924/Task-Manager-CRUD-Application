package com.example.MongoDBDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void addTask(TaskCreateRequest taskCreateRequest){
        Task task = taskCreateRequest.to();
        task.setTaskId(UUID.randomUUID().toString());
        taskRepository.save(task);
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(String taskId){
        return taskRepository.findById(taskId).orElse(null);
    }

    public List<Task> getTaskBySeverity(int severity){
        return taskRepository.findBySeverity(severity);
    }

    public Task updateTask(String taskId, TaskCreateRequest taskCreateRequest) throws Exception {
        Task task = taskRepository.findById(taskId).orElse(null);
        if (task==null)
            throw new Exception("Task not present in the system");
        task.setDescription(taskCreateRequest.getDescription());
        task.setAssignee(taskCreateRequest.getAssignee());
        task.setSeverity(taskCreateRequest.getSeverity());
        task.setStoryPoint(taskCreateRequest.getStoryPoint());
        return taskRepository.save(task);
    }

    public String deleteTask(String taskId){
        taskRepository.deleteById(taskId);
        return "Task "+taskId+" has been deleted from the system";
    }
}
