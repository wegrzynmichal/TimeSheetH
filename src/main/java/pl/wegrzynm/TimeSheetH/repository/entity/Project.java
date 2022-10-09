package pl.wegrzynm.TimeSheetH.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PROJECT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "PROJECT_NAME")
    private String projectName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "MANAGER_ID")
    private Integer managerId;

    @Column(name = "START_DATE")
    private OffsetDateTime startDate;

//    @JsonManagedReference(value = "projects")
    @ManyToMany(mappedBy = "projects")
//    @JsonIgnoreProperties("projects")
    private List<Employee> employees = new ArrayList<>();

}
