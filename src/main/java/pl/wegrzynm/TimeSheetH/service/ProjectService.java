package pl.wegrzynm.TimeSheetH.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wegrzynm.TimeSheetH.repository.EmployeeRepository;
import pl.wegrzynm.TimeSheetH.repository.ProjectRepository;
import pl.wegrzynm.TimeSheetH.repository.entity.Employee;
import pl.wegrzynm.TimeSheetH.repository.entity.Project;

import javax.management.Query;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ProjectService {
    @Autowired
    private final ProjectRepository projectRepository;

    @Autowired
    private final EmployeeService employeeService;

    public void save(Project project){

//        projectRepository.save(project);
        Project newProject = new Project();
        newProject.setProjectName(project.getProjectName());
        newProject.setDescription(project.getDescription());
        newProject.setManagerId(project.getManagerId());
        newProject.getEmployees()
                .addAll(project
                        .getEmployees()
                        .stream()
                        .map(e -> {
                            if(!employeeService.existById(e.getId()))
                                throw new IllegalArgumentException("Employee with id: " + e.getId() + " not exist.");
                            Employee ee = employeeService.findById(e.getId());
                            ee.getProjects().add(newProject);
                            return ee;
                        }).toList());
        projectRepository.save(newProject);
    }

    public List<Project> findAll(){
        return projectRepository.findAll();
    }




}
