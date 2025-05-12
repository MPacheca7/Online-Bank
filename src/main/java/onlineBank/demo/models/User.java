package onlineBank.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    // probar de hacer la clase abstracta
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;

    @Pattern(regexp = "^[0-9]{8}[A-Z]$", message = "DNI invalid")
    // añadir validación para que sea único
    @Column(unique = true)
    private String dni;

    @NotEmpty
    @Email(message = "Email not find")
    private String email;

//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn(name = "role_id")
    @Enumerated(EnumType.STRING)
    private ERole role;

    public User(String name, String dni, String email, ERole role) {
        this.name = name;
        this.dni = dni;
        this.email = email;
        this.role = role;
    }
}
