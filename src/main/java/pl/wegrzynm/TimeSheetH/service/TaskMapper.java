package pl.wegrzynm.TimeSheetH.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.wegrzynm.TimeSheetH.controller.dto.TaskRequest;
import pl.wegrzynm.TimeSheetH.controller.dto.TaskResponse;
import pl.wegrzynm.TimeSheetH.repository.EmployeeRepository;
import pl.wegrzynm.TimeSheetH.repository.ProjectRepository;
import pl.wegrzynm.TimeSheetH.repository.TaskRepository;
import pl.wegrzynm.TimeSheetH.repository.entity.Task;

import java.time.OffsetDateTime;

@Component
@AllArgsConstructor
public class TaskMapper {

    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;

    private final TaskRepository taskRepository;


    public Task map(TaskRequest taskRequest){
        return Task.builder()
                .taskName(taskRequest.getTaskName())
                .description(taskRequest.getDescription())
                .duration(taskRequest.getDuration())
                .startDate(OffsetDateTime.now())
                .project(projectRepository
                        .findById(taskRequest.getProjectId())
                        .orElseThrow(()->new IllegalArgumentException("Project with id: " +
                                taskRequest.getProjectId() +
                                "not found.")))
                .employee(employeeRepository
                        .findById(taskRequest.getEmployeeId())
                        .orElseThrow(()->new IllegalArgumentException("Employee with id: " +
                                taskRequest.getEmployeeId() +
                                "not found.")))
                .build();
    }

    public TaskResponse map(Task task){
        return TaskResponse.builder()
                .taskName(task.getTaskName())
                .description(task.getDescription())
                .duration(task.getDuration())
                .startDate(task.getStartDate())
                .projectId(task.getProject().getId())
                .employeeId(task.getEmployee().getId())
                .build();
    }


}
