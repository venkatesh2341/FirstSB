package com.task1.postAndPatch.Controller;

import com.task1.postAndPatch.DTO.Todo;
import com.task1.postAndPatch.Service.TaskService;
import com.task1.postAndPatch.Service.TaskServiceImpl1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/v1/todos")
public class Task1Controller {

    List<Todo> todos ;
    TaskService taskService;


    Task1Controller(TaskService taskService)
    {
        todos= new ArrayList<>();
        todos.add(new Todo(1,"clean", false));
        todos.add(new Todo(3, "eat", true));
        //Constructor based dependency injection
        this.taskService = taskService;
    }

    @GetMapping("/service")
    private String getService(){
        return taskService.getService();
    }


    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos()
    {
        return new ResponseEntity<>( todos, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity getTodo(@RequestParam(required = false, defaultValue = "false") boolean isCompleted)
    {
        System.out.println("Request param is " + isCompleted);
        List<Todo> fileterdTodo= todos.stream().filter(todo -> todo.getStatus() == isCompleted).toList();
        return ResponseEntity.ok().body(fileterdTodo);
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo)
    {
        todos.add(todo);
        return ResponseEntity.accepted().body(todo);
    }

    @PatchMapping("/{id}/{task}")
    public ResponseEntity<?> updateTodo(@PathVariable int id, @PathVariable String task)
    {
        Optional<Todo> todo = todos.stream().filter(ele -> ele.getId() == id).findFirst();
        if(todo.isPresent()) {
            int ind = todos.indexOf(todo.get());
            todos.get(ind).setTask(task);
            return ResponseEntity.accepted().body(todo.get());
        }
        return new ResponseEntity<>("Todo not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable("id") int taskId)
    {
        Optional<Todo> todo= todos.stream().filter(ele -> ele.getId() == taskId).findFirst();
        if(todo.isPresent())
        {
            Todo delTodo= todo.get();
            todos.remove(todo.get());

            return ResponseEntity.ok().body(delTodo);
        }
        else
        {
            return new ResponseEntity<>("Todo not found", HttpStatus.NOT_FOUND);
        }
    }
}
