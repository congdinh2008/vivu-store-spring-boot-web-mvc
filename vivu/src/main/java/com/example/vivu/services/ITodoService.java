package com.example.vivu.services;

import java.util.List;

import com.example.vivu.models.Todo;

public interface ITodoService {

    // Save operation
    Todo save(Todo todo);

    // Read operation
    Todo getById(Long id);

    // Read operation
    List<Todo> getAll();

    // Update operation
    Todo update(Todo todo, Long id);

    // Delete operation
    void deleteById(Long todoId);
}