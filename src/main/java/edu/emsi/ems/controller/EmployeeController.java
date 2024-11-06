package edu.emsi.ems.controller;

import edu.emsi.ems.dto.EmployeeDto;
import edu.emsi.ems.entity.Employee;
import edu.emsi.ems.service.EmployeeService;
import edu.emsi.ems.service.serviceImpl.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    /*POST*/
    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);

        return ResponseEntity.ok()
                .header("Employee Created Successfully")
                .body(savedEmployee);
    }

    /*GET*/
    @GetMapping({"/afficher/{id}"})
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok()
                .header("Found")
                .body(employeeDto);
    }

    /*Get all */
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployee();
        return ResponseEntity.ok(employeeDtos);
    }

    /*PUT*/
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,
                                                      @RequestBody EmployeeDto employeeDto) {
        EmployeeDto employeeDtoUpdated = employeeService.updateEmployee(id, employeeDto);
        return ResponseEntity.ok(employeeDtoUpdated);
    }


    /*DELETE*/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee Successfully Deleted");
    }

}
