package pl.wegrzynm.TimeSheetH.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wegrzynm.TimeSheetH.repository.EmployeeRepository;
import pl.wegrzynm.TimeSheetH.repository.ProjectRepository;
import pl.wegrzynm.TimeSheetH.repository.entity.Employee;
import pl.wegrzynm.TimeSheetH.repository.entity.Project;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public void save(Employee employee){
        employeeRepository.save(employee);
    }


}
