package pl.wegrzynm.TimeSheetH.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wegrzynm.TimeSheetH.controller.dto.TaskRequest;
import pl.wegrzynm.TimeSheetH.controller.dto.TaskResponse;
import pl.wegrzynm.TimeSheetH.repository.entity.Project;
import pl.wegrzynm.TimeSheetH.repository.entity.Task;
import pl.wegrzynm.TimeSheetH.service.TaskService;

import java.util.List;

@RestController
@AllArgsConstructor
public class TaskController {

    @Autowired
    private final TaskService taskService;

    @PostMapping(path = "/task")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody TaskRequest task){
        taskService.save(task);
    }

    @GetMapping(path = "/task")
    public ResponseEntity<List<TaskResponse>> findAll(){
        return ResponseEntity.ok(taskService.findAll());
    }
}
