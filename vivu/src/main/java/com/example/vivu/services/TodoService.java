package com.example.vivu.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vivu.models.Todo;
import com.example.vivu.repositories.TodoRepository;

@Service
public class TodoService implements ITodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo getById(Long id) {
        return todoRepository.findById(id).get();
    }

    @Override
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo update(Todo todo, Long id) {
        Todo todoEntity = todoRepository.findById(id).get();

        if (Objects.nonNull(todo.getTitle()) && !"".equalsIgnoreCase(todo.getTitle())) {
            todoEntity.setTitle(todo.getTitle());
        }

        if (todoEntity.getIsCompleted() != todo.getIsCompleted()) {
            todoEntity.setIsCompleted(todo.getIsCompleted());
        }

        return todoRepository.save(todoEntity);
    }

    @Override
    public void deleteById(Long todoId) {
        todoRepository.deleteById(todoId);
    }
}
