/*
 * You can use the following import statements
 * 
 * 
 * 
 */

package com.example.todo;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.*;

// Do not modify the below code

public class TodoService implements TodoRepository {

    private static HashMap<Integer, Todo> todoList = new HashMap<>();
    int todoId = 6;

    public TodoService() {
        todoList.put(1, new Todo(1, "Watch Movie", "LOW", "TO DO"));
        todoList.put(2, new Todo(2, "Finish Project", "HIGH", "IN PROGRESS"));
        todoList.put(3, new Todo(3, "Buy Groceries", "MEDIUM", "TO DO"));
        todoList.put(4, new Todo(4, "Learning from NxtWave", "HIGH", "IN PROGRESS"));
        todoList.put(5, new Todo(5, "Go for a Run", "MEDIUM", "DONE"));

    }

    // Do not modify the above code

    // Write your code here
    @Override
    public ArrayList<Todo> getTodos() {
        Collection<Todo> todos = todoList.values();
        ArrayList<Todo> todo = new ArrayList<>(todos);
        return todo;
    }

    @Override
    public Todo getTodoById(int todoId) {
        Todo todo = todoList.get(todoId);
        if (todo != null) {
            return todo;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Todo addTodo(Todo todo) {
        todo.setId(todoId);
        todoList.put(todoId, todo);
        todoId += 1;
        return todo;
    }

    @Override
    public Todo updateTodo(int todoId, Todo todo) {
        Todo changeTodo = todoList.get(todoId);
        if (changeTodo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (todo.getTodo() != null) {
            changeTodo.setTodo(todo.getTodo());
        }
        if (todo.getPriority() != null) {
            changeTodo.setPriority(todo.getPriority());
        }
        if (todo.getStatus() != null) {
            changeTodo.setStatus(todo.getStatus());
        }
        return changeTodo;
    }

    @Override
    public void deleteTodo(int todoId) {
        Todo changeTodo = todoList.get(todoId);
        if (changeTodo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else {
            todoList.remove(todoId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}
