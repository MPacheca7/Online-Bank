package onlineBank.demo.services;
import onlineBank.demo.DTO.ClientDTO;
import onlineBank.demo.models.Client;
import onlineBank.demo.models.ERole;
import onlineBank.demo.models.Employee;
import onlineBank.demo.repository.ClientRepository;
import onlineBank.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Employee saveEmployee(Employee employee){
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }

    public Employee newEmployee(Employee employee){
        Employee employee1 = new Employee();

        employee1.setName(employee.getName());
        employee1.setDni(employee.getDni());
        employee1.setEmail(employee.getEmail());
        employee1.setPassword(passwordEncoder.encode(employee.getPassword()));
        employee1.setEmployeeNumber("N" + generateEmployeeNumber());
        employee1.setRole(ERole.ROLE_ADMIN);

        return employeeRepository.save(employee1);
    }

    private String generateEmployeeNumber() {
        int randomNumber = ThreadLocalRandom.current().nextInt(9000) + 1000;
        return String.valueOf(randomNumber);
    }

    public Client updateClient(Long id, Client updatedClient){
        Client existingHolder = clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        existingHolder.setName(updatedClient.getName());
        existingHolder.setDni(updatedClient.getDni());
        existingHolder.setEmail(updatedClient.getEmail());

        return clientRepository.save(existingHolder);
    }

    public Client changeInfo(Long id, ClientDTO clientDTO){
        Client existingHolder = clientRepository.findById(id).orElse(null);

        if(existingHolder == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (clientDTO.getName() != null){
            existingHolder.setName(clientDTO.getName());
            clientRepository.save(existingHolder);
        }

        if(clientDTO.getEmail() != null){
            existingHolder.setEmail(clientDTO.getEmail());
            clientRepository.save(existingHolder);
        }

        return clientRepository.save(existingHolder);
    }

    public void deleteClientById(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Holder not found");
        }
        clientRepository.deleteById(id);
    }

}
