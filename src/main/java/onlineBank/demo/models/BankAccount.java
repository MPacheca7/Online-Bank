package onlineBank.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "bank_account")
public class BankAccount extends User{
    @NotEmpty
    @Pattern(regexp = "^[A-Z]{2}[0-9]{2}[A-Z0-9]{10,30}$", message = "IBAN invalid")
    private String IBAN;

    public BankAccount(String name, String dni, String email, Role role, String IBAN) {
        super(name, dni, email, role);
        this.IBAN = IBAN;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }
}
