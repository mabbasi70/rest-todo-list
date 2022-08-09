package com.mohammad.service;

import java.util.List;

import com.mohammad.model.Task;

public interface TaskService {
	
	public List<Task> getTasks();

	public void saveTask(Task task);

	public Task getTask(int theId);

	public void deleteTask(int theId);
}
