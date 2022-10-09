package pl.wegrzynm.TimeSheetH.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wegrzynm.TimeSheetH.controller.dto.TaskResponse;
import pl.wegrzynm.TimeSheetH.repository.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
