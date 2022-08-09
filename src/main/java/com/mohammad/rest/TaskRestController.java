package com.mohammad.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohammad.exception.TaskNotFoundException;
import com.mohammad.model.Task;
import com.mohammad.service.TaskService;

@RestController
@RequestMapping("/api")
public class TaskRestController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/tasks")
	public List<Task> getTasks(){return taskService.getTasks();}
	
	@GetMapping("/tasks/{taskId}")
	public Task getTask(@PathVariable int taskId) {
		
		Task task = taskService.getTask(taskId);
		if(task == null) {
			throw new TaskNotFoundException("Task id not found - "+ taskId);
		}
		return task;
	}
	
	@PostMapping("/tasks")
	public Task addTask(@RequestBody Task task) {
		task.setId(0);
		taskService.saveTask(task);
		return task;
	}
	
	@PutMapping("/tasks")
	public Task updateTask(@RequestBody Task task) {
		taskService.saveTask(task);
		return task; 
	}
	
	@DeleteMapping("/tasks/{taskId}")
	public String deleteTask(@PathVariable int taskId) {
		
		Task task = taskService.getTask(taskId);
		if(task==null) {
			throw new TaskNotFoundException("Task id not found - " + taskId);
		}
		taskService.deleteTask(taskId);
		return "Deleted Task id - "+taskId;
	}
	
}
