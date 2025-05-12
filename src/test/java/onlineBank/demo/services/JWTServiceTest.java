package onlineBank.demo.services;


import onlineBank.demo.repository.ClientRepository;
import onlineBank.demo.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JWTServiceTest {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    JwtService jwtService;

    @Test
    @DisplayName("Generar Token")
    void generateToken(){
        String token = jwtService.generateToken("Gema", "[ROLE_ADMIN]");

        System.out.println("El token: " + token);
    }
}
