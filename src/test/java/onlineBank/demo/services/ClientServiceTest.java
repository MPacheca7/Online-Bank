package onlineBank.demo.services;

import onlineBank.demo.models.BankAccount;
import onlineBank.demo.models.Client;
import onlineBank.demo.models.ERole;
import onlineBank.demo.repository.BankAccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientServiceTest {

    @Autowired
    ClientService clientService;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Test
    @DisplayName("New client")
    public void generateClient(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setIBAN("DE89370400440532013000");
        bankAccountRepository.save(bankAccount);

        Client holder = new Client();

        holder.setName("Armando");
        holder.setPassword("121");
        holder.setDni("22345678A");
        holder.setEmail("holder1@prueba.com");
        holder.setRole(ERole.ROLE_HOLDER);
        holder.setBankAccount(bankAccount);

        clientService.saveClient(holder);
    }
}
