package onlineBank.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Employee extends User{

    @Column(name = "employee_number")
    private int employeeNumber;

    public Employee(String name, String dni, String email, Role role, int employeeNumber) {
        super(name, dni, email, role);
        this.employeeNumber = employeeNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                '}';
    }
}
