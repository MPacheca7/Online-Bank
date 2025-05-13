package onlineBank.demo.services;

import onlineBank.demo.models.BankAccount;
import onlineBank.demo.models.Client;
import onlineBank.demo.models.ERole;
import onlineBank.demo.repository.BankAccountRepository;
import onlineBank.demo.repository.ClientRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ClientServiceTest {

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Test
    @DisplayName("New client asign IBAN")
    public void generateClient(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setIBAN("DE89370400440532013000");
        bankAccountRepository.save(bankAccount);

        Client holder = new Client();

        holder.setName("Maria");
        holder.setPassword("121");
        holder.setDni("21111111A");
        holder.setEmail("holder1@prueba.com");
        holder.setRole(ERole.ROLE_HOLDER);
        holder.setBankAccount(bankAccount);

        clientService.saveClient(holder);
        assertTrue(holder.getPassword().startsWith("$2a$"));
    }

    @Test
    @DisplayName("New client auto IBAN")
    public void saveClient(){
        Client holder = new Client();
        BankAccount bankAccount = new BankAccount();

        if (bankAccount.getIBAN() == null) {
            bankAccount.setIBAN(generateAccountNumber());
        }

        bankAccountRepository.save(bankAccount);

        holder.setName("Sara");
        holder.setPassword("121");
        holder.setDni("72440678Z");
        holder.setEmail("holder1@prueba.com");
        holder.setRole(ERole.ROLE_HOLDER);
        holder.setBankAccount(bankAccount);

        clientService.saveClient(holder);
        assertTrue(holder.getPassword().startsWith("$2a$"));
    }

    private String generateAccountNumber() {
        String countryCode = "ES";
        String controlDigits = "76";
        StringBuilder bban = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            bban.append(random.nextInt(10));
        }
        return countryCode + controlDigits + bban.toString();
    }
}
