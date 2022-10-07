package pl.wegrzynm.TimeSheetH.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wegrzynm.TimeSheetH.repository.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
