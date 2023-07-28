package com.example.vivu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.vivu.models.Todo;
import com.example.vivu.services.ITodoService;

@Controller
@RequestMapping(value = "/todos")
public class TodoController {
    @Autowired
    private ITodoService todoService;

    @RequestMapping(value = "/index")
    public String getAllTodos(Model model) {
        List<Todo> todos = todoService.getAll();
        model.addAttribute("todos", todos);

        return "todo-list";
    }

    @RequestMapping(value = "/{id}")
    public String getTodoById(Model model, @PathVariable("id") Long id) {
        Todo todo = todoService.getById(id);
        model.addAttribute("todo", todo);
        return "todo-item";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "create-todo";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String save(@ModelAttribute Todo todo) {
        System.out.println("Hello");
        todoService.save(todo);
        return "redirect:/todos/index";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model) {
        Todo todoEntity = todoService.getById(id);
        model.addAttribute("todo", todoEntity);
        return "update-todo";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute Todo department, @PathVariable("id") Long id) {
        todoService.update(department, id);
        return "redirect:/todos/index";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTodoById(Model model, @PathVariable("id") Long id) {
        todoService.deleteById(id);
        return "redirect:/todos/index";
    }
}
