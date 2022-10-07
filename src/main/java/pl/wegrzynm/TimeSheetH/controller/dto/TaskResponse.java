package pl.wegrzynm.TimeSheetH.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponse {
    private String taskName;
    private String description;
    private OffsetDateTime startDate;
    private int duration;
    private Integer projectId;
    private Integer employeeId;
}
