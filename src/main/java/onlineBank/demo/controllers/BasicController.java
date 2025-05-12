package onlineBank.demo.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BasicController {

    @GetMapping("/private/admin")
    public ResponseEntity<String> cosasImportantes() {
        return ResponseEntity.ok("Private access correct");
    }

    @GetMapping("/public/users")
    public ResponseEntity<String> publicUsers() {
        return ResponseEntity.ok("Bienvenido: ");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> adminRoute() {
        return ResponseEntity.ok("Access correct");
    }
}
