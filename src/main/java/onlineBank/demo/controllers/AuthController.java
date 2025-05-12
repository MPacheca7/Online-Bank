package onlineBank.demo.controllers;

import onlineBank.demo.models.Client;
import onlineBank.demo.services.ClientService;
import onlineBank.demo.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
/*
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Client client) {
        Optional<Client> optionalClient = clientService.getByClientName(client.getName());

        if (optionalClient.isPresent()) {
            Client foundClient = optionalClient.get();

            if (clientService.passwordIsValid(foundClient, client.getPassword())) {

                String token = jwtService.generateToken(foundClient.getName(), foundClient.getRole().toString());
                return ResponseEntity.ok(token);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login incorrecto");
            }

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }
}*/
