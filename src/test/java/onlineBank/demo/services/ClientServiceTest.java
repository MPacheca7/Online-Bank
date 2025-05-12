package onlineBank.demo.services;

import onlineBank.demo.models.Client;
import onlineBank.demo.models.ERole;
import onlineBank.demo.models.Role;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientServiceTest {

    @Autowired
    ClientService clientService;

    @Test
    @DisplayName("New client")
    public void generateClient(){
        Client holder = new Client();

        holder.setName("Miguel");
        holder.setPassword("123");
        holder.setDni("42345678A");
        holder.setEmail("holder@prueba.com");
        holder.setRole(ERole.ROLE_HOLDER);

        clientService.saveClient(holder);
    }
}
