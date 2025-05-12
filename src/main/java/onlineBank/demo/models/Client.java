package onlineBank.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Client extends User {

    @OneToOne
    @JoinColumn(name= "bank_account_id")
    private BankAccount bankAccount;

    @NotEmpty
    private String password;

    public Client(String name, String dni, String email, ERole role, BankAccount bankAccount, String password) {
        super(name, dni, email, role);
        this.bankAccount = bankAccount;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "bankAccount=" + bankAccount +
                ", password='" + password + '\'' +
                '}';
    }
}
