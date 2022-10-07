package pl.wegrzynm.TimeSheetH.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wegrzynm.TimeSheetH.repository.EmployeeRepository;
import pl.wegrzynm.TimeSheetH.repository.ProjectRepository;
import pl.wegrzynm.TimeSheetH.repository.entity.Project;

import java.util.List;


@Service
@AllArgsConstructor
public class ProjectService {
    @Autowired
    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;

//    public ProjectService(ProjectRepository projectRepository) {
//        this.projectRepository = projectRepository;
//    }
    public void save(Project project){
        projectRepository.save(project);
    }

    public List<Project> findAll(){
        return projectRepository.findAll();
    }

}
