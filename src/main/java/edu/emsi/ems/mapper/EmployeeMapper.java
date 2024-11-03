package edu.emsi.ems.mapper;

import edu.emsi.ems.dto.EmployeeDto;
import edu.emsi.ems.entity.Employee;

public class EmployeeMapper {
    public static Employee mapToEmployeeDto(Employee employee){
        return new Employee(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
    public static EmployeeDto mapToEmployee(EmployeeDto employeeDto){
        return new EmployeeDto(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
