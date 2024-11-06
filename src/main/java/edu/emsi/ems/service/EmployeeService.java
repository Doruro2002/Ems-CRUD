package edu.emsi.ems.service;

import edu.emsi.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public EmployeeDto getEmployeeById(Long id);
    public List<EmployeeDto> getAllEmployee();
    public EmployeeDto updateEmployee(Long id , EmployeeDto employeeDto);
    public void deleteEmployee(Long id);

}
