package pl.wegrzynm.TimeSheetH.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "TASK")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TASK_NAME")
    private String taskName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "START_DATE")
    private OffsetDateTime startDate;

    @Column(name = "DURATION")
    private int duration;

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
    private Employee employee;


}
