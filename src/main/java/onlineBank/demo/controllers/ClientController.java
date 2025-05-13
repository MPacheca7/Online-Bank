package onlineBank.demo.controllers;

import onlineBank.demo.DTO.ClientDTO;
import onlineBank.demo.models.Client;
import onlineBank.demo.repository.ClientRepository;
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

    @PostMapping("/register/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Client> register(@RequestBody Client client) {
      Client savedClient = clientService.saveClient(client);
       return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
   }

}
