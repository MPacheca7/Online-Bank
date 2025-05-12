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
        Employee employee = new Employee(
                "Alfredo",
                "11000000Z",
                "employee3@prueba.com",
                ERole.ROLE_ADMIN,
                "n552233",
                "1234");

        try {
            employeeService.saveEmployee(employee);
            System.out.println("Employee: " + employee);
        } catch (Exception e) {
             e.printStackTrace();
        }
    }
}
