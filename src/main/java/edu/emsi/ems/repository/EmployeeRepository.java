package edu.emsi.ems.repository;

import edu.emsi.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface    EmployeeRepository extends JpaRepository<Employee, Integer> {
}
