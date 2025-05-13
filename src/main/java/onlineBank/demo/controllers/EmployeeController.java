package onlineBank.demo.controllers;

import lombok.AllArgsConstructor;
import onlineBank.demo.models.Client;
import onlineBank.demo.models.Employee;
import onlineBank.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/register/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee saved = employeeService.newEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
