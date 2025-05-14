package onlineBank.demo.services;

import onlineBank.demo.models.BankAccount;
import onlineBank.demo.models.Client;
import onlineBank.demo.models.ERole;
import onlineBank.demo.repository.BankAccountRepository;
import onlineBank.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Random;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    BankAccountRepository bankAccountRepository;

    public Client saveClient(Client client){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setIBAN(generateAccountNumber());

        if (bankAccount.getIBAN() == null) {
            bankAccount.setIBAN(generateAccountNumber());
        }
        bankAccountRepository.save(bankAccount);

        Client holder = new Client();

        holder.setName(client.getName());
        holder.setDni(client.getDni());
        holder.setEmail(client.getEmail());
        holder.setPassword(passwordEncoder.encode(client.getPassword()));
        holder.setRole(ERole.ROLE_HOLDER);
        holder.setBankAccount(bankAccount);

        return clientRepository.save(holder);
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


    public boolean passwordIsValid(Client client, String password) {
        return passwordEncoder.matches(password, client.getPassword());
    }

    public Optional<Client> getByClientName(String name){
        return clientRepository.findByName(name);
    }
}
