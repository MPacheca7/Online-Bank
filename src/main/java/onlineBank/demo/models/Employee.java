package onlineBank.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Employee extends User{

    @NotEmpty
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
