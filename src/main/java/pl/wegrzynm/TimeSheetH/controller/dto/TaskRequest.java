package pl.wegrzynm.TimeSheetH.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskRequest {

    @NotBlank
    private String taskName;
    @NotBlank
    private String description;
    private OffsetDateTime startDate;
    @NotNull
    private int duration;
    @NotNull
    private Integer projectId;
    @NotNull
    private Integer employeeId;
}
