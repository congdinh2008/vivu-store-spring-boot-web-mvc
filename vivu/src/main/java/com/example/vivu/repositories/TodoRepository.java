package com.example.vivu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vivu.models.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
