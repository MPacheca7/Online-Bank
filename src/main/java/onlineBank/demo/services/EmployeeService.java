package onlineBank.demo.services;

import onlineBank.demo.models.ERole;
import onlineBank.demo.models.Employee;
import onlineBank.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Employee saveEmployee(Employee employee){
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }

    public Employee newEmployee(Employee employee){
        Employee employee1 = new Employee();

        employee1.setName(employee.getName());
        employee1.setDni(employee.getDni());
        employee1.setEmail(employee.getEmail());
        employee1.setPassword(passwordEncoder.encode(employee.getPassword()));
        employee1.setEmployeeNumber("N" + generateEmployeeNumber());
        employee1.setRole(ERole.ROLE_ADMIN);

        return employeeRepository.save(employee1);
    }

    private String generateEmployeeNumber() {
        int randomNumber = ThreadLocalRandom.current().nextInt(9000) + 1000;
        return String.valueOf(randomNumber);
    }

}
