package onlineBank.demo.controllers;
import onlineBank.demo.DTO.ClientDTO;
import onlineBank.demo.models.Client;
import onlineBank.demo.models.Employee;
import onlineBank.demo.services.ClientService;
import onlineBank.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/admin")
    public ResponseEntity<String> adminRoute() {
        return ResponseEntity.ok("Access correct");
    }

    @GetMapping("/private/admin")
    public ResponseEntity<String> cosasImportantes() {
        return ResponseEntity.ok("Private access correct");
    }

    @PostMapping("/register/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee saved = employeeService.newEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/admin/change-holder/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Client>updatedClient(@PathVariable Long id, @RequestBody Client updatedClient){
        Client savedClient = employeeService.updateClient(id, updatedClient);
        return ResponseEntity.ok(savedClient);
    }

    @PatchMapping("/admin/change-Info-holder/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Client> changeInfo(@PathVariable Long id, @RequestBody ClientDTO clientDTO){
        Client newInfoClient = employeeService.changeInfo(id, clientDTO);
        return ResponseEntity.ok(newInfoClient);
    }
}
