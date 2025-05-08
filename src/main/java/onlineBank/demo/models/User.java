package onlineBank.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @Pattern(regexp = "^[0-9]{8}[A-Z]$", message = "DNI invalid")
    private String dni;

    @NotEmpty
    @Email(message = "Email not find")
    private String email;

    @OneToOne(fetch = FetchType.EAGER)
    private Role role = new Role();

    public User(String name, String dni, String email, Role role) {
        this.name = name;
        this.dni = dni;
        this.email = email;
        this.role = role;
    }
}
