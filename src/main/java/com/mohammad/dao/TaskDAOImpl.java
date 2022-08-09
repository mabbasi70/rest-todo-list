package com.mohammad.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mohammad.model.Task;

@Repository
public class TaskDAOImpl implements TaskDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Task> getTasks() {
		Session session = sessionFactory.getCurrentSession();
		Query<Task> query = session.createQuery("from Task", Task.class);
		List<Task> tasks = query.getResultList();
		return tasks;
	}

	@Override
	public void saveTask(Task task) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(task);
	}

	@Override
	public Task getTask(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Task task = session.get(Task.class, theId);
		return task;
	}

	@Override
	public void deleteTask(int theId) {
		Session session = sessionFactory.getCurrentSession();
		Task task = session.get(Task.class, theId);
		session.delete(task);
	}

}
