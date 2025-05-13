package onlineBank.demo.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Employee extends User{

    private String employeeNumber;

    @NotEmpty
    private String password;

    public Employee(String name, String dni, String email, ERole role, String employeeNumber, String password) {
        super(name, dni, email, role);
        this.employeeNumber = employeeNumber;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", password='" + password + '\'' +
                '}';
    }
}
