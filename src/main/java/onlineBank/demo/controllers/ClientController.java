package onlineBank.demo.controllers;
import onlineBank.demo.models.Client;
import onlineBank.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank/holder")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/public/users")
    public ResponseEntity<String> publicUsers() {
        return ResponseEntity.ok("Bienvenido al tu banco de confianza");
    }

    @PostMapping("/register/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Client> register(@RequestBody Client client) {
      Client savedClient = clientService.saveClient(client);
       return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
   }

}
