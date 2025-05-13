package onlineBank.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Pattern(regexp = "^[A-Z]{2}[0-9]{2}[A-Z0-9]{10,30}$", message = "IBAN invalid")
    @Column(unique = true)
    private String IBAN;

    private String accountNumber;

    @OneToOne(mappedBy="bankAccount")
    @JsonIgnore
    private Client client;
}
