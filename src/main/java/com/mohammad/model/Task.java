package com.mohammad.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="task_name")
	private String taskName;
	
	@Lob
	@Column(name="description")
	private String description;
	
	@Column(name="priority")
	private String priority;
	
	@Column(name="init_date")
	private LocalDate initDate;
	
	@Column(name="deadline")
	private LocalDate deadline;
	
	public Task() {initDate=LocalDate.now();}

	public int getId() {return id;}

	public void setId(int id) {this.id = id;}

	public String getTaskName() {return taskName;}

	public void setTaskName(String taskName) {this.taskName = taskName;}

	public String getDescription() {return description;}

	public void setDescription(String description) {this.description = description;}

	public String getPriority() {return priority;}

	public void setPriority(String priority) {this.priority = priority;}

	public LocalDate getInitDate() {return initDate;}

	public void setInitDate(LocalDate initDate) {this.initDate = initDate;}

	public LocalDate getDeadline() {return deadline;}

	public void setDeadline(LocalDate deadline) {this.deadline = deadline;}
}
