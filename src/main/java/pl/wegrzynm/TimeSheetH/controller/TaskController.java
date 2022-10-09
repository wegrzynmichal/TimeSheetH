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

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class TaskController {

    @Autowired
    private final TaskService taskService;

    @PostMapping(path = "/task")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid TaskRequest taskRequest){
        taskService.save(taskRequest);
    }

    @GetMapping(path = "/task")
    public ResponseEntity<List<TaskResponse>> findAll(){
        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping(path = "/task/{id}")
    public ResponseEntity<TaskResponse> findById(@PathVariable Integer id) {
        if(!taskService.existById(id)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(taskService.findById(id));
    }

    @GetMapping(path = "/task/project/{id}")
    public ResponseEntity<List<TaskResponse>> findByProjectId(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.findByProjectId(id));
    }

    @PutMapping(path = "/task/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid TaskRequest taskRequest, @PathVariable Integer id){
        if(!taskService.existById(id)){
            return ResponseEntity.notFound().build();
        }
        taskService.update(taskRequest,id);
        return ResponseEntity.ok().build();
    }

//    @PatchMapping(path = "/task/{id}")
//    public ResponseEntity<?> patch(@RequestBody TaskRequest taskRequest, @PathVariable Integer id){
//        if(!taskService.existById(id)){
//            return ResponseEntity.notFound().build();
//        }
//        taskService.update(taskRequest,id);
//        return ResponseEntity.ok().build();
//    }

}
