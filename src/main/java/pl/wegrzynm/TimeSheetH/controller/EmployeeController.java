package pl.wegrzynm.TimeSheetH.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wegrzynm.TimeSheetH.repository.entity.Employee;
import pl.wegrzynm.TimeSheetH.repository.entity.Project;
import pl.wegrzynm.TimeSheetH.service.EmployeeService;

import java.util.List;

@AllArgsConstructor
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping(path = "/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Employee employee){
        employeeService.save(employee);
    }

    @GetMapping(path = "/employee")
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(employeeService.findAll());
    }
}
