package gt.edu.umg.task.controllers;

import gt.edu.umg.task.entities.Task;
import gt.edu.umg.task.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping
    public List<Task> listTask(){

        return taskService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Task GenerarTask( @PathVariable Long id){
        return taskService.findById(id);
    }

    @PostMapping()
    public Task createTask( @PathVariable ("id") Long id, @RequestBody Task task){
        taskService.create(task);
        return task;
    }

    @PutMapping(value =  "/{id}")
    public Task modifyTask( @PathVariable Long id,@RequestBody  Task task){
        taskService.modify(id, task);
        return task;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.delete(id);
    }
}
