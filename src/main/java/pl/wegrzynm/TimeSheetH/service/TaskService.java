package pl.wegrzynm.TimeSheetH.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wegrzynm.TimeSheetH.controller.dto.TaskRequest;
import pl.wegrzynm.TimeSheetH.controller.dto.TaskResponse;
import pl.wegrzynm.TimeSheetH.repository.TaskRepository;
import pl.wegrzynm.TimeSheetH.repository.entity.Task;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskService {

    @Autowired
    private final TaskRepository taskRepository;
    private final TaskMapper mapper;

    public void save(TaskRequest toSave){
        var task = mapper.map(toSave);
        taskRepository.save(task);
    }

    public List<TaskResponse> findAll(){
        return taskRepository.findAll()
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }
}
