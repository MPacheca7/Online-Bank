package onlineBank.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// ESTA CLASE YA NO SE USA. SE PUEDE BORRAR LA TABLA TAMBIEN

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private ERole name;
}
