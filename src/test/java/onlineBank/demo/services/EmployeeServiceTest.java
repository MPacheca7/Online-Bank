package onlineBank.demo.services;

import onlineBank.demo.models.ERole;
import onlineBank.demo.models.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeServiceTest {
    @Autowired
    EmployeeService employeeService;

    @Test
    @DisplayName("New employee")
    public void generateEmployee(){
        Employee employee = new Employee("Pedro", "00000000B", "employee1@prueba.com", ERole.ROLE_ADMIN, 101010, "1234");
    }
}
