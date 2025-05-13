package onlineBank.demo.controllers;
import onlineBank.demo.models.Client;
import onlineBank.demo.services.ClientService;
import onlineBank.demo.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/bank")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    JwtService jwtService;

    @GetMapping("/public/users")
    public ResponseEntity<String> publicUsers() {
        return ResponseEntity.ok("Bienvenido al tu banco de confianza");
    }

    @PostMapping("public/register/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Client> register(@RequestBody Client client) {
      Client savedClient = clientService.saveClient(client);
       return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
   }

   @PostMapping("/login")
    public ResponseEntity<String> logim(@RequestBody Client client) {
       Client existingClient = clientService.getByClientName(client.getName())
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if(clientService.passwordIsValid(existingClient, client.getPassword())){
            String token = jwtService.generateToken(existingClient.getName(), existingClient.getRole(), existingClient.getEmail(), existingClient.getDni(), existingClient.getBankAccount());
            return ResponseEntity.ok(token);
        } else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login incorrecto");
        }
   }

}
