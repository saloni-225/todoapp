package com.example.webapp.todoapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;


//I have commented this controller so that spring boot doesn't refer
// this class but go to refer the TodoControllerJPA.
//@Controller
@SessionAttributes("name")
public class TodoController {
	
	public TodoController(ToDoService todoService) {
		super();
		this.todoService=todoService;
	}
	
//	@Autowired
	private ToDoService todoService;
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username=getLoggedUsername(model);
		List<Todo>todos=todoService.findByUsername(username);
		model.put("todos", todos);
		return "listTodos";
	}

	private String getLoggedUsername(ModelMap model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showAddTodo(ModelMap model) {
		String username=getLoggedUsername(model);
		Todo todo=new Todo(0,username,"",LocalDate.now(), false);
		model.put("todo", todo);
		
		return "addTodo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String showNewTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) return "addTodo";
		String username=getLoggedUsername(model);
		todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodoTask(id);
		return "redirect:list-todos";
	}
	//this is for seeing the update page only , it has no feature to update.
//	@RequestMapping("update-todo")
//	public String updateTodo(@RequestParam int id,ModelMap model) {
//		Todo todo=todoService.findById(id);
//		model.put("todo", todo);
//		return "addTodo";
//	}
	
	@RequestMapping(value="update-todo" ,method=RequestMethod.GET)
	public String updateTodo(@RequestParam int id,ModelMap model) {
		Todo todo=todoService.findById(id);
		model.put("todo", todo);
		return "addTodo";
	}
	@RequestMapping(value="update-todo" ,method=RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "addTodo";
		}
		String username=getLoggedUsername(model);
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	
	
//	@RequestMapping(value="add-todo", method=RequestMethod.GET)
//	public String showAddTodo() {
//		return "addTodo";
//	}
//	
//	@RequestMapping(value="add-todo", method=RequestMethod.POST)
//	public String showNewTodo(@RequestParam String decsription,ModelMap model) {
//		String username=(String)model.get("name");
//		todoService.addTodo(username, decsription, LocalDate.now().plusYears(1), false);
//		return "redirect:list-todos";
//	}

}
