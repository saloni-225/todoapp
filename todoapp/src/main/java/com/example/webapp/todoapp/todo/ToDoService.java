package com.example.webapp.todoapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ToDoService {
	
	private static List<Todo>todos =new ArrayList<>();
	private static int count=0;
	static {
		todos.add(new Todo(++count,"in28minutes","Learn AWS 1",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++count,"in28minutes","DevOps 1",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++count,"in28minutes","FullStack 1",LocalDate.now().plusYears(3),false));
	}
	public List<Todo> findByUsername(String username){
		Predicate<? super Todo>predicate=todo->todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	public void addTodo(String username,String description,LocalDate targetDate, boolean isDone ) {
		Todo todo=new Todo(++count,username,description,targetDate,isDone);
		todos.add(todo);
		
	}
	public void deleteTodoTask(int id) {
		Predicate<? super Todo> predicate=todo->todo.getId()==id;
		todos.removeIf(predicate);
	}
	public Todo findById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo>predicate=todo->todo.getId()==id;
		Todo todo=todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		deleteTodoTask(todo.getId());
		todos.add(todo);
		
	}
	

}
