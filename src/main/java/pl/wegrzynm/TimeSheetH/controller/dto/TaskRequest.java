package pl.wegrzynm.TimeSheetH.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.wegrzynm.TimeSheetH.repository.entity.Employee;
import pl.wegrzynm.TimeSheetH.repository.entity.Project;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskRequest {

    private String taskName;
    private String description;
    private OffsetDateTime startDate;
    private int duration;
    private Integer projectId;
    private Integer employeeId;
}
