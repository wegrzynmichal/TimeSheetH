package pl.wegrzynm.TimeSheetH.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

//    @JsonBackReference(value = "project_id")
    @ManyToMany(cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE })

    @JoinTable(
            name = "Employee_Project",
            joinColumns = @JoinColumn(name = "employee_id") ,
            inverseJoinColumns =  @JoinColumn(name = "project_id")
    )
    @JsonIgnoreProperties("employees")
    List<Project> projects = new ArrayList<>();

}
