package onlineBank.demo.services;

import onlineBank.demo.models.BankAccount;
import onlineBank.demo.repository.BankAccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BankAccountRepositoryTest {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Test
    @DisplayName("Nuevo IBAN")
    public void generateISBN(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setIBAN("ES7620770024003102575766");
        bankAccountRepository.save(bankAccount);
    }
}
