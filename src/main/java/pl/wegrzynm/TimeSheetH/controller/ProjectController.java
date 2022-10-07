package pl.wegrzynm.TimeSheetH.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wegrzynm.TimeSheetH.repository.entity.Project;
import pl.wegrzynm.TimeSheetH.service.ProjectService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping(path = "/project")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Project project){
        projectService.save(project);
    }

    @GetMapping(path = "/project")
    public ResponseEntity<List<Project>> findAll(){
        return ResponseEntity.ok(projectService.findAll());
    }

}
