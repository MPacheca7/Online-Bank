package onlineBank.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import onlineBank.demo.models.ERole;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private String name;
    private String dni;
    private String email;
    private String password;
}
