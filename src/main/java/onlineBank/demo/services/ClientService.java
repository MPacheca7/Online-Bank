package onlineBank.demo.services;


import onlineBank.demo.models.Client;
import onlineBank.demo.repository.ClientRepository;
import onlineBank.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Client saveClient(Client client){
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        return clientRepository.save(client);
    }

    public boolean passwordIsValid(Client client, String password) {
        return passwordEncoder.matches(password, client.getPassword());
    }


}
