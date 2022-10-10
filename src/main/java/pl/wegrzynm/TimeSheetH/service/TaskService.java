package pl.wegrzynm.TimeSheetH.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wegrzynm.TimeSheetH.controller.dto.TaskRequest;
import pl.wegrzynm.TimeSheetH.controller.dto.TaskResponse;
import pl.wegrzynm.TimeSheetH.repository.ProjectRepository;
import pl.wegrzynm.TimeSheetH.repository.TaskRepository;
import pl.wegrzynm.TimeSheetH.repository.entity.Task;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskService {

    @Autowired
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final TaskMapper mapper;

    public void save(Task toSave){
        taskRepository.save(toSave);
    }

    public void save(TaskRequest toSave){
        var task = mapper.map(toSave);
        taskRepository.save(task);
    }

    public void delete(Integer id){
        var task = taskRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Task with id: " + id + " not found.")
        );
        taskRepository.delete(task);
    }

    public void update(TaskRequest toUpdate, Integer id){
//        var task = taskRepository.findById(id)
//                .orElseThrow(
//                        ()-> new IllegalArgumentException("Task with id: " + id + " not found.")
//                );
        if(!taskRepository.existsById(id)) {
            throw new IllegalArgumentException("Task with id: " + id + " not found.");

        }
        else {
            var task = mapper.map(toUpdate);
            task.setId(id);
            //System.out.println(task.toString());
            taskRepository.save(task);
        }
    }

//    public void patch(TaskRequest toUpdate, Integer id){
//        var task = taskRepository.findById(id);
//        toUpdate.
//    }

    public List<TaskResponse> findAll(){
        return taskRepository.findAll()
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    public TaskResponse findById(Integer id){
        return taskRepository.findById(id)
                .map(a->mapper.map(a))
                .orElseThrow(
                        ()-> new IllegalArgumentException("Task with id: " + id + " not found.")
                );
    }

    public List<TaskResponse> findByProjectId(Integer id){
        return taskRepository.findAll()
                .stream()
                .filter(t->t.getProject().getId().equals(id))
                .map(mapper::map)
                .toList();
    }

    public List<TaskResponse> findByEmployeeId(Integer id){
        return taskRepository.findAll()
                .stream()
                .filter(t->t.getEmployee().getId().equals(id))
                .map(mapper::map)
                .toList();
    }

    public boolean existById(Integer id){
        return taskRepository.existsById(id);
    }

}
